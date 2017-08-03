package com.galgeyo.vo;

import java.io.Serializable;
import java.util.ArrayList;

public class Arraylist implements Serializable {
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
