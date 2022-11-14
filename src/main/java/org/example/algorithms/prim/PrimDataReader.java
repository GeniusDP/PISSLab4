package org.example.algorithms.prim;

import static org.example.algorithms.dejkstra.Dejkstra.INF;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.example.algorithms.dejkstra.Matrix;

public class PrimDataReader {

  public static Matrix getMatrix() throws IOException {
    Path path = Path.of("src/main/resources/prim/input.txt");
    String line = Files.lines(path).collect(Collectors.joining(""));

    List<Integer> vertexes = new ArrayList<>();
    List<Integer> edges = new ArrayList<>();

    Arrays.stream(line.split(", ")).forEach(equality -> {
      String[] equalityParts = equality.split("=");
      vertexes.add(Integer.parseInt(equalityParts[0]));
      edges.add(Integer.parseInt(equalityParts[1]));
    });
    int vertexNumber = vertexes.stream()
        .flatMap(x -> Stream.of(x / 10, x % 10))
        .max(Integer::compareTo)
        .get();

    int[][] graph = new int[vertexNumber][vertexNumber];
    for (int i = 0; i < vertexNumber; i++) {
      for (int j = 0; j < vertexNumber; j++) {
        if (i != j) {
          graph[i][j] = INF;
        } else {
          graph[i][j] = 0;
        }
      }
    }

    for (int i = 0; i < vertexes.size(); i++) {
      int x = vertexes.get(i) / 10 - 1;
      int y = vertexes.get(i) % 10 - 1;
      graph[x][y] = graph[y][x] = Math.min(edges.get(i), graph[x][y]);
    }

    return new Matrix(graph);
  }

}
