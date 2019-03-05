package rc;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbSeeder implements CommandLineRunner {

	private FeedbackRespository feedbackRepository;
	
	public DbSeeder(FeedbackRespository feedbackRepository) {
		this.feedbackRepository = feedbackRepository;
	}

	@Override
	public void run(String... strings) throws Exception{
		FeedbackForHotels vivanta= new FeedbackForHotels(
				"Vivanta By Taj",
				new HotelDescription("Best Hotel by Taj"),
				Arrays.asList(
						new Review("Hirak",9,"Very Good")
						)
				);
		
		FeedbackForHotels taj= new FeedbackForHotels(
				"Taj Hotel",
				new HotelDescription("Best Hotel in Mumbai"),
				Arrays.asList(
						new Review("Hirak JD",10,"Very Good")
						)
				);
		
		//drop all feedbacks
		this.feedbackRepository.deleteAll();
		
		//add our feedbacks to the database
		List<FeedbackForHotels> feedbackForResolution = Arrays.asList(vivanta,taj);
		this.feedbackRepository.saveAll(feedbackForResolution);
	}

}
