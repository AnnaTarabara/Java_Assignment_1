import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {

        int ticketNumber;
        int numberOfDigits;
        int firstHalf;
        int lastHalf;
        int currDigitOfFirstHalf;
        int currDigitOfLastHalf;
        int lastDigitOfFirstHalf;
        int lastDigitOfLastHalf;
        int firstHalfSum = 0;
        int lastHalfSum = 0;
        int factor;
        int finalFactor = 10;
        int mediumFactor;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please enter a ticket no. as a positive integer value with EVEN number of digits and not exceeding " + Integer.MAX_VALUE + " or enter 'stop' to exit");
            if (scanner.hasNextInt()) {
                ticketNumber = scanner.nextInt();
                numberOfDigits = String.valueOf(ticketNumber).length();
                if (numberOfDigits % 2 == 0) {

                    factor = (int) Math.pow(finalFactor, numberOfDigits / 2.0);
                    mediumFactor = factor / finalFactor;

                    firstHalf = ticketNumber / factor;
                    lastHalf = ticketNumber % factor;
                    lastDigitOfLastHalf = lastHalf % finalFactor;
                    lastDigitOfFirstHalf = firstHalf % finalFactor;

                    while (mediumFactor >= finalFactor) {
                        currDigitOfFirstHalf = firstHalf / mediumFactor;
                        currDigitOfLastHalf = lastHalf / mediumFactor;
                        firstHalf = firstHalf % mediumFactor;
                        lastHalf = lastHalf % mediumFactor;
                        firstHalfSum += currDigitOfFirstHalf;
                        lastHalfSum += currDigitOfLastHalf;
                        mediumFactor = mediumFactor / finalFactor;
                    }

                    lastHalfSum = lastHalfSum + lastDigitOfLastHalf;
                    firstHalfSum = firstHalfSum + lastDigitOfFirstHalf;

                    if (lastHalfSum == firstHalfSum) {
                        System.out.println("Congratulations! You ve got a happy ticket!");
                    } else {
                        System.out.println("Not Lucky this time, try another ticket.");
                    }
                } else {
                    System.out.println("Incorrect input! Number of digits in a ticket no. must be EVEN and ticket no. must be no more than " + Integer.MAX_VALUE + "!");
                }
            } else if(scanner.hasNext("stop")){break;}
            else
            {
                System.out.println("Incorrect input! Ticket number must contain digits only and must be no more than " + Integer.MAX_VALUE + "!");
                scanner.next();
            }
        }
    }
}