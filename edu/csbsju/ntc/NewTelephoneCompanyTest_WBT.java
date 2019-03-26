package edu.csbsju.ntc;

import static org.junit.Assert.*;

import org.junit.*;

import junit.framework.Assert;

public class NewTelephoneCompanyTest_WBT {
	private NewTelephoneCompany NTC;
	
	@Before
	public void start()
	{
		NTC = new NewTelephoneCompany();
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testComputeChargeInvalidStartTime() {
		NTC.setStartTime(-5);
		NTC.computeCharge();
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void testComputeChargeInvalidDuration()
	{
		NTC.setDuration(-5);
	    NTC.computeCharge();
	}
	
	@Test
	public void testComputeChargeDurationAboveSixty()
	{
		NTC.setDuration(65);
		NTC.setStartTime(800);
		assertTrue(NTC.computeCharge()==2298.4);
	}
	
	@Test
	public void testComputeChargeNight()
	{
	  NTC.setDuration(60);
	  NTC.setStartTime(0);
	  assertTrue(NTC.computeCharge()==1248.0);
	}
	@Test
	public void testComputeChargeNightAndAboveSixty()
	{
		NTC.setStartTime(0);
		NTC.setDuration(100);
		assertTrue(NTC.computeCharge()==1768.0);
	}
	@Test
	public void testComputeCharge()
	{
	    NTC.setStartTime(1000);
	    NTC.setDuration(40);
	    assertTrue(NTC.computeCharge()==1664.0);
	}
	
}


