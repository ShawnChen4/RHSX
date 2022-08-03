package PitBoss;

// Need these imports to make a GUI
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PitBossGUI
{

  static JTextField BuyerIDInput;
  static JTextField SellerIDInput;
  static JTextField QuantityInput;
  static JTextField PriceInput;
  static EnterKeyListener EnterKey;
  
  public static void main(String []args)
  {
    JLabel BuyerID;
    JLabel SellerID;
    JLabel Quantity;
    JLabel Price;
    
    
    JButton enterButton;

    JFrame frame = new JFrame("PITBOSS");
    frame.setSize(1280,720);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new FlowLayout());
    
    
    JPanel mainPanel = new JPanel();
    frame.add(mainPanel);
    mainPanel.setLayout(new GridLayout(2,4));

    JPanel buttonPanel = new JPanel();
    frame.add(buttonPanel);
    
    BuyerID = new JLabel("Enter Buyer ID");
    BuyerID.setFont(new Font("Arial", Font.PLAIN, 15));
    mainPanel.add(BuyerID);
    
    SellerID = new JLabel("Enter Seller ID");
    SellerID.setFont(new Font("Arial", Font.PLAIN, 15));
    mainPanel.add(SellerID);
    
    Quantity = new JLabel("Enter Quantity");
    Quantity.setFont(new Font("Arial", Font.PLAIN, 15));
    mainPanel.add(Quantity);
    
    Price = new JLabel("Enter Price");
    Price.setFont(new Font("Arial", Font.PLAIN, 15));
    mainPanel.add(Price);
    
    BuyerIDInput = new JTextField(10);
    mainPanel.add(BuyerIDInput);
    
    SellerIDInput = new JTextField(10);
    mainPanel.add(SellerIDInput);
    
    QuantityInput = new JTextField(10);
    mainPanel.add(QuantityInput);
    
    PriceInput = new JTextField(10);
    mainPanel.add(PriceInput);
    
    //enterButton = new JButton("Enter");
    //buttonPanel.add(enterButton);
    //enterButton.addActionListener(new EnterButtonListener());
    //frame.addKeyListener(EnterKey);
    //keylistener doesn't work
    
    frame.setVisible(true);
  }

  public static void printOut()
  {
    System.out.println(BuyerIDInput.getText() + " buys " + QuantityInput.getText() + " shares @" + PriceInput.getText() + " from " + SellerIDInput.getText());
    BuyerIDInput.setText("");
    QuantityInput.setText("");
    PriceInput.setText("");
    SellerIDInput.setText("");
  }
}
