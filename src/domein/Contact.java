package domein;

public class Contact {

	private String firstName;
	private String lastName;
	private String title;
	private String organization;

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOrganization() {
		return this.organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	/**
	 * 
	 * @param newFirstName
	 * @param newLastName
	 * @param newTitle
	 * @param newOrganization
	 */
	public Contact(String newFirstName, String newLastName, String newTitle, String newOrganization) {
            setFirstName(firstName);
            setLastName(lastName);
            setTitle(title);
            setOrganization(organization);
	}

	@Override
	public String toString() {
            return firstName + " " + lastName;
	}

}