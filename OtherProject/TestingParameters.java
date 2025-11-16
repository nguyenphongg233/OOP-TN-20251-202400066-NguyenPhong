import parameters.Student;

public class TestingParameters {

    public static void main(String[] args) {
        Student s1 = new Student(1, "A"); 
        Student s2 = new Student(2, "B");
        
        System.out.println("Before swap: s1 = " + s1.getName() + ", s2 = " + s2.getName());
        swap(s1, s2);
        
        System.out.println("After swap:");
        System.out.println("First student: " + s1.getName());
        System.out.println("Second student: " + s2.getName());

        swapStudent(s1, s2);
        System.out.println("After swapStudent:");
        System.out.println("First student: " + s1.getName());
        System.out.println("Second student: " + s2.getName());
    }

    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;           
        o2 = tmp;
        System.out.println("Inside swap: o1 = " + ((Student)o1).getName() + ", o2 = " + ((Student)o2).getName());
    }
    public static void swapStudent(Student o1, Student o2){
        Student temp = new Student(0,"");   
        temp.set(o1);
        o1.set((Student)o2);
        o2.set(temp);
    }
}