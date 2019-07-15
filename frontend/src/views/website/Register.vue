<template>
  <div class="container">
    <navbar></navbar>
    <div class="row">
      <div class="column col-12 col-md-5 col-lg-4 pr-lg-4 mr-lg-5">
        <h1 class="title">Teie broneering</h1>
        <div class="card">
          <div class="card-body" v-if="visit">
            <p class="card-text mb-1">Teenus:</p>
            <h5 class="card-title mb-4">{{ visit.procedure.name }}</h5>

            <p class="card-text mb-1">Arst:</p>
            <h5 class="card-title mb-4">{{ 'Dr. ' + visit.doctor.name }}</h5>

            <p class="card-text mb-1">Aeg:</p>
            <h5 class="card-title mb-5">{{ visit.time }}</h5>
            <router-link to="/booking">
              <a class="btn btn-book btn-md float-right pl-5 pr-5" href role="button">Muuda</a>
            </router-link>
          </div>
        </div>
      </div>
      <div class="column col-12 col-md-7 col-lg-6 pl-lg-5 registration">
        <h4 class="card-title registration__title mb-5">Täitke oma isikuandmed</h4>
        <form class="needs-validation" @submit.prevent="submit">
          <div class="form-group">
            <label class="registration__label" for="firstName">Eesnimi<span>*</span></label>
            <input type="text" class="form-control"
                   v-bind:class="{ 'is-invalid': formIsInvalid && !$v.form.firstName.required }" id="firstName"
                   placeholder="Eesnimi" v-model.trim="$v.form.firstName.$model">
            <div class="invalid-feedback">Eesnimi on kohustuslik</div>
          </div>
          <div class="form-group">
            <label class="registration__label" for="lastName">Perekonnanimi<span>*</span></label>
            <input type="text" class="form-control"
                   v-bind:class="{ 'is-invalid': formIsInvalid && !$v.form.lastName.required }" id="lastName"
                   placeholder="Perekonnanimi" v-model="$v.form.lastName.$model">
            <div class="invalid-feedback">Perekonnanimi on kohustuslik</div>
          </div>
          <div class="form-group">
            <label class="registration__label" for="phone">Telefoninumber<span>*</span></label>
            <input type="text" class="form-control"
                   v-bind:class="{ 'is-invalid': formIsInvalid && !$v.form.telephone.required }" id="phone"
                   placeholder="Telefoninumber" v-model="$v.form.telephone.$model">
            <div class="invalid-feedback">Telefoninumber on kohustuslik</div>
          </div>
          <div class="form-group">
            <label class="registration__label" for="email">E-meil<span>*</span></label>
            <input type="email" class="form-control"
                   v-bind:class="{ 'is-invalid': formIsInvalid && !$v.form.email.required }" id="email"
                   placeholder="E-meil" v-model="$v.form.email.$model">
            <div class="invalid-feedback">E-meil on kohustuslik</div>
          </div>
          <div class="registration__label mb-3">Ühendus minuga<span>*</span></div>
          <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="connectWithMe" id="connectWithMePhone" value="phone"
                   :checked="$v.form.connectionType.$model === 'phone'" v-model="$v.form.connectionType.$model">
            <label class="form-check-label" for="connectWithMePhone">telefon</label>
          </div>
          <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="connectWithMe" id="connectWithMeEmail" value="email"
                   v-model="$v.form.connectionType.$model">
            <label class="form-check-label" for="connectWithMeEmail">e-meil</label>
          </div>
          <div class="form-check mt-5">
            <input class="form-check-input"
                   v-bind:class="{ 'is-invalid': formIsInvalid && $v.form.dataProcessing.$model === false }"
                   type="checkbox" id="confirm" v-model="$v.form.dataProcessing.$model">
            <label class="form-check-label registration__label-checkbox" for="confirm">Olen nõus andmetöötlemisega
              <span>*</span>
            </label>
          </div>
          <button type="submit" class="btn btn-main btn-md pl-5 pr-5 mt-5">Registreeri</button>
        </form>
      </div>
    </div>
    <Footer/>
  </div>
</template>

<script>
import Navbar from "@/components/website/Navbar.vue";
import Footer from "@/components/website/Footer.vue";

import { required, sameAs } from "vuelidate/lib/validators";

export default {
  name: "register",
  components: {
    Navbar,
    Footer
  },
  data() {
    return {
      visit: null,
      form: {
        firstName: null,
        lastName: null,
        telephone: null,
        email: null,
        connectionType: "phone",
        dataProcessing: false
      },
      formIsInvalid: null
    };
  },
  mounted() {
    fetch('/dentalclinic/api/visits/get/' + this.$route.params.visitId).then(response => {
      response.json().then(data => {
        this.visit = data;
      });
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
    postData() {
      const client = {
        visitId: this.visit.id,
        name: this.form.firstName,
        surname: this.form.lastName,
        telephone: this.form.telephone,
        email: this.form.email,
        connectionType: this.form.connectionType
      };

      const visit = {
        id: this.visit.id,
        doctor: this.visit.doctor,
        procedure: this.visit.procedure,
        time: this.visit.time,
        date: this.visit.date,
        interval: this.visit.interval,
        isActive: this.visit.isActive,
        isBooked: true
      };

      const addClient = fetch("/dentalclinic/api/clients/add", {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body:  JSON.stringify(client)
      }).catch(error => {
          console.error('Request failure: ', error);
      });

      const updateVisit = fetch("/dentalclinic/api/visits/update/" + this.$route.params.visitId, {
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json'
        },
        body:  JSON.stringify(visit)
      }).catch(error => {
        console.error('Request failure: ', error);
      });

      Promise.all([addClient, updateVisit]).then(response => {
        const userVisit = {
          procedureName: this.visit.procedure.name,
          doctorName: this.visit.doctor.name,
          time: this.visit.time
        };

        this.$ls.set('userVisit', JSON.stringify(userVisit));
        this.$router.push("/thanks");
      });
    },
    submit() {
      if (this.$v.form.$invalid) {
        this.formIsInvalid = true;
      } else {
        this.postData();
      }
    }
  }
};
</script>

<style lang="less" scoped>
  @fat-font-weight: 500;
  @letter-spacing-wide: 2px;
  @thin-font-weight: 400;

  .title {
    text-transform: uppercase;
    font-size: 1.5em;
    font-weight: @fat-font-weight;
    letter-spacing: @letter-spacing-wide;
    margin-top: 1.5em;
    margin-bottom: 1.5em;
    color: #575757;
  }

  @media only screen and (max-width: 575.98px) {
    .title {
      text-align: center;
    }
  }

  .registration {
    &__title {
      margin-top: 1.5em;
      font-weight: @thin-font-weight;
    }

    &__label {
      font-size: 1.1em;
      font-weight: 500;

      span {
        color: red;
        margin-left: 5px;
      }
    }

    &__label-checkbox {
      span {
        color: red;
        margin-left: 5px;
      }
    }
  }

  .card {
    background-color: #C5E6D5;
    border: none;
    border-radius: 1.25em;
    padding: 0.5em;
  }

  .btn-main {
    background-color: #B23900;
    border-radius: 10em;
    color: white;
    padding: 0.35em 1.5em 0.5em;
    font-weight: @fat-font-weight;

    &:hover {
      background-color: #993000;
      color: white;
    }

    &:focus {
      box-shadow: none;
    }
  }

  .btn-book {
    background-color: #009687;
    border-radius: 10em;
    color: white;
    font-weight: @fat-font-weight;

    &:hover {
      background-color: #00786C;
      color: white;
    }

    &:focus {
      box-shadow: none;
    }
  }

</style>