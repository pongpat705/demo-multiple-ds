package org.maoz.training.app.repository;

import org.maoz.training.app.model.CityModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AppRepository {

    @Autowired
    @Qualifier("myDs")
    private DataSource myDs;

    public List<CityModel> findByCountryCode(String countryCode) throws SQLException {
        Connection connection = myDs.getConnection();

        StringBuilder sb = new StringBuilder();
        sb.append("  select id, name, countrycode, district, population  ");
        sb.append("  from city where CountryCode = ? ");
        PreparedStatement preparedStatement = connection.prepareStatement(sb.toString());
        preparedStatement.setString(1, countryCode);

        ResultSet resultSet = preparedStatement.executeQuery();
        List<CityModel> cityModelList = new ArrayList<>();
        while (resultSet.next()) {
            int col = 1;
            CityModel x = new CityModel();
            x.setId(resultSet.getLong(col++));
            x.setName(resultSet.getString(col++));
            x.setCountryCode(resultSet.getString(col++));
            x.setDistrict(resultSet.getString(col++));
            x.setPopulation(resultSet.getInt(col++));
            cityModelList.add(x);
        }

        return cityModelList;
    }
}
