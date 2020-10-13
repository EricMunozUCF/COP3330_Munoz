public class Sphere extends Shape3D{

    double radius;

    public Sphere(double radius)
    {
        this.name = "sphere";
        this.radius = radius;
    }

    public double getArea()
    {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    public double getVolume()
    {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }
}
