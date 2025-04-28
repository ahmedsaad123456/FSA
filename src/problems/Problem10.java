package problems;

import automata.NFA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Map;

import static java.util.Map.entry;

public class Problem10 {
    int[] states = {0, 1};
    int[] startState = {0};
    int[] finalState = {0, 1};
    char[] alphabet = {'E','x', 'y'};
    public Map<Integer, int[][]> transitionTable = Map.ofEntries(
            entry(0, new int[][]{{-1},{0}, {1}}),
            entry(1, new int[][]{ {-1},{0}, {2}})
    );
    NFA nfa = new NFA(states, startState, finalState, alphabet, transitionTable);

    public Problem10(BufferedReader br, BufferedWriter bw) throws IOException {
        nfa.solveProblem(br, bw);
    }
}
