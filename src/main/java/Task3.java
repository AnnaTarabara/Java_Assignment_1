import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {

        int counter = 0;
        int weightOfApplesInCurrentGift;
        int weightOfPearsInCurrentGift;
        int weightOfOrangesInCurrentGift;
        int numberOfOrangesInCurrentGift;
        int weightOfGift;
        int weightOfApple;
        int weightOfPear;
        int weightOfOrange;
        int maxNumberOfApple;
        int maxNumberOfPear;

        System.out.println("Enter integer weight of a gift > 0:");
        weightOfGift = getWeight();

        System.out.println("Enter integer weight of an apple > 0:");
        weightOfApple = getWeight();

        System.out.println("Enter integer weight of a pear > 0:");
        weightOfPear = getWeight();

        System.out.println("Enter integer weight of an orange > 0:");
        weightOfOrange = getWeight();

        maxNumberOfApple = weightOfGift / weightOfApple;
        maxNumberOfPear = weightOfGift / weightOfPear;

        for(int i=0;i<=maxNumberOfApple * weightOfApple;i+=weightOfApple)
        {
            for(int j=0;j<=maxNumberOfPear * weightOfPear;j+=weightOfPear)
            {
                weightOfApplesInCurrentGift = i;
                weightOfPearsInCurrentGift = j;
                weightOfOrangesInCurrentGift = weightOfGift - weightOfApplesInCurrentGift - weightOfPearsInCurrentGift;
                numberOfOrangesInCurrentGift = weightOfOrangesInCurrentGift / weightOfOrange;

                if(numberOfOrangesInCurrentGift>=0)
                {
                    if(weightOfApplesInCurrentGift + weightOfPearsInCurrentGift + weightOfOrangesInCurrentGift == weightOfGift && weightOfOrangesInCurrentGift >= 0 && weightOfOrangesInCurrentGift % weightOfOrange == 0)
                    {
                        counter++;
                        System.out.print(i);
                        System.out.print(" ");
                        System.out.print(j);
                        System.out.print(" ");
                        System.out.print(weightOfOrangesInCurrentGift);
                        System.out.println();
                    }
                }
            }
        }
        System.out.println("Number of gift options is: " + counter);
    }
    public static int getWeight(){
        Scanner scanner = new Scanner(System.in);
        int weight;
        while (true) {
            if (scanner.hasNextInt()) {
                weight = scanner.nextInt();
                if (weight > 0) {
                    break;
                } else {
                    System.out.println("Incorrect input. Please enter integer value > 0!");
                }
            } else {
                System.out.println("Incorrect input. Please enter integer value!");
                scanner.next();
            }
        }
        return weight;
    }
}
