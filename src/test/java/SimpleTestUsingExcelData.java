import java.io.IOException;
import java.util.ArrayList;

public class SimpleTestUsingExcelData {
    public static void main(String[] args) throws IOException {
        DataDriverFromExcel dataDriverFromExcel = new DataDriverFromExcel();
        ArrayList<String> data =  dataDriverFromExcel.getData("Add Profile");
        System.out.println(data.get(0));
        System.out.println(data.get(1));
        System.out.println(data.get(2));
        System.out.println(data.get(3));
    }
}
