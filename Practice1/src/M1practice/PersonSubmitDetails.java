package M1practice;

class Person1{
    String name;
    String dateOfBrith;
    String email;

    public Person1(String name, String dateOfBrith, String email) {
        this.name = name;
        this.dateOfBrith = dateOfBrith;
        this.email = email;
    }
}

class PImplementation{
    public String validator(Person1 details) throws Exception{
        int  a=Integer.parseInt(details.dateOfBrith.substring(6));
        String b=details.email.substring(details.email.length()-13);
        if(a>2000) {
            throw new InvalidDataException("data year must be less than 2000");
        }
            if (!b.equals("@doselect.com")) {
                throw new InvalidEmailException("only @doselect.com domain email are accepted");
            }


            return "vaild details";

    }
    public String submitDetails(Person1 details){
        try{
            validator(details);
            return "details sumbitted successfully";

        }catch(InvalidDataException e){
            return "invalid details";
        }
        catch (InvalidEmailException e){
            return "invaild details";
        }
        catch (Exception e){
            return "other expection";
        }
    }
}

class InvalidDataException extends Exception{

    public InvalidDataException(String str){
        super(str);
    }
}

class InvalidEmailException extends Exception{
    public InvalidEmailException(String str) {
        super(str);
    }
}
public class PersonSubmitDetails {

    static void main(String[] args) throws Exception {
        Person1 data=new Person1("Steve","12-02-1999","Steve12@doselect.com");
        PImplementation obj=new PImplementation();
        System.out.println(obj.validator(data));
        System.out.println(obj.submitDetails(data));
    }

}
