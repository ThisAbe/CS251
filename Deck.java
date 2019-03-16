package Program04;

public class Deck
{
	private static String[] suits =
	{ "S", "H", "D", "C" };
	private static String[] ranks =
	{ "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
	private int cardsDealt;
	private Card[] deck = new Card[52];

	public Deck() // constructor
	{
		// set each element of deck to a unique Card object,
		for (int i = 0; i < deck.length; ++i)
		{
			String suit = suits[i / 13];
			String rank = ranks[i % 13];
			Card temp = new Card(suit, rank);
			deck[i] = temp;
		}
		// and sets cardsDealt to zero.
		setCardsDealt(0);
	}

	public int getCardsDealt()
	{// accessor
		// return the value of cardsDealt.
		return cardsDealt;
	}

	private void setCardsDealt(int cardsDealt)
	{// mutator
		// sets cardsDealt specified value (cardsDealt)
		this.cardsDealt = cardsDealt;
	}

	public boolean emptyDeck()
	{
		// returns whether or not all the cards in deck
		// have already been dealt (cardsDealt == 52).
		if (getCardsDealt() == 52)
			return true;
		else
			return false;
	}

	public void collectCards()
	{
		// set cardsDealt to zero.
		setCardsDealt(0);
	}

	public void collectCards(int cardCnt)
	{
		// decrement cardsDealt by cardCnt.
		setCardsDealt(getCardsDealt() - cardCnt);
	}

	public Card dealCard()
	{
		// if emptyDeck() is false ...
		// returns the card at location cardsDealt in deck,
		// and increments cardsDealt by 1.
		// else ...
		// returns null
		if (emptyDeck() == false)
		{
			int notEmpty = getCardsDealt();
			setCardsDealt(getCardsDealt() + 1);
			return deck[notEmpty];
		}
		return null;
	}

	public void shuffleDeck()
	{
		// apply 100 random card swaps within deck
		int swapCnt = 100;
		shuffleDeck(swapCnt);
	}

	public void shuffleDeck(int swapCnt)
	{
		// apply swapCnt random card swaps within deck
		for (int i = 0; i < swapCnt; ++i)
		{
			int k = (int) (Math.random() * 52);
			int j = (int) (Math.random() * 52);
			Card temp = deck[k];
			deck[k] = deck[j];
			deck[j] = temp;
		}
	}

}
