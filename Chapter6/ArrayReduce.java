/**
 * Chapter6
 * ArrayReduce.java
 */

import java.util.Scanner;

public class ArrayReduce
{
	public static void main(String[] args)
	{
		Scanner myScanner = new Scanner(System.in);

		int[] arr = {1, 2, 3, 4, 5};
		int i = 4;

		do
		{
			if(i == 0)
			{
				System.out.println("�޷���������");
				break;
			}

			System.out.println("�Ƿ������������y����n����");
			char key = myScanner.next().charAt(0);

			if(key == 'n')	break;

			System.out.print("������");

			int[] tmp = new int[i];
			for(int j = 0; j < i; j++)
			{
				tmp[j] = arr[j];
				System.out.print(tmp[j] + "\t");	
			}

			i--;
			System.out.println("\n");

		}while(true);
	}
}