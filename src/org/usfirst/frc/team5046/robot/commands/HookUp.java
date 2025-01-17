package org.usfirst.frc.team5046.robot.commands;

import org.usfirst.frc.team5046.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class HookUp extends Command {

    public HookUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.climber);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.climber.hookPower(1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.climber.hookPower(1);

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.climber.hookPower(0);

    }
    
}
