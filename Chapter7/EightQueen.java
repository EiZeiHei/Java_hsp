/**
 * Chapter7
 * EightQueen.java
 * 八皇后问题
 */

public class EightQueen
{
	int num = 8;
	static int count = 0;
	int[] arr = new int[num];

	public static void main(String[] args)
	{
		EightQueen a = new EightQueen();
		a.queenPut(0);
		System.out.println("共有 " + count + " 种摆放方式");
	}

	public void queenPut(int n)
	{
		if(n == num)
		{
			printQueen();
			return;
		}
		else
		{
			for(int i = 0; i < num; i++)
			{
				arr[n] = i;
				if(flag(n))
				{
					queenPut(n + 1);
				}
			}
		}
	}

	public boolean flag(int n)
	{
		for(int i = 0; i < n; i++)
		{
			if(arr[i] == arr[n] || Math.abs(arr[i] - arr[n]) == Math.abs(i - n))
			{
				return false;
			}
		}
		return true;
	}

	public void printQueen()
	{
		for(int i = 0; i < num; i++)
		{
			System.out.print(arr[i] + "\t");
		}
		System.out.println();
		count++;
	}
}