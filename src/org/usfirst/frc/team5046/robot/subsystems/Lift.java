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
	//setup variables needed for error checking
//	private int maxLoopNumber = 0;  
//	private int onTargetCounter = 0;
//	private int allowedErrorRange = 0;
	
	
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
		SmartDashboard.putNumber("Lift Encoder", RobotMap.liftMotor.getSelectedSensorPosition(0));
		SmartDashboard.putNumber("Lift Enc VEL", RobotMap.liftMotor.getSelectedSensorVelocity(0));
    }
		
	public void overrideLimits() {
		RobotMap.liftMotor.overrideLimitSwitchesEnable(false);
		RobotMap.liftMotor.overrideSoftLimitsEnable(false);
		System.out.println("Limits Overridden");
    }
			   
    	
 
	
	
    
	
//	//This clears the sticky faults on the lift motor
//	public void clearStickyFaults(boolean shouldClearFaults) 
//	{
//		if (shouldClearFaults)
//		{
//			RobotMap.liftMotor.clearStickyFaults(0);
//   	
//
//		   	}
//	}
//	
//	//Enables Braking mode
//	public void setBrakeMode(boolean shouldBrakeMode)
//	{
//		if (shouldBrakeMode)
//		{
//			RobotMap.liftMotor.setNeutralMode(NeutralMode.Brake);
//		}
//		else
//		{
//			RobotMap.liftMotor.setNeutralMode(NeutralMode.Coast);
//		}
//	}
//	
//
//
//
//	//Setup the sensor phase of the encoders
//	public void setSensorPhase(boolean liftphase)
//	{
//		RobotMap.liftMotor.setSensorPhase(liftphase);
//	}
//
//	//Zero's the encoders
//	public void zeroEncoders() {
//		
//		RobotMap.liftMotor.setSelectedSensorPosition(0, 0, 0);
//
//		RobotMap.liftMotor.getSensorCollection().setQuadraturePosition(0, 0);
//		
//		
//	}
//	
//	//Sets the PID values on the talons
//	public void setPID(double P, double I, double D, double F) {
//
//		RobotMap.liftMotor.config_kF(0, F, 10);
//		RobotMap.liftMotor.config_kP(0, P, 10);
//		RobotMap.liftMotor.config_kI(0, I, 10);
//		RobotMap.liftMotor.config_kD(0, D, 10);
//
//	}
//	
//	//Sets the distance that you are trying to reach in inches
//	public void setSetpointDrive(double setpointinches)
//	{
//		System.out.println("Target "+inchToEncoder(setpointinches));
//		RobotMap.liftMotor.set(ControlMode.Position,
//				inchToEncoder(setpointinches));
//	}
//
//	
//	//This makes sure that your on target to hit your value
//	public void setupOnTarget(int ticks, int maxLoopNumber)
//	{
//		// zero the on target counter
//		onTargetCounter = 0;
//
//		RobotMap.liftMotor.configAllowableClosedloopError(0, ticks, 10);
//
//		// set tolerance in ticks
//		allowedErrorRange = ticks;
//		
//		this.maxLoopNumber=maxLoopNumber;
//
//	}
//	
//	//converts inches to encoder pulses (needs to be tuned to the pulses of your encoder
//	public double inchToEncoder(double inches)
//	{
//		System.out.println("inchtoencoder: "+(inches / RobotMap.liftPullyDiameter*3.14) * 4096);
//		return (inches / RobotMap.liftPullyDiameter*3.14) * 4096;
//	}
//	
//	
//	
//	//Makes sure you are within range of the values you set
//	public boolean onTarget()
//	{
//		if (Math.abs(RobotMap.liftMotor.getClosedLoopError(0))
//				<= allowedErrorRange)
//		{
//			onTargetCounter++;
//		}
//		else
//		{
//			onTargetCounter = 0;
//		}
//
//		if (maxLoopNumber <= onTargetCounter)
//		{
//			return true;
//		}
//
//		return false;
//	}



	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());

    }
}

