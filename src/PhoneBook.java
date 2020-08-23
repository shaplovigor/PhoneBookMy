import java.util.Scanner;
import java.util.Arrays;

public class PhoneBook {

        public static void main(String[] args) {
        // объявляем двумерный массив в 5 строк: ФИО/телефонный номер
        String[][] PhoneBook = new String[5][2];
        for (int j=0; j < PhoneBook.length; j++ ) {
            Scanner console = new Scanner(System.in);
            String FIO = "";
            String phoneNumber = "";
            System.out.println("Введите ФИО:");
            boolean isCorrectName = false;
            while (!isCorrectName) {
                // считываем новую строку с консоли: ФИО, форматируем и проверяем корректность
                FIO = formatName(console.nextLine());
                isCorrectName = checkName(FIO);
                if (!isCorrectName) System.out.println("Введите корректное имя!");
            }
            // перебираем справочник, если ФИО есть - возвращаем номер телефона, если нет - добавляем запись
            boolean isFind = false;
            for (int i = 0; i < PhoneBook.length; i++)
                if (PhoneBook[i][0] == FIO) {
                    isFind = true;
                    System.out.println(FIO + " уже есть в справочнике, телефон: " + PhoneBook[i][1]);
                    break;
                }
            if (!isFind) {
                System.out.println("Введите номер телефона: ");
                boolean isCorrectPhoneNumber = false;
                while (!isCorrectPhoneNumber) {
                    phoneNumber = formatPhoneNumber(console.nextLine());
                    // проверяем корректность ввода номера телефона
                    isCorrectPhoneNumber = checkPhoneNumber(phoneNumber);
                    if (!isCorrectPhoneNumber)
                        System.out.println("Введите корректно номер сотового телефона: 11 цифр!");
                }
                add(PhoneBook, FIO, phoneNumber);
            }
        }
        list(PhoneBook);
        }

        public static boolean checkName(String name) {
            // разделяет очищенную строку с именем на слова по пробелу, если количество слов равно 3, то ФИО введено верно
            String[] words = name.split(" ");
            return words.length == 3;
        }

        public static String formatName(String name) {
            // удаляет из введенной строки лидирующие пробелы и неправильные символы, приводит к нижнему регистру
            String cleanName = name.trim().replaceAll("[^a-zA-Zа-яА-Я- ]", "").toLowerCase();
            // первые буквы в каждом слове делает заглавными
            String[] words = cleanName.split(" ");
            String goodName = "";
            for (int i = 0; i < words.length; i++) {
                String str = words[i];
                char firstChar = str.charAt(0);
                if (!Character.isUpperCase(firstChar)) {
                    goodName += Character.toUpperCase(firstChar) + str.substring(1) + " ";
                } else {
                    goodName += str + " ";
                }
            }
            return goodName;
        }

        public static boolean checkPhoneNumber(String Number) {
            String clean = Number.replaceAll("[^0-9]", "");
            return clean.length() == 11;
        }

        public static String formatPhoneNumber(String number) {
            String clean = number.replaceAll("[^0-9]", "");
            return "+7" + " " + clean.substring(1, 4) + " " + clean.substring(4, 7) + " " + clean.substring(7, 9) + " " + clean.substring(9);
        }

        public static void add(String[][] book, String name, String number) {
            //add
            int idxNewRec = -1;
            for (int i=0; i < book.length; i++ )
                if (book[i][0] == null) {
                    idxNewRec = i;
                    break;
                }
                else if (book[i][0] != null && i == book.length - 1) {
                idxNewRec = book.length;
                book = Arrays.copyOf(book, book.length + 5);
                break;
            }
            book[idxNewRec][0] = name;
            book[idxNewRec][1] = number;
            System.out.printf("ФИО: " + name + "номер: " + number + " добавлен!\n");
        }

        public static void list(String[][] book) {
            //print phone book
            Arrays.sort(book);
            for (int i=0; i < book.length; i++)
                System.out.printf("ФИО: " + book[i][0] + "номер: " + book[i][1] + "\n");
        }
}
