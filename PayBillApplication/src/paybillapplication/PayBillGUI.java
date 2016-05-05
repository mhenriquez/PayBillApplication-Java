package paybillapplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Moises Henriquez
 * @date April 17, 2016
 */
public class PayBillGUI extends JFrame implements ActionListener
{
    //Instance Variables
    private double totalAmount = 0;
    private int taxAmount = 0;
    private double tipAmount = 0;
    
    //Labels
    JLabel lblTotal = new JLabel("Total Due");
    JLabel lblTax = new JLabel("Tax Rate");
    JLabel lblTip = new JLabel("Tip Rate");
    JLabel lblResponse = new JLabel(String.format("Total Owed $%,.2f", totalAmount));
    
    //TextFields
    JTextField txtTotal = new JTextField(12);
    JTextField txtTax = new JTextField(12);
    JTextField txtTip = new JTextField(12);
    
    //Buttons
    JButton btnCalc = new JButton("Calculate");
    JButton btnExit = new JButton("Exit");
    
    //Constructor
    public PayBillGUI(String title, int width, int height, boolean visible) throws InvalidAmountException, NumberFormatException
    {
        super(title);
        setSize(width, height);
        //
        setLayout(new FlowLayout());
        //
        add(lblTotal);
        add(txtTotal);
        //
        add(lblTax);
        add(txtTax);
        //
        add(lblTip);
        add(txtTip);
        //
        add(lblResponse);
        //
        add(btnCalc);
        btnCalc.addActionListener(this);
        //
        add(btnExit);
        btnExit.addActionListener(this);
        //
        setVisible(visible); //<--Must be placed at end to render added components
    }
    
    //Methods
    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if(source instanceof JButton){
            if(source==btnCalc){
                //Try to parse to double values
                try 
                {
                    totalAmount = Double.parseDouble(txtTotal.getText());
                    taxAmount = Integer.parseInt(txtTax.getText());
                    tipAmount = Double.parseDouble(txtTip.getText());
                    
                    //Try to calculate double values
                    try 
                    {
                        Calculate(totalAmount, taxAmount, tipAmount);
                    }
                    catch (InvalidAmountException ex) 
                    {
                        lblResponse.setText(ex.getMessage());
                    }
                }
                catch(NumberFormatException ex)
                {
                    lblResponse.setText("Error: " + ex.getMessage());
                }
            }else{
                System.exit(0);
            }
        }
    }
    
    public void Calculate(double total, int tax, double tip) throws InvalidAmountException
    {
        if(total < 0 || tax < 0 || tip < 0){
           throw new  InvalidAmountException("Value cannot be less than 0.");
        } else {
            lblResponse.setText(String.format("Total Owed $%,.2f", total + (total * (tax * .01)) + tip));
        }
    }
}
