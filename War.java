import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class War {
   Deck deck;
  public War(){
   char response;
   deck = new Deck();
  
      System.out.println("Battle? (y/n)");
    Scanner input = new Scanner(System.in);
    
    response = input.next().charAt(0);


    while (player1Cards.size() != 0 && player2Cards.size() !=0) {
        
    while (response != 'n')
    {    
    
   //while they still have cards, pop the top
      Card player1Card = player1Cards.pop();
      Card player2Card = player2Cards.pop();

      System.out.println("Player 1: " + player1Card.toString());
      System.out.println("Player 2: " + player2Card.toString());

//battle, player 1 wins
      if ( player1Card.getCard() > player2Card.getCard())
      {
        player1Cards.addLast(player2Card);
        player1Cards.addLast(player1Card);
      //battle, p2 wins
      } else if (player1Card.getCard() < player2Card.getCard()) 
      {
        player2Cards.addLast(player2Card);
        player2Cards.addLast(player1Card);
      } else {
      // WAR occurs
        System.out.println("War");
        List<Card> warCards1 = new ArrayList<Card>();
        List<Card> warCards2 = new ArrayList<Card>();
        for ( int i = 0; i < 3; i++ ) {
          if(player1Cards.size()==0 || player2Cards.size()==0)
          {
            break;
          }
          warCards1.add( player1Cards.pop());
          warCards2.add( player2Cards.pop());
        }
        System.out.println("Player 1 war: " + warCards1.get(0).toString( ));
        System.out.println("Player 2 war: " + warCards2.get(0).toString());
        if ( warCards1.get( 0 ).getCard( ) > warCards2.get(0).getCard()) 
        {
          player1Cards.addAll(warCards2);
          player1Cards.addAll(warCards1);
          System.out.println( "Player 1 wins the war" );
        } else {
          player2Cards.addAll(warCards2);
          player2Cards.addAll(warCards1);
          System.out.println( "Player 2 wins the war" );
        }
      }
      System.out.println("Battle??");
      response = input.next().charAt(0);

      }
      
      
//check hand size
      if (player1Cards.size() == 0) {
        System.out.println( "Player 1 wins!" );
        break;
      } else if (player2Cards.size() == 0) {
        System.out.println( "Player 2 wins!" );
        break;
        }
        else {
        System.out.println("Game ended early");
        break;
        }
        
      }
    }
  
}