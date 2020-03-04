
public enum Direction {

	UP, DOWN, LEFT, RIGHT, NONE;
	
	
	/**
	 * Creates a coordinate for the direction of movement
	 * @return the coordinate of the movement
	 */
	public Coordinate delta()
	{
		if (this == UP)
			return new Coordinate(0,1);
		else if (this == DOWN)
			return new Coordinate(0,-1);
		else if (this == LEFT)
			return new Coordinate(-1,0);
		else if (this == RIGHT)
			return new Coordinate(1,0);
		else
			return new Coordinate(0,0);
	}
	
	
}
