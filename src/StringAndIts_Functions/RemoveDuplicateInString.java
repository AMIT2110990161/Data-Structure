package StringAndIts_Functions;
import java.util.*;

public class RemoveDuplicateInString {
    public static void main(String[] args) {
        String str = "ananassmjacsb";
        StringBuilder sb = new StringBuilder();
        HashSet<Character> hs = new HashSet<>();

        for(char ch:str.toCharArray()){
            if(!hs.contains(ch)){
                sb.append(ch);
                hs.add(ch);
            }
        }
        System.out.println(sb);
    }
}
