import{S as a,i as r,s as o,a as e,e as t,t as s,A as c,f,g as h,c as i,b as d,d as v,h as p,j as n,k as l,l as T,m as E,n as b}from"./index.e5c655c7.js";import"./create.bcc8dfec.js";import"./index.02e345fc.js";import"./app.8e87bdbb.js";import"./_commonjsHelpers.fffabd3b.js";import{C as g}from"./js.cookie.7f372dc7.js";import"./jquery.dc1d5bd8.js";import"./fetchdata.afb1a114.js";function D(a){let r,o,D,m,u,y,O,S,k,P,R,J,N,j,I,B,L,x,z,A,w,H,V,U,M,C,K,q,_,F,G,Q,W,X,Y,Z,$,aa,ra,oa,ea,ta,sa,ca,fa,ha,ia,da,va,pa,na,la,Ta,Ea,ba,ga,Da,ma,ua,ya,Oa,Sa,ka,Pa,Ra,Ja,Na,ja,Ia,Ba,La,xa,za,Aa,wa,Ha,Va,Ua,Ma,Ca,Ka,qa,_a,Fa,Ga,Qa,Wa,Xa,Ya,Za,$a,ar,rr,or,er,tr,sr,cr,fr,hr,ir,dr,vr,pr,nr,lr,Tr,Er,br,gr,Dr,mr,ur,yr,Or,Sr,kr,Pr,Rr,Jr,Nr,jr,Ir,Br,Lr,xr,zr,Ar,wr,Hr,Vr,Ur,Mr,Cr,Kr,qr,_r,Fr,Gr=g.get("apiuserfullname")+"",Qr=g.get("apiuserusername")+"",Wr=g.get("apiusertoken")+"";return{c(){r=e(),o=t("div"),D=e(),m=t("a"),u=s("Log Out\r\n              "),y=t("br"),O=t("br"),S=t("br"),k=e(),P=t("div"),R=t("div"),J=t("div"),N=t("div"),j=t("h3"),I=s(Gr),B=s("          "),L=e(),x=t("ul"),z=t("li"),A=t("b"),w=s("Username:"),H=e(),V=t("b"),U=s(Qr),M=e(),C=t("li"),K=t("b"),q=s("API Token:"),_=e(),F=t("b"),G=s(Wr),Q=e(),W=t("a"),X=t("b"),Y=s("Refresh API Token"),Z=e(),$=t("div"),aa=t("table"),ra=t("tr"),oa=t("th"),ea=s("Method"),ta=t("th"),sa=s("URL"),ca=t("th"),fa=s("Body"),ha=t("th"),ia=s("Result"),da=t("th"),va=s("Remarks"),pa=e(),na=t("tr"),la=t("td"),Ta=s("POST"),Ea=t("td"),ba=s("api/get-hf"),ga=t("td"),Da=s("token, pageno, pagesize, sortby"),ma=t("td"),ua=s("JSON"),ya=t("td"),Oa=e(),Sa=t("tr"),ka=t("td"),Pa=s("POST"),Ra=t("td"),Ja=s("api/get-hf-search"),Na=t("td"),ja=s("searchKeyword, token, pageno, pagesize, sortby"),Ia=t("td"),Ba=s("JSON"),La=t("td"),xa=e(),za=t("tr"),Aa=t("td"),wa=s("POST"),Ha=t("td"),Va=s("api/get-hf-byHfCode"),Ua=t("td"),Ma=s("token, code"),Ca=t("td"),Ka=s("JSON"),qa=t("td"),_a=e(),Fa=t("tr"),Ga=t("td"),Qa=s("POST"),Wa=t("td"),Xa=s("api/get-hf-byProvince"),Ya=t("td"),Za=s("token, province, pageno, pagesize, sortby"),$a=t("td"),ar=s("JSON"),rr=t("td"),or=e(),er=t("tr"),tr=t("td"),sr=s("POST"),cr=t("td"),fr=s("api/get-hf-byDistrict"),hr=t("td"),ir=s("token, district, pageno, pagesize, sortby"),dr=t("td"),vr=s("JSON"),pr=t("td"),nr=e(),lr=t("tr"),Tr=t("td"),Er=s("POST"),br=t("td"),gr=s("api/get-hf-byMunicipality"),Dr=t("td"),mr=s("token, municipality, pageno, pagesize, sortby"),ur=t("td"),yr=s("JSON"),Or=t("td"),Sr=e(),kr=t("tr"),Pr=t("td"),Rr=s("POST"),Jr=t("td"),Nr=s("api/hf-create"),jr=t("td"),Ir=s("token,[form elements]"),Br=t("td"),Lr=s("JSON"),xr=t("td"),zr=e(),Ar=t("tr"),wr=t("td"),Hr=s("POST"),Vr=t("td"),Ur=s("api/hf-update"),Mr=t("td"),Cr=s("token,[form elements]"),Kr=t("td"),qr=s("JSON"),_r=t("td"),this.h()},l(a){c('[data-svelte="svelte-1w1wnis"]',document.head).forEach(f),r=h(a),o=i(a,"DIV",{}),d(o).forEach(f),D=h(a),m=i(a,"A",{class:!0,style:!0,href:!0});var e=d(m);u=v(e,"Log Out\r\n              "),e.forEach(f),y=i(a,"BR",{}),O=i(a,"BR",{}),S=i(a,"BR",{}),k=h(a),P=i(a,"DIV",{class:!0});var t=d(P);R=i(t,"DIV",{class:!0});var s=d(R);J=i(s,"DIV",{class:!0});var p=d(J);N=i(p,"DIV",{class:!0});var n=d(N);j=i(n,"H3",{class:!0});var l=d(j);I=v(l,Gr),B=v(l,"          "),l.forEach(f),L=h(n),x=i(n,"UL",{class:!0});var T=d(x);z=i(T,"LI",{class:!0});var E=d(z);A=i(E,"B",{});var b=d(A);w=v(b,"Username:"),b.forEach(f),H=h(E),V=i(E,"B",{class:!0});var g=d(V);U=v(g,Qr),g.forEach(f),E.forEach(f),M=h(T),C=i(T,"LI",{class:!0});var Fr=d(C);K=i(Fr,"B",{});var Xr=d(K);q=v(Xr,"API Token:"),Xr.forEach(f),_=h(Fr),F=i(Fr,"B",{class:!0});var Yr=d(F);G=v(Yr,Wr),Yr.forEach(f),Fr.forEach(f),T.forEach(f),Q=h(n),W=i(n,"A",{href:!0,class:!0});var Zr=d(W);X=i(Zr,"B",{});var $r=d(X);Y=v($r,"Refresh API Token"),$r.forEach(f),Zr.forEach(f),n.forEach(f),p.forEach(f),s.forEach(f),Z=h(t),$=i(t,"DIV",{id:!0,class:!0});var ao=d($);aa=i(ao,"TABLE",{id:!0,class:!0});var ro=d(aa);ra=i(ro,"TR",{});var oo=d(ra);oa=i(oo,"TH",{});var eo=d(oa);ea=v(eo,"Method"),eo.forEach(f),ta=i(oo,"TH",{});var to=d(ta);sa=v(to,"URL"),to.forEach(f),ca=i(oo,"TH",{});var so=d(ca);fa=v(so,"Body"),so.forEach(f),ha=i(oo,"TH",{});var co=d(ha);ia=v(co,"Result"),co.forEach(f),da=i(oo,"TH",{});var fo=d(da);va=v(fo,"Remarks"),fo.forEach(f),oo.forEach(f),pa=h(ro),na=i(ro,"TR",{});var ho=d(na);la=i(ho,"TD",{});var io=d(la);Ta=v(io,"POST"),io.forEach(f),Ea=i(ho,"TD",{});var vo=d(Ea);ba=v(vo,"api/get-hf"),vo.forEach(f),ga=i(ho,"TD",{});var po=d(ga);Da=v(po,"token, pageno, pagesize, sortby"),po.forEach(f),ma=i(ho,"TD",{});var no=d(ma);ua=v(no,"JSON"),no.forEach(f),ya=i(ho,"TD",{}),d(ya).forEach(f),ho.forEach(f),Oa=h(ro),Sa=i(ro,"TR",{});var lo=d(Sa);ka=i(lo,"TD",{});var To=d(ka);Pa=v(To,"POST"),To.forEach(f),Ra=i(lo,"TD",{});var Eo=d(Ra);Ja=v(Eo,"api/get-hf-search"),Eo.forEach(f),Na=i(lo,"TD",{});var bo=d(Na);ja=v(bo,"searchKeyword, token, pageno, pagesize, sortby"),bo.forEach(f),Ia=i(lo,"TD",{});var go=d(Ia);Ba=v(go,"JSON"),go.forEach(f),La=i(lo,"TD",{}),d(La).forEach(f),lo.forEach(f),xa=h(ro),za=i(ro,"TR",{});var Do=d(za);Aa=i(Do,"TD",{});var mo=d(Aa);wa=v(mo,"POST"),mo.forEach(f),Ha=i(Do,"TD",{});var uo=d(Ha);Va=v(uo,"api/get-hf-byHfCode"),uo.forEach(f),Ua=i(Do,"TD",{});var yo=d(Ua);Ma=v(yo,"token, code"),yo.forEach(f),Ca=i(Do,"TD",{});var Oo=d(Ca);Ka=v(Oo,"JSON"),Oo.forEach(f),qa=i(Do,"TD",{}),d(qa).forEach(f),Do.forEach(f),_a=h(ro),Fa=i(ro,"TR",{});var So=d(Fa);Ga=i(So,"TD",{});var ko=d(Ga);Qa=v(ko,"POST"),ko.forEach(f),Wa=i(So,"TD",{});var Po=d(Wa);Xa=v(Po,"api/get-hf-byProvince"),Po.forEach(f),Ya=i(So,"TD",{});var Ro=d(Ya);Za=v(Ro,"token, province, pageno, pagesize, sortby"),Ro.forEach(f),$a=i(So,"TD",{});var Jo=d($a);ar=v(Jo,"JSON"),Jo.forEach(f),rr=i(So,"TD",{}),d(rr).forEach(f),So.forEach(f),or=h(ro),er=i(ro,"TR",{});var No=d(er);tr=i(No,"TD",{});var jo=d(tr);sr=v(jo,"POST"),jo.forEach(f),cr=i(No,"TD",{});var Io=d(cr);fr=v(Io,"api/get-hf-byDistrict"),Io.forEach(f),hr=i(No,"TD",{});var Bo=d(hr);ir=v(Bo,"token, district, pageno, pagesize, sortby"),Bo.forEach(f),dr=i(No,"TD",{});var Lo=d(dr);vr=v(Lo,"JSON"),Lo.forEach(f),pr=i(No,"TD",{}),d(pr).forEach(f),No.forEach(f),nr=h(ro),lr=i(ro,"TR",{});var xo=d(lr);Tr=i(xo,"TD",{});var zo=d(Tr);Er=v(zo,"POST"),zo.forEach(f),br=i(xo,"TD",{});var Ao=d(br);gr=v(Ao,"api/get-hf-byMunicipality"),Ao.forEach(f),Dr=i(xo,"TD",{});var wo=d(Dr);mr=v(wo,"token, municipality, pageno, pagesize, sortby"),wo.forEach(f),ur=i(xo,"TD",{});var Ho=d(ur);yr=v(Ho,"JSON"),Ho.forEach(f),Or=i(xo,"TD",{}),d(Or).forEach(f),xo.forEach(f),Sr=h(ro),kr=i(ro,"TR",{});var Vo=d(kr);Pr=i(Vo,"TD",{});var Uo=d(Pr);Rr=v(Uo,"POST"),Uo.forEach(f),Jr=i(Vo,"TD",{});var Mo=d(Jr);Nr=v(Mo,"api/hf-create"),Mo.forEach(f),jr=i(Vo,"TD",{});var Co=d(jr);Ir=v(Co,"token,[form elements]"),Co.forEach(f),Br=i(Vo,"TD",{});var Ko=d(Br);Lr=v(Ko,"JSON"),Ko.forEach(f),xr=i(Vo,"TD",{}),d(xr).forEach(f),Vo.forEach(f),zr=h(ro),Ar=i(ro,"TR",{});var qo=d(Ar);wr=i(qo,"TD",{});var _o=d(wr);Hr=v(_o,"POST"),_o.forEach(f),Vr=i(qo,"TD",{});var Fo=d(Vr);Ur=v(Fo,"api/hf-update"),Fo.forEach(f),Mr=i(qo,"TD",{});var Go=d(Mr);Cr=v(Go,"token,[form elements]"),Go.forEach(f),Kr=i(qo,"TD",{});var Qo=d(Kr);qr=v(Qo,"JSON"),Qo.forEach(f),_r=i(qo,"TD",{}),d(_r).forEach(f),qo.forEach(f),ro.forEach(f),ao.forEach(f),t.forEach(f),this.h()},h(){document.title="Api Login",p(m,"class","button"),n(m,"float","right"),p(m,"href","javascript:void(0)"),p(j,"class","profile-username text-center"),p(V,"class","pull-right"),p(z,"class","list-group-item"),p(F,"class","pull-right"),p(C,"class","list-group-item"),p(x,"class","list-group list-group-unbordered"),p(W,"href","javascript:void(0)"),p(W,"class","btn btn-primary btn-block"),p(N,"class","box-body box-profile"),p(J,"class","box box-primary"),p(R,"class","col-md-6"),p(aa,"id","list-table"),p(aa,"class","table table-striped table-bordered"),p($,"id","showtable"),p($,"class","box-body col-md-6"),p(P,"class","row")},m(e,t){l(e,r,t),l(e,o,t),l(e,D,t),l(e,m,t),T(m,u),l(e,y,t),l(e,O,t),l(e,S,t),l(e,k,t),l(e,P,t),T(P,R),T(R,J),T(J,N),T(N,j),T(j,I),T(j,B),T(N,L),T(N,x),T(x,z),T(z,A),T(A,w),T(z,H),T(z,V),T(V,U),T(x,M),T(x,C),T(C,K),T(K,q),T(C,_),T(C,F),T(F,G),T(N,Q),T(N,W),T(W,X),T(X,Y),T(P,Z),T(P,$),T($,aa),T(aa,ra),T(ra,oa),T(oa,ea),T(ra,ta),T(ta,sa),T(ra,ca),T(ca,fa),T(ra,ha),T(ha,ia),T(ra,da),T(da,va),T(aa,pa),T(aa,na),T(na,la),T(la,Ta),T(na,Ea),T(Ea,ba),T(na,ga),T(ga,Da),T(na,ma),T(ma,ua),T(na,ya),T(aa,Oa),T(aa,Sa),T(Sa,ka),T(ka,Pa),T(Sa,Ra),T(Ra,Ja),T(Sa,Na),T(Na,ja),T(Sa,Ia),T(Ia,Ba),T(Sa,La),T(aa,xa),T(aa,za),T(za,Aa),T(Aa,wa),T(za,Ha),T(Ha,Va),T(za,Ua),T(Ua,Ma),T(za,Ca),T(Ca,Ka),T(za,qa),T(aa,_a),T(aa,Fa),T(Fa,Ga),T(Ga,Qa),T(Fa,Wa),T(Wa,Xa),T(Fa,Ya),T(Ya,Za),T(Fa,$a),T($a,ar),T(Fa,rr),T(aa,or),T(aa,er),T(er,tr),T(tr,sr),T(er,cr),T(cr,fr),T(er,hr),T(hr,ir),T(er,dr),T(dr,vr),T(er,pr),T(aa,nr),T(aa,lr),T(lr,Tr),T(Tr,Er),T(lr,br),T(br,gr),T(lr,Dr),T(Dr,mr),T(lr,ur),T(ur,yr),T(lr,Or),T(aa,Sr),T(aa,kr),T(kr,Pr),T(Pr,Rr),T(kr,Jr),T(Jr,Nr),T(kr,jr),T(jr,Ir),T(kr,Br),T(Br,Lr),T(kr,xr),T(aa,zr),T(aa,Ar),T(Ar,wr),T(wr,Hr),T(Ar,Vr),T(Vr,Ur),T(Ar,Mr),T(Mr,Cr),T(Ar,Kr),T(Kr,qr),T(Ar,_r),Fr=E(m,"click",a[0])},p:b,i:b,o:b,d(a){a&&f(r),a&&f(o),a&&f(D),a&&f(m),a&&f(y),a&&f(O),a&&f(S),a&&f(k),a&&f(P),Fr()}}}function m(a){return[a=>void(confirm("Are you sure you want to Logout?")&&(g.remove("apiusertoken"),g.remove("apiuserid"),g.remove("apiuserfullname"),g.remove("apiuserusername"),window.location.replace("apiLogin")))]}export default class extends a{constructor(a){super(),r(this,a,m,D,o,{})}}
