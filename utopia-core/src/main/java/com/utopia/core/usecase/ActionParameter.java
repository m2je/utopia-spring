package com.utopia.core.usecase;


public class ActionParameter {
	private ActionParameterTypes type;
	private int index;
	public ActionParameterTypes getType() {
		return type;
	}
	public void setType(ActionParameterTypes type) {
		this.type = type;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public ActionParameter(ActionParameterTypes type, int index) {
		super();
		this.type = type;
		this.index = index;
	}
	public ActionParameter(ActionParameterTypes type, long index) {
	this(type,(int)index);
	}
}
