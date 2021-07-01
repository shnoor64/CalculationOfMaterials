public class SelectorScenario {
    public static void selectingScenario(String[] args) {
        if ("add".equals(args[0])) {
            Recorder.recordInDatabase(args[1], args[2], args[3]);
        } else if ("search".equals(args[0])) {
            AveragePrice.calculatingAveragePrice(Searcher.searchByWord(args[1]));
        } else if ("remove".equals(args[0])) {
            Remover.RemoverFromDatabase(args[1]);
        }

    }
}
