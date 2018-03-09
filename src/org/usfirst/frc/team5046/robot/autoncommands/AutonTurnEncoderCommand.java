package org.usfirst.frc.team5046.robot.autoncommands;

import org.usfirst.frc.team5046.robot.Robot;
import org.usfirst.frc.team5046.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutonTurnEncoderCommand extends Command
{
	private double targetAngle;

	public AutonTurnEncoderCommand(double targetAngle, double seconds)
	{
		requires(Robot.driveTrain);
		this.targetAngle = targetAngle;
		setTimeout(seconds);
	}

	protected void initialize()
	{
		Robot.driveTrain.zeroEncoders();

		Robot.driveTrain.setPID(SmartDashboard.getNumber("turnP", RobotMap.turnP),
				SmartDashboard.getNumber("driveI", RobotMap.driveI), 
				SmartDashboard.getNumber("driveD", RobotMap.driveD),
				SmartDashboard.getNumber("driveF", RobotMap.driveF));

		Robot.driveTrain.setupOnTarget(500, 20);

		Robot.driveTrain.setSetpointTurn(targetAngle);
	}

	protected void execute()
	{
	}

	protected boolean isFinished()
	{
		return Robot.driveTrain.onTarget() || isTimedOut();
	}

	protected void end()
	{
		Robot.driveTrain.driveArcade(0, 0);
		Robot.driveTrain.zeroEncoders();
	}

	protected void interrupted()
	{
		end();
	}
}
