// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc9000.FRC2015Java.subsystems;

import org.usfirst.frc9000.FRC2015Java.MotionControlHelper;
import org.usfirst.frc9000.FRC2015Java.RobotMap;
import org.usfirst.frc9000.FRC2015Java.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType; 
import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Drive extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    Gyro gyro = RobotMap.driveGyro;
    Encoder rightWheelsEncoder = RobotMap.driveRightWheelsEncoder;
    SpeedController rightMotors = RobotMap.driveRightMotors;
    SpeedController leftMotors = RobotMap.driveLeftMotors;
    RobotDrive robotDrive = RobotMap.driveRobotDrive;
    SpeedController robotSpeed = RobotMap.driveRobotSpeed;
    Encoder leftWheelsEncoder = RobotMap.driveLeftWheelsEncoder;
    PIDController pIDRobotDrive = RobotMap.drivePIDRobotDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    //leftWheelsEncoder
    //Temp MotionControlHelper motionControlHelper = null;
    
    //Temp robotSpeed = new SpeedController();
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    //Temp public void startMotionControl(double targetDistance, double rampUpRampDownDistance,
    //Temp		                       double runningSpeed, double initialDistance){
    //Temp motionControlHelper = new MotionControlHelper(targetDistance, rampUpRampDownDistance, 
    //Temp		                                      runningSpeed, initialDistance);
    //Temp}
    

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

