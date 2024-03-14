import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String input = "Иванов Иван Иванович 01.01.2000 1234567890"; // Пример ввода данных

        try {
            String[] data = input.split(" ");
            if (data.length != 6) {
                throw new IllegalArgumentException("Неверное количество данных");
            }

            String lastName = data[0];
            String firstName = data[1];
            String middleName = data[2];
            String birthDate = data[3];
            long phoneNumber = Long.parseLong(data[4]);
            char gender = data[5].charAt(0);

            if (!birthDate.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
                throw new IllegalArgumentException("Неверный формат даты рождения");
            }

            if (gender != 'm' && gender != 'f') {
                throw new IllegalArgumentException("Неверный формат пола");
            }

            String fileName = lastName + ".txt";
            FileWriter fileWriter = new FileWriter(fileName, true);
            fileWriter.write(lastName + " " + firstName + " " + middleName + " " + birthDate + " " + phoneNumber + " " + gender + "\n");
            fileWriter.close();
        } catch (NumberFormatException e) {
            System.out.println("Ошибка преобразования номера телефона в число");
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлом");
            e.printStackTrace();
        }
    }
}