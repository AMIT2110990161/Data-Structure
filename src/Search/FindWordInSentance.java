package Search;

public class FindWordInSentance {
    public static void main(String[] args) {
//        String[] sentences = {
//                "The quick brown fox jumps over the lazy dog",
//                "Linear search is simple but inefficient",
//                "Searching algorithms help find data quickly"
//        };
//        String word = "search";
        String[] sentences = {
                "The sun rises in the east",
                "Data structures are important for coding",
                "Practice makes a person perfect"
        };
        String word = "search";

        boolean check = true;

        for(String str:sentences){
            String[] arr = str.split(" ");
            for(String s:arr){
                if(word.equals(s)){
                    System.out.println(str);
                    check = false;
                    break;
                }
            }
        }
        if(check) System.out.println("Not Found");
    }
}
