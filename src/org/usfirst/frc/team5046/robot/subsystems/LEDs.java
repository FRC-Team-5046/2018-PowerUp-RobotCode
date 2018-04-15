package org.usfirst.frc.team5046.robot.subsystems;

import org.usfirst.frc.team5046.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LEDs extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	
//	79  0.57 solid Colors Hot Pink 	
	public void solidHotPink() {
		RobotMap.ledController.set(.57);
	}
	
//	80  0.59 solid Colors Dark red 	
	public void solidDarkRed() {
		RobotMap.ledController.set(.59);
	}
	
//	81  0.61 solid Colors Red			
	public void solidRed() {
		RobotMap.ledController.set(.61);
	}
	
//	82  0.63 solid Colors Red Orange 	
	public void solidRedOrange() {
		RobotMap.ledController.set(.63);
	}
	
//	83  0.65 solid Colors Orange 		
	public void solidOrange() {
		RobotMap.ledController.set(.65);
	}
	
//	84  0.67 solid Colors Gold 	
	public void solidGold() {
		RobotMap.ledController.set(.67);
	}
	
//	85  0.69 solid Colors Yellow	
	public void solidYellow() {
		RobotMap.ledController.set(.69);
	}
	
//	86  0.71 solid Colors Lawn Green	
	public void solidLawnGreen() {
		RobotMap.ledController.set(.71);
	}
	
//	87  0.73 solid Colors Lime			
	public void solidLime() {
		RobotMap.ledController.set(.73);
	}
	
//	88  0.75 solid Colors Dark Green 	
	public void solidDarkGreen() {
		RobotMap.ledController.set(.75);
	}
	
//	89  0.77 solid Colors Green 	
	public void solidGreen() {
		RobotMap.ledController.set(.77);
	}
//	90  0.79 solid Colors Blue Green 	
	public void solidBlueGreen() {
		RobotMap.ledController.set(.79);
	}
	
//	91  0.81 solid Colors Aqua 		
	public void solidAqua() {
		RobotMap.ledController.set(.81);
	}
	
//	92  0.83 solid Colors Sky Blue 	
	public void solidSkyBlue() {
		RobotMap.ledController.set(.83);
	}
	
//	93  0.85 solid Colors Dark Blue 	
	public void solidDarkBlue() {
		RobotMap.ledController.set(.85);
	}
	
//	94  0.87 solid Colors Blue 		
	public void solidBlue() {
		RobotMap.ledController.set(.87);
	}
	
//	95  0.89 solid Colors Blue Violet 	
	public void solidBlueViolet() {
		RobotMap.ledController.set(.89);
	}
	
//	96  0.91 solid Colors Violet 		
	public void solidViolet() {
		RobotMap.ledController.set(.91);
	}
	
//	97  0.93 solid Colors White 		
	public void solidWhite() {
		RobotMap.ledController.set(.93);
	}
	
//	98  0.95 solid Colors Gray 		
	public void solidGray() {
		RobotMap.ledController.set(.95);
	}
	
//	99  0.97 solid Colors Dark Gray 	
	public void solidDarkGrey() {
		RobotMap.ledController.set(.97);
	}
	
//	100 0.99 solid Colors Black 		
	public void solidBlack() {
		RobotMap.ledController.set(.99);
	}
	
	

//	38 -0.25 Fixed Palette Pattern Heartbeat, Red
	public void heartbeatRed() {
		RobotMap.ledController.set(-0.25);
	}


//	39 -0.23 Fixed Palette Pattern Heartbeat, Blue	
	public void heartbeatBlue() {
		RobotMap.ledController.set(-0.23);
	}
	
//	45 -0.11 Fixed Palette Pattern Strobe, Red - - Brightness
	public void strobeRed() {
		RobotMap.ledController.set(-0.11);
	}
	
//	46 -0.09 Fixed Palette Pattern Strobe, Blue - - Brightness
	public void strobeBlue() {
		RobotMap.ledController.set(-0.09);
	}
	
	public void manual(double pwmvalue) {
		RobotMap.ledController.set(pwmvalue);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    
}

