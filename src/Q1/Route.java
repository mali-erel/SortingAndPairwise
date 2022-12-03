package Q1;


public class Route implements Comparable<Route> {

	public Route(String source, String destination) {
		super();
		this.source = source;
		this.destination = destination;
	}

	private String source;
	private String destination;

	public int compareTo(Route o) {

		if (source.compareTo(o.getSource()) != 0) {
			return source.compareTo(o.getSource());
		}
		return destination.compareTo(o.getDestination());
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return  source +" "+destination;
	}
}
