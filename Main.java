import java.util.*;

public class Main
{
    public static void main(String args[])
    {
      // -----------------------------------
      // do not edit main...
      // -----------------------------------
      List<Person> people = new ArrayList<Person>();

      people.add(new Person("Frank", "Denton", 73));
      people.add(new Person("Mark", "Cohen", 44));
      people.add(new Person("Tim", "Smith", 22));
      people.add(new Person("Steve", "Denton", 16));
      people.add(new Person("Andy", "Ashton", 44));
      people.add(new Person("Albert", "Denton", 58));

      List<Person> ans = mergeSort(people);
      System.out.println(ans);
      // -----------------------------------
    }

    public static List<Person> mergeSort(List<Person> items)
    {
        List<Person> sorted = new ArrayList<Person>();
        if (items.size() == 1) // base case...
        {
            return;
        }
        else // recursive call...
        {
            int mid = items / 2;
            int [] l = new int [mid];
            int[] r = new int [n - mid];

            for (int i = 0; i < mid; i++)
            {
              l[i] = a[i];
            }

            for (int i = mid; i < n; i++)
            {
              r[i - mid] = a[i];
            }

            mergeSort(l, mid);
            mergeSort(r, n - mid);
            merge(a, l, r, mid, n - mid);
        }
    }

    private static List<Person> merge(List<Person> partA, List<Person> partB)
    {
         List<Person> merged = new ArrayList<Person>();

         Stream.of(partA, partB).forEach(newList::addAll);

         return merged;
    }
}
