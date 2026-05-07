package com.jobportal;

import java.sql.*;

public class Company {

    public void postJob(String title, String description, int companyId) throws Exception {
        Connection con = DBConnection.getConnection();
        String query = "INSERT INTO jobs(title,description,company_id) VALUES(?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, title);
        ps.setString(2, description);
        ps.setInt(3, companyId);
        ps.executeUpdate();
        System.out.println("Job Posted Successfully!");
    }

    public void viewApplicants(int jobId) throws Exception {
        Connection con = DBConnection.getConnection();
        String query = "SELECT c.name FROM applications a JOIN candidates c ON a.candidate_id=c.id WHERE a.job_id=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, jobId);
        ResultSet rs = ps.executeQuery();

        while(rs.next()) {
            System.out.println("Applicant: " + rs.getString("name"));
        }
    }
}
