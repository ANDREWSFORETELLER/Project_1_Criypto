package project_1_Cryptographer;

import project_1_Cryptographer.cryptographer.Cryptosystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        String exit = "";
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            while (!exit.equalsIgnoreCase("exit")) {
                System.out.println("**************");
                System.out.println("1.Encryption");
                System.out.println("2.Decrypted");
                System.out.println("3.Exit");
                System.out.println("**************");
                //Читаем ответ пользователя
                exit = bufferedReader.readLine();
                //Сверяем с пунктами выбора
                if (exit.equals("1") || exit.equalsIgnoreCase("encryption")) {

                    File fileReader = new File("/Users/foreteller/Desktop/Java_Proekt_1/src/project_1_Cryptographer/resources/test.txt");
                    File fileWriter = new File("/Users/foreteller/Desktop/Java_Proekt_1/src/project_1_Cryptographer/resources/Cryptoshif.txt");
                    int shift = 1;
                    //Сдвигаем по указаному ключу символы
                    Cryptosystem.ShiftElements(fileReader, fileWriter, shift);
                } else if (exit.equals("2") || exit.equalsIgnoreCase("decrypted")) {

                } else if (exit.equals("3") || exit.equalsIgnoreCase("exit")) {
                    break;
                }
            }
        }catch (IOException e){
            System.out.println("Введите число от 1-3 или наберите выбранный пункт");
        }
    }
}


