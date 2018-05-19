import List.MyList;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Integer[] ints = {1,2,3,4,5,6,7,8,9,10} ;
        Integer[] integersNoContains = {11, 12, 13, 14, 15};
        MyList<Integer> listToOperate = new MyList<>(Arrays.asList(ints));
        listToOperate.addAll(4, Arrays.asList(integersNoContains));
        System.out.println();
    }
}
