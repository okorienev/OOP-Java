package List;

import java.util.*;

public class MyList<E> implements List<E> {
    private int size = 0;
    private Node<E> head;
    private Node<E> tail;


    /**
     * Constructs list from single item
     * @param data instance of type parameter class
     */
    public MyList(E data) {
        Node<E> tmp = new Node<>(data);
        this.head = tmp;
        this.tail = tmp;
        size = 1;
    }

    /**
     * constructs list from collection
     * @param collection with type inherited from list type parameter
     */
    public MyList(Collection<? extends E> collection){
        this.addAll(collection);
    }

    /**
     * constructs empty list
     */
    public MyList() {

    }

//    Deprecated method. Problems with listIterator. If items were added/deleted by listIterator methods then the size
//    will be displayed incorrectly
//    @Override
//    public int size() {
//        return size;
//    }

    @Override
    public int size() {
        Iterator iterator = iterator();
        int size = 0;
        while (iterator.hasNext()){
            iterator.next();
            size++;
        }
        return size;
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public Iterator<E> iterator() {
        return listIterator();
    }


    @Override
    public Object[] toArray() {
        return new Object[size];
    }

    /**
     *
     * @param o instance of List type parameter
     * @return true if list was modified
     */
    @Override
    public boolean add(E o){
        if (o == null){
            throw new NullPointerException();
        }
        Node<E> tmp = new Node<>(o);
        if (head == null){
            head = tmp;
            tail = tmp;
            size = 1;
        }else {
            tail.setNext(tmp);
            tmp.setPrev(tail);
            tail = tmp;
            size ++;
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    /**
     * @param c iterable collection
     * @return true if list was changed
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E o: c) {
            add(o);
        }
        return true;
    }

    /**
     * Unsupported operation
     * @throws UnsupportedOperationException on any call
     */
    @Override
    public boolean addAll(int index, Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        if (index >= size){
            throw new IndexOutOfBoundsException();
        }else {
            Node<E> tmp = head;
            for (int i = 0; i < index; i++) {
                tmp = tmp.getNext();
            }
            return tmp.getData();
        }
    }

    @Override
    public E set(int index, E element) {
        if (index >= size){
            throw new IndexOutOfBoundsException();
        }else {
            Node<E> tmp = head;
            E tmpData;
            for (int i = 0; i < index; i++) {
                tmp = tmp.getNext();
            }
            tmpData = tmp.getData();
            tmp.setData(element);
            return tmpData;
        }
    }

    @Override
    public void add(int index, E element) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        } else {
            Node<E> tmp = head;
            Node<E> tmp2 = new Node<>(element);
            for (int i = 0; i < index; i++) {
                tmp = tmp.getNext();
            }
            tmp2.setNext(tmp);
            tmp2.setPrev(tmp.getPrev());
            tmp.setPrev(tmp2);
        }
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return new MyIterator<>(head);
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        } else {
            Node<E> tmp = head;
            for (int i = 0; i < index; i++) {
                tmp = tmp.getNext();
            }
            return new MyIterator<E>(tmp);
        }
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        for (Object o : c) {
            if (!this.contains(o)){
                return false;
            }
        }return true;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}

