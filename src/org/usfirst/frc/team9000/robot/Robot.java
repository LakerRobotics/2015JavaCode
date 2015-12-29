
package org.usfirst.frc.team9000.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;

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

	RobotDrive robotDrive = new RobotDrive(0,1);
	Joystick joyStickDriver   = new Joystick(1);
	Joystick joyStickOperator = new Joystick(2);
	Talon motorClaw = new Talon(3);
	Talon motorElevator = new Talon(2);
	Encoder leftWheels = new Encoder(0,1);
	Encoder rightWheels = new Encoder(2,3);
	Gyro gyro = new Gyro(0); 
	
	I2C rotation = new I2C(Port.kOnboard,192);
 
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
//    	leftWheels.setReverseDirection(true);
        SmartDashboard.putString("test","in robotInit()");
        gyro.initGyro();  
        gyro.setSensitivity(0.007);
        gyro.reset();
        
    }
    
    public void reportGyroOnDashboard(){
        double angle = gyro.getAngle(); // get current heading
        SmartDashboard.putDouble("gyroAngle",angle);
        SmartDashboard.putDouble("gyroRate",gyro.getRate());
        
    }
    /*
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        SmartDashboard.putString("test","in autonomousPeriodic()");

        reportGyroOnDashboard();
        
        while (isAutonomous()) {
            reportGyroOnDashboard();
            double angle = gyro.getAngle(); // get current heading
            double motorPower = 0.2;
            
            robotDrive.drive(motorPower, -angle*Kp); // drive towards heading 0
            Timer.delay(0.004);
        }
        //robotDrive.drive(0.5, 0.5);//commented out so Teleop is in control
        
        
        
        

    }

    private void drive(double d, double e) {
		// TODO Auto-generated method stub
		
	}

	/**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        reportGyroOnDashboard();
        SmartDashboard.putString("test","in teleopPeriodic()");
    	
        // Driving 
    	robotDrive.arcadeDrive((-joyStickDriver.getRawAxis(1)), -joyStickDriver.getRawAxis(0));

    	double leftDist = leftWheels.getDistance();

    	SmartDashboard.putNumber("Left Encoder", leftWheels.getDistance());
    	SmartDashboard.putNumber("Right Encoder", rightWheels.getDistance());
    	
    	// End Effector, Open and Close the Claw(End Effector)
    	if (joyStickDriver.getRawButton(5))	{
    		motorClaw.set(.45);
    	}
    	else{
    		motorClaw.set(0);
    	};
    	
    	
    	// Elevator, Have the Elevator go Up and Down
    	/*double axisinput;
    	axisinput = operator.getRawAxis(1);
    	Elevator.set(axisinput);
    	*/
    	motorElevator.set(joyStickOperator.getRawAxis(1));
    	
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
