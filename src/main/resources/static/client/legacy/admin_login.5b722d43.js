import{a,b as s,c as r,d as e,i as o,s as t,e as i,S as n,f as c,g as l,t as d,F as m,h as f,j as u,l as p,m as v,k as h,H as b,o as y,p as E,q as g,r as I,J as w,u as x,K as j,n as D,A as V,B as T,L as $}from"./index.0c22fd66.js";import"./slicedToArray.f13a096f.js";import{_ as L,a as P}from"./asyncToGenerator.c4edb546.js";import"./create.ae49f39d.js";import{N as U,d as k}from"./index.33a6d4f8.js";import"./app.390ac8b7.js";import{C as B}from"./js.cookie.e6b006aa.js";import"./jquery.ca35874e.js";import"./defineProperty.b786bad4.js";import{baseUrl as N}from"./fetchdata.8e40b9d2.js";import"./index.9d3d9637.js";import{p as A}from"./api.395cacab.js";function S(a){var s,r,e,o,t,i,n,L,P,k,B,N,A,S,q,F,H,O,C,G,J,K,M,R,_,z,Q,W,X,Y,Z,aa,sa,ra,ea,oa=new U({});return{c:function(){s=c("div"),r=c("div"),e=l(),o=c("div"),t=c("div"),i=c("div"),n=c("h3"),L=d("Sign in"),P=l(),k=c("form"),B=c("input"),N=l(),A=c("div"),S=c("div"),q=c("div"),F=c("label"),H=d("Username"),O=l(),C=c("input"),G=l(),J=c("div"),K=c("div"),M=c("label"),R=d("Password"),_=l(),z=c("input"),Q=l(),m(oa.$$.fragment),W=l(),X=c("div"),Y=c("button"),Z=d("Log In"),aa=l(),sa=c("div"),this.h()},l:function(a){s=f(a,"DIV",{class:!0,style:!0});var c=u(s);r=f(c,"DIV",{class:!0}),u(r).forEach(p),e=v(c),o=f(c,"DIV",{class:!0});var l=u(o);t=f(l,"DIV",{class:!0,style:!0});var d=u(t);i=f(d,"DIV",{class:!0});var m=u(i);n=f(m,"H3",{align:!0,class:!0});var y=u(n);L=h(y,"Sign in"),y.forEach(p),m.forEach(p),P=v(d),k=f(d,"FORM",{role:!0,id:!0});var E=u(k);B=f(E,"INPUT",{type:!0,value:!0,name:!0,id:!0}),N=v(E),A=f(E,"DIV",{class:!0});var g=u(A);S=f(g,"DIV",{class:!0});var I=u(S);q=f(I,"DIV",{});var w=u(q);F=f(w,"LABEL",{for:!0});var x=u(F);H=h(x,"Username"),x.forEach(p),w.forEach(p),O=v(I),C=f(I,"INPUT",{type:!0,name:!0,id:!0,class:!0,value:!0}),I.forEach(p),G=v(g),J=f(g,"DIV",{class:!0});var j=u(J);K=f(j,"DIV",{});var D=u(K);M=f(D,"LABEL",{for:!0});var V=u(M);R=h(V,"Password"),V.forEach(p),D.forEach(p),_=v(j),z=f(j,"INPUT",{type:!0,name:!0,id:!0,class:!0}),j.forEach(p),Q=v(g),b(oa.$$.fragment,g),W=v(g),X=f(g,"DIV",{class:!0,align:!0});var T=u(X);Y=f(T,"BUTTON",{type:!0,class:!0});var $=u(Y);Z=h($,"Log In"),$.forEach(p),T.forEach(p),g.forEach(p),E.forEach(p),d.forEach(p),l.forEach(p),aa=v(c),sa=f(c,"DIV",{class:!0}),u(sa).forEach(p),c.forEach(p),this.h()},h:function(){y(r,"class","col-md-4"),y(n,"align","center"),y(n,"class","box-title"),y(i,"class","box-header with-border"),y(B,"type","hidden"),B.value="",y(B,"name","id"),y(B,"id","id"),y(F,"for","exampleInputEmail1"),y(C,"type","text"),y(C,"name","email"),y(C,"id","email"),y(C,"class","form-control col-md-10"),C.value="",y(S,"class","form-group"),y(M,"for","exampleInputEmail1"),y(z,"type","password"),y(z,"name","password"),y(z,"id","password"),y(z,"class","form-control col-md-10"),y(J,"class","form-group"),y(Y,"type","submit"),y(Y,"class","btn btn-primary"),y(X,"class","box-footer"),y(X,"align","center"),y(A,"class","box-body"),y(k,"role","form"),y(k,"id","form"),y(t,"class","box box-primary col-md-9"),E(t,"background-color","#5cbbde"),y(o,"class","col-md-5"),y(sa,"class","col-md-4"),y(s,"class","row col-md-12"),E(s,"margin-top","100px")},m:function(c,l){g(c,s,l),I(s,r),I(s,e),I(s,o),I(o,t),I(t,i),I(i,n),I(n,L),I(t,P),I(t,k),I(k,B),I(k,N),I(k,A),I(A,S),I(S,q),I(q,F),I(F,H),I(S,O),I(S,C),I(A,G),I(A,J),I(J,K),I(K,M),I(M,R),I(J,_),I(J,z),I(A,Q),w(oa,A,null),I(A,W),I(A,X),I(X,Y),I(Y,Z),I(s,aa),I(s,sa),ra=!0,ea=x(k,"submit",j(a[0]))},p:D,i:function(a){ra||(V(oa.$$.fragment,a),ra=!0)},o:function(a){T(oa.$$.fragment,a),ra=!1},d:function(a){a&&p(s),$(oa),ea()}}}function q(a){var s=N+"/login/user";function r(){return(r=L(P.mark((function a(r){var e,o,t,i;return P.wrap((function(a){for(;;)switch(a.prev=a.next){case 0:return e=document.getElementById("email").value,o=document.getElementById("password").value,a.next=4,A(s,{email:e,password:o});case 4:t=a.sent,console.log(t),1==t.Status?(i=new Date((new Date).getTime()+3e7),B.set("uid",t.user.id),B.set("token",t.user.token,{expires:i}),B.set("username",t.user.username),B.set("role",t.user.role),B.set("province",t.user.province),B.set("district",t.user.district),B.set("municipality",t.user.municipality),window.location.replace(".")):k("Username and Password donot matched.");case 7:case"end":return a.stop()}}),a)})))).apply(this,arguments)}return[function(a){return r.apply(this,arguments)}]}var F=function(c){function l(a){var n;return s(this,l),n=r(this,e(l).call(this)),o(i(n),a,q,S,t,{}),n}return a(l,n),l}();export default F;
