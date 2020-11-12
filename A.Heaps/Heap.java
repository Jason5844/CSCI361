import java.util.*;

public class Heap implements IHeap
{
  private int[] data;
  private int heapSize;

   public Heap(int size)
   {
     data = new int[size];
     heapSize = 0;
   }

   @Override
   public void insert(int item)
   {
     if (heapSize == data.length)
        throw new HeapException("Heap's underlying storage is overflow");
      else
      {
        heapSize++;
        data[heapSize - 1] = item;
        moveUp(heapSize - 1);
      }
    }

   private void moveUp(int nodeIndex)
   {
    int parentIndex, tmp;

    if (nodeIndex != 0)
      {
        parentIndex = getParentIndex(nodeIndex);

        if (data[parentIndex] > data[nodeIndex])
        {
          tmp = data[parentIndex];
          data[parentIndex] = data[nodeIndex];
          data[nodeIndex] = tmp;
          moveUp(parentIndex);

        }

      }
   }

  @Override
  public void insertAll(List items)
   {
     int listNum = 0;
     while (heapSize > listNum)
     {
       insert(items[listNum]);
       listNum++;
       listNum++;
     }
   }


   @Override
   public int size()
   {
     return heapSize;
   }

   @Override
	public void clear()
	{
    while (heapSize != 0)
    {
      removeTop();
    }
	}

   @Override
   public int removeTop()
   {
     if (isEmpty())
      throw new HeapException("Heap is empty");
    else
    {
      data[0] = data[heapSize - 1];
      heapSize--;
      if (heapSize > 0)
        moveUp(0);
    }
   }

   private void moveDown(int nodeIndex)
   {
     int leftChildIndex, rightChildIndex, minIndex, tmp;
     leftChildIndex = getLeft(nodeIndex);
     rightChildIndex = getRight(nodeIndex);
     if (rightChildIndex >= heapSize)
      {
        if (leftChildIndex >= heapSize)
            return;
        else
            minIndex = leftChildIndex;
      }
      else
      {
        if (data[leftChildIndex] <= data[rightChildIndex])
          minIndex = leftChildIndex;
        else
          minIndex = rightChildIndex;
      }
        if (data[nodeIndex] > data[minIndex])
        {
          tmp = data[minIndex];
          data[minIndex] = data[nodeIndex];
          data[nodeIndex] = tmp;
          moveDown(minIndex);
        }
    }

   @Override
   public String toString()
   {
   }

   private int getParent(int nodeIndex)
   {
     return (nodeIndex - 1) / 2;
   }

   private int getLeft(int nodeIndex, int ary[])
   {
     return 2 * nodeIndex + 1;
   }

   private int getRight(int nodeIndex, int ary[])
   {
     return 2 * nodeIndex + 2;
   }

}
