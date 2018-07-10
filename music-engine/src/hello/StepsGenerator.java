package hello;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StepsGenerator {

    private ArrowMap arrowMap;
    private Random rand;

    public StepsGenerator() {
        arrowMap = new ArrowMap();
        rand = new Random();
    }

    public List<Arrow> getArrowsList(int stepsNum) {
        Random rand = new Random();
        return IntStream.range(1,stepsNum)
                .map(num -> rand.nextInt(50))
                .mapToObj(randNum -> arrowMap.getArrowByNumber(randNum))
                .collect(Collectors.toList());
    }
}
