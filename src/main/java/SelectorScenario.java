public class SelectorScenario {
    public static void selectingScenario(String[] args) {
        switch (args [0]){
            case "add":
                Recorder.recordInDatabase(args [1],args [2] ,args [3]);
                break;
            case "search":
                AveragePrice.calculatingAveragePrice(Searcher.searchByWord(args [1]));
                break;
            case "remove":
                Remover.RemoverFromDatabase(args [1]);
                break;

        }

    }
}
