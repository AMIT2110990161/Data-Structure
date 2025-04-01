package SortingAlgorithem;

public class BubbleSort {
    public static void main(String[] args) {
        int[] studentMarks = {5,4,3,2,1};
        sort(studentMarks);
        printMarks(studentMarks);
    }

    public static void sort(int[] arr){
        int cnt = 0;
        for(int i=0; i<arr.length; i++){
            boolean check = false;
            for(int j=1; j<arr.length-i; j++){
                if(arr[j-1] > arr[j]){
//                    int temp = arr[j];
//                    arr[j] = arr[j-1];
//                    arr[j-1] = temp;
                    swap(arr, j-1, j);
                    check = true;
                    cnt++;
                }
            }
            cnt++;
            if(!check)break;
        }
        System.out.println(cnt);
    }
    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void printMarks(int[] arr){
        for(int a:arr){
            System.out.print(a + " ");
        }
    }
}
