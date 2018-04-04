public class Classroom
{
	public static void main(String[] args)
	{
		Student s1 = new Student("Kamel", 70, "Computer");
		Student s2 = new Student("Alex", 80, "Computer");

		boolean same = s1.getMajor().equals(s2.getMajor());
		System.out.println(same);
		
		System.out.println(s1.equals(s2));

	}
}