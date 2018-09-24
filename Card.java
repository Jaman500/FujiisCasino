
public class Card
{
    // instance variables - replace the example below with your own
    private int value;
    private String suit;
    private String name; //jack,queen,king

    public Card(int num, String type, String face)
    {
        value = num;
        suit = type;
        name = face;

    }
    //WORKS
    public String getFace()
    {return name;
    }
    //WORKS
    public String getSuit()
    {return suit;
    }
    //WORKS
    public int getNum()
    {return value;
    }
    //WORKS
    public String toString()
    {return name +" of "+ suit;
    }

    public void changeAce()
    {value = 1;
    }

    public boolean equals(Card other)
    {if(value == other.getNum() && name.equals(other.getFace()))
        {return true;
        }
        return false;
    }

    public void changePoker(Card fix)
    {if(fix.getFace().equals("Ace"))
        {value = 1;
        }
        else if(fix.getFace().equals("Jack"))
        {value = 11;
        }
        else if(fix.getFace().equals("Queen"))
        {value = 12;
        }
        else if(fix.getFace().equals("King"))
        {value = 13;
        }
    }
}