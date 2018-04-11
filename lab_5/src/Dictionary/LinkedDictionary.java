package Dictionary;
/**
 * @deprecated
 * @see Dictionary.ArrayDictionary
 */
public class LinkedDictionary<T> {
    private Node<T> head;
    private Node<T> tail;
    private int length;
    private Node<T> current = null;

    public int getLength() {
        return length;
    }

    public LinkedDictionary(){
        length = 0;
    }

    private Node<T> next(){
        if (current == null) {
            current = head;
            return current;
        }else {
            current = current.getNext();
            return current;
        }
    }

    public void append(T data, Object key){
        if (head == null){
            head = new Node<>(data, key);
            tail = new Node<>(data, key);
            head.setNext(tail);
            tail.setPrev(head);
            length++;
        }else{
            Node<T>temp = new Node<>(data, key);
            temp.setPrev(tail);
            tail.setNext(temp);
            tail = temp;
            length++;
        }
    }

    public T get(T key) {
        for (int i = 0; i < this.length; i++) {
            current = this.next();
            if (current.compare(key)) {
                return current.getValue();
            }
        }
        return null;
    }
//    @Override
//    public String toString(){
//        StringBuilder result = new StringBuilder();
//        for (int i = 0; i < this.length; i++) {
//            current = this.next();
//            result.append(current.getValue().toString()).append("\n");
//        }
//        return result.toString();
//    }
}
