package com.exercise.shortestroute.route.service;

import java.util.List;

public interface RouteService {
	
	List<String> getShortestPath(String origin, String destination);

}
