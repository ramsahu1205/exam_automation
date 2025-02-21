const {executeCmd} = require("./execute_command")
const fs=require("fs");
const {getErrorGinger,getAllFileData} = require("./error_data")
const canList= getAllFileData("think_exam_67.json","think_exam_68.json");

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
      },force?(60000*10):50000)
   })
      }

async function executeAllStudent(){
   console.log("Total execution==>",canList.length)
   for(let i=0;i<canList.length;i++){
      await executeApp(canList[i],(i+1)%15==0);
   }
}

executeAllStudent();