import{S as a,i as s,s as t}from"./index.e5c655c7.js";import{f as i,l as e}from"./create.15ee5e82.js";import{C as c}from"./js.cookie.a0f74474.js";const n="https://nhfr.mohp.gov.np";let o,r,l,w,y,h,p,j,g,u,v,d,f,m,x,k,b,z,C,D=c.get("token");(async()=>{const a=await i(n+"/facility-type/list?search=");o=await a.json()})(),(async()=>{const a=await i(n+"/service-type/getProvince");d=await a.json()})(),(async()=>{const a=await i(n+"/service-type/getDistrict");f=await a.json()})(),(async()=>{const a=await i(n+"/service-type/getMunicipality");m=await a.json()})(),(async()=>{const a=await i(n+"/ownership/list?search=");r=await a.json()})(),(async()=>{const a=await i(n+"/facility-level/list?search=");l=await a.json()})(),(async()=>{const a=await i(n+"/services/list?search=");w=await a.json()})(),(async()=>{const a=await i(n+"/ayurved/list");x=await a.json()})(),(async()=>{const a=await i(n+"/motherhood/list");k=await a.json()})(),(async()=>{const a=await i(n+"/familyplanning/list");b=await a.json()})(),(async()=>{const a=await i(n+"/opd/list?search=");y=await a.json()})(),(async()=>{const a=await i(n+"/bipanna/list?search=");h=await a.json()})(),(async()=>{const a=await i(n+"/laboratory/list?search=");p=await a.json()})(),(async()=>{const a=await i(n+"/specialized/list?search=");g=await a.json()})(),(async()=>{const a=await i(n+"/radiology/list?search=");j=await a.json()})(),(async()=>{const a=await i(n+"/surgical/list?search=");u=await a.json()})(),(async()=>{const a=await i(n+"/service-type/list?search=");v=await a.json()})();let M;var P=c.get("uid"),S=c.get("role"),q=c.get("province"),A=c.get("district"),B=c.get("municipality"),E=n+"/health-registry";M=n+"/health-registry/list?search=","palika"==S&&(M=E+"/getlist?search=&roles="+S+"&rvalues="+B+"&uid="+P),"district"==S&&(M=E+"/getlist?search=&roles="+S+"&rvalues="+A+"&uid="+P),"provincial"==S&&(M=E+"/getlist?search=&roles="+S+"&rvalues="+q+"&uid="+P);(async()=>{const a=await e(M,D);C=await a.json()})();export default class extends a{constructor(a){super(),s(this,a,null,null,t,{})}}export{x as ayurved,n as baseUrl,h as bipanna,f as district,l as flevel,b as fplanning,C as hflist,p as laboratory,k as motherhood,z as opdService,y as opds,r as ownership,m as palika,o as parent,d as province,j as radiology,w as services,v as servicetype,g as specialized,u as surgical};
