package testspace;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Tester{

    public static void main(String[] args){
        LinkedList<Integer> list = new LinkedList<Integer>(Arrays.asList(4,3,7,1,9,6,7,3,3,1));
        System.out.println("List before sorting " + list.toString());
        LinkedList<Integer> listSorted = selSort(list);
        System.out.println("list after sorting " + listSorted);
        System.out.println("Is 10 in the list " + binarySearch(listSorted,10));
    }

    public static LinkedList<Integer> selSort(LinkedList<Integer> listToSort) {
        if(listToSort.isEmpty()){
            return new LinkedList<Integer>();
        }
        else {
            int index = 0;
            for(int n = 1; n<listToSort.size(); n++){
                if (listToSort.get(n) < listToSort.get(index)){
                    index = n;
                }
            }
            int smallest = listToSort.remove(index);
            LinkedList<Integer> returner = selSort(listToSort);
            returner.add(0, smallest);
            return returner;
        }
    }

    public static boolean binarySearch(List<Integer> list, int val){
        int middle = list.size()/2;
        if(list.isEmpty()){
            return false;
        }
        else {
            if (val == list.get(middle)) {
                return true;
            }
            else if (val < list.get(middle)) {
                return binarySearch(list.subList(0, middle), val);
            }
            else if (val > list.get(middle)) {
                return binarySearch(list.subList(middle+1, list.size()), val);
            }
        }
        return false;
    }
}
