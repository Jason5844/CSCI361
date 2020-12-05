public class Plates
{
  private Map<String, Integer> plateMap;

  public Plates()
  {
     plateMap = new HashMap<String, Integer>();
  }

  // Implement me please...
  public void buildMap()
  {
    map.put("MA", 1);
    map.put("ME", 1);
    map.put("WA", 1);
    map.put("NY", 1);
    map.put("NJ", 1);
    map.put("VT", 1);
  }

  public void printCounts()
  {
     /* do not edit the implementation of this method*/
     System.out.println("Number of Plates: " + plateMap.keySet().size());
     for (String key : plateMap.keySet())
       System.out.printf("%s -> %s%n", key, plateMap.get(key));
  }
}
