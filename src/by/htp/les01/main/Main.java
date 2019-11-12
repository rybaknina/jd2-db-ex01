package by.htp.les01.main;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try{
            Class.forName("org.gjt.mm.mysql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/jd2_ex01?useSSL=false","root","123456");
            st = con.createStatement();
            rs = st.executeQuery("select * from users");
            while (rs.next()){
                System.out.printf("%4d %10s %10s %20s",rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString("email"));
                System.out.println();
            }
        }
        finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e){
                // log
            }
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e){
                // log
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                // log
            }

        }
    }
}
