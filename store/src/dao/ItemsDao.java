package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.Items;
import util.DBHelper;

public class ItemsDao {

	//获取所有商品信息
	public ArrayList<Items> getAllItems(){
		//在对数据库进行CRUD操作的时候，每一个操作都需要获取Connection对象
		Connection conn = null;
		
		//Statement的主要作用就是执行SQL语句并且返回它所生产的结果对象。Statement对象是通过Connection对象进行获取的，通过
		//Connection.createStatement()方法获取Statement对象。通过执行Statement对象的executeQuery()方法进行查询SQL。
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		ArrayList<Items> list = new ArrayList<Items>();//商品集合
		
		try{
			conn = DBHelper.getConnection();
			String sql="select * from items;";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				Items item=new Items(); 
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setCity(rs.getString("city"));
				item.setNumber(rs.getInt("number"));
				item.setPrice(rs.getInt("price"));
				item.setPicture(rs.getString("picture"));
				list.add(item);// 把一个商品加入集合
			}
			return list;
		}
		catch(Exception ex){
		   ex.printStackTrace();
		   return null;
		}
		finally{
			// 释放数据集对象
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			// 释放语句对象
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
}
