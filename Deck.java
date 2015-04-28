import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Deck
{
public Deck()
{
 //this creates a deck
             List<Card> deck = new ArrayList<Card>();
         
             for ( int i = 0; i < 4; i++ ) {
               for ( int j = 2; j < 15; j++ ) {
                 deck.add( new Card( i, j ) );
               }
             }
                        //shuffles the deck
             Collections.shuffle(deck, new Random(System.nanoTime()));
         
         // adds cards to player's hands
             LinkedList<Card> player1Cards = new LinkedList<Card>();
             player1Cards.addAll( deck.subList(0,25));
         
             LinkedList<Card> player2Cards = new LinkedList<Card>();
             player2Cards.addAll(deck.subList(26,deck.size()));
             
}
}