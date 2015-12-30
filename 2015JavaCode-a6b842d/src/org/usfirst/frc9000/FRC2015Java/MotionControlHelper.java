package org.usfirst.frc9000.FRC2015Java;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * 
 * @author richard.topolewski
 *
 */
public class MotionControlHelper {
	double m_targetDistance         = 0.0d; // in distance units for example inches or Degrees of rotation
	double m_rampUpRampDownDistance = 0.0d; // in distance units for example inches or Degrees of roation
    double m_runningSpeed           = 0.0d; // distance (e.g. inchs or Degrees of rotation) over seconds	
	
    double m_currentMeasuredDistance  = 0.0d;
    double m_initialMeasuredDistance  = 0.0d;
    
    /**
     * This helper class just takes a target distance and will provide a motion control speed to get to that target
     * @param aTargetDistance   Where we are trying to get to
     * @param aRampUpRampDownDistance  Allows control of how fast we accelorate and decelorate
     * @param aRunningSpeed   the speed we want to travel most of the time, except for ramp up and ramp down
     * @param aInitialMeasuredDistance  so we know where we started from for the ramp up
     */
    public MotionControlHelper(double targetDistance, double rampUpRampDownDistance, double runningSpeed, 
    		            double initialMeasuredDistance){
    	m_targetDistance          = targetDistance;
    	m_rampUpRampDownDistance  = Math.abs(rampUpRampDownDistance);
    	m_runningSpeed            = runningSpeed;
    	m_initialMeasuredDistance = initialMeasuredDistance;
    }
    
    /**
     * Given the currentPosition (i.e. distance) this will return the current target speed 
     * @param currentMeasuredDistance // the current position, in distance units for example inches or Degrees-of-rotation
     * @return
     */
       public double getTargetSpeed(double currentMeasuredDistance){
       double targetSpeed = 0.0d;       

       double percentDeadZoneOverride = 10;
       if( Math.abs(currentMeasuredDistance - m_initialMeasuredDistance) < m_rampUpRampDownDistance*(percentDeadZoneOverride/100)){
    	   targetSpeed = m_runningSpeed *(percentDeadZoneOverride/100) ; //just to make sure it does not stay stuck at the start 
       }
       else {
    	   double distanceFromStart = Math.abs(currentMeasuredDistance - m_initialMeasuredDistance); // use absolute value so if happens to move the other side of the intial position it does not move further and further away.
    	   double distanceFromEnd   =  m_targetDistance - currentMeasuredDistance;
    	   double gapDistanceToUse = 0.0d;

    	   System.out.println("fromStart="+distanceFromStart+" fromEnd="+distanceFromEnd);
    	   if(Math.abs(distanceFromEnd)<Math.abs(distanceFromStart)){
    		   gapDistanceToUse = -distanceFromEnd; // need to still move in the right direction
    	   }
    	   else{
    		   gapDistanceToUse = Math.abs(distanceFromStart);
    		   double direction = -distanceFromEnd/Math.abs(distanceFromEnd);//just get the sign
    		   gapDistanceToUse = gapDistanceToUse * direction;
    	   }
    	   SmartDashboard.putNumber("gapDistanceToUse",gapDistanceToUse);
    	   if(Math.abs(gapDistanceToUse) < m_rampUpRampDownDistance)
    		   targetSpeed = (gapDistanceToUse/m_rampUpRampDownDistance) * m_runningSpeed;
    	    else
    		   targetSpeed = m_runningSpeed;
       }
       
       return targetSpeed;
    }
    
    //Time
}
