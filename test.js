const {getErrorGinger,getErrorMattle} = require("./error_data")

let data=getErrorGinger("C:\\exam_logs\\ginger");
let m_data = getErrorMattle("C:\\exam_logs\\mercer_mettl")
console.log(m_data);