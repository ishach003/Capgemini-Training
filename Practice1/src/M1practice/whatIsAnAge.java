package M1practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Person{
    private String name;
    private  int age;

     public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
         this.name=name;
    }

    public void setAge(int age){
         this.age=age;
    }
    public int getAge(){
         return age;
    }
}

class StreamImplementation{
    public int sumAge(List<Person> list){
        return list.stream().filter(e->e.getAge()>50)
                .mapToInt(e->e.getAge())
                .sum();
    }

    public List<String> printName(List<Person> list){
        return list.stream().map(e->e.getName())
                .collect(Collectors.toList());
    }

    public List<Integer> printAge(List<Person> list){
        return  list.stream()
                .map(e->e.getAge())
                .collect(Collectors.toList());
    }
}

public class whatIsAnAge {
    static void main(String[] args) {
        List<Person> list=new ArrayList<>();
        list.add(new Person("perry",20));
        list.add(new Person("ferry",52));
        list.add(new Person("katty",100));
        list.add(new Person("elly",10));

        StreamImplementation st=new StreamImplementation();
        System.out.println(st.sumAge(list));
        System.out.println(st.printAge(list));
        System.out.println(st.printName(list));
    }
}
