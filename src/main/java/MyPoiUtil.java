import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.util.IOUtils;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.*;

public class MyPoiUtil {


    public static void exportToExcel(Connection connection, String sql, String tableName, String filePath) {

        ResultSet resultSet = null;
        PreparedStatement statement = null;
        OutputStream os = null;

        // Создать книгу Excel
        HSSFWorkbook workbook = new HSSFWorkbook();

        // Создаем таблицу и устанавливаем имя листа
        HSSFSheet sheet = workbook.createSheet(tableName);

        // Создать строку заголовка
        HSSFRow row = sheet.createRow(0);

        // формат даты
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        HSSFCreationHelper creationHelper = workbook.getCreationHelper();
        cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));

        try {

            // Запрос данных в таблице через входящий SQL
            statement = connection.prepareStatement(sql);
            // Получить набор результатов
            resultSet = statement.executeQuery();
            // Получить метаданные для получения имени поля
            ResultSetMetaData metaData = resultSet.getMetaData();
            // Количество столбцов в каждой строке
            int columnCount = metaData.getColumnCount();

            // Задаем имя столбца динамически в соответствии с именем поля, то есть заголовком
            for (int i = 0; i < columnCount; i++) {
                String labelName = metaData.getColumnLabel(i + 1);
                row.createCell(i).setCellValue(labelName);
            }

            int i = 1;

            // Временная строка
            HSSFRow tempRow;
            // Обходим набор результатов и записываем данные в Excel
            while (resultSet.next()) {
                // Создать временную строку, которая является текущей строкой
                tempRow = sheet.createRow(i);
                for (int j = 0; j < columnCount; j++) {
                    // Получить текущую ячейку
                    HSSFCell tempCell = tempRow.createCell(j);
                    // Получить данные, соответствующие текущей сетке в базе данных
                    Object temp = resultSet.getObject(j + 1);

                    // Если полученные данные пусты, пропустите эту ячейку
                    if (temp == null || "".equals(temp)) {
                        continue;
                    }

                    // Если время получено, отформатируйте время и запишите его в Excel
                    if (temp instanceof java.util.Date) {
                        // Устанавливаем стиль для даты
                        tempCell.setCellStyle(cellStyle);
                        tempCell.setCellValue((java.util.Date) temp);
                    } else if (temp instanceof Boolean) {
                        tempCell.setCellValue((Boolean) temp);
                    } else if (temp instanceof Double) {
                        tempCell.setCellValue((Double) temp);
                    } else {
                        tempCell.setCellValue(temp.toString());
                    }
                }
                i++;
            }

            os = new BufferedOutputStream(new FileOutputStream(filePath));
            // Выписать форму Excel по указанному пути
            workbook.write(os);
            System.out.println(filePath + "Done good");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Закрыть ресурсы
            IOUtils.closeQuietly(os);
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}