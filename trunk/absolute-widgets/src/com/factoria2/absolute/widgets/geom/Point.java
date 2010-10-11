package com.factoria2.absolute.widgets.geom;

/**
 * Points are read-only
 * @author Iv�n
 *
 */
public class Point {
	
	public static final Point ORIGIN = new Point(0,0);
	
	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Point clone() {
		return new Point(x,y);
	}
	
	@Override
	public String toString() {
		return "("+x+","+y+")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	public Point moveBy(int deltaX, int deltaY) {
		Point point = this.clone();
		point.x += deltaX;
		point.y += deltaY;
		return point;
	}

	public Point moveTo(int x, int y) {
		Point point = this.clone();
		point.x = x;
		point.y = y;
		return point;
	}
	
}
