import Vue from "vue";
import BootstrapVue from 'bootstrap-vue';
import Vuelidate from 'vuelidate';
import VeeValidate from 'vee-validate';
import VueLocalStorage from 'vue-localstorage'
import * as VueGoogleMaps from 'vue2-google-maps';
import Router from "vue-router";
import Home from "./views/website/Home.vue";
import Booking from "./views/website/Booking.vue";
import Register from "./views/website/Register.vue";
import Thanks from "./views/website/Thanks.vue";
import VisitList from "./views/admin/VisitList";
import EditVisit from "./views/admin/EditVisit";
import AddVisit from "./views/admin/AddVisit";
import ClientList from "./views/admin/ClientList";

import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap-vue/dist/bootstrap-vue.css';

Vue.use(BootstrapVue);
Vue.use(Vuelidate);
Vue.use(VeeValidate);
Vue.use(Router);
Vue.use(VueLocalStorage, {
  name: 'ls',
  bind: true
});

Vue.use(VueGoogleMaps, {
  load: {
    key: 'AIzaSyBFQ4TMRVb64dvOpUO2eJRs2fGO4cXMn4E',
    libraries: 'places'
  },
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
      path: "/admin/visits",
      name: "visitList",
      component: VisitList
    },
    {
      path: '/admin',
      redirect: { name: 'visitList' }
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
