import java.io.*;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.net.UnknownHostException;
import java.io.*;
import java.util.Scanner;
import java.awt.Desktop;
import java.net.URI;

public class ConsoleAppV1
{
	public static void main(String[]args) throws Exception
	{
		System.out.println("Hello user please enter the name of the class and the section ID of the course you are taking.");
		Scanner sc = new Scanner(System.in);
		String x = sc.nextLine();
		if(x.compareTo("CS2263 FRO1A")==0)
		{
			String amazonURL = "https://www.amazon.ca/s/ref=nb_sb_noss_2?url=search-alias%3Dstripbooks&field-keywords=Intermediate+C+Programming";
			AmazonCrawler a = new AmazonCrawler(amazonURL);
			String chaptersURL = "https://www.chapters.indigo.ca/en-ca/home/search/?keywords=intermediate%20c%20programming#page=0&pid=978149871163&sortDirection=&sortKey=";
			ChaptersCrawler c   = new ChaptersCrawler(chaptersURL);
			//c.crawl();
			a.crawl();
			
		}
	}
}