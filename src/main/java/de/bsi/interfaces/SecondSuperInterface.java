package de.bsi.interfaces;

public sealed interface SecondSuperInterface permits RegularInterface {
	
	String CONSTANT_C = "exists also in other interface";
	
	public abstract void test();
	
}
