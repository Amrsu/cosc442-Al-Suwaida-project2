/**
 * 
 */
package edu.towson.cis.cosc442.project2.vendingmachine;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author am
 *
 */
public class VendingMachineTest {

	/**
	 * @throws java.lang.Exception
	 */
	
	VendingMachine vend;
	VendingMachine vend2;
	VendingMachine vend3;
	VendingMachine vend4;
	VendingMachineItem[] itemArray;
	VendingMachineItem VendingItems;
	
	@Before
	public void setUp() throws Exception {
		
		vend = new VendingMachine();
		vend2 = new VendingMachine();
		vend3 = new VendingMachine();
		vend4 = new VendingMachine();
		itemArray = new  VendingMachineItem[4];
		
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		
		vend=null;
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachine#addItem(edu.towson.cis.cosc442.project2.vendingmachine.VendingMachineItem, java.lang.String)}.
	 */
	
	@Test
	public void testArray() {
		
		assertEquals(4, itemArray.length); // testing if the array length is 4
		
	}
	@Test
	public void testAddItem() {
		
		//testing each item with different objects.
		
		vend.addItem(VendingItems, VendingMachine.A_CODE);
		assertEquals(VendingItems, vend.getItem(VendingMachine.A_CODE));
		
		vend2.addItem(VendingItems, VendingMachine.B_CODE);
		assertEquals(VendingItems, vend2.getItem(VendingMachine.B_CODE));
		
		vend3.addItem(VendingItems, VendingMachine.C_CODE);
		assertEquals(VendingItems, vend3.getItem(VendingMachine.C_CODE));
		
		vend4.addItem(VendingItems, VendingMachine.D_CODE);
		assertEquals(VendingItems, vend4.getItem(VendingMachine.D_CODE));
		

	}

	

	/**
	 * Test method for {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachine#removeItem(java.lang.String)}.
	 */
	@Test
	public void testRemoveItem() {
	
		//removing the item from the array and set them to null
		// i found assert null is match with this case.
		assertNull(vend.getItem(VendingMachine.A_CODE));
		assertNull(vend2.getItem(VendingMachine.B_CODE));
		assertNull(vend3.getItem(VendingMachine.C_CODE));
		assertNull(vend4.getItem(VendingMachine.D_CODE));
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachine#insertMoney(double)}.
	 */
	@Test
	public void testInsertMoney() {
		
		//trying different integers to all objects.
		
		vend.insertMoney(1.00);
		assertEquals(1.00, vend.getBalance(),1.00);
		
		vend2.insertMoney(2.00);
		assertEquals(2.00, vend2.getBalance(),2.00);
		
		vend3.insertMoney(3.00);
		assertEquals(3.00, vend3.getBalance(),3.00);
		
		vend4.insertMoney(4.00);
		assertEquals(4.00, vend4.getBalance(),4.00);
	}
	
	@Test(expected=VendingMachineException.class) 
	
	// found this on exception in 
	// https://stackoverflow.com/questions/156503/how-do-you-assert-that-a-certain-exception-is-thrown-in-junit-4-tests
	
	public void testInsertMoneyLessThan0() {
		
		//test all objects with a money less than 0.

		vend.insertMoney(-1.00);
		assertEquals(-1.00, vend.getBalance(),-1.00);
		
		vend2.insertMoney(-2.00);
		assertEquals(-2.00, vend2.getBalance(),-2.00);
		
		vend3.insertMoney(-3.00);
		assertEquals(3.00, vend3.getBalance(),-3.00);
		
		vend4.insertMoney(-4.00);
		assertEquals(-4.00, vend4.getBalance(),-4.00);
	
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachine#getBalance()}.
	 */
	@Test
	public void testGetBalance() {
		
	// see if the balance is the same with previous test or not.
		assertEquals(1.0,vend.getBalance(), 1.0 );
		assertEquals(2.0,vend2.getBalance(), 2.0 );
		assertEquals(3.0,vend3.getBalance(), 3.0 );
		assertEquals(4.0,vend4.getBalance(), 4.0 );
		
		
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachine#makePurchase(java.lang.String)}.
	 */
	@Test
	public void testMakePurchase() {
		
		//testing the method and conditions in all objects
		
		VendingItems = vend.getItem(VendingMachine.A_CODE);
		double balance = 2.0;
		assertNull(VendingItems);
		assertEquals(1.0, vend.getBalance(), balance);
		assertFalse(vend.makePurchase(VendingMachine.A_CODE));
		
		VendingItems = vend2.getItem(VendingMachine.B_CODE);
		double balance2 = 3.0;
		assertNull(VendingItems);
		assertEquals(2.0, vend2.getBalance(), balance2);
		assertFalse(vend2.makePurchase(VendingMachine.B_CODE));
		
		VendingItems = vend3.getItem(VendingMachine.C_CODE);
		double balance3 = 4.0;
		assertNull(VendingItems);
		assertEquals(3.0, vend3.getBalance(), balance3);
		assertFalse(vend3.makePurchase(VendingMachine.C_CODE));
		
		VendingItems = vend.getItem(VendingMachine.D_CODE);
		double balance4 = 5.0;
		assertNull(VendingItems);
		assertEquals(4.0, vend4.getBalance(), balance4);
		assertFalse(vend4.makePurchase(VendingMachine.D_CODE));
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachine#returnChange()}.
	 */
	@Test
	public void testReturnChange() {
		
		// testing and making sure that the change return and the balance become 0
		vend.insertMoney(1.0);
		assertEquals(1.0,vend.returnChange(),0.0);
		assertEquals(0.0,vend.getBalance(), 0.0 );
		
		vend2.insertMoney(2.0);
		assertEquals(1.0,vend2.returnChange(),1.0);
		assertEquals(0.0,vend2.getBalance(), 0.0 );
		
		vend3.insertMoney(3.0);
		assertEquals(2.0,vend3.returnChange(),2.0);
		assertEquals(0.0,vend3.getBalance(), 0.0 );
		
		vend4.insertMoney(4.0);
		assertEquals(3.0,vend4.returnChange(),3.0);
		assertEquals(0.0,vend4.getBalance(), 0.0 );
		
	}

}
