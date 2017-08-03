package com.galgeyo.vo;

import java.util.ArrayList;

public class Arraylist {
private ArrayList<Menu> arrayList;

public Arraylist(ArrayList<Menu> menulist) {
	super();
	this.arrayList = menulist;
}

public ArrayList<Menu> getArrayList() {
	return arrayList;
}

public void setArrayList(ArrayList<Menu> arrayList) {
	this.arrayList = arrayList;
}

}
