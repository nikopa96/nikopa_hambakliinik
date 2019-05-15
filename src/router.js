import Vue from "vue";
import BootstrapVue from 'bootstrap-vue';
import Vuelidate from 'vuelidate';
import VueLocalStorage from 'vue-localstorage'
import * as VueGoogleMaps from 'vue2-google-maps';
import Router from "vue-router";
import Home from "./views/Home.vue";
import Booking from "./views/Booking.vue";
import Register from "./views/Register.vue";
import Thanks from "./views/Thanks.vue";

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

Vue.use(BootstrapVue);
Vue.use(Vuelidate);
Vue.use(Router);
Vue.use(VueLocalStorage, {
  name: 'ls',
  bind: true
})

Vue.use(VueGoogleMaps, {
  load: {
    key: 'AIzaSyBFQ4TMRVb64dvOpUO2eJRs2fGO4cXMn4E',
    libraries: 'places'
  },
})

require('@/assets/css/style.css');

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
      path: "/register/:serviceId/:doctorId/:time",
      name: "register",
      component: Register
    },
    {
      path: "/thanks",
      name: "thanks",
      component: Thanks
    }
  ]
});
