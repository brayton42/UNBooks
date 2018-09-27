import java.io.*;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.net.UnknownHostException;

public class AmazonCrawler extends WebCrawler
{
	public AmazonCrawler(String addressIn)
	{
		super(addressIn);
	}
	
	public void crawl() throws IOException
	{
		Document doc = super.crawl(super.getAddress());
        super.setLinks(doc.select("a[href]"));  //intializes the Elements so that only hyperlinks are stored in it 
			
		for (Element link : super.getLinks())  //grabs all the links from the page
		{
         
				String attr1 = link.attr("href"); //puts a flag by the links in each link grabbed
				
				//sees if the result is a book or ebook and removes all review links
                if (attr1.contains("book") && !attr1.contains("review")) //Sees if the link links to a book. If it does the link is added to the Result set.
				{
                    super.add(attr1);
                }
		}
			for (String x: super.getResults()) //prints out each link
			{
				System.out.println(x);
				System.out.println("****");
			}
	}
	
	public void crawlBook() throws IOException
	{
		for(String URL: super.getResults())
		{
            Document doc = Jsoup
                    .connect(URL)
                    .userAgent("Jsoup client")
                    .timeout(5000).get();

            Elements links = doc.select("label"); //change string once can find all the details needed
            Set<String> result = new HashSet<>();

            for (Element link : links) {
				String attr1 = link.attr("title"); //must figure out what to chop off at
			
				result.add(attr1);
			}
			/*To store all the required book info
            for (String el : result) {
                System.out.println(el);
            }*/
			
		}
	}
}