/**
 * Chapter7
 * Homework04.java
 */
public class Homework04
{
    public static void main(String[] args)
    {
        double[] arr = {1.1, 2.2, 3.3, 4, 5};

        A04 a = new A04();
        double[] arrNew = a.copyArr(arr);

        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arrNew[i] + "\t");
        }
    }    
}

class A04
{
    public double[] copyArr(double[] arr)
    {
        double[] arrNew = new double[arr.length];
        for (int i = 0; i < arr.length; i++)
        {
            arrNew[i] = arr[i];
        }

        return arrNew;
    }
}