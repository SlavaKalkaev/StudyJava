import java.util.Scanner;
public class fromOneToTen {
    public static void main(String[] args) {
        Scanner N = new Scanner (System.in);
        int num = N.nextInt();
        int sum =0;
        while (num > 0){
            sum+=num--;
        }
        System.out.println(sum);
        }
    }

