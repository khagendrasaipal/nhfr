import{S as a,i as r,s as o,a as e,e as t,t as s,A as c,f as h,g as i,c as f,b as d,d as v,h as n,j as p,k as l,l as T,m as E,n as b}from"./index.e5c655c7.js";import"./create.15ee5e82.js";import"./index.72429f81.js";import"./app.3d6ba03a.js";import{C as g}from"./js.cookie.a0f74474.js";import"./jquery.84830057.js";import"./fetchdata.678a37a2.js";function D(a){let r,o,D,u,m,y,O,S,k,P,R,J,N,j,I,B,L,x,z,A,w,H,V,U,M,C,K,q,F,G,Q,W,X,Y,Z,$,_,aa,ra,oa,ea,ta,sa,ca,ha,ia,fa,da,va,na,pa,la,Ta,Ea,ba,ga,Da,ua,ma,ya,Oa,Sa,ka,Pa,Ra,Ja,Na,ja,Ia,Ba,La,xa,za,Aa,wa,Ha,Va,Ua,Ma,Ca,Ka,qa,Fa,Ga,Qa,Wa,Xa,Ya,Za,$a,_a,ar,rr,or,er,tr,sr,cr,hr,ir,fr,dr,vr,nr,pr,lr,Tr,Er,br,gr,Dr,ur,mr,yr,Or,Sr,kr,Pr,Rr,Jr,Nr,jr,Ir,Br,Lr,xr,zr,Ar,wr,Hr,Vr,Ur,Mr,Cr,Kr,qr,Fr,Gr,Qr=g.get("apiuserfullname")+"",Wr=g.get("apiuserusername")+"",Xr=g.get("apiusertoken")+"";return{c(){r=e(),o=t("div"),D=e(),u=t("a"),m=s("Log Out\r\n              "),y=t("br"),O=t("br"),S=t("br"),k=e(),P=t("div"),R=t("div"),J=t("div"),N=t("div"),j=t("h3"),I=s(Qr),B=s("          "),L=e(),x=t("ul"),z=t("li"),A=t("b"),w=s("Username:"),H=e(),V=t("b"),U=s(Wr),M=e(),C=t("li"),K=t("b"),q=s("API Token:"),F=e(),G=t("b"),Q=s(Xr),W=e(),X=t("a"),Y=t("b"),Z=s("Refresh API Token"),$=e(),_=t("div"),aa=t("table"),ra=t("tr"),oa=t("th"),ea=s("Method"),ta=t("th"),sa=s("URL"),ca=t("th"),ha=s("Body"),ia=t("th"),fa=s("Result"),da=t("th"),va=s("Remarks"),na=e(),pa=t("tr"),la=t("td"),Ta=s("POST"),Ea=t("td"),ba=s("api/get-hf"),ga=t("td"),Da=s("token, pageno, pagesize, sortby"),ua=t("td"),ma=s("JSON"),ya=t("td"),Oa=e(),Sa=t("tr"),ka=t("td"),Pa=s("POST"),Ra=t("td"),Ja=s("api/get-hf-search"),Na=t("td"),ja=s("searchKeyword, token, pageno, pagesize, sortby"),Ia=t("td"),Ba=s("JSON"),La=t("td"),xa=e(),za=t("tr"),Aa=t("td"),wa=s("POST"),Ha=t("td"),Va=s("api/get-hf-byHfCode"),Ua=t("td"),Ma=s("token, code"),Ca=t("td"),Ka=s("JSON"),qa=t("td"),Fa=e(),Ga=t("tr"),Qa=t("td"),Wa=s("POST"),Xa=t("td"),Ya=s("api/get-hf-byProvince"),Za=t("td"),$a=s("token, province, pageno, pagesize, sortby"),_a=t("td"),ar=s("JSON"),rr=t("td"),or=e(),er=t("tr"),tr=t("td"),sr=s("POST"),cr=t("td"),hr=s("api/get-hf-byDistrict"),ir=t("td"),fr=s("token, district, pageno, pagesize, sortby"),dr=t("td"),vr=s("JSON"),nr=t("td"),pr=e(),lr=t("tr"),Tr=t("td"),Er=s("POST"),br=t("td"),gr=s("api/get-hf-byMunicipality"),Dr=t("td"),ur=s("token, municipality, pageno, pagesize, sortby"),mr=t("td"),yr=s("JSON"),Or=t("td"),Sr=e(),kr=t("tr"),Pr=t("td"),Rr=s("POST"),Jr=t("td"),Nr=s("api/hf-create"),jr=t("td"),Ir=s("token,[form elements]"),Br=t("td"),Lr=s("JSON"),xr=t("td"),zr=e(),Ar=t("tr"),wr=t("td"),Hr=s("POST"),Vr=t("td"),Ur=s("api/hf-update"),Mr=t("td"),Cr=s("token,[form elements]"),Kr=t("td"),qr=s("JSON"),Fr=t("td"),this.h()},l(a){c('[data-svelte="svelte-1w1wnis"]',document.head).forEach(h),r=i(a),o=f(a,"DIV",{}),d(o).forEach(h),D=i(a),u=f(a,"A",{class:!0,style:!0,href:!0});var e=d(u);m=v(e,"Log Out\r\n              "),e.forEach(h),y=f(a,"BR",{}),O=f(a,"BR",{}),S=f(a,"BR",{}),k=i(a),P=f(a,"DIV",{class:!0});var t=d(P);R=f(t,"DIV",{class:!0});var s=d(R);J=f(s,"DIV",{class:!0});var n=d(J);N=f(n,"DIV",{class:!0});var p=d(N);j=f(p,"H3",{class:!0});var l=d(j);I=v(l,Qr),B=v(l,"          "),l.forEach(h),L=i(p),x=f(p,"UL",{class:!0});var T=d(x);z=f(T,"LI",{class:!0});var E=d(z);A=f(E,"B",{});var b=d(A);w=v(b,"Username:"),b.forEach(h),H=i(E),V=f(E,"B",{class:!0});var g=d(V);U=v(g,Wr),g.forEach(h),E.forEach(h),M=i(T),C=f(T,"LI",{class:!0});var Gr=d(C);K=f(Gr,"B",{});var Yr=d(K);q=v(Yr,"API Token:"),Yr.forEach(h),F=i(Gr),G=f(Gr,"B",{class:!0});var Zr=d(G);Q=v(Zr,Xr),Zr.forEach(h),Gr.forEach(h),T.forEach(h),W=i(p),X=f(p,"A",{href:!0,class:!0});var $r=d(X);Y=f($r,"B",{});var _r=d(Y);Z=v(_r,"Refresh API Token"),_r.forEach(h),$r.forEach(h),p.forEach(h),n.forEach(h),s.forEach(h),$=i(t),_=f(t,"DIV",{id:!0,class:!0});var ao=d(_);aa=f(ao,"TABLE",{id:!0,class:!0});var ro=d(aa);ra=f(ro,"TR",{});var oo=d(ra);oa=f(oo,"TH",{});var eo=d(oa);ea=v(eo,"Method"),eo.forEach(h),ta=f(oo,"TH",{});var to=d(ta);sa=v(to,"URL"),to.forEach(h),ca=f(oo,"TH",{});var so=d(ca);ha=v(so,"Body"),so.forEach(h),ia=f(oo,"TH",{});var co=d(ia);fa=v(co,"Result"),co.forEach(h),da=f(oo,"TH",{});var ho=d(da);va=v(ho,"Remarks"),ho.forEach(h),oo.forEach(h),na=i(ro),pa=f(ro,"TR",{});var io=d(pa);la=f(io,"TD",{});var fo=d(la);Ta=v(fo,"POST"),fo.forEach(h),Ea=f(io,"TD",{});var vo=d(Ea);ba=v(vo,"api/get-hf"),vo.forEach(h),ga=f(io,"TD",{});var no=d(ga);Da=v(no,"token, pageno, pagesize, sortby"),no.forEach(h),ua=f(io,"TD",{});var po=d(ua);ma=v(po,"JSON"),po.forEach(h),ya=f(io,"TD",{}),d(ya).forEach(h),io.forEach(h),Oa=i(ro),Sa=f(ro,"TR",{});var lo=d(Sa);ka=f(lo,"TD",{});var To=d(ka);Pa=v(To,"POST"),To.forEach(h),Ra=f(lo,"TD",{});var Eo=d(Ra);Ja=v(Eo,"api/get-hf-search"),Eo.forEach(h),Na=f(lo,"TD",{});var bo=d(Na);ja=v(bo,"searchKeyword, token, pageno, pagesize, sortby"),bo.forEach(h),Ia=f(lo,"TD",{});var go=d(Ia);Ba=v(go,"JSON"),go.forEach(h),La=f(lo,"TD",{}),d(La).forEach(h),lo.forEach(h),xa=i(ro),za=f(ro,"TR",{});var Do=d(za);Aa=f(Do,"TD",{});var uo=d(Aa);wa=v(uo,"POST"),uo.forEach(h),Ha=f(Do,"TD",{});var mo=d(Ha);Va=v(mo,"api/get-hf-byHfCode"),mo.forEach(h),Ua=f(Do,"TD",{});var yo=d(Ua);Ma=v(yo,"token, code"),yo.forEach(h),Ca=f(Do,"TD",{});var Oo=d(Ca);Ka=v(Oo,"JSON"),Oo.forEach(h),qa=f(Do,"TD",{}),d(qa).forEach(h),Do.forEach(h),Fa=i(ro),Ga=f(ro,"TR",{});var So=d(Ga);Qa=f(So,"TD",{});var ko=d(Qa);Wa=v(ko,"POST"),ko.forEach(h),Xa=f(So,"TD",{});var Po=d(Xa);Ya=v(Po,"api/get-hf-byProvince"),Po.forEach(h),Za=f(So,"TD",{});var Ro=d(Za);$a=v(Ro,"token, province, pageno, pagesize, sortby"),Ro.forEach(h),_a=f(So,"TD",{});var Jo=d(_a);ar=v(Jo,"JSON"),Jo.forEach(h),rr=f(So,"TD",{}),d(rr).forEach(h),So.forEach(h),or=i(ro),er=f(ro,"TR",{});var No=d(er);tr=f(No,"TD",{});var jo=d(tr);sr=v(jo,"POST"),jo.forEach(h),cr=f(No,"TD",{});var Io=d(cr);hr=v(Io,"api/get-hf-byDistrict"),Io.forEach(h),ir=f(No,"TD",{});var Bo=d(ir);fr=v(Bo,"token, district, pageno, pagesize, sortby"),Bo.forEach(h),dr=f(No,"TD",{});var Lo=d(dr);vr=v(Lo,"JSON"),Lo.forEach(h),nr=f(No,"TD",{}),d(nr).forEach(h),No.forEach(h),pr=i(ro),lr=f(ro,"TR",{});var xo=d(lr);Tr=f(xo,"TD",{});var zo=d(Tr);Er=v(zo,"POST"),zo.forEach(h),br=f(xo,"TD",{});var Ao=d(br);gr=v(Ao,"api/get-hf-byMunicipality"),Ao.forEach(h),Dr=f(xo,"TD",{});var wo=d(Dr);ur=v(wo,"token, municipality, pageno, pagesize, sortby"),wo.forEach(h),mr=f(xo,"TD",{});var Ho=d(mr);yr=v(Ho,"JSON"),Ho.forEach(h),Or=f(xo,"TD",{}),d(Or).forEach(h),xo.forEach(h),Sr=i(ro),kr=f(ro,"TR",{});var Vo=d(kr);Pr=f(Vo,"TD",{});var Uo=d(Pr);Rr=v(Uo,"POST"),Uo.forEach(h),Jr=f(Vo,"TD",{});var Mo=d(Jr);Nr=v(Mo,"api/hf-create"),Mo.forEach(h),jr=f(Vo,"TD",{});var Co=d(jr);Ir=v(Co,"token,[form elements]"),Co.forEach(h),Br=f(Vo,"TD",{});var Ko=d(Br);Lr=v(Ko,"JSON"),Ko.forEach(h),xr=f(Vo,"TD",{}),d(xr).forEach(h),Vo.forEach(h),zr=i(ro),Ar=f(ro,"TR",{});var qo=d(Ar);wr=f(qo,"TD",{});var Fo=d(wr);Hr=v(Fo,"POST"),Fo.forEach(h),Vr=f(qo,"TD",{});var Go=d(Vr);Ur=v(Go,"api/hf-update"),Go.forEach(h),Mr=f(qo,"TD",{});var Qo=d(Mr);Cr=v(Qo,"token,[form elements]"),Qo.forEach(h),Kr=f(qo,"TD",{});var Wo=d(Kr);qr=v(Wo,"JSON"),Wo.forEach(h),Fr=f(qo,"TD",{}),d(Fr).forEach(h),qo.forEach(h),ro.forEach(h),ao.forEach(h),t.forEach(h),this.h()},h(){document.title="Api Login",n(u,"class","button"),p(u,"float","right"),n(u,"href","javascript:void(0)"),n(j,"class","profile-username text-center"),n(V,"class","pull-right"),n(z,"class","list-group-item"),n(G,"class","pull-right"),n(C,"class","list-group-item"),n(x,"class","list-group list-group-unbordered"),n(X,"href","javascript:void(0)"),n(X,"class","btn btn-primary btn-block"),n(N,"class","box-body box-profile"),n(J,"class","box box-primary"),n(R,"class","col-md-6"),n(aa,"id","list-table"),n(aa,"class","table table-striped table-bordered"),n(_,"id","showtable"),n(_,"class","box-body col-md-6"),n(P,"class","row")},m(e,t){l(e,r,t),l(e,o,t),l(e,D,t),l(e,u,t),T(u,m),l(e,y,t),l(e,O,t),l(e,S,t),l(e,k,t),l(e,P,t),T(P,R),T(R,J),T(J,N),T(N,j),T(j,I),T(j,B),T(N,L),T(N,x),T(x,z),T(z,A),T(A,w),T(z,H),T(z,V),T(V,U),T(x,M),T(x,C),T(C,K),T(K,q),T(C,F),T(C,G),T(G,Q),T(N,W),T(N,X),T(X,Y),T(Y,Z),T(P,$),T(P,_),T(_,aa),T(aa,ra),T(ra,oa),T(oa,ea),T(ra,ta),T(ta,sa),T(ra,ca),T(ca,ha),T(ra,ia),T(ia,fa),T(ra,da),T(da,va),T(aa,na),T(aa,pa),T(pa,la),T(la,Ta),T(pa,Ea),T(Ea,ba),T(pa,ga),T(ga,Da),T(pa,ua),T(ua,ma),T(pa,ya),T(aa,Oa),T(aa,Sa),T(Sa,ka),T(ka,Pa),T(Sa,Ra),T(Ra,Ja),T(Sa,Na),T(Na,ja),T(Sa,Ia),T(Ia,Ba),T(Sa,La),T(aa,xa),T(aa,za),T(za,Aa),T(Aa,wa),T(za,Ha),T(Ha,Va),T(za,Ua),T(Ua,Ma),T(za,Ca),T(Ca,Ka),T(za,qa),T(aa,Fa),T(aa,Ga),T(Ga,Qa),T(Qa,Wa),T(Ga,Xa),T(Xa,Ya),T(Ga,Za),T(Za,$a),T(Ga,_a),T(_a,ar),T(Ga,rr),T(aa,or),T(aa,er),T(er,tr),T(tr,sr),T(er,cr),T(cr,hr),T(er,ir),T(ir,fr),T(er,dr),T(dr,vr),T(er,nr),T(aa,pr),T(aa,lr),T(lr,Tr),T(Tr,Er),T(lr,br),T(br,gr),T(lr,Dr),T(Dr,ur),T(lr,mr),T(mr,yr),T(lr,Or),T(aa,Sr),T(aa,kr),T(kr,Pr),T(Pr,Rr),T(kr,Jr),T(Jr,Nr),T(kr,jr),T(jr,Ir),T(kr,Br),T(Br,Lr),T(kr,xr),T(aa,zr),T(aa,Ar),T(Ar,wr),T(wr,Hr),T(Ar,Vr),T(Vr,Ur),T(Ar,Mr),T(Mr,Cr),T(Ar,Kr),T(Kr,qr),T(Ar,Fr),Gr=E(u,"click",a[0])},p:b,i:b,o:b,d(a){a&&h(r),a&&h(o),a&&h(D),a&&h(u),a&&h(y),a&&h(O),a&&h(S),a&&h(k),a&&h(P),Gr()}}}function u(a){return[a=>void(confirm("Are you sure you want to Logout?")&&(g.remove("apiusertoken"),g.remove("apiuserid"),g.remove("apiuserfullname"),g.remove("apiuserusername"),window.location.replace("apiLogin")))]}export default class extends a{constructor(a){super(),r(this,a,u,D,o,{})}}
