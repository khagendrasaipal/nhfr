import{S as t,i as a,s as e,e as s,t as r,c as o,b as n,d as i,f as c,k as l,l as p,o as f,a as d,O as h,g as u,n as m,Q as g}from"./index.e5c655c7.js";import"./create.bcc8dfec.js";import"./index.02e345fc.js";import"./app.39a58b89.js";import"./_commonjsHelpers.fffabd3b.js";import"./js.cookie.7f372dc7.js";import"./jquery.dc1d5bd8.js";import{baseUrl as j}from"./fetchdata.afb1a114.js";function v(t,a,e){const s=t.slice();return s[8]=a[e],s}function $(t){let a,e,d=t[8].remarks+"";return{c(){a=s("p"),e=r(d)},l(t){a=o(t,"P",{});var s=n(a);e=i(s,d),s.forEach(c)},m(t,s){l(t,a,s),p(a,e)},p(t,a){4&a&&d!==(d=t[8].remarks+"")&&f(e,d)},d(t){t&&c(a)}}}function y(t){let a,e,j,y,k,b,w,E,P,S,x,A,H,N,O,Y,F,L,M,R=t[2],T=[];for(let a=0;a<R.length;a+=1)T[a]=$(v(t,R,a));return{c(){a=s("h2"),e=r("Online Application Status"),j=d(),y=s("p"),k=r("Tracking code: "),b=r(t[3]),w=d(),E=s("p"),P=r("Health Facility Name: "),S=r(t[0]),x=d(),A=s("p"),H=r("Application Status: "),N=r(t[1]),O=d(),Y=s("p"),F=r("Messages:"),L=d();for(let t=0;t<T.length;t+=1)T[t].c();M=h()},l(s){a=o(s,"H2",{});var r=n(a);e=i(r,"Online Application Status"),r.forEach(c),j=u(s),y=o(s,"P",{});var l=n(y);k=i(l,"Tracking code: "),b=i(l,t[3]),l.forEach(c),w=u(s),E=o(s,"P",{});var p=n(E);P=i(p,"Health Facility Name: "),S=i(p,t[0]),p.forEach(c),x=u(s),A=o(s,"P",{});var f=n(A);H=i(f,"Application Status: "),N=i(f,t[1]),f.forEach(c),O=u(s),Y=o(s,"P",{});var d=n(Y);F=i(d,"Messages:"),d.forEach(c),L=u(s);for(let t=0;t<T.length;t+=1)T[t].l(s);M=h()},m(t,s){l(t,a,s),p(a,e),l(t,j,s),l(t,y,s),p(y,k),p(y,b),l(t,w,s),l(t,E,s),p(E,P),p(E,S),l(t,x,s),l(t,A,s),p(A,H),p(A,N),l(t,O,s),l(t,Y,s),p(Y,F),l(t,L,s);for(let a=0;a<T.length;a+=1)T[a].m(t,s);l(t,M,s)},p(t,[a]){if(1&a&&f(S,t[0]),2&a&&f(N,t[1]),4&a){let e;for(R=t[2],e=0;e<R.length;e+=1){const s=v(t,R,e);T[e]?T[e].p(s,a):(T[e]=$(s),T[e].c(),T[e].m(M.parentNode,M))}for(;e<T.length;e+=1)T[e].d(1);T.length=R.length}},i:m,o:m,d(t){t&&c(a),t&&c(j),t&&c(y),t&&c(w),t&&c(E),t&&c(x),t&&c(A),t&&c(O),t&&c(Y),t&&c(L),g(T,t),t&&c(M)}}}function k(t,a,e){const s=new URL(window.location.href);let r,o,n,i=[];const c=new URLSearchParams(s.search).get("trackid");(async()=>{const t=await fetch(j+"/health-registry/gettrack?tid="+c);let a=await t.json(),s=a[0],l=a[1];console.log(l),l&&(e(2,i=l.revs),console.log(i)),e(4,r=s),e(0,o=s.hf_name),1==r.onlinestatus&&e(1,n="Your application is pending for approval."),2==r.onlinestatus&&e(1,n="Your application is approved."),3==r.onlinestatus&&e(1,n="Your application is rejected. "),r.revs&&e(2,i=r.revs),r.status})();return t.$$.update=()=>{t.$$.dirty,t.$$.dirty,t.$$.dirty,t.$$.dirty},[o,n,i,c]}export default class extends t{constructor(t){super(),a(this,t,k,y,e,{})}}
