package org.usfirst.frc.team5046.robot.commands;

import org.usfirst.frc.team5046.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class OverrideLimit extends Command {

    public OverrideLimit() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.lift.overrideLimits();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.lift.overrideLimits();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.lift.overrideLimits();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.lift.overrideLimits();
    }
}
