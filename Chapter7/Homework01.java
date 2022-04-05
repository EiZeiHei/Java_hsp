/**
 * Chapter7
 * Homework01.java
 */

public class Homework01
{
    public static void main(String[] args)
    {
        double[] num = {1.1, 2.2, 3.3, 0, 5};

        A01 a = new A01();
        System.out.println("Max of num: " + a.max(num));
    }    
}

class A01
{
    public double max(double[] num)
    {
        double tmp = num[0];

        for (int i = 1; i < num.length; i++)
        {
            if (num[i] > tmp)
            {
                tmp = num[i];      
            }  
        }

        return tmp;
    }
}