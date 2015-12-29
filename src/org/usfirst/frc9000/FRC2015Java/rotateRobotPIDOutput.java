package org.usfirst.frc9000.FRC2015Java;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.Talon;

public class rotateRobotPIDOutput implements PIDOutput {


	public rotateRobotPIDOutput() {
	}

	@Override
	public void pidWrite(double output) {
	   	RobotMap.driveRobotDrive.tankDrive(output,-output);
	}

}
