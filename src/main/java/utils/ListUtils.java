package utils;

import java.util.List;

public class ListUtils {
    public void stringSeparator(List<String> stringListToSeparate) {
        StringBuilder strResult = new StringBuilder();

        for (int i = 0; i < stringListToSeparate.size(); i++) {
            strResult.append(",");
            strResult.append(stringListToSeparate.get(i));
        }

        strResult.deleteCharAt(0);
        System.out.println(strResult);
    }
}
