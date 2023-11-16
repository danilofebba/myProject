package org.mycompany.app;

import java.sql.*;

public class App {
	public static void main(String[] args) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:postgresql://192.168.0.10:5432/db_01", "user_01", "123456");

		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from public.tb_01 limit 10");
		
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		
		
		while (rs.next()) {
			String RowResult = "";
			for (int i = 1; i <= columnsNumber; i++) {
				if (RowResult == "") {
					RowResult = rs.getString(i);
				} else {
					RowResult +=  ";" + rs.getString(i);
				}	 
			}
			System.out.println(RowResult);
		}
		rs.close();
		st.close();
	}
}
