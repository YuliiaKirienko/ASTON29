import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StudentInfo {
    public static void removeUnderperformingStudents(Set<Student> students) {
        students.removeIf(student -> student.getAverageGrade() < 3.0);
    }

    public static void promoteEligibleStudents(Set<Student> students) {
        students.stream()
                .filter(student -> student.getAverageGrade() >= 3.0)
                .forEach(Student::promoteToNextCourse);
    }

    public static void printStudentsByCourse(Set<Student> students, int course) {
        System.out.println("\nСтуденты " + course + " курса:");
        students.stream()
                .filter(student -> student.getCourse() == course)
                .forEach(System.out::println);
    }

    public static void demo() {
        Set<Student> students = new HashSet<>();

        students.add(new Student("Александр Пушкин", 1811, 1,
                Map.of("Математика", 2, "Биология", 3, "Физика", 2)));

        students.add(new Student("Антон Чехов", 1860, 2,
                Map.of("Биология", 5, "Литература", 3, "Химия", 5)));

        students.add(new Student("Поль Гоген", 1848, 3,
                Map.of("Математика", 3, "Живопись", 5, "История", 4)));


        System.out.println("\nИсходный список студентов:");
        students.forEach(System.out::println);

        removeUnderperformingStudents(students);
        System.out.println("\nКроме студентов с баллом < 3:");
        students.forEach(System.out::println);

        promoteEligibleStudents(students);
        System.out.println("\nПереведены на следующий курс:");
        students.forEach(System.out::println);

        printStudentsByCourse(students, 3);
    }
}