package org.maoz.training.app.repository;

import org.maoz.training.app.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    List<City> findByCountryCode(String countryCode);
}
