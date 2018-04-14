package Dictionary;

import java.util.Arrays;

public class ArrayDictionary<T> {
    class DictPair<T>{
        private int key;
        private T data;

        DictPair(T data, Object key) {
            this.data = data;
            this.key = key.hashCode();
        }

        public boolean compare(Object key){
            return key.hashCode() == this.key;
        }

        public T getData() {
            return data;
        }
        @Override
        public String toString() {
            return "DictPair{" +
                    "data=" + data +
                    '}';
        }
    }

    private DictPair[] dictPairs;

    public ArrayDictionary(DictPair[] dictPairs) {
        this.dictPairs = dictPairs;
    }

    public ArrayDictionary(Object key, T data){
        this.dictPairs = new DictPair[]{new DictPair(data, key)};
    }

    public ArrayDictionary(){}

    public void append(Object key, T data){
        DictPair<T> tmp = new DictPair(key, data);
        if (dictPairs == null){
            dictPairs = new DictPair[]{tmp};
        }else{
            DictPair[] dictPairsCopy = new DictPair[dictPairs.length + 1];
            System.arraycopy(dictPairs, 0, dictPairsCopy, 0, dictPairs.length);
            dictPairsCopy[dictPairsCopy.length - 1] = tmp;
            dictPairs = dictPairsCopy;
        }
    }

    public T get(Object key){
        for (DictPair element: dictPairs) {
            if(element.compare(key)){
                return (T)element.data;
            }
        }
        return null;
    }
    @Override
    public String toString() {
        return "ArrayDictionary{" +
                "dictPairs=" + Arrays.toString(dictPairs) +
                '}';
    }

    public ArrayDictionary<T> copy(){
        return new ArrayDictionary<>(dictPairs);
    }

    public void clear(){
        dictPairs = null;
    }
}
