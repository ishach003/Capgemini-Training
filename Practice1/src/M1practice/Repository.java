package M1practice;

class repository1{
    static String getCountryName(String countryCode) throws InvalidCodeExpection{
        int cc=Integer.parseInt(countryCode);

        if(cc>70 && cc<90){
            return "India";
        } else if (cc==908) {
            return "US";
        } else if (cc==011) {
            return "Dial somewhere outside of USA";
        }
        else {
            throw new InvalidCodeExpection("No country with the given code found");
        }
    }
}

class repositoryImplementation{
    public static String getCountry(String countryCode) throws InvalidCodeExpection {
        int n=countryCode.length();
        if(n>3 || n<2){
            throw new InvalidCodeExpection("Invalid code detail found");
        }
        else{
            countryCode=repository1.getCountryName(countryCode);
        }

        return countryCode;
    }
}

class InvalidCodeExpection extends Exception{
    public InvalidCodeExpection(String msg){
        super(msg);
    }
}

public class Repository {
    static void main(String[] args) throws InvalidCodeExpection {
        repositoryImplementation obj=new repositoryImplementation();
        System.out.println(obj.getCountry("1"));
    }
}
