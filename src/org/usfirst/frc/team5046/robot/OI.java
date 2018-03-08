/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5046.robot;

import org.usfirst.frc.team5046.robot.RobotMap;
import org.usfirst.frc.team5046.robot.commandgroups.PickupCube;
import org.usfirst.frc.team5046.robot.commandgroups.SpitCubeOut;
import org.usfirst.frc.team5046.robot.commands.DriveShiftToggle;
import org.usfirst.frc.team5046.robot.commands.IntakeArmsToggle;
import org.usfirst.frc.team5046.robot.commands.LowerLift;
import org.usfirst.frc.team5046.robot.commands.RaiseLift;
import org.usfirst.frc.team5046.robot.commands.ShooterHighSpeed;
import org.usfirst.frc.team5046.robot.utilities.LogitechF310;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	
	public LogitechF310 one = new LogitechF310(RobotMap.DRIVER);
	public LogitechF310 two = new LogitechF310(RobotMap.OPERATOR);
	
	public OI()
	{
		one.buttonL1.toggleWhenPressed(new DriveShiftToggle());
		one.buttonR1.whileHeld(new IntakeArmsToggle());
		one.buttonTL.whileHeld(new ShooterHighSpeed());
		
		two.buttonA.whileHeld(new PickupCube());
		two.buttonB.whileHeld(new SpitCubeOut());
		
		two.buttonTL.whileHeld(new RaiseLift(5));
		two.buttonTR.whileHeld(new LowerLift(5));
		//two.buttonA.whileHeld(new ShooterHighSpeed());
		
		
		
		
		

	}
	
}
