import org.junit.jupiter.api.*;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FileTest {

    @TempDir
    Path tempDir;
    File file;

    @BeforeAll
    public void beforeAll() {
        file = new File("data.txt");
    }

    @BeforeEach
    public void beforeEach() throws IOException {
        Path temp = tempDir.resolve("test.txt");
        List<String> lines = Arrays.asList("İstanbul", "Ankara", "İzmir");
        Files.write(temp, lines);
    }

    @Test
    public void fileExistsTest() throws IOException {
        Path temp = tempDir.resolve("test.txt");
        Assertions.assertTrue( Files.exists(temp), "Temp File Fail" );
        List<String> ls = Files.readAllLines(temp);
        Assertions.assertTrue( ls.get(0).equals("İstanbul"), "İstanbul Not Found" );
    }

    @Test
    @Order(1)
    public void fileWriteTest() {
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.write("New Line");
            writer.write(System.lineSeparator());
            writer.close();
            Assertions.assertTrue(true, "FileWriter Fail");
        }catch (Exception ex) {
            Assertions.assertTrue(false, ex.getMessage() );
        }
    }

    @Test
    @Order(2)
    public void fileReadTest() {
        try {
            Scanner scanner = new Scanner(file);
            while ( scanner.hasNext() ) {
                String line = scanner.nextLine();
                System.out.println( line );
            }
            Assertions.assertTrue(true, "Scanner Fail");
        }catch (Exception ex) {
            Assertions.assertTrue(false, ex.getMessage() );
        }
    }


}
