import{S as a,i as t,s as e,e as r,t as o,a as s,c,b as l,d as i,f as n,g as d,k as h,l as f,o as p,z as v,A as m,B as u,h as g,j as E,D as b,m as I,E as T,W as y,v as D,w as x,Q as w,F as j,G as S,n as _}from"./index.6832dad2.js";import"./index.9158f9e3.js";import{C as O,j as P}from"./jquery.923a77c3.js";import{a as R}from"./create.cc1894b6.js";import{baseUrl as B}from"./fetchdata.e02faaf8.js";import{L,p as N}from"./index.5ddcc576.js";function H(a,t,e){const r=a.slice();return r[10]=t[e],r}function V(a){let t,e,s=a[10].caseid+"";return{c(){t=r("td"),e=o(s)},l(a){t=c(a,"TD",{});var r=l(t);e=i(r,s),r.forEach(n)},m(a,r){h(a,t,r),f(t,e)},p(a,t){4&t&&s!==(s=a[10].caseid+"")&&p(e,s)},d(a){a&&n(t)}}}function $(a){let t,e;return{c(){t=r("td"),e=o("-")},l(a){t=c(a,"TD",{});var r=l(t);e=i(r,"-"),r.forEach(n)},m(a,r){h(a,t,r),f(t,e)},p:_,d(a){a&&n(t)}}}function A(a){let t,e,v,m,u,g,E,b,I,T,y,D,x,w,j,S,_=a[10].id+"",O=a[10].userid+"",P=a[10].action+"",R=a[10].url+"",B=a[10].created_at+"";function L(a,t){return 0==a[10].caseid?$:V}let N=L(a),H=N(a);return{c(){t=r("tr"),e=r("td"),v=o(_),m=s(),u=r("td"),g=o(O),E=s(),b=r("td"),I=o(P),T=s(),y=r("td"),D=o(R),x=s(),H.c(),w=s(),j=r("td"),S=o(B)},l(a){t=c(a,"TR",{});var r=l(t);e=c(r,"TD",{});var o=l(e);v=i(o,_),o.forEach(n),m=d(r),u=c(r,"TD",{});var s=l(u);g=i(s,O),s.forEach(n),E=d(r),b=c(r,"TD",{});var h=l(b);I=i(h,P),h.forEach(n),T=d(r),y=c(r,"TD",{});var f=l(y);D=i(f,R),f.forEach(n),x=d(r),H.l(r),w=d(r),j=c(r,"TD",{});var p=l(j);S=i(p,B),p.forEach(n),r.forEach(n)},m(a,r){h(a,t,r),f(t,e),f(e,v),f(t,m),f(t,u),f(u,g),f(t,E),f(t,b),f(b,I),f(t,T),f(t,y),f(y,D),f(t,x),H.m(t,null),f(t,w),f(t,j),f(j,S)},p(a,e){4&e&&_!==(_=a[10].id+"")&&p(v,_),4&e&&O!==(O=a[10].userid+"")&&p(g,O),4&e&&P!==(P=a[10].action+"")&&p(I,P),4&e&&R!==(R=a[10].url+"")&&p(D,R),N===(N=L(a))&&H?H.p(a,e):(H.d(1),H=N(a),H&&(H.c(),H.m(t,w))),4&e&&B!==(B=a[10].created_at+"")&&p(S,B)},d(a){a&&n(t),H.d()}}}function U(a){let t,e,_,O,P,R,B,N,V,$,U,k,z,F,q,M,W,G,K,Q,J,X,Y,Z,aa,ta,ea,ra,oa,sa,ca,la,ia,na,da,ha,fa,pa,va,ma,ua,ga,Ea,ba,Ia,Ta,ya,Da,xa,wa,ja,Sa,_a,Oa,Pa,Ra,Ba,La,Na,Ha,Va,$a,Aa,Ua,Ca,ka,za,Fa,qa,Ma,Wa,Ga,Ka,Qa,Ja,Xa,Ya,Za,at,tt,et,rt,ot=(a[1]-1)*C+1+"",st=(a[1]-1)*C+a[2].length+"",ct=a[0].length+"",lt=a[2],it=[];for(let t=0;t<lt.length;t+=1)it[t]=A(H(a,lt,t));const nt=new L({props:{totalItems:a[0].length,pageSize:C,currentPage:a[1],limit:1,showStepOptions:!0}});return nt.$on("setPage",a[8]),{c(){t=r("link"),e=r("script"),O=s(),P=r("div"),R=r("div"),B=r("h3"),N=o("List of API Log"),V=s(),$=r("div"),U=r("button"),k=r("i"),z=s(),F=r("button"),q=r("i"),M=s(),W=r("div"),G=r("div"),K=r("div"),Q=r("form"),J=r("b"),X=o("SHOW"),Y=s(),Z=r("select"),aa=r("option"),ta=o("10"),ea=r("option"),ra=o("20"),oa=r("option"),sa=o("100"),ca=s(),la=r("b"),ia=o("ENTRIES"),na=s(),da=r("div"),ha=r("form"),fa=r("input"),pa=s(),va=r("button"),ma=o("Search"),ua=s(),ga=r("br"),Ea=r("br"),ba=s(),Ia=r("div"),Ta=r("table"),ya=r("tr"),Da=r("th"),xa=o("ID"),wa=s(),ja=r("th"),Sa=o("User Id"),_a=s(),Oa=r("th"),Pa=o("Action"),Ra=s(),Ba=r("th"),La=o("URL"),Na=s(),Ha=r("th"),Va=o("Case ID"),$a=s(),Aa=r("th"),Ua=o("Date"),Ca=s();for(let a=0;a<it.length;a+=1)it[a].c();ka=s(),za=r("div"),Fa=s(),qa=r("div"),v(nt.$$.fragment),Ma=s(),Wa=r("br"),Ga=r("p"),Ka=r("b"),Qa=o("Showing "),Ja=o(ot),Xa=o(" to "),Ya=o(st),Za=o("  from total "),at=o(ct),tt=o(" Records."),this.h()},l(a){const r=m('[data-svelte="svelte-17iz5w9"]',document.head);t=c(r,"LINK",{rel:!0,href:!0}),e=c(r,"SCRIPT",{src:!0,integrity:!0,crossorigin:!0}),l(e).forEach(n),r.forEach(n),O=d(a),P=c(a,"DIV",{class:!0});var o=l(P);R=c(o,"DIV",{class:!0});var s=l(R);B=c(s,"H3",{class:!0});var h=l(B);N=i(h,"List of API Log"),h.forEach(n),V=d(s),$=c(s,"DIV",{class:!0});var f=l($);U=c(f,"BUTTON",{type:!0,class:!0,"data-widget":!0,"data-toggle":!0,title:!0});var p=l(U);k=c(p,"I",{class:!0}),l(k).forEach(n),p.forEach(n),z=d(f),F=c(f,"BUTTON",{type:!0,class:!0,"data-widget":!0,"data-toggle":!0,title:!0});var v=l(F);q=c(v,"I",{class:!0}),l(q).forEach(n),v.forEach(n),f.forEach(n),s.forEach(n),M=d(o),W=c(o,"DIV",{id:!0,class:!0});var g=l(W);G=c(g,"DIV",{class:!0});var E=l(G);K=c(E,"DIV",{class:!0});var b=l(K);Q=c(b,"FORM",{id:!0});var I=l(Q);J=c(I,"B",{});var T=l(J);X=i(T,"SHOW"),T.forEach(n),Y=d(I),Z=c(I,"SELECT",{id:!0});var y=l(Z);aa=c(y,"OPTION",{value:!0});var D=l(aa);ta=i(D,"10"),D.forEach(n),ea=c(y,"OPTION",{value:!0});var x=l(ea);ra=i(x,"20"),x.forEach(n),oa=c(y,"OPTION",{value:!0});var w=l(oa);sa=i(w,"100"),w.forEach(n),y.forEach(n),ca=d(I),la=c(I,"B",{});var j=l(la);ia=i(j,"ENTRIES"),j.forEach(n),I.forEach(n),b.forEach(n),na=d(E),da=c(E,"DIV",{style:!0});var S=l(da);ha=c(S,"FORM",{id:!0,name:!0});var _=l(ha);fa=c(_,"INPUT",{id:!0,placeholder:!0,type:!0,name:!0}),pa=d(_),va=c(_,"BUTTON",{type:!0,id:!0,name:!0});var L=l(va);ma=i(L,"Search"),L.forEach(n),_.forEach(n),S.forEach(n),ua=d(E),E.forEach(n),ga=c(g,"BR",{}),Ea=c(g,"BR",{}),ba=d(g),Ia=c(g,"DIV",{id:!0,class:!0});var H=l(Ia);Ta=c(H,"TABLE",{id:!0,class:!0});var A=l(Ta);ya=c(A,"TR",{});var C=l(ya);Da=c(C,"TH",{});var et=l(Da);xa=i(et,"ID"),et.forEach(n),wa=d(C),ja=c(C,"TH",{});var rt=l(ja);Sa=i(rt,"User Id"),rt.forEach(n),_a=d(C),Oa=c(C,"TH",{});var lt=l(Oa);Pa=i(lt,"Action"),lt.forEach(n),Ra=d(C),Ba=c(C,"TH",{});var dt=l(Ba);La=i(dt,"URL"),dt.forEach(n),Na=d(C),Ha=c(C,"TH",{});var ht=l(Ha);Va=i(ht,"Case ID"),ht.forEach(n),$a=d(C),Aa=c(C,"TH",{});var ft=l(Aa);Ua=i(ft,"Date"),ft.forEach(n),C.forEach(n),Ca=d(A);for(let a=0;a<it.length;a+=1)it[a].l(A);ka=d(A),za=c(A,"DIV",{id:!0}),l(za).forEach(n),A.forEach(n),Fa=d(H),qa=c(H,"DIV",{});var pt=l(qa);u(nt.$$.fragment,pt),Ma=d(pt),pt.forEach(n),Wa=c(H,"BR",{}),Ga=c(H,"P",{style:!0});var vt=l(Ga);Ka=c(vt,"B",{align:!0});var mt=l(Ka);Qa=i(mt,"Showing "),Ja=i(mt,ot),Xa=i(mt," to "),Ya=i(mt,st),Za=i(mt,"  from total "),at=i(mt,ct),tt=i(mt," Records."),mt.forEach(n),vt.forEach(n),H.forEach(n),g.forEach(n),o.forEach(n),this.h()},h(){document.title="API List",g(t,"rel","stylesheet"),g(t,"href","https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"),e.src!==(_="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js")&&g(e,"src","https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"),g(e,"integrity","sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"),g(e,"crossorigin","anonymous"),g(B,"class","box-title"),g(k,"class","fa fa-minus"),g(U,"type","button"),g(U,"class","btn btn-box-tool"),g(U,"data-widget","collapse"),g(U,"data-toggle","tooltip"),g(U,"title","Collapse"),g(q,"class","fa fa-times"),g(F,"type","button"),g(F,"class","btn btn-box-tool"),g(F,"data-widget","remove"),g(F,"data-toggle","tooltip"),g(F,"title","Remove"),g($,"class","box-tools pull-right"),g(R,"class","box-header with-border"),aa.__value="10",aa.value=aa.__value,ea.__value="20",ea.value=ea.__value,oa.__value="100",oa.value=oa.__value,g(Z,"id","selectentry"),g(Q,"id","tableform"),g(K,"class","pull-left"),g(fa,"id","searchfill"),g(fa,"placeholder"," search here"),g(fa,"type","text"),g(fa,"name","search"),g(va,"type","submit"),g(va,"id","searchbtn"),g(va,"name","submit"),g(ha,"id","srch"),g(ha,"name","srch"),E(da,"float","right"),g(G,"class","mb10"),g(za,"id","tab1"),g(Ta,"id","admtype-table"),g(Ta,"class","table table-striped table-bordered"),g(Ka,"align","center"),E(Ga,"text-align","center"),g(Ia,"id","showtable"),g(Ia,"class","box-body"),g(W,"id","table"),g(W,"class","box-body"),g(P,"class","box col-md-12")},m(r,o){f(document.head,t),f(document.head,e),h(r,O,o),h(r,P,o),f(P,R),f(R,B),f(B,N),f(R,V),f(R,$),f($,U),f(U,k),f($,z),f($,F),f(F,q),f(P,M),f(P,W),f(W,G),f(G,K),f(K,Q),f(Q,J),f(J,X),f(Q,Y),f(Q,Z),f(Z,aa),f(aa,ta),f(Z,ea),f(ea,ra),f(Z,oa),f(oa,sa),f(Q,ca),f(Q,la),f(la,ia),f(G,na),f(G,da),f(da,ha),f(ha,fa),f(ha,pa),f(ha,va),f(va,ma),f(G,ua),f(W,ga),f(W,Ea),f(W,ba),f(W,Ia),f(Ia,Ta),f(Ta,ya),f(ya,Da),f(Da,xa),f(ya,wa),f(ya,ja),f(ja,Sa),f(ya,_a),f(ya,Oa),f(Oa,Pa),f(ya,Ra),f(ya,Ba),f(Ba,La),f(ya,Na),f(ya,Ha),f(Ha,Va),f(ya,$a),f(ya,Aa),f(Aa,Ua),f(Ta,Ca);for(let a=0;a<it.length;a+=1)it[a].m(Ta,null);f(Ta,ka),f(Ta,za),f(Ia,Fa),f(Ia,qa),b(nt,qa,null),f(qa,Ma),f(Ia,Wa),f(Ia,Ga),f(Ga,Ka),f(Ka,Qa),f(Ka,Ja),f(Ka,Xa),f(Ka,Ya),f(Ka,Za),f(Ka,at),f(Ka,tt),et=!0,rt=[I(Z,"change",T(a[3])),I(ha,"submit",T((function(){y(a[3]({currentPage:a[1]}))&&a[3]({currentPage:a[1]}).apply(this,arguments)}))),I(Ia,"click",a[9])]},p(t,[e]){if(a=t,4&e){let t;for(lt=a[2],t=0;t<lt.length;t+=1){const r=H(a,lt,t);it[t]?it[t].p(r,e):(it[t]=A(r),it[t].c(),it[t].m(Ta,ka))}for(;t<it.length;t+=1)it[t].d(1);it.length=lt.length}const r={};1&e&&(r.totalItems=a[0].length),2&e&&(r.currentPage=a[1]),nt.$set(r),(!et||2&e)&&ot!==(ot=(a[1]-1)*C+1+"")&&p(Ja,ot),(!et||6&e)&&st!==(st=(a[1]-1)*C+a[2].length+"")&&p(Ya,st),(!et||1&e)&&ct!==(ct=a[0].length+"")&&p(at,ct)},i(a){et||(D(nt.$$.fragment,a),et=!0)},o(a){x(nt.$$.fragment,a),et=!1},d(a){n(t),n(e),a&&n(O),a&&n(P),w(it,a),j(nt),S(rt)}}}let C=10;function k(a,t,e){let r=B+"/health_registry/api_log",o=[],s=1,c=O.get("token");function l(){void 0!==c||window.location.replace(".")}function i(){var a=P("#searchfill").val()||"";P("#selectentry").val();let t=r+"/list?search="+a;(async()=>{const a=await R(t,c);200==a.status?(n=await a.json(),e(0,o=n),e(2,d=N({items:o,pageSize:C,currentPage:s})),console.log(d),console.log(n)):(alert("session is expired please Login Again"),O.remove("token"),O.remove("username"),O.remove("role"),O.remove("province"),O.remove("district"),O.remove("municipality"),window.location.replace("."))})()}l(),i();let n,d;return n=[],e(2,d=[]),[o,s,d,i,n,r,c,l,a=>e(1,s=a.detail.page),()=>i()]}export default class extends a{constructor(a){super(),t(this,a,k,U,e,{})}}
