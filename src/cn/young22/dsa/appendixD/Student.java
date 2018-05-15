package cn.young22.dsa.appendixD;

import cn.young22.dsa.appendixC.Name;

public class Student {

	private Name fullName;
	private String id;
	
	public Student(){
		fullName = new Name();
		id = "";
	} // end default constructor
	
	public Student(Name studentName, String studentId){
		fullName = studentName;
		id = studentId;
	} // end constructor
	
	public void setStudent(Name studentName, String studentId){
		setFullName(studentName);
		setId(studentId);
	} // end setStudent
	
	public Name getFullName() {
		return fullName;
	} // end getFullName

	public void setFullName(Name fullName) {
		this.fullName = fullName;
	} // end setFullName

	public String getId() {
		return id;
	} // end getId

	public void setId(String id) {
		this.id = id;
	} // end setId
	
	public String toString(){
		return id + " " + fullName.toString();
	} // end toString
	
}
