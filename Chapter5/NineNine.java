/**
 * Chapter5
 * NineNine.java
 * �žų˷���
 */

public class NineNine
{
	public static void main(String[] args)
	{
		for (int i = 1; i <= 9; i++)
		{
			for	(int j = 1; j <= i; j++)
			{
				int pro = i * j;
				System.out.print(j + " * " + i + " = " +
					pro + "\t");
			}
			System.out.println();
		}
	}
}