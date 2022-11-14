package org.example.algorithms.dejkstra;

import static org.example.algorithms.dejkstra.Dejkstra.INF;

import java.io.IOException;
import java.util.List;

public class DejkstraMain {

  public static void main(String[] args) throws IOException {
    Matrix matrix = DataReader.getMatrix();
    System.out.println(matrix);
    int start = 7;//0-index
    List<Integer> dist = Dejkstra.perform(matrix.getGraph(), start);

    for (int i = 0; i < matrix.getSize(); i++) {
      if(i != start){
        System.out.println("(" + (start + 1) + ")" +  " --> " + "(" + (i + 1) + ")" + " === " +
            (dist.get(i) < INF ? dist.get(i) : "∞"));
      }
    }

  }

}
