package List;


import java.util.*;

public class MyList<E> implements List<E> {
//    private int size = 0;
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
//        size = 1;
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

    /**
     * works slow because of iterating list
     * @return list size
     */
    @Override
    public int size() {
        if (isEmpty()) {
            return 0;
        }
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
        return head == null;
    }

    /**
     * @return Does not throw ClassCastException
     */
    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public Iterator<E> iterator() {
        return listIterator();
    }

    /**
     *
     * @return array containing list items in correct order
     */
    @SuppressWarnings("unchecked")
    @Override
    public E[] toArray() {
        Object[] result = new Object[size()];
        int index = 0;
        for (E e : this) {
            result[index++] = e;
        }
        return (E[])result;
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
//            size = 1;
        }else {
            tail.setNext(tmp);
            tmp.setPrev(tail);
            tail = tmp;
//            size ++;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean remove(Object o) {
        boolean flag = false;
        if (indexOf(o)!= -1){
            remove(indexOf(o));
            flag = true;
        }
        return flag;
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


    @SuppressWarnings("unchecked")
    @Override
    public boolean addAll(int index, Collection c) {
        for (Object o: c){
            this.add(index++, (E)o);
        }
        return true;
    }

    /**
     * clears the list
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
//        size = 0;
    }

    @Override
    public E get(int index) {
        if (index >= size() || index < 0){
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
        if (index >= size() || index < 0){
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
        if (element == null) {
            throw new NullPointerException();
        }
        if (index > size() || index < 0) { // index bounds
            throw new IndexOutOfBoundsException();
        }
        if(index == size()) {  // right edge of a list
            this.add(element);
        }
        Node<E> NodeToAdd = head;
        Node<E> NodeNextToAdded = new Node<>(element);
        for (int i = 0; i < index; i++) { // get needed node
            NodeToAdd = NodeToAdd.getNext();
        }
        if (NodeToAdd.getPrev() != null) {
            NodeToAdd.getPrev().setNext(NodeNextToAdded);
            NodeNextToAdded.setPrev(NodeToAdd.getPrev());
        }else{ //left edge of a list
            head = NodeNextToAdded;
            NodeNextToAdded.setNext(NodeToAdd);
        }
        NodeNextToAdded.setNext(NodeToAdd);
        NodeToAdd.setPrev(NodeNextToAdded);
        }


    @Override
    public E remove(int index) {
        if (index >= size() || index < 0){
            throw new IndexOutOfBoundsException();
        }
        Node<E> tmp = head;
        E tmpData = null;
        for (int i = 0; i < index; i++) {
            tmp = tmp.getNext();
        }
        tmpData = tmp.getData();
        if(index == 0){
            head.getNext().setPrev(null);
            head = head.getNext();
            return tmpData;
        }
        if (index == size() - 1){
            tail.getPrev().setNext(null);
            tail = tail.getPrev();
            return tmpData;
        }
        tmp.getPrev().setNext(tmp.getNext());
        tmp.getNext().setPrev(tmp.getPrev());
        return tmpData;
    }

    @Override
    public int indexOf(Object o) {
        if (isEmpty()) {
            return -1;
        }
        if (!head.getData().getClass().isAssignableFrom(o.getClass())){
            throw new ClassCastException();
        }
        int index = 0;
        for (E e : this) {
            if (o.equals(e)){
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int lastIndex = -1;
        int index = 0;
        for (E e : this) {
            if (o.equals(e)){
                lastIndex = index;
            }
            index++;
        }
        return lastIndex;
    }

    @Override
    public ListIterator<E> listIterator() {
        return new MyIterator<>(head);
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        if (index >= size() || index < 0) {
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
        if (fromIndex >= toIndex || toIndex > size() || fromIndex < 0 || toIndex < 0){
            throw new IndexOutOfBoundsException();
        }
        MyList<E> result = new MyList<E>();
        for (int i = fromIndex; i < toIndex; i++) {
            result.add(get(i));
        }
        return result;
    }

    @Override
    public boolean retainAll(Collection c) {
        boolean flag = false;
        for (E e : this) {
            if (!c.contains(e)){
                this.remove(e);
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public boolean removeAll(Collection c) {
        boolean flag = false;
        for (Object o : c) {
            if(this.remove(o)){
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public boolean containsAll(Collection c) {
        for (Object o : c) {
            if (!this.contains(o)){
                return false;
            }
        }return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size())
            a = (T[])java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), size());
        int i = 0;
        Object[] result = a;
        for (Node<E> x = head; x != null; x = x.getNext())
            result[i++] = x.getData();

        if (a.length > size())
            a[size()] = null;

        return a;
        }
}


