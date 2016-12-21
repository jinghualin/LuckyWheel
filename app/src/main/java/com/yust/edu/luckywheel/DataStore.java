package com.yust.edu.luckywheel;

import java.util.ArrayList;

import android.content.Context;
import android.content.SharedPreferences;
/**
 * 用于存储数据的仓库
 * @author lin
 *
 */
public class DataStore {
	/**
	 * 获取共享数据，用于持久化程序数据
	 * 
	 * @param c
	 *            当前Context对象（Activity）
	 * @return SharedPreferences对象
	 */
	public static SharedPreferences getSharedPreferences(Context c) {
		return c.getSharedPreferences("data", 0);
	}

	/**
	 * 读取转盘项数据
	 * 
	 * @param c
	 *            当前Context对象（Activity）
	 * @return 转盘项数据列表
	 */
	public static ArrayList<String> readWheelItemsData(Context c) {
		SharedPreferences set = getSharedPreferences(c);
		ArrayList<String> l = new ArrayList<String>();
		for (int i = 0; i < 6; i++) {
			String s = set.getString("WheelItem" + i, null);
			if (s != null && s.length() > 0)
				l.add(s);
		}
		return l;
	}

	/**
	 * 保存转盘项数据
	 * 
	 * @param c
	 *            当前Context对象（Activity）
	 * @param li
	 *            转盘项数据列表
	 */
	public static void writeWheelItemsData(Context c, ArrayList<String> li) {
		SharedPreferences.Editor e = getSharedPreferences(c).edit();
		for (int i = 0; i < li.size(); i++) {
			e.putString("WheelItem" + i, li.get(i));
		}
		e.commit();
	}

	
}
