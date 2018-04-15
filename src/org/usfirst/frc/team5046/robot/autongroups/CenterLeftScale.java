package org.usfirst.frc.team5046.robot.autongroups;

import org.usfirst.frc.team5046.robot.autoncommands.AutonRaiseLift;
import org.usfirst.frc.team5046.robot.autoncommands.AutonDriveCommand;
import org.usfirst.frc.team5046.robot.autoncommands.AutonRaiseLift;
import org.usfirst.frc.team5046.robot.autoncommands.AutonTurnEncoderCommand;
import org.usfirst.frc.team5046.robot.commands.ShooterHighSpeed;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CenterLeftScale extends CommandGroup {

    public CenterLeftScale() {
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
    	
    
    	//CENTER LEFT SCALE
    	addSequential(new AutonDriveCommand(-52,1,false));  //forward
    	addSequential(new AutonTurnEncoderCommand(90,2)); 	//turn
    	addSequential(new AutonDriveCommand(-125,2.5,false));  //forward
    	addSequential(new AutonTurnEncoderCommand(-105,3));  //turn
    	addParallel(new AutonRaiseLift(5));
    	addSequential(new AutonDriveCommand(-210,4,false));
    	addSequential(new ShooterHighSpeed());




    	
    }
}
