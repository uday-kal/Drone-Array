
public interface Signalable<T> {
	
	/**
	 * Says that the drone has found something
	 * @param message a random string input
	 */
	public void signal(T message);

}
