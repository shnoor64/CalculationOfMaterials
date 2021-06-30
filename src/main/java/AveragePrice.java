import entity.PriceList;

import java.util.List;

public class AveragePrice {
    public static float calculatingAveragePrice(List<PriceList> selectedLinesOfPriceList) {
        float resoult = 0;
        for (int i = 0; i < selectedLinesOfPriceList.size(); i++) {
            resoult += selectedLinesOfPriceList.get(i).getPrice();
        }
        resoult = resoult / selectedLinesOfPriceList.size();
        System.out.println("Средняя цена: "+resoult);
        return resoult;
    }
}
