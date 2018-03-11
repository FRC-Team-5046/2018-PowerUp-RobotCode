package org.usfirst.frc.team5046.robot.autoncommands;

import org.usfirst.frc.team5046.robot.Robot;
import org.usfirst.frc.team5046.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutonDriveCommandHighGear extends Command
{
	private double inches;

	public AutonDriveCommandHighGear(double inches, double seconds,boolean speed)
	{
		requires(Robot.driveTrain);

		this.inches = inches;

		setTimeout(seconds);
		
		Robot.driveTrain.zeroEncoders();
		
		Robot.driveTrain.shiftHigh();
		

	}

	protected void initialize()
	{
		Robot.driveTrain.zeroEncoders();
		
		Robot.driveTrain.shiftLow();

		Robot.driveTrain.setPID(
				SmartDashboard.getNumber("driveP", RobotMap.driveP),
				SmartDashboard.getNumber("driveI", RobotMap.driveI),
				SmartDashboard.getNumber("driveD", RobotMap.driveD),
				SmartDashboard.getNumber("driveF", RobotMap.driveF));

		Robot.driveTrain.setSetpointDrive(inches);

		Robot.driveTrain.setupOnTarget(300, 10);
		
		Robot.driveTrain.shiftHigh();

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
