public class Student
{
	private String name;
	private int GPA;
	private String major;

	public Student(String name, int GPA, String major)
	{
		this.name = name;
		this.GPA = GPA;
		this.major = major;
	}
	
	public boolean isLoser()
	{
		if(name.equals("Fiona"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void setMajor(String major)
	{
		this.major = major;
	}

	public String getMajor()
	{
		return this.major;
	}
	
	public void setGPA(int GPA)
	{
		this.GPA=GPA;
	}

	public int getGPA()
	{
		return GPA;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public boolean equals(Student other)
	{
		if(!name.equals(other.getName()))
		{
			return false;
		}
		else if(!major.equals(other.getMajor()))
		{
			return false;
		}
		else if(GPA!=other.getGPA())
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	public String toString()
	{
		return ("Student name: " + name + " The GPA: " + GPA + " Department: " + major);
	}
}