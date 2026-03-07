package M1practice;

class StringPlay{
    int convert;
    int max;

    public StringPlay(){
        this.convert=convert;
        this.max=max;
    }
}

class StringMethods{
    public  int covertToInt(StringPlay sp,String str){
        sp.convert=Integer.parseInt(str);
        return sp.convert;
    }

    public int getMax(StringPlay sp,char ch,String str){
        int count=0;
        for(char c:str.toCharArray()){
            if(c==ch){
                count++;
            }
        }
        sp.max=count;
        return sp.max;
    }
}

public class HarryAssignment {
    static void main(String[] args) {
        StringMethods sm=new StringMethods();
        StringPlay sp=new StringPlay();

        System.out.println(sm.getMax(sp,'g',"fgfgfgf"));
        System.out.println(sm.covertToInt(sp,"123"));

    }

}
