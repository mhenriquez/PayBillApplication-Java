package paybillapplication;

import javax.swing.*;

/**
 * @author Moises Henriquez
 * @date April 17, 2016
 */
public class PayBillApplication{
    
    public static void main(String[] args) throws InvalidAmountException
    {
        //JFrame variables
        final String FRAME_TITLE = "Pay the Bill";
        final boolean VISIBLE = true;
        final int FRAME_WIDTH = 250;
        final int FRAME_HEIGHT = 300;
        
        //Instatiate new GUI class
        PayBillGUI window = new PayBillGUI(FRAME_TITLE, FRAME_WIDTH, FRAME_HEIGHT, VISIBLE);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
