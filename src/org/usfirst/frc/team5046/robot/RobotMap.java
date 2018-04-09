/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5046.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;


import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static final int DRIVER = 0;  //driver joystick USB0
	public static final int OPERATOR = 1; //operator joysick USB1
	

	public static final int pcm = 0;  //setup pneumatics
	public static final int pdp = 0; //setup pdp
	
	
	//setup PIDF values for DriveTrain
	public static double driveP = .13;
	public static double driveI = 0.0;
	public static double driveD = 0.0;
	public static double driveF = 0.0;

	//setup PIDF values for Drivetrain when turning with Gyro
	public static double turnP = .3;
	public static double turnI = 0.0;
	public static double turnD = 0.0;
	public static double turnF = 0.0;
	
	
	public static final double wheelCir = 18.84; //Set wheel circumfrence for 6in wheels
	public static final double robotCir = 100;  //Set circumfrence of the robot

	
	//sets the sensor phase of the drivetrain motors
	public static boolean leftDriveSensorPhase = false;
	public static boolean rightDriveSensorPhase = false;
	
	//sets the direction of the drivetrain motors
	public static boolean leftDriveInverted = true;
	public static boolean rightDriveInverted = false;

	//defines the drivetrain master talons (these have the encoders hooked to them)
	public static TalonSRX leftDriveMaster = new TalonSRX(9);
	public static TalonSRX rightDriveMaster = new TalonSRX(5);
	
	
	//these are the follower talons or victors in the drivetrain depending on the robot we are using
	public static VictorSPX leftDriveSlave1 = new VictorSPX(10);
	public static VictorSPX leftDriveSlave2 = new VictorSPX(11);
	public static VictorSPX rightDriveSlave1 = new VictorSPX(3);
	public static VictorSPX rightDriveSlave2 = new VictorSPX(4);
//	public static TalonSRX leftDriveSlave1 = new TalonSRX(10);
//	public static TalonSRX leftDriveSlave2 = new TalonSRX(11);
//	public static TalonSRX rightDriveSlave1 = new TalonSRX(3);
//	public static TalonSRX rightDriveSlave2 = new TalonSRX(4);
	
	
	//setup solenoids for various robot functions
	public static DoubleSolenoid solenoidIntakeArms = new DoubleSolenoid(0, 7);
	public static DoubleSolenoid solenoidUpperLift = new DoubleSolenoid(2, 5);
	public static DoubleSolenoid solenoidDriveShifters = new DoubleSolenoid(1, 6);

	//setup our intake subsystem speed controlers
	public static TalonSRX leftIntake = new TalonSRX(13); 		/* device IDs here (1 of 2) */
	public static TalonSRX rightIntake = new TalonSRX(1);

	public static boolean leftIntakeInverted = true;
	public static boolean rightIntakeInverted = false;
	
	
	//setup our conveyer susbsystem speed controlers
	public static TalonSRX leftConveyer = new TalonSRX(12);
	public static TalonSRX rightConveyer = new TalonSRX(2);

	public static boolean leftConveyerInverted = true;
	public static boolean rightConveyerInverted = false;

	
	
	//setup the shooter motors speed controllers
	
	public static TalonSRX leftShooter = new TalonSRX(7); 		/* device IDs here (1 of 2) */
	public static TalonSRX rightShooter = new TalonSRX(6);
	//public static Talon rightShooter = new Talon(1);
	//public static Talon leftShooter = new Talon(0);

	public static boolean leftShooterInverted = false;
	public static boolean rightShooterInverted = true;

	
	//setup our lift motor 
	public static TalonSRX liftMotor = new TalonSRX(8);
	public static boolean liftMotorInverted = true;
	
	//led light driver
	public static Spark ledController = new Spark(0);
	
	public static double ledValue = 0.99;
	
	public static int matchEndWarning = 30;
	public static int matchEndClose = 10;
	
	
}
