package PitBoss;
import java.awt.event.*;

public class EnterKeyListener  implements KeyListener
{

    public void keyTyped(KeyEvent e) 
    {
       
       
    }

    public void keyPressed(KeyEvent e) 
    {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_ENTER)
       {
        PitBossGUI.printOut();
       }
    }
    public void keyReleased(KeyEvent e) 
    {
        
    }


}
