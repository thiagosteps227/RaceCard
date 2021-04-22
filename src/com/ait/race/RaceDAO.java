package com.ait.race;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class RaceDAO {

    public List<Horse> findAll() {
        List<Horse> list = new ArrayList<Horse>();
        Connection c = null;
    	String sql = "SELECT * FROM card ORDER BY name";
        try {
            c = ConnectionHelper.getConnection();
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                list.add(processRow(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}
        return list;
    }

    public Horse findById(int id) {
    	String sql = "SELECT * FROM card WHERE id = ?";
    	Horse raceEntry = null;
        Connection c = null;
        try {
            c = ConnectionHelper.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                raceEntry = processRow(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}
        return raceEntry;
    }
    
    public Horse findByName(String name) {
        Horse raceEntry = null;
        Connection c = null;
    	String sql = "SELECT * FROM card as e " +
			"WHERE UPPER(name) LIKE ? " +	
			"ORDER BY name";
        try {
            c = ConnectionHelper.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, "%" + name.toUpperCase() + "%");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                raceEntry = processRow(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}
        return raceEntry;
    }
   
    protected Horse processRow(ResultSet rs) throws SQLException {
        Horse raceEntry = new Horse();
        raceEntry.setId(rs.getInt("id"));
        raceEntry.setName(rs.getString("name"));
        raceEntry.setTrainer(rs.getString("trainer"));
        raceEntry.setJockey(rs.getString("jockey"));
        raceEntry.setOwner(rs.getString("owner"));
        raceEntry.setBreeder(rs.getString("breeder"));
        raceEntry.setSire(rs.getString("sire"));
        raceEntry.setDam(rs.getString("dam"));
        raceEntry.setPicture(rs.getString("picture"));
        raceEntry.setAge(rs.getInt("age"));
        raceEntry.setBetting(rs.getString("betting"));
        return raceEntry;
    }
    
}
