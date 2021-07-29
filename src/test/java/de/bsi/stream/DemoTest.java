package de.bsi.stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class DemoTest {

	private static StreamDemo streamDemo = new StreamDemo();
	private static LoopDemo loopDemo = new LoopDemo();
	
	@BeforeAll
	static void prepareDemoDataTest() {
		loopDemo.prepareDemoData();
		streamDemo.prepareDemoData();
		assertEquals(loopDemo.items, streamDemo.items);
		
		streamDemo.items.stream().collect(Collectors.groupingBy(Item::id))
			.forEach((group, elements) -> System.out.println(group + " : " + elements));
	}
	
	@Test
	void testSortAndPrintItems() {
		System.out.println("Print with loop:");
		loopDemo.sortAndPrintItems();
		System.out.println("Print with stream:");
		streamDemo.sortAndPrintItems();
		assertEquals(loopDemo.items.size(), streamDemo.items.size());
		// Sorting with stream does not change order in source of stream.
		assertNotEquals(loopDemo.items, streamDemo.items);
	}
	
	@Test
	void testFindBySubstringAndCountPosition() {
		var found1 = loopDemo.findBySubstringAndCountPosition("Beam");
		var found2 = streamDemo.findBySubstringAndCountPosition("Beam");
		assertEquals(loopDemo.itemNames.get(2), found1.get().name());
		assertEquals(found1, found2);
	}
	
	@Test
	void testCountItemsById() {
		var counts = new ArrayList<Long>();
		for (int i = 5; i < 15; i++) {
			long loopCount = loopDemo.countItemsById(i);
			assertEquals(loopCount, streamDemo.countItemsById(i));
			counts.add(loopCount);
		}
		
		assertTrue(counts.stream().noneMatch(c -> c < 0));
		assertFalse(counts.stream().allMatch(c -> c < 0));
		assertTrue(counts.stream().anyMatch(c -> c > 0));
	}

}
