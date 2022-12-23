package com.zy.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.zy.model.User;

/**
 * ��¼��
 * 
 * @author �ﾺ������������
 *
 */
public class LoginConfig {
	/**
	 * �洢�û�������Ϣ
	 * 
	 * @param user
	 */
	public static void save(User user) {
		List<String> list = new ArrayList<>();
		list.add("name" + user.getUsername());
		list.add("pwd" + user.getPassword());
                list.add("uid"+user.getUserid());
		try {
			FileUtils.writeLines(new File("password.txt"), list);// ���û���Ϣд���ļ�
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ���û���Ϣ
	 */
	public static List<String> reader() {

		String str = "";
		try {
			str = FileUtils.readFileToString(new File("password.txt"), "GBK");
		} catch (IOException e) {
			e.printStackTrace();
		}
		String userName = subString(str, "name", "pwd");// ��ȡ�û���
		String password = subString(str, "pwd", "uid");// ��ȡ����
		// ��ȡ�û�Ȩ��id
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
		/* �ҳ�ָ����2���ַ��� ���ַ�������� λ�� */
		int strStartIndex = str.indexOf(strStart);
		int strEndIndex = str.indexOf(strEnd);

		/* index Ϊ���� ����ʾ���ַ����� û�и��ַ� */
		if (strStartIndex < 0) {
			return "�ַ��� :---->" + str + "<---- �в����� " + strStart + ", �޷���ȡĿ���ַ���";
		}
		if (strEndIndex < 0) {
			return "�ַ��� :---->" + str + "<---- �в����� " + strEnd + ", �޷���ȡĿ���ַ���";
		}
		/* ��ʼ��ȡ */
		String result = str.substring(strStartIndex, strEndIndex).substring(strStart.length());
		return result;
	}

	/**
	 * ɾ���ļ�(���˳�ϵͳʱ)
	 */
	public static void clean() {
		File file = new File("password.txt");
		if (!file.exists()) {
			System.out.println("�ļ���ɾ��");
		} else {
			file.delete();
		}

	}

	// ����
	public static void main(String[] args) {


	}
}
