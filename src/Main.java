import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        PhoneBookManager phoneBookManager = new PhoneBookManager();
        int choice = -1;
        while (choice != 0) {
            System.out.println("---CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ---");
            System.out.println("(Chọn chức năng theo số để tiếp tục)");
            System.out.println("1. Xem danh sách ");
            System.out.println("2. Thêm mới ");
            System.out.println("3. Cập nhật ");
            System.out.println("4. Xóa ");
            System.out.println("5. Tìm kiếm ");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi vào file");
            System.out.println("0. Thoát");
            System.out.println("Chọn chức năng: ");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Danh sách điện thoại: ");
                    phoneBookManager.displayPhoneBook();
                    break;
                case 2:
                    System.out.println("___THÊM MỚI SỐ ĐIỆN THOẠI___ ");
                    try {
                        phoneBookManager.addPhoneBook();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    System.out.println("Nhập số điện thoại cần sửa: ");
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Nhập lại thông tin: ");
                    PhoneBook phoneBook = phoneBookManager.phoneBookInfo();
                    String phoneNumbers = scanner.nextLine();
                    try {
                        phoneBookManager.editPhoneBookByPhoneNumber(phoneNumbers, phoneBook);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    System.out.println("Nhập số điện thoại cần xóa: ");
                    Scanner scanner1 = new Scanner(System.in);
                    String phoneNumber = scanner1.nextLine();
                    try {
                        phoneBookManager.deletePhoneBookByPhoneNumber(phoneNumber);
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    System.out.print("Nhập số điện thoại cần tìm: ");
                    Scanner scanner2 = new Scanner(System.in);
                    String phoneNumber1 = scanner2.nextLine();
                    phoneBookManager.findPhoneBookByPhoneNum(phoneNumber1);
                    break;
                case 6:

                case 7:
                    try {
                        phoneBookManager.writeFile();
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                    break;

                case 0:
                    System.exit(0);
            }
        }
    }
}
