import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;


public class RHSX {
	
	public static void main(String[] args) throws IOException {
		
		ArrayList<String> properties = new ArrayList<String>();
		ArrayList<Trader> traders = new ArrayList<Trader>();
		File database = new File("Database.txt");
		Scanner readFile = new Scanner(database);
		while (readFile.hasNext()) {
			properties.add(readFile.next());
		}
		
		for (int i = 0; i < properties.size(); i++) {
			String[] arr = properties.get(i).split("/", 3);
			traders.add(new Trader(arr[0], Integer.parseInt(arr[1]), Integer.parseInt(arr[2])));
		}
		
		for (int i = 0; i < traders.size(); i++) {
			traders.get(i).printTraderInfo();
		}
		
	}
}
