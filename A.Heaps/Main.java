public class Main
{
   public static void main(String[] args)
   {
      // you can use this method to test your heap
      // you can put any code you like here

      // here is some sample code that creates
       // a heap...
      Integer[] ary = {2,5, 9, 3};
      List l = Arrays.asList(ary);
      Heap h = new Heap();
      h.insertAll(l);
      System.out.println(h);
   }
}
