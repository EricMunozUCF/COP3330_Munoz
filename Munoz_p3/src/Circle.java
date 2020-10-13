public class Circle extends Shape2D {

    double radius;

    public Circle(double radius)
    {
        this.name = "circle";
        this.radius = radius;
    }

    public double getArea()
    {
        return Math.PI * Math.pow(this.radius, 2);
    }
}
