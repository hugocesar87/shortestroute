package com.excersise.shortestroute.commons.util;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.excersise.shortestroute.route.dto.VertexEdgeDto;

public class BFSExploration {
	
	private Logger log = LoggerFactory.getLogger(BFSExploration.class);
	private Integer noVertices;
	private LinkedList<Integer> adjacencyNodeList[];
	private LinkedList<Integer> nodePathList;

	@SuppressWarnings("unchecked")
	BFSExploration(Integer vertexNumber) {
		this.noVertices = vertexNumber;
		this.adjacencyNodeList = new LinkedList[vertexNumber];
		for (int i = 0; i < vertexNumber; ++i) {
			adjacencyNodeList[i] = new LinkedList<Integer>();
		}
	}

	private void addEdge(Integer v, Integer w) {
		adjacencyNodeList[v].add(w);
	}

	private Boolean BFSalgorithm(Integer s, Integer destination, Integer[] pred) {
		
		boolean visited[] = new boolean[noVertices];
		for(int i=0; i < noVertices; i++) {
			pred[i] = -1;
		}

		LinkedList<Integer> queue = new LinkedList<Integer>();
		visited[s] = true;
		queue.add(s);

		while (queue.size() != 0) {
			
			s = queue.poll();
			Iterator<Integer> i = adjacencyNodeList[s].listIterator();
			while (i.hasNext()) {
				
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					pred[n] = s;
					queue.add(n);
					if (n == destination) {
						return Boolean.TRUE;
					}
				}
			}
		}
		return Boolean.FALSE;
	}

	private List<Integer> performBFSexploration(Integer source, Integer destination) {

		List<Integer> resultList = new LinkedList<Integer>();
		Integer[] pred = new Integer[noVertices];

		if (BFSalgorithm(source, destination, pred)) {
			buildNodePath(destination, pred);
			return buildSortedNodePath(resultList);
		}
		return resultList; //No route found.
	}

	private List<Integer> buildSortedNodePath(List<Integer> resultList) {
		log.debug("Shortest path length is {}", (nodePathList.size() - 1));
		for (int i = nodePathList.size() - 1; i >= 0; i--) {
			log.debug(nodePathList.get(i) + " ");
			resultList.add(nodePathList.get(i));
		}
		return resultList;
	}

	private void buildNodePath(Integer destination, Integer[] pred) {
		nodePathList = new LinkedList<Integer>();
		Integer index = destination;
		nodePathList.add(index);	
		while (pred[index] != -1) {
			nodePathList.add(pred[index]);
			index = pred[index];
		}
	}

	public static List<Integer> getShortestRoute(Integer vertexNumber, List<List<VertexEdgeDto>> vertexMatrix, Integer origin, Integer destination) {

		BFSExploration bfsExploration = new BFSExploration(vertexNumber);
		
		for(List<VertexEdgeDto> vertexValueList : vertexMatrix) {
			for(VertexEdgeDto vertexValue : vertexValueList) {
				bfsExploration.addEdge(vertexValue.getOrigin(), vertexValue.getDestination());
			}
		}
		return bfsExploration.performBFSexploration(origin, destination);
	}

}
