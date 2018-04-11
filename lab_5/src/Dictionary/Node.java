package Dictionary;

/**
 * @deprecated
 * @see ArrayDictionary
 */
class Node<T> {
    private int key;
    private T value;
    private Node<T> next;
    private Node<T> prev;
    Node(T data, Object key){
        this.key = key.hashCode();
        value = data;
    }

    void setNext(Node<T> next) {
        this.next = next;
    }

    void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    Node<T> getPrev() {
        return prev;
    }

    Node<T> getNext() {
        return next;
    }

    boolean compare(Object key){
        return key.hashCode() == this.key;
    }

    T getValue() {
        return value;
    }

    void setValue(T value) {
        this.value = value;
    }
}