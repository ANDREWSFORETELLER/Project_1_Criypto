package project_1_Cryptographer.cryptographer;

import project_1_Cryptographer.Helper;

import java.util.*;

public class Cryptosystem {
    public static String Cryptograf(String txt, int key) {
        StringBuilder criptoTxt = new StringBuilder();
        for (char s : txt.toCharArray()) {
            if (s =='\n'){
                criptoTxt.append("\n");
            }else {
                        criptoTxt.append((char) (s + key));
            }
        }
        System.out.println(key);
        return criptoTxt.toString();
    }
    public static void ShiftElements(String fileReader, String fileWriter, int shift) {
        String txt = Helper.ReadingFile(fileReader);
        txt = Cryptograf(txt, shift);
        Helper.WriterFile(fileWriter,txt);
    }
    public static String BruteForce(int shift, String fileReader) {
        String txt = Helper.ReadingFile(fileReader);
        return BruteForce(txt,shift);
    }

    public static String BruteForce(String txt, int shift) {
        String txtCryptograf;
        while (shift < 1000) {
            txtCryptograf = Cryptograf(txt,-shift);
            if (GetStasysDecrypted(txtCryptograf)) {
                Helper.print(txtCryptograf);
                Helper.print(new String[]{"**************",
                        "Документ раскодирован ?",
                        "Да",
                        "Нет, или любой другой символ",
                        "***************"
                });
                    String res = Helper.readConsole();
                    if (res.equalsIgnoreCase("Да")){
                        return txtCryptograf;
                    }
            }
            shift++;
        }
        Helper.print("Было сделано 1000 попыток. Расшифровать не удалось, попробуйте в другой раз....");
        return "";
    }
    public static String StaticAnalise(String fileReaderBook, String fileReaderPartBook) {

        String book = Helper.ReadingFile(fileReaderBook); //Считываем Текст
        String partBook = Helper.ReadingFile(fileReaderPartBook);//Считываем отрывок из Текста

        HashMap<String,Integer> mapBook = Helper.AccountSymbols(book); //Считаем количество повторяемых символов в строке
        HashMap<String,Integer> mapPartBook = Helper.AccountSymbols(partBook); //Считаем количество повторяемых символов в строке

        LinkedHashMap<String,Integer> sortedLinkedMapBook = Helper.SortedMap(mapBook); //Сортировка через stream
        LinkedHashMap<String,Integer> sortedLinkedPartMapBook = Helper.SortedMap(mapPartBook);//Сортировка через stream

        Set<String> keyBook = sortedLinkedMapBook.keySet(); // Получаем отсортированое множество ключей
        Set<String> keyPartBook = sortedLinkedPartMapBook.keySet(); // Получаем отсортированое множество ключей

        HashMap<String,String> alphabet = Helper.CreationAlphabet(keyBook,keyPartBook); //Получаем map соответсвтий

        return DecryptionStaticAnalise(alphabet,book); //

    }
    private static String DecryptionStaticAnalise(HashMap<String,String> alphabet,String txt){
        StringBuilder stringBuilder = new StringBuilder();

        for (char symbol : txt.toCharArray()) {
            String resultNull = alphabet.get(Character.toString(symbol));
            if (resultNull != null){
            stringBuilder.append(resultNull);
            }
        }
        return stringBuilder.toString();

    }
    private static boolean GetStasysDecrypted(String txt){

        String[] txtPars = txt.split(", ");

        //Проверяем после есть ли после запятой пробел.
        if (txtPars.length > 1){


            txtPars = txt.split("[\\W][А-Я\n]");
            //Проверяем после спец символа .,!? и т.д есть ли Переход на другую строчку или Заглавная бука
            if (txtPars.length > 1) {
                txtPars = txt.split("\n[А-Я]");
                //Проверяем есть ли после переноса строки заглавная буква
                return txtPars.length > 1;
            }
        }
        return false;
    }

}

