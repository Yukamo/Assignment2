package it.unipd.tos.model;

import static org.junit.Assert.*;

import org.junit.Test;

import it.unipd.tos.model.ItemType;

public class ItemTypeTest {

	@Test
	public void testToString() {
		ItemType i = ItemType.Panino;
		assertEquals("PANINO", i.toString());
	}
}