import java.io.*;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.net.UnknownHostException;

public abstract class WebCrawler
{
	private Set<String> results;
	String address;
	private Elements links;
	
	public WebCrawler(String addressIn)
	{
		address = addressIn;
		results = new HashSet<>();
	}
		
	public void crawl() throws IOException
	{
		Document doc = Jsoup
                    .connect(address)
                    .userAgent("Jsoup client")
                    .timeout(5000).get();

            links = doc.select("a[href]");
	}
	
	public Elements getLinks()
	{
		return links;
	}
	
	public Set<String> getResults()
	{
		return results;
	}
	
	public void add(String attr1)
	{
		results.add(attr1);
	}
	
	public abstract void crawlBook() throws IOException;
}