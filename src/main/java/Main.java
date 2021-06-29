public class Main {

    public static void main(String... args) {

//        Recorder.recordInDatabase();
//        Searcher.searchByWord("силикатн");
        AveragePrice.calculatingAveragePrice(Searcher.searchByWord("кирпич"));

    }
}