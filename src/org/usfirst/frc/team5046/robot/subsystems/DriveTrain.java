package org.usfirst.frc.team5046.robot.subsystems;

import org.usfirst.frc.team5046.robot.commands.DriveCommand;
import org.usfirst.frc.team5046.robot.RobotMap;
import org.usfirst.frc.team5046.robot.utilities.Drive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public final class DriveTrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	
	private Drive drive;

	private int maxLoopNumber = 0;
	private int onTargetCounter = 0;
	private int allowedErrorRange = 0;

	
	public DriveTrain() 
	{
		
    setFollower();
	
	RobotMap.leftDriveMaster.configNominalOutputForward(0, 10);
	RobotMap.leftDriveMaster.configNominalOutputReverse(0, 10);
	RobotMap.leftDriveMaster.configPeakOutputForward(1, 10);
	RobotMap.leftDriveMaster.configPeakOutputReverse(-1, 10);
	RobotMap.rightDriveMaster.configNominalOutputForward(0, 10);
	RobotMap.rightDriveMaster.configNominalOutputReverse(0, 10);
	RobotMap.rightDriveMaster.configPeakOutputForward(1, 10);
	RobotMap.rightDriveMaster.configPeakOutputReverse(-1, 10);


	RobotMap.leftDriveMaster.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,0);
   	RobotMap.rightDriveMaster.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,0,0);
	
   	clearStickyFaults(true);
	setBrakeMode(true);
	setInverted();
	setSensorPhase(false,false);

   
	drive=new Drive(RobotMap.rightDriveMaster,RobotMap.leftDriveMaster);

	}
	
	
	public void clearStickyFaults(boolean shouldClearFaults) 
	{
		if (shouldClearFaults)
		{
			RobotMap.leftDriveMaster.clearStickyFaults(0);
		   	RobotMap.leftDriveSlave1.clearStickyFaults(0);
		   	RobotMap.leftDriveSlave2.clearStickyFaults(0);
		   	
			RobotMap.rightDriveMaster.clearStickyFaults(0);		 
			RobotMap.rightDriveSlave1.clearStickyFaults(0);
		   	RobotMap.rightDriveSlave2.clearStickyFaults(0);
		   	

		   	}
	}
	
	public void setBrakeMode(boolean shouldBrakeMode)
	{
		if (shouldBrakeMode)
		{
			RobotMap.leftDriveMaster.setNeutralMode(NeutralMode.Brake);
		   	RobotMap.leftDriveSlave1.setNeutralMode(NeutralMode.Brake);
		   	RobotMap.leftDriveSlave2.setNeutralMode(NeutralMode.Brake);

		   	RobotMap.rightDriveMaster.setNeutralMode(NeutralMode.Brake);
		   	RobotMap.rightDriveSlave1.setNeutralMode(NeutralMode.Brake);
		   	RobotMap.rightDriveSlave2.setNeutralMode(NeutralMode.Brake);
				}
		else
		{
			RobotMap.leftDriveMaster.setNeutralMode(NeutralMode.Coast);
		   	RobotMap.leftDriveSlave1.setNeutralMode(NeutralMode.Coast);
		   	RobotMap.leftDriveSlave2.setNeutralMode(NeutralMode.Coast);
			
		   	RobotMap.rightDriveMaster.setNeutralMode(NeutralMode.Coast);
		   	RobotMap.rightDriveSlave1.setNeutralMode(NeutralMode.Coast);
		   	RobotMap.rightDriveSlave2.setNeutralMode(NeutralMode.Coast);
		}
	}
	
	private void setFollower()
	{
		RobotMap.leftDriveSlave1.follow(RobotMap.leftDriveMaster);
	   	RobotMap.leftDriveSlave2.follow(RobotMap.leftDriveMaster);
	   	
	   	RobotMap.rightDriveSlave1.follow(RobotMap.rightDriveMaster);
	   	RobotMap.rightDriveSlave2.follow(RobotMap.rightDriveMaster);
	}
	
	private void setInverted() {
		
		RobotMap.leftDriveMaster.setInverted(RobotMap.leftDriveInverted);
	 	RobotMap.leftDriveSlave1.setInverted(RobotMap.leftDriveInverted);
	   	RobotMap.leftDriveSlave2.setInverted(RobotMap.leftDriveInverted);
	   	
	   	RobotMap.rightDriveMaster.setInverted(RobotMap.rightDriveInverted);
	   	RobotMap.rightDriveSlave1.setInverted(RobotMap.rightDriveInverted);
	   	RobotMap.rightDriveSlave2.setInverted(RobotMap.rightDriveInverted);
	  
	}

	public void setSensorPhase(boolean leftphase, boolean rightphase)
	{
		RobotMap.leftDriveMaster.setSensorPhase(leftphase);
	   	RobotMap.rightDriveMaster.setSensorPhase(rightphase);
	}

	public void zeroEncoders() {
		RobotMap.leftDriveMaster.setSelectedSensorPosition(0, 0, 0);
		RobotMap.rightDriveMaster.setSelectedSensorPosition(0, 0, 0);
		
		RobotMap.leftDriveMaster.getSensorCollection().setQuadraturePosition(0, 0);
		RobotMap.rightDriveMaster.getSensorCollection().setQuadraturePosition(0, 0);
		
		
	}
	
	public void setPID(double P, double I, double D, double F) {

		RobotMap.leftDriveMaster.config_kF(0, F, 10);
		RobotMap.leftDriveMaster.config_kP(0, P, 10);
		RobotMap.leftDriveMaster.config_kI(0, I, 10);
		RobotMap.leftDriveMaster.config_kD(0, D, 10);

		RobotMap.rightDriveMaster.config_kF(0, F, 10);
		RobotMap.rightDriveMaster.config_kP(0, P, 10);
		RobotMap.rightDriveMaster.config_kI(0, I, 10);
		RobotMap.rightDriveMaster.config_kD(0, D, 10);

	}
	
	public void setSetpointDrive(double setpointinches)
	{
		System.out.println("Target "+inchToEncoder(setpointinches));
		RobotMap.leftDriveMaster.set(ControlMode.Position,
				inchToEncoder(setpointinches));
		RobotMap.rightDriveMaster.set(ControlMode.Position, 
				inchToEncoder(setpointinches));
	}

	public void setSetpointTurn(double setpointdegrees)
	{
		zeroEncoders();

		System.out.println("setpoint: " + degreesToEncoder(setpointdegrees));

		RobotMap.leftDriveMaster.set(ControlMode.Position,
				degreesToEncoder(setpointdegrees));
		RobotMap.leftDriveMaster.set(ControlMode.Position, 
				degreesToEncoder(setpointdegrees));
	}
	
	public void setupOnTarget(int ticks, int maxLoopNumber)
	{
		// zero the on target counter
		onTargetCounter = 0;

		RobotMap.leftDriveMaster.configAllowableClosedloopError(0, ticks, 10);
		RobotMap.rightDriveMaster.configAllowableClosedloopError(0, ticks, 10);

		// set tolerance in ticks
		allowedErrorRange = ticks;
		
		this.maxLoopNumber=maxLoopNumber;

	}
		
	public double inchToEncoder(double inches)
	{
		System.out.println("inchtoencoder: "+(inches / RobotMap.wheelCir) * 4096);
		return (inches / RobotMap.wheelCir) * 5000;
	}
	
	public double degreesToEncoder(double degrees)
	{
		return inchToEncoder((RobotMap.robotCir / 360) * degrees);
	}
	
	public boolean onTarget()
	{
		if (Math.abs(RobotMap.leftDriveMaster.getClosedLoopError(0))
				<= allowedErrorRange && 
				Math.abs(RobotMap.rightDriveMaster.getClosedLoopError(0))
				<= allowedErrorRange)
		{
			onTargetCounter++;
		}
		else
		{
			onTargetCounter = 0;
		}

		if (maxLoopNumber <= onTargetCounter)
		{
			return true;
		}

		return false;
	}

	public void updateEncoders()
	{
		SmartDashboard.putNumber("Right Encoder", RobotMap.rightDriveMaster.getSelectedSensorPosition(0));
		SmartDashboard.putNumber("Left Encoder", RobotMap.leftDriveMaster.getSelectedSensorPosition(0));
		SmartDashboard.putNumber("Right Enc VEL", RobotMap.rightDriveMaster.getSelectedSensorVelocity(0));
		SmartDashboard.putNumber("Left Enc VEL", RobotMap.leftDriveMaster.getSelectedSensorVelocity(0));
	}
	
	public void driveArcade(double throttle, double wheel)
	{
		drive.driveArcade(throttle, wheel);
	}
	
	public void shiftLow() {
    	RobotMap.solenoidDriveShifters.set(DoubleSolenoid.Value.kForward);	
	}
	
	// set drive train shifters to high gear
	public void shiftHigh() {
		RobotMap.solenoidDriveShifters.set(DoubleSolenoid.Value.kReverse);
	
	}
	
	
    public void initDefaultCommand() {
   	
		setDefaultCommand(new DriveCommand());

    }
}

