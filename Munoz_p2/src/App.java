import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    public static boolean moreInput()
    {
        Scanner scanObj = new Scanner(System.in);

        System.out.printf("\nEnter Y or N: ");
        String input = scanObj.nextLine();

        if (input.equals("Y"))
            return true;
        else
            return false;
    }

    public static double getUserHeight()
    {
        Scanner scanObj = new Scanner(System.in);
        String input;
        Double inputDouble;

        while (true)
        {
            System.out.printf("\nEnter a height in inches: ");
            input = scanObj.nextLine();
            inputDouble = Double.parseDouble(input);

            if (inputDouble > 0.0)
                break;
            else
                System.out.printf("\nYour height must be positive.");
        }

        return Double.parseDouble(input);
    }

    public static double getUserWeight()
    {
        Scanner scanObj = new Scanner(System.in);
        String input;
        Double inputDouble;

        while (true)
        {
            System.out.printf("\nEnter a weight in inches: ");
            input = scanObj.nextLine();
            inputDouble = Double.parseDouble(input);

            if (inputDouble > 0.0)
                break;
            else
                System.out.printf("\nYour weight must be positive.");
        }

        return Double.parseDouble(input);
    }

    public static void displayBmiInfo(BodyMassIndex bmi)
    {
        Double score = bmi.calculateBMI();
        String category = bmi.findCategory();

        System.out.printf("\nYour BMI Score is %.2f", score);
        System.out.printf("\nYour BMI Category is %s", category);
    }

    public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData)
    {

        int size = bmiData.size();
        Double totalBMI = 0.0;

        for (int i = 0; i < size; i++)
            totalBMI += bmiData.get(i).calculateBMI();

        Double averageBMI = totalBMI / size;

        System.out.printf("\nThe average BMI is %.2f", averageBMI);
    }
}
