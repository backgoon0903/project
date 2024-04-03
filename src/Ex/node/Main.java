package Ex.node;
class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
}


class GenericLinkedList<T> {
    private Node<T> head = null;

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public int size() {
        Node<T> currunt = head;
        int count = 0;
        while (currunt.next != null) {
            count++;
            currunt = currunt.next;
        }
        return count;
    }

    public boolean contains(T data) {
        while (head.next != null) {
            if (head.data.equals(data)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public void clear() {
        head = null;
    }


    public T get(int index) {
        Node<T> current = head;
        int i = 0;
        while (current != null) {
            if (i == index) {
                return current.data;
            }
            current = current.next;
            i++;
        }
        throw new IndexOutOfBoundsException("Index: " + index);
    }

    public void insert(int index, T data) {

        if (index == 0) {
            Node <T> newNode = new Node<>(data);
            newNode.next = head;
            head = newNode;
            return;
        }

        Node<T> current = head;
        int curruntIndex = 0;
        while (current != null && curruntIndex < index -1){
            current = current.next;
            curruntIndex++;
        }
        if (current != null) {
            Node<T> newNode = new Node<>(data);
            newNode.next = current.next;
            current.next = newNode;
        }else  {
            throw new IndexOutOfBoundsException("Index: " + index);
        }

    }
/*    종합아면 index가 0인경우, index가 중앙에 있는 경우, index가 가장 마지막 linked list의 element가 되는경우, index가 linked lis
t 범위에서 벗어난 경우 4가지를 모두 담아줘야 하지만 2가지밖에 고려하지 않았다.
 또한 언제 만들고 어디서 어떻게 이어줘야 하는지에 대한 선언이 틀렸다.*/





    public boolean remove(T data) {
        if (head == null) return false;

        if (head.data.equals(data)) {
            head = head.next;
            return true;
        }

        Node<T> current = head;
        while (current.next != null) {
            if (current.data.equals(data)) {
                current.next = current.next.next;
            }
            return true;
        }
        return false;
    }





    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}

interface Iterator<T> {
    boolean hasNext();
    T next();
}

public class Main {
    public static void main(String[] args) {
        GenericLinkedList<String> stringList = new GenericLinkedList<>();
        stringList.add("Java");
        stringList.add("Python");
        stringList.add("C++");

        Iterator<String> iterator = stringList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        GenericLinkedList<Integer> intList = new GenericLinkedList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        System.out.println(intList.size());


        boolean iscotained = intList.contains(1);
        if (iscotained) {
            System.out.println("removed");
        } else {
            System.out.println("fail");
        }

        boolean isRemoved = intList.remove(2);
        if (isRemoved) {
            System.out.println("removed");
        } else {
            System.out.println("fail");
        }




        Iterator<Integer> intIterator = intList.iterator();
        while (intIterator.hasNext()) {
            System.out.println(intIterator.next());
            System.out.println(intList.get(2));
        }
    }
}