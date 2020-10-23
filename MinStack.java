public class MinStack<T extends Comparable<T>> implements IStack<T>
{
  private Node m_head;
  private int m_count;
  private Node m_min;

  public StackLL()
	{
    m_head = new Node(null);
  }

  public StackM()
  {
    m_min = new Node(null);
  }

  @Override
  public void push(T item)
  {
  		// runs in constant time...

  	Node n = new Node(item);
  	n.m_next = m_head.m_next;
  	m_head.m_next = n;
  	m_count++;
  }

  @Override
  public T pop()
  {
  		// runs in constant time...

  	if (isEmpty())
  		throw new IllegalStateException("pop error: stack is empty!");

  	m_count--;
  	T ret = m_head.m_next.m_data;
		m_head.m_next = m_head.m_next.m_next;

  	return ret;
  }

  @Override
  public T top()
  {
  		// runs in constant time...

  	if (isEmpty())
  		throw new IllegalStateException("top error: stack is empty!");
  	return  m_head.m_next.m_data;
  }

  @Override
  public T min()
  {

    if (isEmpy())
      throw new IllegalStateException("min error: stack is empty!");

      T ret1 = m_head.m_data;
      T ret2 = m_head.m_next.m_data;

      for (i = 0; i < m_count; i++)
      {
        String myStr1 = ret1;
        String myStr2 = ret2;
        if (myStr1.compareTo(myStr2) > 0)
        {
          m_min.m_data = myStr2.m_data;
        }
        ret1 = m_head.m_next.m_data;
        ret2 = m_head.m_next.m_next.m_data;
      }
    return m_min.m_data;
  }

  @Override
  public boolean isEmpty()
  {
  		// runs in constant time...

  	return getSize() == 0;
  }

  @Override
  public int getSize()
  {
  		// runs in constant time...

  	return m_count;
  }

  @Override
  public String toString()
  {
  		// runs in linear time...

  	StringBuffer sb = new StringBuffer("top->");
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


  	/**
  	 * <p>Internal class used to represent a link in a linked list
  	 * structure.  Each node in the list contains the element
  	 * that was added to the stack, as well as a reference to the
  	 * next item in the stack.</p>
  	 */
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
