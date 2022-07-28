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
            input = scanner.nextLine();

            if (!input.equalsIgnoreCase("stop")) {

                while (true) {
                    if (input.chars().allMatch(Character::isDigit)) {
                        num1 = Integer.parseInt(input);
                        break;
                    } else if (input.equalsIgnoreCase("stop")) {
                        break outerloop;
                    } else {
                        System.out.println(incorrectInput);
                        input = scanner.nextLine();
                    }
                }

                System.out.println("Enter another integer number or enter 'stop' to quit:");
                input = scanner.nextLine();

                while (true) {
                    if (input.chars().allMatch(Character::isDigit)) {
                        num2 = Integer.parseInt(input);
                        break;
                    } else if (input.equalsIgnoreCase("stop")) {
                        break outerloop;
                    } else {
                        System.out.println(incorrectInput);
                        input = scanner.nextLine();
                    }
                }

                System.out.println("Enter an operation or enter 'stop' to quit:");
                input = scanner.nextLine();

                while (true) {
                    if (Arrays.asList(operations).contains(input)) {
                        if (num2 == 0 && input.equals("/")) {
                            System.out.println(DivisionByZero);
                            input = scanner.nextLine();
                        } else {
                            operation = input;
                            break;
                        }
                    } else if (input.equalsIgnoreCase("stop")) {
                        break outerloop;
                    } else {
                        System.out.println(incorrectInput);
                        input = scanner.nextLine();
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
        String answer = "" + num1 + operation + num2 + "=";

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


        if(operation.equals("/")){
            if(num1%num2 == 0){return answer+result;}
            else{return answer + String.format("%.2f", (double) num1/(double) num2);}}
        else {return answer+result;}
}}
