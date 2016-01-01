package org.usfirst.frc9000.FRC2015Java;

import edu.wpi.first.wpilibj.PIDOutput;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class rotateRobotPIDOutput implements PIDOutput {


	public rotateRobotPIDOutput() {
	    SmartDashboard.putString("rotateRobotPIDOutput", "constructor called");
	}

	@Override
	public void pidWrite(double output) {
		//Dec29RGT   	RobotMap.driveRobotDrive.tankDrive(-output,output);
		//Dec30RGT RobotMap.driveRobotDrive.tankDrive(output,-output);
		//Dec30RGT   	RobotMap.driveRobotDrive.tankDrive(-output,output);
		//Dec30RGT	 RobotMap.driveRobotDrive.tankDrive(output,-output);
		//Dec30RGT RobotMap.driveRobotDrive.tankDrive(-output,output);
		//Dec31RGT RobotMap.driveRobotDrive.tankDrive(output,-output);
		//Dec31RGT RobotMap.driveRobotDrive. tankDrive(-output,output);
		//Dec31RGT RobotMap.driveRobotDrive.tankDrive(output,-output); // was holding it at its current position, when turn it pushed it back to the start position
		//Dec31RGT RobotMap.driveRobotDrive. tankDrive(-output,output); // This was turning it away from the target and redid the MCHelper so it now holds the source so that can actually adjust the rate
		//Dec31RGT RobotMap.driveRobotDrive.tankDrive(output,-output);// Again turned this back on and it locked the robot from rotating.
		//Dec31RGT RobotMap.driveRobotDrive. tankDrive(-output,output); // This was turning it away from the target and redid the MCHelper so it now holds the source so that can actually adjust the rate
		                                                                // Even after I think getting the target speed directio corec tint the MCHelper still just spun the wrong way.
		//Dec31RGT RobotMap.driveRobotDrive.tankDrive(output,-output);// Again turned this back on and it locked the robot from rotating.
		                                                              // turned down the gain and when turn it seems to resist in
		//Dec31RGT	RobotMap.driveRobotDrive. tankDrive(-output,output); // This was turning it away from the target and redid the MCHelper so it now holds the source so that can actually adjust the rate
																		// just was rotating the wrong way. (after eliminated the Exception throwing that was not needed to make sure was returning rate), assumes it is setup to return rate.
			RobotMap.driveRobotDrive. tankDrive(output,-output); // This was turning it away from the target and redid the MCHelper so it now holds the source so that can actually adjust the rate
		 SmartDashboard.putNumber("Motor Output",output); 
	}

}
