const fs=require("fs");
const {executeCmd} = require("./execute_command")
const {getErrorMattle,getAllFileData} = require("./error_data")
const loginData= getAllFileData("mettl_exam_13.json");

//const loginData = JSON.parse(csvData);

//console.log(loginData);


function executeApp(email,url,force){
    return new Promise((resolve,reject)=>{
       setTimeout(()=>{
          executeCmd(`mvn exec:java -Dexec.mainClass="com.examtest.logicknots.MercerMettl" -Dexec.args="${email} ${url}"`)
          .then((result)=>{
             console.log("result==>",result)
          })
          .catch((err)=>{
             console.log("Error==>",err)
          })
          resolve(true);
       },force?(60000*5):30000)
    })
       
 }
 
 async function executeAllStudent(){
   console.log("Total execution==>",canList.length)
    for(let i=0;i<loginData.length;i++){
       await executeApp(loginData[i].email,loginData[i].url,(i+1)%15==0);
    }
 }
 
 executeAllStudent();

 //executeApp(loginData[0].email,loginData[0].url);