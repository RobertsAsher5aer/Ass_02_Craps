import java.util.Random;
import java.util.Scanner;

public class CrapsGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        while (playAgain) {
            int dice1 = rollDice(random);
            int dice2 = rollDice(random);
            int sum = dice1 + dice2;

            System.out.printf("You rolled %d + %d = %d\n", dice1, dice2, sum);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You lose.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You win.");
            } else {
                System.out.printf("Point is set to %d\n", sum);
                boolean pointSet = true;

                while (pointSet) {
                    int nextDice1 = rollDice(random);
                    int nextDice2 = rollDice(random);
                    int nextSum = nextDice1 + nextDice2;

                    System.out.printf("Next roll: %d + %d = %d\n", nextDice1, nextDice2, nextSum);

                    if (nextSum == sum) {
                        System.out.println("Made point! You win.");
                        pointSet = false;
                    } else if (nextSum == 7) {
                        System.out.println("Seven out! You lose.");
                        pointSet = false;
                    } else {
                        System.out.println("Trying for point...");
                    }
                }
            }

            System.out.print("Play again? (yes/no): ");
            String input = scanner.nextLine().toLowerCase();
            playAgain = input.equals("yes") || input.equals("y");
        }

        System.out.println("Thanks for playing Craps!");
    }

    private static int rollDice(Random random) {
        return random.nextInt(6) + 1; // Generate random number between 1 and 6 inclusive
    }
}

