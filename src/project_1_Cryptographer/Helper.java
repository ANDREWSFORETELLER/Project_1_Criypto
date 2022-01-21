package project_1_Cryptographer;

import java.io.*;
import java.util.List;

public class Helper {
    static private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static void print(String string){
        System.out.println(string);
    }
    public static void print(String[] strings){
        for (String string: strings) {
            print(string);
        }
    }
    public static String readConsole() {
        String string = "";
        try {
            string = bufferedReader.readLine();
        }catch (IOException e){
            print("Вы ввели некорректные данные");
        }
        return string;
    }
    public static String ReadingFile(File fileReader) {
        StringBuilder txt = new StringBuilder();
        try (BufferedReader ReaderFiles = new BufferedReader(new FileReader(fileReader))) {
            //Читаем из файла
            while (ReaderFiles.ready()) {
                txt.append(ReaderFiles.readLine()).append("\n");
            }

        }catch (IOException e){
            System.out.println("Фаил или путь для чтения файла не верны.");
        }
        return txt.toString();
    }
    public static void WriterFile(File fileWriter, String txt){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileWriter))) {
            bufferedWriter.write(txt);
            bufferedWriter.flush();
            System.out.println("\n" + "Файл записан по пути: " + fileWriter.getPath() + "\n");
        } catch (IOException ioException) {
            System.out.println("Фаил или путь для записи файла не верны.");
        }
    }

}
