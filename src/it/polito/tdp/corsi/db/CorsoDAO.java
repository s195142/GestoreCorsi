package it.polito.tdp.corsi.db;

import java.sql.*;
import java.sql.SQLException;
import java.util.*;

import it.polito.tdp.corsi.model.Corso;

public class CorsoDAO {

	public List<Corso> listAll(int periodo) {
		String sql = "SELECT * FROM corso";
		List<Corso> risultato = new LinkedList<Corso>();
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				Corso c = new Corso(rs.getString("codins"), rs.getInt("crediti"), rs.getString("nome"), rs.getInt("pd"));
				
				risultato.add(c);
			}
			conn.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		return risultato;
	}

	public List<Corso> listCorsiByPD(int periodo) {
		String sql = "SELECT * FROM corso WHERE pd = ?";
		List<Corso> result = new LinkedList<Corso>();
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, periodo);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				Corso c = new Corso(rs.getString("codins"),
						rs.getInt("crediti"),
						rs.getString("nome"),
						rs.getInt("pd"));
				
				result.add(c);
			}
			
			conn.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return result;
	}

	public Map<String, Integer> getIscrittiCorsi(int periodo) {
		String sql = "SELECT c.codins, c.nome, COUNT(*) AS tot " + 
				"FROM corso AS c, iscrizione AS i "+
				"WHERE c.codins = i.codins AND c.pd = ? "+
				"GROUP BY c.codins, c.nome";
		Map<String, Integer> result = new HashMap<String, Integer>();
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, periodo);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				result.put(rs.getString("nome"), rs.getInt("tot"));
			}
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		return result;
	}

}
