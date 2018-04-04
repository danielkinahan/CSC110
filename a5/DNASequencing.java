/*
* Name: Daniel Kinahan
* ID: V00887329
* Date: 30/10/2017
* Filename: DNASequencing.java
* Details: \CSC110\ Assignment 5
*/

/*
* The class DNASequencing contains tests of each method.
*/
public class DNASequencing
extends Object
{
	public static void main(String[] args)
	{
		String[] test = {"ACGT", "AACCGGTT", "ACT", "AACT", "AACCGTT", "ACGT", "ACGT"};
		printArray(test);

		System.out.println("There are " + countTotalMutations(test) + " mutations.");

		System.out.println("ACGT appears " + findFrequency("ACGT", test)+ " times.");
		
		System.out.println("ACGT appears " + findFreqWithMutations("ACGT", test) + " times including mutations.");

		System.out.println(test[1] + " with all mutations removed is " + removeMutation(test[1]));

		System.out.println("The longest String is " + findLongest(test));

		System.out.println("Does " + test[1] + " have a mutation? " + hasMutation(test[1]));


	}

	/*
	* Counts all mutations that exist in an array of DNA sequencing
	* input: An array of DNA sequencing.
	* returns : The amount of sequences that have mutations as an integer.
	*/
	public static int countTotalMutations(String[] seqArray)
	{
		int x = 0;
		for(int i = 0; i<seqArray.length;i++)
		{
			if(hasMutation(seqArray[i]))
			{
				x++;
			}
		}
		return x;
	}

	/*
	* Finds amount of times a String exists in an array of Strings.
	* input: An array of Strings and the target String.
	* returns : The amount of times the target appears as an integer.
	*/
	public static int findFrequency(String target, String[] strings)
	{
		int x = 0;
		for(int i=0; i<strings.length;i++)
		{
			if(strings[i].equals(target))
			{
				x++;
			}
		}
		return x;
	}
	
	/*
	* Finds amount of times a DNA sequence exists in an array of sequences
	* including all of its mutations.
	* input: An array of DNA sequences and the target sequence.
	* returns : The amount of times the sequence appears as an integer.
	*/
	public static int findFreqWithMutations(String target, String[] seqArray)
	{
		int x = 0;
		for(int i=0; i<seqArray.length;i++)
		{
			if(seqArray[i].equals(target))
			{
				x++;
			}
			else if(hasMutation(seqArray[i]))
			{
				if(target.equals(removeMutation(seqArray[i])))
				{
					x++;
				}
			}
		}
		return x;
	}
	
	/*
	* Takes a string with repeat characters and removes them.
	* input: A String sequence of DNA.
	* returns : The same String without repeat characters.
	*/
	public static String removeMutation(String sequence)
	{
		String unmutated = "";
		unmutated += sequence.substring(0,1);
		for(int i = 1; i<sequence.length();i++)
		{
			if(sequence.charAt(i)!=sequence.charAt(i-1))
			{
				unmutated += Character.toString(sequence.charAt(i));
			}
		}
		return unmutated;
	}

	/*
	* Finds the longest String in an array of Strings.
	* input: An array of Strings.
	* returns : The longest String.
	*/
	public static String findLongest(String[] strings)
	{
		String longest = "";
		for(int i=0; i<strings.length;i++)
		{
			String current = strings[i];
			if(current.length()>longest.length())
			{
				longest = current;
			}
		}
		return longest;
	}

	/*
	* Determines if a DNA sequence is mutated, i.e. has repeated characters.
	* input: sequence A String sequence of two to four
	* of the following characters: {A,C,G,T}
	* returns: true if the DNA sequence is mutated, false if it is not.
	*/
	public static boolean hasMutation(String sequence)
	{
		boolean sameLetter = false;
		for(int i = 1; i<sequence.length();i++)
		{
			if(sequence.charAt(i)==sequence.charAt(i-1))
			{
				sameLetter=true;
			}
		}
		return sameLetter;
	}

	/*
	* Prints each String in an array on its own line.
	* input: An array of strings.
	* returns : Each item printed to the console.
	*/
	public static void printArray(String[] strings)
	{
		System.out.println("The array contains the following: ");
		for(int i=0; i<strings.length;i++)
		{
			System.out.println(strings[i]);
		}
	}
}