// problems/Problem1.java
package problems;

import automata.DFA;
import java.util.Map;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import static java.util.Map.entry;

public class Problem6 {
    int[] states = {0, 1, 2, 3};
    int startState = 0;
    int[] finalState = {1};
    char[] alphabet = {'a', 'b'};
    public Map<Integer, int[]> transitionTable = Map.ofEntries(
        // EE (0): 'a' → OE (2), 'b' → EO (1)
        entry(0, new int[]{2, 1}),
        // EO (1): 'a' → OO (3), 'b' → EE (0)
        entry(1, new int[]{3, 0}),
        // OE (2): 'a' → EE (0), 'b' → OO (3)
        entry(2, new int[]{0, 3}),
        // OO (3): 'a' → EO (1), 'b' → OE (2)
        entry(3, new int[]{1, 2})
    );
    DFA dfa = new DFA(states, startState, finalState, alphabet, transitionTable);

    public Problem6(BufferedReader br, BufferedWriter bw) throws IOException {
        dfa.solveProblem(br, bw);
    }
}