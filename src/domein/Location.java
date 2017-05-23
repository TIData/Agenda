package domein;

public class Location {

	private String location;

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Location() {
		// TODO - implement Location.Location
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param newLocation
	 */
	public Location(String newLocation) {
		// TODO - implement Location.Location
                setLocation(newLocation);
	}

	@Override
	public String toString() {
            return location;
        }

}