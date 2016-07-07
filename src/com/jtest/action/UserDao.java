package com.jtest.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.jtest.entity.User;


public class UserDao {

	public void saveUser(Map<?, ?> params){
		System.out.println("saveUser");
		for(Entry<?,?> entry:params.entrySet()){
			System.out.println("key:"+entry.getKey()+" value:"+entry.getValue());
		}
	}
	
	public void deleteUser(String name,int id){
		
	}
	
	public List<User> queryAll(){
		String url="jdbc:mysql://127.0.0.1:3306/bms";
		String userDb="admin";
		String password="123456";
		
		List<User> results=new ArrayList<User>();
		User user=null;
		
		Connection connection=null;
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			connection=DriverManager.getConnection(url, userDb, password);
			
			String sql="SELECT * from users";
			statement=connection.prepareStatement(sql);
			//Ö´ÐÐÓï¾ä
			resultSet=statement.executeQuery();
			while(resultSet.next()){
				int id = resultSet.getInt("id");
				String userName=resultSet.getString("userName");
				String pwd=resultSet.getString("password");
				String realName=resultSet.getString("realName");
				
				user=new User(id, userName, pwd, realName);
				results.add(user);
				user=null;
			}
			return results;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet!=null){
					resultSet.close();
				}
				if(statement!=null){
					statement.close();
				}
				if(connection!=null){
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
}
