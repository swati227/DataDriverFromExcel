import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.Arrays;
import java.util.Iterator;

public class DataDriverFromExcel {

    public ArrayList<String> getData(String testCaseName) throws IOException {

        ArrayList<String> dataArray = new ArrayList<>();

        FileInputStream fileInputStream = new FileInputStream("/Users/nikhilpatil/Downloads/Demo_data.xlsx");

//        fileinputstream argument
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        int numberOfSheets = workbook.getNumberOfSheets();
//        System.out.println(numberOfSheets);

        for(int i=0; i<numberOfSheets; i++){

            if(workbook.getSheetName(i).equalsIgnoreCase("TestData")){
                XSSFSheet sheet = workbook.getSheetAt(i);
                Iterator<Row> rows = sheet.iterator();
                Row firstRow = rows.next();

                Iterator<Cell> cellIterator = firstRow.cellIterator();

                int k = 0;
                int column = 0;
                while(cellIterator.hasNext()){
                    Cell value = cellIterator.next();
                    if(value.getStringCellValue().equalsIgnoreCase(testCaseName)){
                        column = k;
                    }
                    k++;
                }

                while(rows.hasNext()){
                    Row row = rows.next();
                   if(row.getCell(0).getStringCellValue().equalsIgnoreCase(testCaseName)){
                       Iterator<Cell> cellValue = row.iterator();

                       while(cellValue.hasNext()){
                           Cell value = cellValue.next();

                           if(value.getCellType() == CellType.STRING){
                               dataArray.add(value.getStringCellValue());
                           }else{

                               dataArray.add(NumberToTextConverter.toText(value.getNumericCellValue()));
                           }

                       }
                   }

                }
            }
        }
        return dataArray;
    }
}
