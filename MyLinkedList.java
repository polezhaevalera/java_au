import java.util.Iterator;


class MyIterator<E> implements Iterator<E> {
    int index;
    MyLinkedList<E> list;

    MyIterator(MyLinkedList<E> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return list.len >= index + 1;
    }

    @Override
    public E next() {
        return list.get(index++);
    }
}


class Node<T> {
    T val;
    Node<T> next, prev;

    Node(T val) {
        this.val = val;
    }
}


class MyLinkedList<T> implements Iterable<T> {
    int len;
    Node<T> start, end;

    @Override
    public Iterator<T> iterator() {
        return new MyIterator<>(this);
    }

    T get(int index) {
        Node<T> head = start;

        if (index >= len || index < 0) {
            return null;
        }

        for (int i = 0; i < index; i++) {
            head = head.next;
        }

        return head.val;
    }

    void addAtHead(T val) {
        Node<T> add = new Node<>(val);

        if (start == null) {
            start = add;
            end = add;
            len++;
            return;
        }

        add.next = start;
        start.prev = add;
        start = add;
        len++;
    }

    void addAtTail(T val) {
        Node<T> add = new Node<>(val);

        if (start == null) {
            start = add;
            end = add;
            len++;
            return;
        }

        add.prev = end;
        end.next = add;
        end = add;
        len++;
    }

    void addAtIndex(int index, T val) {
        if (index == 0) {
            addAtHead(val);
            return;
        }

        if (index == len) {
            addAtTail(val);
            return;
        }

        if (index > len || index < 0) {
            return;
        }

        Node<T> add = new Node<>(val);
        Node<T> head = start;

        for (int i = 0; i < index; i++) {
            head = head.next;
        };

        add.prev = head.prev;
        add.next = head;
        head.prev.next = add;
        head.prev = add;
        len++;
    }

    void deleteAtIndex(int index) {
        if (index == 0) {
            if (len == 1) {
                start = null;
                end = null;
            } else {
                start.next.prev = null;
                start = start.next;
            }
            len--;
            return;
        }

        if (index == len - 1) {
            end.prev.next = null;
            end = end.prev;
            len--;
            return;
        }

        if (index >= len || index < 0) {
            return;
        }

        Node<T> head = start;

        for (int i = 0; i < index; i++) {
            head = head.next;
        }

        head.prev.next = head.next;
        head.next.prev = head.prev;
        len--;
    }
}
