import java.util.List;

public interface IHeap<T extends Comparable<T>>
{
    public void insert(T item);
    public void insertAll(List<T> items);
    public int size();
    public T removeTop();
    public void clear();
}

public interface HeapSort
{
  public void sort(int arr[]);
  void heapify(int arr[], int n, int i);
  static void printArray(int arr[]);

}
