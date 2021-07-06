package company.ac.za.studentbookstore.util;

public class MyAppLog {
    public static String sMessage(String action){
        return CurrentData.getCurrentTime()+": "+action+ " successful";
    }
    public static String fMessage(String action){
        return CurrentData.getCurrentTime()+": "+action+ " Failled";
    }
}
