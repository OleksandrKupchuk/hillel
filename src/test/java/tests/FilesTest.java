package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import setup.TestSetup;
import wait.WaitElement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FilesTest extends TestSetup {

//    @Test
//    public void createTest(){
//        String path = "target/some.txt";
//        Path filePath = Paths.get(path);
//        List<String> lines = List.of("new line example", "new line example", "new line example");
//
//        try {
//            if (Files.notExists(filePath)){
//                Files.createFile(filePath);
//            }
//
//            Files.write(filePath, lines, StandardOpenOption.APPEND);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Test
//    public void readAllLinesTest(){
//        String path = "target/some.txt";
//        Path filePath = Paths.get(path);
//
//        try {
//            if(Files.exists(filePath)){
//                List<String> fileLines = Files.readAllLines(filePath);
//                System.out.println(fileLines);
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Test
//    public void readLineTest(){
//        String path = "target/some.txt";
//
//        try(FileReader fileReader = new FileReader(path)) {
//           BufferedReader bufferedReader = new BufferedReader(fileReader);
//           String line = bufferedReader.readLine();
//           System.out.println(line);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    @Test
    public void downloadFile() {
        WaitElement waitElement = new WaitElement(getDriver());
        String path = "target/files/random_data.txt";

        getDriver().get("https://the-internet.herokuapp.com/download");
        getDriver().findElement(By.linkText("random_data.txt")).click();

        waitElement.waitForDownloadFile(path);
    }

//    @Test
//    public void uploadFile() {
//        WaitElement waitElement = new WaitElement(getDriver());
//        String path = "D:\\Homework\\Hillel\\target\\upload.txt";
//        Path filePath = Paths.get(path);
//        List<String> lines = List.of("new line example", "new line example", "new line example");
//
//        try {
//            if (Files.notExists(filePath)){
//                Files.createFile(filePath);
//            }
//            Files.write(filePath, lines, StandardOpenOption.APPEND);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        getDriver().get("https://the-internet.herokuapp.com/upload");
//        getDriver().findElement(By.id("file-upload")).sendKeys(path);
//
//        getDriver().findElement(By.id("file-submit")).click();
//
//        WebElement fileName = waitElement.waitAndGetOfVisibilityElement(By.id("uploaded-files"));
//        "upload.txt".contains(fileName.getText());
//    }
}
