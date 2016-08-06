package com.yuxiaoli.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yuxiaoli.domain.Customer;


public interface UserDao {
	public ResultSet query(Connection conn,Customer user) throws SQLException;
}
