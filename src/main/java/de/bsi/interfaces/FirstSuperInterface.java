package de.bsi.interfaces;

abstract interface FirstSuperInterface {
	
	String CONSTANT_A = "public static final is set implicit";
	final String CONSTANT_B = "public static is set implicit";
	static final String CONSTANT_C = "public is set implicit";
	public static final String CONSTANT_D = "All modifiers set explicit";
	
	void test();
	
	default String readSomething() {
		return reading();
	}
	
	private String reading() {
		return "private method called by default method.";
	}

}
