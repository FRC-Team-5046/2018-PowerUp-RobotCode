package org.usfirst.frc.team5046.robot.subsystems;

import org.usfirst.frc.team5046.robot.RobotMap;
import org.usfirst.frc.team5046.robot.commands.Climb;


import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public void hookPower(double power) {
		RobotMap.raiseHook.set(power);
	}
	
		
	public void climbPower(double power) {
		RobotMap.winch.set(power);
	}
	
 	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    }
}

