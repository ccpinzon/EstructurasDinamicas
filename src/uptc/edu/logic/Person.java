package uptc.edu.logic;
import java.util.Comparator;

public class Person {

    private String id;
    private String name;
    private int age;
    private String lastName;
    
    public static Comparator< Person > compId = new Comparator< Person >( ) {
        @Override
        public int compare ( Person t, Person t1 ) {
           return t.getId( ).compareTo( t1.getId(  )  );
        }
    };
    
    public static Comparator< Person> compDuration = new Comparator< Person >() {
        @Override
        public int compare(Person t, Person t1) {
            return ( t.getAge( ) - t1.getAge( ) ); 
        }
    };
    
    public static Comparator< Person> compInterpreter = new Comparator< Person >( ) {
        @Override
        public int compare( Person t, Person t1 ) {
            return t1.getName( ).compareTo( t.getName( ) );
        }
    };
    
    public static Comparator< Person> compSizeInterpreter = new Comparator< Person >() {
        @Override
        public int compare(Person t, Person t1) {
           return ( t.getLastName( ).length( ) ) - ( t1.getLastName( ).length( ) );
        }
    };

    public Person(String id, String name, int age, String lastName) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String LastName) {
        this.lastName = LastName;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + ", Age=" + age + ", Apellido=" + lastName + '}';
    }

}
