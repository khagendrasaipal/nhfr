<script context="module">

  import { onMount } from "svelte";
  export const baseUrl="http://localhost:8081";
  export let parent;
  export let ownership;
  export let flevel;
  export let services;
  export let opds;
  export let bipanna;
  export let laboratory;
  export let radiology;
  export let specialized;
  export let surgical;
  export let servicetype;
  export let province;
  export let district;
  export let palika;
  export let ayurved;
  export let motherhood;
  export let fplanning;
  export let opdService;

  

     const createParent = (async()=>{
    
  const response =   await fetch(baseUrl+"/facility-type/list?search=");
     
    parent = await response.json();
   
    
})()

 const createProvince = (async()=>{
    
  const response =   await fetch(baseUrl+"/service-type/getProvince");
     
    province = await response.json();
   
    
})()

const createDistrict = (async()=>{
    
  const response =   await fetch(baseUrl+"/service-type/getDistrict");
     
    district = await response.json();
   
    
})()

const createPalika = (async()=>{
    
  const response =   await fetch(baseUrl+"/service-type/getMunicipality");
     
    palika = await response.json();
   
    
})()

 const createOwnership = (async()=>{
    
  const response =   await fetch(baseUrl+"/ownership/list?search=");
     
    ownership = await response.json();
   
    
})()

const createFlevel = (async()=>{
    
  const response =   await fetch(baseUrl+"/facility-level/list?search=");
     
    flevel = await response.json();
   
    
})()

const createServices = (async()=>{
    
  const response =   await fetch(baseUrl+"/services/list?search=");
     
    services = await response.json();
   
    
})()

const createAyurved = (async()=>{
    
  const response =   await fetch(baseUrl+"/ayurved/list");
     
    ayurved = await response.json();
   
    
})()
const createMotherhood = (async()=>{
    
  const response =   await fetch(baseUrl+"/motherhood/list");
     
    motherhood = await response.json();
   
    
})()
const createFamily = (async()=>{
    
  const response =   await fetch(baseUrl+"/familyplanning/list");
     
    fplanning = await response.json();
   
    
})()

const createOpd= (async()=>{
    
  const response =   await fetch(baseUrl+"/opd/list?search=");
     
    opds = await response.json();
   
    
})()

const createBipanna= (async()=>{
    
  const response =   await fetch(baseUrl+"/bipanna/list?search=");
     
    bipanna = await response.json();
   
    
})()

const createLaboratory= (async()=>{
    
  const response =   await fetch(baseUrl+"/laboratory/list?search=");
     
    laboratory = await response.json();
   
    
})()

const createSpecialized= (async()=>{
    
  const response =   await fetch(baseUrl+"/specialized/list?search=");
     
    specialized = await response.json();
   
    
})()
const createRadiology= (async()=>{
    
  const response =   await fetch(baseUrl+"/radiology/list?search=");
     
    radiology = await response.json();
   
    
})()

const createSurgical= (async()=>{
    
  const response =   await fetch(baseUrl+"/surgical/list?search=");
     
    surgical = await response.json();
   
    
})()

const createServiceType= (async()=>{
    
  const response =   await fetch(baseUrl+"/service-type/list?search=");
     
    servicetype = await response.json();
   
    
})()
  
 </script>

 