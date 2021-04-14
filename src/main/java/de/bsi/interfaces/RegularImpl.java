package de.bsi.interfaces;

public class RegularImpl implements RegularInterface {
	
	public static void main(String args[]) {
		new RegularImpl().test();
	}

	@Override
	public void test() {
		System.out.println("Constants: %s ; %s ; %s".formatted(CONSTANT_A, CONSTANT_B, SecondSuperInterface.CONSTANT_C));
		System.out.println("Overwritten default method: " + readSomething());
		System.out.println(RegularInterface.addInfo("..."));
		
	}
	
	@Override
	public String readSomething() {
		return "overwritten default method";
	}
	

}
