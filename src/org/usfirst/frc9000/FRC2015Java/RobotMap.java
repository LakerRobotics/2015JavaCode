// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc9000.FRC2015Java;
    
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType; import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;

import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import java.util.Vector;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static Gyro driveGyro;
    public static Encoder driveRightWheelsEncoder;
    public static SpeedController driveRightMotors;
    public static SpeedController driveLeftMotors;
    public static RobotDrive driveRobotDrive;
    public static SpeedController driveRobotSpeed;
    public static Encoder driveLeftWheelsEncoder;
    public static PIDController drivePIDRobotDrive;
    public static Encoder elevatorElevatorEncoder;
    public static SpeedController elevatorElevatorMotor;
    public static Encoder clawClawEncoder;
    public static SpeedController clawClawMotor;
    public static Relay lightsSpike;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveGyro = new Gyro(0);
        LiveWindow.addSensor("Drive", "Gyro", driveGyro);
        driveGyro.setSensitivity(0.0068);
        driveRightWheelsEncoder = new Encoder(0, 1, false, EncodingType.k4X);
        LiveWindow.addSensor("Drive", "RightWheelsEncoder", driveRightWheelsEncoder);
        driveRightWheelsEncoder.setDistancePerPulse(1.0);
        driveRightWheelsEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
        driveRightMotors = new Talon(1);
        LiveWindow.addActuator("Drive", "RightMotors", (Talon) driveRightMotors);
        
        driveLeftMotors = new Talon(0);
        LiveWindow.addActuator("Drive", "LeftMotors", (Talon) driveLeftMotors);
        
        driveRobotDrive = new RobotDrive(driveLeftMotors, driveRightMotors);
        
        driveRobotDrive.setSafetyEnabled(true);
        driveRobotDrive.setExpiration(0.1);
        driveRobotDrive.setSensitivity(0.5);
        driveRobotDrive.setMaxOutput(1.0);
        

        driveRobotSpeed = new Talon(4);
        LiveWindow.addActuator("Drive", "RobotSpeed", (Talon) driveRobotSpeed);
        
        driveLeftWheelsEncoder = new Encoder(2, 3, true, EncodingType.k4X);
        LiveWindow.addSensor("Drive", "LeftWheelsEncoder", driveLeftWheelsEncoder);
        driveLeftWheelsEncoder.setDistancePerPulse(1.0);
        driveLeftWheelsEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
        drivePIDRobotDrive = new PIDController(1.0, 0.0, 0.0, 0.0, driveLeftWheelsEncoder, driveRobotSpeed, 0.02);
        LiveWindow.addActuator("Drive", "PIDRobotDrive", drivePIDRobotDrive);
        drivePIDRobotDrive.setContinuous(false); drivePIDRobotDrive.setAbsoluteTolerance(0.2); 
        drivePIDRobotDrive.setOutputRange(-1.0, 1.0);        

        elevatorElevatorEncoder = new Encoder(4, 5, false, EncodingType.k4X);
        LiveWindow.addSensor("Elevator", "ElevatorEncoder", elevatorElevatorEncoder);
        elevatorElevatorEncoder.setDistancePerPulse(1.0);
        elevatorElevatorEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
        elevatorElevatorMotor = new Talon(2);
        LiveWindow.addActuator("Elevator", "ElevatorMotor", (Talon) elevatorElevatorMotor);
        
        clawClawEncoder = new Encoder(6, 7, false, EncodingType.k4X);
        LiveWindow.addSensor("Claw", "ClawEncoder", clawClawEncoder);
        clawClawEncoder.setDistancePerPulse(1.0);
        clawClawEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
        clawClawMotor = new Talon(3);
        LiveWindow.addActuator("Claw", "ClawMotor", (Talon) clawClawMotor);
        
        lightsSpike = new Relay(0);
        LiveWindow.addActuator("Lights", "Spike", lightsSpike);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveLeftWheelsEncoder.setDistancePerPulse(4*Math.PI/360);
        driveRightWheelsEncoder.setDistancePerPulse(4*Math.PI/360);
    }
}
