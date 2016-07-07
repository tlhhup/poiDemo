package com.jtest.test;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class UserDaoTest {

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 50; i++) {
			//读取第一列--->类
			Class<?> clazz = Class.forName("com.jtest.action.UserDao");
			//读取第二列--->方法
			Method method = clazz.getDeclaredMethod("saveUser", Map.class);
			//读取第三列--->map对象
			// 数据
			Map<String, String> params = new HashMap<String, String>();
			params.put("1", "张三");
			params.put("2", "李四");
			
			//对象
			Object instance = clazz.newInstance();
			// 方法调用
			method.invoke(instance, params);
		}
	}

}
