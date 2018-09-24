public class BookArray
{
	private Book[] array;
	public BookArray(Book[] arrayIn)
	{
		array = arrayIn;
	}
	
	public String toString()
	{
		String x="";
		for (int i = 0; i<array.length; i++)
		{
			x+=array[i].getPrice() + " " + array[i].getCondition()+"\n";
		}
		return x;
	}
}
