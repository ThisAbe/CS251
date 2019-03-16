package Program04;

public class DeckDriver
{
	public static void main(String[] args)
	{
		int row = 0;
		Deck card1 = new Deck();
		card1.shuffleDeck();
		do
		{
			System.out.print(card1.dealCard() + " ");
			++row;
			if (row % 8 == 0)
				System.out.println(card1.dealCard() + " ");

		} while (card1.emptyDeck() == false);

	}
}
