package candy;

public class Coordinate {

	private int x, y;
	private Coordinate left, right, top, bottom;
	
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Coordinate left(){
		if(left == null){
			left = new Coordinate(x-1, y);
		}
		return left;
	}

	public Coordinate right(){
		if(right == null){
			right = new Coordinate(x+1, y);
		}
		return right;
	}

	public Coordinate top(){
		if(top == null){
			top = new Coordinate(x, y-1);
		}
		return top;
		
	}

	public Coordinate bottom(){
		if(bottom == null){
			bottom = new Coordinate(x, y+1);
		}
		return bottom;
		
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
		Coordinate other = (Coordinate) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	public boolean isValid(int max){
		return isValid(x, max) && isValid(y, max);
	}
	
	private boolean isValid(int i, int max){
		return i >= 0 && i <=max;
	}

	@Override
	public String toString() {
		return "Coordinate [x=" + x + ", y=" + y + "]";
	}
	
	
}
