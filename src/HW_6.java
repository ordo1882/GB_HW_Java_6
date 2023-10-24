import java.util.*;
public class HW_6 {
    static class PhoneBook {
        private static TreeMap<String, ArrayList<Integer>> phoneBook = new TreeMap<>();
        public void addContact(String name, Integer phoneNum) {
            ArrayList<Integer> number = new ArrayList<>();
            if (phoneBook.containsKey(name)) {
                number = phoneBook.get(name); // Если контакт уже существует, то извлекаем его номера в список.
            }
            number.add(phoneNum); // Добавляем новый номер к предыдущим.
            number.sort(Comparator.reverseOrder()); // Сортируем номера по убыванию.
            phoneBook.put(name, number); // Добавляем в контакт.
        }
        public void removeContact(String name) {
            if (phoneBook.containsKey(name)) {
                phoneBook.remove(name);
                System.out.println("The contact " + name + " has been deleted");
            } else {
                System.out.println("The contact " + name + " is not exists.");
            }
        }
        public void removeNumber(String name, Integer numberPosition) {
            ArrayList<Integer> number = new ArrayList<>();
            if (phoneBook.containsKey(name)) {
                number = phoneBook.get(name); // Извлекаем номера контакта в список.
                number.remove(numberPosition - 1); // Удаляем номер с позиции указанной пользователем.
                number.sort(Comparator.reverseOrder()); // Сортируем номера по убыванию.
                phoneBook.put(name, number); // Добавляем в контакт.
                System.out.println("The number on position " + numberPosition + " has been deleted");
            } else {
                System.out.println("The contact " + name + " is not exists.");
            }

        }
        public void findContact(String name) {
            if (phoneBook.containsKey(name)){
                for (Map.Entry<String, ArrayList<Integer>> entry : phoneBook.entrySet()
                ) {
                    if (entry.getKey().equals(name)) {
                        System.out.print(entry.getKey() + " -- ");
                        for (int i = 0; i < entry.getValue().size(); i++) {
                            if (i == entry.getValue().size() - 1) { // Если это последний либо единственны номер, то после него ничего не выводим.
                                System.out.print(entry.getValue().get(i));
                            } else {
                                System.out.print(entry.getValue().get(i) + ", "); // Иначе перебираем номера через запятую.
                            }
                        }
                        System.out.print("\n");
                        break;
                    }
                }
            } else {
                System.out.println("The contact " + name + " is not exists.");
            }
        }
        public void showList() {
            for (Map.Entry<String, ArrayList<Integer>> entry : phoneBook.entrySet()
            ) {
                System.out.print(entry.getKey() + " -- ");
                for (int i = 0; i < entry.getValue().size(); i++) {
                    if (i == entry.getValue().size() - 1) { // Если это последний либо единственны номер, то после него ничего не выводим.
                        System.out.print(entry.getValue().get(i));
                    } else {
                        System.out.print(entry.getValue().get(i) + ", "); // Иначе перебираем номера через запятую.
                    }
                }
                System.out.print("\n");
            }
            System.out.println();
        }
    }
}
