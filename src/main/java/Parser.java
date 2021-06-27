
import entity.PriceList;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Parser {

    public static List<PriceList> parse(String nameXls, String provider, String updateDate) {

        String result = "";
        InputStream in = null;
        HSSFWorkbook wb = null;
        try {
            in = new FileInputStream(nameXls);
            wb = new HSSFWorkbook(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<PriceList> resultPars = new ArrayList<PriceList>();
        Sheet sheet = wb.getSheetAt(0);
        Iterator<Row> it = sheet.iterator();

        while (it.hasNext()) {
            PriceList pL = new PriceList();
            Row row = it.next();
            if (row.getRowNum() > 0) {
                Iterator<Cell> cells = row.iterator();
                pL.setProvider(provider);
                pL.setDateUpdatePrice(updateDate);

                for (int i = 0; i < 4; i++) {
                    Cell cell = cells.next();
                    switch (i) {
                        case 0:
                            pL.setCodeProduct((int) cell.getNumericCellValue());
                            break;
                        case 1:
                            pL.setNameProduct(cell.getStringCellValue());
                            break;
                        case 2:
                            pL.setUnit(cell.getStringCellValue());
                            break;
                        case 3:
                            pL.setPrice((int) cell.getNumericCellValue());
                            break;
                    }

                }
                resultPars.add(pL);

            }


        }

        return resultPars;
    }

}
