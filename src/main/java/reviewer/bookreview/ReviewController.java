package reviewer.bookreview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sriya on 6/16/16.
 */
@RestController
@RequestMapping(value="/book")
public class ReviewController {


//    @RequestMapping(value="/hello")
//    public String hello(){
//    return "hi abcd!";
//    }

//    ReviewModel rev = new ReviewModel("2", 20, "sriya");
//
//    //GET ALL
//    @RequestMapping(value = "/allReviews", method = RequestMethod.GET, headers = "Accept=Application/json", produces = "application/json")
//    public List<ReviewModel> getCountries() {
//        List<ReviewModel> listOfReviews = new ArrayList<ReviewModel>();
//        listOfReviews=createReviewList();
//        return listOfReviews;
//    }
//
//    //GET EACH
//    @RequestMapping(value = "/review/{sid}", method = RequestMethod.GET, headers = "Accept=Application/json", produces = "application/json")
//    public ReviewModel getEmpById(@PathVariable int sid) {
//        List<ReviewModel> listOfReviews = new ArrayList<ReviewModel>();
//        listOfReviews=createReviewList();
//        for(ReviewModel reviews:listOfReviews){
//            if(reviews.getStars()== sid)
//                return reviews;
//        }
//        return null;
//    }
//
//    //POST
//    @RequestMapping(value = "/review/", method=RequestMethod.POST, produces={"application/json"})
//    public ReviewModel reviewPost(@RequestParam String ureview) {
//
//        if (ureview.equalsIgnoreCase("sriya")) {
//            return rev;
//        }else {
//            return new ReviewModel("5",50,ureview);
//        }
//    }
//
//
//
//    //PUT
//    @RequestMapping(value="/review/{name}",method=RequestMethod.PUT, produces={"application/json"})
//    public ReviewModel empPut(@PathVariable String name){
//        if(name.equalsIgnoreCase("1"))
//            return rev;
//        else
//            return new ReviewModel(name,60,"great app");
//
//    }
//
//
//    //DELETE
//    @RequestMapping(value = "/review/{review}", method=RequestMethod.DELETE, produces={"application/json"})
//    public ReviewModel reviewDelete(@PathVariable String review) {
//
//        if (review.equalsIgnoreCase("great app")) {
//            return rev;
//        }else {
//            List<ReviewModel> lm=new ArrayList<ReviewModel>();
//            lm.remove(rev);
//            System.out.println("removed item"+rev.getName());
//           return null;
//        }
//    }
//
//
//
//    //creating the list of reviews
//    public List<ReviewModel> createReviewList()
//    {
//        ReviewModel indiaReview=new ReviewModel("1",10, "India");
//        ReviewModel chinaReview=new ReviewModel("4",20, "China");
//        ReviewModel nepalReview=new ReviewModel("3",30,"Nepal");
//        ReviewModel bhutanReview=new ReviewModel("2",40, "Bhutan");
//
//        List<ReviewModel> listOfReviews = new ArrayList<ReviewModel>();
//        listOfReviews.add(indiaReview);
//        listOfReviews.add(chinaReview);
//        listOfReviews.add(nepalReview);
//        listOfReviews.add(bhutanReview);
//        return listOfReviews;
//    }


    private ReviewRepository reviewRepository;
    @Autowired
    public ReviewController(ReviewRepository reviewRepository){
        this.reviewRepository=reviewRepository;
    }

    @RequestMapping(value="/all" ,method=RequestMethod.GET, produces = "application/json")
    public List<ReviewModel> getAll(){
        return reviewRepository.findAll();
    }

    @RequestMapping(value = "/getStar/{stars}",method=RequestMethod.GET, produces = "application/json")
    public List<ReviewModel> getStars(@PathVariable int stars){
    return reviewRepository.findByStarsLessThan(stars);
    }

    @RequestMapping(value="/create",method = RequestMethod.POST,produces = "application/json")
    public List<ReviewModel> create(@RequestBody ReviewModel reviewModel){
    reviewRepository.save(reviewModel);
        return reviewRepository.findAll();
    }

    @RequestMapping(value="delete/{id}",method=RequestMethod.POST)
    public List<ReviewModel> remove(@PathVariable long id){
    reviewRepository.delete(id);
        return reviewRepository.findAll();
    }
}
