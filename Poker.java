import java.util.*;
public class Poker
{   public static void dealP(ArrayList<Card> handP, Deck poker)
    {   handP.add(poker.drawCard());
        handP.add(poker.drawCard());
        handP.add(poker.drawCard());
        handP.add(poker.drawCard());
        handP.add(poker.drawCard());
        
    }
    public static void replace(ArrayList<Card> handP, Deck poker, int pick)
    {if(pick == 1)
        {pick = 0;
        }
       else if(pick == 2)
        {pick = 1;
        }
       else if(pick == 3)
        {pick =2;
        }
       else if(pick == 4)
        {pick = 3;
        }
      else  if(pick == 5)
        {pick = 4;
        }
        
        handP.remove(pick);
        handP.add(pick,poker.drawCard());
    }
    public static void arrange(ArrayList<Card> handP)
    {ArrayList<Card> fake = new ArrayList<Card>();
        int place = 0;
        for(int i = 0; i<handP.size(); i++)
        {
            Card lowest = new Card(100, "Diamonds", "100");
            for (int b = 0; b<handP.size(); b++)
            {
               
                handP.get(b).changePoker(handP.get(b));
                if(handP.get(b).getNum()<lowest.getNum())
                {place = b;
                    lowest = handP.get(b);
                    
                }
            }
            fake.add(handP.remove(place));
            i--;
            
            
        }
     for(int i =0; i<fake.size(); i++)
     {handP.add(fake.remove(i));
         i--;
        }
        System.out.println(handP);
    }
    public static String payout(ArrayList<Card> handP, int bet, Wallet money)
    {if(royalFlush(handP) == true)
        {bet = bet*250;
            System.out.println("Your hand contained a royal Flush. Cool.");
            return "You won $" +money.win(bet);
        }
        else if(straightFlush(handP) == true)
        {bet = bet*50;
            System.out.println("Your hand contained a straight flush. Wow you know how to match AND count. Good job");
            return "You won $" +money.win(bet);
        }
        else if(four(handP) == true)
        {bet = bet*25;
            System.out.println("Your hand contained a four of a kind. I mean, that's cool I guess.");
            return "You won $" +money.win(bet);
        }
       else if(fullHouse(handP) == true)
        {bet = bet*9;
            System.out.println("Your hand contained a full house. You probably only know of the show. ");
            return "You won $" +money.win(bet);
        }
        else if(flush(handP) == true)
        {bet = bet*6;
            System.out.println("Your hand contained a flush. Is this a preschool matching game?");
            return "You won $" +money.win(bet);
        }
        else if(straight(handP) == true)
        {bet = bet*4;
            System.out.println("Your hand contained a straight. Congratulations. You know how to count.");
            return "You won $" +money.win(bet);
        }
        else if(three(handP) == true)
        {bet = bet*3;
            System.out.println("Your hand contained a three of a kind. That's decent");
            return "You won $" +money.win(bet);
        }
        else if(twoPair(handP) == true)
        {bet = bet*2;
            System.out.println("Your hand contained two pairs. Slightly good hand.");
            return "You won $" +money.win(bet);
        }
        else if(pair(handP) == true)
        {System.out.println("Your hand contained a pair. Your hand was alright... I guess.");
            return "You won $" +money.win(bet);
        }
        else 
        {System.out.println("Your hand contained nothing. Most likely because you suck. ");
            return "You lost $" +money.lose(bet);
        }
        
    }
    public static boolean pair(ArrayList<Card> handP)
    {ArrayList<Card> check = handP;
       
        
        for(int i =0; i<handP.size(); i++)
        {check.get(i).changePoker(check.get(i));
        }
        if(check.get(0).getNum() == check.get(1).getNum() || check.get(1).getNum() == check.get(2).getNum() ||check.get(2).getNum() == check.get(3).getNum() || check.get(3).getNum() == check.get(4).getNum() )
        {return true;
        }
        return false;
      /* for(int i =0; i< handP.size(); i++)
       {for(int p =1; p<handP.size(); p++)
           {if(check.get(i).getNum() == check.get(p).getNum())
               {return true;
               }
               
           }
           check.remove(i);
           i--;
       }
        return false;*/
    }
    
