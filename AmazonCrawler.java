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
		super.crawl();
		for (Element link : super.getLinks()) {

                String attr1 = link.attr("href");
				
				//change String to address for amazon book id
                if (attr1.startsWith("")) {
                    super.add(attr1);
                }
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