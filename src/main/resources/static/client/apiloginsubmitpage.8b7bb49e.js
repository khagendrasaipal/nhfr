import{S as a,i as r,s as e,a as o,e as t,t as s,A as c,f as h,g as i,c as f,b as d,d as v,h as n,j as p,k as l,l as T,m as E,n as b}from"./index.e5c655c7.js";import"./create.be28beed.js";import"./index.7e2e6ea4.js";import"./app.5d9269da.js";import{C as g}from"./js.cookie.9f4d6962.js";import"./jquery.719b2463.js";import"./fetchdata.889125f6.js";function D(a){let r,e,D,u,m,y,O,S,k,P,R,J,N,j,I,B,L,x,z,A,w,H,V,U,M,C,K,q,F,G,Q,W,X,Y,Z,$,_,aa,ra,ea,oa,ta,sa,ca,ha,ia,fa,da,va,na,pa,la,Ta,Ea,ba,ga,Da,ua,ma,ya,Oa,Sa,ka,Pa,Ra,Ja,Na,ja,Ia,Ba,La,xa,za,Aa,wa,Ha,Va,Ua,Ma,Ca,Ka,qa,Fa,Ga,Qa,Wa,Xa,Ya,Za,$a,_a,ar,rr,er,or,tr,sr,cr,hr,ir,fr,dr,vr,nr,pr,lr,Tr,Er,br,gr,Dr,ur,mr,yr,Or,Sr,kr,Pr,Rr,Jr,Nr,jr,Ir,Br,Lr,xr,zr,Ar,wr,Hr,Vr,Ur,Mr,Cr,Kr,qr,Fr,Gr,Qr=g.get("apiuserfullname")+"",Wr=g.get("apiuserusername")+"",Xr=g.get("apiusertoken")+"";return{c(){r=o(),e=t("div"),D=o(),u=t("a"),m=s("Log Out\r\n              "),y=t("br"),O=t("br"),S=t("br"),k=o(),P=t("div"),R=t("div"),J=t("div"),N=t("div"),j=t("h3"),I=s(Qr),B=s("          "),L=o(),x=t("ul"),z=t("li"),A=t("b"),w=s("Username:"),H=o(),V=t("b"),U=s(Wr),M=o(),C=t("li"),K=t("b"),q=s("API Token:"),F=o(),G=t("b"),Q=s(Xr),W=o(),X=t("a"),Y=t("b"),Z=s("Refresh API Token"),$=o(),_=t("div"),aa=t("table"),ra=t("tr"),ea=t("th"),oa=s("Method"),ta=t("th"),sa=s("URL"),ca=t("th"),ha=s("Body"),ia=t("th"),fa=s("Result"),da=t("th"),va=s("Remarks"),na=o(),pa=t("tr"),la=t("td"),Ta=s("POST"),Ea=t("td"),ba=s("api/get-hf"),ga=t("td"),Da=s("token, pageno, pagesize, sortby"),ua=t("td"),ma=s("JSON"),ya=t("td"),Oa=o(),Sa=t("tr"),ka=t("td"),Pa=s("POST"),Ra=t("td"),Ja=s("api/get-hf-search"),Na=t("td"),ja=s("searchKeyword, token, pageno, pagesize, sortby"),Ia=t("td"),Ba=s("JSON"),La=t("td"),xa=o(),za=t("tr"),Aa=t("td"),wa=s("POST"),Ha=t("td"),Va=s("api/get-hf-byHfCode"),Ua=t("td"),Ma=s("token, code"),Ca=t("td"),Ka=s("JSON"),qa=t("td"),Fa=o(),Ga=t("tr"),Qa=t("td"),Wa=s("POST"),Xa=t("td"),Ya=s("api/get-hf-byProvince"),Za=t("td"),$a=s("token, province, pageno, pagesize, sortby"),_a=t("td"),ar=s("JSON"),rr=t("td"),er=o(),or=t("tr"),tr=t("td"),sr=s("POST"),cr=t("td"),hr=s("api/get-hf-byDistrict"),ir=t("td"),fr=s("token, district, pageno, pagesize, sortby"),dr=t("td"),vr=s("JSON"),nr=t("td"),pr=o(),lr=t("tr"),Tr=t("td"),Er=s("POST"),br=t("td"),gr=s("api/get-hf-byMunicipality"),Dr=t("td"),ur=s("token, municipality, pageno, pagesize, sortby"),mr=t("td"),yr=s("JSON"),Or=t("td"),Sr=o(),kr=t("tr"),Pr=t("td"),Rr=s("POST"),Jr=t("td"),Nr=s("api/hf-create"),jr=t("td"),Ir=s("token,[form elements]"),Br=t("td"),Lr=s("JSON"),xr=t("td"),zr=o(),Ar=t("tr"),wr=t("td"),Hr=s("POST"),Vr=t("td"),Ur=s("api/hf-update"),Mr=t("td"),Cr=s("token,[form elements]"),Kr=t("td"),qr=s("JSON"),Fr=t("td"),this.h()},l(a){c('[data-svelte="svelte-1w1wnis"]',document.head).forEach(h),r=i(a),e=f(a,"DIV",{}),d(e).forEach(h),D=i(a),u=f(a,"A",{class:!0,style:!0,href:!0});var o=d(u);m=v(o,"Log Out\r\n              "),o.forEach(h),y=f(a,"BR",{}),O=f(a,"BR",{}),S=f(a,"BR",{}),k=i(a),P=f(a,"DIV",{class:!0});var t=d(P);R=f(t,"DIV",{class:!0});var s=d(R);J=f(s,"DIV",{class:!0});var n=d(J);N=f(n,"DIV",{class:!0});var p=d(N);j=f(p,"H3",{class:!0});var l=d(j);I=v(l,Qr),B=v(l,"          "),l.forEach(h),L=i(p),x=f(p,"UL",{class:!0});var T=d(x);z=f(T,"LI",{class:!0});var E=d(z);A=f(E,"B",{});var b=d(A);w=v(b,"Username:"),b.forEach(h),H=i(E),V=f(E,"B",{class:!0});var g=d(V);U=v(g,Wr),g.forEach(h),E.forEach(h),M=i(T),C=f(T,"LI",{class:!0});var Gr=d(C);K=f(Gr,"B",{});var Yr=d(K);q=v(Yr,"API Token:"),Yr.forEach(h),F=i(Gr),G=f(Gr,"B",{class:!0});var Zr=d(G);Q=v(Zr,Xr),Zr.forEach(h),Gr.forEach(h),T.forEach(h),W=i(p),X=f(p,"A",{href:!0,class:!0});var $r=d(X);Y=f($r,"B",{});var _r=d(Y);Z=v(_r,"Refresh API Token"),_r.forEach(h),$r.forEach(h),p.forEach(h),n.forEach(h),s.forEach(h),$=i(t),_=f(t,"DIV",{id:!0,class:!0});var ae=d(_);aa=f(ae,"TABLE",{id:!0,class:!0});var re=d(aa);ra=f(re,"TR",{});var ee=d(ra);ea=f(ee,"TH",{});var oe=d(ea);oa=v(oe,"Method"),oe.forEach(h),ta=f(ee,"TH",{});var te=d(ta);sa=v(te,"URL"),te.forEach(h),ca=f(ee,"TH",{});var se=d(ca);ha=v(se,"Body"),se.forEach(h),ia=f(ee,"TH",{});var ce=d(ia);fa=v(ce,"Result"),ce.forEach(h),da=f(ee,"TH",{});var he=d(da);va=v(he,"Remarks"),he.forEach(h),ee.forEach(h),na=i(re),pa=f(re,"TR",{});var ie=d(pa);la=f(ie,"TD",{});var fe=d(la);Ta=v(fe,"POST"),fe.forEach(h),Ea=f(ie,"TD",{});var de=d(Ea);ba=v(de,"api/get-hf"),de.forEach(h),ga=f(ie,"TD",{});var ve=d(ga);Da=v(ve,"token, pageno, pagesize, sortby"),ve.forEach(h),ua=f(ie,"TD",{});var ne=d(ua);ma=v(ne,"JSON"),ne.forEach(h),ya=f(ie,"TD",{}),d(ya).forEach(h),ie.forEach(h),Oa=i(re),Sa=f(re,"TR",{});var pe=d(Sa);ka=f(pe,"TD",{});var le=d(ka);Pa=v(le,"POST"),le.forEach(h),Ra=f(pe,"TD",{});var Te=d(Ra);Ja=v(Te,"api/get-hf-search"),Te.forEach(h),Na=f(pe,"TD",{});var Ee=d(Na);ja=v(Ee,"searchKeyword, token, pageno, pagesize, sortby"),Ee.forEach(h),Ia=f(pe,"TD",{});var be=d(Ia);Ba=v(be,"JSON"),be.forEach(h),La=f(pe,"TD",{}),d(La).forEach(h),pe.forEach(h),xa=i(re),za=f(re,"TR",{});var ge=d(za);Aa=f(ge,"TD",{});var De=d(Aa);wa=v(De,"POST"),De.forEach(h),Ha=f(ge,"TD",{});var ue=d(Ha);Va=v(ue,"api/get-hf-byHfCode"),ue.forEach(h),Ua=f(ge,"TD",{});var me=d(Ua);Ma=v(me,"token, code"),me.forEach(h),Ca=f(ge,"TD",{});var ye=d(Ca);Ka=v(ye,"JSON"),ye.forEach(h),qa=f(ge,"TD",{}),d(qa).forEach(h),ge.forEach(h),Fa=i(re),Ga=f(re,"TR",{});var Oe=d(Ga);Qa=f(Oe,"TD",{});var Se=d(Qa);Wa=v(Se,"POST"),Se.forEach(h),Xa=f(Oe,"TD",{});var ke=d(Xa);Ya=v(ke,"api/get-hf-byProvince"),ke.forEach(h),Za=f(Oe,"TD",{});var Pe=d(Za);$a=v(Pe,"token, province, pageno, pagesize, sortby"),Pe.forEach(h),_a=f(Oe,"TD",{});var Re=d(_a);ar=v(Re,"JSON"),Re.forEach(h),rr=f(Oe,"TD",{}),d(rr).forEach(h),Oe.forEach(h),er=i(re),or=f(re,"TR",{});var Je=d(or);tr=f(Je,"TD",{});var Ne=d(tr);sr=v(Ne,"POST"),Ne.forEach(h),cr=f(Je,"TD",{});var je=d(cr);hr=v(je,"api/get-hf-byDistrict"),je.forEach(h),ir=f(Je,"TD",{});var Ie=d(ir);fr=v(Ie,"token, district, pageno, pagesize, sortby"),Ie.forEach(h),dr=f(Je,"TD",{});var Be=d(dr);vr=v(Be,"JSON"),Be.forEach(h),nr=f(Je,"TD",{}),d(nr).forEach(h),Je.forEach(h),pr=i(re),lr=f(re,"TR",{});var Le=d(lr);Tr=f(Le,"TD",{});var xe=d(Tr);Er=v(xe,"POST"),xe.forEach(h),br=f(Le,"TD",{});var ze=d(br);gr=v(ze,"api/get-hf-byMunicipality"),ze.forEach(h),Dr=f(Le,"TD",{});var Ae=d(Dr);ur=v(Ae,"token, municipality, pageno, pagesize, sortby"),Ae.forEach(h),mr=f(Le,"TD",{});var we=d(mr);yr=v(we,"JSON"),we.forEach(h),Or=f(Le,"TD",{}),d(Or).forEach(h),Le.forEach(h),Sr=i(re),kr=f(re,"TR",{});var He=d(kr);Pr=f(He,"TD",{});var Ve=d(Pr);Rr=v(Ve,"POST"),Ve.forEach(h),Jr=f(He,"TD",{});var Ue=d(Jr);Nr=v(Ue,"api/hf-create"),Ue.forEach(h),jr=f(He,"TD",{});var Me=d(jr);Ir=v(Me,"token,[form elements]"),Me.forEach(h),Br=f(He,"TD",{});var Ce=d(Br);Lr=v(Ce,"JSON"),Ce.forEach(h),xr=f(He,"TD",{}),d(xr).forEach(h),He.forEach(h),zr=i(re),Ar=f(re,"TR",{});var Ke=d(Ar);wr=f(Ke,"TD",{});var qe=d(wr);Hr=v(qe,"POST"),qe.forEach(h),Vr=f(Ke,"TD",{});var Fe=d(Vr);Ur=v(Fe,"api/hf-update"),Fe.forEach(h),Mr=f(Ke,"TD",{});var Ge=d(Mr);Cr=v(Ge,"token,[form elements]"),Ge.forEach(h),Kr=f(Ke,"TD",{});var Qe=d(Kr);qr=v(Qe,"JSON"),Qe.forEach(h),Fr=f(Ke,"TD",{}),d(Fr).forEach(h),Ke.forEach(h),re.forEach(h),ae.forEach(h),t.forEach(h),this.h()},h(){document.title="Api Login",n(u,"class","button"),p(u,"float","right"),n(u,"href","javascript:void(0)"),n(j,"class","profile-username text-center"),n(V,"class","pull-right"),n(z,"class","list-group-item"),n(G,"class","pull-right"),n(C,"class","list-group-item"),n(x,"class","list-group list-group-unbordered"),n(X,"href","javascript:void(0)"),n(X,"class","btn btn-primary btn-block"),n(N,"class","box-body box-profile"),n(J,"class","box box-primary"),n(R,"class","col-md-6"),n(aa,"id","list-table"),n(aa,"class","table table-striped table-bordered"),n(_,"id","showtable"),n(_,"class","box-body col-md-6"),n(P,"class","row")},m(o,t){l(o,r,t),l(o,e,t),l(o,D,t),l(o,u,t),T(u,m),l(o,y,t),l(o,O,t),l(o,S,t),l(o,k,t),l(o,P,t),T(P,R),T(R,J),T(J,N),T(N,j),T(j,I),T(j,B),T(N,L),T(N,x),T(x,z),T(z,A),T(A,w),T(z,H),T(z,V),T(V,U),T(x,M),T(x,C),T(C,K),T(K,q),T(C,F),T(C,G),T(G,Q),T(N,W),T(N,X),T(X,Y),T(Y,Z),T(P,$),T(P,_),T(_,aa),T(aa,ra),T(ra,ea),T(ea,oa),T(ra,ta),T(ta,sa),T(ra,ca),T(ca,ha),T(ra,ia),T(ia,fa),T(ra,da),T(da,va),T(aa,na),T(aa,pa),T(pa,la),T(la,Ta),T(pa,Ea),T(Ea,ba),T(pa,ga),T(ga,Da),T(pa,ua),T(ua,ma),T(pa,ya),T(aa,Oa),T(aa,Sa),T(Sa,ka),T(ka,Pa),T(Sa,Ra),T(Ra,Ja),T(Sa,Na),T(Na,ja),T(Sa,Ia),T(Ia,Ba),T(Sa,La),T(aa,xa),T(aa,za),T(za,Aa),T(Aa,wa),T(za,Ha),T(Ha,Va),T(za,Ua),T(Ua,Ma),T(za,Ca),T(Ca,Ka),T(za,qa),T(aa,Fa),T(aa,Ga),T(Ga,Qa),T(Qa,Wa),T(Ga,Xa),T(Xa,Ya),T(Ga,Za),T(Za,$a),T(Ga,_a),T(_a,ar),T(Ga,rr),T(aa,er),T(aa,or),T(or,tr),T(tr,sr),T(or,cr),T(cr,hr),T(or,ir),T(ir,fr),T(or,dr),T(dr,vr),T(or,nr),T(aa,pr),T(aa,lr),T(lr,Tr),T(Tr,Er),T(lr,br),T(br,gr),T(lr,Dr),T(Dr,ur),T(lr,mr),T(mr,yr),T(lr,Or),T(aa,Sr),T(aa,kr),T(kr,Pr),T(Pr,Rr),T(kr,Jr),T(Jr,Nr),T(kr,jr),T(jr,Ir),T(kr,Br),T(Br,Lr),T(kr,xr),T(aa,zr),T(aa,Ar),T(Ar,wr),T(wr,Hr),T(Ar,Vr),T(Vr,Ur),T(Ar,Mr),T(Mr,Cr),T(Ar,Kr),T(Kr,qr),T(Ar,Fr),Gr=E(u,"click",a[0])},p:b,i:b,o:b,d(a){a&&h(r),a&&h(e),a&&h(D),a&&h(u),a&&h(y),a&&h(O),a&&h(S),a&&h(k),a&&h(P),Gr()}}}function u(a){return[a=>void(confirm("Are you sure you want to Logout?")&&(g.remove("apiusertoken"),g.remove("apiuserid"),g.remove("apiuserfullname"),g.remove("apiuserusername"),window.location.replace("apiLogin")))]}export default class extends a{constructor(a){super(),r(this,a,u,D,e,{})}}
