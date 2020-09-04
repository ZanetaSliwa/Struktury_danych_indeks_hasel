package indekshasel;

/**
 *
 * @author Żaneta
 */

class Ogniwo<T> {

    private T value;
    private Ogniwo next;

    public T getValue() {
        return value;
    }

    public Ogniwo getNext() {
        return next;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setNext(Ogniwo next) {
        this.next = next;
    }

    public Ogniwo(T value, Ogniwo next) {
        this.value = value;
        this.next = next;
    }

}

/////////////////////////////////////////////////
class Lista<T> {

    private Ogniwo<T> head;
    private Ogniwo<T> tail;

    public boolean isEmpty() {
        return (head == null);
    }

    public Ogniwo<T> getHead() {
        return head;
    }

    public Ogniwo<T> getTail() {
        return tail;
    }

    public void setHead(Ogniwo<T> head) {
        this.head = head;
    }

    public void setTail(Ogniwo<T> tail) {
        this.tail = tail;
    }

    public T getFromHead() {
        if (isEmpty()) {
            return head.getValue();
        } else {
            return null;
        }
    }

    public void addToTail(T value) {

        if (isEmpty()) {
            head = new Ogniwo(value, null);
            tail = head;
        } else {
            tail.setNext(new Ogniwo(value, null));
            tail = tail.getNext();

        }
    }

    public void addToHead(T value) {
        if (isEmpty()) {
            head = new Ogniwo(value, null);
            tail = head;
        } else {
            head = new Ogniwo(value, head);
        }
    }

    @Override
    public String toString() {
        Ogniwo rob = head;
        String napis = "";
        while (rob != null) {
            napis = napis + "" + rob.getValue();
            rob = rob.getNext();
        }
        return napis;
    }

    public boolean isOnList(T value) {
        Ogniwo o = head;
        while (o != null) {
            if (o.getValue().equals(value)) {
                return true;
            }
            o = o.getNext();
        }
        return false;
    }

    public boolean deleteHead() {
        if (isEmpty()) {
            return false;
        } else if (head == tail) {
            head = null;
            tail = null;
            return true;

        } else {
            head = head.getNext();
            return true;
        }
    }

    public boolean removeTail() {
        if (isEmpty()) {
            return false;
        } else {
            if (head == tail) {
                head = null;
                tail = null;
                return true;
            } else {
                Ogniwo<T> pom = head;
                while (pom.getNext() != tail) {
                    pom = pom.getNext();
                }
                pom.setNext(null);
                tail = pom;
                return true;
            }
        }
    }

}

