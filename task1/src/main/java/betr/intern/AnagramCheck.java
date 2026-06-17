package betr.intern;

import java.util.Arrays;

public class AnagramCheck {

    public static boolean isAnagram(String string1, String string2){
            if(string2==null||string1==null){
                return false;
            }

            String string1new = string1.toLowerCase().replaceAll("\\s","");
            String string2new = string2.toLowerCase().replaceAll("\\s","");

            if(string1new.length() != string2new.length()){
                return false;
            }

            char[] array1 = string1new.toCharArray();
            char[] array2 = string2new.toCharArray();

            Arrays.sort(array1);
            Arrays.sort(array2);

            return Arrays.equals(array1,array2);
    }

}
