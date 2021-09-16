package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import spring.RegisterData;

public class NewDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public NewDao(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void insert(RegisterData rd)
	{
		// 쿼리문 실행
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(
						"insert into testtable (id, password, name, sung, homeNumber, telNumber, email)"+
						"values (?, ?, ?, ?, ?, ?, ?)");
				pstmt.setString(1, rd.getId());
				pstmt.setString(2, rd.getPassword());
				pstmt.setString(3, rd.getName());
				pstmt.setString(4, rd.getSung());
				pstmt.setString(5, rd.getHomeNumber());
				pstmt.setString(6, rd.getTelNumber());
				pstmt.setString(7, rd.getEmail());
				// 생성한 PreparedStatement 객체 리턴
				return pstmt;
			}
		});
	}
	
	public int checkCount(String id, String pw)
	{
		String str = "select count(*) from testtable where id = '"+id+"' and password = '" + pw +"'";
		Integer count = jdbcTemplate.queryForObject(str, Integer.class);
		return count;
	}
}
