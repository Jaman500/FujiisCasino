import java.util.*;
public class Blackjack
{//Make Wallet methods work in here.
    //deal cards
    public static void deal(Deck ugh, ArrayList<Card> hand)
    {for(int i =0; i<hand.size(); i++)
        {hand.remove(0);
            i--;
        }
     hand.add(ugh.drawCard());
     hand.add(ugh.drawCard());   
     System.out.println("You received " + hand);
     System.out.println("You have " + countCards(hand));
     
     
    }
    public static void dealComp(Deck ugh, ArrayList<Card> compHand)
    {
        for (int i =0; i<compHand.size(); i++)
        {compHand.remove(0);
            i--;
        }
        compHand.add(ugh.drawCard());
        System.out.println("Dealer has a " + compHand);
        System.out.println("Dealer shows " + countCards(compHand));
    }
    //double down
    public static int doubleDown(int bet, Deck ugh, ArrayList<Card> hand)
    {int newBet = 2*bet;
        hand.add(ugh.drawCard());
        sop("You received " + hand);
        sop("You have " + countCards(hand));
        return newBet;
        
        

    }
    //hit
    public static void hit(Deck ugh, Card Clubs, ArrayList<Card> hand)
    { 
        hand.add(ugh.drawCard());
        if(hand.get(hand.size()-1).equals(Clubs) && countCards(hand)>21)
        {hand.get(hand.size() - 1).changeAce();
        }
        System.out.println(hand);
        System.out.println("You now have "+ countCards(hand));
        
        
        
    }
    public static void compHit(Deck ugh, Card Clubs, ArrayList<Card> compHand)
    {compHand.add(ugh.drawCard());
        if(compHand.get(compHand.size()-1).equals(Clubs) && countCards(compHand)>21)
        {
        compHand.get(compHand.size() - 1).changeAce();
    }
    System.out.println(compHand);
    System.out.println("Dealer now has "+ countCards(compHand));
    }
    //computer turn
    public static String comp(Deck ugh, Card Clubs, ArrayList<Card> compHand, ArrayList<Card> hand, int bet, Wallet money)
     {Scanner sc = new Scanner(System.in);
         if(countCards(compHand) <= 16 || (countCards(compHand) <= 17 && checkAce(Clubs, compHand) == true))
        {while(countCards(compHand) <= 16 || (countCards(compHand) <= 17 && checkAce(Clubs, compHand) == true))
        {sop("Dealer hits");
            compHit(ugh,Clubs, compHand);
         checkBust(hand, compHand, money, bet);
         sop("Press Enter To Continue");
         sc.nextLine();
        }
        if(checkBust(hand, compHand, money, bet) == false)
        {System.out.println(checkWin(hand, compHand, money, bet));
        }
      } 
        
        
        
        else 
        {return "Computer Stays with a " + countCards(compHand);
        }
        return "";
    }
    //count cards
   public static int countCards(ArrayList<Card> hand)
   {int count =0;
       for(int i = 0; i<hand.size(); i++)
       { count += hand.get(i).getNum();
       }
       return count;
   }
   
   public static boolean check21(ArrayList<Card> hand, ArrayList<Card> compHand, Wallet money, int bet)
   {if (countCards(hand) == 21)
       {money.win(bet);
       return true;
    }
    return false;
   }
   public static boolean checkFirstTry(ArrayList<Card> hand, ArrayList<Card> compHand, Wallet money, int bet)
   {if(countCards(hand)==21 && hand.size() == 2)
        {money.firstTry(bet);
         sop("Blackjack on your first try! you get 1.5 times your bet!");  
           return true;
        }
       return false;
    }
    public static boolean checkBust(ArrayList<Card> hand, ArrayList<Card> compHand, Wallet money, int bet)
    { if(countCards(hand) >21)
        {System.out.println(checkWin(hand, compHand, money, bet));
            return true;
        }
        return false;
    }
    public static String checkWin(ArrayList<Card> hand, ArrayList<Card> compHand, Wallet money, int bet)
    {int pl = countCards(hand);
        int c = countCards(compHand);
        if(pl>21)
        { money.lose(bet);
            return "Bust!";
           
        }
        else if(c>21)
        {money.win(bet); 
            return "Bust!";
            
        }
        else if (pl==21)
        {money.win(bet);
            return "Blackjack!";
        }
        else if (c==21)
        {money.lose(bet);
            return "Dealer gets Blackjack!";
        }
        else if (pl>c)
        {money.win(bet); 
            return "You win!";
            
            
        }
        else if (c>pl)
        {money.lose(bet);
            return "You lose!";
            
        }
        else
        {return "Tie!";
        }
    }
   public static void sop(String sent)
    {System.out.println(sent);
    }
    public static boolean checkAce(Card Clubs, ArrayList<Card> compHand)
    { for(int i = 0; i<compHand.size(); i++)
        {if (compHand.get(i).equals(Clubs))
            {return true;
            }
        }
        return false;
    }
    
}