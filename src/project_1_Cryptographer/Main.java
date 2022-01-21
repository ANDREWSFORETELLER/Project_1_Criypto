package project_1_Cryptographer;

import project_1_Cryptographer.cryptographer.Cryptosystem;


import java.io.File;


public class Main {
    public static void main(String[] args) {
        String exit = "";

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

                    Helper.print(new String[]{"**************",
                            "1.Encryption",
                            "2.Decrypted",
                            "3.Back",
                            "4.Exit",
                            "**************"
                    });

                    //Читаем ответ пользователя
                    exit = Helper.readConsole();

                    // ENCRYPTION ****************************************************************
                    if (exit.equals("1") || exit.equalsIgnoreCase("encryption")) {
                        //Получаем путь к файлу из которого читаем
                        File fileReader = new File("/Users/foreteller/Desktop/Java_Proekt_1/src/project_1_Cryptographer/resources/gluhovskiy_metro-gluhovskiy-_1_metro-2033_xbz24g_Book.txt");

                        //Получаеть путь к файлу в который пишем
                        File fileWriter = new File("/Users/foreteller/Desktop/Java_Proekt_1/src/project_1_Cryptographer/resources/Cryptoshif.txt");

                        //Получаем ключь и отбрасываем целую часть по ASCII
                        int shift = 3 % 255;

                        //Сдвигаем по указаному ключу символы
                        Cryptosystem.ShiftElements(fileReader, fileWriter, shift);

                        // DECRYPTED ****************************************************************
                    }else if (exit.equals("2") || exit.equalsIgnoreCase("decrypted")) {
                        //Получаем путь к файлу из которого читаем
                        File fileReader = new File("/Users/foreteller/Desktop/Java_Proekt_1/src/project_1_Cryptographer/resources/test.txt");

                        //Получаеть путь к файлу в который пишем
                        File fileWriter = new File("/Users/foreteller/Desktop/Java_Proekt_1/src/project_1_Cryptographer/resources/Cryptoshif.txt");

                        //Получаем ключь и отбрасываем целую часть по ASCII
                        int shift = 3 % 255;

                        //Сдвигаем по указаному ключу символы(инвертируем значение для расшифровки)
                        Cryptosystem.ShiftElements(fileWriter, fileReader, -shift);

                        // BACK and EXIT **************************************************************
                    }else if (exit.equals("3") || exit.equalsIgnoreCase("back")){
                        exit = "";
                    }else if (exit.equals("4") || exit.equalsIgnoreCase("exit")){
                        break;
                    }
                        // CRYPTANALYSIS **************************************************************
                } else if (exit.equals("2") || exit.equalsIgnoreCase("cryptanalysis")) {
                    Helper.print(new String[]{"**************",
                            "1.Brute force",
                            "2.Static analise",
                            "3.Back",
                            "4.Exit",
                            "**************"
                    });

                    //Читаем ответ пользователя
                    exit = Helper.readConsole();

                    // BRUTE FORCE ****************************************************************
                    if (exit.equals("1") || exit.equalsIgnoreCase("brute force")
                            || exit.equalsIgnoreCase("brute")
                            || exit.equalsIgnoreCase("force")) {

                        //Получаеть путь к файлу в который пишем
                        File fileWriter = new File("/Users/foreteller/Desktop/Java_Proekt_1/src/project_1_Cryptographer/resources/Cryptoshif.txt");

                        //Получаем ключь и отбрасываем целую часть по ASCII
                        int shift = 1 % 255;

                        String result = Cryptosystem.BruteForce(fileWriter,shift);
                        //Получаем путь к файлу в который нужно писать
                        File fileReader = new File("/Users/foreteller/Desktop/Java_Proekt_1/src/project_1_Cryptographer/resources/test.txt");

                        Helper.WriterFile(fileReader,result);

                        //STATIC ANALISE *************************************************************
                    }else  if (exit.equals("2") || exit.equalsIgnoreCase("static analise")
                            || exit.equalsIgnoreCase("static")
                            || exit.equalsIgnoreCase("analise")) {

                        //Получаем путь части книги
                        File fileReaderPartBook = new File("/Users/foreteller/Desktop/Java_Proekt_1/src/project_1_Cryptographer/resources/gluhovskiy_metro-gluhovskiy-_1_metro_Part.txt");

                        //Получаем путь  книги
                        File fileReaderBook = new File("/Users/foreteller/Desktop/Java_Proekt_1/src/project_1_Cryptographer/resources/gluhovskiy_metro-gluhovskiy-_1_metro-2033_xbz24g_Book.txt");

                        String result = Cryptosystem.StaticAnalise(fileReaderBook, fileReaderPartBook);

                    }
                } else if (exit.equals("3") || exit.equalsIgnoreCase("back")){
                    exit = "";
                }else if (exit.equals("4") || exit.equalsIgnoreCase("exit")){
                    break;
                }
            }
        }
    }



