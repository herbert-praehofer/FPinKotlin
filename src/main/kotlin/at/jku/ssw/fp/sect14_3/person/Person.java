package at.jku.ssw.fp.sect14_3.person;

/**
 * Class representing a person with name and age.
 *
 * @author Herbert Praehofer
 */
public class Person implements Comparable<Person> {

  /**
   * The name of the person
   */
  private final String name;

  /**
   * The age of the person
   */
  private int age;

  /**
   * Default constructor.
   */
  public Person() {
    this("NN", 0);
  }

  /**
   * Constructor initializing the name of the person.
   *
   * @param name the name of the person
   */
  public Person(String name) {
    this(name, 0);
  }

  /**
   * Constructor initializing the name and age of the person.
   *
   * @param name the name of the person
   * @param age  the age of the person
   */
  public Person(String name, int age) {
    super();
    this.name = name;
    this.age = age;
  }

  /**
   * Returns the name of this person.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the age of this person.
   *
   * @return the age
   */
  public int getAge() {
    return age;
  }

  /**
   * Sets the age of this person.
   *
   * @param age the age
   */
  public void setAge(int age) {
    this.age = age;
  }

  /**
   * Returns a string representation of this person.
   *
   * @return the string representation
   */
  @Override
  public String toString() {
    return "Person [name=" + name + ", age=" + age + "]";
  }

  /**
   * Returns a hash code computed from the name of the person.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
  }

  /**
   * Compares this person object and the given object for equality.
   * Compares the name.
   *
   * @return {@code true} if given object is a person and their names are equal
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Person other = (Person) obj;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    return true;
  }

  /**
   * Compares this person and the given person first based on the name, then on the age.
   * <p>
   * Remark: used for demonstration of Comparator
   * </p>
   *
   * @return -1 if this person is smaller,
   * +1 if other person is smaller,
   * 0 if they are equal
   */
  @Override
  public int compareTo(Person o) {
    int c = name.compareTo(o.name);
    if (c == 0) {
      c = age < o.age ? -1 : age == o.age ? 0 : +1;
    }
    return c;
  }
}
