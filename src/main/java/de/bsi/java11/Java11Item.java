package de.bsi.java11;

// TODO Use Record
public class Java11Item {
	
	private String name;
	
	private int id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Java11Item [name=" + name + ", id=" + id + "]";
	}

}
