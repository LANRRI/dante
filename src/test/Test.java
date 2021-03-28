package test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String args[]){

            String format = "yyyyMMdd";
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            String  date1 = sdf.format(new Date(System.currentTimeMillis()));
            String  date2 = sdf.format(new Date(System.currentTimeMillis()+1000));
            System.out.println(System.currentTimeMillis()/ (24*60*60*1000L) == (System.currentTimeMillis()+10000)/ (24*60*60*1000L));

    }
}
