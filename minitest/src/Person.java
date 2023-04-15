public class Person {
    private int id;
    private static int idtemp = 1;
    private String name;
    private int age;

    public Person() {
        this.id = idtemp++;
    }

    public Person(String name, int age) {
        this.id = idtemp++;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getIdtemp() {
        return idtemp;
    }

    public static void setIdtemp(int idtemp) {
        Person.idtemp = idtemp;
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

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
