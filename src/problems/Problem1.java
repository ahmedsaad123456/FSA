// problems/Problem1.java
package problems;

import automata.DFA;
import java.util.Map;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import static java.util.Map.entry;

public class Problem1
{
    int[] states = {0, 1, 2, 3};
    int startState = 0;
    int[] finalState = {2};
    char[] alphabet = {'a', 'b'};
    public Map<Integer, int[]> transitionTable = Map.ofEntries(
            entry(0, new int[]{1, 3}),
            entry(1, new int[]{0, 2}),
            entry(2, new int[]{3, 1}),
            entry(3, new int[]{2, 0})
    );
    DFA dfa = new DFA(states,startState,finalState,alphabet,transitionTable);
    public Problem1 (BufferedReader br, BufferedWriter bw) throws IOException {
        dfa.solveProblem(br,bw);
    }

}
