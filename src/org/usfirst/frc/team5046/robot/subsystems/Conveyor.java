package org.usfirst.frc.team5046.robot.subsystems;

import org.usfirst.frc.team5046.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Conveyor extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void power(double left, double right) {
		RobotMap.leftConveyer.set(ControlMode.PercentOutput, left);
		RobotMap.rightConveyer.set(ControlMode.PercentOutput, right);
		
	}
	
	public void updateConveyerRunning() {
		SmartDashboard.putNumber("Left Conveyer Motor", RobotMap.leftConveyer.getMotorOutputPercent());
		SmartDashboard.putNumber("Right Conveyer Motor", RobotMap.rightConveyer.getMotorOutputPercent());
	}
	
	public void setInverted() {
		RobotMap.leftConveyer.setInverted(RobotMap.leftConveyerInverted);
		RobotMap.rightConveyer.setInverted(RobotMap.rightConveyerInverted);

	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

