package de.bsi.stream;

public record Item (String name, int id) implements Comparable<Item> {

	@Override
	public int compareTo(Item other) {
		if (this.name == null) return -1;
		if (other == null) return 1;
		return this.name.compareTo(other.name);
	}
	
}
