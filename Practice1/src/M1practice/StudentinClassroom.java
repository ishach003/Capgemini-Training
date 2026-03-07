package M1practice;

import java.util.ArrayList;
import java.util.Arrays;

class Source{
    public ArrayList<String> changeOccurrence(ArrayList<String> a,String m,String n){
        ArrayList<String > res=new ArrayList<>();
        for(String x:a){
            if(x.equals(m)){
                res.add(n);
            }
            else {
                res.add(x);
            }
        }

        return res;
    }
    public String listIndex(ArrayList<String> list){
        return list.get(0);
    }
    public ArrayList<String> listAfter(ArrayList<String>a,String m,String n){
        ArrayList<String> s=new ArrayList<>();
       a.add(a.indexOf(m)+1,n);

        for(int i=0;i<a.size();i++){
            s.add(a.get(i));
        }
        return s;
    }
}

public class StudentinClassroom {
    static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        Source s=new Source();

        System.out.println(s.changeOccurrence(list,"c","s"));
        System.out.println(s.listIndex(list));
        System.out.println(s.listAfter(list,"e","f"));


    }
}
