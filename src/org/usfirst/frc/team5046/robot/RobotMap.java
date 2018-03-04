/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5046.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static final int DRIVER = 0;
	public static final int OPERATOR = 1;
	
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	public static final int pcm = 0;
	public static final int pdp = 0;
	
	
	public static double driveP = .13;
	public static double driveI = 0.0;
	public static double driveD = 0.0;
	public static double driveF = 0.0;

	public static double turnP = .13;
	public static double turnI = 0.0;
	public static double turnD = 0.0;
	public static double turnF = 0.0;
	
	public static final double wheelCir = 18.84;
	public static final double robotCir = 103.62;


	public static boolean leftDriveSensorPhase = false;
	public static boolean rightDriveSensorPhase = false;
	public static boolean leftDriveInverted = true;
	public static boolean rightDriveInverted = false;

	
	public static TalonSRX leftDriveMaster = new TalonSRX(9);
	public static TalonSRX rightDriveMaster = new TalonSRX(5);
	
//	public static VictorSPX leftDriveSlave1 = new VictorSPX(10);
//	public static VictorSPX leftDriveSlave2 = new VictorSPX(11);
//	public static VictorSPX rightDriveSlave1 = new VictorSPX(3);
//	public static VictorSPX rightDriveSlave2 = new VictorSPX(4);
	public static TalonSRX leftDriveSlave1 = new WPI_TalonSRX(10);
	public static TalonSRX leftDriveSlave2 = new WPI_TalonSRX(11);
	public static TalonSRX rightDriveSlave1 = new WPI_TalonSRX(3);
	public static TalonSRX rightDriveSlave2 = new WPI_TalonSRX(4);
	
	
	public static DoubleSolenoid solenoidIntakeArms = new DoubleSolenoid(0, 7);
	public static DoubleSolenoid solenoidUpperLift = new DoubleSolenoid(2, 5);
	public static DoubleSolenoid solenoidDriveShifters = new DoubleSolenoid(1, 6);

	
}
