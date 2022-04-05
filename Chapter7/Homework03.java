/**
 * Chapter7
 * Homework03.java
 */
import java.util.Scanner;

public class Homework03
{
    public static void main(String[] args)
    {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Please input price:");
        int price = myScanner.nextInt();

        Book book = new Book();
        System.out.println("The updated price is: "
            + book.updatePrice(price));
    }    
}

class Book
{
    public int updatePrice(int price)
    {
        if (price > 150)
        {
            price = 150;
        }
        else if (price > 100)
        {
            price = 100;
        }

        return price;
    }
}