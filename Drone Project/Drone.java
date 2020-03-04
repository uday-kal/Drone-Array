import java.util.ArrayList;

public class Drone {

	private Coordinate cords;
	private Grid table;
	@SuppressWarnings("rawtypes")
	private ArrayList<Signalable> list = new ArrayList<Signalable>();
	private boolean reversed = false;
	private boolean endRow = false;


	/**
	 * Creates a drone with a start point on the inputed grid
	 * @param start the starting coordinate
	 * @param grid the grid the drone is placed on
	 */
	public Drone(Coordinate start, Grid grid)
	{
		cords = start;
		table = grid;
	}


	/**
	 * Creates a drone with a start x and y point on the grid
	 * @param x the x value of the start point
	 * @param y the y value of the start point
	 * @param grid the grid the drone is placed on
	 */
	public Drone(int x, int y, Grid grid)
	{
		cords = new Coordinate(x,y);
		table = grid;
	}


	/**
	 * tells the list that the drone has found something, adding it to the list
	 * @param listener signals the message of finding something
	 */
	@SuppressWarnings({ "rawtypes" })
	public void addTokenListener(Signalable listener)
	{
		list.add(listener);
	}


	/**
	 * removes a token from the list of found tokens
	 * @param listener signals that it found something
	 */
	@SuppressWarnings("rawtypes")
	public void removeTokenListener(Signalable listener)
	{
		list.remove(listener);
	}


	/**
	 * returns the cordinate of the drone
	 * @return coordinate of the drone
	 */
	public Coordinate getPosition()
	{
		return cords;
	}


	/**
	 * Moves the drone in the direction inputed
	 * Throws an exception if out of bounds
	 * @param d the direction input
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void move(Direction d)
	{

		Coordinate newCords = cords.plus(d);

		//Checks if the new coordinates to be moved to are valid
		if (newCords.getX() < table.sizeX() &&  newCords.getY() < table.sizeY() && newCords.getX() >= 0 &&  newCords.getY() >= 0)
		{

			//moves the drone
			cords = cords.plus(d);

			//checks if the point moved to has a token and adds the drone cords if found
			if(table.hasToken(cords))
			{
				for(Signalable listener : list)
				{
					listener.signal(this);
				}
			}
		}
		else
		{
			throw new GridCoordsOutOfBoundsException("Coordinates out of bounds");
		}
	}
	
	/**
	 * recursively search the entire table for tokens
	 */
	public void searchTable()
	{
		//Stops if the drone is at the end of the table
		if(cords.getX() == table.sizeX()-1 && cords.getY() == table.sizeY()-1)
		{
			
		}
		else
		{
			//Move the drone to the next row if necessary
			if (endRow == true)
			{
				move(Direction.UP);
				endRow = false;

				//flips the direction of movement
				if(reversed == true)
				{
					reversed = false;
				}
				else
					reversed = true;
			}
			//Moves the drone left, until it hits the end of the row
			else if(reversed == true)
			{
				move(Direction.LEFT);

				if(cords.getX() == 0)
				{
					endRow = true;
				}
			}
			//Moves the drone right until it hits the end of the row
			else
			{
				move(Direction.RIGHT);

				if(cords.getX() == table.sizeX()-1)
				{
					endRow = true;
				}
			}

			//continues until it hits the end of the table
			searchTable();
		}
		
	}


	/**
	 * Implements the task of searching throught the array
	 */
	public void search()
	{
		cords = new Coordinate(0,0);
		move(Direction.NONE);
		
		searchTable();

		
	}
}
