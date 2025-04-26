package problems;

import automata.NFA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Map;

import static java.util.Map.entry;

public class Problem9 {
    int[] states = {0, 1, 2, 3};
    int[] startState = {0};
    int[] finalState = {1, 2 , 3};
    char[] alphabet = {'E', '0', '1'};
    public Map<Integer, int[][]> transitionTable = Map.ofEntries(
            entry(0, new int[][]{{-1}, {1}, {2}}),
            entry(1, new int[][]{{-1}, {1}, {2}}),
            entry(2, new int[][]{{-1}, {3}, {2}}),
            entry(3, new int[][]{{-1}, {-1}, {2}})
    );
    NFA nfa = new NFA(states, startState, finalState, alphabet, transitionTable);

    public Problem9(BufferedReader br, BufferedWriter bw) throws IOException {
        nfa.solveProblem(br, bw);
    }
}