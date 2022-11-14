package org.example.algorithms.rabinkarp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class RabinKarpMain {


  public static void main(String[] args) throws IOException {
    String txt = Files.lines(Path.of("src/main/resources/text.txt")).collect(Collectors.joining(""));
    String pattern = "Jerry Strann";

    List<Integer> allOccurrences = RabinKarpAlgorithm.findAllOccurrences(pattern, txt);
    allOccurrences.forEach(System.out::println);
  }
}