package Program07;

public class Person
{
	private String name;

	public Person()
	{
		this("");
	}

	public Person(String name)
	{
		setName(name);
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String n)
	{
		this.name = n;
	}

	public String toString()
	{
		return getName();
	}
}
