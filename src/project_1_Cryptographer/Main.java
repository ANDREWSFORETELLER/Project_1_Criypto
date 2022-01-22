package project_1_Cryptographer;

import project_1_Cryptographer.cryptographer.Cryptosystem;



public class Main {
    private static Integer key = 1;
    private static String fileReader = "";
    private static String fileWriter = "";
    private static String exit = "";

    public static void main(String[] args) {


            while (!exit.equalsIgnoreCase("exit")) {

                Helper.print(new String[]{"**************",
                        "1.Encryption/Decrypted",
                        "2.Cryptanalysis",
                        "3.Exit",
                        "**************"});

                //Читаем ответ пользователя
                exit = Helper.readConsole();

                // ENCRYPTION/DECRYPTED ****************************************************************
                if (exit.equals("1") || exit.equalsIgnoreCase("encryption/decrypted")) {
                    ScreenEncryptionDecrypted();

                    // CRYPTANALYSIS **************************************************************
                } else if (exit.equals("2") || exit.equalsIgnoreCase("cryptanalysis")) {
                    ScreenCryptanalysis();
                }

                if (exit.equals("3") || exit.equalsIgnoreCase("exit")){
                    exit = "exit";
                }
            }
        }
    private static void ScreenEncryptionDecrypted(){

        Helper.print(new String[]{"**************",
                "1.Encryption",
                "2.Decrypted",
                "3.Exit",
                "4.Back",
                "**************"
        });

        //Читаем ответ пользователя
        exit = Helper.readConsole();

        // ENCRYPTION ****************************************************************
        if (exit.equals("1") || exit.equalsIgnoreCase("encryption")) {

            // Запрашиваем у пользователя данные файлов.
            GetPatchUser(true);
            //Сдвигаем по указаному ключу символы
            Cryptosystem.ShiftElements(fileReader, fileWriter, key);

            // DECRYPTED ****************************************************************
        }else if (exit.equals("2") || exit.equalsIgnoreCase("decrypted")) {


            // Запрашиваем у пользователя данные файлов.
            GetPatchUser(true);
            //Сдвигаем по указаному ключу символы(инвертируем значение для расшифровки)
            Cryptosystem.ShiftElements(fileReader, fileWriter, -key);

        }
    }
    private static void ScreenCryptanalysis(){
        Helper.print(new String[]{"**************",
                "1.Brute force",
                "2.Static analise",
                "3.Exit",
                "4.Back",
                "**************"
        });

        //Читаем ответ пользователя
        exit = Helper.readConsole();

        // BRUTE FORCE ****************************************************************
        if (exit.equals("1") || exit.equalsIgnoreCase("brute force")
                || exit.equalsIgnoreCase("brute")
                || exit.equalsIgnoreCase("force")) {

            ScreenBruteForce();


            //STATIC ANALISE *************************************************************
        }else  if (exit.equals("2") || exit.equalsIgnoreCase("static analise")
                || exit.equalsIgnoreCase("static")
                || exit.equalsIgnoreCase("analise")) {

            ScreenStaticAnalise();

        }
    }
    private static void ScreenBruteForce(){
        GetPatchUser(false);

        String result = Cryptosystem.BruteForce(key,fileReader);

        Helper.WriterFile(fileWriter,result);

    }
    private static void ScreenStaticAnalise(){

        GetPatchUser(false);

        Helper.print("Введите путь к файлу где храниться отрывок текста");
        String fileReaderPartBook = Helper.readConsole();

        String result = Cryptosystem.StaticAnalise(fileReader, fileReaderPartBook);

        Helper.WriterFile(fileWriter, result);
    }
    public static void GetPatchUser(boolean getKey){

        Helper.print("Введите полный путь к файлу которуй требуеться считать");
        fileReader = Helper.readConsole();

        Helper.print("Введите полный путь к файлу в котором будет записан результат");
        fileWriter = Helper.readConsole();


        if (getKey) {
            //Получаем ключь и отбрасываем целую часть по ASCII
             int cache;
            while (true)
            try {
                Helper.print("Введите числовой положительный ключ по которому будет сделана зашифровка");
                cache = Integer.parseInt(Helper.readConsole());
                if (cache <= 0){
                    Helper.print(new String[]{"Вы ввели число меньше или равным ноль, требуеться ввести положительное число",
                            "******************************************************************************************"});
                }else {
                    key = cache % 255;
                    return;
                }
            }catch (NumberFormatException e){
                Helper.print("Вы ввели не число.");
            }

        }
    }

}



