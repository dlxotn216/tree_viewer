package com.taesu.test.spec.dto;

import java.util.List;

public class SpecForSelect {
	private String name;
	private Boolean open;
	private List<SpecForSelect> children;
	public List<SpecForSelect> getChildren() {
		return children;
	}
	public void setChildren(List<SpecForSelect> children) {
		this.children = children;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getOpen() {
		return open;
	}
	public void setOpen(Boolean open) {
		this.open = open;
	}
	
}
