
public class Grid {

	private int[][] table;
	private int sizeX = 0;
	private int sizeY = 0;


	/**
	 * Creates a new grid of 0s and fills it with the inputed size
	 * @param sizeX the length of the grid
	 * @param sizeY the height of the grid
	 */
	public Grid(int sizeX, int sizeY)
	{
		this.sizeX = sizeX;
		this.sizeY = sizeY;

		table = new int[sizeX][sizeY];

		//fills grid with 0 and 1
		for (int row = 0; row < table.length; row++) 
		{
			for (int col = 0; col < table[row].length; col++) 
			{
				table[row][col] = 0;
			}
		}
	}

	/**
	 * returns the length of the grid
	 * @return the x size
	 */
	public int sizeX()
	{
		return sizeX;
	}

	/**
	 * returns the height of the grid
	 * @return the y size
	 */
	public int sizeY()
	{
		return sizeY;
	}

	/**
	 * adds a token to the point on the gird, aka a 1
	 * throws exception if out of bounds
	 * @param c the coordinate the point is placed at
	 */
	public void setToken(Coordinate c) 
	{
		try {
			table[c.getX()][c.getY()] = 1;
		}
		catch (IndexOutOfBoundsException e)
		{
			throw new GridCoordsOutOfBoundsException();
		}
	}


	/**
	 * Adds a token to the point on the grid
	 * throws exception if out of bounds
	 * @param x the x value of the point
	 * @param y the y value of the point
	 */
	public void setToken(int x, int y)
	{
		try {
			table[x][y] = 1;
		}
		catch (IndexOutOfBoundsException e)
		{
			throw new GridCoordsOutOfBoundsException();
		}
	}


	/**
	 * Resets the token at the position, aka 1 become 0
	 * throws exception if out of bounds
	 * @param c the coordinate of the point to be removed 
	 */
	public void resetToken(Coordinate c)
	{
		try {
			table[c.getX()][c.getY()] = 0;
		}
		catch (IndexOutOfBoundsException e)
		{
			throw new GridCoordsOutOfBoundsException();
		}
	}


	/**
	 * Resets the token at the position, aka 1 become 0
	 * throws exception if out of bounds
	 * @param x the x value of the point
	 * @param y the y value of the point
	 */
	public void resetToken(int x, int y)
	{
		try {
			table[x][y] = 0;
		}
		catch (IndexOutOfBoundsException e)
		{
			throw new GridCoordsOutOfBoundsException();
		}
	}


	/**
	 * Checks if the point has a token at the point
	 * throws exception if out of bounds
	 * @param c coordinate of the point to be checked
	 * @return true if a token is found, false if not
	 */
	public boolean hasToken(Coordinate c)
	{
		try {

			if (table[c.getX()][c.getY()] == 1)
				return true;

			return false;

		}
		catch (IndexOutOfBoundsException e)
		{
			throw new GridCoordsOutOfBoundsException();
		}
	}

	/**
	 * Checks if the point has a token at the point
	 * throws exception if out of bounds
	 * @param x the x value of the point
	 * @param y the y value of the point
	 * @return true if a token is found, false if not
	 */
	public boolean hasToken(int x, int y)
	{

		try {

			if (table[x][y] == 1)
				return true;

			return false;

		}
		catch (IndexOutOfBoundsException e)
		{
			throw new GridCoordsOutOfBoundsException();
		}

	}

}
