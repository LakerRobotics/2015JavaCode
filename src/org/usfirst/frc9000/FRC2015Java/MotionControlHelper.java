package org.usfirst.frc9000.FRC2015Java;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * 
 * @author richard.topolewski
 *
 */
public class MotionControlHelper {
	double targetDistance         = 0.0d; // in distance units for example inches or Degrees of rotation
	double rampUpRampDownDistance = 0.0d; // in distance units for example inches or Degrees of roation
    double runningSpeed           = 0.0d; // distance (e.g. inchs or Degrees of rotation) over seconds	
	
    double currentMeasuredDistance  = 0.0d;
    double initialMeasuredDistance  = 0.0d;
    
    /**
     * This helper class just takes a target distance and will provide a motion control speed to get to that target
     * @param aTargetDistance   Where we are trying to get to
     * @param aRampUpRampDownDistance  Allows control of how fast we accelorate and decelorate
     * @param aRunningSpeed   the speed we want to travel most of the time, except for ramp up and ramp down
     * @param aInitialMeasuredDistance  so we know where we started from for the ramp up
     */
    public MotionControlHelper(double aTargetDistance, double aRampUpRampDownDistance, double aRunningSpeed, 
    		            double aInitialMeasuredDistance){
    	targetDistance          = aTargetDistance;
    	rampUpRampDownDistance  = aRampUpRampDownDistance;
    	runningSpeed            = aRunningSpeed;
    	initialMeasuredDistance = aInitialMeasuredDistance;
    }
    
    /**
     * Given the currentPosition (i.e. distance) this will return the current target speed 
     * @param currentMeasuredDistance // the current position, in distance units for example inches or Degrees-of-rotation
     * @return
     */
       public double getTargetSpeed(double currentMeasuredDistance){
       double targetSpeed = 0.0d;       

       if( Math.abs(currentMeasuredDistance - initialMeasuredDistance) < 0.01*rampUpRampDownDistance){
    	   targetSpeed = runningSpeed *.01 ; //just to make sure it does not stay stuck at the start 
       }
       else {
    	   double distanceFromStart = Math.abs(currentMeasuredDistance - initialMeasuredDistance); // use absolute value so if happens to move the other side of the intial position it does not move further and further away.
    	   double distanceFromEnd   =  targetDistance - currentMeasuredDistance;
    	   double gapDistanceToUse = 0.0d;

    	   System.out.println("fromStart="+distanceFromStart+" fromEnd="+distanceFromEnd);
    	   if(distanceFromEnd<distanceFromStart){
    		   gapDistanceToUse = distanceFromEnd;
    	   }
    	    else{
    		   gapDistanceToUse = distanceFromStart;
    	    }
    	   SmartDashboard.putNumber("gapDistanceToUse",gapDistanceToUse);
    	   if(gapDistanceToUse < rampUpRampDownDistance)
    		   targetSpeed = (gapDistanceToUse/rampUpRampDownDistance) * runningSpeed;
    	    else
    		   targetSpeed = runningSpeed;
       }
       
       return targetSpeed;
    }
    
    //Time
}
