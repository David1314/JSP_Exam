package com.yuxiaoli.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yuxiaoli.dao.UserDao;
import com.yuxiaoli.domain.Customer;

public class UserDaoImpl implements UserDao {

	public ResultSet query(Connection conn, Customer user) throws SQLException {
		//System.out.println("======");
		PreparedStatement ps=conn.prepareStatement("select * from customer where first_name=? ");
		ps.setString(1, user.getFirst_name());
		
		return ps.executeQuery();
	}

}
