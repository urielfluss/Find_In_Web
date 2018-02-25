import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class a {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("insert URL");
		Scanner s= new Scanner(System.in);
		String www=s.nextLine();

		int count=0;
		URL url=new URL(www);
		
		Map <String,Integer> counter= new HashMap<>();
		while(true) {
			System.out.println("---insert WORD");
			Scanner w= new Scanner(System.in);
			String word=w.nextLine();
			
			System.out.println("connecting to: "+www+"\nsearching: "+word);
			Scanner web = new Scanner(new InputStreamReader(url.openStream()));
			while(web.hasNext()) {
				String str=web.next();
				if(str.contains(word)) {
					count++;
					counter.merge(word, 1 , (x,y)->x+y);
				}
			}
			System.out.println("\nresults:");
			for(Map.Entry<String, Integer> e: counter.entrySet()) {
				System.out.println(e.getKey()+" === "+e.getValue());
			}
		}
	}
}