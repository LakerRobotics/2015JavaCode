package org.usfirst.frc9000.FRC2015Java;

import edu.wpi.first.wpilibj.PIDOutput;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RobotDriveStraightPIDOutput implements PIDOutput {

	double Kp = 0.05;// was 0.05 whith a delay of 0.004

	public RobotDriveStraightPIDOutput() {
//	    SmartDashboard.putString("rotateRobotPIDOutput", "constructor called");
	}

	@Override
	public void pidWrite(double motorPower) {
	   	double angle = RobotMap.driveGyro.getAngle(); // get current heading
	    RobotMap.driveRobotDrive.drive(motorPower, -angle*Kp); // drive towards heading 0
	    SmartDashboard.putNumber("Motor Output",motorPower); 
	}

}
