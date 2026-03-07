package M1practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Almanac{
    HashMap<String, ArrayList<String>> projects=new HashMap<>();


    public String assignProject(String name,String project){
        if(projects.containsKey(name)){
            projects.get(name).add(project);
        }
        else{
            projects.put(name,new ArrayList<>(Arrays.asList(project)));
        }
        return "Project assigned sucessfully";
    }

    public ArrayList<String> currentProjects(String name){
        if(projects.containsKey(name)){
            return projects.get(name);
        } else if (projects.get(name).size()==0) {
            return null;
        } else {
            return projects.get(name);
        }
    }

    public String finishProjecct(String name,String project){
        if(projects.containsKey(name) && projects.containsValue(project)){
            projects.get(name).remove(project);
            return "Project finished successfully";
        }
        else {
            return "Not found";
        }

    }
}

public class projectAlmanac {
    static void main(String[] args) {
        Almanac a=new Almanac();
        System.out.println(a.assignProject("Agent 47","Mission 20891"));
        System.out.println(a.assignProject("Agent 13","Mission 20891"));
        System.out.println(a.assignProject("Agent 47","Mission 20321"));
    }




}
