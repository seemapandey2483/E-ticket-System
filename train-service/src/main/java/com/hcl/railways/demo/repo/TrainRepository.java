package com.hcl.railways.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.hcl.railways.demo.entity.Train;

@EnableJpaRepositories
public interface TrainRepository extends JpaRepository<Train, Long> {
    @Query("Select t from TrainInfo t where t.sourceStationId = :sourceStationId and  t.destStationId=:destStationId and t.noOfDays LIKE :day")
    Train findBySourceStationIdAndDestStationIdContainingAndNoOfDays(Long sourceStationId,Long destStationId,String day);
}