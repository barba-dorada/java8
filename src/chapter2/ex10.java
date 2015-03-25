package chapter2;

/**
 * Created by vad on 04.03.2015.
 */

import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

/**
 * 10. Write a call to  reduce that can be used to compute the average of a  Stream<Double> .
 * Why can’t you simply compute the sum and divide by  count() ?
 */
public class ex10 {
    public static void main(String[] args) {
        Double[] array = new Double[]{5.0, 2.0, 4.0, 5.0};
        Stream<Double> stream = Stream.of(array);
        Optional<Double> var=stream.reduce(new BinaryOperator<Double>() {
            Double sum ;
            int count = 0;

            @Override
            public Double apply(Double x, Double y) {
                if(sum==null) sum=x;
                sum += y;
                count++;
                System.out.printf("%f %d\n", sum, count);
                return sum / (count+1);
            }
        });
        System.out.println(var);
    }
}
