import{S as a,i as s,s as e,a as r,e as o,t,z as c,A as l,f as i,g as n,c as d,b as m,d as f,B as p,h as u,j as v,k as h,l as b,D as g,m as E,E as I,n as y,v as w,w as x,F as j,X as D}from"./index.e5c655c7.js";import"./create.bcc8dfec.js";import{N as V,d as L}from"./index.02e345fc.js";import{a as $,g as U}from"./app.8e87bdbb.js";import"./_commonjsHelpers.fffabd3b.js";import{C as A}from"./js.cookie.7f372dc7.js";import"./jquery.dc1d5bd8.js";import{baseUrl as B}from"./fetchdata.afb1a114.js";import{p as P}from"./api.821fcd38.js";const{document:k}=D;function N(a){let s,e,D,L,$,U,A,B,P,N,T,F,H,O,S,q,z,C,M,R,X,_,G,J,K,Q,W,Y,Z,aa,sa,ea,ra,oa,ta,ca;const la=new V({});return{c(){s=r(),e=o("div"),D=o("div"),L=r(),$=o("div"),U=o("div"),A=o("div"),B=o("h3"),P=t("Api Login"),N=r(),T=o("form"),F=o("input"),H=r(),O=o("div"),S=o("div"),q=o("div"),z=o("label"),C=t("Username"),M=r(),R=o("input"),X=r(),_=o("div"),G=o("div"),J=o("label"),K=t("Password"),Q=r(),W=o("input"),Y=r(),Z=o("div"),aa=o("button"),sa=t("Log In"),ea=r(),c(la.$$.fragment),ra=r(),oa=o("div"),this.h()},l(a){l('[data-svelte="svelte-1w1wnis"]',k.head).forEach(i),s=n(a),e=d(a,"DIV",{class:!0,style:!0});var r=m(e);D=d(r,"DIV",{class:!0}),m(D).forEach(i),L=n(r),$=d(r,"DIV",{class:!0});var o=m($);U=d(o,"DIV",{class:!0,style:!0});var t=m(U);A=d(t,"DIV",{class:!0});var c=m(A);B=d(c,"H3",{align:!0,class:!0});var u=m(B);P=f(u,"Api Login"),u.forEach(i),c.forEach(i),N=n(t),T=d(t,"FORM",{role:!0,id:!0});var v=m(T);F=d(v,"INPUT",{type:!0,value:!0,name:!0,id:!0}),H=n(v),O=d(v,"DIV",{class:!0});var h=m(O);S=d(h,"DIV",{class:!0});var b=m(S);q=d(b,"DIV",{});var g=m(q);z=d(g,"LABEL",{for:!0});var E=m(z);C=f(E,"Username"),E.forEach(i),g.forEach(i),M=n(b),R=d(b,"INPUT",{type:!0,name:!0,id:!0,class:!0,value:!0}),b.forEach(i),X=n(h),_=d(h,"DIV",{class:!0});var I=m(_);G=d(I,"DIV",{});var y=m(G);J=d(y,"LABEL",{for:!0});var w=m(J);K=f(w,"Password"),w.forEach(i),y.forEach(i),Q=n(I),W=d(I,"INPUT",{type:!0,name:!0,id:!0,class:!0}),I.forEach(i),Y=n(h),Z=d(h,"DIV",{class:!0,align:!0});var x=m(Z);aa=d(x,"BUTTON",{type:!0,class:!0});var j=m(aa);sa=f(j,"Log In"),j.forEach(i),ea=n(x),p(la.$$.fragment,x),x.forEach(i),h.forEach(i),v.forEach(i),t.forEach(i),o.forEach(i),ra=n(r),oa=d(r,"DIV",{class:!0}),m(oa).forEach(i),r.forEach(i),this.h()},h(){k.title="Api Login",u(D,"class","col-md-4"),u(B,"align","center"),u(B,"class","box-title"),u(A,"class","box-header with-border"),u(F,"type","hidden"),F.value="",u(F,"name","id"),u(F,"id","id"),u(z,"for","exampleInputEmail1"),u(R,"type","text"),u(R,"name","username"),u(R,"id","username"),u(R,"class","form-control col-md-10"),R.value="",u(S,"class","form-group"),u(J,"for","exampleInputEmail1"),u(W,"type","password"),u(W,"name","password"),u(W,"id","password"),u(W,"class","form-control col-md-10"),u(_,"class","form-group"),u(aa,"type","submit"),u(aa,"class","btn btn-primary"),u(Z,"class","box-footer"),u(Z,"align","center"),u(O,"class","box-body"),u(T,"role","form"),u(T,"id","form"),u(U,"class","box box-primary col-md-9"),v(U,"background-color","#5cbbde"),u($,"class","col-md-5"),u(oa,"class","col-md-4"),u(e,"class","row col-md-12"),v(e,"margin-top","100px")},m(r,o){h(r,s,o),h(r,e,o),b(e,D),b(e,L),b(e,$),b($,U),b(U,A),b(A,B),b(B,P),b(U,N),b(U,T),b(T,F),b(T,H),b(T,O),b(O,S),b(S,q),b(q,z),b(z,C),b(S,M),b(S,R),b(O,X),b(O,_),b(_,G),b(G,J),b(J,K),b(_,Q),b(_,W),b(O,Y),b(O,Z),b(Z,aa),b(aa,sa),b(Z,ea),g(la,Z,null),b(e,ra),b(e,oa),ta=!0,ca=E(T,"submit",I(a[0]))},p:y,i(a){ta||(w(la.$$.fragment,a),ta=!0)},o(a){x(la.$$.fragment,a),ta=!1},d(a){a&&i(s),a&&i(e),j(la),ca()}}}function T(a){let s=B+"/apiLogin";const{session:e}=$();return[async function(a){var e=document.getElementById("username").value,r=document.getElementById("password").value;const o=await P(s,{email:e,password:r});console.log(o),1==o.Status?(A.set("apiusertoken",o.user.token),A.set("apiuserid",o.user.id),A.set("apiuserfullname",o.user.fullname),A.set("apiuserusername",o.user.username),U("/apiloginsubmitpage")):L("Username and Password donot matched.")}]}export default class extends a{constructor(a){super(),s(this,a,T,N,e,{})}}
