package list;

import java.util.ListIterator;
import java.util.NoSuchElementException;

class MyIterator<E> implements ListIterator<E> {
    private Node<E> current;
    private int currentIndex = 0;

    public MyIterator(Node<E> node, int index){
        current = new Node<>(node.getData());
        current.setNext(node);
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
            return currentIndex;
    }

    @Override
    public int previousIndex() {
        return currentIndex - 1;
    }


    @Override
    public void remove() {
        if (current.getPrev()!= null) {
            if (current.getPrev().getNext() == current.getNext()){
                throw new IllegalStateException();
            }
            current.getPrev().setNext(current.getNext());
        }
        if (current.getNext() != null){
             if(current.getNext().getPrev() == current.getPrev()){
                 throw  new IllegalStateException();
             }
            current.getNext().setPrev(current.getPrev());
        }
    }

    @Override
    public void set(E o) {
            current.setData((E)o);
    }

    @Override
    public void add(E o) {
            Node<E> tmpNode = new Node<>(o);
            tmpNode.setPrev(current.getPrev());
            tmpNode.setNext(current);
            current.getPrev().setNext(tmpNode);
            current.setPrev(tmpNode);
    }
}
