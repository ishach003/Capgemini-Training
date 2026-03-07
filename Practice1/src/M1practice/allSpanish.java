package M1practice;

import java.util.ArrayList;
import java.util.List;

class Dish{
    String dishName;

    public Dish(String dishName) {
        this.dishName = dishName;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "dishName='" + dishName + '\'' +
                '}';
    }
}

class dishTest{
    public List<Dish> addYummyToName(List<Dish> list,String s){
        List<Dish> dishList=new ArrayList<>();

        for (Dish d:list){
            Dish dish=new Dish(s+" "+d.getDishName());
            dishList.add(dish);
        }

        return dishList;
    }

    public long count(List<Dish> list,String s){
        long max=0;
        for (Dish l:list){
            if(l.getDishName().contains(s)){
                max++;
            }
        }
        return max;
    }
}

public class allSpanish {
    static void main(String[] args) {
        dishTest dt=new dishTest();
        List<Dish> list=new ArrayList<Dish>();
        list.add(new Dish("Gazpacho"));
        list.add(new Dish("Tamon"));
        list.add(new Dish("Tortilla"));
        list.add(new Dish("Gazpacho"));

        System.out.println(dt.addYummyToName(list,"Yummy"));
        System.out.println(dt.count(list,"a"));
    }
}
