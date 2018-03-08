package org.usfirst.frc.team5046.robot.commands;

import org.usfirst.frc.team5046.robot.RobotMap;
import org.usfirst.frc.team5046.robot.RobotMap.Target;


import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class AutoTargetSelector extends InstantCommand {
Target myTarget;

    public AutoTargetSelector(Target target) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	myTarget = target;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	RobotMap.autonTarget = myTarget;
    }

  
}
