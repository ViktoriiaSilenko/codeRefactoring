package it.discovery.refactoring;

public class Operation {
	
	private String name;
	private String firstOp;
	private String secondOp;
	
	public Operation(String name, String firstOp, String secondOp) {
		this.name = name;
		this.firstOp = firstOp;
		this.secondOp = secondOp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstOp() {
		return firstOp;
	}

	public void setFirstOp(String firstOp) {
		this.firstOp = firstOp;
	}

	public String getSecondOp() {
		return secondOp;
	}

	public void setSecondOp(String secondOp) {
		this.secondOp = secondOp;
	}
}
