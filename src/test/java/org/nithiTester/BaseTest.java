package org.nithiTester;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class BaseTest {

    public WebDriver initDriver(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\nithy\\Downloads\\eclipse-java-2021-09-R-win32-x86_64\\BrowserDrivers\\chromedriver.exe");
        WebDriver driver  = new ChromeDriver();
        return driver;
    }
    public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {

        String jsonContent =  FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);

        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>() {});

        return data;


    }
}