     public static boolean twoPair(ArrayList<Card> handP)
    {ArrayList<Card> check = handP;
       
        int count = 0;
        for(int i =0; i<handP.size(); i++)
        {check.get(i).changePoker(check.get(i));
        }
        
        {if(handP.get(0).getNum() == handP.get(1).getNum())
            {if(handP.get(2).getNum() == handP.get(3).getNum() || handP.get(3).getNum() == handP.get(4).getNum())
                {return true;
                }
            }
            else if(handP.get(1).getNum() == handP.get(2).getNum())
            {if(handP.get(3).getNum() == handP.get(4).getNum())
                {return true;
                }
            }
            else if(handP.get(2).getNum() == handP.get(3).getNum())
            {if(handP.get(4).getNum() == handP.get(0).getNum() || handP.get(4).getNum() == handP.get(0).getNum())
                {return true;
                }
            }
            if(handP.get(3).getNum() == handP.get(4).getNum())
            {if(handP.get(2).getNum() == handP.get(1).getNum() || handP.get(1).getNum() == handP.get(0).getNum())
                {return true;
                }
            }
        }
        return false;
      /* for(int i =0; i< handP.size(); i++)
       {for(int p =1; p<handP.size(); p++)
           {if(check.get(i).getNum() == check.get(p).getNum())
               {count++;
                   check.remove(p);
                   p--;
               }
               
           }
           check.remove(i);
           i--;
       }
       
       if(count ==2)
       {return true;
        }
        return false;*/
    }
     public static boolean three(ArrayList<Card> handP)
    {ArrayList<Card> check = handP;
       
        
        for(int i =0; i<handP.size(); i++)
        {check.get(i).changePoker(check.get(i));
        }
        if(handP.get(0).getNum() == handP.get(1).getNum() && handP.get(1).getNum() == handP.get(2).getNum())
        {return true;
        }
        else if(handP.get(2).getNum() == handP.get(3).getNum() && handP.get(3).getNum() == handP.get(4).getNum())
        {return true;
        }
        return false;
      /* for(int i =0; i< handP.size(); i++)
       {for(int p =1; p<handP.size(); p++)
           {if(check.get(i).getNum() == check.get(p).getNum())
               {check.remove(p);
                   p--;
                  for(int p1 = 1; p1<check.size(); p1++)
                  {if(check.get(i).getNum() == check.get(p1).getNum())
                      {return true;
                        }
                    }
               }
               
           }
           check.remove(i);
           i--;
       }
        return false;*/
    }
     public static boolean four(ArrayList<Card> handP)
    {ArrayList<Card> safety = handP;
        ArrayList<Card> check = handP;
       
        
        for(int i =0; i<handP.size(); i++)
        {check.get(i).changePoker(check.get(i));
        }
        if(check.get(0).getNum() == check.get(1).getNum() && check.get(1).getNum() == check.get(2).getNum()&& check.get(2).getNum() == check.get(3).getNum() )
        {return true;
        }
        else if(check.get(1).getNum() == check.get(2).getNum() && check.get(2).getNum() == check.get(3).getNum()&& check.get(3).getNum() == check.get(4).getNum() )
        {return true;}
        return false;
       /*for(int i =0; i< handP.size(); i++)
       {for(int p =1; p<handP.size(); p++)
           {if(check.get(i).getNum() == check.get(p).getNum())
               {check.remove(p);
                   p--;
                  for(int p1 = 1; p1<check.size(); p1++)
                  {if(check.get(i).getNum() == check.get(p1).getNum())
                      {check.remove(p1);
                          p1--;
                          for(int p2 = 1; p2<check.size(); p2++)
                          {if(check.get(i).getNum() == check.get(p2).getNum())
                              {for(int j= 0; j<safety.size(); j++)
                                  {handP.add(safety.remove(0));
                                      j--;
                                  }
                                  return true;
                                }
                            }
                        }
                    }
               }
            
           }
           check.remove(i);
           i--;*/
       }
    

    
     public static boolean fullHouse(ArrayList<Card> handP)
    {ArrayList<Card> check = handP;
        for(int i = 0; i<handP.size(); i++)
        {handP.get(i).changePoker(handP.get(i));
        }
        if(handP.get(1).getNum() == handP.get(0).getNum() && handP.get(2).getNum() == handP.get(3).getNum() && handP.get(2).getNum()==handP.get(4).getNum())
        {return true;
        }
        else if(handP.get(4).getNum() == handP.get(3).getNum() && handP.get(0).getNum() == handP.get(1).getNum() && handP.get(0).getNum()==handP.get(2).getNum())
        {return true;
        }
       
        return false;
        
    }
     public static boolean straight(ArrayList<Card> handP)
    {int count = 1;
        int lowest = handP.get(0).getNum();
        
        for(int i = 1; i<handP.size(); i++)
        {if(handP.get(i).getNum() == (lowest + 1))
            { lowest = handP.get(i).getNum();
                count++;
            }
        }
        
        if(count == 5)
        {return true;
        }
        return false;
    }
     public static boolean flush(ArrayList<Card> handP)
    {String color = handP.get(0).getSuit();
        int count =1;
        for(int i =1; i<handP.size(); i++)
        {if (handP.get(i).getSuit().equals(color))
            {count++;
            }
        }
        if(count ==5)
        {return true;
        }
        return false;
    }
    public static boolean straightFlush(ArrayList<Card> handP)
    {if(straight(handP) == true)
        {if(flush(handP) == true)
            {return true;
            }
        }
        return false;
    }
    public static boolean royalFlush(ArrayList<Card> handP)
    {if(flush(handP) == true)
        {
            if(handP.get(0).getFace().equals("Ace") && handP.get(1).getFace().equals("10") && handP.get(2).getFace().equals("Jack") && handP.get(3).getFace().equals("Queen") && handP.get(4).getFace().equals("King"))
            {return true;
            }
        }
        return false;
    }
    
    
    public void main()
    {ArrayList<Card> handP = new ArrayList<Card>();
        Deck poker = new Deck();
        poker.shuffle();
        Wallet money = new Wallet();
        int bet = 10;
       
        dealP(handP, poker);
        arrange(handP);
        
    }
    
    
}