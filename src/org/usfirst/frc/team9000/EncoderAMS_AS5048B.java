/**
 * 
 */
package org.usfirst.frc.team9000;

import edu.wpi.first.wpilibj.DigitalSource;
import edu.wpi.first.wpilibj.Encoder;

/**
 * @author Richard Topolewski
 * This is a class to talk to an Australian Micro Systems Rotation Position sensor AS5048B, 
 *    where the "B" indicates a I2C implmentation
 *
 */
public class EncoderAMS_AS5048B extends Encoder {
	int I2C_Number = -1;
    /**
     *  I2C_A1A2Number then number from the boards leads (typically from 0 to 3)
     */
	public EncoderAMS_AS5048B(int a_I2C_Number){
		super(0,0);
	    I2C_Number = a_I2C_Number;
	}
	this.get(){
	}
	this.getDirection()
	this.getDistance()
	this.getFPGAIndex()
	this.getPeriod()
	this.getRate()
	this.getRaw()
	this.getSamplesToAverage()
	this.getSmartDashboardType();
	this.getStopped();
	this.getTable()??;
	this.pidGet()
	this.reset();
	this.setDistancePerPulse(distancePerPulse);
	this.setIndexSource(source);
	this.setIndexSource(source, type);
	this.setIndexSource(channel, type);
	this.setMaxPeriod(maxPeriod);
	this.setMinRate(minRate);
	this.setPIDSourceParameter(pidSource);
	this.setReverseDirection(reverseDirection);
	this.setSamplesToAverage(samplesToAverage);
	this.setDefaultSolenoidModule(moduleNumber);
	this.startLiveWindowMode();
	this.stopLiveWindowMode();
	this.setDefaultSolenoidModule(moduleNumber);
	this.updateTable();
	this.getDefaultSolenoidModule()
	this.setDefaultSolenoidModule(moduleNumber);
	}
	/**
	 * @param aChannel
	 * @param bChannel
	 * @deprecated
	 */
	private EncoderAMS_AS5048B(int aChannel, int bChannel) throws Exception {
		super(aChannel, bChannel);
		throw new Exception("tha AS5048B sensor does not have an A B Channel, it is a hall effect sensor");
		
	}

	/**
	 * @param aSource
	 * @param bSource
	 * @deprecated
	 */
	public EncoderAMS_AS5048B(DigitalSource aSource, DigitalSource bSource) throws Exception {
		super(aSource, bSource);
		throw new Exception("tha AS5048B sensor does not have an A B Channel, it is a hall effect sensor");
	}

	/**
	 * @param aChannel
	 * @param bChannel
	 * @param reverseDirection
	 * @deprecated
	 */
	public EncoderAMS_AS5048B(int aChannel, int bChannel,
			boolean reverseDirection) throws Exception {
		super(aChannel, bChannel, reverseDirection);
		throw new Exception("tha AS5048B sensor does not have an A B Channel, it is a hall effect sensor");
	}

	/**
	 * @param aChannel
	 * @param bChannel
	 * @param indexChannel
	 * @deprecated
	 */
	public EncoderAMS_AS5048B(int aChannel, int bChannel, int indexChannel) throws Exception {
		super(aChannel, bChannel, indexChannel);
		throw new Exception("tha AS5048B sensor does not have an A B Channel, it is a hall effect sensor");
	}

	/**
	 * @param aSource
	 * @param bSource
	 * @param reverseDirection
     * @deprecated
	 */
	public EncoderAMS_AS5048B(DigitalSource aSource, DigitalSource bSource,
			boolean reverseDirection) throws Exception {
		super(aSource, bSource, reverseDirection);
		throw new Exception("tha AS5048B sensor does not have an A B Channel, it is a hall effect sensor");
	}

	/**
	 * @param aSource
	 * @param bSource
	 * @param indexSource
	 * @deprecated
	 */
	public EncoderAMS_AS5048B(DigitalSource aSource, DigitalSource bSource,
			DigitalSource indexSource) throws Exception {
		super(aSource, bSource, indexSource);
		throw new Exception("tha AS5048B sensor does not have an A B Channel, it is a hall effect sensor");
	}

	/**
	 * @param aChannel
	 * @param bChannel
	 * @param reverseDirection
	 * @param encodingType
	 * @deprecated
	 */
	public EncoderAMS_AS5048B(int aChannel, int bChannel,
			boolean reverseDirection, EncodingType encodingType) throws Exception {
		super(aChannel, bChannel, reverseDirection, encodingType);
		throw new Exception("tha AS5048B sensor does not have an A B Channel, it is a hall effect sensor");
	}

	/**
	 * @param aChannel
	 * @param bChannel
	 * @param indexChannel
	 * @param reverseDirection
	 * @deprecated
	 */
	public EncoderAMS_AS5048B(int aChannel, int bChannel, int indexChannel,
			boolean reverseDirection) throws Exception{
		super(aChannel, bChannel, indexChannel, reverseDirection);
		throw new Exception("tha AS5048B sensor does not have an A B Channel, it is a hall effect sensor");
	}

	/**
	 * @param aSource
	 * @param bSource
	 * @param reverseDirection
	 * @param encodingType
	 * @deprecated
	 */
	public EncoderAMS_AS5048B(DigitalSource aSource, DigitalSource bSource,
			boolean reverseDirection, EncodingType encodingType) throws Exception{
		super(aSource, bSource, reverseDirection, encodingType);
		throw new Exception("tha AS5048B sensor does not have an A B Channel, it is a hall effect sensor");
	}

	/**
	 * @param aSource
	 * @param bSource
	 * @param indexSource
	 * @param reverseDirection
	 * @deprecated
	 */
	public EncoderAMS_AS5048B(DigitalSource aSource, DigitalSource bSource,
			DigitalSource indexSource, boolean reverseDirection) throws Exception {
		super(aSource, bSource, indexSource, reverseDirection);
		throw new Exception("tha AS5048B sensor does not have an A B Channel, it is a hall effect sensor");
		}

}
