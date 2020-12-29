package com.hcl.railways.demo.repo;

import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.hcl.railways.demo.entity.Station;

@EnableJpaRepositories

public interface StationRepository extends JpaRepository<Station, Long> {
	public Station findByStationNameLike(String stationName);
	public List<Station> findByStationNameIn(Collection<String> stationNames);

}