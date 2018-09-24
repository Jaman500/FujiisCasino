/**
 * Write a description of class Wallet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wallet
{
    
    private double cash;

    
    public Wallet()
    {
       cash = 100;
    }

    public double getCash()
    {return cash;
    }
    
    public double win(int bet)
    {
        cash= cash + bet;
        return cash;
    } 

    public double lose(int bet)
    {cash = cash - bet;
        return cash;
    }
    
    public double firstTry(int bet)
    {cash = cash + (bet * 1.5);
        return cash;
    }
    
    public static boolean checkCash(Wallet money)
    {if(money.getCash()<=0)
        {return true;
        }
        return false;
    }
}