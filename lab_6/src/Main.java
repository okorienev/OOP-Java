import List.MyList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        MyList<Integer> list = new MyList<Integer>();
        list.addAll(Arrays.asList(3,5,7));
//        System.out.println(list.get(0));
//        System.out.println(list.get(1));
//        System.out.println(list.get(2));
//        System.out.println(list.size());
//        ListIterator iterator = list.listIterator();
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(list.get(2));
//        System.out.println(iterator.nextIndex());
//        System.out.println(iterator.hasNext());
//        System.out.println(iterator.hasPrevious());
//        System.out.println(iterator.previous());
//        for (Integer integer : list) {
//            System.out.println(integer);
//        }
        list.addAll(1, Arrays.asList(4,8,9));
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
