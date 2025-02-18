const {executeCmd} = require("./execute_command")
const fs=require("fs");

const csvData= fs.readFileSync("think_exam.csv","utf8");

const canList = JSON.parse(csvData)

function executeApp(can_id){
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
      },30000)
   })
      
}

async function executeAllStudent(){
   console.log("Total execution==>",canList.length)
   for(let i=0;i<canList.length;i++){
      await executeApp(canList[i]);
   }
}

executeAllStudent();