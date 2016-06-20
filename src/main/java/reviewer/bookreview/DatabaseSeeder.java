package reviewer.bookreview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sriya on 6/17/16.
 */
@Component
public class DatabaseSeeder implements CommandLineRunner{
    private ReviewRepository reviewRepository;
    @Autowired
    public DatabaseSeeder(ReviewRepository reviewRepository){
        this.reviewRepository=reviewRepository;
    }
    @Override
    public void run(String... strings) throws Exception {
    List<ReviewModel> reviews=new ArrayList<>();
        ReviewModel indiaReview=new ReviewModel("1",10, "India");
        ReviewModel chinaReview=new ReviewModel("4",20, "China");
        ReviewModel nepalReview=new ReviewModel("3",30,"Nepal");
        ReviewModel bhutanReview=new ReviewModel("2",40, "Bhutan");
        reviews.add(indiaReview);
        reviews.add(chinaReview);
        reviews.add(nepalReview);
        reviews.add(bhutanReview);
        reviewRepository.save(reviews);
    }




}
