package String;
import java.util.*;

public class StringArrayToStringBuffer {
    public static void main(String[] args) {
        String[] stringArray = {"Amit", "is", "a", "boy"};
        int len = stringArray.length, idx = 0;
        StringBuffer sb = new StringBuffer();
        for(String str:stringArray){
            sb.append(str);
            if(idx < len)sb.append(" ");
            idx++;
        }
        System.out.println(sb);
    }
}
