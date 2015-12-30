package org.usfirst.frc9000.FRC2015Java;

import java.util.TimerTask;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.util.BoundaryException;

public class MotionControlPIDController extends PIDController {
	MotionControlHelper m_motionControlHelper; 
	PIDOutput mm_output;
	PIDSource mm_source;
	
	public double getRate() throws Exception{
		//create a new object that hold a method and see if the mm_source happens to have a method call getRate
		// Gyro and Encoder will have a method called getRate (otherwise we can just throw an exception because 
		// the developer didn't provide the right kind of mm_source (mainly a Gyro or Encodeer) for the 
		// motionControlPIDController to work, so we should blow up 
		java.lang.reflect.Method methodGetRate;
		try {
		  methodGetRate = mm_source.getClass().getMethod("getRate");
		}
		catch (SecurityException e) {
		      throw new Exception("failure in trying got find getRate() method on the PIDSource Object provided, maybe if exist is is private, but needs to be publice for MotionCotrollerPIDController requires", e);
		} 
		catch (NoSuchMethodException e) {
			  throw new Exception("failure in trying got find getRate() method on the PIDSource Object provided, apparently one does not exist, as MotionCotrollerPIDController requires", e);
		}
		
		try {
			  return (double) methodGetRate.invoke(mm_source);
		} 
		catch (IllegalArgumentException e) {
		      throw new Exception("failure in trying got run getRate() method on the PIDSource Object provided", e);
		} 
		catch (IllegalAccessException e) {
		      throw new Exception("failure in trying got run getRate() method on the PIDSource Object provided", e);
		}
	
		
	}

	public double getMeasurment() throws Exception{
		if (mm_source instanceof Gyro){
			Gyro gyro = (Gyro) mm_source;
			return gyro.getAngle();
		}
		else if (mm_source instanceof Encoder){
			Encoder encoder = (Encoder) mm_source;
			return encoder.getDistance();
		}
		else{
			//create a new object that hold a method and see if the mm_source happens to have a method call getRate
			// Gyro and Encoder will have a method called getRate (otherwise we can just throw an exception because 
			// the developer didn't provide the right kind of mm_source (mainly a Gyro or Encodeer) for the 
			// motionControlPIDController to work, so we should blow up 
			try{
				java.lang.reflect.Method methodGetMeas;
				try {
					methodGetMeas = mm_source.getClass().getMethod("getMeasurement");
				}
				catch (SecurityException e) {
			      throw new Exception("failure in trying got find getMeasurement() method on the PIDSource Object provided, maybe if exist is is private, but needs to be publice for MotionCotrollerPIDController requires", e);
				} 
				catch (NoSuchMethodException e) {
					throw new Exception("failure in trying got find getMeasurement() method on the PIDSource Object provided, apparently one does not exist, as MotionCotrollerPIDController requires", e);
				}
				
				try {
					return (double) methodGetMeas.invoke(mm_source);
				} 
				catch (IllegalArgumentException e) {
					throw new Exception("failure in trying got run getMeasurement() method on the PIDSource Object provided", e);
				} 
				catch (IllegalAccessException e) {
					throw new Exception("failure in trying got run getMeasurment() method on the PIDSource Object provided", e);
				}
			}
			catch(Exception e){
				throw new Exception("Source was not Encoder or Gyro or a PIDSource with a method getMeasurement()", e);
			}
		}
	}	
	
	/**
	 * The PIDSource is expected to have a setPIDSourceParameter() method on it, otherwise we can not ensure it is
	 * returning rate to the PIDController
	 * @throws Exception
	 */
	public void ensureSourceProvidesRate() throws Exception{
		
		java.lang.reflect.Method methodSetSourceParm;
		try {
			methodSetSourceParm = mm_source.getClass().getMethod("setPIDSourceParameter");
		}
		catch (SecurityException e) {
	      throw new Exception("failure in trying got find setPIDSourceParameter() method on the PIDSource Object provided, maybe if exist is is private, but needs to be publice for MotionCotrollerPIDController requires", e);
		} 
		catch (NoSuchMethodException e) {
			throw new Exception("failure in trying got find setPIDSourceParameter() method on the PIDSource Object provided, apparently one does not exist, as MotionCotrollerPIDController requires", e);
		}
		
		// do the real work, set the PIDSource to return rate
		try {
			methodSetSourceParm.invoke(mm_source, PIDSource.PIDSourceParameter.kRate);
			return;
		} 
		catch (IllegalArgumentException e) {
			throw new Exception("failure in trying got run setPIDSourceParameter() method on the PIDSource Object provided", e);
		} 
		catch (IllegalAccessException e) {
			throw new Exception("failure in trying got run setPIDSourceParameter() method on the PIDSource Object provided", e);
		}
}



	public MotionControlPIDController(double Kp, double Ki, double Kd, PIDSource source, PIDOutput output,
			MotionControlHelper motionControl) {
		super(Kp, Ki, Kd, source, output);
		m_motionControlHelper = motionControl;
		mm_source = new wrapPIDInput(this);
		mm_output = output;
	}
	
	
	public MotionControlPIDController(double Kp, double Ki, double Kd, PIDSource source, PIDOutput output,
			double period,
			MotionControlHelper motionControl) {
		super(Kp, Ki, Kd, source, output, period);
		m_motionControlHelper = motionControl; 
		mm_source = new wrapPIDInput(this);
		mm_output = output;
	}

	public MotionControlPIDController(double Kp, double Ki, double Kd, double Kf, PIDSource source, PIDOutput output,
			MotionControlHelper motionControl) {
		super(Kp, Ki, Kd, Kf, source, output);
		m_motionControlHelper = motionControl; 
		mm_source = new wrapPIDInput(this);
		mm_output = output;
	}

	public MotionControlPIDController(double Kp, double Ki, double Kd, double Kf, PIDSource source, PIDOutput output,
			double period,MotionControlHelper motionControl) {
		super(Kp, Ki, Kd, Kf, source, output, period);
		m_motionControlHelper = motionControl; 
		mm_source = new wrapPIDInput(this);
		mm_output = output;
	}

	

    /**
     * Read the input(i.e. position) and calculate the speed for this position and put that in as the setPoint
     */
    private void calculateSetup() throws Exception {
    	//using the current measurement get the desired rate (i.e. speed)
    	double targetSpeed = m_motionControlHelper.getTargetSpeed(this.getMeasurment());
    	setSetpoint(targetSpeed);
    	
    	ensureSourceProvidesRate();
    	// now that we have the speed set properly lets call the PID control and have it adjust the PIDInput (e.g. the motor power) to get closer to the desired speed.
    	//TODO need to access the inner class PIDTask and override to call calculatesSetup then then calculate()
       	//super.calculate();
    }


    private class wrapPIDInput implements PIDSource {

        private MotionControlPIDController m_MCcontroller;

        public wrapPIDInput(MotionControlPIDController mccontroller) {
            if (mccontroller == null) {
                throw new NullPointerException("Given MotionControlPIDController was null");
            }
            m_MCcontroller = mccontroller;
        }
        
		@Override
        public double pidGet(){
        	// have the controller set the target speed,
        	//TODO redo the PIDController so the calculate() method is protected so we wouldn't have to do this hack 
			//  if it were protected then we could override calculate() method and allow the target speed to be set ahead of calculation the new PID output
			try{
        	m_MCcontroller.calculateSetup();
			}
			catch (Exception e){
				System.out.println("MotionControl PIDSource BAD, likley not Gyro or Encoder or missing getMeasurement()");
				System.out.println(e);
			}
			// call the real PIDSource
        	return m_MCcontroller.mm_source.pidGet();
        }

    }

}
