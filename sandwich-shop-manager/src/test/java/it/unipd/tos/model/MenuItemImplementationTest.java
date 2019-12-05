package it.unipd.tos.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import it.unipd.tos.model.ItemType;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.MenuItemImplementation;

public class MenuItemImplementationTest {

	private MenuItem test;
	@Before
    public void before() {
    	test = new MenuItemImplementation("panino vegano", ItemType.Panino, 8.0);
    }
	
	@Test
	public void testGetName() {
		assertEquals("panino vegano", test.getName());
	}

	@Test
	public void testGetType() {
		assertEquals(ItemType.Panino, test.getType());
	}

	@Test
	public void testGetPrice() {
		assertEquals(8.0, test.getPrice(), 0.01);
	}
}

