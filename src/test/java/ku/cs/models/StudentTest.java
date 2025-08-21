package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    Student test;
    @BeforeEach
    void init() {
        test = new Student("6710404123", "test");
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 60")
    void testAddScore() {
        test.addScore(60);
        assertEquals(60, test.getScore());
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 90 และ คำนวณเกรด")
    void testCalculateGrade() {
        test.addScore(90);
        assertEquals("A", test.grade());
    }

    @Test
    @DisplayName("ทดสอบการเปลี่ยนชื่อ")
    void testChangeName() {
        test.changeName("Mambo");
        assertEquals("Mambo", test.getName());
    }

    @Test
    @DisplayName("ทดสอบการเทียบ Id ว่าเมื่อตรงกันออกมาเป็น True")
    void testIsId() {
        assertEquals(true, test.isId("6710404123"));
    }

    @Test
    @DisplayName("ทดสอบการว่าเมื่อมีตัวอักษรนั้นในชื่อไหม ถ้ามีออกมาเป็น True")
    void testIsNameContains() {
        assertEquals(true, test.isNameContains("t"));
    }

    @Test
    @DisplayName("ทดสอบการเรียกค่า ID")
    void testGetId() {
        assertEquals("6710404123", test.getId());
    }

    @Test
    @DisplayName("ทดสอบการเรียกค่า ชื่อ")
    void testGetName() {
        assertEquals("test", test.getName());
    }

    @Test
    @DisplayName("ทดสอบการเรียกค่า Grade")
    void testGetGrade() {
        assertEquals("F", test.getGrade());
    }

    @Test
    @DisplayName("ทดสอบการเรียกค่า Score")
    void testGetScore() {
        test.addScore(60);
        assertEquals(60, test.getScore());
    }

    @Test
    @DisplayName("ทดสอบการปริ้นข้อมูลใน Student")
    void testToString() {
        assertEquals("{" +
                    "id: '" + test.getId() + '\'' +
                    ", name: '" + test.getName() + '\'' +
                    ", score: " + test.getScore() +
                    '}', test.toString());
    }
}