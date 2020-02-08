package ALGO_Lab13;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Pair> l = new ArrayList<Pair>();
		
		l.add(new Pair("A","B"));
		l.add(new Pair("B","C"));
		l.add(new Pair("A","D"));
		l.add(new Pair("B","D"));
		l.add(new Pair("E","F"));  //Add another component
		Graph g = new Graph(l);
		String s = g.toString();
		System.out.println(s);
		System.out.println("Are B and C adjacent? "+g.areAdjacent(new Vertex("B"),new Vertex("C")));
		System.out.println("Are A and C adjacent? "+g.areAdjacent(new Vertex("A"),new Vertex("C")));
		System.out.println("Spanning Tree:");
		Graph t = g.getSpanningTree();
		System.out.println(t);
		System.out.println(t.getSpanningTree());

		System.out.println("************** Questions to be solved about the graph ****************************");
		System.out.println("1.It a Connected graph?: " + g.isConnected());
		System.out.println("2.1.Exist path between A and C?: " + g.existsPathBetween(new Vertex("A"),new Vertex("C")));
		System.out.println("2.1.Exist path between A and F?: " + t.existsPathBetween(new Vertex("A"),new Vertex("F")));
		System.out.println("3.Contains a cycle?: " + g.containsCycle());
		System.out.println("4.Is Bipartite: " + g.isBipartite);
	}

}
