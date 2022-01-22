package project_1_Cryptographer;


import java.io.*;
import java.util.*;


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
    public static String ReadingFile(String fileReader) {
        StringBuilder txt = new StringBuilder();
        boolean red = true;
        while (red) {
            try (BufferedReader ReaderFiles = new BufferedReader(new FileReader(fileReader))) {
                //Читаем из файла
                while (ReaderFiles.ready()) {
                    txt.append(ReaderFiles.readLine()).append("\n");
                }
                red = false;
            } catch (IOException e) {
                System.out.println("Путь для чтения файла не верны, введите повторно");
                fileReader = readConsole();
                red = true;
            }
        }
            return txt.toString();

    }
    public static void WriterFile(String fileWriter, String txt){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileWriter))) {
            bufferedWriter.write(txt);
            bufferedWriter.flush();
            System.out.println("\n" + "Файл записан по пути: " + fileWriter + "\n");
        } catch (IOException ioException) {
            System.out.println("Путь для записи файла не верны, введите повторно");
            fileWriter = readConsole();
            WriterFile(fileWriter,txt);
        }
    }
    public static HashMap<String,Integer> AccountSymbols(String txt){
        //Считаем количество повторяемых символов в строке
        HashMap<String,Integer> map = new HashMap<>();
        for (char symbol : txt.toCharArray()) {
            String stringSymbol = Character.toString(symbol);
            Integer result = map.get(stringSymbol);
            if (result == null){
                map.put(stringSymbol,1);
            }else map.put(stringSymbol,(result + 1));
        }
        return map;
    }
    /**
     Сортировка через stream
     Author Papin.A.I
     */
    public static LinkedHashMap<String,Integer> SortedMap(Map<String,Integer> map){
        //Сортируем, создаме из map стрим и перемещаем значение в LinkedMap т.к он имеет порядок добавления.
        //Сортировка через stream.
        LinkedHashMap<String,Integer> linkedHashMap = new LinkedHashMap<>();
        map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(x-> linkedHashMap.put(x.getKey(),x.getValue()));
        return linkedHashMap;
    }

    public static HashMap<String,String> CreationAlphabet(Set<String> key,Set<String> value){
        HashMap<String,String> map = new HashMap<>();

        Iterator<String> iteratorKey = key.iterator();
        Iterator<String> iteratorValue = value.iterator();

        while (iteratorKey.hasNext() &&iteratorValue.hasNext()){
            map.put(iteratorKey.next(),iteratorValue.next());
        }
        return map;
    }



}
