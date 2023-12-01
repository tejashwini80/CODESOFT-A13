import java.util.ArrayList;

class Course {
    private String courseCode;
    private String courseName;
    private int maxCapacity;
    private int currentEnrollment;

    public Course(String courseCode, String courseName, int maxCapacity) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.maxCapacity = maxCapacity;
        this.currentEnrollment = 0;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getCurrentEnrollment() {
        return currentEnrollment;
    }

    public boolean enrollStudent() {
        if (currentEnrollment < maxCapacity) {
            currentEnrollment++;
            return true;
        } else {
            System.out.println("Course is full. Enrollment failed.");
            return false;
        }
    }

    @Override
    public String toString() {
        return courseCode + " - " + courseName + " (Capacity: " + maxCapacity + ", Enrolled: " + currentEnrollment + ")";
    }
}

class RegistrationSystem {
    private ArrayList<Course> courses;

    public RegistrationSystem() {
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void displayCourses() {
        System.out.println("Available Courses:");
        for (Course course : courses) {
            System.out.println(course);
        }
        System.out.println();
    }

    public boolean enrollStudentInCourse(String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equals(courseCode)) {
                return course.enrollStudent();
            }
        }
        System.out.println("Course not found.");
        return false;
    }
}
