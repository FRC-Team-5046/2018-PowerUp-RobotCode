package org.usfirst.frc.team5046.robot.subsystems;

import org.usfirst.frc.team5046.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Shooter extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public void power(double left, double right) {
		
	
//			RobotMap.leftShooter.set(left);
//			RobotMap.rightShooter.set(right);
		if (RobotMap.liftMotor.getSensorCollection().isRevLimitSwitchClosed() == false) 
			{
			if (left<0 || right<0) 
				{
				RobotMap.leftShooter.set(ControlMode.PercentOutput, 0);
				RobotMap.rightShooter.set(ControlMode.PercentOutput, 0);
				}
			else
				{
					RobotMap.leftShooter.set(ControlMode.PercentOutput, left);
					RobotMap.rightShooter.set(ControlMode.PercentOutput, right);
				}
			}
		else 
			{
				RobotMap.leftShooter.set(ControlMode.PercentOutput, left);
				RobotMap.rightShooter.set(ControlMode.PercentOutput, right);
			}

	
		}
			
	
	public void updateShooterRunning() {
		SmartDashboard.putNumber("Left Shooter Motor", RobotMap.leftShooter.getMotorOutputPercent());
		SmartDashboard.putNumber("Right Shooter Motor", RobotMap.rightShooter.getMotorOutputPercent());
		
	}

	public void setInverted() {
		RobotMap.leftShooter.setInverted(RobotMap.leftShooterInverted);
		RobotMap.rightShooter.setInverted(RobotMap.rightShooterInverted);

	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

