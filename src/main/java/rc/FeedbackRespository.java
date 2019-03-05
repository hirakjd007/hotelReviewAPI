package rc;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRespository extends MongoRepository<FeedbackForHotels, String> {
	
	@Query(value="{hotelName:?0}")
	FeedbackForHotels findByHotelName(String hotelName);

}
