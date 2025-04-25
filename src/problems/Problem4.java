// problems/Problem4.java
package problems;

import automata.DFA;
import java.util.Map;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import static java.util.Map.entry;

public class Problem4 {
    int[] states = {0, 1, 2, 3, 4, 5, 6};
    int startState = 0;
    int[] finalState = {0};
    char[] alphabet = {'0', '1'};
    public Map<Integer, int[]> transitionTable = Map.ofEntries(
        // Transitions for q0 (remainder 0)
        entry(0, new int[]{0, 1}),   // On '0' → q0, on '1' → q1
        // Transitions for q1 (remainder 1)
        entry(1, new int[]{2, 3}),    // On '0' → q2, on '1' → q3
        // Transitions for q2 (remainder 2)
        entry(2, new int[]{4, 5}),    // On '0' → q4, on '1' → q5
        // Transitions for q3 (remainder 3)
        entry(3, new int[]{6, 0}),    // On '0' → q6, on '1' → q0
        // Transitions for q4 (remainder 4)
        entry(4, new int[]{1, 2}),    // On '0' → q1, on '1' → q2
        // Transitions for q5 (remainder 5)
        entry(5, new int[]{3, 4}),    // On '0' → q3, on '1' → q4
        // Transitions for q6 (remainder 6)
        entry(6, new int[]{5, 6})     // On '0' → q5, on '1' → q6
    );
    DFA dfa = new DFA(states, startState, finalState, alphabet, transitionTable);

    public Problem4(BufferedReader br, BufferedWriter bw) throws IOException {
        dfa.solveProblem(br, bw);
    }
}