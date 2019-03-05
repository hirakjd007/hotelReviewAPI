package rc;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("feedbacks")
public class FeedbackController {
	private FeedbackRespository feedbackRespository;

	public FeedbackController(FeedbackRespository feedbackRespository) {
		this.feedbackRespository = feedbackRespository;
	}

	@GetMapping("/all")
	public List<FeedbackForHotels> getAll(){
		List<FeedbackForHotels> feedbacks= this.feedbackRespository.findAll();

		return feedbacks;
	}
	@PutMapping
	public void insert(@RequestBody FeedbackForHotels feedback) {
		this.feedbackRespository.insert(feedback);
	}

	@PostMapping
	public void update(@RequestBody FeedbackForHotels feedback) {
		this.feedbackRespository.save(feedback);
	}

	@GetMapping("/hotelName/{hotelName}")
	public FeedbackForHotels getByResolverName(@PathVariable("resolverName") String resolverName){
		FeedbackForHotels feedbacks=this.feedbackRespository.findByHotelName(resolverName);
		return feedbacks;
	}

	@PostMapping("/addfeedback")
	@CrossOrigin(origins = "*")
	public FeedbackForHotels addFeedback(@RequestBody FeedbackForHotels feedback) {
		String resolver=feedback.getHotelName();
		System.out.println(resolver);
		if(this.feedbackRespository.findByHotelName(resolver)!=null) {
			FeedbackForHotels feedbacks=this.feedbackRespository.findByHotelName(resolver);
			this.feedbackRespository.delete(feedbacks);
			List<Review> reviews=feedbacks.getReviews();
			reviews.addAll(feedback.getReviews());
			feedbacks.setReviews(reviews);
			return this.feedbackRespository.save(feedbacks);
		}
		else 
			return null;
	}
}
