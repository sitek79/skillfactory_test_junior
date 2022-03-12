package app;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Practice {
    static String srcDir = "src/app/";
    static String appProp = "staff.list";

    public static void main(String ... args) {
        Practice pr = new Practice();
        pr.readHashMap();
    }

    public void readHashMap() {
        // соберем из файла набор для добавления в очередь
        Properties propHM = new Properties();

        try {
            //File file = new File(srcDir, appProp);
            //FileInputStream inputStream = new FileInputStream(file);
            propHM.load(new FileInputStream(srcDir + appProp));
            // вывод в консоль
            //prop.list(System.out);
        } catch (IOException e) {
            System.err.println("Ошибка чтения свойства в файле " + appProp);
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.err.println("Во входных данных недопустимый символ Юникода.");
        } catch (ClassCastException e) {
            System.err.println("Объект свойств содержит какие-либо ключи или значения, которые не являются строками.");
        }

        // теперь, когда у нас есть набор ключей и значений
        Map<String, HashMapProperties> statesHM = new HashMap<String, HashMapProperties>();
        // добавим этот набор в очередь
        //проходимся по всем ключам ...
        System.out.println("Пройдемся по всем ключам...");
        for (String keyHM : propHM.stringPropertyNames()) {
            //System.out.print("Ключ " + key + "свойство " + prop.get(key) + "\n");
            // ... и добавляем каждый ключ и его значение в ArrayDeque
            //String keyAdd = keyHM + " + " + propHM.get(keyHM);
            //statesHM.put(keyAdd);
            statesHM.put(keyHM, new HashMapProperties((String) propHM.get(keyHM)));
        }

        //statesHM.put("1234id54", new HashMapProperties("ENCRYPT_KEY"));
        //statesHM.put("1234id55", new HashMapProperties("HOSTNAME"));
        //statesHM.put("1234id56", new HashMapProperties("SHELL"));
        //statesHM.put("1234id57", new HashMapProperties("USER"));

        // получим объект по ключу 2
        HashMapProperties first = statesHM.get(2);
        System.out.println(first);
        // получим весь набор ключей
        Set<String> keys = statesHM.keySet();
        // получить набор всех значений
        Collection<HashMapProperties> values = statesHM.values();
        //заменить элемент
        statesHM.replace(String.valueOf(1), new HashMapProperties("MAIL"));
        // удаление элемента по ключу 2
        statesHM.remove(2);
        // перебор элементов
        for (Map.Entry<String, HashMapProperties> item : statesHM.entrySet()) {
            System.out.printf("Key: %s  Value: %s \n", item.getKey(), item.getValue().getName());
        }

        Map<String, HashMapProperties> keys2 = new HashMap<String, HashMapProperties>();
        System.out.println("Обратим внимание на порядок вывода:");
        keys2.put("123i56", new HashMapProperties("LANG"));
        keys2.put("123i54", new HashMapProperties("SHLVL"));
        keys2.put("123i55", new HashMapProperties("HOME"));

        for (Map.Entry<String, HashMapProperties> item : keys2.entrySet()) {
            System.out.printf("Key: %s  Value: %s \n", item.getKey(), item.getValue().getName());
        }
    }
}
