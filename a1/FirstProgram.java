public class FirstProgram
{
	public static void main(String[] args)
	{
		printFrog();
		printOwl();
		System.out.println("");
		approxPi();
	}
	public static void printFrog()
	{
		System.out.println("  @..@  ");
		System.out.println(" (----) ");
		System.out.println("( >__< )");
		System.out.println("\"\"    \"\"");
	}
	public static void printOwl()
	{
		System.out.println("  ^...^  ");
		System.out.println(" / o,o \\ ");
		System.out.println(" |):::(| ");
		System.out.println("===w=w===");
	}
	public static void approxPi()
	{
		double nextTerm = 1;
		double denominator = 1;
		double series = 0;
		
		for(int i=0;i<8;i++)
		{
			series += (nextTerm/denominator);
			denominator += 2;
			nextTerm *= -1;
		}
		series *= 4;
		System.out.println("Beep Boop I've approximated Pi to " + series);
	}
}