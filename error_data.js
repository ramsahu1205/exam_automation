const fs=require("fs");
function getErrorMattle(path){
    const csvData= fs.readFileSync("all_Mercer.csv","utf8");
    const error_data = csvData.split("\n").map((d)=>{
        const [email,url] = d.split(",");
        return {email,url:url?.trim()};
    }).reduce((acc,d)=>{
        acc[d.email]=d;
        return acc;
    },{})
    const list_of_directory =  fs.readdirSync(path); // "C:\\exam_logs\\ginger"
    
    const errorList=list_of_directory.filter((d)=>d.indexOf("error")>=0).map((d)=>{
        return d.replaceAll("_error.json","");
    }).map((d)=>{
        return error_data[d] 
    }).filter((d)=>d)
    return errorList;
}


function getErrorGinger(path){
    const list_of_directory =  fs.readdirSync(path); // "C:\\exam_logs\\ginger"
    
    const errorList=list_of_directory.filter((d)=>d.indexOf("error")>=0).map((d)=>{
        return d.replaceAll("_error.json","");
    })
    return errorList;
}

function getAllFileData(...files){
    let csvData1 = []
    files.forEach((f)=>{
        const csvData= fs.readFileSync(f,"utf8");    
        const loginData = JSON.parse(csvData);
        csvData1=[...csvData1,...loginData]
    })
    return csvData1
}



module.exports = {
    getErrorMattle,
    getErrorGinger,
    getAllFileData
}