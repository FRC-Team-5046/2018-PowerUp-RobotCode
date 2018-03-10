package org.usfirst.frc.team5046.robot.autongroups;

import org.usfirst.frc.team5046.robot.autoncommands.AutonDriveCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveStraightBackwards extends CommandGroup {

    public DriveStraightBackwards() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	//DRIVE STRAIGHT
    	addSequential(new AutonDriveCommand(-200,4,false));

    	
    	//RIGHT RIGHT SWITCH
//    	addSequential(new AutonDriveCommand(-150,2));
//    	addSequential(new AutonTurnEncoderCommand(90,2));
//    	addSequential(new AutonDriveCommand(-30,2));
//    	addSequential(new ShooterHighSpeed());
//    	addSequential(new ShooterStop());
    	
    	//RIGHT RIGHT SCALE
//    	addParallel(new AutoRaiseLift(5));
//    	addSequential(new AutonDriveCommand(-256,4));
//     	addSequential(new AutonTurnEncoderCommand(50,2));
//     	addSequential(new AutonDriveCommand(-21,2));
//    	addSequential(new ShooterHighSpeed());
//    	addSequential(new ShooterStop());

    	//LEFT LEFT SWITCH
//    	addSequential(new AutonDriveCommand(-150,2));
//    	addSequential(new AutonTurnEncoderCommand(-90,1));
//    	addSequential(new AutonDriveCommand(-30,1));
//    	addSequential(new ShooterHighSpeed());
//    	addSequential(new ShooterStop());    	
    	
    	//LEFT LEFT SCALE
//    	addParallel(new AutoRaiseLift(5));
//    	addSequential(new AutonDriveCommand(-256,4));
//     	addSequential(new AutonTurnEncoderCommand(-50,1));
//     	addSequential(new AutonDriveCommand(-21,1));
//    	addSequential(new ShooterHighSpeed());
//    	addSequential(new ShooterStop());    	
    	
    	//CENTER LEFT SWITCH
//    	addSequential(new AutonDriveCommand(-52,2));
//    	addSequential(new AutonTurnEncoderCommand(90,1));
//    	addSequential(new AutonDriveCommand(-50,1));
//    	addSequential(new AutonTurnEncoderCommand(-90,1));
//    	addSequential(new AutonDriveCommand(-48,1));
//    	addSequential(new ShooterHighSpeed());
//    	addSequential(new ShooterStop());    	
    	
    	
    	//CENTER RIGHT SWITCH
//    	addSequential(new AutonDriveCommand(-52,2));
//    	addSequential(new AutonTurnEncoderCommand(-90,1));
//    	addSequential(new AutonDriveCommand(-48,1));
//    	addSequential(new AutonTurnEncoderCommand(90,1));
//    	addSequential(new AutonDriveCommand(-48,1));
//    	addSequential(new ShooterHighSpeed());
//    	addSequential(new ShooterStop());    	
//    	
    	
    	//CENTER RIGHT SCALE
//       	addSequential(new AutonDriveCommand(-52,1));  //forward
//    	addSequential(new AutonTurnEncoderCommand(-100,2)); 	//turn right
//    	addSequential(new AutonDriveCommand(-115,2.5));  //forward
//    	addSequential(new AutonTurnEncoderCommand(100,3));  //turn left
//    	addParallel(new AutoRaiseLift(5));
//    	addSequential(new AutonDriveCommand(-206,4));
//    	addSequential(new ShooterHighSpeed());
//    	
    	
    	//CENTER LEFT SCALE
//    	addSequential(new AutonDriveCommand(-52,1));  //forward
//    	addSequential(new AutonTurnEncoderCommand(90,2)); 	//turn
//    	addSequential(new AutonDriveCommand(-125,2.5));  //forward
//    	addSequential(new AutonTurnEncoderCommand(-105,3));  //turn
//    	addParallel(new AutoRaiseLift(5));
//    	addSequential(new AutonDriveCommand(-210,4));
//    	addSequential(new ShooterHighSpeed());

    	//RIGHT LEFT SCALE
//    	addSequential(new AutonDriveCommand(-205,4));
//    	addSequential(new AutonTurnEncoderCommand(90,2)); 	//turn left
//    	addSequential(new AutonDriveCommand(-200,4));
//    	addSequential(new AutonTurnEncoderCommand(-100,2)); 	//turn right
//    	addParallel(new AutoRaiseLift(5));
//    	addSequential(new AutonDriveCommand(-35,3));
//    	addSequential(new ShooterHighSpeed());

    	
    	
    	//LEFT RIGHT SCALE
//    	addSequential(new AutonDriveCommand(-205,4));
//    	addSequential(new AutonTurnEncoderCommand(-90,2)); 	//turn left
//    	addSequential(new AutonDriveCommand(-200,4));
//    	addSequential(new AutonTurnEncoderCommand(100,2)); 	//turn right
//    	addParallel(new AutoRaiseLift(5));
//    	addSequential(new AutonDriveCommand(-25,3));
//    	addSequential(new ShooterHighSpeed());



    	
    }
}
