import{S as a,i as s,s as e,e as r,a as o,t,z as c,c as i,b as l,f as n,g as d,d as m,B as f,h as p,j as u,k as v,l as h,D as b,m as g,E,n as I,v as y,w,F as x}from"./index.e5c655c7.js";import"./create.bcc8dfec.js";import{N as D,d as j}from"./index.02e345fc.js";import"./app.713904b4.js";import"./_commonjsHelpers.fffabd3b.js";import{C as V}from"./js.cookie.7f372dc7.js";import"./jquery.dc1d5bd8.js";import{baseUrl as $}from"./fetchdata.afb1a114.js";import"./index.9bb96efd.js";import{p as U}from"./api.821fcd38.js";function B(a){let s,e,j,V,$,U,B,L,P,T,k,N,S,A,F,H,O,q,z,C,M,R,_,G,J,K,Q,W,X,Y,Z,aa,sa,ea,ra;const oa=new D({});return{c(){s=r("div"),e=r("div"),j=o(),V=r("div"),$=r("div"),U=r("div"),B=r("h3"),L=t("Sign in"),P=o(),T=r("form"),k=r("input"),N=o(),S=r("div"),A=r("div"),F=r("div"),H=r("label"),O=t("Username"),q=o(),z=r("input"),C=o(),M=r("div"),R=r("div"),_=r("label"),G=t("Password"),J=o(),K=r("input"),Q=o(),c(oa.$$.fragment),W=o(),X=r("div"),Y=r("button"),Z=t("Log In"),aa=o(),sa=r("div"),this.h()},l(a){s=i(a,"DIV",{class:!0,style:!0});var r=l(s);e=i(r,"DIV",{class:!0}),l(e).forEach(n),j=d(r),V=i(r,"DIV",{class:!0});var o=l(V);$=i(o,"DIV",{class:!0,style:!0});var t=l($);U=i(t,"DIV",{class:!0});var c=l(U);B=i(c,"H3",{align:!0,class:!0});var p=l(B);L=m(p,"Sign in"),p.forEach(n),c.forEach(n),P=d(t),T=i(t,"FORM",{role:!0,id:!0});var u=l(T);k=i(u,"INPUT",{type:!0,value:!0,name:!0,id:!0}),N=d(u),S=i(u,"DIV",{class:!0});var v=l(S);A=i(v,"DIV",{class:!0});var h=l(A);F=i(h,"DIV",{});var b=l(F);H=i(b,"LABEL",{for:!0});var g=l(H);O=m(g,"Username"),g.forEach(n),b.forEach(n),q=d(h),z=i(h,"INPUT",{type:!0,name:!0,id:!0,class:!0,value:!0}),h.forEach(n),C=d(v),M=i(v,"DIV",{class:!0});var E=l(M);R=i(E,"DIV",{});var I=l(R);_=i(I,"LABEL",{for:!0});var y=l(_);G=m(y,"Password"),y.forEach(n),I.forEach(n),J=d(E),K=i(E,"INPUT",{type:!0,name:!0,id:!0,class:!0}),E.forEach(n),Q=d(v),f(oa.$$.fragment,v),W=d(v),X=i(v,"DIV",{class:!0,align:!0});var w=l(X);Y=i(w,"BUTTON",{type:!0,class:!0});var x=l(Y);Z=m(x,"Log In"),x.forEach(n),w.forEach(n),v.forEach(n),u.forEach(n),t.forEach(n),o.forEach(n),aa=d(r),sa=i(r,"DIV",{class:!0}),l(sa).forEach(n),r.forEach(n),this.h()},h(){p(e,"class","col-md-4"),p(B,"align","center"),p(B,"class","box-title"),p(U,"class","box-header with-border"),p(k,"type","hidden"),k.value="",p(k,"name","id"),p(k,"id","id"),p(H,"for","exampleInputEmail1"),p(z,"type","text"),p(z,"name","email"),p(z,"id","email"),p(z,"class","form-control col-md-10"),z.value="",p(A,"class","form-group"),p(_,"for","exampleInputEmail1"),p(K,"type","password"),p(K,"name","password"),p(K,"id","password"),p(K,"class","form-control col-md-10"),p(M,"class","form-group"),p(Y,"type","submit"),p(Y,"class","btn btn-primary"),p(X,"class","box-footer"),p(X,"align","center"),p(S,"class","box-body"),p(T,"role","form"),p(T,"id","form"),p($,"class","box box-primary col-md-9"),u($,"background-color","#5cbbde"),p(V,"class","col-md-5"),p(sa,"class","col-md-4"),p(s,"class","row col-md-12"),u(s,"margin-top","100px")},m(r,o){v(r,s,o),h(s,e),h(s,j),h(s,V),h(V,$),h($,U),h(U,B),h(B,L),h($,P),h($,T),h(T,k),h(T,N),h(T,S),h(S,A),h(A,F),h(F,H),h(H,O),h(A,q),h(A,z),h(S,C),h(S,M),h(M,R),h(R,_),h(_,G),h(M,J),h(M,K),h(S,Q),b(oa,S,null),h(S,W),h(S,X),h(X,Y),h(Y,Z),h(s,aa),h(s,sa),ea=!0,ra=g(T,"submit",E(a[0]))},p:I,i(a){ea||(y(oa.$$.fragment,a),ea=!0)},o(a){w(oa.$$.fragment,a),ea=!1},d(a){a&&n(s),x(oa),ra()}}}function L(a){let s=$+"/login/user";return[async function(a){var e=document.getElementById("email").value,r=document.getElementById("password").value;const o=await U(s,{email:e,password:r});if(console.log(o),1==o.Status){var t=new Date((new Date).getTime()+3e7);V.set("uid",o.user.id),V.set("token",o.user.token,{expires:t}),V.set("username",o.user.username),V.set("role",o.user.role),V.set("province",o.user.province),V.set("district",o.user.district),V.set("municipality",o.user.municipality),V.set("orgid",o.user.orgid),window.location.replace(".")}else j("Username and Password donot matched.")}]}export default class extends a{constructor(a){super(),s(this,a,L,B,e,{})}}
