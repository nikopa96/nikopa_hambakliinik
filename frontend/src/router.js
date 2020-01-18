import Vue from "vue";
import BootstrapVue from "bootstrap-vue";
import Vuelidate from "vuelidate";
import VueLocalStorage from "vue-localstorage";
import * as VueGoogleMaps from "vue2-google-maps";
import Router from "vue-router";
import Home from "./views/website/Home";
import Booking from "./views/website/Booking";
import Register from "./views/website/Register";
import Thanks from "./views/website/Thanks";
import Procedures from "./views/website/Procedures";
import Doctors from "./views/website/Doctors";
import Contact from "./views/website/Contact";
import Careers from "./views/website/Careers";
import NotFound from "./views/website/NotFound";
import VisitList from "./views/admin/VisitList";
import EditVisit from "./views/admin/EditVisit";
import AddVisit from "./views/admin/AddVisit";
import ClientList from "./views/admin/ClientList";

import "bootstrap/dist/css/bootstrap.css";
import "bootstrap-vue/dist/bootstrap-vue.css";

Vue.use(BootstrapVue);
Vue.use(Vuelidate);
Vue.use(Router);
Vue.use(VueLocalStorage, {
  name: "ls",
  bind: true
});

Vue.use(VueGoogleMaps, {
  load: {
    key: "AIzaSyBFQ4TMRVb64dvOpUO2eJRs2fGO4cXMn4E",
    libraries: "places"
  }
});

export default new Router({
  routes: [
    {
      path: "/",
      name: "home",
      component: Home
    },
    {
      path: "/booking",
      name: "booking",
      component: Booking
    },
    {
      path: "/register/:visitId",
      name: "register",
      component: Register
    },
    {
      path: "/thanks",
      name: "thanks",
      component: Thanks
    },
    {
      path: "/procedures",
      name: "procedures",
      component: Procedures
    },
    {
      path: "/doctors",
      name: "doctors",
      component: Doctors
    },
    {
      path: "/contact",
      name: "contact",
      component: Contact
    },
    {
      path: "/careers",
      name: "careers",
      component: Careers
    },
    {
      path: "/404",
      name: "404",
      component: NotFound
    },
    {
      path: "*",
      redirect: "/404"
    },
    {
      path: "/admin/visits",
      name: "visitList",
      component: VisitList
    },
    {
      path: "/admin",
      redirect: { name: "visitList" }
    },
    {
      path: "/admin/visits/add",
      name: "addVisit",
      component: AddVisit
    },
    {
      path: "/admin/visits/edit/:visitId",
      name: "editVisit",
      component: EditVisit
    },
    {
      path: "/admin/clients",
      name: "clientList",
      component: ClientList
    }
  ]
});
