
import java.util.*;
public class Casino
{//player can't leave games yet
    public void main()
    {Scanner sc = new Scanner(System.in);
        Wallet money =  new Wallet();
        while(true)
        {sop("Welcome to Fujii Resort and Casino!");
            sop("Here we have an assortment of games you can play!");
            sop("You have $" +money.getCash());
            sop("would you like to play:");
            sop("1) Blackjack");
            sop("2) Poker");

            int x = sc.nextInt();

            //blackjack
            if (x == 1)
            {if(sc.nextLine().equals("leave"))
                {break;
                }
                Card ace = new Card(11, "Hearts", "Ace");
                Deck ugh = new Deck();
                ugh.shuffle();
                ArrayList<Card> hand = new ArrayList<Card>();
                ArrayList<Card> compHand = new ArrayList<Card>();

                sop("Welcome to Blackjack!");
                sop("The object of this game is to add up the values of your cards to get to 21.");
                sop("If your cards add up to over 21, you lose (bust).");
                sop("If neither you nor the computer get your cards to 21, the player with the higher sum wins.");
                sop("Are you ready to play?");
                String ans = sc.nextLine();
                String again = "yes";
                

                //blackjack
                 if (ans.equals("yes")|| ans.equals("yea"))
                   
                {  
                    while(true)
                    { if(again.equals("no"))
                        {break;
                        }
                        else if(again.equals("yes"))
                        {
                         String no = "hit";
                         sop("You have $" +money.getCash() +". How much would you like to bet?");
                         int bet = sc.nextInt();
                         sop("Alright. I'll deal now.");
                         sop("Press Enter To Continue");
                         sc.nextLine();
                         sc.nextLine();
                         //player gets cards
                         Blackjack.deal(ugh, hand);
                         if(Blackjack.checkFirstTry(hand, compHand, money, bet)==false)
                         {Blackjack.dealComp(ugh, compHand);
                             Blackjack.checkBust(hand, compHand, money, bet); 
 
                             //player sees dealer's card
                             sop("Would you like to hit, stay, or double down?");
                             String call = sc.nextLine();
                             if(call.equals("double down"))
                             {bet = Blackjack.doubleDown(bet, ugh, hand);
 
                                 if(Blackjack.checkBust(hand, compHand, money, bet)== false && Blackjack.check21(hand, compHand, money, bet) == false)
                                 {Blackjack.comp(ugh, ace, compHand, hand, bet, money);
                                     if(Wallet.checkCash(money) == true)
                                     {sop("You ran out of money.");
                                         break;
                                     }
                                 }
 
                             }
                             else if(call.equals("hit"))
                             {while(true)
                                 {
                                     if (no.equals("hit"))
                                     {
                                         Blackjack.hit(ugh, ace, hand);
 
                                         if (Blackjack.check21(hand, compHand, money, bet) == true)
                                         {break;
                                         }
                                         else if(Blackjack.checkBust(hand, compHand, money, bet) == true)
                                         {break;
                                         }
                                     }
                                     else if(no.equals("stay"))
                                     {Blackjack.comp(ugh, ace, compHand, hand, bet, money);
                                         if(Wallet.checkCash(money) == true)
                                     {sop("You ran out of money.");
                                         break;
                                     }
                                         break;
                                     }
 
                                     sop("Would you like to hit or stay?");
                                     no = sc.nextLine();
                                 }

                            }
                            else if (call.equals("stay"))
                            { Blackjack.comp(ugh, ace, compHand, hand, bet, money);
                                    if(Wallet.checkCash(money) == true)
                                    {sop("You ran out of money.");
                                        break;
                                    }

                            }

                            ugh = new Deck();
                            ugh.shuffle();
                            sop("Play again?");
                            again = sc.nextLine();
                            
                         }
                        }
                    }

                    //loops until he busts or wins
                    //player hits, stays or doubles down
                    //once he hits, count cards; return value
                    //check if he busts

                    //if he stays, computer goes
                    //comp hits automatically if under 15

                    //once they stand, check winner
                    //payout
                }

                else
                {sop("Oh... then what do you wanna talk about?");
                    String talk = sc.nextLine();

                    if(talk.equals("Star Wars")|| talk.equals("star wars"))
                    { sop("DUDE NO WAY!!! OMG YOU'RE MY NEW BEST FRIEND!");
                        sop("SO I TEACH MARTIAL ARTS AND ONE OF THE NEW CLASSES WE HAVE IS A LIGHTSABER COMBAT CLASS!");
                        sop("but we call it saber combat cuz we don't want to get sued by Disney");
                        sop("BUT ANYWAY IT'S SO COOL DUDE. I'VE LEARNED HOW TO FIGHT AND I'D KICK YOUR BUTT!");
                        sop("");
                        sop("sorry dude, my boss is telling me that I have to kick you out. See you next time!");
                        sop("");
                        sop("");
                        sop("YOU HAVE BEEN KICKED OUT OF FUJII RESORT ");
                        sop("Press Enter To Continue");
                        sc.nextLine();
                    }
                    else
                    {sop("Ok. That's cool and all, but have you heard about the new Star Wars movie??");
                        sop("Dude it's super cool. It's about how the rebel alliance gets the plans for the deathstar!");
                        sop("Darth Vader is in it and it's super cool.");
                        sop("But anyway, you don't want to hear about this... so uh... get out.");
                        sop("");
                        sop("");
                        sop("YOU HAVE BEEN KICKED OUT OF FUJII RESORT");
                        sop("Press Enter To Continue");
                        sc.nextLine();
                    }

                }
            }
                //poker
                else if (x == 2)
                {
                    sop("Welcome to Video Poker");
                    sop("The object of this game is to get a winning hand.");
                    sop("You will get 5 cards and you can choose to replace any of your cards");
                    sop("you ready to play?");
                    sc.nextLine();
                    String ans2 = sc.nextLine();
                    

                    if(ans2.equals("yes")||ans2.equals("yea"))
                    {sop("Awesome. Let's play");
                        String play = "yes";
                       
                        while(true)
                         {if(play.equals("no")||play.equals("nah"))
                         {break;
                         }
                            Deck poker = new Deck();
                            poker.shuffle();
                            ArrayList<Card> handP = new ArrayList<Card>();
                            sop("You have $" +money.getCash());
                            sop("How much do you want to bet?");
                            int wager = sc.nextInt();
                            Poker.dealP(handP, poker);
                            Poker.arrange(handP);
                            sop("Alright. Look at your cards. How many would you like to replace?");
                            int num = sc.nextInt();
                            for(int i= 0; i<num; i++)
                            {sop("What card would you like to replace?");
                                int pick = sc.nextInt();
                                Poker.replace(handP, poker, pick);
                            }
                            Poker.arrange(handP);
                            Poker.payout(handP, wager, money);
                            //payout
                            
                            
                            
                            
                            
                            
                         if(Wallet.checkCash(money) == true)
                               {sop("You ran out of money.");
                                   break;
                                }
                                sop("Play again?");
                                sc.nextLine();
                                play= sc.nextLine();
                            
                           
                            

                        }
                    }
                    else
                    {sop("Why are you even here then?");
                        sop("HEY PAULIE, GET THIS TOOL OUTTA HERE.");
                        sop("");
                        sop("");
                        sop("Paulie kicked you out of Fujii Resort and Casino");
                        sop("Press Enter To Continue");
                        sc.nextLine();
                    }
                }
                
            }
            
            
           if(Wallet.checkCash(money) == true)
           {
            sop("Press Enter To Continue");
            sc.nextLine();
            sop("As you walk out of the casino, you see your wife walk up to you. ");
            sop("She puts her hand on her hip as she stares you down.");
            sop("Would you like to run?");
            sc.nextLine();
            if(sc.nextLine().equals("yes")||sc.nextLine().equals("yea")||sc.nextLine().equals("hell yes") || sc.nextLine().equals("HELL YES"))
            {sop("You try to run, but she somehow catches up to you");
                sop("She grabs you by the arm and yells at you");
                sop("HOW MUCH DID YOU LOSE?! - she asks");
                sop("Would you like to lie?");
                if(sc.nextLine().equals("yes")||sc.nextLine().equals("yea")||sc.nextLine().equals("hell yes") || sc.nextLine().equals("HELL YES"))
                {sop("*You tell her you only lost $25*");
                    sop("She sees through your lie...");
                    sop("What would you like to do now?");
                    sc.nextLine();
                    sop("Bro. I've seen other people try that out. It doesn't work. Try something else");
                    sc.nextLine();
                    sop("How would that even work?? Bro that's gonna get you killed");
                    sop("");
                    sop("");
                    sop("Press Enter To Continue");
                    sc.nextLine();
                    
                    sop("DO SOMETHING SHE'S STARING AT ME NOW");
                    sop("");
                    sop("");
                    sop("Press Enter To Continue");
                    sc.nextLine();
                    sop("lol nah i'm not dealing with this. You're on your own B. Good Luck");
                    sop("");
                    sop("");
                    sop("Press Enter To Continue");
                    sc.nextLine();
                    sop("*You Were Left Alone*");
                    sop("Your wife drags you home and doesn't talk to you for weeks");
                    sop("Press Enter To Continue");
                    sc.nextLine();
                    sop("Borish, your gambling addiction needs to stop");
                    sop("plus you've got minors making a casino?");
                    sop("This is some dark web level type of crazy");
                    
                }
                else
                {sop("Screw that man! Why would you tell her the truth? Lie to her!");
                    sop("*You tell her you only lost $25*");
                    sop("She sees through your lie...");
                    sop("What would you like to do now?");
                    sc.nextLine();
                    sop("Bro. I've seen other people try that out. It doesn't work. Try something else");
                    sc.nextLine();
                    sop("How would that even work?? Bro that's gonna get you killed");
                    sop("");
                    sop("");
                    sop("Press Enter To Continue");
                    sc.nextLine();
                    
                    sop("DO SOMETHING SHE'S STARING AT ME NOW");
                    sop("");
                    sop("");
                    sop("Press Enter To Continue");
                    sc.nextLine();
                    sop("lol nah i'm not dealing with this. You're on your own B. Good Luck");
                    sop("");
                    sop("");
                    sop("Press Enter To Continue");
                    sc.nextLine();
                    sop("*You Were Left Alone*");
                    sop("Your wife drags you home and doesn't talk to you for weeks");
                    sop("Press Enter To Continue");
                    sc.nextLine();
                    sop("Borish, your gambling addiction needs to stop");
                    sop("plus you've got minors making a casino?");
                    sop("This is some dark web level type of crazy");
                }
            }
            else 
            {sop("*You Stand There*");
                sop("*She Is Further Infuriated*");
                sop("Wow bro. That was NOT a good idea...");
                sop("*She grabs you by the arm and yells at you*");
                sop("HOW MUCH DID YOU LOSE?! - she asks");
                sop("Would you like to lie?");
                 if(sc.nextLine().equals("yes")||sc.nextLine().equals("yea")||sc.nextLine().equals("hell yes") || sc.nextLine().equals("HELL YES"))
                {sop("*You tell her you only lost $25*");
                    sop("She sees through your lie...");
                    sop("What would you like to do now?");
                    sc.nextLine();
                    sop("Bro. I've seen other people try that out. It doesn't work. Try something else");
                    sc.nextLine();
                    sop("How would that even work?? Bro that's gonna get you killed");
                    sop("");
                    sop("");
                    sop("Press Enter To Continue");
                    sc.nextLine();
                    
                    sop("DO SOMETHING SHE'S STARING AT ME NOW");
                    sop("");
                    sop("");
                    sop("Press Enter To Continue");
                    sc.nextLine();
                    sop("lol nah i'm not dealing with this. You're on your own B. Good Luck");
                    sop("");
                    sop("");
                    sop("Press Enter To Continue");
                    sc.nextLine();
                    sop("*You Were Left Alone*");
                    sop("Your wife drags you home and doesn't talk to you for weeks");
                    sop("Press Enter To Continue");
                    sc.nextLine();
                    sop("Borish, your gambling addiction needs to stop");
                    sop("plus you've got minors making a casino?");
                    sop("This is some dark web level type of crazy");
                    
                }
                else
                {sop("Screw that man! Why would you tell her the truth? Lie to her!");
                    sop("*You tell her you only lost $25*");
                    sop("She sees through your lie...");
                    sop("What would you like to do now?");
                    sc.nextLine();
                    sop("Bro. I've seen other people try that out. It doesn't work. Try something else");
                    sc.nextLine();
                    sop("How would that even work?? Bro that's gonna get you killed");
                    sop("");
                    sop("");
                    sop("Press Enter To Continue");
                    sc.nextLine();
                    
                    sop("DO SOMETHING SHE'S STARING AT ME NOW");
                    sop("");
                    sop("");
                    sop("Press Enter To Continue");
                    sc.nextLine();
                    sop("lol nah i'm not dealing with this. You're on your own B. Good Luck");
                    sop("");
                    sop("");
                    sop("Press Enter To Continue");
                    sc.nextLine();
                    sop("*You Were Left Alone*");
                    sop("Your wife drags you home and doesn't talk to you for weeks");
                    sop("Press Enter To Continue");
                    sc.nextLine();
                    sop("Borish, your gambling addiction needs to stop");
                    sop("plus you've got minors making a casino?");
                    sop("This is some dark web level type of crazy");
                }
            }
        }
    }
         public void sop(String sent)
    {System.out.println(sent);
    }
    }