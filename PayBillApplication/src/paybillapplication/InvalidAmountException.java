package paybillapplication;

/**
 * @author Moises Henriquez
 * @date April 17, 2016
 */
public class InvalidAmountException extends Exception
{
    public InvalidAmountException(){
        super("An invalid amount exception was thrown");
    }
    
    public InvalidAmountException(String msg){
        super(msg);
    }
}
