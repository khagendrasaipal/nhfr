import{S as a,i as e,s as t,e as s,t as r,c as l,b as o,d as c,f as n,k as i,l as d,n as f,a as h,g as v,h as u,m,o as p,G as E,z as g,A as b,B as I,j as y,D as T,E as _,W as O,v as D,w as x,Q as N,F as w,X as S}from"./index.e5c655c7.js";import{l as P,c as B,d as V}from"./create.bcc8dfec.js";import{N as L,s as $,d as j}from"./index.02e345fc.js";import"./_commonjsHelpers.fffabd3b.js";import{C as A}from"./js.cookie.7f372dc7.js";import{j as C}from"./jquery.dc1d5bd8.js";import{parent as R,baseUrl as k}from"./fetchdata.81784280.js";import{L as U,p as H}from"./index.9bb96efd.js";const{document:F}=S;function z(a,e,t){const s=a.slice();return s[14]=e[t],s}function M(a,e,t){const s=a.slice();return s[14]=e[t],s}function W(a){let e,t,h,v=a[14].type_name+"";return{c(){e=s("option"),t=r(v),this.h()},l(a){e=l(a,"OPTION",{value:!0});var s=o(e);t=c(s,v),s.forEach(n),this.h()},h(){e.__value=h=a[14].id,e.value=e.__value},m(a,s){i(a,e,s),d(e,t)},p:f,d(a){a&&n(e)}}}function q(a){let e,t,f,g,b,I,y,T,_,O,D,x,N,w,S,P,B,V,L=a[14].id+"",$=a[14].code+"",j=a[14].name+"";function A(...e){return a[10](a[14],...e)}function C(...e){return a[11](a[14],...e)}return{c(){e=s("tr"),t=s("td"),f=r(L),g=h(),b=s("td"),I=r($),y=h(),T=s("td"),_=r(j),O=h(),D=s("td"),x=s("a"),N=s("span"),w=h(),S=s("a"),P=s("span"),B=h(),this.h()},l(a){e=l(a,"TR",{});var s=o(e);t=l(s,"TD",{});var r=o(t);f=c(r,L),r.forEach(n),g=v(s),b=l(s,"TD",{});var i=o(b);I=c(i,$),i.forEach(n),y=v(s),T=l(s,"TD",{});var d=o(T);_=c(d,j),d.forEach(n),O=v(s),D=l(s,"TD",{});var h=o(D);x=l(h,"A",{class:!0,href:!0});var u=o(x);N=l(u,"SPAN",{class:!0}),o(N).forEach(n),u.forEach(n),w=v(h),S=l(h,"A",{class:!0,href:!0});var m=o(S);P=l(m,"SPAN",{class:!0}),o(P).forEach(n),m.forEach(n),B=v(h),h.forEach(n),s.forEach(n),this.h()},h(){u(N,"class","glyphicon glyphicon-edit"),u(x,"class","btn btn-info"),u(x,"href","javascript:void(0)"),u(P,"class","glyphicon glyphicon-trash"),u(S,"class","btn btn-danger"),u(S,"href","javascript:void(0)")},m(a,s){i(a,e,s),d(e,t),d(t,f),d(e,g),d(e,b),d(b,I),d(e,y),d(e,T),d(T,_),d(e,O),d(e,D),d(D,x),d(x,N),d(D,w),d(D,S),d(S,P),d(D,B),V=[m(x,"click",A),m(S,"click",C)]},p(e,t){a=e,4&t&&L!==(L=a[14].id+"")&&p(f,L),4&t&&$!==($=a[14].code+"")&&p(I,$),4&t&&j!==(j=a[14].name+"")&&p(_,j)},d(a){a&&n(e),E(V)}}}function G(a){let e,t,f,p,S,P,B,V,$,j,A,C,k,H,G,Q,X,J,Y,Z,aa,ea,ta,sa,ra,la,oa,ca,na,ia,da,fa,ha,va,ua,ma,pa,Ea,ga,ba,Ia,ya,Ta,_a,Oa,Da,xa,Na,wa,Sa,Pa,Ba,Va,La,$a,ja,Aa,Ca,Ra,ka,Ua,Ha,Fa,za,Ma,Wa,qa,Ga,Ka,Qa,Xa,Ja,Ya,Za,ae,ee,te,se,re,le,oe,ce,ne,ie,de,fe,he,ve,ue,me,pe,Ee,ge,be,Ie,ye,Te,_e,Oe,De,xe,Ne,we,Se,Pe,Be,Ve,Le,$e,je,Ae,Ce,Re,ke,Ue=R,He=[];for(let e=0;e<Ue.length;e+=1)He[e]=W(M(a,Ue,e));const Fe=new L({});let ze=a[2],Me=[];for(let e=0;e<ze.length;e+=1)Me[e]=q(z(a,ze,e));const We=new U({props:{totalItems:a[0].length,pageSize:K,currentPage:a[1],limit:1,showStepOptions:!0}});return We.$on("setPage",a[12]),{c(){e=s("link"),t=h(),f=s("div"),p=s("div"),S=s("div"),P=s("div"),B=s("h3"),V=r("Create Ownership"),$=h(),j=s("form"),A=s("input"),C=h(),k=s("div"),H=s("div"),G=s("label"),Q=r("Parent Ownership"),X=h(),J=s("select"),Y=s("option"),Z=r("Select One..");for(let a=0;a<He.length;a+=1)He[a].c();aa=h(),ea=s("div"),ta=s("label"),sa=r("Code"),ra=h(),la=s("input"),oa=h(),ca=s("div"),na=s("label"),ia=r("Name"),da=h(),fa=s("input"),ha=h(),va=s("div"),ua=s("label"),ma=r("Status"),pa=h(),Ea=s("select"),ga=s("option"),ba=r("Select One.."),Ia=s("option"),ya=r("Enabled"),Ta=s("option"),_a=r("Disabled"),Oa=s("option"),Da=r("Expired"),xa=h(),Na=s("div"),wa=s("button"),Sa=r("Submit"),Pa=h(),Ba=s("button"),Va=r("Reset"),La=h(),g(Fe.$$.fragment),$a=h(),ja=s("div"),Aa=s("div"),Ca=s("h3"),Ra=r("List of Ownership"),ka=h(),Ua=s("div"),Ha=s("button"),Fa=s("i"),za=h(),Ma=s("button"),Wa=s("i"),qa=h(),Ga=s("div"),Ka=s("div"),Qa=s("div"),Xa=s("form"),Ja=s("b"),Ya=r("SHOW"),Za=h(),ae=s("select"),ee=s("option"),te=r("10"),se=s("option"),re=r("20"),le=s("option"),oe=r("100"),ce=h(),ne=s("b"),ie=r("ENTRIES"),de=h(),fe=s("div"),he=s("form"),ve=s("input"),ue=h(),me=s("button"),pe=r("Search"),Ee=h(),ge=s("br"),be=s("br"),Ie=h(),ye=s("div"),Te=s("table"),_e=s("tr"),Oe=s("th"),De=r("ID"),xe=h(),Ne=s("th"),we=r("Code"),Se=h(),Pe=s("th"),Be=r("Name"),Ve=h(),Le=s("th"),$e=r("ACTIONS"),je=h();for(let a=0;a<Me.length;a+=1)Me[a].c();Ae=h(),Ce=s("div"),g(We.$$.fragment),this.h()},l(a){const s=b('[data-svelte="svelte-gzyv7l"]',F.head);e=l(s,"LINK",{rel:!0,href:!0}),s.forEach(n),t=v(a),f=l(a,"DIV",{class:!0});var r=o(f);p=l(r,"DIV",{class:!0});var i=o(p);S=l(i,"DIV",{class:!0});var d=o(S);P=l(d,"DIV",{class:!0});var h=o(P);B=l(h,"H3",{class:!0});var u=o(B);V=c(u,"Create Ownership"),u.forEach(n),h.forEach(n),$=v(d),j=l(d,"FORM",{role:!0,id:!0});var m=o(j);A=l(m,"INPUT",{type:!0,value:!0,name:!0,id:!0}),C=v(m),k=l(m,"DIV",{class:!0});var E=o(k);H=l(E,"DIV",{class:!0});var g=o(H);G=l(g,"LABEL",{for:!0});var y=o(G);Q=c(y,"Parent Ownership"),y.forEach(n),X=v(g),J=l(g,"SELECT",{class:!0,id:!0,name:!0});var T=o(J);Y=l(T,"OPTION",{value:!0});var _=o(Y);Z=c(_,"Select One.."),_.forEach(n);for(let a=0;a<He.length;a+=1)He[a].l(T);T.forEach(n),g.forEach(n),aa=v(E),ea=l(E,"DIV",{class:!0});var O=o(ea);ta=l(O,"LABEL",{for:!0});var D=o(ta);sa=c(D,"Code"),D.forEach(n),ra=v(O),la=l(O,"INPUT",{type:!0,name:!0,id:!0,class:!0,value:!0}),O.forEach(n),oa=v(E),ca=l(E,"DIV",{class:!0});var x=o(ca);na=l(x,"LABEL",{for:!0});var N=o(na);ia=c(N,"Name"),N.forEach(n),da=v(x),fa=l(x,"INPUT",{type:!0,name:!0,id:!0,class:!0}),x.forEach(n),ha=v(E),va=l(E,"DIV",{class:!0});var w=o(va);ua=l(w,"LABEL",{for:!0});var L=o(ua);ma=c(L,"Status"),L.forEach(n),pa=v(w),Ea=l(w,"SELECT",{class:!0,id:!0,name:!0});var R=o(Ea);ga=l(R,"OPTION",{value:!0});var U=o(ga);ba=c(U,"Select One.."),U.forEach(n),Ia=l(R,"OPTION",{value:!0});var z=o(Ia);ya=c(z,"Enabled"),z.forEach(n),Ta=l(R,"OPTION",{value:!0});var M=o(Ta);_a=c(M,"Disabled"),M.forEach(n),Oa=l(R,"OPTION",{value:!0});var W=o(Oa);Da=c(W,"Expired"),W.forEach(n),R.forEach(n),w.forEach(n),xa=v(E),Na=l(E,"DIV",{class:!0});var q=o(Na);wa=l(q,"BUTTON",{type:!0,class:!0});var K=o(wa);Sa=c(K,"Submit"),K.forEach(n),Pa=v(q),Ba=l(q,"BUTTON",{type:!0,onClick:!0,class:!0});var Re=o(Ba);Va=c(Re,"Reset"),Re.forEach(n),La=v(q),I(Fe.$$.fragment,q),q.forEach(n),E.forEach(n),m.forEach(n),d.forEach(n),i.forEach(n),$a=v(r),ja=l(r,"DIV",{class:!0});var ke=o(ja);Aa=l(ke,"DIV",{class:!0});var Ue=o(Aa);Ca=l(Ue,"H3",{class:!0});var ze=o(Ca);Ra=c(ze,"List of Ownership"),ze.forEach(n),ka=v(Ue),Ua=l(Ue,"DIV",{class:!0});var qe=o(Ua);Ha=l(qe,"BUTTON",{type:!0,class:!0,"data-widget":!0,"data-toggle":!0,title:!0});var Ge=o(Ha);Fa=l(Ge,"I",{class:!0}),o(Fa).forEach(n),Ge.forEach(n),za=v(qe),Ma=l(qe,"BUTTON",{type:!0,class:!0,"data-widget":!0,"data-toggle":!0,title:!0});var Ke=o(Ma);Wa=l(Ke,"I",{class:!0}),o(Wa).forEach(n),Ke.forEach(n),qe.forEach(n),Ue.forEach(n),qa=v(ke),Ga=l(ke,"DIV",{id:!0,class:!0});var Qe=o(Ga);Ka=l(Qe,"DIV",{class:!0});var Xe=o(Ka);Qa=l(Xe,"DIV",{class:!0});var Je=o(Qa);Xa=l(Je,"FORM",{id:!0});var Ye=o(Xa);Ja=l(Ye,"B",{});var Ze=o(Ja);Ya=c(Ze,"SHOW"),Ze.forEach(n),Za=v(Ye),ae=l(Ye,"SELECT",{id:!0});var at=o(ae);ee=l(at,"OPTION",{value:!0});var et=o(ee);te=c(et,"10"),et.forEach(n),se=l(at,"OPTION",{value:!0});var tt=o(se);re=c(tt,"20"),tt.forEach(n),le=l(at,"OPTION",{value:!0});var st=o(le);oe=c(st,"100"),st.forEach(n),at.forEach(n),ce=v(Ye),ne=l(Ye,"B",{});var rt=o(ne);ie=c(rt,"ENTRIES"),rt.forEach(n),Ye.forEach(n),Je.forEach(n),de=v(Xe),fe=l(Xe,"DIV",{style:!0});var lt=o(fe);he=l(lt,"FORM",{id:!0,name:!0});var ot=o(he);ve=l(ot,"INPUT",{id:!0,placeholder:!0,type:!0,name:!0}),ue=v(ot),me=l(ot,"BUTTON",{type:!0,id:!0,name:!0});var ct=o(me);pe=c(ct,"Search"),ct.forEach(n),ot.forEach(n),lt.forEach(n),Ee=v(Xe),Xe.forEach(n),ge=l(Qe,"BR",{}),be=l(Qe,"BR",{}),Ie=v(Qe),ye=l(Qe,"DIV",{id:!0,class:!0});var nt=o(ye);Te=l(nt,"TABLE",{id:!0,class:!0});var it=o(Te);_e=l(it,"TR",{});var dt=o(_e);Oe=l(dt,"TH",{});var ft=o(Oe);De=c(ft,"ID"),ft.forEach(n),xe=v(dt),Ne=l(dt,"TH",{});var ht=o(Ne);we=c(ht,"Code"),ht.forEach(n),Se=v(dt),Pe=l(dt,"TH",{});var vt=o(Pe);Be=c(vt,"Name"),vt.forEach(n),Ve=v(dt),Le=l(dt,"TH",{});var ut=o(Le);$e=c(ut,"ACTIONS"),ut.forEach(n),dt.forEach(n),je=v(it);for(let a=0;a<Me.length;a+=1)Me[a].l(it);it.forEach(n),Ae=v(nt),Ce=l(nt,"DIV",{});var mt=o(Ce);I(We.$$.fragment,mt),mt.forEach(n),nt.forEach(n),Qe.forEach(n),ke.forEach(n),r.forEach(n),this.h()},h(){F.title="Ownership",u(e,"rel","stylesheet"),u(e,"href","https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"),u(B,"class","box-title"),u(P,"class","box-header with-border"),u(A,"type","hidden"),A.value="",u(A,"name","id"),u(A,"id","id"),u(G,"for","exampleInputEmail1"),Y.__value="",Y.value=Y.__value,u(J,"class","form-control"),u(J,"id","parent_id"),u(J,"name","parent_id"),u(H,"class","form-group"),u(ta,"for","exampleInputEmail1"),u(la,"type","text"),u(la,"name","code"),u(la,"id","code"),u(la,"class","form-control"),la.value="",u(ea,"class","form-group"),u(na,"for","exampleInputEmail1"),u(fa,"type","text"),u(fa,"name","name"),u(fa,"id","name"),u(fa,"class","form-control"),u(ca,"class","form-group"),u(ua,"for","exampleInputEmail1"),ga.__value="",ga.value=ga.__value,Ia.__value="1",Ia.value=Ia.__value,Ta.__value="2",Ta.value=Ta.__value,Oa.__value="3",Oa.value=Oa.__value,u(Ea,"class","form-control"),u(Ea,"id","status"),u(Ea,"name","status"),u(va,"class","form-group"),u(wa,"type","submit"),u(wa,"class","btn btn-primary"),u(Ba,"type","reset"),u(Ba,"onclick","resetForm()"),u(Ba,"class","btn btn-info pull-right"),u(Na,"class","box-footer"),u(k,"class","box-body"),u(j,"role","form"),u(j,"id","form"),u(S,"class","box box-primary"),u(p,"class","col-md-6"),u(Ca,"class","box-title"),u(Fa,"class","fa fa-minus"),u(Ha,"type","button"),u(Ha,"class","btn btn-box-tool"),u(Ha,"data-widget","collapse"),u(Ha,"data-toggle","tooltip"),u(Ha,"title","Collapse"),u(Wa,"class","fa fa-times"),u(Ma,"type","button"),u(Ma,"class","btn btn-box-tool"),u(Ma,"data-widget","remove"),u(Ma,"data-toggle","tooltip"),u(Ma,"title","Remove"),u(Ua,"class","box-tools pull-right"),u(Aa,"class","box-header with-border"),ee.__value="10",ee.value=ee.__value,se.__value="20",se.value=se.__value,le.__value="100",le.value=le.__value,u(ae,"id","selectentry"),u(Xa,"id","tableform"),u(Qa,"class","pull-left"),u(ve,"id","searchfill"),u(ve,"placeholder"," search here"),u(ve,"type","text"),u(ve,"name","search"),u(me,"type","submit"),u(me,"id","searchbtn"),u(me,"name","submit"),u(he,"id","srch"),u(he,"name","srch"),y(fe,"float","right"),u(Ka,"class","mb10"),u(Te,"id","admtype-table"),u(Te,"class","table table-striped table-bordered"),u(ye,"id","showtable"),u(ye,"class","box-body"),u(Ga,"id","table"),u(Ga,"class","box-body"),u(ja,"class","box col-md-6"),u(f,"class","row col-md-12")},m(s,r){d(F.head,e),i(s,t,r),i(s,f,r),d(f,p),d(p,S),d(S,P),d(P,B),d(B,V),d(S,$),d(S,j),d(j,A),d(j,C),d(j,k),d(k,H),d(H,G),d(G,Q),d(H,X),d(H,J),d(J,Y),d(Y,Z);for(let a=0;a<He.length;a+=1)He[a].m(J,null);d(k,aa),d(k,ea),d(ea,ta),d(ta,sa),d(ea,ra),d(ea,la),d(k,oa),d(k,ca),d(ca,na),d(na,ia),d(ca,da),d(ca,fa),d(k,ha),d(k,va),d(va,ua),d(ua,ma),d(va,pa),d(va,Ea),d(Ea,ga),d(ga,ba),d(Ea,Ia),d(Ia,ya),d(Ea,Ta),d(Ta,_a),d(Ea,Oa),d(Oa,Da),d(k,xa),d(k,Na),d(Na,wa),d(wa,Sa),d(Na,Pa),d(Na,Ba),d(Ba,Va),d(Na,La),T(Fe,Na,null),d(f,$a),d(f,ja),d(ja,Aa),d(Aa,Ca),d(Ca,Ra),d(Aa,ka),d(Aa,Ua),d(Ua,Ha),d(Ha,Fa),d(Ua,za),d(Ua,Ma),d(Ma,Wa),d(ja,qa),d(ja,Ga),d(Ga,Ka),d(Ka,Qa),d(Qa,Xa),d(Xa,Ja),d(Ja,Ya),d(Xa,Za),d(Xa,ae),d(ae,ee),d(ee,te),d(ae,se),d(se,re),d(ae,le),d(le,oe),d(Xa,ce),d(Xa,ne),d(ne,ie),d(Ka,de),d(Ka,fe),d(fe,he),d(he,ve),d(he,ue),d(he,me),d(me,pe),d(Ka,Ee),d(Ga,ge),d(Ga,be),d(Ga,Ie),d(Ga,ye),d(ye,Te),d(Te,_e),d(_e,Oe),d(Oe,De),d(_e,xe),d(_e,Ne),d(Ne,we),d(_e,Se),d(_e,Pe),d(Pe,Be),d(_e,Ve),d(_e,Le),d(Le,$e),d(Te,je);for(let a=0;a<Me.length;a+=1)Me[a].m(Te,null);d(ye,Ae),d(ye,Ce),T(We,Ce,null),Re=!0,ke=[m(j,"submit",_(a[4])),m(ae,"change",_((function(){O(a[3]({currentPage:a[1]}))&&a[3]({currentPage:a[1]}).apply(this,arguments)}))),m(he,"submit",_((function(){O(a[3]({currentPage:a[1]}))&&a[3]({currentPage:a[1]}).apply(this,arguments)}))),m(ye,"click",a[13])]},p(e,[t]){if(a=e,0&t){let e;for(Ue=R,e=0;e<Ue.length;e+=1){const s=M(a,Ue,e);He[e]?He[e].p(s,t):(He[e]=W(s),He[e].c(),He[e].m(J,null))}for(;e<He.length;e+=1)He[e].d(1);He.length=Ue.length}if(100&t){let e;for(ze=a[2],e=0;e<ze.length;e+=1){const s=z(a,ze,e);Me[e]?Me[e].p(s,t):(Me[e]=q(s),Me[e].c(),Me[e].m(Te,null))}for(;e<Me.length;e+=1)Me[e].d(1);Me.length=ze.length}const s={};1&t&&(s.totalItems=a[0].length),2&t&&(s.currentPage=a[1]),We.$set(s)},i(a){Re||(D(Fe.$$.fragment,a),D(We.$$.fragment,a),Re=!0)},o(a){x(Fe.$$.fragment,a),x(We.$$.fragment,a),Re=!1},d(a){n(e),a&&n(t),a&&n(f),N(He,a),w(Fe),N(Me,a),w(We),E(ke)}}}let K=10;function Q(a,e,t){let s=k+"/ownership",r=A.get("token"),l=[],o=[],c=1;function n(){var a=C("#searchfill").val()||"";C("#selectentry").val();let e=s+"/list?search="+a;(async()=>{const a=await P(e,r);200==a.status?(l=await a.json(),t(0,o=l),t(2,f=H({items:o,pageSize:K,currentPage:c})),console.log(f),console.log(l)):(alert("session is expired please Login Again"),A.remove("token"),A.remove("username"),A.remove("role"),A.remove("province"),A.remove("district"),A.remove("municipality"),window.location.replace("."))})()}function i(a){if(confirm("Are you sure you want to delete?")){let e=s+"/delete/"+a,t="DELETE";(async()=>{200==(await V(e,t)).status?$("Item Deleted Successfully !"):j("Failed To Delete Item."),n()})()}}function d(a){let e=[];(async()=>{const t=await fetch(s+"/edit/"+a);e=await t.json(),document.getElementById("id").value=e.id,document.getElementById("parent_id").value=e.parent_id,document.getElementById("code").value=e.code,document.getElementById("name").value=e.name,document.getElementById("status").value=e.status})()}n();let f;return t(2,f=[]),[o,c,f,n,function(a){let e,t;a.preventDefault();var l=document.getElementById("id").value,o=document.getElementById("parent_id").value,c=document.getElementById("code").value,i=document.getElementById("name").value,d=document.getElementById("status").value;""==l?(e=s+"/create",t="POST"):(e=s+"/update/"+l,t="PUT");let f={parent_id:o,code:c,name:i,status:d};console.log(f),(async()=>{const a=await B(e,t,f,r);console.log(a),200==a.status?($("Item Saved Successfully"),C("#id").val(""),C("#form")[0].reset()):j("Failed to save data"),n()})()},i,d,l,s,r,(a,e)=>d(a.id),(a,e)=>i(a.id),a=>t(1,c=a.detail.page),()=>n()]}export default class extends a{constructor(a){super(),e(this,a,Q,G,t,{})}}
