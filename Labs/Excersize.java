public class Excersize
{
	public static void main(String[] args)
	{
		System.out.println(fac(31));
		System.out.println(fac(12));
	}
	
	public static int fac(int n)
	{
		if(n==0)
		{
			return 1;
		}
		else
		{
			return n*fac(n-1);
		}
	}
}