package org.example.algorithms.dejkstra;

import static org.example.algorithms.dejkstra.Dejkstra.INF;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Matrix {

  private int[][] graph;

  public int getSize() {
    return graph.length;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    for (int[] ints : graph) {
      for (int anInt : ints) {
        if (anInt == INF) {
          stringBuilder.append("   ∞");
        } else {
          stringBuilder.append(String.format("%4d", anInt));
        }
      }
      stringBuilder.append("\n");
    }
    return stringBuilder.toString();
  }
}
