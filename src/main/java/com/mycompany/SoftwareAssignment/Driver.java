package com.mycompany.SoftwareAssignment;

import com.mycompany.app.CourseProgramme;
import com.mycompany.app.Student;
import com.mycompany.app.Module;
import org.joda.time.DateTime;

import java.util.ArrayList;


public class Driver
{
    private static CourseProgramme ComputerScience, Business, Science;
    private static Student Nora, Anna, Jonathan;
    private static Module Maths, Ethics, MachineLearning;

    public Driver(CourseProgramme courseProgramme) {

        Maths = new Module("Maths", "MTS34");
        Nora = new Student("Nora", 21, new DateTime("1999-09-14"), 173093251);
        ComputerScience = new CourseProgramme("ComputerScience", new DateTime("2020-09-28"), new DateTime("2021-05-20"));
        Ethics = new Module("Ethics", "DB84");
        Anna = new Student("Anna", 21, new DateTime("1999-09-14"), 17325941);
        Business = new CourseProgramme("Business", new DateTime("2020-09-28"), new DateTime("2021-05-20"));
        MachineLearning = new Module("MachineLearning", "BS28");
        Jonathan = new Student("Jonathan", 21, new DateTime("1999-09-14"), 1728394);
        Science = new CourseProgramme("Science", new DateTime("2020-09-28"), new DateTime("2021-05-20"));

        Nora.addModule(Maths);
        Nora.addModule(Ethics);
        Nora.addCourse(Business);

        Anna.addModule(Maths);
        Anna.addModule(Ethics);
        Anna.addModule(MachineLearning);
        Anna.addCourse(ComputerScience);

        Jonathan.addModule(Maths);
        Jonathan.addModule(Ethics);
        Jonathan.addCourse(Science);

        Maths.addStudent(Nora);
        Maths.addStudent(Anna);
        Maths.addStudent(Jonathan);

        Ethics.addStudent(Nora);
        Ethics.addStudent(Anna);
        Ethics.addStudent(Jonathan);

        MachineLearning.addStudent(Anna);

        Maths.addCourse(Business);
        Maths.addCourse(Science);
        Maths.addCourse(ComputerScience);

        MachineLearning.addCourse(ComputerScience);

        Ethics.addCourse(Business);
        Ethics.addCourse(Science);
        Ethics.addCourse(ComputerScience);

        MachineLearning.addCourse(ComputerScience);
    }


    public static void main(String[] args){
        printToConsole();
    }

    public static void printToConsole(){
        studentPrint(Nora);
        studentPrint(Anna);
        studentPrint(Jonathan);
        modulePrint(Maths);
        modulePrint(Ethics);
        modulePrint(MachineLearning);
        coursesPrint(ComputerScience);
        coursesPrint(Business);
        coursesPrint(Science);
    }

    public static void studentPrint(Student student){

        System.out.println(student.getName());
        ArrayList<CourseProgramme> courses = student.getRegisteredCourses();

        System.out.print("Student username:");
        System.out.println(student.getUsername());

        System.out.println("They study the course(s):");
        for (CourseProgramme course : courses) {
            System.out.println(course.getCourseName());
        }

        System.out.println("They take the following modules:");
        ArrayList<Module> modules = student.getRegisteredModules();
        for (Module module : modules) {
            System.out.println(module.getModuleName());
        }

    }

    public static void modulePrint(Module module){

        System.out.print(module.getModuleName());
        ArrayList<CourseProgramme> courses = module.getModuleCourses();
        System.out.println(" is a module in the following courses:");
        for (CourseProgramme course : courses) {
            System.out.println(course.getCourseName());
        }

        ArrayList<Student> students = module.getModuleStudents();
        System.out.println("The following students take this module:");
        for (Student student : students) {
            System.out.println(student.getName());
        }

    }

    public static void coursesPrint(CourseProgramme course){

        System.out.print(course.getCourseName());
        ArrayList<Module> modules = course.getCourseModules();
        System.out.println(" has the following modules:");
        for (Module module : modules) {
            System.out.println(module.getModuleName());
        }

        System.out.println("The following students are registered for this course:");
        ArrayList<Student> students = course.getCourseStudents();
        for (Student student : students) {
            System.out.println(student.getName());
        }

    }

}
