import java.io.*;

public class RHSX {
	
	public static void main(String[] args) throws IOException {
	
		RHSX_Interface GUI = new RHSX_Interface();
		GUI.collectInfo();
		GUI.run();
	}
}
