<template>
  <div class="container">
    <Navbar/>
    <div class="row">
      <div class="column col-12 col-md-5 col-lg-4 pr-lg-4 mr-lg-5">
        <h1 class="title">Teie broneering</h1>
        <div class="card booking-info">
          <div class="card-body">
            <p class="card-text mb-1">Teenus:</p>
            <h5 class="card-title mb-4">{{ service.type }}</h5>

            <p class="card-text mb-1">Arst:</p>
            <h5 class="card-title mb-4">{{ 'Dr. ' + doctor.name }}</h5>

            <p class="card-text mb-1">Aeg:</p>
            <h5 class="card-title mb-5">{{ $route.params.time }}</h5>
            <router-link to="/booking">
              <a class="btn btn-book btn-md float-right pl-5 pr-5" href role="button">Muuda</a>
            </router-link>
          </div>
        </div>
      </div>
      <div class="column col-12 col-md-7 col-lg-6 pl-lg-5 registration">
        <h4
          class="card-title registration__title registration__title--thin-text mb-5"
        >Täitke oma isikuandmed</h4>
        <form class="needs-validation" @submit.prevent="submit">
          <div class="form-group">
            <label class="registration__label" for="firstName">
              Eesnimi
              <span>*</span>
            </label>
            <input
              type="text"
              class="form-control"
              v-bind:class="{ 'is-invalid': formIsInvalid && !$v.form.firstName.required }"
              id="firstName"
              placeholder="Eesnimi"
              v-model.trim="$v.form.firstName.$model"
            >
            <div class="invalid-feedback">Eesnimi on kohustuslik</div>
          </div>
          <div class="form-group">
            <label class="registration__label" for="lastName">
              Perekonnanimi
              <span>*</span>
            </label>
            <input
              type="text"
              class="form-control"
              v-bind:class="{ 'is-invalid': formIsInvalid && !$v.form.lastName.required }"
              id="lastName"
              placeholder="Perekonnanimi"
              v-model="$v.form.lastName.$model"
            >
            <div class="invalid-feedback">Perekonnanimi on kohustuslik</div>
          </div>
          <div class="form-group">
            <label class="registration__label" for="personalCode">
              Isikukood
              <span>*</span>
            </label>
            <input
              type="text"
              class="form-control"
              v-bind:class="{ 'is-invalid': formIsInvalid && !$v.form.personalCode.required }"
              id="personalCode"
              placeholder="Isikukood"
              v-model="$v.form.personalCode.$model"
            >
            <div class="invalid-feedback">Isikukood on kohustuslik</div>
          </div>
          <div class="form-group">
            <label class="registration__label" for="phone">
              Telefoninumber
              <span>*</span>
            </label>
            <input
              type="text"
              class="form-control"
              v-bind:class="{ 'is-invalid': formIsInvalid && !$v.form.telephone.required }"
              id="phone"
              placeholder="Telefoninumber"
              v-model="$v.form.telephone.$model"
            >
            <div class="invalid-feedback">Telefoninumber on kohustuslik</div>
          </div>
          <div class="form-group">
            <label class="registration__label" for="email">
              E-meil
              <span>*</span>
            </label>
            <input
              type="email"
              class="form-control"
              v-bind:class="{ 'is-invalid': formIsInvalid && !$v.form.email.required }"
              id="email"
              placeholder="E-meil"
              v-model="$v.form.email.$model"
            >
            <div class="invalid-feedback">E-meil on kohustuslik</div>
          </div>

          <div class="registration__label mb-3">
            Ühendus minuga
            <span>*</span>
          </div>
          <div class="form-check form-check-inline">
            <input
              class="form-check-input"
              type="radio"
              name="connectWithMe"
              id="connectWithMePhone"
              value="phone"
              :checked="$v.form.connectionType.$model === 'phone'"
              v-model="$v.form.connectionType.$model"
            >
            <label class="form-check-label" for="connectWithMePhone">telefon</label>
          </div>
          <div class="form-check form-check-inline">
            <input
              class="form-check-input"
              type="radio"
              name="connectWithMe"
              id="connectWithMeEmail"
              value="email"
              v-model="$v.form.connectionType.$model"
            >
            <label class="form-check-label" for="connectWithMeEmail">e-meil</label>
          </div>

          <div class="form-check mt-5">
            <input
              class="form-check-input"
              v-bind:class="{ 'is-invalid': formIsInvalid && $v.form.dataProcessing.$model === false }"
              type="checkbox"
              id="confirm"
              v-model="$v.form.dataProcessing.$model"
            >
            <label class="form-check-label registration__label-checkbox" for="confirm">
              Olen nõus
              andmetöötlemisega
              <span>*</span>
            </label>
          </div>

          <b-button type="submit" class="btn btn-main btn-md pl-5 pr-5 mt-5">Registreeri</b-button>
        </form>
      </div>
    </div>
    <Footer/>
  </div>
</template>

<script>
import Navbar from "@/components/Navbar.vue";
import Footer from "@/components/Footer.vue";

import axios from "axios";
import { required, sameAs } from "vuelidate/lib/validators";

export default {
  name: "register",
  components: {
    Navbar,
    Footer
  },
  data() {
    return {
      service: { id: null, type: null },
      doctor: { id: null, name: null },
      form: {
        firstName: null,
        lastName: null,
        personalCode: null,
        telephone: null,
        email: null,
        connectionType: "phone",
        dataProcessing: false
      },
      formIsInvalid: null
    };
  },
  mounted() {
    axios.get("http://dijkstra.cs.ttu.ee/~nikopa/kasutajaliidesed/mock_data/data.json").then(response => {
      let info = response.data;

      let services = info.services.filter(service => {
        return service.id === parseInt(this.$route.params.serviceId);
      });
      let doctors = info.doctors.filter(doctor => {
        return doctor.id === parseInt(this.$route.params.doctorId);
      });

      this.service = services[0];
      this.doctor = doctors[0];
    });
  },
  validations: {
    form: {
      firstName: {
        required
      },
      lastName: {
        required
      },
      personalCode: {
        required
      },
      telephone: {
        required
      },
      email: {
        required
      },
      connectionType: {
        required
      },
      dataProcessing: {
        required,
        sameAs: sameAs(() => true)
      }
    }
  },
  methods: {
    submit() {
      if (this.$v.form.$invalid) {
        this.formIsInvalid = true;
      } else {
        let userVisit = {
          serviceType: this.service.type,
          doctorName: this.doctor.name,
          time: this.$route.params.time
        };

        this.$ls.set('userVisit', JSON.stringify(userVisit));
        this.$router.push("/thanks");
      }
    }
  }
};
</script>

<style >
 h1 { color: red; }
</style>