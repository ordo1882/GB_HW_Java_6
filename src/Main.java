import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        HW_6.PhoneBook myPhoneBook = new HW_6.PhoneBook();
        myPhoneBook.addContact("Kolia", 3546345);
        myPhoneBook.addContact("Evgen", 5653444);
        myPhoneBook.addContact("Vitya", 2353466);
        myPhoneBook.addContact("Sandra", 7856564);

        boolean isStart = true;
        int phoneNumber;
        String name;
        while (isStart) {
            System.out.println("Make a choice:\n" +
                    "1: Add\n" +
                    "2: Delete Contact\n" +
                    "3: Delete Number\n" +
                    "4: Find the contact\n" +
                    "5: Show the list\n" +
                    "0: Exit");
            Scanner in = new Scanner(System.in);
            int op = in.nextInt();
            in.skip("\n");

            switch (op) {
                case 1:
                    System.out.print("Enter the name: ");
                    name = in.nextLine();
                    System.out.print("Enter the phone number: ");
                    phoneNumber = in.nextInt();
                    myPhoneBook.addContact(name, phoneNumber);
                    System.out.println("The contact " + name + " has been created");
                    break;
                case 2:
                    System.out.print("Enter the name: ");
                    name = in.nextLine();
                    myPhoneBook.removeContact(name);
                    break;
                case 3:
                    System.out.print("Enter the name: ");
                    name = in.nextLine();
                    System.out.print("Enter the phone number position: ");
                    Integer phoneNumberPosition = in.nextInt();
                    myPhoneBook.removeNumber(name, phoneNumberPosition);
                    break;
                case 4:
                    System.out.print("Enter the name: ");
                    name = in.nextLine();
                    myPhoneBook.findContact(name);
                    break;
                case 5:
                    myPhoneBook.showList();
                    break;
                case 0:
                    isStart = false;
                    break;
                default:
                    System.out.println("Unexpected value: " + op + "\n");
                    break;
            }
        }
    }
}