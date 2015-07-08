
package org.usfirst.frc.team9000.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;

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
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
	RobotDrive robotDrive = new RobotDrive(0,1);
	Joystick driver = new Joystick(1);
	Joystick operator = new Joystick(2);
	Talon Claw = new Talon(2);
	
    public void robotInit() {

    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

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
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
