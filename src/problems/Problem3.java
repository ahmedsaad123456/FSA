// problems/Problem1.java
package problems;

import automata.DFA;
import java.util.Map;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import static java.util.Map.entry;

public class Problem3
{
    int[] states = {0, 1, 2, 3 , 4 , 5 , 6 , 7 , 8 , 9};
    int startState = 0;
    int[] finalState = {7};
    char[] alphabet = {'x', 'y' , 'z'};
    public Map<Integer, int[]> transitionTable = Map.ofEntries(
            entry(0, new int[]{1, 2 , 3}),
            entry(1, new int[]{1, 4 , 0}),
            entry(2, new int[]{5, 0 , 0}),
            entry(3, new int[]{6, 0, 0}),
            entry(4, new int[]{1, 0 , 7}),
            entry(5, new int[]{5, 8 , 0}),
            entry(6, new int[]{6, 9 , 0}),
            entry(7, new int[]{7, 7 , 7}),
            entry(8, new int[]{5, 0 , 7}),
            entry(9, new int[]{6, 0 , 7})
    );
            DFA dfa = new DFA(states,startState,finalState,alphabet,transitionTable);
    public Problem3 (BufferedReader br, BufferedWriter bw) throws IOException {
        dfa.solveProblem(br,bw);
    }

}
