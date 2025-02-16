const { exec} = require("child_process");

function executeCmd(cmd) {
    console.log(cmd);
    return new Promise((resolve, reject) => {
        let ls=exec(cmd);
        ls.stdout.on('data', function (data) {
            console.log(data);
        });
        
        ls.stderr.on('data', function (data) {
            console.log(data);
        });
        
        ls.on('exit', function (code) {
            resolve(code);
        });

    });
}

exports.executeCmd=executeCmd;