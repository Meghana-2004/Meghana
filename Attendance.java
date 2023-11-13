import java.util.ArrayList; 
import java.util.List; 
import java.util.Scanner;
class Student {
    private int id; private String name;
    public Student(int id, String name) 
    {
        this.id = id;
        this.name = name;
    }
    public int getId()
    { 
        return id;
    }
    public String getName()
    {
        return name;
    }
}
class Course {
    private String name;
    private List<Student> students;
    private List<Boolean> attendance;
    public Course(String name) 
    { 
        this.name = name;
        this.students = new ArrayList<>(); 
        this.attendance = new ArrayList<>();
    }
    public void addStudent(Student student)
    {
        students.add(student);
        attendance.add(false); // Initialize attendance as false for this student
    }
    public void markAttendance(int studentId)
    {
        if (studentId >= 0 && studentId < students.size()) 
        {
            attendance.set(studentId, true);
        }
    }
    public List<Student> getStudents()
    { 
        return students;
    }
    public List<Boolean> getAttendance()
    { 
        return attendance;
    }
    public String getName() 
    {
        return name;
    }
}
class AttendanceManager
{
    public static void main(String[] args)
    { 
        Scanner scanner = new Scanner(System.in);
        // Create a course
        Course course = new Course("Java Programming");
        // Add students to the course 
course.addStudent(new Student(1, "Meghana"));
 course.addStudent(new Student(2,"Swathi")); course.addStudent(new Student(3,"Ramya")); course.addStudent(new Student(4, "Varshitha")); course.addStudent(new Student(5, "Jahnavi")); course.addStudent(new Student(6, "Neha")); course.addStudent(new Student(7, "Sownya")); course.addStudent(new Student(8, "Priyanka")); course.addStudent(new Student(9, "Alekhya")); course.addStudent(new Student(10, "Sahithya")); course.addStudent(new Student(11, "Niharika")); course.addStudent(new Student(12, "Sri Vidya")); course.addStudent(new Student(13, "Rama ")); course.addStudent(new Student(14, "Harathi"));  course.addStudent(new Student(15, "Munnisha"));


    while (true) 
    {
        System.out.println("Attendance Management System"); 
        System.out.println("1. Mark Attendance"); 
        System.out.println("2. Display Attendance"); 
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        switch (choice) 
        { 
          case 1:
             System.out.println("Students:"); 
             List<Student> students = course.getStudents(); 
             for (int i = 0; i < students.size(); i++) 
             {
                System.out.println(i + 1 + ". " + students.get(i).getName());
            }
            System.out.print("Enter student ID to mark attendance: ");
            int studentId = scanner.nextInt();
            course.markAttendance(studentId - 1); // Adjust for 0-based index System.out.println("Attendance marked for student " + studentId); break;
           case 2:
            System.out.println("Attendance for " + course.getName() + ":");
            List<Student> attendees = course.getStudents();
            List<Boolean> attendanceList = course.getAttendance();
            for (int i = 0; i < attendees.size(); i++)
            {
               String attendanceStatus = attendanceList.get(i) ? "Present" : "Absent"; System.out.println(attendees.get(i).getName() + ": " + attendanceStatus);
            }
            break; 
           case 3:
             System.out.println("Exiting Attendance Management System.");
             System.exit(0);
         default:
              System.out.println("Invalid choice. Please try again.");
       }
    }
  }
}

