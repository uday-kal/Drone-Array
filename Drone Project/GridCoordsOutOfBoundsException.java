
@SuppressWarnings("serial")
public class GridCoordsOutOfBoundsException extends IndexOutOfBoundsException{

	/**
	 * Basic exception constructer with no inputs
	 */
	public GridCoordsOutOfBoundsException()
	{
		super();
	}

	/**
	 * Constructor with a string input error mesasge
	 * @param message the error message input
	 */
	public GridCoordsOutOfBoundsException(String message)
	{
		super(message);
	}
}
