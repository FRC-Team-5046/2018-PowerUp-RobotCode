package org.usfirst.frc.team5046.robot.autongroups;

import org.usfirst.frc.team5046.robot.autoncommands.AutoRaiseLift;
import org.usfirst.frc.team5046.robot.autoncommands.AutonDriveCommand;
import org.usfirst.frc.team5046.robot.autoncommands.AutonTurnEncoderCommand;
import org.usfirst.frc.team5046.robot.autoncommands.AutonTurnGyroCommand;
import org.usfirst.frc.team5046.robot.commands.RaiseLift;
import org.usfirst.frc.team5046.robot.commands.ShooterHighSpeed;
import org.usfirst.frc.team5046.robot.commands.ShooterReverse;
import org.usfirst.frc.team5046.robot.commands.ShooterStop;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CenterRightScale extends CommandGroup {

    public CenterRightScale() {
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
    	
    	//CENTER RIGHT SCALE
     	addSequential(new AutonDriveCommand(-52,1));  //forward
    	addSequential(new AutonTurnEncoderCommand(-100,2)); 	//turn right
    	addSequential(new AutonDriveCommand(-115,2.5));  //forward
    	addSequential(new AutonTurnEncoderCommand(100,3));  //turn left
    	addParallel(new AutoRaiseLift(5));
    	addSequential(new AutonDriveCommand(-206,4));
    	addSequential(new ShooterHighSpeed());




    	
    }
}
