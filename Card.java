package Program04;
public class Card
{
	private String mysuit;
	private String myrank;

	public String getSuit()
	{
		return this.mysuit;
	}

	public String getRank()
	{
		return this.myrank;
	}

	private void setSuit(String suit)
	{
		mysuit = suit;
	}

	private void setRank(String rank)
	{
		myrank = rank;
	}

	public Card()
	{
		setSuit("C");
		setRank("A");
	}

	public Card(String suit, String rank)
	{
		setRank(rank);
		setSuit(suit);
	}

	public Card clone()
	{
		Card obj = new Card(getSuit(), getRank());
		return obj;
	}

	public boolean equals(Card guest)
	{
		if (guest.getSuit().equals(getSuit())
				&& guest.getRank().equals(getRank()))
		{
			return true;
		}
		return false;
	}

	public String toString()
	{
		return getRank() + getSuit();
	}
}
