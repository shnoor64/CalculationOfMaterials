import entity.PriceList;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        try {
            while (!input.equalsIgnoreCase("stop")) {
                showMenu();
                input = in.readLine();
                if (input.equals("add")) {
                    System.out.println("Введите путь к файлу");
                    String filePathXls = in.readLine();
                    File file = new File(filePathXls);
                    if (!file.exists()) {
                        System.out.println(file.getCanonicalPath() + "- указанный путь не существует, проверьте правильность ввода");
                        continue;
                    }

                    System.out.println("Введите поставщика");
                    String provider = in.readLine();
                    System.out.println("Введите дату обновления");
                    String updateDate = in.readLine();
                    Recorder.recordInDatabase(filePathXls, provider, updateDate);
                } else if (input.equals("search")) {
                    System.out.println("Что ищем?");
                    String searchWord = in.readLine();
                    System.out.println("Результат поиска:");
                    List<PriceList> resoult = Searcher.searchByWord(searchWord);
                    if (resoult.isEmpty()) {
                        System.out.println("По запросу <"+searchWord+"> ничего не найдено");
                    }
                    else {
                        AveragePrice.calculatingAveragePrice(resoult);
                    }
                } else if (input.equals("remove")) {
                    System.out.println("Введите имя поставщика, прайслист которого хотите удалить");
                    String nameProvider = in.readLine();
                    Remover.RemoverFromDatabase(nameProvider);
                    System.out.println("Прайслист поставщика <"+nameProvider+"> успешно удален");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showMenu() {
        System.out.println("Введите команду:" + "\n" +
                "add для добавления нового прайслиста" + "\n" +
                "search для поиска" + "\n" +
                "remove для удаления прайслиста" + "\n" +
                "stop для выхода");

//////////////////////////
//    public static void main(String... args) throws IOException {
//        SelectorScenario.selectingScenario(args);
///////////////////////////

//        Recorder.recordInDatabase("C:\\Users\\Shnoor64\\IdeaProjects\\CalculationOfMaterials\\testPrice\\testfile1.xls"
//                ,"ИП Стройхлам"
//                ,"30.06.2021");
//
//        Recorder.recordInDatabase("C:\\Users\\Shnoor64\\IdeaProjects\\CalculationOfMaterials\\testPrice\\testfile2.xls"
//                ,"Рога и копыта"
//                ,"30.06.2021");

//        Searcher.searchByWord("силикатн");
//        AveragePrice.calculatingAveragePrice(Searcher.searchByWord("кирпич"));
//        Remover.RemoverFromDatabase("ИП Стройхлам");
    }
}