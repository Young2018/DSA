package cn.young22.dsa.appendixC;

public enum LetterGrade {

	A("A", 4.0), A_MINUS("A-", 3.7), B_PLUS("B+", 3.3), B("B", 3.0), 
	B_MINUS("B-", 2.7), C_PLUS("C+", 2.3), C("C",2.0), C_MINUS("C-", 1.7), 
	D_PLUS("D+", 1.3), D("D", 1.0), F("F", 0.0);

	private final String grade;
	private final double points;
	
	private LetterGrade(String letterGrade, double qualityPoints) {
		grade = letterGrade;
		points = qualityPoints;
	} // end constructor

	public String getGrade() {
		return grade;
	}

	public double getPoints() {
		return points;
	}
	
	public String toString(){
		return getGrade();
	}
}
