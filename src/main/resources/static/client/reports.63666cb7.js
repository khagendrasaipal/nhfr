import{S as t,i as e,s as l,O as a,k as s,e as i,t as c,a as r,c as o,b as n,d,f as h,g as v,j as p,h as f,l as m,m as y,W as k,o as u,Q as g,z as b,A as w,B as E,D as T,v as j,w as S,F as I,G as L,X as x,n as A}from"./index.e5c655c7.js";import"./create.bcc8dfec.js";import"./index.02e345fc.js";import"./app.10470a6a.js";import"./_commonjsHelpers.fffabd3b.js";import{C as D}from"./js.cookie.7f372dc7.js";import{j as N}from"./jquery.dc1d5bd8.js";import{baseUrl as P,province as F,flevel as H}from"./fetchdata.81784280.js";import{L as _,p as C}from"./index.9bb96efd.js";import{a as $}from"./module.9872e2eb.js";const{document:z}=x;function V(t,e,l){const a=t.slice();return a[35]=e[l],a}function B(t,e,l){const a=t.slice();return a[35]=e[l],a}function O(t){let e,l=t[0],i=[];for(let e=0;e<l.length;e+=1)i[e]=G(B(t,l,e));return{c(){for(let t=0;t<i.length;t+=1)i[t].c();e=a()},l(t){for(let e=0;e<i.length;e+=1)i[e].l(t);e=a()},m(t,l){for(let e=0;e<i.length;e+=1)i[e].m(t,l);s(t,e,l)},p(t,a){if(65&a[0]){let s;for(l=t[0],s=0;s<l.length;s+=1){const c=B(t,l,s);i[s]?i[s].p(c,a):(i[s]=G(c),i[s].c(),i[s].m(e.parentNode,e))}for(;s<i.length;s+=1)i[s].d(1);i.length=l.length}},d(t){g(i,t),t&&h(e)}}}function G(t){let e,l,a,g,b,w,E,T,j,S,I,L,x,A=t[35].nameen+"";return{c(){e=i("li"),l=i("label"),a=c(A),b=r(),w=i("input"),T=r(),j=i("div"),I=r(),this.h()},l(t){e=o(t,"LI",{id:!0,class:!0});var s=n(e);l=o(s,"LABEL",{style:!0,for:!0,class:!0});var i=n(l);a=d(i,A),i.forEach(h),b=v(s),w=o(s,"INPUT",{type:!0,id:!0,class:!0}),T=v(s),j=o(s,"DIV",{id:!0,class:!0}),n(j).forEach(h),I=v(s),s.forEach(h),this.h()},h(){p(l,"background-image","url('folder-horizontal.png')"),f(l,"for",g=t[35].nameen),f(l,"class","svelte-13ki1lk"),f(w,"type","checkbox"),f(w,"id",E=t[35].nameen),f(w,"class","svelte-13ki1lk"),f(j,"id",S="province"+t[35].pid),f(j,"class","pro svelte-13ki1lk"),f(e,"id",L="p"+t[35].pid),f(e,"class","svelte-13ki1lk")},m(i,c){s(i,e,c),m(e,l),m(l,a),m(e,b),m(e,w),m(e,T),m(e,j),m(e,I),x=y(l,"click",(function(){k(t[6](t[35].pid))&&t[6](t[35].pid).apply(this,arguments)}))},p(s,i){t=s,1&i[0]&&A!==(A=t[35].nameen+"")&&u(a,A),1&i[0]&&g!==(g=t[35].nameen)&&f(l,"for",g),1&i[0]&&E!==(E=t[35].nameen)&&f(w,"id",E),1&i[0]&&S!==(S="province"+t[35].pid)&&f(j,"id",S),1&i[0]&&L!==(L="p"+t[35].pid)&&f(e,"id",L)},d(t){t&&h(e),x()}}}function U(t){let e,l;return{c(){e=i("td"),l=c("-"),this.h()},l(t){e=o(t,"TD",{class:!0});var a=n(e);l=d(a,"-"),a.forEach(h),this.h()},h(){f(e,"class","svelte-13ki1lk")},m(t,a){s(t,e,a),m(e,l)},p:A,d(t){t&&h(e)}}}function R(t){let e,l,a=t[35].healthFacilityLevel.name+"";return{c(){e=i("td"),l=c(a),this.h()},l(t){e=o(t,"TD",{class:!0});var s=n(e);l=d(s,a),s.forEach(h),this.h()},h(){f(e,"class","svelte-13ki1lk")},m(t,a){s(t,e,a),m(e,l)},p(t,e){8&e[0]&&a!==(a=t[35].healthFacilityLevel.name+"")&&u(l,a)},d(t){t&&h(e)}}}function K(t){let e,l,a,p,k,g,b,w,E,T,j,S,I,L,x,A,D,N,P,F,H,_,C,$,z,V=t[35].hf_code+"",B=t[35].hf_name+"",O=t[35].healthFacilityType.type_name+"",G=t[35].provinces.nameen+"",K=t[35].districts.nameen+"",M=t[35].municipalitys.nameen+"";function W(t,e){return t[35].healthFacilityLevel?R:U}let q=W(t),Q=q(t);function X(...e){return t[32](t[35],...e)}return{c(){e=i("tr"),l=i("td"),a=c(V),p=r(),k=i("td"),g=c(B),b=r(),w=i("td"),E=c(O),T=r(),Q.c(),j=r(),S=i("td"),I=c(G),L=r(),x=i("td"),A=c(K),D=r(),N=i("td"),P=c(M),F=r(),H=i("td"),_=i("a"),C=c("View Services"),$=r(),this.h()},l(t){e=o(t,"TR",{class:!0});var s=n(e);l=o(s,"TD",{class:!0});var i=n(l);a=d(i,V),i.forEach(h),p=v(s),k=o(s,"TD",{class:!0});var c=n(k);g=d(c,B),c.forEach(h),b=v(s),w=o(s,"TD",{class:!0});var r=n(w);E=d(r,O),r.forEach(h),T=v(s),Q.l(s),j=v(s),S=o(s,"TD",{class:!0});var f=n(S);I=d(f,G),f.forEach(h),L=v(s),x=o(s,"TD",{class:!0});var m=n(x);A=d(m,K),m.forEach(h),D=v(s),N=o(s,"TD",{class:!0});var y=n(N);P=d(y,M),y.forEach(h),F=v(s),H=o(s,"TD",{class:!0});var u=n(H);_=o(u,"A",{class:!0,href:!0});var z=n(_);C=d(z,"View Services"),z.forEach(h),u.forEach(h),$=v(s),s.forEach(h),this.h()},h(){f(l,"class","svelte-13ki1lk"),f(k,"class","svelte-13ki1lk"),f(w,"class","svelte-13ki1lk"),f(S,"class","svelte-13ki1lk"),f(x,"class","svelte-13ki1lk"),f(N,"class","svelte-13ki1lk"),f(_,"class","btn btn-info svelte-13ki1lk"),f(_,"href","javascript:void(0)"),f(H,"class","svelte-13ki1lk"),f(e,"class","svelte-13ki1lk")},m(t,i){s(t,e,i),m(e,l),m(l,a),m(e,p),m(e,k),m(k,g),m(e,b),m(e,w),m(w,E),m(e,T),Q.m(e,null),m(e,j),m(e,S),m(S,I),m(e,L),m(e,x),m(x,A),m(e,D),m(e,N),m(N,P),m(e,F),m(e,H),m(H,_),m(_,C),m(e,$),z=y(_,"click",X)},p(l,s){t=l,8&s[0]&&V!==(V=t[35].hf_code+"")&&u(a,V),8&s[0]&&B!==(B=t[35].hf_name+"")&&u(g,B),8&s[0]&&O!==(O=t[35].healthFacilityType.type_name+"")&&u(E,O),q===(q=W(t))&&Q?Q.p(t,s):(Q.d(1),Q=q(t),Q&&(Q.c(),Q.m(e,j))),8&s[0]&&G!==(G=t[35].provinces.nameen+"")&&u(I,G),8&s[0]&&K!==(K=t[35].districts.nameen+"")&&u(A,K),8&s[0]&&M!==(M=t[35].municipalitys.nameen+"")&&u(P,M)},d(t){t&&h(e),Q.d(),z()}}}function M(t){let e,l,a,k,u,x,A,D,N,P,F,H,C,$,B,G,U,R,M,Q,X,Y,J,Z,tt,et,lt,at,st,it,ct,rt,ot,nt,dt,ht,vt,pt,ft,mt,yt,kt,ut,gt,bt,wt,Et,Tt,jt,St,It,Lt,xt,At,Dt,Nt,Pt,Ft,Ht,_t,Ct,$t,zt,Vt,Bt,Ot,Gt,Ut,Rt,Kt,Mt,Wt,qt,Qt,Xt,Yt,Jt,Zt,te,ee,le,ae,se,ie,ce,re,oe,ne,de,he,ve,pe,fe=t[0]&&O(t),me=t[3],ye=[];for(let e=0;e<me.length;e+=1)ye[e]=K(V(t,me,e));const ke=new _({props:{totalItems:t[1].length,pageSize:W,currentPage:t[2],limit:1,showStepOptions:!0}});return ke.$on("setPage",t[33]),{c(){e=i("style"),l=c(".modal-card{\r\n    min-width: 550px !important;\r\n  }\r\n  "),a=i("script"),u=i("link"),x=i("link"),A=i("link"),D=i("link"),N=i("link"),P=i("link"),F=i("link"),H=r(),C=i("aside"),$=i("ol"),B=i("li"),G=i("label"),U=c("National"),R=r(),M=i("input"),Q=r(),X=i("ol"),Y=i("li"),fe&&fe.c(),J=r(),Z=i("div"),tt=i("select"),et=i("option"),lt=c("Authority Wise"),at=i("option"),st=c("Authority Level Wise"),it=r(),ct=i("div"),rt=i("a"),ot=c("Download"),nt=r(),dt=i("div"),ht=i("div"),vt=r(),pt=i("div"),ft=i("table"),mt=r(),yt=i("div"),kt=i("div"),ut=r(),gt=i("div"),bt=i("input"),wt=r(),Et=i("input"),Tt=r(),jt=i("input"),St=r(),It=i("input"),Lt=r(),xt=i("input"),At=r(),Dt=i("input"),Nt=r(),Pt=i("div"),Ft=i("div"),Ht=i("div"),_t=i("table"),Ct=i("tr"),$t=i("th"),zt=c("Code"),Vt=r(),Bt=i("th"),Ot=c("Name"),Gt=r(),Ut=i("th"),Rt=c("Authority"),Kt=r(),Mt=i("th"),Wt=c("Facility Type"),qt=r(),Qt=i("th"),Xt=c("Province"),Yt=r(),Jt=i("th"),Zt=c("District"),te=r(),ee=i("th"),le=c("Palika"),ae=r(),se=i("th"),ie=c("Action"),ce=r();for(let t=0;t<ye.length;t+=1)ye[t].c();re=r(),oe=i("br"),ne=i("br"),de=r(),he=i("div"),b(ke.$$.fragment),this.h()},l(t){const s=w('[data-svelte="svelte-wx6sdd"]',z.head);e=o(s,"STYLE",{class:!0});var i=n(e);l=d(i,".modal-card{\r\n    min-width: 550px !important;\r\n  }\r\n  "),i.forEach(h),a=o(s,"SCRIPT",{src:!0,integrity:!0,crossorigin:!0,class:!0}),n(a).forEach(h),u=o(s,"LINK",{rel:!0,href:!0,class:!0}),x=o(s,"LINK",{rel:!0,href:!0,class:!0}),A=o(s,"LINK",{rel:!0,href:!0,class:!0}),D=o(s,"LINK",{rel:!0,href:!0,class:!0}),N=o(s,"LINK",{rel:!0,href:!0,class:!0}),P=o(s,"LINK",{rel:!0,href:!0,class:!0}),F=o(s,"LINK",{rel:!0,href:!0,class:!0}),s.forEach(h),H=v(t),C=o(t,"ASIDE",{class:!0,style:!0});var c=n(C);$=o(c,"OL",{class:!0});var r=n($);B=o(r,"LI",{class:!0});var p=n(B);G=o(p,"LABEL",{style:!0,for:!0,class:!0});var f=n(G);U=d(f,"National"),f.forEach(h),R=v(p),M=o(p,"INPUT",{type:!0,id:!0,class:!0}),Q=v(p),X=o(p,"OL",{class:!0});var m=n(X);Y=o(m,"LI",{class:!0});var y=n(Y);fe&&fe.l(y),y.forEach(h),m.forEach(h),p.forEach(h),r.forEach(h),c.forEach(h),J=v(t),Z=o(t,"DIV",{class:!0,style:!0});var k=n(Z);tt=o(k,"SELECT",{id:!0,name:!0,class:!0});var g=n(tt);et=o(g,"OPTION",{value:!0,class:!0});var b=n(et);lt=d(b,"Authority Wise"),b.forEach(h),at=o(g,"OPTION",{value:!0,class:!0});var T=n(at);st=d(T,"Authority Level Wise"),T.forEach(h),g.forEach(h),k.forEach(h),it=v(t),ct=o(t,"DIV",{id:!0,class:!0,style:!0});var j=n(ct);rt=o(j,"A",{id:!0,style:!0,class:!0,href:!0});var S=n(rt);ot=d(S,"Download"),S.forEach(h),nt=v(j),dt=o(j,"DIV",{class:!0});var I=n(dt);ht=o(I,"DIV",{class:!0}),n(ht).forEach(h),vt=v(I),pt=o(I,"DIV",{class:!0,style:!0});var L=n(pt);ft=o(L,"TABLE",{id:!0,class:!0}),n(ft).forEach(h),L.forEach(h),I.forEach(h),j.forEach(h),mt=v(t),yt=o(t,"DIV",{id:!0,class:!0,style:!0});var _=n(yt);kt=o(_,"DIV",{class:!0}),n(kt).forEach(h),ut=v(_),gt=o(_,"DIV",{id:!0,class:!0});var V=n(gt);bt=o(V,"INPUT",{type:!0,name:!0,id:!0,class:!0}),wt=v(V),Et=o(V,"INPUT",{type:!0,name:!0,id:!0,class:!0}),Tt=v(V),jt=o(V,"INPUT",{type:!0,name:!0,id:!0,class:!0}),St=v(V),It=o(V,"INPUT",{type:!0,name:!0,id:!0,class:!0}),Lt=v(V),xt=o(V,"INPUT",{type:!0,name:!0,id:!0,class:!0}),At=v(V),Dt=o(V,"INPUT",{type:!0,name:!0,id:!0,class:!0}),Nt=v(V),Pt=o(V,"DIV",{class:!0});var O=n(Pt);Ft=o(O,"DIV",{id:!0,class:!0});var K=n(Ft);Ht=o(K,"DIV",{id:!0,class:!0});var W=n(Ht);_t=o(W,"TABLE",{id:!0,class:!0,width:!0,style:!0});var q=n(_t);Ct=o(q,"TR",{class:!0});var ve=n(Ct);$t=o(ve,"TH",{class:!0});var pe=n($t);zt=d(pe,"Code"),pe.forEach(h),Vt=v(ve),Bt=o(ve,"TH",{class:!0});var me=n(Bt);Ot=d(me,"Name"),me.forEach(h),Gt=v(ve),Ut=o(ve,"TH",{class:!0});var ue=n(Ut);Rt=d(ue,"Authority"),ue.forEach(h),Kt=v(ve),Mt=o(ve,"TH",{class:!0});var ge=n(Mt);Wt=d(ge,"Facility Type"),ge.forEach(h),qt=v(ve),Qt=o(ve,"TH",{class:!0});var be=n(Qt);Xt=d(be,"Province"),be.forEach(h),Yt=v(ve),Jt=o(ve,"TH",{class:!0});var we=n(Jt);Zt=d(we,"District"),we.forEach(h),te=v(ve),ee=o(ve,"TH",{class:!0});var Ee=n(ee);le=d(Ee,"Palika"),Ee.forEach(h),ae=v(ve),se=o(ve,"TH",{class:!0});var Te=n(se);ie=d(Te,"Action"),Te.forEach(h),ve.forEach(h),ce=v(q);for(let t=0;t<ye.length;t+=1)ye[t].l(q);re=v(q),q.forEach(h),oe=o(W,"BR",{class:!0}),ne=o(W,"BR",{class:!0}),de=v(W),he=o(W,"DIV",{class:!0});var je=n(he);E(ke.$$.fragment,je),je.forEach(h),W.forEach(h),K.forEach(h),O.forEach(h),V.forEach(h),_.forEach(h),this.h()},h(){z.title="Reports",f(e,"class","svelte-13ki1lk"),a.src!==(k="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js")&&f(a,"src","https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"),f(a,"integrity","sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"),f(a,"crossorigin","anonymous"),f(a,"class","svelte-13ki1lk"),f(u,"rel","stylesheet"),f(u,"href","https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css"),f(u,"class","svelte-13ki1lk"),f(x,"rel","stylesheet"),f(x,"href","https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css"),f(x,"class","svelte-13ki1lk"),f(A,"rel","stylesheet"),f(A,"href","https://adminlte.io/themes/AdminLTE/bower_components/font-awesome/css/font-awesome.min.css"),f(A,"class","svelte-13ki1lk"),f(D,"rel","stylesheet"),f(D,"href","https://adminlte.io/themes/AdminLTE/bower_components/Ionicons/css/ionicons.min.css"),f(D,"class","svelte-13ki1lk"),f(N,"rel","stylesheet"),f(N,"href","https://adminlte.io/themes/AdminLTE/bower_components/jvectormap/jquery-jvectormap.css"),f(N,"class","svelte-13ki1lk"),f(P,"rel","stylesheet"),f(P,"href","https://adminlte.io/themes/AdminLTE/dist/css/AdminLTE.min.css"),f(P,"class","svelte-13ki1lk"),f(F,"rel","stylesheet"),f(F,"href","https://adminlte.io/themes/AdminLTE/dist/css/skins/_all-skins.min.css"),f(F,"class","svelte-13ki1lk"),p(G,"background-image","url('folder-horizontal.png')"),f(G,"for","folder1"),f(G,"class","svelte-13ki1lk"),f(M,"type","checkbox"),f(M,"id","folder1"),f(M,"class","svelte-13ki1lk"),f(Y,"class","svelte-13ki1lk"),f(X,"class","svelte-13ki1lk"),f(B,"class","svelte-13ki1lk"),f($,"class","tree svelte-13ki1lk"),f(C,"class","main-sidebar svelte-13ki1lk"),p(C,"float","left"),p(C,"position","absolute"),et.__value="1",et.value=et.__value,f(et,"class","svelte-13ki1lk"),at.__value="2",at.value=at.__value,f(at,"class","svelte-13ki1lk"),f(tt,"id","catid"),f(tt,"name","catid"),f(tt,"class","form-control svelte-13ki1lk"),f(Z,"class","col-md-3 svelte-13ki1lk"),p(Z,"margin-left","500px"),f(rt,"id","dwnbtn"),p(rt,"float","right"),f(rt,"class","btn btn-info svelte-13ki1lk"),f(rt,"href","javascript:void(0)"),f(ht,"class","col-md-2 svelte-13ki1lk"),f(ft,"id","reward-table"),f(ft,"class","table table-hover svelte-13ki1lk"),f(pt,"class","col-md-10  svelte-13ki1lk"),p(pt,"overflow-x","auto"),f(dt,"class","row col-md-12  svelte-13ki1lk"),f(ct,"id","tab"),f(ct,"class"," svelte-13ki1lk"),p(ct,"display","none"),f(kt,"class","col-md-2 svelte-13ki1lk"),f(bt,"type","hidden"),f(bt,"name","vcid"),f(bt,"id","vcid"),f(bt,"class","svelte-13ki1lk"),f(Et,"type","hidden"),f(Et,"name","status"),f(Et,"id","status"),f(Et,"class","svelte-13ki1lk"),f(jt,"type","hidden"),f(jt,"name","province"),f(jt,"id","province"),f(jt,"class","svelte-13ki1lk"),f(It,"type","hidden"),f(It,"name","district"),f(It,"id","district"),f(It,"class","svelte-13ki1lk"),f(xt,"type","hidden"),f(xt,"name","palika"),f(xt,"id","palika"),f(xt,"class","svelte-13ki1lk"),f(Dt,"type","hidden"),f(Dt,"name","types"),f(Dt,"id","types"),f(Dt,"class","svelte-13ki1lk"),f($t,"class","svelte-13ki1lk"),f(Bt,"class","svelte-13ki1lk"),f(Ut,"class","svelte-13ki1lk"),f(Mt,"class","svelte-13ki1lk"),f(Qt,"class","svelte-13ki1lk"),f(Jt,"class","svelte-13ki1lk"),f(ee,"class","svelte-13ki1lk"),f(se,"class","svelte-13ki1lk"),f(Ct,"class","svelte-13ki1lk"),f(_t,"id","admtype-table"),f(_t,"class","table col-md-10 svelte-13ki1lk"),f(_t,"width","80%"),p(_t,"margin-top","10px"),f(oe,"class","svelte-13ki1lk"),f(ne,"class","svelte-13ki1lk"),f(he,"class","svelte-13ki1lk"),f(Ht,"id","showtable"),f(Ht,"class","box-body svelte-13ki1lk"),f(Ft,"id","table"),f(Ft,"class","box-body svelte-13ki1lk"),f(Pt,"class","box svelte-13ki1lk"),f(gt,"id","tab12"),f(gt,"class","col-md-10 svelte-13ki1lk"),f(yt,"id","tab1"),f(yt,"class","row col-md-12 svelte-13ki1lk"),p(yt,"display","none")},m(i,c){m(z.head,e),m(e,l),m(z.head,a),m(z.head,u),m(z.head,x),m(z.head,A),m(z.head,D),m(z.head,N),m(z.head,P),m(z.head,F),s(i,H,c),s(i,C,c),m(C,$),m($,B),m(B,G),m(G,U),m(B,R),m(B,M),m(B,Q),m(B,X),m(X,Y),fe&&fe.m(Y,null),s(i,J,c),s(i,Z,c),m(Z,tt),m(tt,et),m(et,lt),m(tt,at),m(at,st),s(i,it,c),s(i,ct,c),m(ct,rt),m(rt,ot),m(ct,nt),m(ct,dt),m(dt,ht),m(dt,vt),m(dt,pt),m(pt,ft),s(i,mt,c),s(i,yt,c),m(yt,kt),m(yt,ut),m(yt,gt),m(gt,bt),m(gt,wt),m(gt,Et),m(gt,Tt),m(gt,jt),m(gt,St),m(gt,It),m(gt,Lt),m(gt,xt),m(gt,At),m(gt,Dt),m(gt,Nt),m(gt,Pt),m(Pt,Ft),m(Ft,Ht),m(Ht,_t),m(_t,Ct),m(Ct,$t),m($t,zt),m(Ct,Vt),m(Ct,Bt),m(Bt,Ot),m(Ct,Gt),m(Ct,Ut),m(Ut,Rt),m(Ct,Kt),m(Ct,Mt),m(Mt,Wt),m(Ct,qt),m(Ct,Qt),m(Qt,Xt),m(Ct,Yt),m(Ct,Jt),m(Jt,Zt),m(Ct,te),m(Ct,ee),m(ee,le),m(Ct,ae),m(Ct,se),m(se,ie),m(_t,ce);for(let t=0;t<ye.length;t+=1)ye[t].m(_t,null);m(_t,re),m(Ht,oe),m(Ht,ne),m(Ht,de),m(Ht,he),T(ke,he,null),ve=!0,pe=[y(G,"click",t[4]),y(tt,"change",t[5]),y(rt,"click",q),y(Ht,"click",t[34])]},p(t,e){if(t[0]?fe?fe.p(t,e):(fe=O(t),fe.c(),fe.m(Y,null)):fe&&(fe.d(1),fe=null),264&e[0]){let l;for(me=t[3],l=0;l<me.length;l+=1){const a=V(t,me,l);ye[l]?ye[l].p(a,e):(ye[l]=K(a),ye[l].c(),ye[l].m(_t,re))}for(;l<ye.length;l+=1)ye[l].d(1);ye.length=me.length}const l={};2&e[0]&&(l.totalItems=t[1].length),4&e[0]&&(l.currentPage=t[2]),ke.$set(l)},i(t){ve||(j(ke.$$.fragment,t),ve=!0)},o(t){S(ke.$$.fragment,t),ve=!1},d(t){h(e),h(a),h(u),h(x),h(A),h(D),h(N),h(P),h(F),t&&h(H),t&&h(C),fe&&fe.d(),t&&h(J),t&&h(Z),t&&h(it),t&&h(ct),t&&h(mt),t&&h(yt),g(ye,t),I(ke),L(pe)}}}let W=10;function q(){var t="<table border='2px'><tr bgcolor='#87AFC6'>",e=0,l=document.getElementById("reward-table");for(e=0;e<l.rows.length;e++)t=t+l.rows[e].innerHTML+"</tr>",t+="</tr>";return t+="</table>",window.navigator.userAgent.indexOf("MSIE ")>0||navigator.userAgent.match(/Trident.*rv\:11\./)?(txtArea1.document.open("txt/html","replace"),txtArea1.document.write(t),txtArea1.document.close(),txtArea1.focus(),sa=txtArea1.document.execCommand("SaveAs",!0,"participant.xls")):sa=window.open("data:application/vnd.ms-excel,"+encodeURIComponent(t)),sa}function Q(t,e,l){let a,s=P+"/health-registry",i=F,c=H,r=D.get("token");function o(){void 0!==r||window.location.replace(".")}o();let n,d,h=[],v=[];function p(){N("#province").val(""),N("#district").val(""),N("#palika").val(""),N("#status").val(""),N("#types").val("");let t=N("#catid").val();(async()=>{const e=await fetch(P+"/service-type/getProvince");l(0,i=await e.json());(async()=>{let e="";if(3==t){e="national-count-level";const t=await fetch(P+"/health-registry/national-count?catid=1");d=await t.json(),console.log(d)}else e="national-count";const l=await fetch(P+"/health-registry/"+e+"?catid="+t);n=await l.json(),console.log(n),N("#tab").show(),N("#tab1").hide();var s='<caption style="caption-side: top !important;text-align:center"></caption>';if(3==t){let t="<tr><th>Category</th><th>Total Health Facility</th>";for(let e=0;e<H.length;e++)t+=`<th>${H[e].name}</th>`;t+="</tr>"}for(var c in 1==t?s+="<tr><th>Category</th><th>Total Health Facility</th><th>Government</th><th>Non Government</th></tr>":2==t?s+="<tr><th>Category</th><th>Total Health Facility</th><th>Federal</th><th>Provincial</th><th>Local</th></tr>":3==t?s=a:s+="<tr><th>Category</th><th>Total Health Facility</th><th>Government</th><th>Non Government</th></tr>",i){let e="";if(1==t)s=s+"<tr><td>"+i[c].nameen+"</td><td> <label  style='cursor: pointer;' class='totallbl' id="+i[c].pid+">"+n[0][c]+"</label></td><td><label  style='cursor: pointer;' class='govlbl' id="+i[c].pid+">"+n[1][c]+"</label></td><td><label  style='cursor: pointer;' class='nglbl' id="+i[c].pid+">"+n[2][c]+"</label></td></tr>";else if(2==t)s=s+"<tr><td>"+i[c].nameen+"</td><td> <label  style='cursor: pointer;' class='totallbl' id="+i[c].pid+">"+n[0][c]+"</label></td><td><label  style='cursor: pointer;' class='fedlbl' id="+i[c].pid+">"+n[1][c]+"</label></td><td><label  style='cursor: pointer;' class='prolbl' id="+i[c].pid+">"+n[2][c]+"</label></td><td><label  style='cursor: pointer;' class='lclbl' id="+i[c].pid+">"+n[3][c]+"</label></td></tr>";else if(3==t){for(var r in H)e=e+"<td> <label  style='cursor: pointer;' class='srvlvl' id="+i[c].pid+">"+n[r].hf_count+"</label></td>";s=s+"<tr><td>"+i[c].nameen+"</td><td> <label  style='cursor: pointer;' class='srblvl' id="+i[c].pid+">"+d[0][c]+"</label></td>"+e+"</tr>"}else s=s+"<tr><td>"+i[c].nameen+"</td><td> <label  style='cursor: pointer;' class='totallbl' id="+i[c].pid+">"+n[0][c]+"</label></td><td><label  style='cursor: pointer;' class='govlbl' id="+i[c].pid+">"+n[1][c]+"</label></td><td><label  style='cursor: pointer;' class='nglbl' id="+i[c].pid+">"+n[2][c]+"</label></td></tr>"}N("#reward-table").html(s),N(".totallbl").on("click",(function(){var t=N(this).attr("id");console.log(t),N("#province").val(t),N("#status").val(1),N("#types").val(0),g(t,"prov",0)})),N(".govlbl").on("click",(function(){var t=N(this).attr("id");console.log(t),N("#province").val(t),N("#status").val(1),N("#types").val(1),g(t,"prov",1)})),N(".nglbl").on("click",(function(){var t=N(this).attr("id");console.log(t),N("#province").val(t),N("#status").val(1),N("#types").val(2),g(t,"prov",2)}))})()})()}function f(t){N(".muc").hide(),N("#dist"+t).html("");(async()=>{const e=await fetch(P+"/service-type/getMunicipality/"+t);v=await e.json();var l="";for(var a in v)l=l+'<li class="muc"  id="'+v[a].vcid+'" style="cursor: pointer;margin-left:30px;list-style-type:none;"><img src="folder-horizontal.png" alt="logo" /> &nbsp; <label  for="'+v[a].vcid+'" on:click={getHf('+v[a].vcid+")}>"+v[a].nameen+'</label><ol id="dist'+v[a].vcid+'"></ol> </li>';N("#dist"+t).html(l),N(".muc").on("click",(function(){var t=N(this).attr("id");console.log(t),u(t)})),N("#dist"+t).show()})();let e=N("#catid").val();(async()=>{const l=await fetch(P+"/health-registry/palika-count?did="+t+"&catid="+e);n=await l.json(),console.log(n[0]),console.log(n[1]),console.log(n[2]),N("#tab1").hide(),N("#tab").show();var a='<caption style="caption-side: top !important;text-align:center"></caption>';for(var s in 1==e&&(a+="<tr><th>Category</th><th>Total Health Facility</th><th>Government</th><th>Non Government</th></tr>"),2==e&&(a+="<tr><th>Category</th><th>Total Health Facility</th><th>Federal</th><th>Provincial</th><th>Local</th></tr>"),v)1==e&&(a=a+"<tr><td>"+v[s].nameen+"</td><td> <label  style='cursor: pointer;' class='ptotallbl' id="+v[s].vcid+">"+n[0][s]+"</label></td><td><label  style='cursor: pointer;' class='pgovlbl' id="+v[s].vcid+">"+n[1][s]+"</label></td><td><label  style='cursor: pointer;' class='pnglbl' id="+v[s].vcid+">"+(n[0][s]-n[1][s])+"</label></td></tr>"),2==e&&(a=(a=a+"<tr><td>"+v[s].nameen+"</td><td> <label  style='cursor: pointer;' class='ptotallblss' id="+v[s].vcid+">"+n[0][s]+"</label></td><td><label  style='cursor: pointer;' class='pgovlblss' id="+v[s].vcid+">"+n[1][s]+"</label></td><td><label  style='cursor: pointer;' class='pnglblss' id="+v[s].vcid+">"+n[2][s]+"</label></td><td><label  style='cursor: pointer;' class='pnglblss' id="+v[s].vcid+">"+n[3][s]+"</label></td></tr>").replace("undefined","0")),a=a.replace("undefined","0");a=a.replace("undefined","0"),N("#reward-table").html(a),N(".ptotallbl").on("click",(function(){var t=N(this).attr("id");console.log(t),N("#palika").val(t),N("#status").val(3),N("#types").val(0),g(t,"palika",0)})),N(".pgovlbl").on("click",(function(){var t=N(this).attr("id");console.log(t),N("#palika").val(t),N("#status").val(3),N("#types").val(1),g(t,"palika",1)})),N(".pnglbl").on("click",(function(){var t=N(this).attr("id");console.log(t),N("#palika").val(t),N("#status").val(3),N("#types").val(2),g(t,"palika",2)}))})()}let m=[],y=[],k=1;function u(t){var e=N("#status").val(),a=N("#province").val(),i=N("#types").val(),c=N("#district").val(),r=N("#palika").val();if(1==e?g(a,"prov",i):2==e?g(c,"dists",i):3==e&&g(r,"palika",i),t){N("#vcid").val(t),l(2,k=1);var o=N("#vcid").val();(async()=>{const t=await fetch(s+"/gethfByPalika?palika="+o);m=await t.json(),l(1,y=m),l(3,V=C({items:y,pageSize:W,currentPage:k})),N("#tab").hide(),N("#tab1").show(),console.log(V)})()}}function g(t,e,a){var i=N("#status").val();if("prov"==e){(async()=>{const e=await fetch(s+"/reportList?status="+i+"&id="+t+"&type="+a);m=await e.json(),l(1,y=m),l(3,V=C({items:y,pageSize:W,currentPage:k})),N("#tab1").show(),console.log(V)})()}if("dists"==e){(async()=>{const e=await fetch(s+"/reportList?status="+i+"&id="+t+"&type="+a);m=await e.json(),l(1,y=m),l(3,V=C({items:y,pageSize:W,currentPage:k})),N("#tab1").show(),console.log(V)})()}if("palika"==e){(async()=>{const e=await fetch(s+"/reportList?status="+i+"&id="+t+"&type="+a);m=await e.json(),l(1,y=m),l(3,V=C({items:y,pageSize:W,currentPage:k})),N("#tab1").show(),console.log(V)})()}}let b=[],w=[],E=[],T=[],j=[],S=[],I=[],L=[],x=[],A=[],_="";function z(t){_="";(async()=>{const e=await fetch(P+"/services/getServiceSearch/"+t);b=await e.json();(async()=>{const e=await fetch(P+"/services/getOpdService/"+t);w=await e.json();(async()=>{const e=await fetch(P+"/services/getRadioService/"+t);T=await e.json();(async()=>{const e=await fetch(P+"/services/getSurgicalService/"+t);j=await e.json(),console.log(j);(async()=>{const e=await fetch(P+"/services/getSpecializedService/"+t);S=await e.json();(async()=>{const e=await fetch(P+"/services/getMotherService/"+t);I=await e.json();(async()=>{const e=await fetch(P+"/services/getFamilyService/"+t);L=await e.json();(async()=>{const e=await fetch(P+"/services/getAyurvedService/"+t);x=await e.json();(async()=>{const e=await fetch(P+"/services/getBipannaService/"+t);A=await e.json();(async()=>{const e=await fetch(P+"/services/getLabService/"+t);for(var l in E=await e.json(),b){var a=b[l].services;console.log(a.name),_=_+"<li>"+a.name+"</li>"}if(w[0]){for(var l in _+="<li>OPD:",w){a=w[l].opd;_=_+"<li style='margin-left:5em'>"+a.name+"</li>"}_+="</li>"}if(E[0]){for(var l in _+="<li>Laboratory Service:",E){a=E[l].laboratory;_=_+"<li style='margin-left:5em'>"+a.name+"</li>"}_+="</li>"}if(T[0]){for(var l in _+="<li>Radiology Service:",T){a=T[l].radiology;_=_+"<li style='margin-left:5em'>"+a.name+"</li>"}_+="</li>"}if(j[0]){for(var l in _+="<li>Surgical Service:",j){a=j[l].surgical;_=_+"<li style='margin-left:5em'>"+a.name+"</li>"}_+="</li>"}if(S[0]){for(var l in _+="<li>Specialized Service:",S){a=S[l].specialized;_=_+"<li style='margin-left:5em'>"+a.name+"</li>"}_+="</li>"}if(I[0]){for(var l in _+="<li>Safe Motherhood Service:",I){a=I[l].motherhood;_=_+"<li style='margin-left:5em'>"+a.name+"</li>"}_+="</li>"}if(L[0]){for(var l in _+="<li>Family Planning Service:",L){a=L[l].familyplanning;_=_+"<li style='margin-left:5em'>"+a.name+"</li>"}_+="</li>"}if(x[0]){for(var l in _+="<li>Ayurved Service:",x){a=x[l].ayurved;_=_+"<li style='margin-left:5em'>"+a.name+"</li>"}_+="</li>"}if(A[0]){for(var l in _+="<li>Free Bipanna Service:",A){a=A[l].bipanna;_=_+"<li style='margin-left:5em'>"+a.name+"</li>"}_+="</li>"}""==_&&(_="Services Not Available."),$.confirm({message:_,title:"Available Services",type:"is-success"})})()})()})()})()})()})()})()})()})()})()}let V;return t.$$.update=()=>{t.$$.dirty[0]},l(3,V=[]),[i,y,k,V,p,function(){if(p(),console.log(c),console.log(H),3==N("#catid").val()){l(9,a="<tr><th>Category</th><th>Total Health Facility</th>");for(let t=0;t<H.length;t++)l(9,a+=`<th>${H[t].name}</th>`);l(9,a+="</tr>")}console.log(a)},function(t){N("#province"+t).html(""),N(".pro").hide(),(async()=>{const e=await fetch(P+"/service-type/getDistrict/"+t);h=await e.json();var l="";for(var a in h)l=l+'<li  class="din"  id="'+h[a].districtid+'" style="cursor: pointer;margin-left:40px;list-style-type:none;"><img src="folder-horizontal.png" alt="logo" /> &nbsp;<label  for="'+h[a].districtid+'" on:click="{() =>getPalika('+h[a].districtid+')}" > '+h[a].nameen+' </label><ol id="dist'+h[a].districtid+'"></ol></li> ';N("#province"+t).append(l),N(".din").on("click",(function(){var t=N(this).attr("id");console.log(t),f(t)})),N("#province"+t).show()})();let e=N("#catid").val();(async()=>{const l=await fetch(P+"/health-registry/district-count?pid="+t+"&catid="+e);n=await l.json(),console.log(n[0]),console.log(n[1]),console.log(n[2]),N("#tab1").hide(),N("#tab").show();var a='<caption style="caption-side: top !important;text-align:center"></caption>';for(var s in 1==e?a+="<tr><th>Category</th><th>Total Health Facility</th><th>Government</th><th>Non Government</th></tr>":2==e&&(a+="<tr><th>Category</th><th>Total Health Facility</th><th>Federal</th><th>Provincial</th><th>Local</th></tr>"),h)1==e&&(a=a+"<tr><td>"+h[s].nameen+"</td><td> <label  style='cursor: pointer;' class='dtotallbl' id="+h[s].districtid+">"+n[0][s]+"</label></td><td><label  style='cursor: pointer;' class='dgovlbl' id="+h[s].districtid+">"+n[1][s]+"</label></td><td><label  style='cursor: pointer;' class='dnglbl' id="+h[s].districtid+">"+(n[0][s]-n[1][s])+"</label></td></tr>"),2==e&&(a=(a=a+"<tr><td>"+h[s].nameen+"</td><td> <label  style='cursor: pointer;' class='dtotallblss' id="+h[s].districtid+">"+n[0][s]+"</label></td><td><label  style='cursor: pointer;' class='dgovlblss' id="+h[s].districtid+">"+n[1][s]+"</label></td><td><label  style='cursor: pointer;' class='dnglblss' id="+h[s].districtid+">"+n[2][s]+"</label></td><td><label  style='cursor: pointer;' class='dnglblss' id="+h[s].districtid+">"+n[3][s]+"</label></td></tr>").replace("undefined","0")),a=a.replace("undefined","0");a=a.replace("undefined","0"),N("#reward-table").html(a),N(".dtotallbl").on("click",(function(){var t=N(this).attr("id");console.log(t),N("#district").val(t),N("#status").val(2),N("#types").val(0),g(t,"dists",0)})),N(".dgovlbl").on("click",(function(){var t=N(this).attr("id");console.log(t),N("#district").val(t),N("#status").val(2),N("#types").val(1),g(t,"dists",1)})),N(".dnglbl").on("click",(function(){var t=N(this).attr("id");console.log(t),N("#district").val(t),N("#status").val(2),N("#types").val(2),g(t,"dists",2)}))})()},u,z,a,h,v,n,d,m,b,w,E,T,j,S,I,L,x,A,_,s,c,r,o,f,g,(t,e)=>z(t.id),t=>l(2,k=t.detail.page),()=>u()]}export default class extends t{constructor(t){super(),e(this,t,Q,M,l,{},[-1,-1])}}
