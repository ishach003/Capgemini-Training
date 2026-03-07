package M1practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Model{
    String modelName;
    int carSpeed;

    public Model(String modelName, int carSpeed){
        this.modelName=modelName;
        this.carSpeed=carSpeed;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getCarSpeed() {
        return carSpeed;
    }

    public void setCarSpeed(int carSpeed) {
        this.carSpeed = carSpeed;
    }

    @Override
    public String toString() {
        return "Model{" +
                "modelName='" + modelName + '\'' +
                ", carSpeed=" + carSpeed +
                '}';
    }
}

class Implementation{
    public List<String> getModelName(List<Model> list){
        return list.stream()
                .map(m->m.getModelName())
                .collect(Collectors.toList());
    }

    public Model getModelInfo(List<Model> list, String model,int speed){
        return list.stream().filter(m->m.getModelName()==model && m.getCarSpeed()==speed)
                .findAny().get() ;

    }

}

public class OfferOnBrands {

    static void main(String[] args) {
        List<Model> list=new ArrayList<>();
        list.add(new Model("SUV",500));
        list.add(new Model("SEDAN",800));

        Implementation i=new Implementation();
        System.out.println(i.getModelName(list));
        System.out.println(i.getModelInfo(list,"SUV",500));
    }

}
