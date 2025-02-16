const {executeCmd} = require("./execute_command")

executeCmd(`mvn exec:java -Dexec.mainClass="com.examtest.logicknots.App" -Dexec.args="CAN35139260"`)
.then((result)=>{
   console.log("result==>",result)
})
.catch((err)=>{
   console.log("Error==>",err)
})