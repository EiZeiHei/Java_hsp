/**
 * Chapter5
 * TicketPrice.java
 * 票价
 */

import java.util.Scanner;

public class TicketPrice
{
	public static void main(String[] args)
	{
		int ticketPrice;

		Scanner myScanner = new Scanner(System.in);

		System.out.println("请输入月份");
		int month = myScanner.nextInt();

		System.out.println("请输入年龄");
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

		System.out.println("票价为：" + ticketPrice);
	}
}