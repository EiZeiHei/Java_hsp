/**
 * Chapter7
 * Homework13.java
 */
public class Homework13
{
    public static void main(String[] args)
    {
        PassObject p = new PassObject();
        Circle c = new Circle();
        p.printAreas(c, 5);
    }    
}

class Circle
{
    double radius;

    public Circle()
    {

    }

    public Circle(double radius)
    {
        this.radius = radius;
    }

    public double findArea()
    {
        double area = Math.PI * radius * radius;

        return area;
    }

    public void setR(double r)
    {
        this.radius = r;
    }
}

class PassObject
{
    public void printAreas(Circle c, int times)
    {
        System.out.println("Radius\tArea");
        for (int i = 1; i <= times; i++)
        {
            c.setR(i);
            System.out.println((double)i + "\t" + c.findArea());
            c = new Circle(i + 1);
        }
    }
}