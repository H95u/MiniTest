import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PersonManager personManager = new PersonManager();
        int choice;
        do {
            System.out.println("-------------MENU------------");
            System.out.println("1. Hiển thị tất cả người");
            System.out.println("2. Thêm 1 người vào ds");
            System.out.println("3. Hiển thị người trong danh sách bằng mã");
            System.out.println("4. Xóa 1 người trong danh sách theo mã");
            System.out.println("5. Sửa thông tin 1 người theo mã");
            System.out.println("6. Sắp xếp danh sách theo điểm trung bình tăng dần");
            System.out.println("7. Sắp xếp danh sách theo điểm trung bình giảm dần");
            System.out.println("8. Tính tổng điểm tất cả");
            System.out.println("0. Thoát");
            System.out.println("MỜI NHẬP VÀO LỰA CHỌN CỦA BẠN");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    personManager.displayAll();
                    break;
                case 2:
                    System.out.println("1. Tạo Person");
                    System.out.println("2. Tạo Student");
                    System.out.println("MỜI NHẬP VÀO LỰA CHỌN CỦA BẠN");
                    int myChoice = Integer.parseInt(scanner.nextLine());
                    switch (myChoice) {
                        case 1:
                            personManager.addPerson();
                            personManager.displayAll();
                            break;
                        case 2:
                            personManager.addStudent();
                            personManager.displayAll();
                            break;
                    }
                    break;
                case 3:
                    personManager.showByID();
                    break;
                case 4:
                    personManager.displayAll();
                    personManager.removeByID();
                    personManager.displayAll();
                    break;
                case 5:
                    personManager.editByID();
                    personManager.displayAll();
                    break;
                case 6:
                    personManager.arrangeByAvgIncrease();
                    personManager.displayAll();
                    break;
                case 7:
                    personManager.arrangeByAvgDecrease();
                    personManager.displayAll();
                    break;
                case 8:
                    personManager.sumAll();
                    break;
            }
        } while (choice != 0);
    }
}
