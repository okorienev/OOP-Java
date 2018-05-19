package list.test;

import list.MyList;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * list tests according to jdk list<E>documentation
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
        MyList<Integer> list = new MyList<>(); //IntelliJ says incompatible types but Java all is ok
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
        assertThrows(ClassCastException.class, ()->list.contains("i_am_string_uncastable_to_int"));
        //indexation testing
        list.add(0, Integer.MAX_VALUE);
        list.add(Integer.MAX_VALUE);
        assertTrue(list.indexOf(Integer.MAX_VALUE) == 0);
        assertTrue(list.lastIndexOf(Integer.MAX_VALUE) == list.size() - 1);
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
        assertThrows(IndexOutOfBoundsException.class, ()->list.add(list.size() + 1, 1));
        assertThrows(NullPointerException.class, ()->list.add(0, null));
        assertTrue(list.add(11));
       assertThrows(NullPointerException.class, ()->list.add(null));
        list.add(0, Integer.MIN_VALUE);
        assertTrue( list.get(0) == Integer.MIN_VALUE);
        list.add(list.size(), Integer.MAX_VALUE);
        assertTrue(list.get(list.size() - 1) == Integer.MAX_VALUE);
    }

    @Test
    void setTest(){
        MyList<Integer> list = getListCopy();
        assertThrows(IndexOutOfBoundsException.class, ()->list.set(list.size(), 0));
        assertThrows(IndexOutOfBoundsException.class, ()->list.set(-1, 0));
        list.set(0, Integer.MIN_VALUE);
        list.set(list.size() - 1, Integer.MAX_VALUE);
        list.set(list.size()-2, 0); // magic numbers
        assertTrue(list.get(0) == Integer.MIN_VALUE);
        assertTrue(list.get(list.size() - 1) ==Integer.MAX_VALUE);
        assertTrue(list.get(list.size() - 2) == 0); // magic numbers
    }

    @Test
    void removeTest(){
        MyList<Integer> list = getListCopy();
        int tmp = list.size();
        assertThrows(IndexOutOfBoundsException.class, ()->list.set(list.size(), 0));
        assertThrows(IndexOutOfBoundsException.class, ()->list.set(-1, 0));
        assertEquals(list.get(0), list.remove(0));
        assertEquals(list.size(), --tmp);
        assertEquals(list.get(list.size() - 1), list.remove(list.size() - 1));
        assertEquals(list.size(), --tmp);
//        list.add(Integer.MAX_VALUE);
//        list.add(list.size()/2, Integer.MAX_VALUE);  test fails cause Java thinks integer was given instead of object
//        list.remove((Number)Integer.MAX_VALUE);       and test expected method to behave with Integer like with Object
//        assertFalse(list.contains(Integer.MAX_VALUE));  and not with int
//        assertEquals(list.size(), tmp);
        list.add(0, Integer.MIN_VALUE);
        list.add(list.size()/2, Integer.MIN_VALUE);
        list.remove(list.indexOf(Integer.MIN_VALUE));
        list.remove(list.indexOf(Integer.MIN_VALUE));
        assertFalse(list.contains(Integer.MIN_VALUE));
        assertEquals(list.size(), tmp);
    }

    @Test
    void removeObjectTest(){
        String[] strings = {"str_1", "str_2", "str_3", "str_delete", "str_4"};
        MyList<String> list = new MyList<>(Arrays.asList(strings));
        for (String s : strings) {
            assertTrue(list.contains(s));
        }
        list.remove("str_delete");
        assertFalse(list.contains("str_delete"));
    }

    @Test
    void addAllTest(){
        MyList<Integer> list = getListCopy();
        assertThrows(NullPointerException.class, ()->{
            Integer[] integers = {null, null, null};
            list.addAll(Arrays.asList(integers));
        });

        assertThrows(NullPointerException.class, ()->{
            Integer[] integers = {null, null, null};
            list.addAll(0, Arrays.asList(integers));
        });

        assertThrows(IndexOutOfBoundsException.class, ()->{
            Integer[] integers = {1, 2, 3};
            list.addAll(-1, Arrays.asList(integers));
        });

        assertThrows(IndexOutOfBoundsException.class, ()->{
            Integer[] integers = {1, 2, 3};
            list.addAll(list.size() + 1, Arrays.asList(integers));
        });

        MyList<Integer> list2 = new MyList<Integer>(Arrays.asList(integersNoContains));
        list.addAll(list2);
        for (Integer integer : list2) {
            assertTrue(list.contains(integer));
        }
    }

    @Test
    void subListTest(){
        MyList<Integer> list = getListCopy();
        assertThrows(IndexOutOfBoundsException.class, ()->list.subList(-2, list.size()/2));
        assertThrows(IndexOutOfBoundsException.class, ()->list.subList(0, list.size() + 1));
        MyList<Integer> listSlice = list.subList(0, list.size());
        assertEquals(listSlice.size(), list.size());
        for (int i = 0; i < list.size(); i++) {
            assertEquals(list.get(i), listSlice.get(i));
        }
        assertEquals(list.subList(0, 1).get(0), list.get(0));
        assertEquals(list.subList(list.size()-1, list.size()).get(0), list.get(list.size()-1));
    }

    @Test
    void creationTest(){
        MyList<Integer> list = new MyList<>(13);
        assertEquals(1, list.size());
        assertFalse(list.isEmpty());
    }
    
    //some old tests, not structured but can be useful
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
        assertEquals(1, listIterator.nextIndex());
        listIterator.next();
        assertTrue(listIterator.hasPrevious());

    }
}