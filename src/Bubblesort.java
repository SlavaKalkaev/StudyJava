import java.util.ArrayList;

public class Bubblesort {
         private ArrayList<Integer> sortedList;
     private void swap(int firstIndex, int secondIndex) {
         int z = sortedList.get(firstIndex);
         sortedList.set(firstIndex, sortedList.get(secondIndex));
         sortedList.set(secondIndex, z);
     }

     public ArrayList<Integer>  sort_bubble(ArrayList<Integer> list) {
        sortedList= list;
         for (int i = 0; i < list.size() - 1; i++) {
             for (int j = i + 1; j < list.size(); j++) {
                 if (list.get(i) > list.get(j)) {
                     swap(i, j);
                 }
             }
         }
         return list;
     }
 }
