/**
 * Chapter7
 * Homework14.java
 */
import java.util.Random;
import java.util.Scanner;

public class Homework14
{
    public static void main(String[] args)
    {
        Scanner myScanner = new Scanner(System.in);
        int[] result = new int[6];
        PC pc = new PC();

        for (int i = 0; i < 3; i++)
        {
            System.out.println("----The Number " + i + " Guess----");
            System.out.print("Please input guess:\t");
            int tom = myScanner.nextInt();
            if (tom < 0 || tom > 2)
            {
                System.out.println("Input 0 1 2");
                i--;
                continue;
            }
            int pcg = pc.guess();
            System.out.println("PC Guess\t" + pcg);
            System.out.println("Result\t" + pc.wol(tom, pcg));
            System.out.println();
            result[2 * i] = tom;
            result[2 * i + 1] = pcg;
        }

        System.out.println("----The Final Result----");
        System.out.println("Round\tResult\tTom\tPC");

        for (int i = 0; i < 3; i++)
        {
            int a = result[2 * i];
            int b = result[2 * i + 1];

            System.out.println(i + "\t" + pc.wol(a, b) + "\t"
                + a + "\t" + b);
        }
    }
}

class PC
{
    public int guess()
    {
        Random r = new Random();
        return r.nextInt(3);
    }

    public String wol(int tom, int pcg)
    {
        if (tom == pcg) return "TIE";
        else if (tom - pcg == 1 || pcg - tom == 2) return "LOSE";
        else if (pcg - tom == 1 || tom - pcg == 2) return "WIN";
        else return "NAN";
    }
}