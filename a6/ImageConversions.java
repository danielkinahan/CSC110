/*
* Name: Daniel Kinahan
* ID: V00887329
* Date: 06/11/2017
* Filename: ImageConversions.java
* Details: \CSC110\ Assignment 6
*/

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

/*
 * Class ImageConversions is a collection of methods that convert jpg images
 * into variations.
 */
public class ImageConversions {
	
	/*
	 * Handles all input instructions and relays the information to the
	 * appropriate method.
	 * If the input is not as specified, the program stops, with an informative message.
	 * @param args The input necessary to execute the appropriate conversion.
	 * The array is formated in one of the following ways:
	 * <ul style="list-style:none;">
	 * <li>[infile outfile] invert
	 * 	<ul style="list-style:none;">
	 *	<li>infile: image file  outfile: image file</li>
	 * 	</ul></li>
	 * <li>[infile outfile] verticalFlip</li>
	 * <li>[infile outfile] horizontalFlip</li>
	 * <li>[infile outfile] makeAscii</li>
	 * <li>[infile outfile] scale [scalefactor]
	 *	<ul style="list-style:none;">
	 *	<li>scalefactor: A number: 1 maintains original size, &lt; 1 reduces size, &gt; 1 enlarges size.</li>
	 *	</ul></li>
	 * <li>[infile outfile] rotate</li>
	 * </ul>
	 */
	public static void main(String[] args)
	{
		int[][] image = readGrayscaleImage(args[0]);
		String outputName = args[1];
		String method = args[2];
		double scaleFactor=0;
		if(args.length==4)
		{
			scaleFactor = Double.parseDouble(args[3]);
		}
		if(method.equals("invert"))
		{
			writeGrayscaleImage(outputName, invert(image));
		}
		else if(method.equals("verticalFlip"))
		{
			writeGrayscaleImage(outputName, verticalFlip(image));
		}
		else if(method.equals("horizontalFlip"))
		{
			writeGrayscaleImage(outputName, horizontalFlip(image));
		}
		else if(method.equals("makeAscii"))
		{
			makeAscii(outputName, image);
		}
		else if(method.equals("scale"))
		{
			writeGrayscaleImage(outputName, scale(image, scaleFactor));
		}
		else if(method.equals("rotate"))
		{
			writeGrayscaleImage(outputName, rotate(image));
		}
	}	

	/*
	* Inverts the colours of the photo(black and white)
	* input: A 2d array with integer grey values
	* returns : A 2d array with those integers inversed
	*/
	public static int[][] invert(int[][] x)
	{
		int n = 255;
		int[][] result = new int[x.length][x[0].length];
		for (int i=0; i<x.length; i++) {
			for (int j=0; j<x[0].length; j++)
			{
				result[i][j]=(n - x[i][j]);
			}
		}
		return result;
	}

	/*
	* Flips the array vertically
	* input: A 2d array with integer grey values
	* returns : A 2d array with those flipped over the x-axis
	*/
	public static int[][] verticalFlip(int[][] x)
	{
		int[][] result = new int[x.length][x[0].length];
		int vertX = x.length-1;
		for(int i=0;i<x.length;i++)
		{
			for(int j=0;j<x[0].length;j++)
			{
				result[i][j]= x[vertX][j];
			}
			vertX--;
		}
		return result;
	}

	/*
	* Flips the array horizontally
	* input: A 2d array with integer grey values
	* returns : A 2d array with those flipped over the y-axis
	*/
	public static int[][] horizontalFlip(int[][] x)
	{
		int[][] result = new int[x.length][x[0].length];
		int horizX = x[0].length-1;
		for(int j=0;j<x[0].length;j++)
		{
			for(int i=0;i<x.length;i++)
			{
				result[i][j]= x[i][horizX];
			}
			horizX--;
		}
		return result;
	}

