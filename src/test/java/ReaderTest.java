import com.project.Reader;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReaderTest {

    static String path1 = "src/main/resources/single-line";

    @Test
    public void test() throws IOException{
        Reader reader = new Reader();
        InputStream inputStream = new FileInputStream(new File(path1));
        String output = reader.processInput(inputStream);

        System.out.println(output);
        System.out.println("-- token array--");
        System.out.println(reader.getTokens());
    }
}
