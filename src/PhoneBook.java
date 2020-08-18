import java.util.Scanner;

public class PhoneBook {

        public static void main(String[] args) {
            // объявляем двумерный массив в 5 строк: ФИО/телефонный номер
            String[][] PhoneBook = new String[5][2];
            Scanner console = new Scanner(System.in);
            System.out.println("Введите ФИО:");
            boolean isCorrectName = false;
            while (!isCorrectName) {
                // считываем новую строку с консоли: ФИО, форматируем и проверяем корректность
                String FIO = formatName(console.nextLine());
                isCorrectName = checkName(FIO);
                if (!isCorrectName) System.out.println("Введите корректное имя!");
            }
            // перебираем справочник, если ФИО есть - возвращаем номер телефона, если нет - добавляем запись
            boolean isFind = false;
            for (int i=0; PhoneBook.length; i++ )
                if (PhoneBook[i][1] = FIO) {
                    isFind = true;
                    System.out.println(FIO + " уже есть в справочнике, телефон: " + PhoneBook[i][2]);
                    break;
                }
            if (isFind = false) {
                System.out.println("Введите номер телефона: ");
                boolean isCorrectPhoneNumber = false;
                while (!isCorrectPhoneNumber) {
                    String phoneNumber = formatPhoneNumber(console.nextInt());
                    // проверяем корректность ввода номера телефона
                    isCorrectPhoneNumber = checkPhoneNumber(phoneNumber);
                    if (!isCorrectPhoneNumber) System.out.println("Введите корректно номер сотового телефона: 11 цифр!");
                }
                add(book, FIO, Number);
            }
        }

        public static boolean checkName(String name) {
            // разделяет очищенную строку с именем на слова по пробелу, если количество слов равно 3, то ФИО введено верно
            String[] words = name.split(" ");
            return words.length == 3;
        }

        public static String formatName(String name) {
            // удаляет из введенной строки лидирующие пробелы и неправильные символы, приводит к нижнему регистру
            String name = name.trim().replaceAll("[^a-zA-Zа-яА-Я- ]", "").toLowerCase();
            // первые буквы в каждом слове делает заглавными
            String[] words = name.split(" ");
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
            String clean = Number.replaceAll("[^0-9]", "");
            String result = "+7" + " " + clean.substring(1, 4) + " " +
                    clean.substring(4, 7) + " " + clean.substring(7, 9) + " " + clean.substring(9);
            return result;
        }

        public static void add(String[][] book, String name, String number) {
            //add
            int idxNewRec = -1;
            for (int i=0; book.length; i++ )
                if (book[i][1] = null) {
                    idxNewRec = i;
                    break;
                }
                else if (book[i][1] <> null and i = book.length) {
                idxNewRec = book.length + 1;
                book = Arrays.copyOf(book, book.length + 5);
                break;
            }
            book[idxNewRec][1] = name;
            book[idxNewRec][2] = number;
            System.out.printf("ФИО: " + book[i][1] + "номер: " + book[i][2] + " добавлен!");
        }

        public static void list(String[][] book) {
            //print phone book
            for (int i=0; i < book.length; i++)
                System.out.printf("ФИО: " + book[i][1] + "номер: " + book[i][2]);
        }
}
