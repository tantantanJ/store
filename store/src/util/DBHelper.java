package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHelper {
    private static final String driver="com.mysql.jdbc.Driver";
    //�������ݿ��URL��ַ,���ݿ���û���,���ݿ������
    private static final String url="jdbc:mysql://localhost:3306/shopping?useUnicode=true&characterEncoding=UTF-8";
    private static final String username="root";
    private static final String password="090722ms";
    private static Connection conn=null ;
    
    //Class.forname(driver)�����������class�ļ����ڴ棬�����γ�һ��������������ṹ��Class��ʵ�������ҳ�ʼ����������
    static{
    	try{
    		Class.forName(driver);
    	}
    	catch(Exception ex){
    		ex.printStackTrace();
    	}
    }
    
    //����ģʽ�������ݿ����Ӷ���,���Connection conn= DriverManager.getConnection(url)
    public static Connection getConnection() throws Exception{
    	if(conn==null){
    		conn=DriverManager.getConnection(url,username,password);
    		return conn;
    	}
    	else{
    		return conn;
    	}
    }

}
