package project_1_Cryptographer.cryptographer;

import java.io.*;

public class Cryptosystem {


    public static String Cryptosystem(String txt, int key) {
        StringBuilder criptoTxt = new StringBuilder();
        for (char s : txt.toCharArray()) {
            criptoTxt.append(Character.toString(s + key));
        }
        return criptoTxt.toString();
    }

    public static void ShiftElements(File fileReader, File fileWriter, int shift) {
        String txt = ReadingFile(fileReader);
        txt = Cryptosystem(txt, shift);
        WriterFile(fileWriter,txt);
    }

    public static void Decrypted() {

    }

    public static String ReadingFile(File fileReader) {
        StringBuilder txt = new StringBuilder();
        try (BufferedReader ReaderFiles = new BufferedReader(new FileReader(fileReader))) {
            //Читаем из файла
            while (ReaderFiles.ready()) {
                txt.append(ReaderFiles.readLine());
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
