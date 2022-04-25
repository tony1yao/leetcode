import java.util.*;

public class Monarchy {
    public static void main(String[] args) {
        Monarchy mon = new Monarchy("Jake");
        mon.birth("Catherine", "Jake");
        mon.birth("Tom", "Jake");
        mon.birth("Celine", "Jake");
        mon.birth("Peter", "Celine");
        mon.birth("Jane", "Catherine");
        mon.birth("Farah", "Jane");
        mon.birth("Mark", "Catherine");

        System.out.println(mon.getOrderOfSuccession());

        mon.death("Jake");
        mon.death("Jane");
        System.out.println(mon.getOrderOfSuccession());
    }



    private Person root;
    private Map<String, Person> personMap;

    public Monarchy(String name) {
        this.root = new Person(name);
        this.personMap = new HashMap<>();
        this.personMap.put(name, this.root);
    }

    public void birth(String childName, String parentName) {
        Person newChild = new Person(childName);
        this.personMap.get(parentName).addChild(newChild);
        this.personMap.put(childName, newChild);
    }

    public void death(String name) {
        this.personMap.get(name).setAlive(false);
    }

    public List<String> getOrderOfSuccession() {
        List<String> monarchyList = new ArrayList<>();
        dfs(this.root, monarchyList);
        return monarchyList;
    }

    private void dfs(Person person, List<String> monarchyList) {
        if (person.isAlive()) {
            monarchyList.add(person.getName());
        }

        if (person.getChildren() != null && !person.getChildren().isEmpty()) {
            person.getChildren().forEach(child -> dfs(child, monarchyList));
        }

    }
}

class Person  {
    private String name;
    private Boolean alive;
    private List<Person> children;

    public Person(String name) {
        this.name = name;
        this.alive = true;
        this.children = null;
    }

    public String getName() {
        return name;
    }

    public Boolean isAlive() {
        return alive;
    }

    public void setAlive(Boolean alive) {
        this.alive = alive;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addChild(Person person) {
        if (this.children == null) {
            this.children = new ArrayList<>();
        }
        this.children.add(person);
    }
}