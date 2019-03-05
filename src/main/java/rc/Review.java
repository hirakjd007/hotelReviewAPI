package rc;

public class Review {

	private String userName;
	private int rating;
	private String comments;
	
	protected Review() {
		
	}

	public Review(String userName, int rating, String comments) {
		super();
		this.userName = userName;
		this.rating = rating;
		this.comments = comments;
	}

	public String getUserName() {
		return userName;
	}

	public int getRating() {
		return rating;
	}

	public String getComments() {
		return comments;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
}
