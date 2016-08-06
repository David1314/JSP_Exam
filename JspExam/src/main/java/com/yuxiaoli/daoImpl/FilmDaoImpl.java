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
		PreparedStatement ps=conn.prepareStatement("select film_id,title,description,language_id,name from film,language where film.language_id=language.language_id");
		ResultSet rs=ps.executeQuery();
		List<Film> filmList=new ArrayList<Film>();
		while(rs.next()){
			Film film=new Film();
			film.setFilm_id(rs.getInt(1));
			film.setTitle(rs.getString(2));
			film.setDescription(rs.getString(3));
			film.setLanguage_id(rs.getInt(4));
			film.setName(rs.getString(5));
			filmList.add(film);
		}
		return filmList;
	}

}
