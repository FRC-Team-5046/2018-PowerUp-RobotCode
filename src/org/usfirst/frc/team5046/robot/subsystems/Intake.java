package org.usfirst.frc.team5046.robot.subsystems;

import org.usfirst.frc.team5046.robot.RobotMap;
import org.usfirst.frc.team5046.robot.commands.IntakeCubeManual;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Intake extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public void suckCubeIn() {
		RobotMap.leftIntake.set(ControlMode.PercentOutput, 1);
		RobotMap.rightIntake.set(ControlMode.PercentOutput, 1);
		
	}
	
	public void spitCubeOut() {
		RobotMap.leftIntake.set(ControlMode.PercentOutput, -1);
		RobotMap.rightIntake.set(ControlMode.PercentOutput, -1);
		
	}
	
	public void manual(double left, double right) {
		RobotMap.leftIntake.set(ControlMode.PercentOutput, left);
		RobotMap.rightIntake.set(ControlMode.PercentOutput, right);
		
	}
	
	public void armsOpen() {
		RobotMap.solenoidIntakeArms.set(DoubleSolenoid.Value.kForward);
		SmartDashboard.putString("Intake Arms" , "OPEN");
	}
	
	public void armsClosed() {
		RobotMap.solenoidIntakeArms.set(DoubleSolenoid.Value.kReverse);
		SmartDashboard.putString("Intake Arms" , "CLOSED");
	}	
	
	public void updateIntakeRunning() {
		SmartDashboard.putNumber("Left Intake Motor", RobotMap.leftIntake.getMotorOutputPercent());
		SmartDashboard.putNumber("Right Intake Motor", RobotMap.rightIntake.getMotorOutputPercent());
	}
	
	public void setInverted() {
		RobotMap.leftIntake.setInverted(RobotMap.leftIntakeInverted);
		RobotMap.rightIntake.setInverted(RobotMap.rightIntakeInverted);

	}
		
   	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new IntakeCubeManual());
    }
}

