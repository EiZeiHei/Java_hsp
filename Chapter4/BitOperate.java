/**
 * Chapter4
 * BitOperate.java
 * Î»ÔËËã
 */

public class BitOperate
{
	public static void main(String[] args)
	{
		int a = 1 >> 2;
		int b = -1 >> 2;
		int c = 1 << 2;
		int d = -1 << 2;
		int e = 3 >>> 2;

		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		System.out.println("d = " + d);
		System.out.println("e = " + e);

		System.out.println(~2);
		System.out.println(2&3);
		System.out.println(2|3);
		System.out.println(~-5);
		System.out.println(13&7);
		System.out.println(5|4);
		System.out.println(-3^3);
	}
}