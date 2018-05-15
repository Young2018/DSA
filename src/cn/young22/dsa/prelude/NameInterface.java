package cn.young22.dsa.prelude;

public interface NameInterface {

	public void setName(String firstName, String lastName);

	public String getName();

	public void setFirst(String firstName);

	public String getFirst();

	public void setLast(String lastName);

	public String getLast();

	public void giveLastNameTo(NameInterface aName);

	public String toString();

}// end NameInterface
