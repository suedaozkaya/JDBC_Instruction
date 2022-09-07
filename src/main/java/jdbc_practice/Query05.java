package jdbc_practice;

import java.sql.*;

public class Query05 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed",
                "postgres",
                "15080373");

        Statement st = con.createStatement();

        //SORU: Öğrenciler tablosuna yen bir kayıt ekleyin (300, 'Sena Can', 12, 'K')

        int s1 = st.executeUpdate("INSERT INTO ogrenciler VALUES(300, 'Sena Can', 12, 'K')");
        System.out.println(s1 + " satir database'e eklendi");

        //SORU: Öğrenciler tablosuna birden fazla veri ekleyin
        // (400, 'Sena Can', 12, 'K'), (401, 'Sena Can', 12, 'K'), (402, 'Sena Can', 12, 'K')

        //1. YOL
        String [] veri = {"insert into ogrenciler values (400, 'Sena Can', 12, 'K')",
                "insert into ogrenciler values (401, 'Sena Can', 12, 'K')",
                "insert into ogrenciler values (402, 'Sena Can', 12, 'K')"};

        int count=0;
        for(String each:veri){
            count = count + st.executeUpdate(each);
        }
        System.out.println(count + " satır eklendi");

        //2. YOL
        String [] veri2 = {"insert into ogrenciler values (400, 'Sena Can', 12, 'K')",
                "insert into ogrenciler values (401, 'Sena Can', 12, 'K')",
                "insert into ogrenciler values (402, 'Sena Can', 12, 'K')"};
        for (String each:veri2) {
            st.addBatch(each); // yukaridaki datalarin hepsini birleştiriyor
        }
        st.executeBatch(); // datalari tek seferde gonderiyor

        System.out.println("Datalar eklendi");
        
    }
}
