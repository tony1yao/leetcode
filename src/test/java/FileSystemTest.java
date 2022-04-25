import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileSystemTest {
    FileSystem fileSystem;
    @BeforeEach
    void setUp() {
        fileSystem = new FileSystem();
    }

    @Test
    void createPath() {
        Assertions.assertTrue(fileSystem.createPath("/parent", 2));
        Assertions.assertTrue(fileSystem.createPath("/parent/test", 5));
        Assertions.assertFalse(fileSystem.createPath("/paret/test", 5));
        Assertions.assertFalse(fileSystem.createPath("/test/test/test", 2));
        Assertions.assertFalse(fileSystem.createPath("", 2));
        Assertions.assertFalse(fileSystem.createPath("/", 2));
        Assertions.assertFalse(fileSystem.createPath("aaa", 2));
        Assertions.assertTrue(fileSystem.createPath("/parent/test/another", 6));
    }

    @Test
    void getValue() {
        fileSystem.createPath("/parent", 2);
        fileSystem.createPath("/parent/test", 5);
        Assertions.assertEquals(5, fileSystem.get("/parent/test"));
        Assertions.assertEquals(2, fileSystem.get("/parent"));
        Assertions.assertEquals(-1, fileSystem.get("/test"));
        Assertions.assertEquals(-1, fileSystem.get("/parent/test/another"));
        Assertions.assertEquals(-1, fileSystem.get("/parent/te"));
    }
}