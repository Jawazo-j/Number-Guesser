import java.util.Random;
import java.util.Scanner;

public class RNG {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int randomNumber;
        int userIn;
        String quit = "";

        int[] remainingNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        do {
            System.out.println("Guess the number the computer selected between and including 1 and 10\n");
            randomNumber = random.nextInt(10) + 1;
            do {
//                System.out.println(randomNumber); // for testing
                System.out.print("Enter your guess: ");
                userIn = input.nextInt();
                input.nextLine(); // (1) Consume new line, 'quit' input won't work otherwise.

                /*
                 * Make sure the user input is within the valid range.
                 */
                if (userIn < 1 || userIn > 10) {
                    System.out.println("Please enter a number from 1 to 10");
                    continue;
                }
                if (userIn == randomNumber) {
                    System.out.println("You got it right!");
                    /*
                     * (2) Whenever the user guesses the correct number, the remainingNumbers array restores its values
                     * from 1 to 20 (read comment (3) for context). The purpose of resetting the array
                     * is so, when winning and playing again, the user doesn't get the message
                     * "You already tried that number. Try again!" when entering numbers that were entered in the first
                     * play through.
                     */
                    for (int i = 0; i < remainingNumbers.length; i++) {
                        remainingNumbers[i] = i + 1;
                    }
                    System.out.println("Would you like to play again? Type N to quit, Type anything else to continue.");
                    quit = input.nextLine();

                  /*
                   * Read comment (3) for context
                   */
                } else if (remainingNumbers[userIn - 1] == 0) {

                    System.out.println("You already tried that number. Try again!");

                } else {
                    System.out.println("You got it wrong. Try again!");

                    /*
                     * (3) For every wrong number the user guesses, that number will be set to 0 in the remainingNumbers
                     * array. userIn - 1 is used since array indexes start from 0 so if the user selects the number 9
                     * for example, in the array, the number 9 is of index 8.
                     */
                    remainingNumbers[userIn - 1] = 0;
                }

            }
            /*
             * Loops until the correct number is guessed.
             */
            while (userIn != randomNumber);
        }
        /*
         * Loops until the user enters "N" when prompted to play again after winning.
         */
        while (!quit.equalsIgnoreCase("N"));
        input.close();
    }
}
