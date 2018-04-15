package org.usfirst.frc.team5046.robot.autoncommands;

import org.usfirst.frc.team5046.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutonRaiseLift extends Command {

    public AutonRaiseLift(double seconds) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.lift);
    	
    	setTimeout(seconds);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.lift.raiseUpperStage();
    	Robot.lift.lowerstage(1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return isTimedOut();    
    	}

    // Called once after isFinished returns true
    protected void end() {
    	Robot.lift.lowerstage(0);
        
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.lift.lowerstage(0);
    }
}
