import"./index.e5c655c7.js";function o(o,t,e,n){return fetch(o,{method:t,body:JSON.stringify(e),headers:{"Access-Control-Allow-Origin":"*","Content-Type":"application/json",Authorization:"Bearer "+n}})}function t(o,t){return fetch(o,{method:t,headers:{"Access-Control-Allow-Origin":"*","Content-Type":"application/json;charset=utf-8"}})}function e(o,t){return fetch(o,{method:"GET",headers:{"Access-Control-Allow-Origin":"*","Content-Type":"application/json;charset=utf-8","Access-Control-Allow-Methods":"*","Access-Control-Allow-Credentials":!0,Authorization:"Bearer "+t}})}function n(o){return fetch(o,{method:"GET",headers:{"Access-Control-Allow-Origin":"*","Content-Type":"application/json;charset=utf-8","Access-Control-Allow-Methods":"*","Access-Control-Allow-Credentials":!0}})}export{n as a,o as c,t as d,e as l};
