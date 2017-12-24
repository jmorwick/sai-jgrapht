package net.sourcedestination.sai.jgrapht.graph;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import com.google.common.collect.HashMultimap;
import net.sourcedestination.sai.graph.Feature;
import org.jgrapht.graph.DirectedMultigraph;
import com.google.common.collect.Multimap;

public class JgtGraph extends DirectedMultigraph<Integer, Integer>
	implements net.sourcedestination.sai.graph.Graph {
	private final Set<Feature> features = new HashSet<>();
	private final Multimap nodeFeatures = HashMultimap.create();
	private final Multimap edgeFeatures = HashMultimap.create();

	public JgtGraph(Feature... features) {
		super(Integer.class);
		for(net.sourcedestination.sai.graph.Feature f : features)
			this.features.add(f);
	}

	@Override
	public Stream<Integer> getEdgeIDs() {
		return edgeSet().stream();
	}

	@Override
	public Stream<Integer> getNodeIDs() {
		return vertexSet().stream();
	}

	public void addNodeFeature(int nid, Feature f) {
		nodeFeatures.put(nid, f);
	}

	@Override
	public Stream<Feature> getNodeFeatures(int n) {
		return nodeFeatures.get(n).stream();
	}

	public void addEdgeFeature(int eid, Feature f) {
		edgeFeatures.put(eid, f);
	}

	@Override
	public Stream<Feature> getEdgeFeatures(int e) {
		return nodeFeatures.get(e).stream();
	}

	@Override
	public int getEdgeSourceNodeID(int edgeID) {
		return getEdgeSource(edgeID);
	}

	@Override
	public int getEdgeTargetNodeID(int edgeID) {
		return getEdgeTarget(edgeID);
	}

	public void addFeature(Feature f) {
		features.add(f);
	}

	@Override
	public Stream<Feature> getFeatures() {
		return features.stream();
	}
}
