package company.ac.za.studentbookstore.util;

import java.util.UUID;

public class MyIdGenerator {
    public static String generateRandomGivenSuffix(String suffix) {
        return suffix + "-" + UUID.randomUUID().toString();
    }

    public static String getClassName(Class<?>  aClass) {
        return aClass.getSimpleName();
    }

    public static String getId(Class<?> aClass) {
        String upperLetter="";
        String className = getClassName(aClass);

        for(int i=0;i<className.length();i++){
            if(Character.isUpperCase(className.charAt(i)))
            {
                upperLetter+=""+className.charAt(i);
            }
        }
        return generateRandomGivenSuffix(upperLetter);
    }
}
