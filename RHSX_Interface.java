import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import java.util.*;
import javax.swing.BorderFactory;
import javax.swing.plaf.DimensionUIResource;


public class RHSX_Interface {
	
	private GraphicsPanel canvas;
	private JFrame frame;
	private JTextField QuantityInput;
	private JTextField PriceInput;
	private JLabel BuyerID;
	private JLabel SellerID;
	private JLabel Quantity;
	private JLabel Price;
	private JLabel printLabel;
	private JButton enterButton;
	private JPanel buttonPanel;
	private MyKeyListener keyListener; 
	private ArrayList<String> properties;
	private ArrayList<Trader> traders;
	private File database;
	private String[] buyerIDArr;
	private String[] sellerIDArr;
	private JComboBox buyerDropDown;
	private JComboBox sellerDropDown;
	private String print = " --- open --- ";
	private int size ;
	private double price;
	
	
	RHSX_Interface() {

		frame = new JFrame("Pitboss");
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		canvas = new GraphicsPanel();
		frame.add(canvas);
		canvas.setLayout(new GridLayout(2, 4));
		buttonPanel = new JPanel();
		frame.add(buttonPanel);
		frame.setBounds(0, 0, 600, 500);

		printLabel = new JLabel(print);
		printLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		frame.add(printLabel);

		keyListener = new MyKeyListener();

	    BuyerID = new JLabel("Enter Buyer ID");
	    BuyerID.setFont(new Font("Arial", Font.PLAIN, 15));
	    canvas.add(BuyerID);
	    
	    SellerID = new JLabel("Enter Seller ID");
	    SellerID.setFont(new Font("Arial", Font.PLAIN, 15));
	    canvas.add(SellerID);
	    
	    Quantity = new JLabel("Enter Quantity");
	    Quantity.setFont(new Font("Arial", Font.PLAIN, 15));
	    canvas.add(Quantity);
	    
	    Price = new JLabel("Enter Price");
	    Price.setFont(new Font("Arial", Font.PLAIN, 15));
	    canvas.add(Price);
	    

	    
	    enterButton = new JButton("Enter");
	    buttonPanel.add(enterButton);
	    enterButton.addActionListener(new EnterButtonListener());
		canvas.addKeyListener(keyListener); 
		database = new File("Database.txt");
		
		
	}
	
	public void collectInfo() throws IOException {
		
		properties = new ArrayList<String>();
		traders = new ArrayList<Trader>();
		Scanner readFile = new Scanner(database);
		while (readFile.hasNext()) {
			properties.add(readFile.next());
		}
		
		for (int i = 0; i < properties.size(); i++) {
			String[] arr = properties.get(i).split("/", 3);
			traders.add(new Trader(arr[0].toUpperCase(), Integer.parseInt(arr[1]), Double.parseDouble(arr[2])));
		}
		
		for (int i = 0; i < traders.size(); i++) {
			traders.get(i).printTraderInfo();
		}
		
		buyerIDArr = new String[traders.size()];
		sellerIDArr = new String[traders.size()];
		for (int i = 0; i < traders.size(); i++) {
			buyerIDArr[i] = traders.get(i).getTraderID();
			sellerIDArr[i] = traders.get(i).getTraderID();
		}

		buyerDropDown = new JComboBox(buyerIDArr);
		canvas.add(buyerDropDown);
		canvas.repaint();

		sellerDropDown = new JComboBox(buyerIDArr);
		canvas.add(sellerDropDown);
		canvas.repaint();
	    
	    QuantityInput = new JTextField(10);
	    canvas.add(QuantityInput);
	    
	    PriceInput = new JTextField(10);
	    canvas.add(PriceInput);

		frame.setVisible(true);
		
	}
	
	public void run() {
		while (true) {
			frame.repaint();
			try  {Thread.sleep(10);} catch(Exception e){}
		}
	}
	
	  public void printOut()
	  {
		size = Integer.parseInt(QuantityInput.getText());
		price =  Math.floor(Double.parseDouble(PriceInput.getText()) * 100) / 100;

	    System.out.println(buyerDropDown.getSelectedItem() + " buys " + size + " shares @" + price + " from " + sellerDropDown.getSelectedItem());
	    
		print = "<html><p>" + buyerDropDown.getSelectedItem() + " buys " + QuantityInput.getText()  + " shares @" + PriceInput.getText() + " from " + sellerDropDown.getSelectedItem() +"<br/>" + print +"</p></html>";

		//print = buyerDropDown.getSelectedItem() + " buys " + size + " shares @" + price + " from " + sellerDropDown.getSelectedItem();
		printLabel.setText(print);

		traders.get(buyerDropDown.getSelectedIndex()).setTraderBalance( traders.get(buyerDropDown.getSelectedIndex()).getTraderBalance()-(size*price));
		traders.get(buyerDropDown.getSelectedIndex()).setSharesOwned(traders.get(buyerDropDown.getSelectedIndex()).getSharesOwned() + size);
		traders.get(sellerDropDown.getSelectedIndex()).setTraderBalance( traders.get(sellerDropDown.getSelectedIndex()).getTraderBalance()+(size*price));
		traders.get(sellerDropDown.getSelectedIndex()).setSharesOwned(traders.get(sellerDropDown.getSelectedIndex()).getSharesOwned() - size);


		for (int i = 0; i < traders.size(); i++) {
			traders.get(i).printTraderInfo();
		}
		
		QuantityInput.setText("");
	    PriceInput.setText("");
	  }
	
	
	public class GraphicsPanel extends JPanel {
		GraphicsPanel() {
			setFocusable(true);
			requestFocusInWindow();
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
		}
	}
	
	public class EnterButtonListener implements ActionListener {
	
	    public void actionPerformed (ActionEvent event) {
	      printOut();
	    }
	}
	
	public class MyKeyListener implements KeyListener {
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if (key == KeyEvent.VK_ENTER) {
				printOut();
			}
		}
		public void keyReleased(KeyEvent e) {}
		public void keyTyped(KeyEvent e) {}
	}
	
}
