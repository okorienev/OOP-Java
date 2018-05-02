package List.test;

import List.MyList;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * list tests according to jdk List<E>documentation
 */
class MyListTest {
    private static Integer[] ints = {1,2,3,4,5,6,7,8,9,10} ;
    private static Integer[] integersNoContains = {11, 12, 13, 14, 15};
    private static MyList<Integer> listToOperate = new MyList<>(Arrays.asList(ints));

    private static MyList<Integer> getListCopy(){
        return new MyList<>(listToOperate);
    }


    @Test
    void isEmptyTest(){
        MyList<Integer> list = new MyList<>();
        assertTrue(list.isEmpty());
        list.add(15);
        assertFalse(list.isEmpty());
    }

    @Test
    void containsTest(){
        MyList<Integer> list = getListCopy();
        for (Integer anInt : ints) {
            assertTrue(list.contains(anInt));
        }
        for (Integer integersNoContain : integersNoContains) {
            assertFalse(list.contains(integersNoContain));
        }
        assertThrows(NullPointerException.class, ()->list.contains(null));
//        assertThrows(ClassCastException.class, ()->list.contains("i_am_string_uncastable_to_int"));
    }

    @Test
    void iterationTest(){
        MyList<Integer> list = getListCopy();
        Iterator iterator = list.listIterator();
        int index = 0;
        while (iterator.hasNext()){
            assertTrue(iterator.next() == ints[index++]);
        }
        iterator.remove();
        assertTrue(list.size() == ints.length - 1);
        assertThrows(IllegalStateException.class, ()->iterator.remove());
    }


    @Test
    void addTest(){
        MyList<Integer> list = getListCopy();
        assertThrows(IndexOutOfBoundsException.class, ()->list.add(-1, 1));
        assertThrows(IndexOutOfBoundsException.class, ()->list.add(list.size(), 1));
        assertThrows(NullPointerException.class, ()->list.add(0, null));
        assertTrue(list.add(11));
        assertThrows(NullPointerException.class, ()->list.add(null));
        list.add(0, Integer.MIN_VALUE);
        assertTrue( list.get(0) == Integer.MIN_VALUE);
        list.add(list.size() - 1, Integer.MAX_VALUE);
        assertTrue(list.get(list.size() - 1) == Integer.MAX_VALUE);

    }






    @Test
    void listCreationTest(){
        Integer[] tmp = new Integer[]{11, 12, 43, 27, 18, 6};
        MyList<Integer> list = new MyList<>(Arrays.asList(tmp));
        assertEquals(tmp.length, list.size());
        assertEquals((int)tmp[4] ,(int)list.get(4));
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    void listAddingTest(){
        Integer[] tmp = new Integer[]{11, 12, 43, 27, 18, 6};
        MyList<Integer> list = new MyList<>(Arrays.asList(tmp));
        assertThrows(NullPointerException.class, ()->list.add(null));
        list.add(123);
        assertEquals(123 ,(int)list.get(6));
        assertEquals(tmp.length + 1, list.size());
        list.addAll(Arrays.asList(tmp));
        assertEquals(2 * tmp.length + 1, list.size());
        assertEquals(tmp[tmp.length - 1], list.get(list.size() - 1));
    }

    @Test
    void iteratorTest(){
        Integer[] tmp = new Integer[]{11, 12, 43, 27, 18, 6};
        MyList<Integer> list = new MyList<>(Arrays.asList(tmp));
        ListIterator listIterator = list.listIterator();
        assertFalse(listIterator.hasPrevious());
        assertTrue(listIterator.hasNext());
        listIterator.next();
        assertEquals(0, listIterator.previousIndex());
        assertEquals(2, listIterator.nextIndex());
        listIterator.next();
        assertTrue(listIterator.hasPrevious());

    }
}