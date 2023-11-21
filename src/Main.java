import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(
                Arrays.asList(54,33,32,45,67,89,9)
        );
        Bubblesort hui = new Bubblesort();
        System.out.println(
                hui.sort_bubble(list)
        );

        }
    }
