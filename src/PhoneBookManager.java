import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBookManager {
    List<PhoneBook> phoneBookList;

    private static final String EMAIL_REGEX =   "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    //Số điện thoại gồm 10 số nếu có nhập số 0 ở đầu tiên. Nếu không nhập 0 thì còn 9 số.
    public static final String PHONENUMBERS_REGEX = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$";

    public PhoneBook phoneBookInfo(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số điện thoại: ");
        String phoneNumber = scanner.nextLine();

        Pattern pattern = Pattern.compile(PHONENUMBERS_REGEX);
        Matcher matcher = pattern.matcher(phoneNumber);
        if (!matcher.find()){
            System.out.println("Số điện thoại không đúng. Mời nhập lại");

        }
        System.out.print("Nhập nhóm danh bạ:");
        String group = scanner.nextLine();
        System.out.print("Nhập Họ và tên:");
        String name = scanner.nextLine();
        System.out.print("Nhập giới tính:");
        String gender = scanner.nextLine();
        System.out.print("Nhập địa chỉ:");
        String address = scanner.nextLine();
        System.out.print("Nhập ngày sinh:");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Nhập địa chỉ Email:");
        String email = scanner.nextLine();

        Pattern pattern1 = Pattern.compile(EMAIL_REGEX);
        Matcher matcher1 = pattern1.matcher(email);
        if (!matcher1.find()){
            System.out.println("Email không đúng. Mời nhập lại");
        }
        PhoneBook phoneBook = new PhoneBook(phoneNumber, group, name, gender, address, dateOfBirth, email);
        return phoneBook;
    }
    public void addPhoneBook() throws IOException {
        PhoneBook phoneBook = phoneBookInfo();
        phoneBookList.add(phoneBook);
        PhoneBookFile.writeFile(phoneBookList);
    }

    public void displayPhoneBook(){
        for (PhoneBook phoneBook: phoneBookList
             ) {
            System.out.println(phoneBook);
        }
    }

    public void editPhoneBookByPhoneNumber(String phoneNumber, PhoneBook phoneBook) throws IOException {
        for (int i = 0; i < phoneBookList.size(); i++) {
            if (phoneBookList.get(i).getPhoneNumber().equals(phoneNumber)){
                phoneBookList.get(i).setPhoneNumber(phoneBook.getPhoneNumber());
                phoneBookList.get(i).setGroup(phoneBook.getGroup());
                phoneBookList.get(i).setName(phoneBook.getName());
                phoneBookList.get(i).setGender(phoneBook.getGender());
                phoneBookList.get(i).setAddress(phoneBook.getAddress());
                phoneBookList.get(i).setDateOfBirth(phoneBook.getDateOfBirth());
                phoneBookList.get(i).setEmail(phoneBook.getEmail());
            }
        }
        PhoneBookFile.writeFile(phoneBookList);
    }

    public void deletePhoneBookByPhoneNumber(String phoneNumber) throws IOException{
        for (int i = 0; i < phoneBookList.size(); i++) {
            if (phoneBookList.get(i).getPhoneNumber().equals(phoneNumber)){
                phoneBookList.remove(i);
            }
            PhoneBookFile.writeFile(phoneBookList);
        }
    }
    public PhoneBook findPhoneBookByPhoneNum(String phonenumber) {
        for (PhoneBook phoneBook : phoneBookList) {
            if (phoneBook.getPhoneNumber().equals(phonenumber)) {
                return phoneBook;
            }
        }
        return null;
    }

    public void writeFile() throws IOException{
        try {
            PhoneBookFile.writeFile(phoneBookList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public PhoneBookManager() {
    }

    public PhoneBookManager(List<PhoneBook> phoneBookList) {
        this.phoneBookList = phoneBookList;
    }

    public List<PhoneBook> getPhoneBookList() {
        return phoneBookList;
    }

    public void setPhoneBookList(List<PhoneBook> phoneBookList) {
        this.phoneBookList = phoneBookList;
    }

    @Override
    public String toString() {
        return "PhoneBookManager{" +
                "phoneBookList=" + phoneBookList +
                '}';
    }
}
