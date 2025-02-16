const {executeCmd} = require("./execute_command")
let canList=["CAN35139189 ",
"CAN35139183",
"CAN35139146",
"CAN35139145",
"CAN35139140",
"CAN35139138",
"CAN35139136",
"CAN35139135",
"CAN35139130",
"CAN35139127",
"CAN35139118",
"CAN35139117",
"CAN35139113",
"CAN35139110",
"CAN35139104",
"CAN35139103"]

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
      },25000)
   })
      
}

async function executeAllStudent(){
   for(let i=0;i<canList.length;i++){
      await executeApp(canList[i]);
   }
}

executeAllStudent();