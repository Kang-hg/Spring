package spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;


public class MemberDao {
	
	private JdbcTemplate jdbcTemplate;
	private RowMapper<Member> memRowMapper =
			new RowMapper<Member>() {
				@Override
				public Member mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					// Member 객체를 생성 생성자에서 이메일, 패스워드, 이름, 날짜, 아이디 순으로 넣어서 객채를 생성
					Member member = new Member(rs.getString("EMAIL"),
							rs.getString("PASSWORD"),
							rs.getString("NAME"),
							rs.getTimestamp("REGDATE").toLocalDateTime());
					member.setId(rs.getLong("ID"));
					return member;
				}
			};
	
	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Member selectByEmail(String email)
	{
		List<Member> results = jdbcTemplate.query(
				"select * from MEMBER where EMAIL = ?",
				memRowMapper, email);
		
		return results.isEmpty() ? null : results.get(0);
	}
	
	// 생년월일 추가 후 email, password 검색
//	public Member selectByEmailPassword(String email, String password)
//	{
//		List<Member> results = jdbcTemplate.query(
//				"select * from MEMBER where EMAIL = ? and PASSWORD = ?",
//				new RowMapper<Member>() {
//					@Override
//					public Member mapRow(ResultSet rs, int rowNum)
//						throws SQLException 
//						{
//						Member member = new Member(
//								rs.getString("EMAIL"),
//								rs.getString("PASSWORD"),
//								rs.getString("NAME"),
//								rs.getTimestamp("REGDATE").toLocalDateTime(),
//								rs.getString("BIRTHDATE"));
//						member.setId(rs.getLong("ID"));
//						return member;
//						}
//				},
//				email, password);
//		return results.isEmpty() ? null : results.get(0);
//	}
	
	public int count()
	{
		Integer count = jdbcTemplate.queryForObject(
				"select count(*) from MEMBER", Integer.class);
		return count;
	}
	
	public void insert(Member member)
	{
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(
						"insert into MEMBER (EMAIL, PASSWORD, NAME, REGDATE, BIRTHDATE)"+
						"values (?, ?, ?, ?, ?)",
						new String[] {"ID"});
				pstmt.setString(1, member.getEmail());
				pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getName());
				pstmt.setTimestamp(4,
						Timestamp.valueOf(member.getRegisterDateTime()));
				pstmt.setString(5, member.getBirthdate());
				return pstmt;
			}
		}, keyHolder);
		Number keyValue = keyHolder.getKey();
		member.setId(keyValue.longValue());
	}
	
	public void update(Member member)
	{
		jdbcTemplate.update(
				"update MEMBER set NAME = ?, PASSWORD = ?, BIRTHDATE = ? where EMAIL = ?",
				member.getName(), member.getPassword(),member.getBirthdate(), member.getEmail());
	}
	
	public List<Member> selectAll()
	{
		List<Member> results = jdbcTemplate.query(
				"select * from MEMBER", memRowMapper);
		return results;
	}
	
	public List<Member> selectByRegdate(
						LocalDateTime from, LocalDateTime to)
	{	// DB에 쿼리문을 전송
		// DB의 결과를 List에 Member만 담을 수 있는 변수 result에 대입
		List<Member> result = jdbcTemplate.query(
			"select * from MEMBER where REGDATE between ? and ? "+
			"order by REGDATE desc",
			memRowMapper,
			from, to);
		// 나를 호출 한 곳으로 List<Member>의 값을 돌려준다.
		return result;
	}
	
	public Member selectById(Long memId)
	{	// Member 값을 List에 대입
		List<Member> results = jdbcTemplate.query(
				"select * from MEMBER where ID = ?",
				memRowMapper, memId);
		
		// results 값이 비어 있으면 null 리턴
		// 아니면 0번째 인덱스 값인 Member를 리턴
		// 0번에 값만 있을 수 밖에 없는 이유 => where ID = ? 같은 id Member를 확인
		// 기본키 이기 때문에 값이 1개일 수 밖에 없다.
		return results.isEmpty() ? null : results.get(0);
	}
	
	public int checkCount(String email, String pw)
	{
		String str = "select count(*) from MEMBER where EMAIL = '"+email+"' and PASSWORD = '" + pw +"'";
		Integer count = jdbcTemplate.queryForObject(str, Integer.class);
		return count;
	}
}





