package org.usfirst.frc.team5046.robot.commands;

import org.usfirst.frc.team5046.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeArmsToggle extends Command {

    public IntakeArmsToggle() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.intake.armsClosed();
        //System.out.println("Lift Up init");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	}

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//System.out.println("Lift Up end");
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	//System.out.println("Lift Interupted");
    	Robot.intake.armsOpen();
        
    }
}
