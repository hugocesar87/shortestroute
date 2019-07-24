package com.exercise.shortestroute.web.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.shortestroute.commons.constants.ShortestRouteConstants;
import com.exercise.shortestroute.route.service.RouteService;
import com.exercise.shortestroute.web.dto.commons.ResponseDto;

@RestController
@RequestMapping("shortestroute/route")
@Validated
public class RouteController {

	private final Logger log = LoggerFactory.getLogger(RouteController.class);
	private RouteService routeService;
	
	public RouteController(RouteService routeService) {
		super();
		this.routeService = routeService;
	}

	@GetMapping("get")
	public ResponseDto<List<String>> getRoute(
			@Valid
			@RequestParam(name = "origin") 
			@NotBlank(message = "Origin is mandatory.") 
			@Size(min = 3, max = 3, message = "Origin length must be 3.") 
			String origin,
			@Valid
			@RequestParam(name = "destination") 
			@NotBlank(message = "Destination is mandatory.") 
			@Size(min = 3, max = 3, message = "Destination length must be 3.") 
			String destination) {

		log.debug("Message received. origin {}, destination {}", origin, destination);

		return new ResponseDto<List<String>>(ResponseDto.NOT_ERROR, ShortestRouteConstants.RESULT_CODE_SUCCESS,
				ShortestRouteConstants.RESULT_MSG_SUCCESS, routeService.getShortestPath(origin, destination));

	}
}
