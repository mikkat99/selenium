package project.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
    private final Properties properties = new Properties();

    private static TestProperties INSTANCE = null;

    private TestProperties(){
        try{
            properties.load(new FileInputStream("src/enveronment.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static TestProperties getINSTANCE() {
        if (INSTANCE == null){
            INSTANCE = new TestProperties();
        }
        return INSTANCE;
    }
    public Properties getProperties() { return  properties;}
}
