package com.excersise.shortestroute.route.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.excersise.shortestroute.route.model.Route;

public interface RouteDao extends JpaRepository<Route, Long> {

	@Query(value = " SELECT count(route) " +
			   " FROM Route route " +
			   " WHERE route.origin = :origin")
	Long findOrigin(@Param("origin")String origin);
	
	@Query(value = " SELECT count(route) " +
			   " FROM Route route " +
			   " WHERE route.destination = :destination")
	Long findDestination(@Param("destination")String origin);

}
