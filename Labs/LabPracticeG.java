public class LabPracticeG
{
	public static void main(String[] args)
	{
		Circle fiona = new Circle(4, "Pink");
		Circle daniel = new Circle(5, "Blue");
		System.out.println("Fiona : " + fiona.getArea());
		System.out.println("Daniel : " + daniel.getArea());

		
		int searchValue = 22;
		int[] arr = {2,4,5,7,8,9,12,14,17,19,22,25,27,28,33};
		System.out.println(binarySearchAlgorithm(22, arr));
			
	}
	
	public static boolean binarySearchAlgorithm(int key, int[] data)
	{
		int low = 0;
		int high = data.length - 1;

		while(high >= low)
		{
			int middle = (high+low)/2;
			if(data[middle] == key)
			{
				return true;
			}
			if(data[middle] > key)
			{
				high = middle - 1;
			}
			if(data[middle] < key)
			{	
				low = middle + 1;
			}
		}
		return false;
	}
}