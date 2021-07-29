package de.bsi.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamDemo extends LoopDemo {
	
	private Function<String, Item> generateItem = name -> new Item(name, name.length());
	private Comparator<Item> compareByName = (a, b) -> a.name().compareTo(b.name());
	
	@Override
	void prepareDemoData() {
		items = itemNames.stream().map(generateItem).collect(Collectors.toList());
	}
	
	@Override
	public List<Item> sortAndPrintItems() {
		items.stream().sorted(compareByName).forEach(System.out::println);
		return items;
	}
	
	@Override
	public Optional<Item> findBySubstringAndCountPosition(String substring) {
		final var counter = new ThreadLocal<Integer>();
		counter.set(0);
		
		return items.stream()
				.peek(i -> counter.set(counter.get() + 1))
				.filter(it -> it.name().contains(substring))
				.peek(i -> System.out.println("Stream: Item found at position: " + counter.get()))
				.findFirst();
	}
	
	@Override
	public long countItemsById(int id) {
		Predicate<Item> equalId = it -> it.id() == id;
		return items.stream().filter(equalId).count();
	}
}