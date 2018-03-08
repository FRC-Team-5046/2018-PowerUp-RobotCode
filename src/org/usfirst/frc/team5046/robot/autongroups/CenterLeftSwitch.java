package org.usfirst.frc.team5046.robot.autongroups;

import org.usfirst.frc.team5046.robot.autoncommands.AutonDriveCommand;
import org.usfirst.frc.team5046.robot.autoncommands.AutonTurnGyroCommand;
import org.usfirst.frc.team5046.robot.commands.RaiseLift;
import org.usfirst.frc.team5046.robot.commands.ShooterHighSpeed;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CenterLeftSwitch extends CommandGroup {

    public CenterLeftSwitch() {
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
    	addSequential(new AutonDriveCommand(24,2));
    	addSequential(new AutonTurnGyroCommand(45,3));
    	addSequential(new AutonDriveCommand(48,3));
    	addSequential(new AutonTurnGyroCommand(-45,3));
    	addSequential(new AutonDriveCommand(24,3));
    	addSequential(new ShooterHighSpeed());

      	//addSequential(new RaiseLift(5));
    	//addSequential(new ShooterHighSpeed());
    	
    	
    }
}
