import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WalmartLab {
    public static void main(String[] args) {
        List list1 = new ArrayList();
        list1.add(1);
        list1.add(5);
        list1.add(7);
        list1.add(7);
        List list2 = new ArrayList();
        list2.add(0);
        list2.add(1);
        list2.add(2);
        list2.add(3);

        System.out.println(merge(list1, list2));

    }

    public static List<Integer> merge(List<Integer> a, List<Integer> b) {
        if (a.isEmpty() && b.isEmpty()) {
            return new ArrayList<>();
        }
        if (b.size() == 0) {
            return a;
        }
        if (a.size() == 0) {
            return b;
        }
        Iterator<Integer> itrA = a.iterator();
        Iterator<Integer> itrB = b.iterator();
        List<Integer> result = new ArrayList<>();
        int currentA = itrA.next();
        int currentB = itrB.next();
        int i = 0;
        while (itrA.hasNext() && itrB.hasNext()) {
            if (currentA <= currentB) {
                result.add(currentA);
                if (!itrA.hasNext()) {
                    currentA = Integer.MAX_VALUE;
                    continue;
                }
                currentA = itrA.next();
            } else {
                result.add(currentB);
                if (!itrB.hasNext()) {
                    currentB = Integer.MAX_VALUE;
                    continue;
                }
                currentB = itrB.next();
            }

        }

        while (itrA.hasNext()) {

            result.add(itrA.next());
        }
        return result;

    }
}
