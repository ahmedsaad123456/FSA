package problems;

import automata.NFA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Map;

import static java.util.Map.entry;

public class Problem7 {
    int[] states = {0, 1, 2, 3, 4, 5 , 6 , 7 , 8, 9 ,10};
    int[] startState = {0};
    int[] finalState = {5 , 10};
    char[] alphabet = {'E', '0', '1'};
    public Map<Integer, int[][]> transitionTable = Map.ofEntries(
            entry(0, new int[][]{{1 , 6}, {-1}, {-1}}),
            entry(1, new int[][]{{-1}, {-1}, {2}}),
            entry(2, new int[][]{{3}, {-1}, {3}}),
            entry(3, new int[][]{{-1}, {4}, {-1}}),
            entry(4, new int[][]{{5}, {5}, {-1}}),
            entry(5, new int[][]{{1 , 8}, {-1}, {-1}}),
            entry(6, new int[][]{{-1}, {7}, {-1}}),
            entry(7, new int[][]{{8}, {8}, {-1}}),
            entry(8, new int[][]{{-1}, {-1}, {9}}),
            entry(9, new int[][]{{10}, {-1}, {10}}),
            entry(10, new int[][]{{6 , 3}, {-1}, {-1}})
    );
    NFA nfa = new NFA(states, startState, finalState, alphabet, transitionTable);

    public Problem7(BufferedReader br, BufferedWriter bw) throws IOException {
        nfa.solveProblem(br, bw);
    }
}