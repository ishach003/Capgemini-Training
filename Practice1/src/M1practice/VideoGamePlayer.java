package M1practice;

class CarSpeed {
    String speed;
}
class CarSpeedImplementation{
    public String setCarSpeed(CarSpeed sp,int spd)  {
        try{
            if(spd<30 || spd>90){
                throw new  SpeedInvalidException("Exception in Speed Validation");
            }
            else{
                sp.speed="Valid";
            }
        }
        catch(SpeedInvalidException e){
            sp.speed=e.getMessage();
        }

        return sp.speed;
    }

}

class SpeedInvalidException extends Exception{

    public SpeedInvalidException(String msg){
        super(msg);
    }
}

public class VideoGamePlayer {
    static void main(String[] args) {
        CarSpeed s=new CarSpeed();
        CarSpeedImplementation car=new CarSpeedImplementation();

        System.out.println(car.setCarSpeed(s,20));
    }
}
