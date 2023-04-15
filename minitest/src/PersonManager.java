import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class PersonManager implements ManagerInterface {
    private ArrayList<Person> personArr;
    private Scanner scanner;

    public PersonManager() {
        personArr = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    @Override
    public void displayAll() {
        if (personArr.isEmpty()) {
            System.out.println("Không có người nào trong danh sách");
        } else {
            for (Person person : personArr) {
                System.out.println(person);
            }
        }
    }

    @Override
    public void addPerson() {
        System.out.println("Mời nhập tên");
        String name = scanner.nextLine();
        System.out.println("Mời nhập tuổi");
        int age = Integer.parseInt(scanner.nextLine());
        Person person = new Person(name, age);
        personArr.add(person);
    }

    public void addStudent() {
        System.out.println("Mời nhập tên");
        String name = scanner.nextLine();
        System.out.println("Mời nhập tuổi");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Mời nhập điểm TB");
        double avgPoint = Double.parseDouble(scanner.nextLine());
        Student student = new Student(name, age, avgPoint);
        personArr.add(student);
    }

    @Override
    public void showByID() {
        int index = getIndexByID();
        if (index != -1) {
            System.out.println(personArr.get(index));
        } else {
            System.out.println("Không có id bạn vừa nhập vào trong danh sách");
        }
    }

    @Override
    public void removeByID() {
        int index = getIndexByID();
        if (index != -1) {
            System.out.println(personArr.remove(index));
        } else {
            System.out.println("Không có id bạn vừa nhập vào trong danh sách");
        }
    }

    @Override
    public void editByID() {
        int index = getIndexByID();
        if (index != -1) {
            System.out.println("Mời nhập vào tên mới");
            personArr.get(index).setName(scanner.nextLine());
            System.out.println("Mời nhập tuổi mới");
            personArr.get(index).setAge(Integer.parseInt(scanner.nextLine()));
            if (personArr.get(index) instanceof Student) {
                System.out.println("Mời nhập vào điểm TB mới");
                ((Student) personArr.get(index)).setAvgPoint(Double.parseDouble(scanner.nextLine()));
            }
        } else {
            System.out.println("Không có id bạn vừa nhập vào trong danh sách");
        }
    }

    @Override
    public void arrangeByAvgIncrease() {
        personArr.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1 instanceof Student && o2 instanceof Student) {
                    if (((Student) o1).getAvgPoint() > ((Student) o2).getAvgPoint()) return 1;
                    if (((Student) o1).getAvgPoint() < ((Student) o2).getAvgPoint()) return -1;
                    else return 0;
                } else if (o1 instanceof Student) return -1;
                else if (o2 instanceof Student) return 1;
                else return 0;
            }
        });
    }

    public void arrangeByAvgDecrease() {
        personArr.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1 instanceof Student && o2 instanceof Student) {
                    if (((Student) o1).getAvgPoint() > ((Student) o2).getAvgPoint()) return -1;
                    if (((Student) o1).getAvgPoint() < ((Student) o2).getAvgPoint()) return 1;
                    else return 0;
                } else if (o1 instanceof Student) return -1;
                else if (o2 instanceof Student) return 1;
                else return 0;
            }
        });
    }

    @Override
    public void sumAll() {
        double sum = 0;
        for (Person person : personArr) {
            if (person instanceof Student) {
                sum += ((Student) person).getAvgPoint();
            }
        }
        System.out.println("Tổng điểm của các học sinh là : " + sum);
    }

    public int getIndexByID() {
        System.out.println("Mời nhập vào id");
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < personArr.size(); i++) {
            if (personArr.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}
