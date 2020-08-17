import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int toReturn = 0;
        int x = s.nextInt();
        int[] arr = new int[x];
        for (int i = 0; i < x; i ++) {
            arr[i] = s.nextInt();
        }
        if(arr[0]>arr[x-1]) {
            System.out.println("false");
        } else if (arr[0]==arr[x-1]){
            System.out.println("true");
        } else {
            System.out.println("true");
        }
    }
}
