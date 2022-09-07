package jdbc_practice;

import static jdbc_practice.DatabaseUtility.*;

public class Query06 {
    public static void main(String[] args) {
        createConnection();

        String query = "SELECT * FROM ogrenciler";
        System.out.println("Sutun isimleri: " + getColumnNames(query));

        System.out.println("Okul No: " + getColumnData(query,"okul_no"));
        System.out.println("Ogrenci ismi: " + getColumnData(query,"ogrenci_ismi"));
        System.out.println("Sinif: " + getColumnData(query,"sinif"));
        System.out.println("Cinsiyet: " + getColumnData(query,"cinsiyet"));
    }
}
