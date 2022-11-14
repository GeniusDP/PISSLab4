package org.example.algorithms.dejkstra;

import java.util.ArrayList;
import java.util.List;

public class Dejkstra {

  public static final int INF = 1_000_000_000;

  public static List<Integer> perform(int[][] graph, int start) {
    List<Boolean> used = new ArrayList<>();
    List<Integer> dist = new ArrayList<>();

    int n = graph.length;
    /*
     * initialization
     * */

    //used array
    for (int i = 0; i < n; i++) {
      used.add(false);
    }
    //dist array
    for (int i = 0; i < n; i++) {
      dist.add(INF);
    }
    dist.set(start, 0);

    for (int i = 0; i < n; i++) {
      int minValue = INF;
      int vertoxCurr = -1;
      boolean wasFound = false;
      for (int j = 0; j < n; j++) {
        if (!used.get(j) && dist.get(j) < minValue) {
          wasFound = true;
          minValue = dist.get(j);
          vertoxCurr = j;
        }
      }
      if (!wasFound) {
        break;
      }
      used.set(vertoxCurr, true);

      for (int j = 0; j < n; j++) {
        if (!used.get(j)) {
          dist.set(j, Math.min(dist.get(j), dist.get(vertoxCurr) + graph[vertoxCurr][j]));
        }
      }

    }
    return dist;
  }

}
