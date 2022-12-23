package com.zy.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.zy.model.User;

/**
 * 登录类
 * 
 * @author 物竞天择适者生存
 *
 */
public class LoginConfig {
	/**
	 * 存储用户密码信息
	 * 
	 * @param user
	 */
	public static void save(User user) {
		List<String> list = new ArrayList<>();
		list.add("name" + user.getUsername());
		list.add("pwd" + user.getPassword());
                list.add("uid"+user.getUserid());
		try {
			FileUtils.writeLines(new File("password.txt"), list);// 把用户信息写入文件
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 读用户信息
	 */
	public static List<String> reader() {

		String str = "";
		try {
			str = FileUtils.readFileToString(new File("password.txt"), "GBK");
		} catch (IOException e) {
			e.printStackTrace();
		}
		String userName = subString(str, "name", "pwd");// 获取用户名
		String password = subString(str, "pwd", "uid");// 获取密码
		// 获取用户权限id
		int index = str.indexOf("uid");
//		String userid = str.substring(indexOf2);
//		String uid = userid.substring(3);
		String uid = str.substring(index + 3);
		List<String> list = new ArrayList<>();
		list.add(userName.trim());
		list.add(password.trim());
		list.add(uid.trim());
		return list;
	}

	public static String subString(String str, String strStart, String strEnd) {
		/* 找出指定的2个字符在 该字符串里面的 位置 */
		int strStartIndex = str.indexOf(strStart);
		int strEndIndex = str.indexOf(strEnd);

		/* index 为负数 即表示该字符串中 没有该字符 */
		if (strStartIndex < 0) {
			return "字符串 :---->" + str + "<---- 中不存在 " + strStart + ", 无法截取目标字符串";
		}
		if (strEndIndex < 0) {
			return "字符串 :---->" + str + "<---- 中不存在 " + strEnd + ", 无法截取目标字符串";
		}
		/* 开始截取 */
		String result = str.substring(strStartIndex, strEndIndex).substring(strStart.length());
		return result;
	}

	/**
	 * 删除文件(当退出系统时)
	 */
	public static void clean() {
		File file = new File("password.txt");
		if (!file.exists()) {
			System.out.println("文件已删除");
		} else {
			file.delete();
		}

	}

	// 测试
	public static void main(String[] args) {


	}
}
