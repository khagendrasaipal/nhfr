import{S as a,i as s,s as e,a as r,e as o,t,z as c,A as l,f as i,g as n,c as d,b as m,d as f,B as p,h as u,j as v,k as h,l as g,D as E,m as b,E as I,n as y,v as w,w as x,F as D,X as V}from"./index.e5c655c7.js";import"./create.be28beed.js";import{N as j,d as L}from"./index.7e2e6ea4.js";import{a as $,g as U}from"./app.5d9269da.js";import{C as A}from"./js.cookie.9f4d6962.js";import"./jquery.719b2463.js";import{baseUrl as B}from"./fetchdata.889125f6.js";import{p as P}from"./api.821fcd38.js";const{document:k}=V;function N(a){let s,e,V,L,$,U,A,B,P,N,T,F,O,S,q,z,C,H,M,R,X,G,J,K,Q,W,Y,Z,_,aa,sa,ea,ra,oa,ta,ca;const la=new j({});return{c(){s=r(),e=o("div"),V=o("div"),L=r(),$=o("div"),U=o("div"),A=o("div"),B=o("h3"),P=t("Api Login"),N=r(),T=o("form"),F=o("input"),O=r(),S=o("div"),q=o("div"),z=o("div"),C=o("label"),H=t("Username"),M=r(),R=o("input"),X=r(),G=o("div"),J=o("div"),K=o("label"),Q=t("Password"),W=r(),Y=o("input"),Z=r(),_=o("div"),aa=o("button"),sa=t("Log In"),ea=r(),c(la.$$.fragment),ra=r(),oa=o("div"),this.h()},l(a){l('[data-svelte="svelte-1w1wnis"]',k.head).forEach(i),s=n(a),e=d(a,"DIV",{class:!0,style:!0});var r=m(e);V=d(r,"DIV",{class:!0}),m(V).forEach(i),L=n(r),$=d(r,"DIV",{class:!0});var o=m($);U=d(o,"DIV",{class:!0,style:!0});var t=m(U);A=d(t,"DIV",{class:!0});var c=m(A);B=d(c,"H3",{align:!0,class:!0});var u=m(B);P=f(u,"Api Login"),u.forEach(i),c.forEach(i),N=n(t),T=d(t,"FORM",{role:!0,id:!0});var v=m(T);F=d(v,"INPUT",{type:!0,value:!0,name:!0,id:!0}),O=n(v),S=d(v,"DIV",{class:!0});var h=m(S);q=d(h,"DIV",{class:!0});var g=m(q);z=d(g,"DIV",{});var E=m(z);C=d(E,"LABEL",{for:!0});var b=m(C);H=f(b,"Username"),b.forEach(i),E.forEach(i),M=n(g),R=d(g,"INPUT",{type:!0,name:!0,id:!0,class:!0,value:!0}),g.forEach(i),X=n(h),G=d(h,"DIV",{class:!0});var I=m(G);J=d(I,"DIV",{});var y=m(J);K=d(y,"LABEL",{for:!0});var w=m(K);Q=f(w,"Password"),w.forEach(i),y.forEach(i),W=n(I),Y=d(I,"INPUT",{type:!0,name:!0,id:!0,class:!0}),I.forEach(i),Z=n(h),_=d(h,"DIV",{class:!0,align:!0});var x=m(_);aa=d(x,"BUTTON",{type:!0,class:!0});var D=m(aa);sa=f(D,"Log In"),D.forEach(i),ea=n(x),p(la.$$.fragment,x),x.forEach(i),h.forEach(i),v.forEach(i),t.forEach(i),o.forEach(i),ra=n(r),oa=d(r,"DIV",{class:!0}),m(oa).forEach(i),r.forEach(i),this.h()},h(){k.title="Api Login",u(V,"class","col-md-4"),u(B,"align","center"),u(B,"class","box-title"),u(A,"class","box-header with-border"),u(F,"type","hidden"),F.value="",u(F,"name","id"),u(F,"id","id"),u(C,"for","exampleInputEmail1"),u(R,"type","text"),u(R,"name","username"),u(R,"id","username"),u(R,"class","form-control col-md-10"),R.value="",u(q,"class","form-group"),u(K,"for","exampleInputEmail1"),u(Y,"type","password"),u(Y,"name","password"),u(Y,"id","password"),u(Y,"class","form-control col-md-10"),u(G,"class","form-group"),u(aa,"type","submit"),u(aa,"class","btn btn-primary"),u(_,"class","box-footer"),u(_,"align","center"),u(S,"class","box-body"),u(T,"role","form"),u(T,"id","form"),u(U,"class","box box-primary col-md-9"),v(U,"background-color","#5cbbde"),u($,"class","col-md-5"),u(oa,"class","col-md-4"),u(e,"class","row col-md-12"),v(e,"margin-top","100px")},m(r,o){h(r,s,o),h(r,e,o),g(e,V),g(e,L),g(e,$),g($,U),g(U,A),g(A,B),g(B,P),g(U,N),g(U,T),g(T,F),g(T,O),g(T,S),g(S,q),g(q,z),g(z,C),g(C,H),g(q,M),g(q,R),g(S,X),g(S,G),g(G,J),g(J,K),g(K,Q),g(G,W),g(G,Y),g(S,Z),g(S,_),g(_,aa),g(aa,sa),g(_,ea),E(la,_,null),g(e,ra),g(e,oa),ta=!0,ca=b(T,"submit",I(a[0]))},p:y,i(a){ta||(w(la.$$.fragment,a),ta=!0)},o(a){x(la.$$.fragment,a),ta=!1},d(a){a&&i(s),a&&i(e),D(la),ca()}}}function T(a){let s=B+"/apiLogin";const{session:e}=$();return[async function(a){var e=document.getElementById("username").value,r=document.getElementById("password").value;const o=await P(s,{email:e,password:r});console.log(o),1==o.Status?(A.set("apiusertoken",o.user.token),A.set("apiuserid",o.user.id),A.set("apiuserfullname",o.user.fullname),A.set("apiuserusername",o.user.username),U("/apiloginsubmitpage")):L("Username and Password donot matched.")}]}export default class extends a{constructor(a){super(),s(this,a,T,N,e,{})}}
