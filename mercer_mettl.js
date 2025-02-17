const fs=require("fs");
const {executeCmd} = require("./execute_command")

const csvData= fs.readFileSync("mercer_mettl.csv","utf8");

const loginData = csvData.split("\n").map((d)=>{
   const [email,url] = d.split(",");
   return {email,url:url?.trim()};
})

//console.log(loginData);


function executeApp(email,url){
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
       },30000)
    })
       
 }
 
 async function executeAllStudent(){
    for(let i=300;i<loginData.length;i++){
       await executeApp(loginData[i].email,loginData[i].url);
    }
 }
 
 executeAllStudent();

 //executeApp(loginData[0].email,loginData[0].url);