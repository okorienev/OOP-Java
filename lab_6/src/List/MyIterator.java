package List;

import java.util.ListIterator;
import java.util.NoSuchElementException;

class MyIterator<E> implements ListIterator<E> {
    private Node<E> current = null;
    private int currentIndex = 0;

    public MyIterator(Node<E> node){
        current = node;
    }

    @Override
    public boolean hasNext() {
        return current.getNext() != null;
    }

    @Override
    public E next() {
        if (hasNext()){
            current = current.getNext();
            currentIndex++;
            return current.getData();
        }else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public boolean hasPrevious() {
        return current.getPrev() != null;
    }

    @Override
    public E previous() {
        if (hasPrevious()){
            current = current.getPrev();
            currentIndex--;
            return current.getData();
        }else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public int nextIndex() {
            return currentIndex + 1;
    }

    @Override
    public int previousIndex() {
        return currentIndex - 1;
    }

    @Override
    public void remove() {
        current.getPrev().setNext(current.getNext());
        current.getNext().setPrev(current.getPrev());

    }

    @Override
    public void set(E o) {
            current.setData((E)o);
    }

    @Override
    public void add(E o) {
            Node<E> tmpNode = new Node<>((E)o);
            tmpNode.setPrev(current.getPrev());
            tmpNode.setNext(current.getNext());
    }
}
