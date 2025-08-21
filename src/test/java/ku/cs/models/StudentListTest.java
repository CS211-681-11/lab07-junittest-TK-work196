package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {
    StudentList testList;
    ArrayList<Student> students;

    @BeforeEach
    void init() {
        testList = new StudentList();
        students = testList.getStudents();
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มนักเรียน")
    void testAddNewStudent() {
        String id = "6710404123";
        String name = "test";

        Student test = new Student(id,name);
        testList.addNewStudent(id, name);

        assertEquals(1, students.size());
        assertEquals(test.getName(), students.get(0).getName());
        assertEquals(test.getId(), students.get(0).getId());
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มนักเรียนพร้อมคะแนน")
    void testAddNewStudentWithScore() {
        String id = "6710404123";
        String name = "test";
        double score = 45.7;

        Student test = new Student(id,name,score);
        testList.addNewStudent(id, name,score);

        assertEquals(1, students.size());
        assertEquals(test.getName(), students.get(0).getName());
        assertEquals(test.getScore(), students.get(0).getScore());
        assertEquals(test.getId(), students.get(0).getId());
    }

    @Test
    @DisplayName("ทดสอบการหานักเรียนด้วยรหัส")
    void testFindStudentById() {
        testList.addNewStudent("6710404001", "John");
        testList.addNewStudent("6710404002", "Denver");
        assertEquals(students.get(1), testList.findStudentById("6710404002"));
    }

    @Test
    @DisplayName("ทดสอบคัดนักเรียนด้วยชื่อ")
    void testFilterByName() {
        testList.addNewStudent("6710404001", "John");
        testList.addNewStudent("6710404002", "John");
        testList.addNewStudent("6710404003", "John");
        testList.addNewStudent("6710404004", "Denver");
        testList.addNewStudent("6710404005", "Martin");
        StudentList filteredList = testList.filterByName("John");
        assertEquals(3, filteredList.getStudents().size());
    }

    @Test
    @DisplayName("ทดสอบให้คะแนนกับนักเรียนด้วยการระบุรหัส")
    void testGiveScoreToId() {
        testList.addNewStudent("6710404001", "John");
        testList.addNewStudent("6710404002", "Denver");
        testList.giveScoreToId("6710404002", 30);
        assertEquals(30, students.get(1).getScore());
    }

    @Test
    @DisplayName("ทดสอบการแสดงเกรดของนักเรียน")
    void testViewGradeOfId() {
        testList.addNewStudent("6710404001", "John", 70);
        testList.addNewStudent("6710404002", "Denver", 60);
        assertEquals("C", testList.viewGradeOfId("6710404002"));
    }

    @Test
    @DisplayName("ทดลองการเรียกหานักเรียน")
    void testGetStudents() {
        ArrayList<Student> studentsTest = new ArrayList<>();
        studentsTest.add(new Student("6710404001", "John"));
        testList.addNewStudent("6710404001", "John");
        assertEquals(studentsTest, testList.getStudents());
    }
}