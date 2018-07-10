package hello;

import java.util.ArrayList;
import java.util.List;

public class ArrowMap {

    private static final List<Arrow> arrowList;

    static {
        arrowList = new ArrayList<Arrow>();
        arrowList.add(Arrow.UP);
        arrowList.add(Arrow.DOWN);
        arrowList.add(Arrow.LEFT);
        arrowList.add(Arrow.RIGHT);
    }

    public Arrow getArrowByNumber(int index) {
        return arrowList.get(index % arrowList.size());
    }
}
