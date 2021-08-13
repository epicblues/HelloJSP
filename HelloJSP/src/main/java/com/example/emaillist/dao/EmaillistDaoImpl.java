package com.example.emaillist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.emaillist.vo.EmailVO;
public class EmaillistDaoImpl implements EmaillistDao {

	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","c##bituser","bituser");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	
	@Override
	public List<EmailVO> getList() {
		List<EmailVO> list = new ArrayList<EmailVO>();
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			st = conn.createStatement();
			String query = "SELECT * FROM emaillist ORDER BY no";
			rs = st.executeQuery(query);
			while(rs.next()) {
				EmailVO vo = new EmailVO();
				vo.setNo(rs.getLong(1));
				vo.setLastName(rs.getString(2));
				vo.setFirstName(rs.getString(3));
				vo.setEmail(rs.getString(4));
				vo.setCreatedAt(rs.getDate(5));
				list.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return list;
	}

	@Override
	public int insert(EmailVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = getConnection();
			String query = "INSERT INTO emaillist "
					+ "VALUES(seq_emaillist_pk.nextval, ?,?,?,DEFAULT)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getLastName());
			pstmt.setString(2, vo.getFirstName());
			pstmt.setString(3, vo.getEmail());
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}

	@Override
	public int delete(Long pk) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = getConnection();
			String query = "DELETE FROM emaillist "
					+ "WHERE no = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setLong(1, pk);
			
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}

}
