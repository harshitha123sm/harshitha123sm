package com.jobportal;

import java.sql.*;

public class Admin {

    public void viewAllCandidates() throws Exception {
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM candidates");

        while(rs.next()) {
            System.out.println(rs.getString("name") + " - " + rs.getString("email"));
        }
    }
}
