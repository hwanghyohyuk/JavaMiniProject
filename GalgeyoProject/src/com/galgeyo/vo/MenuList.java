package com.galgeyo.vo;

import java.io.Serializable;
import java.util.ArrayList;

public class MenuList implements Serializable {
private ArrayList<Menu> menuList;

public MenuList(ArrayList<Menu> menuList) {
	super();
	this.menuList = menuList;
}

public ArrayList<Menu> getMenuList() {
	return menuList;
}

public void setMenuList(ArrayList<Menu> menuList) {
	this.menuList = menuList;
}
}
