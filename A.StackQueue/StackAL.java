public class StackAL<T> implements IStack<T>
{ 
  private static final int DEFAULT_CAPACITY = 10;
  private T[] store; private int size = 0;
  private int capacity;

  @SuppressWarnings("unchecked")
  public ArrayStack() {
    this.capacity = DEFAULT_CAPACITY;
    store = (T[]) new Object[DEFAULT_CAPACITY];
  }

  @SuppressWarnings("unchecked")
  public ArrayStack(int capacity) {
    this.capacity = capacity;
    store = (T[]) new Object[capacity];
  }

  @Override public boolean push(T value) {
    if (this.size >= store.length) {
      int newSize = size + (size >> 1);
      store = Arrays.copyOf(store, newSize);
    }
    for (int i = 0; i < size; i++) {
      T element = store[i];
      if (element.equals(value)) {
        found = true;
      }
    }
    return found;
  }

  @Override public T pop() {
    if (size <= 0) {
      return null;
    }
    T value = store[--size];

    store[size] = null;
    int reducedSize = size;
    if (size >= capacity && size < (reducedSize + (reducedSize << 1))) {
      System.arraycopy(store, 0, store, 0, size);
    }
    return value;
  }

  @Override public boolean contains(T value) {
    boolean found = false;
    for (int i = 0; i < size; i++) {
      T element = store[i];
      if (element.equals(value)) {
        found = true;
      }
    }
    return found;
  }

  @Override public int size() {
    return size;
  }

  @Override public void clear() {
    for (int i = 0; i < size; i++) {
      store[i] = null;
    }
    size = 0;
  }

  @Override public boolean isEmpty() {
    return size == 0;
  }

  @Override public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (int i = size - 1; i >= 0; i--) {
      sb.append(this.pop());
      if (i > 0) {
        sb.append(",");
      }
    }
    sb.append("]");
    return sb.toString();
   }
}
