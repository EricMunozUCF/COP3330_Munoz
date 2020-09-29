public class BodyMassIndex {

    Double height, weight;

    public BodyMassIndex(Double height, Double weight)
    {
        this.height = height;
        this.weight = weight;
    }


    public Double calculateBMI()
    {
        return 703 * this.weight / Math.pow(this.height, 2);
    }

    public String findCategory()
    {
        Double bmiScore = this.calculateBMI();

        if (bmiScore < 18.5)
            return "Underweight";
        else if (bmiScore >= 18.5 && bmiScore <= 24.9)
            return "Normal Weight";
        else if (bmiScore >= 25 && bmiScore <= 29.9)
            return "Overweight";
        else
            return "Obesity";
    }
}
