package com.mint.assestment.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mint.assestment.model.Tracker;

@Repository
public interface TrackerRepository extends JpaRepository<Tracker, Long> {

	public Optional<Tracker> findBybankIdentificationNumber(String bankIdentificationNumber);

	@Query(value = "select * from tracker LIMIT ?1 OFFSET ?2", nativeQuery = true)
	public List<Tracker> getAllTracker(int limit,int offset);

}
