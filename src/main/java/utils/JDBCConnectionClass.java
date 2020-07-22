package utils;

import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class JDBCConnectionClass {



    public static String connectToPriceWatchDBToGetEmailVerificationCode(String email) throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection("jdbc:sqlserver://192.168.1.61;user=sa;password=Kiddy791;database=PriceWatch");
        Statement sta = conn.createStatement();
        String sql = "select verificationCode from Users join EmailVerificationCode on Users.userId = EmailVerificationCode.userId where userEmail = '" + email + "'";
        ResultSet rs = sta.executeQuery(sql);
        String code = "";
        while (rs.next()) {
            code= rs.getString("verificationCode");
        }

        return code;
    }

}
