package automata;

import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class NFA {
    private final int[] states;
    private final int[] startStates;
    private final int[] finalStates;
    private final char[] alphabet;
    private final Map<Integer, int[][]> transitionTable;

    // ===============================================================================================================

    public NFA(int[] states, int[] startStates, int[] finalStates, char[] alphabet,
               Map<Integer, int[][]> transitionTable) {
        this.states = states;
        this.startStates = startStates;
        this.finalStates = finalStates;
        this.alphabet = alphabet;
        this.transitionTable = transitionTable;
    }

    // ===============================================================================================================

    /**
     * Checks if the input string is accepted by the NFA.
     * @param input the input string to check
     * @return true if the input is accepted, false otherwise
     */
    public boolean isAccepted(String input) {
        // check if the transition table is null
        if (transitionTable == null) {
            return false;
        }

        // Initialize current states with start states
        Set<Integer> currentStates = new HashSet<>();
        for (int startState : startStates) {
            currentStates.add(startState);
        }

        // Get epsilon closure of the start states
        currentStates = epsilonClosure(currentStates);

        for (char c : input.toCharArray()) {
            // Check if character is in alphabet
            boolean isValidChar = false;

            for (char a : alphabet) {
                if (c == a) {
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
                // Get the transitions for the current state
                int[][] transitions = transitionTable.get(currentState);
                if (transitions != null && charIndex < transitions.length) {
                    // Add all reachable states for the current character
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

    // ===============================================================================================================

    /**
     * Calculates the epsilon closure of a set of states.
     * This is a helper method used in the NFA
     * @param states the set of states to calculate the closure for
     * @return the states with their epsilon closure
     */
    private Set<Integer> epsilonClosure(Set<Integer> states) {
        Set<Integer> closure = new HashSet<>(states);

        // Keep track of whether we have added new states to the closure
        boolean changed;

        do {
            changed = false;

            Set<Integer> newStates = new HashSet<>();

            // For each state in the closure, check for epsilon transitions
            for (int state : closure) {
                // Get the transitions for the current state
                int[][] transitions = transitionTable.get(state);

                // If there are transitions, check for epsilon transitions
                if (transitions != null && transitions.length > 0) {

                    // Epsilon transitions are at index 0
                    for (int nextState : transitions[0]) {
                        // Check if the next state is valid and not already in the closure
                        if (nextState != -1 && !closure.contains(nextState)) {
                            newStates.add(nextState);
                            changed = true;
                        }
                    }

                }
            }
            // Add new states to the closure
            closure.addAll(newStates);
        } while (changed);

        // Return the closure
        return closure;
    }

    // ===============================================================================================================

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

    // ===============================================================================================================
}