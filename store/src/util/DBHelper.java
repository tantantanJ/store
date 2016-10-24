package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHelper {
    private static final String driver="com.mysql.jdbc.Driver";
    //连接数据库的URL地址,数据库的用户名,数据库的密码
    private static final String url="jdbc:mysql://localhost:3306/shopping?useUnicode=true&characterEncoding=UTF-8";
    private static final String username="root";
    private static final String password="090722ms";
	//在对数据库进行CRUD操作的时候，每一个操作都需要获取Connection对象
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
    
    //单例模式返回数据库连接对象
    //当调用getConnection静态方法的时候，static静态块会先执行，就会先加载驱动类Class.forName
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




//示例  下面的代码利用getConnection方法创建与MySQL数据库的连接，并返回连接对象,这是没有用单例模式的例子。
//public Connection getConnection(){
//    Connection con=null;
//     try{
//      Class.forName("com.mysql.jdbc.Driver");  //注册数据库驱动
//      String url="jdbc:mysql://localhost:3306/test?user=root&password=root";
//  //定义连接数据库的url
//      con=DriverManager.getConnection(url);   //获取数据库连接
//      System.out.println("数据库连接成功！");
//    }catch(Exception e){
//        e.printStackTrace();
//    }
//    return con;         //返回一个连接
//}
