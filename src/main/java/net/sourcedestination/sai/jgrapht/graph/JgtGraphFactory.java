package net.sourcedestination.sai.jgrapht.graph;

import net.sourcedestination.sai.graph.*;

/**
 * Created by jmorwick on 12/23/17.
 */
public class JgtGraphFactory implements GraphFactory<JgtGraph> {

    @Override
    public JgtGraph copy(net.sourcedestination.sai.graph.Graph g) {
        JgtGraph g2 = new JgtGraph();
        g.getFeatures().forEach(f -> {
            g2.addFeature(f);
        });
        g.getNodeIDs().forEach(nid -> {
            g2.addVertex(nid);
            g.getNodeFeatures(nid).forEach(f -> {
                g2.addNodeFeature(nid, f);
            });
        });
        g.getEdgeIDs().forEach(eid -> {
            g2.addEdge(g.getEdgeSourceNodeID(eid), g.getEdgeTargetNodeID(eid), eid);
            g.getEdgeFeatures(eid).forEach(f -> {
                g2.addEdgeFeature(eid, f);
            });
        });
        return g2;
    }
}
