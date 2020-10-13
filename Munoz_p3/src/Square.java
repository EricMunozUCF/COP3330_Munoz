public class Square extends Shape2D {

    double length;

    public Square(double length)
    {
        this.name = "square";
        this.length = length;
    }

    public double getArea()
    {
        return this.length * this.length;
    }
}
