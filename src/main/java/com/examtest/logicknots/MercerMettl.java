package com.examtest.logicknots;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MercerMettl {

	public static void main(String[] args) {
		
		Logger log = new Logger("C:\\exam_logs\\ginger");
		String canId= null;;
		System.setProperty("javax.net.ssl.trustStore", "trust-store.jks");
		  System.setProperty("javax.net.ssl.trustStorePassword", "TrustStore");
     System.setProperty("webdriver.chrome.driver","C:\\chorme_driver\\chromedriver.exe");  
     WebDriver driver=new ChromeDriver();
    	try {
    		canId="CAN35139264";
    	    QuestionBank bank=new QuestionBank();	
		  
		 driver.navigate().to("https://tests.mettl.com/test-window-pi?key=7zvAXbqZgBq1U4qn1fPWJbBJDMGPtUY8t16qNl%2FYJvn%2BEsQBQeyLQbdWht3oqoiZ");
	     Thread.sleep(5000);//emailId
	     driver.manage().window().maximize();
	     Thread.sleep(2000);//prcd-btn
		 WebElement processBtn= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[1]/div[2]/span"));
         processBtn.click();
	     Thread.sleep(5000);//prcd-btn
         WebElement process1= driver.findElement(By.id("prcd-btn"));
         process1.click();
	     Thread.sleep(2000);////*[@id="root"]/div/div[2]/div/div[2]/div[2]/button
         WebElement emailid= driver.findElement(By.id("formBasicEmail"));
         emailid.sendKeys("2940379_can_35141883@mettl.com");
	     Thread.sleep(2000);////*[@id="crfForm"]/div[2]/div/label/p
	     
		 WebElement process2= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div[2]/button"));
         process2.click();
	     Thread.sleep(2000);////*[@id="crfForm"]/div[2]/div/label/p

		 WebElement termCheckbox= driver.findElement(By.xpath("//*[@id=\"crfForm\"]/div[2]/div/label/p"));
		 termCheckbox.click();
	     Thread.sleep(2000);////*[@id="crfForm"]/div[2]/div/label/p

		//*[@id="crfForm"]/div[3]/div/button
		 
	     WebElement processSubmit= driver.findElement(By.xpath("//*[@id=\"crfForm\"]/div[3]/div/button"));
	     processSubmit.click();
	     Thread.sleep(2000);///start-test-btn
	     
	     WebElement start_test= driver.findElement(By.id("start-test-btn"));
	     start_test.click();
	     Thread.sleep(5000);///start-test-btn
	     
	     
	     WebElement sectiondropDown= driver.findElement(By.id("dropdownSection"));
	     sectiondropDown.click();
	     Thread.sleep(5000);///start-test-btn
	     
	     WebElement selectTheory= driver.findElement(By.xpath("//*[@id=\"dropdownSectionList\"]/li[1]/div"));
	     selectTheory.click();
	     Thread.sleep(5000);///start-test-btn
	     
	     WebElement qsnList= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div/div[1]/div[1]/div[2]/div/div[2]/button"));
	     qsnList.click();
	     Thread.sleep(5000);///start-test-btn
	     
	     WebElement firstQsn= driver.findElement(By.id("quesItem_0"));
	     firstQsn.click();
	     Thread.sleep(5000);///start-test-btn
	     
	     for(int i=0;i<40;i++) {
	    	 
			 WebElement question= driver.findElement(By.xpath("//div[@class=\"question-area\"]/div[2]"));
			 if(i==0) {
				 question.click();
				 Thread.sleep(2000);
			 }//emailId
			 WebElement opt1= driver.findElement(By.xpath("//*[contains(@id,\"_answer_1\")]/div"));
			 WebElement opt2= driver.findElement(By.xpath("//*[contains(@id,\"_answer_2\")]/div"));
			 WebElement opt3= driver.findElement(By.xpath("//*[contains(@id,\"_answer_3\")]/div"));
			 WebElement opt4= driver.findElement(By.xpath("//*[contains(@id,\"_answer_4\")]/div"));
	         int correctAns= bank.getCorrectAnswer(question.getText(), opt1.getText(), opt2.getText(), opt3.getText(), opt4.getText());
			 System.out.println("Question==>"+question.getText());
	         System.out.println("CorrectAns==>"+correctAns);
			 WebElement answer= driver.findElement(By.xpath("//*[contains(@id,\"_answer_"+(correctAns+1)+"\")]/div"));
			 answer.click();
			 Thread.sleep(2000);//emailId
			 log.saveAns(question.getText(), correctAns);
			if(i==0) {
				WebElement nextQuestion= driver.findElement(By.xpath("//*[@class=\"btn-group\"]/a[1]"));
				 nextQuestion.click();
				 Thread.sleep(2000);
			}
			else if( i<39) {
			 WebElement nextQuestion= driver.findElement(By.xpath("//*[@class=\"btn-group\"]/a[2]"));
			 nextQuestion.click();
			 Thread.sleep(2000);//emailId
			}
	     }
	     WebElement nextSection= driver.findElement(By.xpath("//*[@class=\"btn-group\"]/button[1]"));
	     nextSection.click();
		 Thread.sleep(2000);//emailId
		 WebElement qsnList1= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div/div[1]/div[1]/div[2]/div/div[2]/button"));
		 qsnList1.click();
	     Thread.sleep(5000);///start-test-btn
	     
	     WebElement firstQsn1= driver.findElement(By.id("quesItem_0"));
	     firstQsn1.click();
	     Thread.sleep(5000);///start-test-btn
	     
	     for(int i=0;i<20;i++) {
			 WebElement question= driver.findElement(By.xpath("//div[@class=\"question-area\"]/div[2]"));
			// Thread.sleep(5000);//emailId
			 WebElement opt1= driver.findElement(By.xpath("//*[contains(@id,\"_answer_1\")]/div"));
			 WebElement opt2= driver.findElement(By.xpath("//*[contains(@id,\"_answer_2\")]/div"));
			 WebElement opt3= driver.findElement(By.xpath("//*[contains(@id,\"_answer_3\")]/div"));
			 WebElement opt4= driver.findElement(By.xpath("//*[contains(@id,\"_answer_4\")]/div"));
	         int correctAns= bank.getCorrectAnswer(question.getText(), opt1.getText(), opt2.getText(), opt3.getText(), opt4.getText());
			 System.out.println("Question==>"+question.getText());
	         System.out.println("CorrectAns==>"+correctAns);
			 WebElement answer= driver.findElement(By.xpath("//*[contains(@id,\"_answer_"+(correctAns+1)+"\")]/div"));
			 answer.click();
			 Thread.sleep(2000);//emailId
				log.saveAns(question.getText(), correctAns);
			if(i==0) {
					WebElement nextQuestion= driver.findElement(By.xpath("//*[@class=\"btn-group\"]/a[1]"));
					 nextQuestion.click();
					 Thread.sleep(2000);
			}
			else if(i<19) {
			 WebElement nextQuestion= driver.findElement(By.xpath("//*[@class=\"btn-group\"]/a[2]"));
			 nextQuestion.click();
			 Thread.sleep(2000);//emailId
			}
	     }
	     
	     
	     WebElement submitTest= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/nav/div[2]/div[1]/a"));
	     submitTest.click();
	     Thread.sleep(5000);// /html/body/div[12]/div/div/div/div/div[3]/div/div/div/button[1]
	     
	     WebElement submitTestF= driver.findElement(By.xpath("/html/body/div[12]/div/div/div/div/div[3]/div/div/div/button[1]"));
	     submitTestF.click();  
	     Thread.sleep(5000);// /html/body/div[12]/div/div/div/div/div[3]/div/div/div/button[1]

         //driver.quit(); dropdownSection
    	}
    	catch(Exception ex) {
    		ex.getStackTrace();
    		System.out.println(ex.getMessage()); //submittest
            log.addMsg(ex.getMessage());
           // log.saveTest(canId, "error");
           // driver.quit();
    	}
    	
		// TODO Auto-generated method stub

	}

}
