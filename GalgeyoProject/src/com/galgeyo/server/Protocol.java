package com.galgeyo.server;

public interface Protocol {
	public static final boolean POST = true;
	public static final boolean GET = false;
<<<<<<< HEAD
<<<<<<< HEAD
	public static final byte LOGIN = 10;
	public static final byte REG_USER = 20;
	public static final byte REG_ID_CHECK = 21;
	public static final byte REG_MOD_USER = 22;
=======
=======
>>>>>>> HH
	public static final byte LOGIN = 3;
	public static final byte REG_USER = 4;
	public static final byte REG_ID_CHECK = 5;
	public static final byte REG_MOD_USER = 6;
<<<<<<< HEAD
>>>>>>> HH
=======
>>>>>>> HH
	public static final byte FIND_STORE = 30;
	public static final byte FIND_STORE_KR = 31;
	public static final byte FIND_STORE_JP = 32;
	public static final byte FIND_STORE_CN = 33;
	public static final byte FIND_MENU = 40;
}
