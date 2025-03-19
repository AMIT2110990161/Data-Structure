package Search;

public class FindNegative {
    public static void main(String[] args) {
        int[] arr = {-2,5,6,-5,1,6};
        int idx = 0;
        boolean check = true;
        for(int a:arr){
            if(a<0) {
                System.out.println("First Negative Number is on " + idx + " and the number is " + arr[idx]);
                check = false;
                break;
            }
            idx++;
        }
        if(check) System.out.println(-1);
    }
}
