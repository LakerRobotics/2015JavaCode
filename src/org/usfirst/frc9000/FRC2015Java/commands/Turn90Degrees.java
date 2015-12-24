// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc9000.FRC2015Java.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc9000.FRC2015Java.Robot;
import org.usfirst.frc9000.FRC2015Java.RobotMap;

/**
*
*/
public class  Turn90Degrees extends Command {

	double turn = -90;
   
   public Turn90Degrees() {
       // Use requires() here to declare subsystem dependencies
       // eg. requires(chassis);

       // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.drive);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    
   }

   // Called just before this Command runs the first time
   protected void initialize() {
   	RobotMap.driveGyro.reset();
   }

   // Called repeatedly when this Command is scheduled to run
   protected void execute() {
//   	double rotateValue = -.6;
//   	double moveValue = 0;
//   	RobotMap.driveRobotDrive.arcadeDrive(moveValue, rotateValue);
   	RobotMap.driveRobotDrive.tankDrive(-0.6, 0.6);
   	
   }  

   // Make this return true when this Command no longer needs to run execute()
   protected boolean isFinished() {
       SmartDashboard.putNumber("angle", RobotMap.driveGyro.getAngle());

   	if(RobotMap.driveGyro.getAngle() < turn) {
   		return true;
   	}
   	else{
           return false;
   	}

   }

   // Called once after isFinished returns true
   protected void end() {
   }

   // Called when another command which requires one or more of the same
   // subsystems is scheduled to run
   protected void interrupted() {
   }
}
