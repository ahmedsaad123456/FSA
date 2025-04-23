// problems/Problem1.java
package problems;

import automata.DFA;
import java.util.Map;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import static java.util.Map.entry;

public class Problem4
{
    int[] states;
    int startState;
    int[] finalState;
    char[] alphabet;
    public Map<Integer, int[]> transitionTable;
    DFA dfa = new DFA(states,startState,finalState,alphabet,transitionTable);
    public Problem4 (BufferedReader br, BufferedWriter bw) throws IOException {
        dfa.solveProblem(br,bw);
    }

}
