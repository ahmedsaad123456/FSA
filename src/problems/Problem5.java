// problems/Problem5.java
package problems;

import automata.DFA;
import java.util.Map;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import static java.util.Map.entry;

public class Problem5 {
    int[] states = {0, 1, 2};
    int startState = 0;
    int[] finalState = {0};
    char[] alphabet = {'a', 'b'};
    public Map<Integer, int[]> transitionTable = Map.ofEntries(
        // q0: 'a' → q1, 'b' → q0
        entry(0, new int[]{1, 0}),
        // q1: 'a' → q0 (valid pair), 'b' → q2 (invalid)
        entry(1, new int[]{0, 2}),
        // q2: trap state (stays on any input)
        entry(2, new int[]{2, 2})
    );
    DFA dfa = new DFA(states, startState, finalState, alphabet, transitionTable);

    public Problem5(BufferedReader br, BufferedWriter bw) throws IOException {
        dfa.solveProblem(br, bw);
    }
}