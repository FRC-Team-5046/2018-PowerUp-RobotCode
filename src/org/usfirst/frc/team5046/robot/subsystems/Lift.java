package org.usfirst.frc.team5046.robot.subsystems;

import org.usfirst.frc.team5046.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Lift extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void raiseUpperStage() {
    	RobotMap.solenoidUpperLift.set(DoubleSolenoid.Value.kForward);
    	SmartDashboard.putString("Upper Stage" , "RAISED");

    }
    
    public void lowerUpperStage() {
    	RobotMap.solenoidUpperLift.set(DoubleSolenoid.Value.kReverse);
		SmartDashboard.putString("Upper Stage" , "LOWERED");


    }   
    
    public void lowerstage(double power) {
    	RobotMap.liftMotor.set(ControlMode.PercentOutput,power);
    }
    
    public void setInverted() {
		RobotMap.liftMotor.setInverted(RobotMap.liftMotorInverted);
    }
    
    public void updateLift() {
		SmartDashboard.putNumber("Lift Motor", RobotMap.liftMotor.getMotorOutputPercent());
	   	SmartDashboard.putBoolean("Upper Limit Switch", RobotMap.liftMotor.getSensorCollection().isFwdLimitSwitchClosed());
    	SmartDashboard.putBoolean("Lower Limit Switch", RobotMap.liftMotor.getSensorCollection().isRevLimitSwitchClosed());
    	
 
	}
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());

    }
}

