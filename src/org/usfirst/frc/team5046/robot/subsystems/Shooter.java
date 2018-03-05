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
		
	
			RobotMap.leftShooter.set(left);
			RobotMap.rightShooter.set(right);
//			RobotMap.leftShooter.set(ControlMode.PercentOutput, left);
//			RobotMap.rightShooter.set(ControlMode.PercentOutput, right);
	
		}
			
	
	public void updateShooterRunning() {
//		SmartDashboard.putNumber("Left Shooter Motor", RobotMap.leftShooter.getMotorOutputPercent());/
//		SmartDashboard.putNumber("Right Shooter Motor", RobotMap.rightShooter.getMotorOutputPercent());
		
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

