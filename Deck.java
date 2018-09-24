
import java.util.*;
public class Deck
{
     //ArrayList of card objects
     private ArrayList<Card> blah;
     
     public Deck()
     {
       blah = new ArrayList<Card>();
       
     
       for (int i =0; i<14; i++)
       { int x = i+1;
           if (i==10)
           {blah.add(new Card(10, "Hearts", "King"));
            blah.add(new Card(10, "Hearts", "Queen"));
            blah.add(new Card(10, "Hearts", "Jack"));
            Card Hearts = new Card(11, "Hearts", "Ace");
            blah.add(Hearts);
            }
            else if(i==11)
           {blah.add(new Card(10, "Diamonds", "King"));
            blah.add(new Card(10, "Diamonds", "Queen"));
            blah.add(new Card(10, "Diamonds", "Jack"));
            Card Diamonds = new Card(11, "Diamonds", "Ace");
            blah.add(Diamonds);
            }
            else if (i==12)
           {blah.add(new Card(10, "Clubs", "King"));
            blah.add(new Card(10, "Clubs", "Queen"));
            blah.add(new Card(10, "Clubs", "Jack"));
            Card Clubs = new Card(11, "Clubs", "Ace");
            blah.add(Clubs);
            }
            else if (i==13)
           {blah.add(new Card(10, "Spades", "King"));
            blah.add(new Card(10, "Spades", "Queen"));
            blah.add(new Card(10, "Spades", "Jack"));
            Card Spades = new Card(11, "Spades", "Ace");
            blah.add(Spades);
            }
           else
          {blah.add(new Card(x, "Hearts", "" +x ));
           blah.add(new Card(x, "Diamonds", "" +x ));
           blah.add(new Card(x, "Clubs", "" +x));
           blah.add(new Card(x, "Spades", "" +x));
        }
       }
     }
     //works
     public void shuffle()
     {ArrayList<Card> ugh = new ArrayList<Card>();
      int y = blah.size();
         for (int i =0; i<blah.size(); i++)
         {int x = (int)(blah.size()* Math.random());
          ugh.add(blah.remove(x));
          i--;
         }
         
         for (int c =0; c<ugh.size(); c++)
         {blah.add(ugh.get(c));
         }
       }
     
    public int getSize()
    {int x = 0;
        for (int i = 0; i< blah.size(); i++)
        {x++;
        }
        return x;
    }
    public ArrayList<Card> getArray()
    {return blah;
    }
    public Card drawCard()
    {return blah.remove(0);
    }
    
      
  
}