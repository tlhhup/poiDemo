package com.jtest.test;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class UserDaoTest {

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 50; i++) {
			//��ȡ��һ��--->��
			Class<?> clazz = Class.forName("com.jtest.action.UserDao");
			//��ȡ�ڶ���--->����
			Method method = clazz.getDeclaredMethod("saveUser", Map.class);
			//��ȡ������--->map����
			// ����
			Map<String, String> params = new HashMap<String, String>();
			params.put("1", "����");
			params.put("2", "����");
			
			//����
			Object instance = clazz.newInstance();
			// ��������
			method.invoke(instance, params);
		}
	}

}
