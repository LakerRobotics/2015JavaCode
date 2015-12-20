
package org.usfirst.frc.team9000.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */

/*
 *
 */
public class Robot extends IterativeRobot {
	
	double Kp = 0.05;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
	RobotDrive robotDrive = new RobotDrive(0,1);
	Joystick driver = new Joystick(1);
	Joystick operator = new Joystick(2);
	Talon Claw = new Talon(3);
	Talon Elevator = new Talon(2);
	Encoder leftWheels = new Encoder(0,1);
	Encoder rightWheels = new Encoder(2,3);
	Gyro gyro = new Gyro(0);
	
    public void robotInit() {

    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        gyro.reset();
        while (isAutonomous()) {
            double angle = gyro.getAngle(); // get current heading
            robotDrive.drive(-0.2, -angle*Kp); // drive towards heading 0
            Timer.delay(0.004);
        }
        robotDrive.drive(0.5, 0.5);

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	
    	robotDrive.arcadeDrive((-driver.getRawAxis(1)), -driver.getRawAxis(0));
    	
    	if (driver.getRawButton(5))
    	{
    		Claw.set(.45);
    	} else Claw.set(0);
    	double leftDist = leftWheels.getDistance();
    	SmartDashboard.putNumber("Left Encoder", leftWheels.getDistance());
    	SmartDashboard.putNumber("Right Encoder", rightWheels.getDistance());
    	
    	/*double axisinput;
    	axisinput = operator.getRawAxis(1);
    	Elevator.set(axisinput);
    	*/
    	Elevator.set(operator.getRawAxis(1));
    	
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
