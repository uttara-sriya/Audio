package reviewer.bookreview;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sriya on 6/17/16.
 */
@Repository
public interface ReviewRepository extends JpaRepository<ReviewModel,Long>{
    List<ReviewModel> findByStarsLessThan(int stars);

}
