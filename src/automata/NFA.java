package automata;

import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class NFA {
    private final int[] states;
    private final int[] startStates;
    private final int[] finalStates;
    private final char[] alphabet;
    private final Map<Integer, int[][]> transitionTable;

    public NFA(int[] states, int[] startStates, int[] finalStates, char[] alphabet,
               Map<Integer, int[][]> transitionTable) {
        this.states = states;
        this.startStates = startStates;
        this.finalStates = finalStates;
        this.alphabet = alphabet;
        this.transitionTable = transitionTable;
    }

    public boolean isAccepted(String input) {
        if (transitionTable == null) {
            return false;
        }

        Set<Integer> currentStates = new HashSet<>();
        // Start with initial states and their epsilon closures
        for (int startState : startStates) {
            currentStates.add(startState);
        }
        currentStates = epsilonClosure(currentStates);

        for (char c : input.toCharArray()) {
            // Check if character is in alphabet (excluding epsilon)
            boolean isValidChar = false;
            for (char a : alphabet) {
                if (c == a && a != 'E') {  // 'E' is for epsilon transitions
                    isValidChar = true;
                    break;
                }
            }
            if (!isValidChar) {
                return false;
            }

            Set<Integer> nextStates = new HashSet<>();

            // Find the index of the character in the alphabet
            int charIndex = -1;
            for (int i = 0; i < alphabet.length; i++) {
                if (alphabet[i] == c) {
                    charIndex = i;
                    break;
                }
            }

            if (charIndex == -1) {
                return false;
            }

            // Process transitions for each current state
            for (int currentState : currentStates) {
                int[][] transitions = transitionTable.get(currentState);
                if (transitions != null && charIndex < transitions.length) {
                    for (int nextState : transitions[charIndex]) {
                        if (nextState != -1) {
                            nextStates.add(nextState);
                        }
                    }
                }
            }

            // Get epsilon closure of the new states
            currentStates = epsilonClosure(nextStates);

            if (currentStates.isEmpty()) {
                return false;
            }
        }

        // Check if any current state is a final state
        for (int currentState : currentStates) {
            for (int finalState : finalStates) {
                if (currentState == finalState) {
                    return true;
                }
            }
        }

        return false;
    }

    private Set<Integer> epsilonClosure(Set<Integer> states) {
        Set<Integer> closure = new HashSet<>(states);
        boolean changed;
        do {
            changed = false;
            Set<Integer> newStates = new HashSet<>();

            for (int state : closure) {
                int[][] transitions = transitionTable.get(state);
                if (transitions != null && transitions.length > 0) {
                    // Check epsilon transitions (assuming 'E' is first in alphabet)
                    if (alphabet.length > 0 && alphabet[0] == 'E') {
                        for (int nextState : transitions[0]) {
                            if (nextState != -1 && !closure.contains(nextState)) {
                                newStates.add(nextState);
                                changed = true;
                            }
                        }
                    }
                }
            }
            closure.addAll(newStates);
        } while (changed);

        return closure;
    }

    public void solveProblem(BufferedReader br, BufferedWriter bw) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            if (line.equals("end")) break;
            boolean result = isAccepted(line.trim());
            bw.write(result ? "True" : "False");
            bw.newLine();
        }
        bw.write("x");
        bw.newLine();
    }
}