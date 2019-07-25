package com.exercise.shortestroute.web.controller;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.exercise.shortestroute.route.exception.DestinationNotFoundException;
import com.exercise.shortestroute.route.exception.NoRouteAvailableException;
import com.exercise.shortestroute.route.exception.OriginNotFoundException;
import com.exercise.shortestroute.route.service.RouteService;
import com.exercise.shortestroute.web.dto.commons.ResponseDto;

@RunWith(MockitoJUnitRunner.class)
public class RouteControllerTest {
	
	@Mock 
	private RouteService routeService;
	@InjectMocks 
	private RouteController routeController;
	
	@Test
	public void verifyRouteWhenPathExistBetweenOriginAndDestination() {
		
		String origin = "YYZ";
		String destination = "YVR";
		List<String> routeList = new ArrayList<String>();
		routeList.add("YYZ");
		routeList.add("LAX");
		routeList.add("YVR");
		
		when(routeService.getShortestPath(origin, destination)).thenReturn(routeList);
		
		//test
		ResponseDto<List<String>> routeResponse = routeController.getRoute(origin, destination);
		
		assertNotNull(routeResponse);
		assertNotNull(routeResponse.getResponse());
		assertTrue(routeResponse.getResponse().size() > 0);
		verify(routeService, times(1)).getShortestPath(origin, destination);
	}
	
	@Test(expected = NoRouteAvailableException.class)
	public void verifyNoRouteAvailableExceptionWhenRouteDoesNotExits() {
		
		String origin = "IVR";
		String destination = "BJX";
		
		when(routeService.getShortestPath(origin, destination)).thenThrow(new NoRouteAvailableException());
		
		//test
		routeController.getRoute(origin, destination);
		verify(routeService, times(1)).getShortestPath(origin, destination);
	}
	
	@Test(expected = OriginNotFoundException.class)
	public void verifyOriginNotFoundExceptionWhenOriginIsInvalid() {
		
		String origin = "KKK";
		String destination = "LAX";
		
		when(routeService.getShortestPath(origin, destination)).thenThrow(new OriginNotFoundException());
		
		//test
		routeController.getRoute(origin, destination);
		verify(routeService, times(1)).getShortestPath(origin, destination);
	}
	
	@Test(expected = DestinationNotFoundException.class)
	public void verifyDestinationNotFoundExceptionWhenDestinationIsInvalid() {
		
		String origin = "LAX";
		String destination = "KKK";
		
		when(routeService.getShortestPath(origin, destination)).thenThrow(new DestinationNotFoundException());
		
		//test
		routeController.getRoute(origin, destination);
		verify(routeService, times(1)).getShortestPath(origin, destination);
	}
	
}
