package com.exercise.shortestroute.route.util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.exercise.shortestroute.commons.util.BFSExploration;
import com.exercise.shortestroute.route.dto.RouteDto;
import com.exercise.shortestroute.route.dto.VertexEdgeDto;

public abstract class ShortestRouteUtil {

	private Logger log = LoggerFactory.getLogger(ShortestRouteUtil.class);

	public List<String> findShortestRoute(String originRequest, String destinationRequest, List<RouteDto> routeDtoList) {

		List<String> resultList = new LinkedList<String>();
		Set<String> vertexList = buildVertexList(routeDtoList);
		Map<String, Integer> vertexMap = buildVertexMap(vertexList);
		List<List<VertexEdgeDto>> matrixVertexList = buildVertexMatrix(routeDtoList, vertexMap);
		List<Integer> bfsExplorationResults = executeBfsExploration(originRequest, destinationRequest, vertexMap,
				matrixVertexList, vertexList.size());
		return getResultFromBfsExploration(resultList, bfsExplorationResults, vertexList);
	}

	private List<String> getResultFromBfsExploration(List<String> resultList, List<Integer> graphResults, Set<String> vertexList) {
		
		if (graphResults.isEmpty()) {
			log.debug("No Route Found!");
			return resultList;
		}
		log.debug("Shortest path: ");
		List<String> availableVertexList = new ArrayList<String>(vertexList);
		for (Integer result : graphResults) {
			log.debug("-> {} ", availableVertexList.get(result));
			resultList.add(availableVertexList.get(result));
		}
		return resultList;
	}

	private List<Integer> executeBfsExploration(String originRequest, String destinationRequest,
			Map<String, Integer> vertexMap, List<List<VertexEdgeDto>> matrixVertexList, Integer vertexListSize ) {
		
		Integer origin = vertexMap.get(originRequest) == null ? -1 : vertexMap.get(originRequest);
		Integer destination = vertexMap.get(destinationRequest) == null ? -1 : vertexMap.get(destinationRequest);
		List<Integer> graphResults = BFSExploration.getShortestRoute(vertexListSize, matrixVertexList, origin,
				destination);
		return graphResults;
	}

	private List<List<VertexEdgeDto>> buildVertexMatrix(List<RouteDto> routeDtoList, Map<String, Integer> vertexMap) {
		
		List<List<VertexEdgeDto>> matrixVertexList = new LinkedList<List<VertexEdgeDto>>();
		List<VertexEdgeDto> valueVertexList;
		for (RouteDto item : routeDtoList) {
			valueVertexList = new LinkedList<VertexEdgeDto>();
			valueVertexList
					.add(new VertexEdgeDto(vertexMap.get(item.getOrigin()), vertexMap.get(item.getDestination())));
			matrixVertexList.add(valueVertexList);
		}
		return matrixVertexList;
	}

	private Map<String, Integer> buildVertexMap(Set<String> vertexList) {
		
		Map<String, Integer> vertexMap = new LinkedHashMap<String, Integer>();
		Integer counter = 0;
		for (String vertex : vertexList) {
			vertexMap.put(vertex, counter);
			counter++;
		}
		return vertexMap;
	}

	private Set<String> buildVertexList(List<RouteDto> routesList) {
		
		Set<String> vertexList = new LinkedHashSet<String>();
		for (RouteDto item : routesList) {
			vertexList.add(item.getOrigin());
			vertexList.add(item.getDestination());
		}
		return vertexList;
	}

}
