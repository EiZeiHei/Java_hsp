/**
 * Chapter5
 * TicketPrice.java
 * Ʊ��
 */

import java.util.Scanner;

public class TicketPrice
{
	public static void main(String[] args)
	{
		int ticketPrice;

		Scanner myScanner = new Scanner(System.in);

		System.out.println("�������·�");
		int month = myScanner.nextInt();

		System.out.println("����������");
		int age = myScanner.nextInt();

		if (month >= 4 && month <= 10)
		{
			if (age < 18)
			{
				ticketPrice = 30;			
			}
			else if (age > 60)
			{
				ticketPrice = 20;				
			}
			else
			{
				ticketPrice = 60;
			}
		}
		else 
		{
			if (age >= 18 && age <= 60)
			{
				ticketPrice = 40;	
			}
			else
			{
				ticketPrice = 20;
			}
		}

		System.out.println("Ʊ��Ϊ��" + ticketPrice);
	}
}