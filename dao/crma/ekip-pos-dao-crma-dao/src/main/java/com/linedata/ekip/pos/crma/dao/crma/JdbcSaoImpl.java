package com.linedata.ekip.pos.crma.dao.crma;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.linedata.ekip.pos.dao.model.impl.Chiffrage;

@Component
public class JdbcSaoImpl {
	
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate = new JdbcTemplate(); 

/*	public Chiffrage getChiffrage(int chiffId){
		
		Connection conn = null;
		try{
	
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM chiffrage where id = ?");
			ps.setInt(1, chiffId);
			
			Chiffrage chiff = null;
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				chiff = new Chiffrage(chiffId, rs.getString("libelle"));
			}
			rs.close();
			ps.close();
			return chiff;
		}
		catch(Exception e){
			throw new RuntimeException(e);
		}
		finally{
			try{
				conn.close();
			}catch(SQLException s){
				
			}
		}
	}
*/	

	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate.setDataSource(dataSource);
	}
	
	public int getCountChiffrage(){
		String query = "SELECT COUNT(*) FROM chiffrage";
		return jdbcTemplate.queryForInt(query);
	}
	
	
	public String getChiffragename(int id){
		String query = "SELECT libelle FROM chiffrage WHERE id = ?";
		return jdbcTemplate.queryForObject(query, new Object[]{id}, String.class);
	}
	
	public Chiffrage getChiffrageById(int id){
		String query = "SELECT * FROM chiffrage WHERE id = ?";
		return jdbcTemplate.queryForObject(query,new Object[]{id}, new CircleMapper());
	}
	
	
	
	
	public void insertChiffrage(Chiffrage chiff){
		String query = "Insert INTO Chiffrage VALUES(?, ?)";
		jdbcTemplate.update(query, new Object[]{chiff.getId(), chiff.getLibelle()});
	}
	
	
	public List<Chiffrage> getAllChiffrage(){
		String query = "SELECT * FROM chiffrage";
		return jdbcTemplate.query(query, new CircleMapper());
	}
	
	
	
	private static final class CircleMapper implements RowMapper<Chiffrage>{

		@Override
		public Chiffrage mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Chiffrage chiffrage = new Chiffrage(resultSet.getInt("id"),resultSet.getString("libelle"));
			return chiffrage;
		}
		
	}
	

}
