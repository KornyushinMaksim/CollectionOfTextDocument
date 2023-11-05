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
import org.example.frame.FileManager;
import org.example.frame.TextArea;
import org.example.textDocument.WorkToFile;
import org.example.text_new.WorkWithFile;

import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String nameFile1 = "myFile123";
        String pathDir = "Новая папка2";

//        WorkWithFile workWithFile = null;
//        try {
//            workWithFile = new WorkWithFile(pathDir, nameFile1);
//        } catch (UnknownHostException e) {
//            throw new RuntimeException(e);
//        }
//        workWithFile.myCreatedNewFile(pathDir, nameFile1);
//        sleep(10000);
//        workWithFile.myDeleteFile();


////создание папки
//        File dir = new File(path);
//        if (dir.exists()){
//            System.out.println("Папка существует");
//        } else {
//            System.out.println(dir.mkdir());
//        }
//
//
//        File newFile = new File(path + File.separator + nameFile);
//        if (newFile.exists()){
//            System.out.println("Файл существует");
//        } else {
//            System.out.println(newFile.createNewFile());
//        }



//        String nameFile = "myFirstFile";
//        String nameFile3 = "myThirdFile";
//        String path = "D:\\Учеба\\javaProgect\\CollectionOfTextDocument\\Новая папка";
//
//        WorkToFile myFile = new WorkToFile(nameFile, path);
//        WorkToFile myFile3 = new WorkToFile(nameFile3, path);
//        myFile.createdNewFile();
//        myFile3.createdNewFile();
//
//
//        System.out.println(myFile);
//        System.out.println();
//        System.out.println(myFile3);
//        System.out.println();

                //вывод списка файлов в каталоге
//окно файлменеджера
        FileManager fm = new FileManager(pathDir);

//        TextArea areaTest = new TextArea(myFile, pathDir);   //откратие файла в окне
    }
}