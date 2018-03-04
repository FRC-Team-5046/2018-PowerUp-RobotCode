package org.usfirst.frc.team5046.robot.autoncommands;

import org.usfirst.frc.team5046.robot.Robot;
import org.usfirst.frc.team5046.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutonDriveCommand extends Command
{
	private double inches;

	public AutonDriveCommand(double inches, double seconds)
	{
		requires(Robot.driveTrain);

		this.inches = inches;

		setTimeout(seconds);
		
		Robot.driveTrain.zeroEncoders();

	}

	protected void initialize()
	{
		Robot.driveTrain.zeroEncoders();

		Robot.driveTrain.setPID(
				SmartDashboard.getNumber("driveP", RobotMap.driveP),
				SmartDashboard.getNumber("DriveI", RobotMap.driveI),
				SmartDashboard.getNumber("DriveD", RobotMap.driveD),
				SmartDashboard.getNumber("DriveF", RobotMap.driveF));

		Robot.driveTrain.setSetpointDrive(inches);

		Robot.driveTrain.setupOnTarget(300, 10);
	}

	protected void execute()
	{
		//System.out.print(RobotMap.LeftDriveMaster.getClosedLoopTarget(0));
		Robot.driveTrain.updateEncoders();
	}

	protected boolean isFinished()
	{
		return isTimedOut()||Robot.driveTrain.onTarget();
	}

	protected void end()
	{
		System.out.println("End Auto Drive");
		Robot.driveTrain.driveArcade(0, 0);
	}

	protected void interrupted()
	{
		end();
	}
}
