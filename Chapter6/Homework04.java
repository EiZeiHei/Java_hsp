/**
 * Chapter6
 * Homework04.java
 * ���������в���һ��������Ϊ����
 */

import java.util.Scanner;

public class Homework04
{
	public static void main(String[] args)
	{
		int[] arr = {10, 12, 45, 90};

		int[] arrNew = new int[arr.length + 1];
		Scanner myScanner = new Scanner(System.in);
		System.out.println("�����������ݣ�");
		int num = myScanner.nextInt();

		boolean flag = false;
		for(int i = 0, j = 0; i < arrNew.length; i++)
		{
			if(flag == true || arr[j] < num)
			{
				arrNew[i] = arr[j];
				j++;
			}
			else
			{
				arrNew[i] = num;
				flag = true;
			}

			System.out.print(arrNew[i] + "\t");
		}
	}
}