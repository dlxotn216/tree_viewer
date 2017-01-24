package com.taesu.test.tree.fancytree;

import java.util.List;

public class TreeNode {
	private Integer key;
	private String title;
	private Boolean folder;
	private List<TreeNode> children;
	public Integer getKey() {
		return key;
	}
	public void setKey(Integer key) {
		this.key = key;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Boolean getFolder() {
		return folder;
	}
	public void setFolder(Boolean folder) {
		this.folder = folder;
	}
	public List<TreeNode> getChildren() {
		return children;
	}
	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}
	
	
}
