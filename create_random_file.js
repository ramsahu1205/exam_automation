const fs=require("fs");
function random(max){
  return  Math.round(Math.random()*1000)%max;
}


function genrateRandomData(ele){
    const newELe=[];
    while(ele.length>0){
       const index=random(ele.length);
       newELe.push(ele[index]);
       ele=ele.filter((d,i)=>i!=index);
    }
    return newELe;
}


function genrateFiles(folder,prefix,data,limit){
    let count=1;
    while(data.length>0){
        const list1= data.splice(0,limit);
        fs.writeFileSync(folder+"/"+ prefix+"_"+count+".json",JSON.stringify(list1),"utf8")
        count++;
    }
}




function create_mercer_mettl_random(){
    const csvData= fs.readFileSync("Mercer_all.csv","utf8");

    const loginData = csvData.split("\n").map((d)=>{
       const [email,url] = d.split(",");
       return {email,url:url?.trim()};
    })
  
    console.log("ele length==>",loginData.length);
    const newELe=genrateRandomData(loginData);
    console.log("new ele length==>",newELe.length);

    console.log("new ele length==>",newELe.length);
    genrateFiles("mettl","mettl_exam",newELe,300);


}


function create_thik_exam_random(){
    const csvData= fs.readFileSync("thik_all.txt","utf8");

    const loginData = csvData.split("\n").map((d)=>{
       return d?.trim();
    })
  
    console.log("ele length==>",loginData.length);
    const newELe=genrateRandomData(loginData);
    console.log("new ele length==>",newELe.length);
    genrateFiles("think","think_exam",newELe,300);

}

create_mercer_mettl_random();
create_thik_exam_random()