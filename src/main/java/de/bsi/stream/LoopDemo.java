package de.bsi.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class LoopDemo {
	
	protected final List<String> itemNames = 
			List.of("Ardbeg", "Lagavulin", "Jim Beam", "Teeling", "Jameson", "Johnny Walker");
	
	protected List<Item> items;
	
	void prepareDemoData() {
		items = new ArrayList<>();
		for (var name : itemNames)
			items.add(new Item(name, name.length()));
	}

	public List<Item> sortAndPrintItems() {
		// Item must implement Comparable Interface, so that next line compiles.
		Collections.sort(items);
		for (var item : items)
			System.out.println(item);
		return items;
	}
	
	public Optional<Item> findBySubstringAndCountPosition(String substring) {
		for (int i = 0; i < items.size(); i++) {
			var item = items.get(i);
			if (item.name().contains(substring)) {
				System.out.println("Loop: Item found at position: " + i);
				return Optional.of(item);
			}
		}
		return Optional.empty();
	}

	public long countItemsById(int id) {
		long counter = 0;
		for (var item : items)
			if (item.id() == id)
				counter++;
		return counter;
	}
}
