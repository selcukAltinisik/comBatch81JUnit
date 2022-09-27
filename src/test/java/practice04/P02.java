package practice04;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class P02 {

    @Test
    public void test1() {

        //Verify that we have pom.xml file in our project => please try in 4 min s

        String pomXmlDosyaYolu = "C:\\Users\\selcu\\IdeaProjects\\comBatch81JUnit\\pom.xml";
        Assert.assertTrue(Files.exists(Paths.get(pomXmlDosyaYolu)));

    }
}
