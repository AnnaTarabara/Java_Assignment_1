import java.util.Arrays;
import java.util.Scanner;

public class Calculator_ver1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input;
        int num1;
        int num2;
        String operation;
        double result2;
        int result1 = 0;
        String[] operations = {"-", "+", "*", "/"};

        while (true) {

            System.out.println("Enter an integer number or enter 'stop' to quit:");
            input = scanner.next();

            if (!input.equalsIgnoreCase("stop")) {

                while (!input.chars().allMatch(Character::isDigit)) {
                    System.out.println("Your input is incorrect. Try again.");
                    input = scanner.next();
                }
                num1 = Integer.parseInt(input);

                System.out.println("Enter another integer number:");
                input = scanner.next();

                while (!input.chars().allMatch(Character::isDigit)) {
                    System.out.println("Your input is incorrect. Try again.");
                    input = scanner.next();
                }
                num2 = Integer.parseInt(input);

                System.out.println("Enter any of the operands: '+', '-', '/' or '*'");
                input = scanner.next();

                while (!Arrays.asList(operations).contains(input)) {
                    System.out.println("Your input is incorrect. Try again.");
                    input = scanner.next();
                }
                operation = input;

                if(num2 ==0 && operation.equals("/")){System.out.println("Division by zero is not allowed. Begin again!");}

                else if(!(num1%num2 == 0) && operation.equals("/")){
                    result2 = (double) num1 / (double) num2;
                    System.out.println("" + num1 + operation + num2 + "=" + String.format("%.2f", result2));
                }

                else{
                    switch (operation) {
                        case "+":
                            result1 = num1 + num2;
                            break;
                        case "-":
                            result1 = num1 - num2;
                            break;
                        case "*":
                            result1 = num1 * num2;
                            break;
                        case "/":
                            result1 = num1 / num2;
                            break;
                    }
                    System.out.println("" + num1 + operation + num2 + "=" + result1);}

            } else {
                break;
            }}
    }}
