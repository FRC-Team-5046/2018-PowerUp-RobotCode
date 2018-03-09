package org.usfirst.frc.team5046.robot.commands;

import org.usfirst.frc.team5046.robot.RobotMap;
import org.usfirst.frc.team5046.robot.RobotMap.AutoStart;


import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class AutoStartPosition extends InstantCommand {
	AutoStart myPosition;

    public AutoStartPosition(AutoStart position) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	myPosition = position;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	RobotMap.autonStart = myPosition;
    }

  
}
