package edu.towson.cis.cosc442.project2.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineItemTest {
	
	

	VendingMachineItem vend;
	@Before
	public void setUp() throws Exception {
		vend = new VendingMachineItem("AM", 5); // create a new opject to use it for the following test cases.  
	}

	@After
	public void tearDown() throws Exception {
		vend= null;
		
	}
	
	

	@Test(expected=VendingMachineException.class)
	public void testVendingMachineItemWithNegitavePriceOrNot( ) {
		
		vend = new VendingMachineItem("AM", 5);// Greater than 0
		vend = new VendingMachineItem("AM", 2);// Greater than 0
		vend = new VendingMachineItem("AM",6);// Greater than 0
		
		vend = new VendingMachineItem("AM", -20); //less than 0
		vend = new VendingMachineItem("AM", -7); //less than 0
		vend = new VendingMachineItem("AM", -40); //less than 0
		vend = new VendingMachineItem("AM", -35); //less than 0
		
	}

	@Test
	public void testGetName() {
		
		
		assertEquals("AM",vend.getName()); // the name is accepted a string
		
	}

	@Test
	public void testGetPrice() {
		
		assertNotSame(5.0,vend.getPrice()); // the price accepted double 
		
	}

}
