package DataStructure;
import java.util.*;

public class NestedInteger {
    private int n;
    private ArrayList<NestedInteger> l;
    private boolean isInteger;

    public NestedInteger() {
        this.l = new ArrayList<>();
        this.isInteger = false;
    }

    public NestedInteger(int value) {
        this.n = value;
        this.isInteger = true;
    }

    public boolean isInteger() {
        return this.isInteger;
    }

    public int getInteger() {
        return this.n;
    }

    public void setInteger(int value) {
        this.n = value;
        this.isInteger = true;
    }

    public void add(NestedInteger ni) {
        this.l.add(ni);
    }

    public List<NestedInteger> getList() {
        return l==null ? null: l;
    }

    public String toString() {
        String result = "[";
        if (this.isInteger()) {
            result += this.n;
        }
        if (this.getList() != null) {
            for (NestedInteger ni: l) {
                result += ni.toString();
                result += ",";
            }
        }
        result += "]";
        return result;
    }
}
