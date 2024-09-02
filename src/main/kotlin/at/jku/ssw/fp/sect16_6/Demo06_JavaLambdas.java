package at.jku.ssw.fp.sect16_6;

import at.jku.ssw.fp.sect16_2.FunctionsKt;

import java.util.ArrayList;
import java.util.List;

public class Demo06_JavaLambdas {

  public static void main(String[] args) {

    // map

    List<String> list = List.of("A", "AB");
    List<Integer> lengths =
        FunctionsKt.map(list, s -> s.length());
    System.out.println(lengths);

    List<Integer> lengths2 =
        map(list, s -> s.length());
    System.out.println(lengths2);

    // runIf

    int y = 2;
    int x = 5;
    FunctionsKt.runIf(y != 0, () -> {
      int r = x / y;
      System.out.println("x/y = $r");
      return kotlin.Unit.INSTANCE;
    });


  }

  public static <T, R> List<R> map(
      List<T> list,
      kotlin.jvm.functions.Function1<? super T, ? extends R> mapper
  ) {
    List<R> result = new ArrayList<R>();
    for (T t: list) {
      result.add(mapper.invoke(t));
    }
    return result;
  }

}
