package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.Items;
import util.DBHelper;

public class ItemsDao {

	//��ȡ������Ʒ��Ϣ
	public ArrayList<Items> getAllItems(){
		//�ڶ����ݿ����CRUD������ʱ��ÿһ����������Ҫ��ȡConnection����
		Connection conn = null;
		
		//Statement����Ҫ���þ���ִ��SQL��䲢�ҷ������������Ľ������Statement������ͨ��Connection������л�ȡ�ģ�ͨ��
		//Connection.createStatement()������ȡStatement����ͨ��ִ��Statement�����executeQuery()�������в�ѯSQL��
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		ArrayList<Items> list = new ArrayList<Items>();//��Ʒ����
		
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
				list.add(item);// ��һ����Ʒ���뼯��
			}
			return list;
		}
		catch(Exception ex){
		   ex.printStackTrace();
		   return null;
		}
		finally{
			// �ͷ����ݼ�����
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			// �ͷ�������
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
