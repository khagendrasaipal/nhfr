!function(){"use strict";const e=["client/_commonjsHelpers.fffabd3b.js","client/js.cookie.7f372dc7.js","client/index.02e345fc.js","client/create.bcc8dfec.js","client/client.8a997949.js","client/index.e5c655c7.js","client/fetchdata.4bfb09cd.js","client/index.9bb96efd.js","client/module.9872e2eb.js","client/health_registry_list_online.ec2a532a.js","client/app.146495c8.js","client/health_facility_type.91a4f1ba.js","client/health_facility_level.8f3f8e75.js","client/ServiceItemView.05649f0e.js","client/ServiceItem.0a0038f0.js","client/loadLeaflet.78c5bdfd.js","client/index.b3479cb3.js","client/apiloginsubmitpage.07c2a992.js","client/health_registry_list.0616e9c4.js","client/MultiSelect.e42e73c3.js","client/api.821fcd38.js","client/admin_login.55ac1d4d.js","client/healthservice.bc805d7f.js","client/servicetype.e689f8c1.js","client/specialized.1671f8e8.js","client/LocalLevel.ba398200.js","client/laboratory.14057207.js","client/hfservices.8b413454.js","client/motherhood.03a0f526.js","client/onlineview.9dff52fc.js","client/apiSignup.32fea710.js","client/userSignup.d5ab5c16.js","client/ownership.6574e76d.js","client/health_registry.545f037f.js","client/jquery.dc1d5bd8.js","client/googlemap.f3d870e4.js","client/apiLogin.624ba843.js","client/radiology.9bd0baa8.js","client/tracking.cd6d6ea3.js","client/surgical.34d1188e.js","client/userList.5ad5011d.js","client/services.12aa7569.js","client/apiList.082177f6.js","client/bipanna.7d39b134.js","client/ayurved.71eb4e9e.js","client/family.c33c0c80.js","client/apiLog.9f37083c.js","client/login.dcef26af.js","client/index.f1c34726.js","client/[slug].bd755888.js","client/home.a9a87a97.js","client/opd.f7b28563.js","client/reports.6c926725.js","client/search.1a7f9a4f.js","client/applyonline.d8808787.js","client/Sidebar.7cce8300.js"].concat(["service-worker-index.html","document.png","favicon.png","fetchdata.svelte","flag-anim.gif","folder-horizontal.png","global.css","great-success.png","jquery.treeview/changelog.txt","jquery.treeview/demo/async.html","jquery.treeview/demo/bg.gif","jquery.treeview/demo/demo.js","jquery.treeview/demo/images.html","jquery.treeview/demo/index.html","jquery.treeview/demo/large.html","jquery.treeview/demo/prerendered.html","jquery.treeview/demo/screen.css","jquery.treeview/demo/simple.html","jquery.treeview/demo/source.php","jquery.treeview/demo/source.phps","jquery.treeview/images/file.gif","jquery.treeview/images/folder-closed.gif","jquery.treeview/images/folder.gif","jquery.treeview/images/minus.gif","jquery.treeview/images/plus.gif","jquery.treeview/images/treeview-black-line.gif","jquery.treeview/images/treeview-black.gif","jquery.treeview/images/treeview-default-line.gif","jquery.treeview/images/treeview-default.gif","jquery.treeview/images/treeview-famfamfam-line.gif","jquery.treeview/images/treeview-famfamfam.gif","jquery.treeview/images/treeview-gray-line.gif","jquery.treeview/images/treeview-gray.gif","jquery.treeview/images/treeview-red-line.gif","jquery.treeview/images/treeview-red.gif","jquery.treeview/jquery.treeview.async.js","jquery.treeview/jquery.treeview.css","jquery.treeview/jquery.treeview.js","jquery.treeview/jquery.treeview.min.js","jquery.treeview/jquery.treeview.pack.js","jquery.treeview/lib/jquery.cookie.js","jquery.treeview/todo","logo-192.png","logo-512.png","manifest.json","nepal-govt.png","nepali.datepicker.v3.7.min.js","nepdate.css","nepdate.js","toggle-small-expand.png","toggle-small.png"]),i=new Set(e);self.addEventListener("install",i=>{i.waitUntil(caches.open("cache1737100178720").then(i=>i.addAll(e)).then(()=>{self.skipWaiting()}))}),self.addEventListener("activate",e=>{e.waitUntil(caches.keys().then(async e=>{for(const i of e)"cache1737100178720"!==i&&await caches.delete(i);self.clients.claim()}))}),self.addEventListener("fetch",e=>{if("GET"!==e.request.method||e.request.headers.has("range"))return;const t=new URL(e.request.url);t.protocol.startsWith("http")&&(t.hostname===self.location.hostname&&t.port!==self.location.port||(t.host===self.location.host&&i.has(t.pathname)?e.respondWith(caches.match(e.request)):"only-if-cached"!==e.request.cache&&e.respondWith(caches.open("offline1737100178720").then(async i=>{try{const t=await fetch(e.request);return i.put(e.request,t.clone()),t}catch(t){const s=await i.match(e.request);if(s)return s;throw t}}))))})}();
