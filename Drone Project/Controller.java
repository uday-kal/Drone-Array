import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Controller implements Signalable<Drone>{


	private List<Coordinate> list;
	int num = 0;

	/**
	 * Creates a new crontroller, with an array list of coordinates for each found token
	 */
	public Controller()
	{
		list = new ArrayList<Coordinate>();
	}

	/**
	 * the total number of tokens found
	 * @return total tokens
	 */
	public int count()
	{
		return num;
	}

	/**
	 * Turns the list into an immutable list since it is stored internally
	 * @return immutable list of coordinates
	 */
	public List<Coordinate> getCoords()
	{
		return Collections.unmodifiableList(list);
	}

	/**
	 * If the drone finds something, a token is added and its position
	 */
	@Override
	public void signal(Drone d) {
		list.add(d.getPosition());
		num++;
	}

}
