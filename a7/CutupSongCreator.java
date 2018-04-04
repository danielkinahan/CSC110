/*
* Name: Daniel Kinahan
* ID: V00887329
* Date: 19/11/2017
* Filename: CutupSongCreator.java
* Details: \CSC110\ Assignment 7
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

/*
 * Class CutupSongCreator is a collection of commands that 
 * test the methods inside and creates an instance of the
 * scanner class.
 */
public class CutupSongCreator
{
	public static void main(String args[])
		throws FileNotFoundException
	{
		Scanner user = new Scanner(System.in);
		System.out.println("Enter a filename ");
		String filename = user.next();

		File f = new File(filename);
		while(!f.canRead())
		{
			System.out.println("Error: File not found");
			System.out.println("Enter a filename ");
			f = new File(user.next());
		}
		Scanner reader = new Scanner(f);
		SongLine[] songs = makeArray(reader);

		sortByLineNumber(songs);
		System.out.println();
	
		System.out.println("What genre are you looking for? ");
		String filterWord = user.next();
		listLinesByGenre(songs, filterWord);
		System.out.println();

		printArray(songs);
		System.out.println();

		makeSong(songs);
	}

	/*
	* Creates an array of SongLines from text file inputted.
	* input: Scanner instance that reads the file
	* returns : An array of SongLines
	*/
	public static SongLine[] makeArray(Scanner reader)
	{
		int x = 0;
		int numLines = reader.nextInt();
		SongLine[] arr = new SongLine[numLines];
		while(reader.hasNext())
		{
			String genre = reader.next();
			int lineNumber = reader.nextInt();
			String line = reader.nextLine();
			arr[x] = new SongLine(genre, lineNumber, line);
			x++;
		}
		return arr;
	}

	/*
	* Prints out lines that contain filter word as a genre
	* input: Array of SongLines and a filter word
	*/
	public static void listLinesByGenre(SongLine[] songs, String filterWord)
	{
		for(int i=0;i<songs.length; i++)
		{
			SongLine current = songs[i];
			String genre = current.getGenre();
			if(genre.equals(filterWord))
			{
				System.out.println(current);
			}
		}
	}

	/*
	* Prints out all objects in the array
	* input: Array of SongLines
	*/
	public static void printArray(SongLine[] songs)
	{
		for(int i=0; i < songs.length; i++)
		{
			System.out.println(songs[i]);
		}
	}

	/*
	* Sorts the array by line number using bubble sorting
	* input: Array of SongLines
	*/
	public static void sortByLineNumber(SongLine[] songs)
	{
		System.out.println("BEFORE SORTING");
		printArray(songs);
		System.out.println("AFTER SORTING");
		boolean canSort = true;
		while(canSort)
		{
			canSort = false;
			for(int i= 0; i<songs.length-1;i++)
			{
				if(songs[i].compareTo(songs[i+1]) > 0)
				{
					SongLine temp = songs[i];
					songs[i] = songs[i+1];
					songs[i+1] = temp;
					canSort = true;
				}
			}
		}
		printArray(songs);

	}

	/*
	* Prints out 21 random objects from the array
	* input: Array of SongLines
	*/
	public static void makeSong(SongLine[] songs)
	{
		Random rand = new Random();
		System.out.println("THE NEW SONG");
		for(int i = 0; i < 21; i++)
		{
			SongLine current = songs[rand.nextInt(songs.length)];
			System.out.println(current.getWords());
		}
	}
}