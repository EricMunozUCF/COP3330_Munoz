public class Triangle extends Shape2D {

    double base, height;

    public Triangle(double base, double height)
    {
        this.name = "triangle";
        this.base = base;
        this.height = height;
    }

    public double getArea()
    {
        return (base * height) / 2;
    }
}
