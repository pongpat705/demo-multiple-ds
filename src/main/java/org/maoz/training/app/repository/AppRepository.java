package org.maoz.training.app.repository;

import org.maoz.training.app.model.CityModel;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class AppRepository {

    private JdbcTemplate jdbcTemplate;

    public AppRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<CityModel> findByCriteria(Map<String, Object> citeria) throws SQLException {

        List<Object> params = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("  select id, name, countrycode, district, population  ");
        sb.append("  from city where 1=1 ");

        if(citeria.containsKey("countryCode")) {
            sb.append("  and CountryCode = ? ");
            params.add(citeria.get("countryCode"));
        }
        if(citeria.containsKey("name")) {
            sb.append("  and Name like ? ");
            params.add(citeria.get("name") + "%");
        }


        System.out.println(sb.toString());

        List<CityModel> result = jdbcTemplate.query(sb.toString(), params.toArray(), new RowMapper<CityModel>() {
            @Override
            public CityModel mapRow(ResultSet resultSet, int i) throws SQLException {
                int col = 1;
                CityModel x = new CityModel();
                x.setId(resultSet.getLong(col++));
                x.setName(resultSet.getString(col++));
                x.setCountryCode(resultSet.getString(col++));
                x.setDistrict(resultSet.getString(col++));
                x.setPopulation(resultSet.getInt(col++));
                return x;
            }
        });

        return result;
    }
}
