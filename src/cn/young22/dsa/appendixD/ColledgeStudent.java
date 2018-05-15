package cn.young22.dsa.appendixD;

import cn.young22.dsa.appendixC.Name;

public class ColledgeStudent extends Student{

	private int year;
	private String degree;
	
	public ColledgeStudent() {
		super();
		year = 0;
		degree = "";
	}
	
	public ColledgeStudent(Name studentName, String studentId,
			int graduationYear, String degreeSouhgt){
		super(studentName, studentId);
		year = graduationYear;
		degree = degreeSouhgt;
	}
	
	public void setStudent(Name studentName, String studentId,
			int graduationYear, String degreeSought){
		setFullName(studentName);
		setId(studentId);
		
		year = graduationYear;
		degree = degreeSought;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}
	
	public String toString(){
		return super.toString() + ", " + degree + ", " + year;
	}
	
	
}
