package Program07;

public class OrgDriver
{

	public static void main(String[] args)
	{
		Org org1 = new Org("Tomatoes Inc.");
		Org org2 = new Org("Potato LLC.");
		Leader lead1 = new Leader("John", "001", 2);
		Leader lead2 = new Leader("Bill", "101", 1);
		org1.setLeader(lead1);
		org2.setLeader(lead2);

		Member[] mem1 =
		{ new Member("Rosetta", "0002"), new Member("Vinetta", "0003"),
				new Member("Dirtetta", "0004") };
		Member[] mem2 =
		{ mem1[2], new Member("Frenchie", "1000"), new Member("Fry", "999"),
				new Member("Jen", "998") };

		org1.setMembers(mem1);
		org2.setMembers(mem2);

		org1.generateRos();
		org2.generateRos();

	}

}
