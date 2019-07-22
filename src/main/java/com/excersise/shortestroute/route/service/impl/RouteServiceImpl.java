package com.excersise.shortestroute.route.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.excersise.shortestroute.route.dao.RouteDao;
import com.excersise.shortestroute.route.dto.RouteDto;
import com.excersise.shortestroute.route.exception.DestinationNotFoundException;
import com.excersise.shortestroute.route.exception.NoRouteAvailableException;
import com.excersise.shortestroute.route.exception.OriginNotFoundException;
import com.excersise.shortestroute.route.model.Route;
import com.excersise.shortestroute.route.service.RouteService;
import com.excersise.shortestroute.route.util.ShortestRouteUtil;

@Service
public class RouteServiceImpl extends ShortestRouteUtil implements RouteService {

	private final Logger log = LoggerFactory.getLogger(RouteServiceImpl.class);
	private RouteDao routeDao;

	public RouteServiceImpl(RouteDao routeDao) {
		super();
		this.routeDao = routeDao;
	}

	@Override
	public List<String> getShortestPath(String origin, String destination) {

		validateOrigin(origin);
		validateDestination(destination);
		List<RouteDto> routeDtoList = new ArrayList<RouteDto>();
		for (Route routeItem : routeDao.findAll()) {
			routeDtoList.add(new RouteDto(routeItem.getOrigin(), routeItem.getDestination()));
		}
		return validateShortestList(findShortestRoute(origin, destination, routeDtoList));
	}
	
	private List<String> validateShortestList(List<String> shortestRouteList) {
		
		log.debug("Validating shortest route ...");
		if(shortestRouteList.isEmpty()) {
			throw new NoRouteAvailableException();
		}
		return shortestRouteList;
	}

	private void validateOrigin(String origin) {
		
		log.debug("Getting origin ...");
		Long originRoute = routeDao.findOrigin(origin);
		if (originRoute == 0) {
			throw new OriginNotFoundException();
		}
	}
	
	private void validateDestination(String destination) {
		
		log.debug("Getting destination ...");
		Long destinationRoute = routeDao.findDestination(destination);
		if (destinationRoute == 0) {
			throw new DestinationNotFoundException();
		}
	}

}
