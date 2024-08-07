package at.jku.ssw.fp.sect14_3;

import org.jetbrains.annotations.NotNull;

public class Demo05_Anonymous {

  public static void main(String[] args) {

    var prof = new Person("Andrey", "Breslav") {

      public String favouriteLanguage = "Kotlin";

      @Override
      public void work() {
        System.out.println("Teaching and doing research in %s".formatted(favouriteLanguage));
      }

      @NotNull
      @Override
      public String getProfession() {
        return "Professor";
      }
    };

    System.out.println(prof.favouriteLanguage);
  }
}
