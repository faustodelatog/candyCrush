package candy;

public class Coordinate {

	private int x, y;
	
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
		return new Coordinate(x-1, y);
	}

	public Coordinate right(){
		return new Coordinate(x+1, y);
	}

	public Coordinate top(){
		return new Coordinate(x, y-1);
	}

	public Coordinate bottom(){
		return new Coordinate(x, y+1);
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
	
	
	
}
