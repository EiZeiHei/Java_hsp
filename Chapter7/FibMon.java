/**
 * Chapter7
 * FibMon.java
 * 斐波那契数列 & 猴子吃桃问题
 */

public class FibMon
{
	public static void main(String[] args)
	{
		FibMonA a = new FibMonA();

		System.out.println(a.fibo(7));
		System.out.println(a.monkey(10));

	}
}

class FibMonA
{
	public int fibo(int n)
	{
		if(n == 1 || n == 2)
		{
			return 1;
		}
		else
		{
			return fibo(n -1) + fibo(n - 2);
		}
	}

	public int monkey(int n)
	{
		if(n == 1)
		{
			return 1;
		}
		else
		{
			return 2 * (monkey(n - 1) + 1);
		}
	}
}