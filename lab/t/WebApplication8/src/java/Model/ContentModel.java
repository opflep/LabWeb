/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Database.DBaccess;
import Entity.Content;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author Alpha 69
 */
public class ContentModel {
    DBaccess db ;

    public ContentModel() throws NamingException {
        db= new DBaccess();
    }
    public Content getContent() throws SQLException, Exception{
        Content c = new Content();
        String query = "select * from Info;";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setAddress(rs.getString("address"));
                c.setCity(rs.getString("city"));
                c.setCountry(rs.getString("country"));
                c.setTel(rs.getString("tel"));
                c.setEmail(rs.getString("email"));
                
                
            }
            db.closeConnection(rs, ps, conn);
            return c;
        } catch (Exception ex) {
            db.closeConnection(rs, ps, conn);
            throw ex;
        }
    }
}
