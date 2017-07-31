package com.galgeyo.model;

import java.util.HashMap;

import com.galgeyo.server.Protocol;
import com.galgeyo.vo.Manager;
import com.galgeyo.vo.Order;

public class UserMainModel implements Protocol {

	// 즐겨찾기 데이터 가져오기
	public HashMap<String, Manager> getFavorite() {
		return null;
	}

	// 최근주문내역 데이터 가져오기
	public HashMap<String, Order> getRecentlyOrder() {
		return null;
	}

	// 삭제 후 데이터 업데이트(즐겨찾기)
	public void updateFavoriteData(HashMap<String, Manager> updateFavorite) {

	}

	// 삭제 후 데이터 업데이트(최근주문내역)
	public void updateRecentlyData(HashMap<String, Order> updateOrder) {

	}

	// 주문한 메뉴 데이터 가져오기
	public Order getOrderData() {
		return null;
	}

}
