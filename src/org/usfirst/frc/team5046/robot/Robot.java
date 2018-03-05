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

import org.usfirst.frc.team5046.robot.autongroups.DoSomething;
import org.usfirst.frc.team5046.robot.autongroups.DriveStraightBackwards;
import org.usfirst.frc.team5046.robot.autongroups.Turn90;
import org.usfirst.frc.team5046.robot.autongroups.Turn90Gyro;
import org.usfirst.frc.team5046.robot.subsystems.Conveyor;
import org.usfirst.frc.team5046.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5046.robot.subsystems.Intake;
import org.usfirst.frc.team5046.robot.subsystems.Lift;
import org.usfirst.frc.team5046.robot.subsystems.Shooter;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.kauailabs.navx.frc.AHRS;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	
	public static DriveTrain driveTrain = new DriveTrain();
	public static Lift lift = new Lift();
	public static Conveyor conveyor = new Conveyor();
	public static Intake intake = new Intake();
	public static Shooter shooter = new Shooter();
	
	
	public static OI oi;
	public static Compressor c;
	public static UsbCamera cameraOne;

	//public static PowerDistributionPanel pdp;


	Command autonMode;
	SendableChooser<Command> positionChooser = new SendableChooser<Command>();
	SendableChooser<Command> allianceChooser = new SendableChooser<Command>();
	SendableChooser<Command> autonChooser = new SendableChooser<Command>();
	

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() 
	{
		oi = new OI();
		c = new Compressor(RobotMap.pcm);
		//pdp = new PowerDistributionPanel(RobotMap.pdp);

		Robot.intake.setInverted();
		Robot.conveyor.setInverted();
		Robot.shooter.setInverted();


		SmartInit();
				
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		c.start();
		Scheduler.getInstance().run();

	}


	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		Robot.driveTrain.zeroEncoders();
		Robot.driveTrain.shiftLow();

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
		
		SmartDashboard.putString("Robot Autonomous Data", gameData);
		
		// schedule the autonomous command (example)
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
		Robot.driveTrain.updateEncoders();
		Robot.driveTrain.updateHeading();
		Robot.intake.updateIntakeRunning();
		Robot.conveyor.updateConveyerRunning();
		Robot.shooter.updateShooterRunning();
		Robot.lift.updateLift();


		Scheduler.getInstance().run();
	}

	
	public void teleopInit() {
		
		
		Robot.driveTrain.zeroEncoders();
		Robot.driveTrain.shiftLow();
		Robot.intake.armsOpen();
		
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
		
		Robot.driveTrain.updateEncoders();
		Robot.driveTrain.updateHeading();
		Robot.intake.updateIntakeRunning();
		Robot.conveyor.updateConveyerRunning();
		Robot.shooter.updateShooterRunning();
		Robot.lift.updateLift();

		


		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	
	public void testPeriodic() {
	}

	public void SmartInit() {
		
		autonChooser.addObject("DriveStraightForward", new DriveStraightBackwards());
		autonChooser.addObject("Turn 90", new Turn90());
		autonChooser.addObject("Turn 90 Gyro", new Turn90Gyro());
		autonChooser.addObject("DoSomething", new DoSomething());
		
		positionChooser.addObject("Left", null);
		positionChooser.addDefault("Middle", null);
		positionChooser.addObject("Right", null);
		
		allianceChooser.addDefault("Red", null);
		allianceChooser.addObject("Blue", null);
		
		SmartDashboard.putData("Auton mode", autonChooser);
		SmartDashboard.putData("Auton Position", positionChooser);
		SmartDashboard.putData("Alliance", allianceChooser);
		
		

		System.out.println("Settings");
		
		SmartDashboard.putNumber("driveP", RobotMap.driveP);
		SmartDashboard.putNumber("driveI", RobotMap.driveI);
		SmartDashboard.putNumber("driveD", RobotMap.driveD);
		SmartDashboard.putNumber("driveF", RobotMap.driveF);

		SmartDashboard.putNumber("turnP", RobotMap.turnP);
		SmartDashboard.putNumber("turnI", RobotMap.turnI);
		SmartDashboard.putNumber("turnD", RobotMap.turnD);
		SmartDashboard.putNumber("turnF", RobotMap.turnF);
		
		//SmartDashboard.putData("PDP", pdp);
		
		SmartDashboard.putNumber("Drive Right Encoder", 0);
		SmartDashboard.putNumber("Drive Left Encoder", 0);
		SmartDashboard.putNumber("Gyro Heading", 0);
		
		SmartDashboard.putString("Drive Train Gear" , "BEGIN");
		SmartDashboard.putString("Intake Arms" , "BEGIN");
		SmartDashboard.putNumber("Left Intake Motor", 0);
		SmartDashboard.putNumber("Right Intake Motor", 0);
		SmartDashboard.putNumber("Left Conveyer Motor", 0);
		SmartDashboard.putNumber("Right Conveyer Motor", 0);	

		
		SmartDashboard.putData(Scheduler.getInstance());

	}
}
