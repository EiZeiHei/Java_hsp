/**
 * Chapter7
 * Homework05.java
 */
public class Homework05
{
    public static void main(String[] args)
    {
        double r = 1.1;

        Circle c = new Circle();
        c.peri(r);
        c.area(r);
    }    
}

class Circle
{
    public void peri(double r)
    {
        double peri = 2 * 3.14 * r;
        System.out.println("The peri is: " + peri);
    }

    public void area(double r)
    {
        double area = 3.14 * r * r;
        System.out.println("The area is: " + area);
    }
}