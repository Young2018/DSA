package cn.young22.dsa.prelude;

public class Circle implements Circular{

	private double radius;
	
	@Override
	public void setRadius(double newRadius) {
		radius = newRadius;
	} // end setRadius

	@Override
	public double getRadius() {
		return radius;
	} // end getRadius

	public double getArea(){
		return Math.PI * radius * radius;
	} // end getArea
}// end Circle
