package org.example.algorithms.prim;

import static org.example.algorithms.dejkstra.Dejkstra.INF;

import java.util.ArrayList;
import java.util.List;

public class PrimAlgo {

  public static List<Edge> perform(int[][] graph) {
    int n = graph.length;
    List<Edge> edges = new ArrayList<>();

    List<Integer> x = new ArrayList<>();
    x.add(0);

    List<Integer> y = new ArrayList<>();
    for(int i = 1; i < n; i++){
      y.add(i);
    }

    while(x.size() < n) {
      int minEdgeLength = INF;
      Edge edge = null;
      for (var v1: x) {
        for (var v2: y) {
          if(v1 != v2) {
            int currentEdgeLength = graph[v1][v2];
            if (currentEdgeLength < minEdgeLength) {
              minEdgeLength = currentEdgeLength;
              edge = new Edge(v1, v2);
            }
          }
        }
      }
      int toMove = edge.secondVertex;
      x.add(toMove);
      y.removeIf(el -> el == toMove);
      edges.add(edge);
    }
    return edges;
  }

}
