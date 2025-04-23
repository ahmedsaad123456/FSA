package problems;

import automata.NFA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Map;

import static java.util.Map.entry;

public class Problem10 {
    int[] states;
    int[] startState;
    int[] finalState;
    char[] alphabet;
    public Map<Integer, int[][]> transitionTable;
    NFA nfa = new NFA(states, startState, finalState, alphabet, transitionTable);

    public Problem10(BufferedReader br, BufferedWriter bw) throws IOException {
        nfa.solveProblem(br, bw);
    }
}