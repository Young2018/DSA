package cn.young22.dsa.appendixC;

public class Name {

	private String first;
	private String last;
	
	public Name() {
	} // end default constructor
	
	public Name(String firstName, String lastName){
		first = firstName;
		last = lastName;
	} // end constructor

	public void setName(String firstName, String lastName){
		setFirst(firstName);
		setLast(lastName);
	} // end setName
	
	public String getName(){
		return toString();
	} // end getName
	
	public String getFirst() {
		return first;
	} // end getFirst

	public void setFirst(String first) {
		this.first = first;
	} // end setFirst

	public String getLast() {
		return last;
	} // end getLast

	public void setLast(String last) {
		this.last = last;
	} // end setLast
	
	public void giveLastNameTo(Name aName){
		aName.setLast(last);
	} // end giveLastNameTo
	
	public String toString(){
		return first + " " + last;
	} // end toString
	
	public boolean equals(Object other){
		boolean result = false;
		
		if(other instanceof Name){
			Name otherName = (Name)other;
			result = first.equals(otherName.first) && last.equals(otherName.last);
		}
		
		return result;
	}
} // end Name
