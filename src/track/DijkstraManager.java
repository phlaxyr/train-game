package track;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import track.large.TLNode;
import track.large.TLTrack1;

public class DijkstraManager {

	// nodes and edges are explored with a linkedlist-like field state thing
	
    private Set<TLNode> settledNodes;
    private Set<TLNode> unSettledNodes;
    private Map<TLNode, TLNode> predecessors;
//    private Map<TLNode, TLTrack1> trackToUse;
    private Map<TLNode, Float> distance;
    
    
    

//		this.nodes = nodes;
//		this.edges = edges;
		
//        trackToUse = new HashMap<TLNode, TLTrack1>();
	

	// copied from http://www.vogella.com/tutorials/JavaAlgorithmsDijkstra/article.html because i'm low on time
    // however I changed the class names to my classes
    // and i modified some methods like getneighbor to allow for 1-way shenanigans (hopefully)
	
	
	public void recalculate(TLNode source) {
        settledNodes = new HashSet<TLNode>();
        unSettledNodes = new HashSet<TLNode>();
        distance = new HashMap<TLNode, Float>();
        predecessors = new HashMap<TLNode, TLNode>();
        distance.put(source, 0F);
        unSettledNodes.add(source);
        while (unSettledNodes.size() > 0) {
            TLNode closest = getMinimum(unSettledNodes);
            settledNodes.add(closest);
            unSettledNodes.remove(closest);
            findMinimalDistances(closest);
            
//            System.out.println(Arrays.toString(settledNodes.toArray()));
//            System.out.println(Arrays.toString(unSettledNodes.toArray()));
//            System.out.println(Arrays.toString(predecessors.entrySet().toArray()));
        }
    }

    private void findMinimalDistances(TLNode node) {
        List<TLNode> adjacentNodes = getOutwardAdjacent(node); // modified here
        for (TLNode target : adjacentNodes) {
            if (getShortestDistance(target) > getShortestDistance(node)
                    + getDistance(node, target)) {
                distance.put(target, getShortestDistance(node)
                        + getDistance(node, target));
                predecessors.put(target, node);
//                trackToUse.put(target, getShortestTrack(node, target));
                unSettledNodes.add(target);
                // put in adjacent
            }
        }

    }

    private float getDistance(TLNode node, TLNode target) {
//        for (TLTrack edge : edges) {
//            if (edge.getSource().equals(node)
//                    && edge.getDestination().equals(target)) {
//                return edge.getWeight();
//            }
//        }
    	
        return getShortestTrack(node, target).distance();
    }
    
    private TLTrack1 getShortestTrack(TLNode node, TLNode target) {
    	if(node == null) return null;
    	if(target == null) return null;
    	TLTrack1 shortest = null;
    	for(TLTrack1 out : node.outwards()) {
    		if(out.to().equals(target)) {
    			if(shortest == null) {
    				shortest = out;
    			} else{
    				shortest = out.distance() < shortest.distance() ? out : shortest;
    		
    			}	
    		}
    	}
    	return shortest;
    }

//    private List<TLNode> getNeighbors(TLNode node) {
//        List<TLNode> neighbors = new ArrayList<TLNode>();
//        for (Edge edge : edges) {
//            if (edge.getSource().equals(node)
//                    && !isSettled(edge.getDestination())) {
//                neighbors.add(edge.getDestination());
//            }
//        }
//        return neighbors;
//    }
    private List<TLNode> getOutwardAdjacent(TLNode node) {
    	List<TLNode> n = new ArrayList<TLNode>();
    	for(TLTrack1 t : node.outwards()) {
    		n.add(t.to());
    	}
    	return n;
    }
    private List<TLNode> getInwardAdjacent(TLNode node) {
    	List<TLNode> n = new ArrayList<TLNode>();
    	for(TLTrack1 t : node.inwards()) {
    		n.add(t.from());
    	}
    	return n;
    }

    /**
     * Gets the node with the least known distance
     * @param nodes
     * @return
     */
    private TLNode getMinimum(Set<TLNode> nodes) {
        TLNode minimum = null;
        for (TLNode vertex : nodes) {
            if (minimum == null) {
                minimum = vertex;
            } else {
                if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
                    minimum = vertex;
                }
            }
        }
        return minimum;
        
    }

    private boolean isSettled(TLNode vertex) {
        return settledNodes.contains(vertex);
    }

    /**
     * The most short stored distance
     * @return
     */
    private float getShortestDistance(TLNode destination) {
        Float d = distance.get(destination);
        if (d == null) {
            return Float.MAX_VALUE;
        } else {
            return d;
        }
    }
    
    
    /**
     * This method returns the path from the source to the selected target and
     * NULL if no path exists
     * Made out of TLNodes
     */
    public List<TLNode> getPathNodes(TLNode target) {
        List<TLNode> path = new ArrayList<TLNode>();
        
        TLNode step = target;
        // check if a path exists
        if (predecessors.get(step) == null) {
            return null;
        }
        path.add(step);
        while (predecessors.get(step) != null) {
            step = predecessors.get(step);
            path.add(step);
        }
        // Put it into the correct order
        Collections.reverse(path);
        return path;
    }
    
    /**
     * Same thing as getPathNOdes(), but returns a path as a list of TLTrack1s
     */
    public List<TLTrack1> getPathTracks(TLNode target) {
    	
        List<TLTrack1> path = new ArrayList<TLTrack1>();
        
        TLNode step = target;
        // check if a path exists
        if (predecessors.get(step) == null) {
            return null;
        }
//        path.add(step);
        TLNode prev;
        while ((prev = predecessors.get(step)) != null) {
        	System.out.println("adding a track");
        	
            path.add(this.getShortestTrack(prev, step));
            step = prev;
        }
        // Put it into the correct order
        Collections.reverse(path);
        return path;
    }
}
