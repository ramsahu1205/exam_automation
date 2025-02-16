package com.examtest.logicknots;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

class LogDetails{
	List<String> msg=new ArrayList<>();
	List<Map<String , String>> qsn = new ArrayList<>();
	public List<String> getMsg() {
		return msg;
	}
	public void setMsg(List<String> msg) {
		this.msg = msg;
	}
	public List<Map<String, String>> getQsn() {
		return qsn;
	}
	public void setQsn(List<Map<String, String>> qsn) {
		this.qsn = qsn;
	}
}


public class Logger {
	LogDetails logs=null;
	String path="";
    public Logger(String path) {
	 logs=new LogDetails();
	 this.path=path;
    }
    public void addMsg(String msg){
    	logs.msg.add(msg);
    }
    
    public void saveAns(String Q,int A) {
    	Map<String,String> q1=new HashMap<>();
    	q1.put("Q", Q);
    	q1.put("A", A+"");
    	 logs.qsn.add(q1);
    }
    
    public void saveTest(String canId,String status) {
    	 try {
    	      FileWriter myWriter = new FileWriter(this.path+"/"+canId+"_"+status+".json");
    	      Gson gson=new Gson();
    	      String jsonData=gson.toJson(logs);
    	      myWriter.write(jsonData);
    	      myWriter.close();
    	      System.out.println("Successfully wrote to the file.");
    	    } catch (IOException e) {
    	      System.out.println("An error occurred.");
    	      e.printStackTrace();
    	    }
    }
}
