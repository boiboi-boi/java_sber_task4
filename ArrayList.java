import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<T>{
    private final int SIZE = 10;
    private int pointer = 0;
    private Object[] array = new Object[SIZE];

    public void add (T elem) {
        if (pointer == array.length)
            resize(array.length*2);
        array[pointer] = elem;
        pointer++;
    }

    public void set (int index, T elem){
        if (pointer == array.length)
            resize(array.length*2);
        for (int i=pointer-1; i >= index; i--){
            array[i+1]=array[i];
        }
        array[index]=elem;
        pointer++;
    }

    public T get (int index){
        return (T) array[index];
    }

    public int getSize(){
        return pointer;
    }

    public void delete (int index){
        if (array.length > SIZE && pointer < array.length / 2 )
            resize(array.length/2);
        for (int i = index; i < pointer-1; i++) {
            array[i]=array[i+1];
        }
        array[pointer]=null;
        pointer--;
    }

    public void sort (){
        Arrays.sort(array, 0, pointer);
    }

    public boolean equals (ArrayList<T> list){
        if (this.pointer != list.pointer)
            return false;
        for (int i=0; i<pointer; i++){
            if (this.array[i] != list.array[i])
            return false;
        }
        return true;
    }

    public Object[] toArray (){
        Object[] newArray = new Object[pointer];
        System.arraycopy(array, 0, newArray, 0, pointer);
        return newArray;
    }

    public void viewArray (){
        for (int i=0; i<pointer;i++)
            System.out.print(array[i] + ", ");

    }

    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }

    public Iterator<T> iterator() {
        Iterator<T> iterator = new Iterator<T>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < pointer && array[currentIndex] != null;
            }

            @Override
            public T next() {
                return (T) array[currentIndex++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return iterator;
    }
}
