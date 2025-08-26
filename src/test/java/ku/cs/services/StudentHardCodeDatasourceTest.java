package ku.cs.services;

import ku.cs.models.StudentList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentHardCodeDatasourceTest {
    @Test
    @DisplayName("ทดสอบการอ่านค่า Datasource")
    void testsReadData() {
        StudentHardCodeDatasource datasource = new StudentHardCodeDatasource();
        StudentList list = datasource.readData();
        assertNotNull(list);

        assertEquals(4, list.getStudents().size());

        assertEquals("6710400001", list.getStudents().get(0).getId());
        assertEquals("First", list.getStudents().get(0).getName());

        assertEquals("6710400002", list.getStudents().get(1).getId());
        assertEquals("Second", list.getStudents().get(1).getName());

        assertEquals("6710400003", list.getStudents().get(2).getId());
        assertEquals("Third", list.getStudents().get(2).getName());

        assertEquals("6710400004", list.getStudents().get(3).getId());
        assertEquals("Fourth", list.getStudents().get(3).getName());
    }
}