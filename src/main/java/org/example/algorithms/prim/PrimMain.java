package org.example.algorithms.prim;

import java.io.IOException;
import java.util.List;
import org.example.algorithms.dejkstra.Matrix;

public class PrimMain {

  public static void main(String[] args) throws IOException {
    Matrix matrix = PrimDataReader.getMatrix();
    System.out.println(matrix);
    List<Edge> edges = PrimAlgo.perform(matrix.getGraph());
    edges.forEach(edge -> {
      System.out.println("(" + (edge.firstVertex + 1) + ") <--> (" + (edge.secondVertex + 1) + ")");
    });

  }

}
