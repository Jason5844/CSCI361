public class BinaryTree<T> implements Comparable<BinaryTree>
{
    private T m_value;
    private BinaryTree<T> m_left;
    private BinaryTree<T> m_right;

    public BinaryTree(T value)
    {
        m_value = value;
        m_left = null;
        m_right = null;
    }

    public BinaryTree(T value,
                      BinaryTree left,
                      BinaryTree right)
    {
        m_value = value;
        m_left = left;
        m_right = right;
    }

    public BinaryTree getLeft()
    {
        return m_left;
    }

    public BinaryTree getRight()
    {
        return m_right;
    }

    public T getValue()
    {
        return m_value;
    }

    public void setLeft(BinaryTree left)
    {
        m_left = left;
    }

    public void setRight(BinaryTree right)
    {
        m_right = right;
    }

    public void setVale(T value)
    {
        m_value = value;
    }

    @Override
    public T toString()
    {
        StringBuffer buf = new StringBuffer();
        inorder(buf);
        return buf.toString();
    }

    public void inorder(StringBuffer buf)
    {
        if (m_left != null)
            m_left.inorder(buf);

        buf.append("\n"+ m_value);

        if (m_right != null)
            m_right.inorder(buf);
    }

    public void preorder(StringBuffer buf)
    {
        buf.append("\n"+ m_value);

        if (m_left != null)
            m_left.preorder(buf);

        if (m_right != null)
            m_right.preorder(buf);
    }

    public void postorder(StringBuffer buf)
    {
        if (m_left != null)
            m_left.postorder(buf);

        if (m_right != null)
            m_right.postorder(buf);

        buf.append("\n"+ m_value);
    }

    @Override
    public T compareTo(BinaryTree other)
    {
        return m_value.compareTo(other.m_value);
    }

}
