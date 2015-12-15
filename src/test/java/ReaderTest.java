import com.project.Reader;
import junit.framework.Assert;
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
        Assert.assertEquals(18,reader.getTokens().size());
        System.out.println(output.indexOf("have"));

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
