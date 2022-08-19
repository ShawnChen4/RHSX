import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class RHSX_Interface {
	
	private GraphicsPanel canvas;
	private JFrame frame;
	private JTextField BuyerIDInput;
	private JTextField SellerIDInput;
	private JTextField QuantityInput;
	private JTextField PriceInput;
	private JLabel BuyerID;
	private JLabel SellerID;
	private JLabel Quantity;
	private JLabel Price;
	private JButton enterButton;
	private JPanel buttonPanel;
	private MyKeyListener keyListener; 

	
	RHSX_Interface() {
		frame = new JFrame("Pitboss");
		frame.setSize(1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		canvas = new GraphicsPanel();
		frame.add(canvas);
		frame.setLayout(new FlowLayout());
		canvas.setLayout(new GridLayout(2, 4));
	    
		buttonPanel = new JPanel();
		frame.add(buttonPanel);
		
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
	    
	    BuyerIDInput = new JTextField(10);
	    canvas.add(BuyerIDInput);
	    
	    SellerIDInput = new JTextField(10);
	    canvas.add(SellerIDInput);
	    
	    QuantityInput = new JTextField(10);
	    canvas.add(QuantityInput);
	    
	    PriceInput = new JTextField(10);
	    canvas.add(PriceInput);
	    
	    enterButton = new JButton("Enter");
	    buttonPanel.add(enterButton);
	    enterButton.addActionListener(new EnterButtonListener());
		canvas.addKeyListener(keyListener); 
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
	    System.out.println(BuyerIDInput.getText() + " buys " + QuantityInput.getText() + " shares @" + PriceInput.getText() + " from " + SellerIDInput.getText());
	    BuyerIDInput.setText("");
	    QuantityInput.setText("");
	    PriceInput.setText("");
	    SellerIDInput.setText("");
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
