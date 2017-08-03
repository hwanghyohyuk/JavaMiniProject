package com.galgeyo.vo;

import java.io.Serializable;
import java.util.ArrayList;

public class StoreList implements Serializable {
private ArrayList<Manager> storeList;

public StoreList(ArrayList<Manager> storeList) {
	super();
	this.storeList = storeList;
}

public ArrayList<Manager> getStoreList() {
	return storeList;
}

public void setStoreList(ArrayList<Manager> storeList) {
	this.storeList = storeList;
}
}
