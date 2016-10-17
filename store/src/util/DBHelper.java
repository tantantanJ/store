package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHelper {
    private static final String driver="com.mysql.jdbc.Driver";
    //连接数据库的URL地址,数据库的用户名,数据库的密码
    private static final String url="jdbc:mysql://localhost:3306/shopping?useUnicode=true&characterEncoding=UTF-8";
    private static final String username="root";
    private static final String password="090722ms";
    private static Connection conn=null ;
    
    //Class.forname(driver)加载驱动类的class文件到内存，并且形成一个描述此驱动类结构的Class类实例，并且初始化此驱动类
    static{
    	try{
    		Class.forName(driver);
    	}
    	catch(Exception ex){
    		ex.printStackTrace();
    	}
    }
    
    //单例模式返回数据库连接对象,理解Connection conn= DriverManager.getConnection(url)
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
