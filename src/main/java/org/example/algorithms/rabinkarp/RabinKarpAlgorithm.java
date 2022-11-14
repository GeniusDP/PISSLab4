package org.example.algorithms.rabinkarp;


import java.util.ArrayList;
import java.util.List;

public class RabinKarpAlgorithm {

  public final static long DIGIT = 256;
  public final static long MOD = 1_000_000_007;

  public static List<Integer> findAllOccurrences(String pattern, String txt) {
    List<Integer> occurrences = new ArrayList<>();
    int n = txt.length();
    int m = pattern.length();
    int i, j;
    long patternHash = 0;
    long textHash = 0;
    long highestDegree = 1;

    for (i = 0; i < m - 1; i++) {
      highestDegree = (highestDegree * DIGIT) % MOD;
    }

    for (i = 0; i < m; i++) {
      patternHash = (DIGIT * patternHash + pattern.charAt(i)) % MOD;
      textHash = (DIGIT * textHash + txt.charAt(i)) % MOD;
    }

    for (i = 0; i <= n - m; i++) {
      if (patternHash == textHash) {
        for (j = 0; j < m; j++) {
          if (txt.charAt(i + j) != pattern.charAt(j)) {
            break;
          }
        }
        if (j == m) {
          occurrences.add(i);
        }
      }
      if (i + m < n) {
        textHash = (DIGIT * (textHash - txt.charAt(i) * highestDegree) + txt.charAt(i + m)) % MOD;
        if (textHash < 0) {
          textHash = textHash + MOD;
        }
      }

    }
    return occurrences;
  }

}
