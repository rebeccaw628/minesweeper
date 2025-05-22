package util;
import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner;

    public InputHandler () {
        this.scanner = new Scanner(System.in);
    }

    public int inputValidator (String prompt, int upperBound) {
        while (true) {
            System.out.println(prompt);
            if (this.scanner.hasNextInt()) {
                int integerInput = this.scanner.nextInt();
                if (isWithinRange(integerInput,upperBound)) {
                    return integerInput;
                }
                else {
                    System.out.println("Invalid number selected. Enter a number between 1-" + upperBound);
                }
            }
        }
    }

    public void closeScanner() {
        scanner.close();
    }

    private boolean isWithinRange(int inputInteger, int upperBound) {
        return inputInteger > 0 && inputInteger <= upperBound;
    }

}
