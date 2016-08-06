package com.yuxiaoli.service;

import java.sql.Connection;
import java.sql.ResultSet;

import com.yuxiaoli.dao.UserDao;
import com.yuxiaoli.daoImpl.UserDaoImpl;
import com.yuxiaoli.domain.Customer;
import com.yuxiaoli.jdbcUtils.ConnectionFactory;

public class CheckUserService {
	private UserDao userDao=new UserDaoImpl();
	
	public boolean check(Customer user){
		Connection conn=null;
		System.out.println("=======");
		try {
			System.out.println("=======");
			conn = ConnectionFactory.getInstance().getConnection();
			conn.setAutoCommit(false);
			ResultSet rs=userDao.query(conn, user);
			while(rs.next()){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}finally{
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return false;
	}
}
