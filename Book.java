public class Book implements Comparable <Book>
{
	private String name;
	private String isbn3;
	private String isbn10;
	private String author;
	private boolean onlineCode;
	private String course;
	private double price;
	int condition;
	//shipping??
	
	public Book(String nameIn, String isbn3In, String isbn10In, String authorIn,
				boolean onlineCodeIn, String courseIn, double priceIn, int conditionIn)
	{
		name = nameIn;
		isbn3 = isbn3In;
		isbn10 = isbn10In;
		author = authorIn;
		onlineCode = onlineCodeIn;
		course = courseIn;
		price = priceIn;
		condition = conditionIn;
	}
	
	
	public String getName()
	{
		return name;
	}
	
	public String getIsbn3()
	{
		return isbn3;
	}
	
	public String getIsbn10()
	{
		return isbn10;
	}
	
	public String getAuthor()
	{
		return author;
	}
	
	public boolean getOnlineCode()
	{
		return onlineCode;
	}
	
	public String getCourse()
	{
		return course;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public int getCondition()
	{
		return condition;
	}
	
	public String hasOnlineCode()
	{
		if (onlineCode ==true)
		{
			return "Has access code";
		}
		else
		{
			return "No access code";
		}
	}
		
	
	public int compareTo(Book other)
	{
		if (condition == other.condition && isbn3 == other.isbn3 || isbn10 ==other.isbn10)
		{
			if (price >= other.price)
			{
				return 1;
			}
			else
			{
				return -1;
			}
		}
		else //if the books turn out not to be the same condition
		{
			return -2;
		}
	}
}