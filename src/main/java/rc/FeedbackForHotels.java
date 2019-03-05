package rc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="HotelFeedbacks")
public class FeedbackForHotels {
	
	@Id
	private String id;
	private String hotelName;
	private HotelDescription hotelDescription;
	private List<Review> reviews;

	protected FeedbackForHotels() {
		this.reviews=new ArrayList<>();
	}

	public FeedbackForHotels(String hotelName, HotelDescription hotelDescription,
			List<Review> reviews) {
		super();
		this.hotelName = hotelName;
		this.hotelDescription = hotelDescription;
		this.reviews = reviews;
	}

 	public String getId() {
		return id;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public HotelDescription getHotelDescription() {
		return hotelDescription;
	}

	public void setHotelDescription(HotelDescription hotelDescription) {
		this.hotelDescription = hotelDescription;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public void setId(String id) {
		this.id = id;
	}	
		
}
