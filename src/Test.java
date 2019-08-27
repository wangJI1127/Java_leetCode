import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String > list = new ArrayList<>();
        list.add("sad");
        list.add("wqe");
        list.add("fdasd");
        list.removeIf("sad"::equals);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
