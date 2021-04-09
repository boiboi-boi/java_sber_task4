

public class task4 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("D");
        list.add("E");
        list.add("C");
        list.add("A");
        list.add("B");

        ArrayList<String> list_copy = new ArrayList<>();
        list_copy.add("A");
        list_copy.add("B");
        list_copy.add("C");
        list_copy.add("D");

        Object[] test_arr = new String[20];

        System.out.println(list.get(2));
        System.out.println(list.equals(list_copy));
        list.delete(2);
        list.set(2, "K");
        System.out.println(list.getSize());
        test_arr = list.toArray();
        list.sort();
        list.viewArray();

//        System.out.println(list.iterator().next());
    }
}
