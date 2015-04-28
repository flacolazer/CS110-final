class Card {
    private int suit;

    private int card;

   //two numbers for suit and card num
    public Card( int suit, int card ) {
      super( );
      this.suit = suit;
      this.card = card;
    }

    public int getCard( ) {
      return card;
    }

    public void setCard( int card ) {
      this.card = card;
    }

  //changes higher nums to face cards
  //needs to be changed to card jpgs
    public String toString( ) {

      StringBuilder result = new StringBuilder( );
      switch ( card ) {
        case 11 :
          result.append( "jack" );
          break;
        case 12 :
          result.append( "queen" );
          break;
        case 13 :
          result.append( "king" );
          break;
        case 14 :
          result.append( "ace" );
          break;
        default :
          result.append( card );
      }
      
      //changes suit number to string
      //needs to be changed to card jpgs
      switch ( suit ) {
        case 0 :
          result.append("h.jpg");
          break;
        case 1 :
          result.append("d.jpg");
          break;
        case 2 :
          result.append("c.jpg");
          break;
        case 3 :
          result.append("s.jpg");
          break;
      }
      return result.toString( );

    }
   
  }