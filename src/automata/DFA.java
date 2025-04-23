package automata;

import java.util.Map;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class DFA {
    private final int[] states;
    private final int startState;
    private final int[] finalStates;
    private final char[] alphabet;

    private final Map<Integer, int[]> transitionTable;  // Keep as Map<Integer, int[]>

    public DFA(int[] states, int startState, int[] finalStates, char[] alphabet,
               Map<Integer, int[]> transitionTable) {
        this.states = states;
        this.startState = startState;
        this.finalStates = finalStates;
        this.alphabet = alphabet;
        this.transitionTable = transitionTable;
    }



    public boolean isAccepted(String input) {
        if( transitionTable == null){
            return false;
        }
        int currentState = startState;

        for(char c : input.toCharArray()) {
            boolean isValidChar = false;
            for(char a : alphabet) {
                if(c == a ){
                    isValidChar = true;
                    break;
                }
            }

            if(!isValidChar){
                return false;
            }


            int[] transitions = transitionTable.get(currentState);

            if (transitions != null) {
                for (int i = 0; i < alphabet.length; i++) {
                    if (alphabet[i] == c) {
                        currentState = transitions[i];
                        break;
                    }
                }
            } else {
                return false;
            }

        }

        for (int finalState : finalStates) {
            if (currentState == finalState) {
                return true;
            }
        }


        return false;
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