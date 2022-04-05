/**
 * Chapter7
 * Homework02.java
 */

public class Homework02
{
    public static void main(String[] args)
    {
        String[] LA = {"A", "LA", "EiZeiHei"};
        String la = "LA";

        A02 a = new A02();
        System.out.println("Index of LA: " + a.find(LA, la));
    }    
}

class A02
{
    public int find(String[] s, String a)
    {
        int index = -1;

        for(int i = 0; i < s.length; i++)
        {
            if(s[i].equals(a))  index = i;
        }

        return index;
    }
}