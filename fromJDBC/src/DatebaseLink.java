import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatebaseLink {
    static final String driverName="org.gjt.mm.mysql.Driver";
    static final String dbUrl="jdbc:mysql://localhost:3306/test";
    static final String userName="root";
    static final String password="2652693155";
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL

        Connection conn = null;
        Statement stmt = null;
        try{
            // 注册 JDBC 驱动
            Class.forName(driverName);

            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(dbUrl,userName,password);

            // 执行查询
            System.out.println(" 实例化Statement对象...");
            stmt = (Statement) conn.createStatement();
            String sql;
            sql = "SELECT id, name, password, email FROM users";
            ResultSet rs = stmt.executeQuery(sql);

            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                String password = rs.getString("password");
                String email = rs.getString("email");
                // 输出数据
                System.out.print("ID: " + id);
                System.out.print(", 姓名: " + name);
                System.out.print(", 密码: " +password);
                System.out.print(", 邮箱: " +email);
                System.out.print("\n");
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}

