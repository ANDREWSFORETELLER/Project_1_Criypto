package project_1_Cryptographer.cryptographer;

import project_1_Cryptographer.Helper;

import java.io.*;

public class Cryptosystem {


    public static String Cryptograf(String txt, int key) {
        StringBuilder criptoTxt = new StringBuilder();
        for (char s : txt.toCharArray()) {
            if (s =='\n'){
                criptoTxt.append("\n");
            }else {
                criptoTxt.append(Character.toString(s + key));
            }
        }
        return criptoTxt.toString();
    }

    public static void ShiftElements(File fileReader, File fileWriter, int shift) {
        String txt = Helper.ReadingFile(fileReader);
        txt = Cryptograf(txt, shift);
        Helper.WriterFile(fileWriter,txt);
    }

    public static String BruteForce(File fileReader, int shift) {
      String txt = Helper.ReadingFile(fileReader);
     return BruteForce(txt, shift);
    }
    public static String BruteForce(String txt, int shift) {
        txt = Cryptograf(txt,shift);
        if (GetStasysDecrypted(txt)){
            Helper.print(txt);
            Helper.print(new String[]{"**************",
                    "Документ раскодирован ?",
                    "Да",
                    "Нет",
                    "***************"
            });
            if (Helper.readConsole().equalsIgnoreCase("да")){
            return txt;
            }else {
                shift++;
                BruteForce(txt,-shift);
            }
        }else {
            shift++;
            txt = BruteForce(txt,-shift);
        }
        return txt;
    }

    public static String StaticAnalise(File fileReaderBook, File fileReaderPartBook) {
       String book = Helper.ReadingFile(fileReaderBook);
       String partBook = Helper.ReadingFile(fileReaderPartBook);
       char [] charBook = book.toCharArray();
       char [] charPartBook = partBook.toCharArray();
       //char[] statCharBook = new char[10000];
      // char[] statCharPartBook = new char[10000];

      // for (int i = 0; i < charBook.length; i++) {
      //      statCharBook[charBook[i]]++;
       // }
        //for (int i = 0; i < charPartBook.length; i++) {
         //   statCharPartBook[charBook[i]]++;
        //}
        return "";
    }
    public static boolean GetStasysDecrypted(String txt){
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