	/*
	* Converts the array from integers to ascii values based on white space taken
	* and prints them as a string in a text file
	* input: A 2d array with integer grey values
	* throws : runtime error
	*/
	public static void makeAscii(String outputName, int[][] x)
	{
		char[][] result = new char[x.length][x[0].length];
		for(int i=0;i<x.length;i++)
		{
			for(int j=0;j<x[0].length;j++)
			{
				int shade = x[i][j];
				if(shade>=0&&shade<21)
				{
					result[i][j]='M';
				}
				else if(shade>20&&shade<41)
				{
					result[i][j]='L';
				}
				else if(shade>40&&shade<61)
				{
					result[i][j]='I';
				}
				else if(shade>60&&shade<81)
				{
					result[i][j]='o';
				}
				else if(shade>80&&shade<101)
				{
					result[i][j]='|';
				}
				else if(shade>100&&shade<121)
				{
					result[i][j]='=';
				}
				else if(shade>120&&shade<141)
				{
					result[i][j]='*';
				}
				else if(shade>140&&shade<161)
				{
					result[i][j]=':';
				}
				else if(shade>160&&shade<181)
				{
					result[i][j]='-';
				}
				else if(shade>180&&shade<201)
				{
					result[i][j]=',';
				}
				else if(shade>2000&&shade<221)
				{
					result[i][j]='.';
				}
				else
				{
					result[i][j]=' ';
				}
			}
		}
		String content = "";
		for(int i = 0; i<result.length;i++)
		{
			for(int j = 0; j<result[0].length;j++)
			{
				char a = result[i][j];
				content += Character.toString(a);
			}
			content += "\n";
		}
		try{
			File file = new File(outputName);
			if (!file.exists())
			{
               		 	file.createNewFile();
            		}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
		}
		catch(Exception IOException)
		{
			System.out.println("IOException");
		}
	}

	/*
	* Scales the array to enlarge or decrease in size
	* input: A 2d array with integer grey values
	* returns : A 2d array made smaller or larger
	*/
	public static int[][] scale(int[][] x, double scaleFactor)
	{
		int resultRow = (int)Math.round(x.length * scaleFactor);
		int resultCol = (int)Math.round(x[0].length * scaleFactor);
		int[][] result = new int[resultRow][resultCol];
		int z = 0;
            	int count = 0;
            	int c;

            	for (int i = 0; i < resultRow; i++)
		{
                	c = 0;
                	for (int j = 0; j < x[0].length; j++)
			{
	  			for (int k = 0; k < scaleFactor; k++)
				{
                       			result[i][c] = x[z][j];
                       			c++;
               			}
               		}
               		count++;
               		if (count>=scaleFactor)
			{
               			z++;
                		count = 0;
                	}
		}
		return result;
	}
	
	/*
	* Rotates the array 90 degrees clockwise
	* input: A 2d array with integer grey values
	* returns : A 2d array with those values transposed and reversed
	*/
	public static int[][] rotate(int[][] x)
	{
		int len = x.length -1;
		int[][] result = new int[x[0].length][x.length];
		for(int i=0;i<x[0].length;i++)
		{
			for(int j=0;j<x.length;j++)
			{
				result[i][j]= x[len-j][i];
			}
		}
		return result;
	}

	 /* Reads an image file and converts it to a 2D array
	 * of integers.
	 * Each value in the array is a representation
	 * of the corresponding pixel's grayscale value.
	 * @param filename The name of the image file
	 * @return A 2D array of integers.
	 * @throws RuntimeException if the input file cannot be found or read.
	 */
	public static int[][] readGrayscaleImage(String filename)
	{
		int[][] result = null;
		File imageFile = new File(filename);
		BufferedImage image = null;
		try
		{
			image = ImageIO.read(imageFile);
		}
		catch (IOException ioe)
		{
			System.err.println("Problems reading file named " + filename);
			throw new RuntimeException("Please ensure the image file is saved in the same directory as your java file.");
		}
		int height = image.getHeight();
		int width  = image.getWidth();
		result = new int[height][width];
		int rgb;
		for (int x = 0; x < width; x++)
		{
			for (int y = 0; y < height; y++)
			{
				rgb = image.getRGB(x, y);
				result[y][x] = rgb & 0xff;
			}
		}
		return result;
	}

	// THIS METHOD MAY BE CALLED, BUT MUST NOT BE MODIFIED!
	/**
	 * Reads a 2D array of integers and creates
	 * a grayscale image. Each pixel's grayscale value is
	 * based on the corresponding value in the 2D array.
	 * @param filename The name of the image file to create
	 * @param array The 2D array of integers
	 */
	public static void writeGrayscaleImage(String filename, int[][] array)
	{
		int width = array[0].length;
		int height = array.length;
		BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);

		int rgb;
		for (int x = 0; x < width; x++)
		{
			for (int y = 0; y < height; y++)
			{
				rgb = array[y][x];
				rgb |= rgb << 8;
				rgb |= rgb << 16;
				image.setRGB(x, y, rgb);
			}
		}
		File imageFile = new File(filename);
		try
		{
			ImageIO.write(image, "jpg", imageFile);
		}
		catch (IOException ioe) {
			System.err.println("The file could not be created " + filename);
			return;
		}
	}
}