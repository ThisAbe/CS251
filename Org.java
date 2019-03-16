package Program07;

public class Org
{
	private String orgName;
	private Leader orgLeader;
	private Member[] members;

	public Org()
	{

	}

	public Org(String oN)
	{
		this.orgName = oN;
	}

	public String getOrgName()
	{
		return this.orgName;
	}

	public Member[] getMembers()
	{
		return members;
	}

	public Leader getLeader()
	{
		return orgLeader;
	}

	public void setMembers(Member[] mems)
	{
		this.members = mems;
	}

	public void setLeader(Leader lead)
	{
		this.orgLeader = lead;
	}

	public void setOrgName(String oN)
	{
		orgName = oN;
	}

	public void generateRos()
	{
		System.out.println(getOrgName());
		System.out.println(" " + orgLeader.toString());
		for (Member mem : members)
		{
			System.out.println("   -" + mem.toString());
		}
	}

}
