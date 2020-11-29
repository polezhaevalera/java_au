import java.util.Iterator;


class Array3DIterator<T> implements Iterator<T>{
    int len, position, lvl1, lvl2, lvl3;
    T[][][] array;

    Array3DIterator(T[][][] array) {
        this.array = array;

        // Init Len
        for (T[][] lvl1 : array) {
            for (T[] lvl2 : lvl1) {
                len += lvl2.length;
            }
        }
    }

    @Override
    public boolean hasNext() {
        return position < len;
    }

    @Override
    public T next() {
        T element = array[lvl1][lvl2][lvl3];

        position++;
        lvl3++;

        while (lvl2 < array[lvl1].length && lvl3 >= array[lvl1][lvl2].length) {
            lvl3 = 0;
            lvl2++;
        }
        
        while (lvl1 < array.length && lvl2 >= array[lvl1].length) {
            lvl2 = 0;
            lvl1++;
        }

        return element;
    }
}


class Array3D<T> implements Iterable<T> {
    T[][][] array;

    Array3D(T[][][] array) {
        this.array = array;
    }

    @Override
    public Iterator<T> iterator() {
        return new Array3DIterator<>(array);
    }
}
