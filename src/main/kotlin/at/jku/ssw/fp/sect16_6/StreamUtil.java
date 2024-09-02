package at.jku.ssw.fp.sect16_6;

import java.util.Spliterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author Herbert Praehofer
 *
 */
public class StreamUtil {

  /**
   * Creates a stream of numbered values from a stream of values.
   *
   * @param <A> type of the value
   * @param as the stream of values
   * @return the stream of the numbered values
   */
  public static <A extends Comparable<A>> Stream<Numbered<A>> number(Stream<A> as) {
    IntStream is = IntStream.iterate(1, x -> x + 1);
    Stream.Builder<Numbered<A>> builder = Stream.builder();
    Spliterator<A> asSpltr = as.spliterator();
    Spliterator.OfInt isSpltr = is.spliterator();
    asSpltr.forEachRemaining(a -> {
      isSpltr.tryAdvance((int i) -> {
        builder.accept(Numbered.of(i, a));
      });
    });
    return  builder.build();
  }

}
