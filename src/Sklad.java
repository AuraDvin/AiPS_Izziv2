import java.util.Scanner;

class Izziv2 {
    public static void main(String[] args) throws CollectionException{
        Stack<String> stack = new ArrayDeque<>();
        Deque<String> deque = new ArrayDeque<>();
        Sequence<String> sequence = new ArrayDeque<>();

        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        for (String s : line) {
            // Show it working
        }
    }
}


/** @noinspection ALL*/
class ArrayDeque<T> implements Deque<T>, Stack<T>, Sequence<T> {
    private static final int DEFAULT_CAPACITY = 64;
    @SuppressWarnings({"FieldMayBeFinal", "UncheckedCast"})
    private T[] polje = (T[]) (new Object[DEFAULT_CAPACITY]);
    private int front = -1;
    private int back = -1;
    @SuppressWarnings("NeverUsed")
    public final static String[] keyWords = new String[]{
            "echo",
            "print",
            "clear",
            "pop",
            "dup",
            "dup2",
            "swap",
            "reverse",
            "<>",
            "<",
            ">",
            "<=",
            ">=",
            "==",
            "+",
            "-",
            "*",
            "/",
            "%",
            ".",
            "rnd",
            "then",
            "else",
            "?",
    };

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for(Object a : polje){
            if (a == null) continue;
            sb.append((String)a);
            sb.append(", ");
        }
//        for (int i = back; i != front; i++) {
//            if (i >= DEFAULT_CAPACITY) i -= DEFAULT_CAPACITY;
//            if (i < 0) i += DEFAULT_CAPACITY;
//            sb.append(polje[i]);
//            sb.append(", ");
//        }
        sb.delete(sb.length()-2, sb.length()-1);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean isEmpty() {
        return front == back;
    }

    @Override
    public boolean isFull() {
        return front >= DEFAULT_CAPACITY;
    }

    @Override
    public int size() {
        return front < 0 ? 0 : front - back + 1;
    }

    @Override
    public T top() throws CollectionException {
        if (isEmpty()) throw new CollectionException(Collection.ERR_MSG_EMPTY);
        return polje[front];
    }

    @Override
    public void push(T x) throws CollectionException {
        if (isFull()) throw new CollectionException(Collection.ERR_MSG_FULL);
        if (isEmpty()) back = 0;
        polje[++front] = x;
    }

    @Override
    public T pop() throws CollectionException {
        if (isEmpty()) throw new CollectionException(Collection.ERR_MSG_EMPTY);
        T x = top();
        front--;
        return x;
    }

    @Override
    public T front() throws CollectionException {
        if (isEmpty()) throw new CollectionException(Collection.ERR_MSG_EMPTY);
        return top();
    }

    @Override
    public T back() throws CollectionException {
        if (isEmpty()) throw new CollectionException(Collection.ERR_MSG_EMPTY);
        return  polje[back];
    }

    @Override
    public void enqueue(T x) throws CollectionException {
        if (isFull()) throw new CollectionException(Collection.ERR_MSG_FULL);
        if (isEmpty()) front = 0;
        if (--back < 0) back += DEFAULT_CAPACITY;
        polje[back] = x;
    }

    @Override
    public void enqueueFront(T x) throws CollectionException {
        if (isFull()) throw new CollectionException(Collection.ERR_MSG_FULL);
        push(x);
    }

    @Override
    public T dequeue() throws CollectionException {
        if (isEmpty()) throw new CollectionException(Collection.ERR_MSG_EMPTY);
        return pop();
    }

    @Override
    public T dequeueBack() throws CollectionException {
        if (isEmpty()) throw new CollectionException(Collection.ERR_MSG_EMPTY);
        T x = back();
        if (++back >= DEFAULT_CAPACITY) back -= DEFAULT_CAPACITY;
        return x;
    }

    @Override
    public T get(int i) throws CollectionException {
        if (isEmpty()) throw new CollectionException(Collection.ERR_MSG_EMPTY);
        if (i > front) throw new CollectionException("Invalid index");
        if (i < back) throw new CollectionException("Invalid index");
        return  polje[i];
    }


}

class CollectionException extends Exception {
    public CollectionException(String msg) {
        super(msg);
    }
}

/** @noinspection ALL*/
interface Collection {
    static final String ERR_MSG_EMPTY = "Collection is empty.";
    static final String ERR_MSG_FULL = "Collection is full.";

    boolean isEmpty();

    boolean isFull();

    int size();

    String toString();
}

/** @noinspection ALL*/
interface Stack<T> extends Collection {
    T top() throws CollectionException;

    void push(T x) throws CollectionException;

    T pop() throws CollectionException;
}

/** @noinspection ALL*/
interface Deque<T> extends Collection {
    T front() throws CollectionException;

    T back() throws CollectionException;

    void enqueue(T x) throws CollectionException;

    void enqueueFront(T x) throws CollectionException;

    T dequeue() throws CollectionException;

    T dequeueBack() throws CollectionException;
}
/** @noinspection ALL*/
interface Sequence<T> extends Collection {
    static final String ERR_MSG_INDEX = "Wrong index in sequence.";

    T get(int i) throws CollectionException;
}