package com.examtest.logicknots;
import java.io.InputStream;
import java.sql.Driver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;  
/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
		Logger log = new Logger("C:\\exam_logs\\ginger");
		String canId= null;;
		System.setProperty("javax.net.ssl.trustStore", "trust-store.jks");
		  System.setProperty("javax.net.ssl.trustStorePassword", "TrustStore");
     System.setProperty("webdriver.chrome.driver","C:\\chorme_driver\\chromedriver.exe");  
     ChromeOptions options = new ChromeOptions();
     // Enable headless mode by passing the argument
     options.addArguments("--headless");
     WebDriver driver=new ChromeDriver(options);
    	try {
    		canId=args[0]; //"CAN35139260";
    		//canId="CAN35182351";
    	    QuestionBank bank=new QuestionBank();	
		  
		 driver.navigate().to("https://skillassessment.thinkexam.com");
	     Thread.sleep(5000);//emailId
	     WebElement emailText= driver.findElement(By.id("emailId"));
	     emailText.sendKeys(canId);
	     Thread.sleep(2000);//passwordl
	     WebElement passText= driver.findElement(By.id("passwordl"));
	     passText.sendKeys("123456"); //logindisable
	     Thread.sleep(2000);//passwordl
	     log.addMsg("Loged in");
	     WebElement loginBtn=driver.findElement(By.xpath("//input[@type='submit']"));
	     loginBtn.click();
	     Thread.sleep(5000);//passwordl
	     WebElement startBtn= Util.getXpathEle(driver, "//*[@id=\"testDiv\"]/ul/li/div/div[3]/a/div/div/span");  //driver.findElement(By.xpath("//*[@id=\"testDiv\"]/ul/li/div/div[3]/a/div/div/span"));
	     WebElement restartTestBtn=Util.getXpathEle(driver, "//*[@id=\"testDiv\"]/ul/li/div/div[3]/a/span");  //driver.findElement(By.xpath("//*[@id=\"testDiv\"]/ul/li/div/div[3]/a/span"));

	     if(startBtn!=null) {
		    	startBtn.click();
		 }
		 else if(restartTestBtn !=null) {
			     restartTestBtn.click();
		  }
	     log.addMsg("Opend Test");

//		    else if(startTestBtn!=null) {
//			     startTestBtn.click();
//			
//		    }
	     Thread.sleep(5000);//passwordl
	     driver.close();
	     Thread.sleep(5000);//passwordl
	     Object[] windowHandles=driver.getWindowHandles().toArray();
	     driver.switchTo().window((String)windowHandles[0]);
	     Thread.sleep(10000);//passwordl
	        String title=driver.getTitle();

	        System.out.println("Title==>"+title);  
	     WebElement termCondition= driver.findElement(By.className("lftflt"));
	     termCondition.click();
	     Thread.sleep(2000);//emailId
	     WebElement langDrop= driver.findElement(By.id("hindi"));

	     
	     Select lang =new Select(langDrop);
	     lang.selectByValue("1");//wrightImage_1
	     Thread.sleep(2000);//emailId

	     WebElement startTest= driver.findElement(By.id("startTest"));
	     
	     startTest.click();
	     Thread.sleep(5000);//emailId
	     try {
	        Alert alert1 = driver.switchTo().alert();
	        if(alert1!=null) {
		        alert1.accept();
	        	log.addMsg("Accespt alert");
		        Thread.sleep(2000);
	        }
	     }
	     catch(Exception ex) {
	    	 
	     }

	     WebElement question1btn= driver.findElement(By.id("wrightImage_1"));
	     question1btn.click();
	     int count=0;
	     int maxC=Util.randomBetween(5, 15);
	     for(int i=0;i<60;i++) {
			 WebElement question= driver.findElement(By.id("questionDiv"));
			// Thread.sleep(5000);//emailId
			 WebElement opt1= driver.findElement(By.xpath("//label[@for='mcqSingle0']/span"));
			 WebElement opt2= driver.findElement(By.xpath("//label[@for='mcqSingle1']/span"));
			 WebElement opt3= driver.findElement(By.xpath("//label[@for='mcqSingle2']/span"));
			 WebElement opt4= driver.findElement(By.xpath("//label[@for='mcqSingle3']/span"));
	         int correctAns= bank.getCorrectAnswer(question.getText(), opt1.getText(), opt2.getText(), opt3.getText(), opt4.getText());
			 if(count<maxC && Util.random(2)==0) {
				 correctAns = Util.random(4);
				 count++;
			 }
			 System.out.println("Question==>"+question.getText());
	         System.out.println("CorrectAns==>"+correctAns);
			 WebElement answer= driver.findElement(By.xpath("//label[@for='mcqSingle"+correctAns+"']"));
			 answer.click();
			 Thread.sleep(2000);//emailId
				log.saveAns(question.getText(), correctAns);
			if(i!=59) {
			 WebElement nextQuestion= driver.findElement(By.xpath("//*[@id=\"nextID\"]"));
			 nextQuestion.click();
			 Thread.sleep(2000);//emailId
			}
	     }
//         log.addMsg("click on 2nd question");
//	     WebElement question1btnnew= driver.findElement(By.id("wrightImage_60"));
//	     question1btnnew.click();
//		 Thread.sleep(5000);//emailId //popup_ok
//	     WebElement save_test= driver.findElement(By.id("sampleSaveResponseBtn"));
//	     save_test.click();
//		 Thread.sleep(5000);//emailId //popup_ok
		 log.addMsg("save test");
	     WebElement submit_test=driver.findElement(By.xpath("//*[@id=\"submittest\"]/a"));
         submit_test.click();
		 Thread.sleep(5000);//emailId //popup_ok
		 log.addMsg("submit test");
         WebElement submit_final=driver.findElement(By.id("popup_ok"));
         submit_final.click();
		 Thread.sleep(5000);//emailId //popup_ok
         log.addMsg("confirm submit test");
         log.saveTest(canId, "success");
         driver.quit();
    	}
    	catch(Exception ex) {
    		ex.getStackTrace();
    		//System.out.println(ex.getMessage()); //submittest
            log.addMsg(ex.getMessage());
            log.saveTest(canId, "error");
            driver.quit();
    	}
    	
    	
	     //startTest.click();
	     
//         for(int i=0;i<windowHandles.length;i++) {
//        	 System.out.print(windowHandles[i]);
//         }
    }
}
