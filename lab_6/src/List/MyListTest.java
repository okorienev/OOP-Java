package List;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.ListIterator;

import static org.junit.jupiter.api.Assertions.*;

class MyListTest {
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