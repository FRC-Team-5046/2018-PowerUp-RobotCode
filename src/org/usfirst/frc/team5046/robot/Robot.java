/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5046.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.Compressor;

import org.usfirst.frc.team5046.robot.RobotMap.Target;
import org.usfirst.frc.team5046.robot.autongroups.CenterLeftSwitch;
import org.usfirst.frc.team5046.robot.autongroups.DoSomething;
import org.usfirst.frc.team5046.robot.autongroups.DriveStraightBackwards;
import org.usfirst.frc.team5046.robot.autongroups.Turn90;
import org.usfirst.frc.team5046.robot.autongroups.Turn90Gyro;
import org.usfirst.frc.team5046.robot.commands.AutoTargetSelector;
import org.usfirst.frc.team5046.robot.subsystems.Conveyor;
import org.usfirst.frc.team5046.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5046.robot.subsystems.Intake;
import org.usfirst.frc.team5046.robot.subsystems.Lift;
import org.usfirst.frc.team5046.robot.subsystems.Shooter;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	
	
	//setup subsystems
	public static DriveTrain driveTrain = new DriveTrain();
	public static Lift lift = new Lift();
	public static Conveyor conveyor = new Conveyor();
	public static Intake intake = new Intake();
	public static Shooter shooter = new Shooter();
	
	//setup default systems
	public static OI oi;
	public static Compressor c;
	public static UsbCamera cameraOne;
	public static PowerDistributionPanel pdp;

	//setup options for choosing auto from the dashboard
	Command autonMode;
	SendableChooser<Command> startingPositionChooser = new SendableChooser<Command>();
	SendableChooser<Command> allianceChooser = new SendableChooser<Command>();
	SendableChooser<Command> autonChooser = new SendableChooser<Command>();
	SendableChooser<Command> autonTarget = new SendableChooser<Command>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() 
	{
		//start systems
		oi = new OI(); 
		c = new Compressor(RobotMap.pcm);
		pdp = new PowerDistributionPanel(RobotMap.pdp);

		//set motors on subsystems to proper direction so that postive is always forward
		Robot.intake.setInverted();
		Robot.conveyor.setInverted();
		Robot.shooter.setInverted();

		//initialize the dashboard with values
		SmartInit();
				
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		c.start(); //start compressor
		Scheduler.getInstance().run(); //runs scheduler loop

	}


	public void disabledPeriodic() {
		Scheduler.getInstance().run();//runs scheduler loop
	}

	public void autonomousInit() {
		Robot.driveTrain.zeroEncoders(); //zeros encoders at the start of auton
		Robot.driveTrain.shiftLow(); //shifts into lowgear 

		
		//reads game data from field
		String gameData; 
		gameData = DriverStation.getInstance().getGameSpecificMessage();
//		char gameDataOurSwitchSide;
//		char gameDataOurScaleSide;
//		char gameDataThereSwitchSide;
//		gameDataOurSwitchSide = gameData.charAt(0);
//		gameDataOurScaleSide = gameData.charAt(1);
//		gameDataThereSwitchSide = gameData.charAt(2);
		
		if (gameData.charAt(0) == 'L')
		{
			System.out.println("left auton");
			// Put left auto code here
		}
		else
		{
			System.out.println("right auton");
			// Put right auto code here
		}
		
		SmartDashboard.putString("Robot Autonomous Data", gameData);  //puts on dashboard to make sure that we are recieving it properly
		
		switch (RobotMap.autonTarget) {
			case SWITCH: {
				System.out.println("SWITCH");
			}
			case SCALE: {
				System.out.println("SCALE");
			}
		}

		
		// schedule the autonomous command
		autonMode = (Command) autonChooser.getSelected();
		if (autonMode != null) 
		{
			autonMode.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */

	public void autonomousPeriodic() {
		
		//these update the various subsection values to the dashboard
		Robot.driveTrain.updateEncoders();
		Robot.driveTrain.updateHeading();
		Robot.intake.updateIntakeRunning();
		Robot.conveyor.updateConveyerRunning();
		Robot.shooter.updateShooterRunning();
		Robot.lift.updateLift();


		Scheduler.getInstance().run(); //runs scheduler loop
	}

	
	public void teleopInit() {
		
		
		Robot.driveTrain.zeroEncoders(); //zero's encoders as we start telop
		Robot.driveTrain.shiftLow(); //shifts the drive train into low
		Robot.intake.armsOpen(); //opens the arms if they were not already opened in auton mode
		
		
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonMode != null) 
		{
			autonMode.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */

	public void teleopPeriodic()
	{
		//these update the various subsection values to the dashboard
		Robot.driveTrain.updateEncoders();
		Robot.driveTrain.updateHeading();
		Robot.intake.updateIntakeRunning();
		Robot.conveyor.updateConveyerRunning();
		Robot.shooter.updateShooterRunning();
		Robot.lift.updateLift();

		


		Scheduler.getInstance().run();  //runs scheduler loop
	}

	/**
	 * This function is called periodically during test mode.
	 */
	
	public void testPeriodic() {
	}

	public void SmartInit() {
		
		//These are the various autonmodes that can be choosen from on the smartdashboard, each runs a auton command group
		autonChooser.addObject("DriveStraightForward", new DriveStraightBackwards());
		autonChooser.addObject("Turn 90", new Turn90());
		autonChooser.addObject("Turn 90 Gyro", new Turn90Gyro());
		autonChooser.addObject("DoSomething", new DoSomething());
		autonChooser.addObject("CenterLeftSwitch", new CenterLeftSwitch());

		
		//gives you the ability to choose which position on the field that you start in
		startingPositionChooser.addObject("Left", null);
		startingPositionChooser.addDefault("Middle", null);
		startingPositionChooser.addObject("Right", null);
		
		//lets you choose what alliance you are on(not really needed this year as the field is identical on both sides)
		allianceChooser.addDefault("Red", null);
		allianceChooser.addObject("Blue", null);
		
		//What are we trying to score in during auton
		autonTarget.addObject("Switch", new AutoTargetSelector(Target.SWITCH));
		autonTarget.addObject("Scale",  new AutoTargetSelector(Target.SCALE));
		
		//puts these values on the dashboard to make them useable
		SmartDashboard.putData("Auton mode", autonChooser);
		SmartDashboard.putData("Auton Starting Position", startingPositionChooser);
		SmartDashboard.putData("Alliance", allianceChooser);
		SmartDashboard.putData("Auton Target Goal", autonTarget);
		
		

		//System.out.println("Settings"); 
		
		//puts the drivetrain PID values on the dashboard
		SmartDashboard.putNumber("driveP", RobotMap.driveP);
		SmartDashboard.putNumber("driveI", RobotMap.driveI);
		SmartDashboard.putNumber("driveD", RobotMap.driveD);
		SmartDashboard.putNumber("driveF", RobotMap.driveF);
		
		//puts the drivetrain turning(gyro) PID values on the dashboard
		SmartDashboard.putNumber("turnP", RobotMap.turnP);
		SmartDashboard.putNumber("turnI", RobotMap.turnI);
		SmartDashboard.putNumber("turnD", RobotMap.turnD);
		SmartDashboard.putNumber("turnF", RobotMap.turnF);
		
		//puts PDP data on the dashboard so you can see if motors are running or not
		SmartDashboard.putData("PDP", pdp);
		
		//setup encoders and gyro with a base value of 0 on dashboard
		SmartDashboard.putNumber("Drive Right Encoder", 0);
		SmartDashboard.putNumber("Drive Left Encoder", 0);
		SmartDashboard.putNumber("Gyro Heading", 0);
		
		//setup initial values for data from the various subsystems
		SmartDashboard.putString("Drive Train Gear" , "BEGIN");
		SmartDashboard.putString("Intake Arms" , "BEGIN");
		SmartDashboard.putNumber("Left Intake Motor", 0);
		SmartDashboard.putNumber("Right Intake Motor", 0);
		SmartDashboard.putNumber("Left Conveyer Motor", 0);
		SmartDashboard.putNumber("Right Conveyer Motor", 0);	

		
		SmartDashboard.putData(Scheduler.getInstance());  //shows what is scheduled to run

	}
}
