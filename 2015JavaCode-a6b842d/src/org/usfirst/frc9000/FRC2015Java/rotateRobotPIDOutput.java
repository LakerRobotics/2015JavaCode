package org.usfirst.frc9000.FRC2015Java;

import edu.wpi.first.wpilibj.PIDOutput;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class rotateRobotPIDOutput implements PIDOutput {


	public rotateRobotPIDOutput() {
	    SmartDashboard.putString("rotateRobotPIDOutput", "constructor called");
	}

	@Override
	public void pidWrite(double output) {
	   	RobotMap.driveRobotDrive.tankDrive(-output,output);
	    SmartDashboard.putNumber("Motor Output",output);
	}

}
