public class Cube extends Shape3D {

    double length;

    public Cube(double length)
    {
        this.name = "cube";
        this.length = length;
    }

    public double getArea()
    {
        return 6 * Math.pow(this.length, 2);
    }

    public double getVolume()
    {
        return Math.pow(this.length, 3);
    }
}
