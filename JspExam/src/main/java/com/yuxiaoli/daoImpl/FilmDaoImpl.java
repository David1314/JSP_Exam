package com.yuxiaoli.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yuxiaoli.dao.FilmDao;
import com.yuxiaoli.domain.Film;

public class FilmDaoImpl implements FilmDao {

	public List<Film> queryAll(Connection conn) throws SQLException {
		PreparedStatement ps=conn.prepareStatement("select film_id,title,description,film.language_id,name from film,language where film.language_id=language.language_id");
		ResultSet rs=ps.executeQuery();
		List<Film> filmList=new ArrayList<Film>();
		while(rs.next()){
			Film film=new Film();
			film.setFilm_id(rs.getInt(1));
			film.setTitle(rs.getString(2));
			film.setDescription(rs.getString(3));
//			film.setLanguage_id(rs.getInt(4));
			film.setName(rs.getString(5));
			filmList.add(film);
		}
		rs.close();
		ps.close();
		return filmList;
	}

	public int addFilm(Connection conn, Film film) throws SQLException  {
		PreparedStatement ps=conn.prepareStatement("insert into film(title,description,language_id) values(?,?,?)");
		ps.setString(1, film.getTitle());
		ps.setString(2, film.getDescription());
		ps.setInt(3, film.getLanguage_id());
		int result=0;
		result = ps.executeUpdate();
		ps.close();
		return result;
	}

	public int deleteFilm(Connection conn, int film_id) throws SQLException {
		PreparedStatement ps=conn.prepareStatement("delete from film where film_id = ?");
		ps.setInt(1, film_id);
		int result=0;
		result = ps.executeUpdate();
		ps.close();
		return result;
	}


}
