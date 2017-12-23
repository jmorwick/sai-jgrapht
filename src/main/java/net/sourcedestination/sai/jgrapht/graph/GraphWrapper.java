package net.sourcedestination.sai.jgrapht.graph;

import net.sourcedestination.sai.graph.Feature;
import org.jgrapht.graph.DirectedMultigraph;

import java.util.stream.Stream;

/**
 * Created by jmorwick on 12/23/17.
 */
public class GraphWrapper extends DirectedMultigraph<Integer,Integer> implements net.sourcedestination.sai.graph.Graph {

    public GraphWrapper() {
        super(Integer.class);
    }

    public Stream<Integer> getEdgeIDs() {
        return edgeSet().stream();
    }

    public Stream<Integer> getNodeIDs() {
        return vertexSet().stream();
    }

    public Stream<net.sourcedestination.sai.graph.Feature> getFeatures() {
        return null;
    }

    public Stream<net.sourcedestination.sai.graph.Feature> getNodeFeatures(int n) {
        return null;
    }

    public Stream<Feature> getEdgeFeatures(int e) {
        return null;
    }

    public int getEdgeSourceNodeID(int edgeID) {
        return 0;
    }

    public int getEdgeTargetNodeID(int edgeID) {
        return 0;
    }
}
