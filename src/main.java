import java.util.Scanner;

public class main {

    public static void main (String[] args) {
        CardValidator validator = new CardValidator();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== Enter a card ===");
            Card c = new Card(scanner.nextLine());
            int validResult = validator.isCardValid(c);

            if (validResult == 1) {
                System.out.println("Your card is: " + c.getId() + c.getSuit());
                System.out.println("Validation result: valid");
            } else {
                System.out.println("Your card is: " + c.getId() + c.getSuit());
                System.out.println("Validation result: invalid");
            }
        }
    }
}
