import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        int N = sc.nextInt();

        for(int j =1; j < 10; j++){
            System.out.println(N +" * "+j + " = " + (N*j) );
        }
        sc.close();
    }
}