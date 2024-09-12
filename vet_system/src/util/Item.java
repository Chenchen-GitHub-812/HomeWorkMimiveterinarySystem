package util;

import javax.swing.Icon;

public class Item {
	private String text;
	private Icon icon;
	public Item(String text, Icon icon) {
		super();
		this.text = text;
		this.icon = icon;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Icon getIcon() {
		return icon;
	}
	public void setIcon(Icon icon) {
		this.icon = icon;
	}
	

}
