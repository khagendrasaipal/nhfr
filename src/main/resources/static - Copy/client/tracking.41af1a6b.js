import{S as t,i as a,s as e,e as s,t as r,c as o,b as n,d as i,f as c,k as l,l as p,o as f,a as h,O as u,g as d,n as g,Q as m}from"./index.e5c655c7.js";import"./create.15ee5e82.js";import"./index.72429f81.js";import"./app.3bf82e24.js";import"./js.cookie.a0f74474.js";import"./jquery.84830057.js";import{baseUrl as j}from"./fetchdata.0fb6c2af.js";function v(t,a,e){const s=t.slice();return s[8]=a[e],s}function $(t){let a,e,h=t[8].remarks+"";return{c(){a=s("p"),e=r(h)},l(t){a=o(t,"P",{});var s=n(a);e=i(s,h),s.forEach(c)},m(t,s){l(t,a,s),p(a,e)},p(t,a){4&a&&h!==(h=t[8].remarks+"")&&f(e,h)},d(t){t&&c(a)}}}function y(t){let a,e,j,y,k,w,E,P,S,x,A,b,H,N,O,Y,F,L,M,R=t[2],T=[];for(let a=0;a<R.length;a+=1)T[a]=$(v(t,R,a));return{c(){a=s("h2"),e=r("Online Application Status"),j=h(),y=s("p"),k=r("Tracking code: "),w=r(t[3]),E=h(),P=s("p"),S=r("Health Facility Name: "),x=r(t[0]),A=h(),b=s("p"),H=r("Application Status: "),N=r(t[1]),O=h(),Y=s("p"),F=r("Messages:"),L=h();for(let t=0;t<T.length;t+=1)T[t].c();M=u()},l(s){a=o(s,"H2",{});var r=n(a);e=i(r,"Online Application Status"),r.forEach(c),j=d(s),y=o(s,"P",{});var l=n(y);k=i(l,"Tracking code: "),w=i(l,t[3]),l.forEach(c),E=d(s),P=o(s,"P",{});var p=n(P);S=i(p,"Health Facility Name: "),x=i(p,t[0]),p.forEach(c),A=d(s),b=o(s,"P",{});var f=n(b);H=i(f,"Application Status: "),N=i(f,t[1]),f.forEach(c),O=d(s),Y=o(s,"P",{});var h=n(Y);F=i(h,"Messages:"),h.forEach(c),L=d(s);for(let t=0;t<T.length;t+=1)T[t].l(s);M=u()},m(t,s){l(t,a,s),p(a,e),l(t,j,s),l(t,y,s),p(y,k),p(y,w),l(t,E,s),l(t,P,s),p(P,S),p(P,x),l(t,A,s),l(t,b,s),p(b,H),p(b,N),l(t,O,s),l(t,Y,s),p(Y,F),l(t,L,s);for(let a=0;a<T.length;a+=1)T[a].m(t,s);l(t,M,s)},p(t,[a]){if(1&a&&f(x,t[0]),2&a&&f(N,t[1]),4&a){let e;for(R=t[2],e=0;e<R.length;e+=1){const s=v(t,R,e);T[e]?T[e].p(s,a):(T[e]=$(s),T[e].c(),T[e].m(M.parentNode,M))}for(;e<T.length;e+=1)T[e].d(1);T.length=R.length}},i:g,o:g,d(t){t&&c(a),t&&c(j),t&&c(y),t&&c(E),t&&c(P),t&&c(A),t&&c(b),t&&c(O),t&&c(Y),t&&c(L),m(T,t),t&&c(M)}}}function k(t,a,e){const s=new URL(window.location.href);let r,o,n,i=[];const c=new URLSearchParams(s.search).get("trackid");(async()=>{const t=await fetch(j+"/health-registry/gettrack?tid="+c);let a=await t.json(),s=a[0],l=a[1];console.log(l),l&&(e(2,i=l.revs),console.log(i)),e(4,r=s),e(0,o=s.hf_name),1==r.onlinestatus&&e(1,n="Your application is pending for approval."),2==r.onlinestatus&&e(1,n="Your application is approved."),3==r.onlinestatus&&e(1,n="Your application is rejected. "),r.revs&&e(2,i=r.revs),r.status})();return t.$$.update=()=>{t.$$.dirty,t.$$.dirty,t.$$.dirty,t.$$.dirty},[o,n,i,c]}export default class extends t{constructor(t){super(),a(this,t,k,y,e,{})}}
