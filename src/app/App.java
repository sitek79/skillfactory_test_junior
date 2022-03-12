package app;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {
        // вывод содержимого всего файла свойств
        try {
            Stream<String> lines = Files.lines(Paths.get("src/app/staff.list"));
            lines.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Ошибка чтения файла");
        }
    }
}
