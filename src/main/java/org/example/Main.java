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
import org.example.frame.FileManagerFX1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String nameFile1 = "myFile123";
        String pathDir = "Новая папка2";

//        try(FileReader reader = new FileReader(pathDir + File.separator + "r.txt"))
//        {
//            // читаем посимвольно
//            int c;
//            while((c=reader.read())!=-1){
//
//                System.out.print((char)c);
//            }
//        }
//        catch(IOException ex){
//
//            System.out.println(ex.getMessage());
//        }

        FileManagerFX1 fm = new FileManagerFX1(pathDir);

//        OpenFileFX areaTest = new OpenFileFX(myFile, pathDir);   //откратие файла в окне
    }
}