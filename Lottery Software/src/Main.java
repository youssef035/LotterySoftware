
import java.util.*;

public class Main {
    public static final int NUMBERS_TO_PICK = 7;
    public static final int MAX_NUMBER = 40;
    public static final int PRIZE_THRESHOLD = 3;

    public static void main(String[] args) {
        Set<Integer> won = createWinningNumbers();
        Set<Integer> ticket = getTicket();

        Set<Integer> winNumbers = new TreeSet<>(ticket);
        winNumbers.retainAll(won);

        System.out.println("Your numbers are: " + ticket);
        System.out.println("The winning numbers are: " + won);

        if (winNumbers.size() > PRIZE_THRESHOLD) {
            System.out.println("Congratulations! You have won a prize.");
        } else {
            System.out.println("You are unlucky, my friend.");
        }
    }

    public static Set<Integer> createWinningNumbers() {
        Set<Integer> winning = new TreeSet<>();
        Random r = new Random();

        while (winning.size() < NUMBERS_TO_PICK) {
            int number = r.nextInt(MAX_NUMBER) + 1;
            winning.add(number);
        }
        return winning;
    }

    public static Set<Integer> getTicket() {
        Set<Integer> ticket = new TreeSet<>();
        System.out.println("Please enter your  ticket numbers");
        Scanner scan = new Scanner(System.in);

        while (ticket.size() < NUMBERS_TO_PICK) {
            try {
                int n = scan.nextInt();
                if (n >= 1 && n <= MAX_NUMBER && !ticket.contains(n)) {
                    ticket.add(n);
                } else {
                    System.out.println("Invalid input. Please enter a unique number between 1 and " + MAX_NUMBER + ".");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scan.next();
            }
        }
        return ticket;
    }
}
