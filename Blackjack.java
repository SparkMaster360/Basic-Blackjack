//imports
import java.util.*;

//open class
public class Blackjack {
      
   //open main
   public static void main (String [] args) {
   
      //Set up scanner class
      Scanner scan = new Scanner(System.in);
      
      //define variables and introduce user
      int money = 50;
      int playgame=0;
      System.out.println("Welcome to my blackjack game program. You start out with $50 but can win more by playing the game. Good luck!");
      while(playgame!=2){
         System.out.println("Ready to play?\n 1 - Yes \n 2 - Leave");
         playgame = scan.nextInt();
         if(playgame==1){
            int winnings = play(money);
            money+=winnings;
            System.out.println("You now have $" + String.valueOf(money) + "."); 
         }
         else if(playgame==2){
            System.out.println("You finished with $" + String.valueOf(money) + ". Thanks for playing!");
         }
      }
     
   }
   //card drawing
   public static int draw(){
      int[] cards = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
      int num = (int) (Math.random()*12+1);
      int cardDrawn = cards[num];
      return cardDrawn;
   }
   //main game
   public static int play(int cash){
   
      //Set up scanner class
      Scanner scan = new Scanner(System.in);
   
      int choice = 0;
      int bet;
      int x;
      int y;
      int z;
      int q;
      x = draw();
      y = draw();
      int dealertotal = x + y;
      z = draw();
      q = draw();
      int playertotal = x + y;
      //bets
      System.out.println("Your total is " + String.valueOf(playertotal) + ". The dealer is showing a " + x + ".");
      System.out.println("What would you like to bet?");
      bet = scan.nextInt();
      if(bet>cash){
         System.out.println("You don't have that kind of cash! Your bet will instead be all of your money.");
         bet = cash;
      }
      
      //main loop
      while(true){
         if(playertotal>21){
            break;
         }
         else if(choice==2){
            break;
         }
         System.out.println("Your total is " + String.valueOf(playertotal) + ". The dealer is showing a " + x + ".");
         System.out.println("Would you like to hit or stay? \n1 - Hit\n2 - Stay");
         choice = scan.nextInt();
         if(choice==1){
            x=draw();
            playertotal+=x;
            System.out.println("You drew a " + String.valueOf(x) + "! Your new total is " + String.valueOf(playertotal) + "."); 
         }
         else if(choice==2){
            while(dealertotal<16){
               dealertotal+=draw();
            } //close while
         } //close else if
      }//close while
      if(((playertotal>dealertotal) || (dealertotal>21))  && (playertotal<=21)){
         System.out.println("You win! The dealer had " + String.valueOf(dealertotal) + ".");
      }//close if
      else if(dealertotal==playertotal){
         System.out.println("It's a tie! You'll be getting back your bet");
         bet=0;
      }
      else if(true){
         System.out.println("You lose! Better luck next time... The dealer had " + String.valueOf(dealertotal) + ".");
         bet=0-bet;
      }//close else
   return bet;   
   }//close play
} //close class