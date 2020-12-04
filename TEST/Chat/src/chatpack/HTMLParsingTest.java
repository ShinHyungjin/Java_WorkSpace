package chatpack;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class HTMLParsingTest {
	Elements element;

	public HTMLParsingTest() {
		Document doc;
		try {
			doc = Jsoup.connect("https://rss.blog.naver.com/brave_mobile_mkt.xml").get();
			System.out.println(doc.title());

			element = doc.select("item").select("link");
			System.out.println(element.text());
			int urlstart = 0, urlend = 0;
			
			while( true ) {
				urlstart = element.text().indexOf("https", urlend);
				System.out.print("urlStart : " + urlstart);
				urlend = element.text().indexOf("https", urlstart+1);
				System.out.print("\turlEnd : " + urlend);
				if( (urlstart == -1 || urlend == -1) )
					break;
				System.out.println("\t"+element.text().substring(urlstart, urlend));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new HTMLParsingTest();
	}
}
