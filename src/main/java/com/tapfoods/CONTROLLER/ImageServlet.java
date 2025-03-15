package com.tapfoods.CONTROLLER;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tapfoods.DBUtils.DBUtils;

@WebServlet("/ImageServlet")
public class ImageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ServletOutputStream outStream = response.getOutputStream();

        try {
            
    			con=DBUtils.connect();
    		
            // Get restaurant ID from request
            String restaurantId = request.getParameter("id");
           // System.out.println(restaurantId);
            String sql = "SELECT imagePath FROM restaurant WHERE restaurantId=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, restaurantId);
            rs = ps.executeQuery();

            if (rs.next()) {
                Blob blob = rs.getBlob("imagePath");
                byte[] imageBytes = blob.getBytes(1, (int) blob.length());

                // Set response type
                response.setContentType("image/jpeg");
                outStream.write(imageBytes);
                //System.out.println("controlllllllllllllllllllllll");
                outStream.flush();
            } else {
                response.getWriter().write("No Image Found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}
