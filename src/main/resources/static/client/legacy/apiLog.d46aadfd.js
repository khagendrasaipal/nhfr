import{a,b as t,c as r,d as e,i as o,s,e as c,S as n,f as i,t as l,g as f,h as d,j as h,k as u,l as v,m as p,q as m,r as g,v as b,G as E,H as I,I as T,o as y,p as j,K as x,u as D,L as w,a4 as _,A as S,B as O,Z as P,M as R,N as L,n as N}from"./index.93415519.js";import{_ as B}from"./slicedToArray.654f1255.js";import"./_commonjsHelpers.fffabd3b.js";import{_ as H,a as k}from"./asyncToGenerator.7c85ec32.js";import{l as A}from"./create.6718c41c.js";import"./index.d400a0a9.js";import{C as V}from"./js.cookie.16c010e5.js";import{j as $}from"./jquery.d05c5983.js";import{baseUrl as U}from"./fetchdata.59a14e41.js";import{L as C,p as z}from"./index.2c878162.js";function F(a,t,r){var e=a.slice();return e[10]=t[r],e}function q(a){var t,r,e=a[10].caseid+"";return{c:function(){t=i("td"),r=l(e)},l:function(a){t=d(a,"TD",{});var o=h(t);r=u(o,e),o.forEach(v)},m:function(a,e){m(a,t,e),g(t,r)},p:function(a,t){4&t&&e!==(e=a[10].caseid+"")&&b(r,e)},d:function(a){a&&v(t)}}}function M(a){var t,r;return{c:function(){t=i("td"),r=l("-")},l:function(a){t=d(a,"TD",{});var e=h(t);r=u(e,"-"),e.forEach(v)},m:function(a,e){m(a,t,e),g(t,r)},p:N,d:function(a){a&&v(t)}}}function G(a){var t,r,e,o,s,c,n,E,I,T,y,j,x,D,w,_,S=a[10].id+"",O=a[10].userid+"",P=a[10].action+"",R=a[10].url+"",L=a[10].created_at+"";function N(a,t){return 0==a[10].caseid?M:q}var B=N(a),H=B(a);return{c:function(){t=i("tr"),r=i("td"),e=l(S),o=f(),s=i("td"),c=l(O),n=f(),E=i("td"),I=l(P),T=f(),y=i("td"),j=l(R),x=f(),H.c(),D=f(),w=i("td"),_=l(L)},l:function(a){t=d(a,"TR",{});var i=h(t);r=d(i,"TD",{});var l=h(r);e=u(l,S),l.forEach(v),o=p(i),s=d(i,"TD",{});var f=h(s);c=u(f,O),f.forEach(v),n=p(i),E=d(i,"TD",{});var m=h(E);I=u(m,P),m.forEach(v),T=p(i),y=d(i,"TD",{});var g=h(y);j=u(g,R),g.forEach(v),x=p(i),H.l(i),D=p(i),w=d(i,"TD",{});var b=h(w);_=u(b,L),b.forEach(v),i.forEach(v)},m:function(a,i){m(a,t,i),g(t,r),g(r,e),g(t,o),g(t,s),g(s,c),g(t,n),g(t,E),g(E,I),g(t,T),g(t,y),g(y,j),g(t,x),H.m(t,null),g(t,D),g(t,w),g(w,_)},p:function(a,r){4&r&&S!==(S=a[10].id+"")&&b(e,S),4&r&&O!==(O=a[10].userid+"")&&b(c,O),4&r&&P!==(P=a[10].action+"")&&b(I,P),4&r&&R!==(R=a[10].url+"")&&b(j,R),B===(B=N(a))&&H?H.p(a,r):(H.d(1),(H=B(a))&&(H.c(),H.m(t,D))),4&r&&L!==(L=a[10].created_at+"")&&b(_,L)},d:function(a){a&&v(t),H.d()}}}function K(a){for(var t,r,e,o,s,c,n,N,H,k,A,V,$,U,z,q,M,K,Z,J,Q,X,Y,aa,ta,ra,ea,oa,sa,ca,na,ia,la,fa,da,ha,ua,va,pa,ma,ga,ba,Ea,Ia,Ta,ya,ja,xa,Da,wa,_a,Sa,Oa,Pa,Ra,La,Na,Ba,Ha,ka,Aa,Va,$a,Ua,Ca,za,Fa,qa,Ma,Ga,Ka,Wa,Za,Ja,Qa,Xa,Ya,at,tt,rt,et,ot=(a[1]-1)*W+1+"",st=(a[1]-1)*W+a[2].length+"",ct=a[0].length+"",nt=a[2],it=[],lt=0;lt<nt.length;lt+=1)it[lt]=G(F(a,nt,lt));var ft=new C({props:{totalItems:a[0].length,pageSize:W,currentPage:a[1],limit:1,showStepOptions:!0}});return ft.$on("setPage",a[8]),{c:function(){t=i("link"),r=i("script"),e=f(),o=i("div"),s=i("div"),c=i("h3"),n=l("List of API Log"),N=f(),H=i("div"),k=i("button"),A=i("i"),V=f(),$=i("button"),U=i("i"),z=f(),q=i("div"),M=i("div"),K=i("div"),Z=i("form"),J=i("b"),Q=l("SHOW"),X=f(),Y=i("select"),aa=i("option"),ta=l("10"),ra=i("option"),ea=l("20"),oa=i("option"),sa=l("100"),ca=f(),na=i("b"),ia=l("ENTRIES"),la=f(),fa=i("div"),da=i("form"),ha=i("input"),ua=f(),va=i("button"),pa=l("Search"),ma=f(),ga=i("br"),ba=i("br"),Ea=f(),Ia=i("div"),Ta=i("table"),ya=i("tr"),ja=i("th"),xa=l("ID"),Da=f(),wa=i("th"),_a=l("User Id"),Sa=f(),Oa=i("th"),Pa=l("Action"),Ra=f(),La=i("th"),Na=l("URL"),Ba=f(),Ha=i("th"),ka=l("Case ID"),Aa=f(),Va=i("th"),$a=l("Date"),Ua=f();for(var a=0;a<it.length;a+=1)it[a].c();Ca=f(),za=i("div"),Fa=f(),qa=i("div"),E(ft.$$.fragment),Ma=f(),Ga=i("br"),Ka=i("p"),Wa=i("b"),Za=l("Showing "),Ja=l(ot),Qa=l(" to "),Xa=l(st),Ya=l("  from total "),at=l(ct),tt=l(" Records."),this.h()},l:function(a){var i=I('[data-svelte="svelte-17iz5w9"]',document.head);t=d(i,"LINK",{rel:!0,href:!0}),r=d(i,"SCRIPT",{src:!0,integrity:!0,crossorigin:!0}),h(r).forEach(v),i.forEach(v),e=p(a),o=d(a,"DIV",{class:!0});var l=h(o);s=d(l,"DIV",{class:!0});var f=h(s);c=d(f,"H3",{class:!0});var m=h(c);n=u(m,"List of API Log"),m.forEach(v),N=p(f),H=d(f,"DIV",{class:!0});var g=h(H);k=d(g,"BUTTON",{type:!0,class:!0,"data-widget":!0,"data-toggle":!0,title:!0});var b=h(k);A=d(b,"I",{class:!0}),h(A).forEach(v),b.forEach(v),V=p(g),$=d(g,"BUTTON",{type:!0,class:!0,"data-widget":!0,"data-toggle":!0,title:!0});var E=h($);U=d(E,"I",{class:!0}),h(U).forEach(v),E.forEach(v),g.forEach(v),f.forEach(v),z=p(l),q=d(l,"DIV",{id:!0,class:!0});var y=h(q);M=d(y,"DIV",{class:!0});var j=h(M);K=d(j,"DIV",{class:!0});var x=h(K);Z=d(x,"FORM",{id:!0});var D=h(Z);J=d(D,"B",{});var w=h(J);Q=u(w,"SHOW"),w.forEach(v),X=p(D),Y=d(D,"SELECT",{id:!0});var _=h(Y);aa=d(_,"OPTION",{value:!0});var S=h(aa);ta=u(S,"10"),S.forEach(v),ra=d(_,"OPTION",{value:!0});var O=h(ra);ea=u(O,"20"),O.forEach(v),oa=d(_,"OPTION",{value:!0});var P=h(oa);sa=u(P,"100"),P.forEach(v),_.forEach(v),ca=p(D),na=d(D,"B",{});var R=h(na);ia=u(R,"ENTRIES"),R.forEach(v),D.forEach(v),x.forEach(v),la=p(j),fa=d(j,"DIV",{style:!0});var L=h(fa);da=d(L,"FORM",{id:!0,name:!0});var B=h(da);ha=d(B,"INPUT",{id:!0,placeholder:!0,type:!0,name:!0}),ua=p(B),va=d(B,"BUTTON",{type:!0,id:!0,name:!0});var C=h(va);pa=u(C,"Search"),C.forEach(v),B.forEach(v),L.forEach(v),ma=p(j),j.forEach(v),ga=d(y,"BR",{}),ba=d(y,"BR",{}),Ea=p(y),Ia=d(y,"DIV",{id:!0,class:!0});var F=h(Ia);Ta=d(F,"TABLE",{id:!0,class:!0});var G=h(Ta);ya=d(G,"TR",{});var W=h(ya);ja=d(W,"TH",{});var rt=h(ja);xa=u(rt,"ID"),rt.forEach(v),Da=p(W),wa=d(W,"TH",{});var et=h(wa);_a=u(et,"User Id"),et.forEach(v),Sa=p(W),Oa=d(W,"TH",{});var nt=h(Oa);Pa=u(nt,"Action"),nt.forEach(v),Ra=p(W),La=d(W,"TH",{});var lt=h(La);Na=u(lt,"URL"),lt.forEach(v),Ba=p(W),Ha=d(W,"TH",{});var dt=h(Ha);ka=u(dt,"Case ID"),dt.forEach(v),Aa=p(W),Va=d(W,"TH",{});var ht=h(Va);$a=u(ht,"Date"),ht.forEach(v),W.forEach(v),Ua=p(G);for(var ut=0;ut<it.length;ut+=1)it[ut].l(G);Ca=p(G),za=d(G,"DIV",{id:!0}),h(za).forEach(v),G.forEach(v),Fa=p(F),qa=d(F,"DIV",{});var vt=h(qa);T(ft.$$.fragment,vt),Ma=p(vt),vt.forEach(v),Ga=d(F,"BR",{}),Ka=d(F,"P",{style:!0});var pt=h(Ka);Wa=d(pt,"B",{align:!0});var mt=h(Wa);Za=u(mt,"Showing "),Ja=u(mt,ot),Qa=u(mt," to "),Xa=u(mt,st),Ya=u(mt,"  from total "),at=u(mt,ct),tt=u(mt," Records."),mt.forEach(v),pt.forEach(v),F.forEach(v),y.forEach(v),l.forEach(v),this.h()},h:function(){document.title="API List",y(t,"rel","stylesheet"),y(t,"href","https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"),r.src!=="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"&&y(r,"src","https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"),y(r,"integrity","sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"),y(r,"crossorigin","anonymous"),y(c,"class","box-title"),y(A,"class","fa fa-minus"),y(k,"type","button"),y(k,"class","btn btn-box-tool"),y(k,"data-widget","collapse"),y(k,"data-toggle","tooltip"),y(k,"title","Collapse"),y(U,"class","fa fa-times"),y($,"type","button"),y($,"class","btn btn-box-tool"),y($,"data-widget","remove"),y($,"data-toggle","tooltip"),y($,"title","Remove"),y(H,"class","box-tools pull-right"),y(s,"class","box-header with-border"),aa.__value="10",aa.value=aa.__value,ra.__value="20",ra.value=ra.__value,oa.__value="100",oa.value=oa.__value,y(Y,"id","selectentry"),y(Z,"id","tableform"),y(K,"class","pull-left"),y(ha,"id","searchfill"),y(ha,"placeholder"," search here"),y(ha,"type","text"),y(ha,"name","search"),y(va,"type","submit"),y(va,"id","searchbtn"),y(va,"name","submit"),y(da,"id","srch"),y(da,"name","srch"),j(fa,"float","right"),y(M,"class","mb10"),y(za,"id","tab1"),y(Ta,"id","admtype-table"),y(Ta,"class","table table-striped table-bordered"),y(Wa,"align","center"),j(Ka,"text-align","center"),y(Ia,"id","showtable"),y(Ia,"class","box-body"),y(q,"id","table"),y(q,"class","box-body"),y(o,"class","box col-md-12")},m:function(i,l){g(document.head,t),g(document.head,r),m(i,e,l),m(i,o,l),g(o,s),g(s,c),g(c,n),g(s,N),g(s,H),g(H,k),g(k,A),g(H,V),g(H,$),g($,U),g(o,z),g(o,q),g(q,M),g(M,K),g(K,Z),g(Z,J),g(J,Q),g(Z,X),g(Z,Y),g(Y,aa),g(aa,ta),g(Y,ra),g(ra,ea),g(Y,oa),g(oa,sa),g(Z,ca),g(Z,na),g(na,ia),g(M,la),g(M,fa),g(fa,da),g(da,ha),g(da,ua),g(da,va),g(va,pa),g(M,ma),g(q,ga),g(q,ba),g(q,Ea),g(q,Ia),g(Ia,Ta),g(Ta,ya),g(ya,ja),g(ja,xa),g(ya,Da),g(ya,wa),g(wa,_a),g(ya,Sa),g(ya,Oa),g(Oa,Pa),g(ya,Ra),g(ya,La),g(La,Na),g(ya,Ba),g(ya,Ha),g(Ha,ka),g(ya,Aa),g(ya,Va),g(Va,$a),g(Ta,Ua);for(var f=0;f<it.length;f+=1)it[f].m(Ta,null);g(Ta,Ca),g(Ta,za),g(Ia,Fa),g(Ia,qa),x(ft,qa,null),g(qa,Ma),g(Ia,Ga),g(Ia,Ka),g(Ka,Wa),g(Wa,Za),g(Wa,Ja),g(Wa,Qa),g(Wa,Xa),g(Wa,Ya),g(Wa,at),g(Wa,tt),rt=!0,et=[D(Y,"change",w(a[3])),D(da,"submit",w((function(){_(a[3]({currentPage:a[1]}))&&a[3]({currentPage:a[1]}).apply(this,arguments)}))),D(Ia,"click",a[9])]},p:function(t,r){var e=B(r,1)[0];if(a=t,4&e){var o;for(nt=a[2],o=0;o<nt.length;o+=1){var s=F(a,nt,o);it[o]?it[o].p(s,e):(it[o]=G(s),it[o].c(),it[o].m(Ta,Ca))}for(;o<it.length;o+=1)it[o].d(1);it.length=nt.length}var c={};1&e&&(c.totalItems=a[0].length),2&e&&(c.currentPage=a[1]),ft.$set(c),(!rt||2&e)&&ot!==(ot=(a[1]-1)*W+1+"")&&b(Ja,ot),(!rt||6&e)&&st!==(st=(a[1]-1)*W+a[2].length+"")&&b(Xa,st),(!rt||1&e)&&ct!==(ct=a[0].length+"")&&b(at,ct)},i:function(a){rt||(S(ft.$$.fragment,a),rt=!0)},o:function(a){O(ft.$$.fragment,a),rt=!1},d:function(a){v(t),v(r),a&&v(e),a&&v(o),P(it,a),R(ft),L(et)}}}var W=10;function Z(a,t,r){var e=U+"/health_registry/api_log",o=[],s=1,c=V.get("token");function n(){void 0!==c||window.location.replace(".")}function i(){var a=$("#searchfill").val()||"",t=($("#selectentry").val(),e+"/list?search="+a);H(k.mark((function a(){var e;return k.wrap((function(a){for(;;)switch(a.prev=a.next){case 0:return a.next=2,A(t,c);case 2:if(e=a.sent,console.log(e),200!=e.status){a.next=14;break}return a.next=7,e.json();case 7:l=a.sent,r(0,o=l),r(2,f=z({items:o,pageSize:W,currentPage:s})),console.log(f),console.log(l),a.next=22;break;case 14:alert("session is expired please Login Again"),V.remove("token"),V.remove("username"),V.remove("role"),V.remove("province"),V.remove("district"),V.remove("municipality"),window.location.replace(".");case 22:case"end":return a.stop()}}),a)})))()}n(),i();var l,f;return l=[],r(2,f=[]),[o,s,f,i,l,e,c,n,function(a){return r(1,s=a.detail.page)},function(){return i()}]}var J=function(i){function l(a){var n;return t(this,l),n=r(this,e(l).call(this)),o(c(n),a,Z,K,s,{}),n}return a(l,n),l}();export default J;
