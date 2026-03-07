package M1practice;

class Rating{
    int imbdRating;
    int nominee;

    public Rating(int imbdRating, int nominee) {
        this.imbdRating = imbdRating;
        this.nominee = nominee;
    }
}

class ratingvalidtor{
    public String canBeConsideredForTheAward(Rating rating) throws Exception{
        if(rating.imbdRating<7){
            throw new MovingRatingException("Movie not eligible for filmFare award");
        } else if (rating.nominee<4) {
            throw new MovingRatingException("Minimum 4 nominee required");
        }
        else {
            return "Considered for the award";
        }
    }
    public String sendInvite(Rating rating) throws Exception{
        try {
            canBeConsideredForTheAward(rating);
            return "Actors andDirectores Invited";
        }catch (MovingRatingException e){
            return "Not invited";
        }
        catch (Exception e){
            return "other exception";
        }
    }
}

class MovingRatingException extends Exception{
    public MovingRatingException(String msg){
        super(msg);
    }
}
public class FilmFare {
    static void main(String[] args) throws Exception {
        Rating rating=new Rating(9,7);
        ratingvalidtor v=new ratingvalidtor();

        System.out.println(v.canBeConsideredForTheAward(rating).toLowerCase());
        System.out.println(v.sendInvite(rating).toLowerCase());
    }


}
