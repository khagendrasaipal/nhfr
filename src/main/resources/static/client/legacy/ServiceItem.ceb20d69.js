import{a as n,b as e,c as t,d as r,i,s as c,e as a,S as o,V as f,q as u,A as s,F as l,H as d,J as v,B as p,L as h,z as m,X as g,l as w,f as $,g as k,h as j,j as P,m as x,o as y,p as C,r as b,u as T,x as B,t as N,k as q,v as A}from"./index.0c22fd66.js";import{_ as E}from"./slicedToArray.f13a096f.js";import"./_commonjsHelpers.fffabd3b.js";import"./jquery.8acdee4f.js";function H(n,e,t){var r=n.slice();return r[8]=e[t],r}function _(n){var e,t,r,i=n[0].code+"",c=n[0].name+"";return{c:function(){e=N(i),t=N(". "),r=N(c)},l:function(n){e=q(n,i),t=q(n,". "),r=q(n,c)},m:function(n,i){u(n,e,i),u(n,t,i),u(n,r,i)},p:function(n,t){1&t&&i!==(i=n[0].code+"")&&A(e,i),1&t&&c!==(c=n[0].name+"")&&A(r,c)},d:function(n){n&&w(e),n&&w(t),n&&w(r)}}}function z(n){var e,t,r,i,c=n[0].code+"",a=n[0].name+"";return{c:function(){e=N(c),t=N(". "),r=N(a),i=N(" (जनस्वास्थ्य सेवा नियमावली २०७७ अनुसार का आधारभूत सेवा हरु)")},l:function(n){e=q(n,c),t=q(n,". "),r=q(n,a),i=q(n," (जनस्वास्थ्य सेवा नियमावली २०७७ अनुसार का आधारभूत सेवा हरु)")},m:function(n,c){u(n,e,c),u(n,t,c),u(n,r,c),u(n,i,c)},p:function(n,t){1&t&&c!==(c=n[0].code+"")&&A(e,c),1&t&&a!==(a=n[0].name+"")&&A(r,a)},d:function(n){n&&w(e),n&&w(t),n&&w(r),n&&w(i)}}}function D(n){for(var e,t,r=n[5](n[0].id),i=[],c=0;c<r.length;c+=1)i[c]=F(H(n,r,c));var a=function(n){return p(i[n],1,1,(function(){i[n]=null}))};return{c:function(){for(var n=0;n<i.length;n+=1)i[n].c();e=f()},l:function(n){for(var t=0;t<i.length;t+=1)i[t].l(n);e=f()},m:function(n,r){for(var c=0;c<i.length;c+=1)i[c].m(n,r);u(n,e,r),t=!0},p:function(n,t){if(63&t){var c;for(r=n[5](n[0].id),c=0;c<r.length;c+=1){var o=H(n,r,c);i[c]?(i[c].p(o,t),s(i[c],1)):(i[c]=F(o),i[c].c(),s(i[c],1),i[c].m(e.parentNode,e))}for(B(),c=r.length;c<i.length;c+=1)a(c);m()}},i:function(n){if(!t){for(var e=0;e<r.length;e+=1)s(i[e]);t=!0}},o:function(n){i=i.filter(Boolean);for(var e=0;e<i.length;e+=1)p(i[e]);t=!1},d:function(n){g(i,n),n&&w(e)}}}function F(n){var e,t=new L({props:{newservices:n[1],parentChecked:n[2],toggleParent:n[3],service:n[8],level:n[4]+1}});return{c:function(){l(t.$$.fragment)},l:function(n){d(t.$$.fragment,n)},m:function(n,r){v(t,n,r),e=!0},p:function(n,e){var r={};2&e&&(r.newservices=n[1]),4&e&&(r.parentChecked=n[2]),8&e&&(r.toggleParent=n[3]),1&e&&(r.service=n[8]),16&e&&(r.level=n[4]+1),t.$set(r)},i:function(n){e||(s(t.$$.fragment,n),e=!0)},o:function(n){p(t.$$.fragment,n),e=!1},d:function(n){h(t,n)}}}function I(n){var e,t,r,i,c,a,o,l,d,v;function h(n,e){return"B"===n[0].code?z:_}var g=h(n),N=g(n),q=n[2][n[0].id]&&D(n);return{c:function(){e=$("tr"),t=$("td"),r=$("input"),a=k(),N.c(),o=k(),q&&q.c(),l=f(),this.h()},l:function(n){e=j(n,"TR",{});var i=P(e);t=j(i,"TD",{width:!0,class:!0,style:!0});var c=P(t);r=j(c,"INPUT",{type:!0,name:!0,id:!0,value:!0}),a=x(c),N.l(c),c.forEach(w),i.forEach(w),o=x(n),q&&q.l(n),l=f(),this.h()},h:function(){y(r,"type","checkbox"),y(r,"name","newservices"),y(r,"id",i="newservices"+n[0].id),r.value=c=n[0].id,y(t,"width","60%"),y(t,"class","service-name"),C(t,"padding-left",40*n[4]+"px")},m:function(i,c){u(i,e,c),b(e,t),b(t,r),b(t,a),N.m(t,null),u(i,o,c),q&&q.m(i,c),u(i,l,c),d=!0,v=T(r,"change",n[7])},p:function(n,e){var a=E(e,1)[0];(!d||1&a&&i!==(i="newservices"+n[0].id))&&y(r,"id",i),(!d||1&a&&c!==(c=n[0].id))&&(r.value=c),g===(g=h(n))&&N?N.p(n,a):(N.d(1),(N=g(n))&&(N.c(),N.m(t,null))),(!d||16&a)&&C(t,"padding-left",40*n[4]+"px"),n[2][n[0].id]?q?(q.p(n,a),s(q,1)):((q=D(n)).c(),s(q,1),q.m(l.parentNode,l)):q&&(B(),p(q,1,1,(function(){q=null})),m())},i:function(n){d||(s(q),d=!0)},o:function(n){p(q),d=!1},d:function(n){n&&w(e),N.d(),n&&w(o),q&&q.d(n),n&&w(l),v()}}}function J(n,e,t){var r=e.service,i=e.newservices,c=e.parentChecked,a=e.toggleParent,o=e.level,f=void 0===o?0:o;function u(n){var e;return 2==f&&(e=i.filter((function(e){return e.parent===n})),jQuery("#newservices"+e[0].id).attr("checked",!0)),i.filter((function(e){return e.parent===n}))}return n.$set=function(n){"service"in n&&t(0,r=n.service),"newservices"in n&&t(1,i=n.newservices),"parentChecked"in n&&t(2,c=n.parentChecked),"toggleParent"in n&&t(3,a=n.toggleParent),"level"in n&&t(4,f=n.level)},[r,i,c,a,f,u,function(n){var e=i.filter((function(n){return null===n.child})).map((function(n){return n.id}));return e[e.length-1]===n},function(){return a(r.id,f,u(r.id))}]}var L=function(f){function u(n){var o;return e(this,u),o=t(this,r(u).call(this)),i(a(o),n,J,I,c,{service:0,newservices:1,parentChecked:2,toggleParent:3,level:4}),o}return n(u,o),u}();export default L;
