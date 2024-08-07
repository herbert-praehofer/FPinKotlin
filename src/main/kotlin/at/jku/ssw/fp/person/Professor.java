package at.jku.ssw.fp.person;

/**
 * Class for special person professor.
 * Professors additionally do some research.
 *
 * @author Herbert Praehofer
 */
public class Professor extends Person {

  /**
   * The research of the professor
   */
  private String research;

  /**
   * Constructor initializing name, age and research.
   *
   * @param name     the name of the professor
   * @param age      the age  of the professor
   * @param research the research  of the professor
   */
  public Professor(String name, int age, String research) {
    super(name, age);
    this.research = research;
  }

  /**
   * Constructor initializing name and age.
   *
   * @param name the name of the professor
   * @param age  the age  of the professor
   */
  public Professor(String name, int age) {
    this(name, age, "ComputerScience");
  }

  /**
   * Constructor initializing name.
   *
   * @param name the name of the professor
   */
  public Professor(String name) {
    this(name, 0, "ComputerScience");
  }

  /**
   * Returns the research of this professor.
   *
   * @return the research
   */
  public String getResearch() {
    return research;
  }

  /**
   * Sets the research of this professor.
   *
   * @param research the new research
   */
  public void setResearch(String research) {
    this.research = research;
  }

  /**
   * Returns a string representation of this professor.
   *
   * @return the string representation
   */
  @Override
  public String toString() {
    return "Student [name = " + getName() + ", study=" + research + "]";
  }

}
