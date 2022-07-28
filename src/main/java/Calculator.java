import java.util.Arrays;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input;
        int num1;
        int num2;
        String operation;
        String[] operations = {"-", "+", "*", "/"};
        String incorrectInput = "Your input is incorrect. Try again or enter 'stop' to quit:";
        String DivisionByZero = "Division by zero is not allowed. Enter another operation or 'stop' to quit";

        outerloop:
        while (true) {

            System.out.println("Enter an integer number or enter 'stop' to quit:");
            input = scanner.next();

            if (!input.equalsIgnoreCase("stop")) {

                while (true) {
                    if (input.chars().allMatch(Character::isDigit)) {
                        num1 = Integer.parseInt(input);
                        break;
                    } else if (input.equalsIgnoreCase("stop")) {
                        break outerloop;
                    } else {
                        System.out.println(incorrectInput);
                        input = scanner.next();
                    }
                }

                System.out.println("Enter another integer number or enter 'stop' to quit:");
                input = scanner.next();

                while (true) {
                    if (input.chars().allMatch(Character::isDigit)) {
                        num2 = Integer.parseInt(input);
                        break;
                    } else if (input.equalsIgnoreCase("stop")) {
                        break outerloop;
                    } else {
                        System.out.println(incorrectInput);
                        input = scanner.next();
                    }
                }

                System.out.println("Enter an operation or enter 'stop' to quit:");
                input = scanner.next();

                while (true) {
                    if (Arrays.asList(operations).contains(input)) {
                        if (num2 == 0 && input.equals("/")) {
                            System.out.println(DivisionByZero);
                            input = scanner.next();
                        } else {
                            operation = input;
                            break;
                        }
                    } else if (input.equalsIgnoreCase("stop")) {
                        break outerloop;
                    } else {
                        System.out.println(incorrectInput);
                        input = scanner.next();
                    }
                }

                System.out.println(result(num1, num2, operation));}

               else  {
                   break;
            }
        }
    }
    public static String result(int num1, int num2, String operation){

        int result = 0;

        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1/num2;
                break;
        }

        if(operation.equals("/") && num1%num2 == 0){
        return "" + num1 + operation + num2 + "=" + result;}
        else{return "" + num1 + operation + num2 + "=" + String.format("%.2f", (double) num1/(double) num2);}
    }
}
