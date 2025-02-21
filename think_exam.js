const {executeCmd} = require("./execute_command")
const fs=require("fs");
const {getErrorGinger,getAllFileData} = require("./error_data")
const csvData= getAllFileData("think_exam_7.json");
const canList = JSON.parse(csvData)

function executeApp(can_id,force){
   return new Promise((resolve,reject)=>{
      setTimeout(()=>{
         executeCmd(`mvn exec:java -Dexec.mainClass="com.examtest.logicknots.App" -Dexec.args="${can_id}"`)
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
   for(let i=50;i<canList.length;i++){
      await executeApp(canList[i]);
   }
}

executeAllStudent();