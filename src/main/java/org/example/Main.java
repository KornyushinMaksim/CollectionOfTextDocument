//      Проект должен позволять выполнять базовые операции с текстовыми документами: открытие документа
//        (если содержимое документа не помещается на одном экране, нужно организовать постраничный вывод
//        с возможностью перехода вперед или назад на одну страницу), поиск по документу
//        (пользователь вводит слово для поиска, после чего производится поиск,
//        вывод результатов должен быть осуществлен с возможностью перехода на следующее или предыдущее место,
//        где найдено искомое слово / комбинация слов), замена слова или комбинации слов в документе,
//        создание нового документа. При старте проекта отображается структура коллекции.
//        Кроме уже перечисленных возможностей, пользователь может задать корневую папку коллекции,
//        посмотреть свойства документа (размер, автор, дата создания),
//        сортировать коллекцию документов (по размеру, автору, дате создания).
//        Интерфейс приложения должен позволять выводить результат работы приложения в консоль или файл.
//        Приложение должно поддерживать интерфейс командной строки.

package org.example;
import org.example.frame.TextArea;
import org.example.textDocument.WorkToFile;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        String nameFile = "myFirstFile";
        String nameFile3 = "myThirdFile";
        String path = "/Users/mac/Desktop/Новая папка";

        WorkToFile myFile = new WorkToFile(nameFile, path);
        WorkToFile myFile3 = new WorkToFile(nameFile3, path);
        myFile.createdFile();
        myFile3.createdFile();

//        System.out.println(myFile);
//        System.out.println();
//        System.out.println(myFile3);
//        System.out.println();

        File folder = new File(path);   //вывод списка файлов
        for (File file1 : folder.listFiles()){
            System.out.println(file1);
        }

        TextArea areaTest = new TextArea(myFile);   //откратие файла в окне
    }
}