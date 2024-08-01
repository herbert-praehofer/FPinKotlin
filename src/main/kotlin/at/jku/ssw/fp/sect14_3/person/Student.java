package at.jku.ssw.fp.sect14_3.person;

/**
 * Class for special person student.
 * Students additionally do some study.
 *
 * @author Herbert Praehofer
 */
public class Student extends Person {

  /**
   * The study of the student
   */
  private Study study;

  /**
   * Constructor initializing name, age and study.
   *
   * @param name  the name of the student
   * @param age   the age  of the professor
   * @param study the study of the student
   */
  public Student(String name, int age, Study study) {
    super(name);
    this.study = study;
  }

  /**
   * Constructor initializing name and age.
   *
   * @param name the name of the student
   * @param age  the age  of the student
   */
  public Student(String name, int age) {
    this(name, age, Study.ComputerScience);
  }

  /**
   * Constructor initializing name.
   *
   * @param name the name of the student
   */
  public Student(String name) {
    this(name, 0, Study.ComputerScience);
  }

  /**
   * Returns the study of this student.
   *
   * @return the study
   */
  public Study getStudy() {
    return study;
  }

  /**
   * Sets the study of this student.
   *
   * @param study the new study
   */
  public void setStudy(Study study) {
    this.study = study;
  }

  /**
   * Returns a string representation of this student.
   *
   * @return the string representation
   */
  @Override
  public String toString() {
    return "Student [name = " + getName() + ", study=" + study + "]";
  }

}
