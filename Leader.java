package Program07;

public class Leader extends Member
{
	private int term;

	public Leader()
	{
		super();
	}

	public Leader(String mem, String i, int t)
	{
		super(mem, i);
		setTerm(t);
	}

	public int getTerm()
	{
		return term;
	}

	public void setTerm(int t)
	{
		this.term = t;
	}

	public String toString()
	{
		return super.toString() + " " + getTerm();
	}

}
