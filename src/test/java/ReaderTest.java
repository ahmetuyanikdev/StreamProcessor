import com.project.Reader;
import junit.framework.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReaderTest {

    static String path1 = "src/main/resources/single-line";
    static String path2 = "src/main/resources/oie.png";
    static String path3 = "src/main/resources/iphone62.mp3";


    @Test
    public void testReader() throws IOException{
        Reader reader = new Reader();
        InputStream inputStream = new FileInputStream(new File(path3));
        String output = reader.processInput(inputStream);
        System.out.println(output);

        int c=1;

        for (int i = 0; i <reader.getTokens().size() ; i++) {
            String token = reader.getTokens().get(i);
            if(c%2==0){
                Assert.assertTrue(output.contains(reader.reverseToken(token)));
            }
            else{
                Assert.assertTrue(output.contains(token));
            }
            c++;
        }
    }
}
