import problems.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String inputFile = "src/input.txt";
        String outputFile = "src/output.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = br.readLine()) != null) {
                int problemNumber = Integer.parseInt(line.trim());
                System.out.println("Processing problem number: " + problemNumber + "...");

                // Write problem number to output file first
                bw.write(String.valueOf(problemNumber));
                bw.newLine();

                switch (problemNumber) {
                    case 1:
                        new Problem1(br, bw);
                        break;
                    case 2:
                        new Problem2(br, bw);
                        break;
                    case 3:
                        new Problem3(br, bw);
                        break;
                    case 4:
                        new Problem4(br, bw);
                        break;
                    case 5:
                        new Problem5(br, bw);
                        break;
                    case 6:
                        new Problem6(br, bw);
                        break;
                    case 7:
                        new Problem7(br, bw);
                        break;
                    case 8:
                        new Problem8(br, bw);
                        break;
                    case 9:
                        new Problem9(br, bw);
                        break;
                    case 10:
                        new Problem10(br, bw);
                        break;
                    default:
                        System.err.println("Unknown problem number: " + problemNumber);

                }
            }
        } catch (IOException e) {
            System.err.println("Error processing files: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid problem number format");
        }
    }
}