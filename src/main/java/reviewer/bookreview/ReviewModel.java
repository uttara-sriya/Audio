package reviewer.bookreview;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Sriya on 6/16/16.
 */
@Entity
public class ReviewModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    String name;
    int stars;
    String review;
    public ReviewModel(){}

    public ReviewModel(String name, int stars, String review) {
        this.name = name;
        this.stars = stars;
        this.review = review;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public long getId(){
        return id;
    }
}
