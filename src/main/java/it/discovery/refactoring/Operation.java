package it.discovery.refactoring;

public class Operation {
	
	private String name;
	private String firstOp;
	private String secondOp;
	private String scale;
	private String toConsole;
	
	

	public Operation(String name, String firstOp, String secondOp, String scale, String toConsole) {
		super();
		this.name = name;
		this.firstOp = firstOp;
		this.secondOp = secondOp;
		this.scale = scale;
		this.toConsole = toConsole;
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

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getToConsole() {
		return toConsole;
	}

	public void setToConsole(String toConsole) {
		this.toConsole = toConsole;
	}
	
	
}
