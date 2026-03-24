package iocwithxml;

public class Koala {

    int id;
    String name;
    int age;
    String habitat;
    double weight;

    // Default Constructor
    public Koala() {
    }

    // Parameterized Constructor
    public Koala(int id, String name, int age, String habitat, double weight) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.habitat = habitat;
        this.weight = weight;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    // toString Method
    @Override
    public String toString() {
        return "Koala{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", habitat='" + habitat + '\'' +
                ", weight=" + weight +
                '}';
    }
}