import{s as n,n as t,a,b as s,c as i,d as o,i as r,e,S as c,f as u,t as f,g as l,h as d,j as h,k as g,l as v,m,o as p,p as b,q as y,r as k,u as w,v as E,w as j,x,y as A,z as D,A as I,B as L,C as V,D as q,E as z}from"./index.0c22fd66.js";import{_ as B}from"./slicedToArray.f13a096f.js";import"./create.ae49f39d.js";var C=[];function M(a){var s,i=arguments.length>1&&void 0!==arguments[1]?arguments[1]:t,o=[];function r(t){if(n(a,t)&&(a=t,s)){for(var i=!C.length,r=0;r<o.length;r+=1){var e=o[r];e[1](),C.push(e,a)}if(i){for(var c=0;c<C.length;c+=2)C[c][0](C[c+1]);C.length=0}}}return{set:r,update:function(n){r(n(a))},subscribe:function(n){var e=[n,arguments.length>1&&void 0!==arguments[1]?arguments[1]:t];return o.push(e),1===o.length&&(s=i(r)||t),n(a),function(){var n=o.indexOf(e);-1!==n&&o.splice(n,1),0===o.length&&(s(),s=null)}}}}var N=M();function O(n,t,a){var s=n.slice();return s[8]=t[a],s}function S(n,t){var a,s,i,o,r,e,c,x,A,D=t[8].msg+"";function I(){for(var n,a=arguments.length,s=new Array(a),i=0;i<a;i++)s[i]=arguments[i];return((n=t)[7].apply(n,[t[8]].concat(s)))}return{key:n,first:null,c:function(){a=u("li"),s=u("div"),i=f(D),o=l(),r=u("div"),e=l(),this.h()},l:function(n){a=d(n,"LI",{class:!0,style:!0});var t=h(a);s=d(t,"DIV",{class:!0});var c=h(s);i=g(c,D),c.forEach(v),o=m(t),r=d(t,"DIV",{class:!0,style:!0}),h(r).forEach(v),e=m(t),t.forEach(v),this.h()},h:function(){p(s,"class","content svelte-1ggskci"),p(r,"class","progress svelte-1ggskci"),b(r,"animation-duration",t[8].timeout+"ms"),p(a,"class","toast svelte-1ggskci"),b(a,"background",t[8].background),this.first=a},m:function(n,t){y(n,a,t),k(a,s),k(s,i),k(a,o),k(a,r),k(a,e),x=!0,A=w(r,"animationend",I)},p:function(n,s){t=n,(!x||1&s)&&D!==(D=t[8].msg+"")&&E(i,D),(!x||1&s)&&b(r,"animation-duration",t[8].timeout+"ms"),(!x||1&s)&&b(a,"background",t[8].background)},i:function(n){x||(c&&c.end(1),x=!0)},o:function(n){c=j(a,U,{}),x=!1},d:function(n){n&&v(a),n&&c&&c.end(),A()}}}function T(n){for(var t,a,s=[],i=new Map,o=n[0],r=function(n){return n[8].id},e=0;e<o.length;e+=1){var c=O(n,o,e),f=r(c);i.set(f,s[e]=S(f,c))}return{c:function(){t=u("ul");for(var n=0;n<s.length;n+=1)s[n].c();this.h()},l:function(n){t=d(n,"UL",{class:!0});for(var a=h(t),i=0;i<s.length;i+=1)s[i].l(a);a.forEach(v),this.h()},h:function(){p(t,"class","toasts svelte-1ggskci")},m:function(n,i){y(n,t,i);for(var o=0;o<s.length;o+=1)s[o].m(t,null);a=!0},p:function(n,a){var o=B(a,1)[0],e=n[0];x(),s=A(s,o,r,1,n,e,i,t,q,S,null,O),D()},i:function(n){if(!a){for(var t=0;t<o.length;t+=1)I(s[t]);a=!0}},o:function(n){for(var t=0;t<s.length;t+=1)L(s[t]);a=!1},d:function(n){n&&v(t);for(var a=0;a<s.length;a+=1)s[a].d()}}}function U(n,t){var a=t.delay,s=void 0===a?0:a,i=t.duration;return{delay:s,duration:void 0===i?300:i,css:function(n){return"opacity: ".concat(1*(n-.5),"; transform-origin: top right; transform: scaleX(").concat(1*(n-.5),");")}}}function X(n,t,a){var s,i=t.themes,o=void 0===i?{danger:"#bb2124",success:"#22bb33",warning:"#f0ad4e",info:"#5bc0de",default:"#aaaaaa"}:i,r=t.timeout,e=void 0===r?3e3:r,c=0,u=[];function f(n,t,s){var i=o[t]||o.default;a(0,u=[{id:c,msg:n,background:i,timeout:s||e,width:"100%"}].concat(z(u))),c+=1}function l(n){a(0,u=u.filter((function(t){return t.id!=n})))}s=N.subscribe((function(n){n&&(f(n.message,n.type,n.timeout),N.set())})),V(s);return n.$set=function(n){"themes"in n&&a(2,o=n.themes),"timeout"in n&&a(3,e=n.timeout)},[u,l,o,e,c,s,f,function(n){return l(n.id)}]}var $=function(t){function u(t){var a;return s(this,u),a=i(this,o(u).call(this)),r(e(a),t,X,T,n,{themes:2,timeout:3}),a}return a(u,c),u}();function _(n){var t=arguments.length>1&&void 0!==arguments[1]?arguments[1]:"default",a=arguments.length>2?arguments[2]:void 0;N.set({type:t,message:n,timeout:a})}function F(n,t){_(n,"danger",t)}function G(n,t){_(n,"success",t)}export{$ as N,F as d,G as s,M as w};
