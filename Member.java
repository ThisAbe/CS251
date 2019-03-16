package Program07;

public class Member extends Person
{
	private String id;

	public Member()
	{
	}

	public Member(String n, String I)
	{
		super(n);
		setId(I);
	}

	public String getId()
	{
		return id;
	}

	public void setId(String I)
	{
		this.id = I;
	}

	public String toString()
	{
		return super.toString() + " " + getId();
	}

}
