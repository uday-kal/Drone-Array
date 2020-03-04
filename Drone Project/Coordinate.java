
public final class Coordinate {

	private int xVal = 0;
	private int yVal = 0;

	/**
	 * Creates a new coordinate point with an x point and y point
	 * @param x the x value of the point
	 * @param y the y value of the point
	 */
	public Coordinate(int x, int y)
	{
		xVal = x;
		yVal = y;
	}

	/**
	 * Returns the x value 
	 * @return x value
	 */
	public int getX()
	{
		return xVal;
	}

	/**
	 * returns the y value
	 * @return y value
	 */
	public int getY()
	{
		return yVal;
	}

	/**
	 * Creates a new coordinate with the added values
	 * @param dx inputed x value
	 * @param dy inputed y value
	 * @return new coordinate
	 */
	public Coordinate plus(int dx, int dy)
	{
		Coordinate loc = new Coordinate (dx + xVal, dy + yVal);
		return loc; 
	}

	/**
	 * Creates a new coordinate with added x and y from the coordinate
	 * @param delta inputed coordinate
	 * @return new coordinate
	 */
	public Coordinate plus(Coordinate delta)
	{
		Coordinate loc = new Coordinate (delta.getX() + getX(), delta.getY() + getY());
		return loc; 
	}

	/**
	 * Creates a new coordinate with the added coordinate from the given direction
	 * @param d the direction of movement
	 * @return new coordinate added
	 */
	public Coordinate plus(Direction d)
	{
		Coordinate loc = d.delta().plus(xVal, yVal);
		return loc;
	}

	/**
	 * Returns a string format of the coordinate
	 */
	@Override public String toString()
	{
		return "(" + xVal + ", " + yVal + ")";
	}

}
