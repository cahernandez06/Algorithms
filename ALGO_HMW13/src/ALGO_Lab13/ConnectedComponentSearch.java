package ALGO_Lab13;

import java.util.ArrayList;
import java.util.List;

//implement
public class ConnectedComponentSearch extends DepthFirstSearch {
    List<Graph> ConnectedComponents;
    ArrayList<Edge> connectedEdges = new ArrayList<>();

	public ConnectedComponentSearch(Graph graph) {
		super(graph);
        ConnectedComponents = new ArrayList<>();
	}
    public List<Graph> getConnectedComponents() {
        start();
        return ConnectedComponents;
    }
    @Override
    protected void additionalProcessing() {
        ConnectedComponents.add(new Graph(connectedEdges.toArray(new Edge[connectedEdges.size()])));
        //And clear the ArrayList of connectedEdges for next component
        connectedEdges = new ArrayList<>();
    }
    protected void processEdge(Edge e) {
        connectedEdges.add(e);
    }
}
