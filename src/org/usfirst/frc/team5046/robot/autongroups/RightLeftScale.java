package org.usfirst.frc.team5046.robot.autongroups;

import org.usfirst.frc.team5046.robot.autoncommands.AutoRaiseLift;
import org.usfirst.frc.team5046.robot.autoncommands.AutonDriveCommand;
import org.usfirst.frc.team5046.robot.autoncommands.AutonTurnEncoderCommand;
import org.usfirst.frc.team5046.robot.commands.ShooterHighSpeed;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightLeftScale extends CommandGroup {

    public RightLeftScale() {
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
    	

    	//RIGHT LEFT SCALE
    	addSequential(new AutonDriveCommand(-205,4,false));
    	addSequential(new AutonTurnEncoderCommand(90,2)); 	//turn left
    	addSequential(new AutonDriveCommand(-200,4,false));
    	addSequential(new AutonTurnEncoderCommand(-100,2)); 	//turn right
    	addParallel(new AutoRaiseLift(5));
    	addSequential(new AutonDriveCommand(-35,3,false));
    	addSequential(new ShooterHighSpeed());




    	
    }
}
