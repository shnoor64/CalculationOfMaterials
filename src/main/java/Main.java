
public class Main {

    public static void main(String... args) {

//        Recorder.recordInDatabase("C:\\Users\\Shnoor64\\IdeaProjects\\CalculationOfMaterials\\testPrice\\testfile1.xls"
//                ,"ИП Стройхлам"
//                ,"30.06.2021");
//
//        Recorder.recordInDatabase("C:\\Users\\Shnoor64\\IdeaProjects\\CalculationOfMaterials\\testPrice\\testfile2.xls"
//                ,"Рога и копыта"
//                ,"30.06.2021");

//        Searcher.searchByWord("силикатн");
        AveragePrice.calculatingAveragePrice(Searcher.searchByWord("кирпич"));
//        Remover.RemoverFromDatabase("ИП Стройхлам");
    }
}