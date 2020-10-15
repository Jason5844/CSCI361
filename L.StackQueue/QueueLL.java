import java.util.*;

public class QueueLL<T extends Comparable<T>> implements IQueue<T>
{
   public static void main(String args[])
   {
      public void enqueue(3);
      public void enqueue(8);
      public void enqueue(1);
      
      public void reverse();
      
      public void sort();
   }

	private Node m_head;
	private int m_count;

	public QueueLL()
	{
		m_head = new Node(null);
		m_count = 0;
	}

	public void reverse()
	{
    if(isEmpty())
      throw new IllegalStateException("reverse error: queue is empty!");

     Stack<integer> stack = new Stack<integer>();
     int size = m_count;
     Node L = m_head;

     for(int i=0; i < size; i++)
     {
       stack.push(L.m_data);
       L = L.m_next;
     }

    int[] reverseArray = new int[size];

    for(int=0; i < size; i++)
    {
      reverseArray[i] = stack.pop();
    }

    while(m_count != 0)
    {
      public void dequeue();
    }

    for(int i=0; i < size; i++)
    {
      public void enqueue(reverseArray[i]);
    }
    
    System.out.println("Reversed Queue: " + Arrays.toString(reverseArray));

	}

	public void sort()
	{
    if(isEmpty())
      throw new IllegalStateException("sort error: queue is empty!");

      ArrayList<String> sortArray = new ArrayList<String>();
      int size = m_count;
      Node K = m_head;

      for(int i=0; i < size; i++)
      {
        sortArray.add(K.m_data);
        K = K.m_next;
      }

      Collections.sort(sortArray);

      while(m_count != 0)
      {
        public void dequeue();
      }

      for(int i=0; i < size; i++)
      {
        public void enqueue(sortArray[i]);
      }
      
      System.out.println("Sorted queue: " + Arrays.toString(sortArray));
	   
	}

	@Override
	public void enqueue(T item)
	{
		// runs in constant time ...

		// FIFO: this queue places new items at the head of the queue
		// and removes items from the tail of the queue...

		Node n = new Node(item);
		n.m_next = m_head.m_next;
		m_head.m_next = n;
		m_count++;
	}

	@Override
	public T dequeue()
	{
		// runs in O(n) time

		// FIFO: this queue places new items at the head of the queue
		// and removes items from the tail of the queue...

		if (isEmpty())
			throw new IllegalStateException("dequeue error: queue is empty!");

		T ret = null;
		Node cur = m_head;

		// while not at the tail...
		while (cur.m_next != null)
		{
			// if I am at the second from the tail of the queue...
			if (cur.m_next.m_next == null)
			{
				// grab the data from the last item in the queue...
				ret = cur.m_next.m_data;

				// detatch the last item in the queue...
				cur.m_next = null;

				break;
			}
			else
			{
				// otherwise, continue moving towards the tail of the queue...
				cur = cur.m_next;
			}
		}

		m_count--;
		return ret;
	}

	@Override
	public boolean isEmpty()
	{
		return getSize() == 0;
	}

	@Override
	public int getSize()
	{
		return m_count;
	}

	@Override
	public String toString()
	{
		// runs in linear time...

		StringBuffer sb = new StringBuffer("rear->");
		if (!isEmpty())
		{
			Node node = m_head.m_next;
			sb.append(node.m_data.toString());
			while (node.m_next != null)
			{
				node = node.m_next;
				sb.append("->");
				sb.append(node.m_data.toString());
			}
		}
		return sb.toString();
	}

	private class Node
	{
	 	private T m_data;
	 	private Node m_next;

		public Node(T data)
		{
			m_data = data;
			m_next = null;
		}
	}
}
