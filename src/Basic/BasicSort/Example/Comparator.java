package Basic.BasicSort.Example;

import java.util.Arrays;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/13 15:38
 * 比较器
 */
public class Comparator {

    public static class Student{
        public String name;
        public int id;
        public int age;
        public Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }

    public static class IdAscendingComparator implements java.util.Comparator<Student>{
        @Override
        public int compare(Student o1, Student o2) {
            return o1.id - o2.id;
        }
    }

    public static class IdDescendingComparator implements java.util.Comparator<Student>{
        @Override
        public int compare(Student o1, Student o2) {
            return o2.id - o1.id;
        }
    }

    public static void printStudents(Student[] students){

    }

    public static void main(String[] args) {
        Student student1 = new Student("A", 2, 20);
        Student student2 = new Student("B", 3, 21);
        Student student3 = new Student("C", 1, 22);

        Student[] students = new Student[]{student1, student2, student3};
        Arrays.sort(students, new IdAscendingComparator());
    }
}
