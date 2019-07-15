<template>
  <div class="container">
    <navbar></navbar>
    <div class="row">
      <div class="column col-12 col-md-5 pr-md-5">
        <h1 class="title">Broneeri aeg</h1>
        <div class="mb-4">
          <label for="chooseProcedure">Vali teenus:</label>
          <select class="custom-select" id="chooseProcedure" v-model="chosenProcedure"
                  @change="getVisits()">
            <option v-for="procedure in procedures" v-bind:key="procedure.id" v-bind:value="procedure.id">
              {{ procedure.name }}
            </option>
          </select>
        </div>
        <div class="mb-4">
          <label for="chooseDoctor">Vali arsti:</label>
          <select class="custom-select" id="chooseDoctor" v-model="chosenDoctor"
                  @change="getVisits()">
            <option selected v-bind:value="0">Kõik arstid</option>
            <option v-for="doctor in doctors" v-bind:key="doctor.id" v-bind:value="doctor.id">
              {{ doctor.name }}
            </option>
          </select>
        </div>
        <div class="mb-4">
          <date-pick
              v-model="date"
              :hasInputElement="false"
              :format="'DD.MM.YYYY'"
              :weekdays="calendarSettings.weekdays"
              :months="calendarSettings.months"
              :nextMonthCaption="calendarSettings.nextMonthCaption.default"
              :prevMonthCaption="calendarSettings.prevMonthCaption.default"
          ></date-pick>
        </div>
      </div>
      <div class="column col-12 col-md-7 pl-md-5 d-none d-md-block" v-if="!chosenProcedure">
        <img class="mt-md-5" :src="images.arrowLeft" alt="">
        <p class="lead mt-4 text-center">
          Palun vali teenust ja arsti.
          <br>Siin ilmuvad võimalikud visiidite variantid
        </p>
      </div>
      <div class="column col-12 col-md-7 pl-lg-5 pl-0 pr-0 visits" v-else>
        <h1 class="title mb-3">Visiidid</h1>
        <nav class="nav mb-4 mb-4 ml-2 ml-md-0 sort">
          <div class="nav-link p-0 mr-3">Sorteeri:</div>
          <a class="nav-link p-0 mr-3"
             v-bind:class="{ 'sort__item--active': sorting === 'DOCTOR', 'sort__item--inactive': sorting === 'TIME' }"
             v-on:click="{{ sorting = 'DOCTOR'; getVisits() }}">arstide järgi</a>
          <a class="nav-link p-0 mr-3"
             v-bind:class="{ 'sort__item--active': sorting === 'TIME', 'sort__item--inactive': sorting === 'DOCTOR' }"
             v-on:click="{{ sorting = 'TIME'; getVisits() }}">aegade järgi</a>
        </nav>
        <div v-if="sorting === 'DOCTOR'">
          <div v-for="visitByDoctor in visitsByDoctor" v-bind:key="visitByDoctor.doctorId">
            <h4 class="visits__list__heading mb-4 ml-2 ml-md-0">
              {{ 'Dr. ' + visitByDoctor.doctorVisits[0].doctor.name }}
            </h4>
            <ul class="list-group mb-5 striped-list">
              <li class="list-group-item d-flex justify-content-between align-items-center pl-2 pr-2 pl-md-4 pr-md-4"
                  v-for="visit in visitByDoctor.doctorVisits" v-bind:key="visit.id">
                <h5 class="mb-0">{{ visit.time }}</h5>
                <router-link :to="{ name: 'register', params: { visitId: visit.id }}">
                  <a class="btn btn-book btn-md pl-4 pr-4" href role="button">Broneeri</a>
                </router-link>
              </li>
            </ul>
          </div>
        </div>
        <div v-if="sorting === 'TIME'">
          <div v-for="visitByTime in visitsByTime" v-bind:key="visitByTime.interval">
            <h4 class="visits__list__heading mb-4 ml-2 ml-md-0">{{ visitByTime.interval }}</h4>
            <ul class="list-group mb-5 striped-list">
              <li class="list-group-item d-flex justify-content-between align-items-center pl-2 pr-2 pl-md-4 pr-md-4"
                  v-for="visit in visitByTime.doctorVisits" v-bind:key="visit.id">
                <h5 class="mb-0 visits__list__doctor-time">{{ visit.time }}</h5>
                <h5 class="mb-0 visits__list__doctor-name">{{ 'Dr. ' + visit.doctor.name }}</h5>
                <router-link :to="{ name: 'register', params: { visitId: visit.id }}">
                  <a class="btn btn-book btn-md pl-4 pr-4" href="" role="button">Broneeri</a>
                </router-link>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
    <Footer/>
  </div>
</template>

<script>
import Navbar from "@/components/website/Navbar.vue";
import Footer from "@/components/website/Footer.vue";
import DatePick from 'vue-date-pick';
import 'vue-date-pick/dist/vueDatePick.css';

export default {
  name: "booking",
  components: {
    Navbar,
    Footer,
    DatePick
  },
  data() {
    return {
      procedures: null,
      doctors: null,
      chosenProcedure: null,
      chosenDoctor: null,
      visitsByDoctor: null,
      visitsByTime: null,
      date: '30.07.2019',
      sorting: "DOCTOR",
      images: {
        arrowLeft: require('@/assets/img/arrow-left.svg'),
      },
      calendarSettings: {
        weekdays: ['E', 'T', 'K', 'N', 'R', 'L', 'P'],
        months: ['Jaanuar', 'Veebruar', 'Märts', 'Aprill', 'Mai', 'Juuni', 'Juuli', 'August', 'September', 'Oktoober',
          'November', 'Detsember'],
        nextMonthCaption: {type: String, default: 'Järgmine'},
        prevMonthCaption: {type: String, default: 'Eelmine'},
      }
    };
  },
  mounted() {
    const proceduresApi = fetch('/dentalclinic/api/procedures/getall').then(function(response){
      return response.json();
    });
    const doctorsApi = fetch('/dentalclinic/api/doctors/getall').then(function(response){
      return response.json();
    });
    const visitsApi = fetch('/dentalclinic/api/visits/getall').then(function(response){
      return response.json();
    });

    Promise.all([proceduresApi, doctorsApi, visitsApi]).then(responses => {
      this.procedures = responses[0];
      this.doctors = responses[1];
      this.visits = responses[2];
    });
  },
  methods: {
    getVisits() {
      if (this.sorting === "DOCTOR") {
        this.getVisitsSortedByDoctor();
      } else {
        this.getVisitsSortedByTime();
      }
    },
    getVisitsSortedByDoctor() {
      const results = this.visits.filter(visit => {
        if (this.chosenDoctor !== null && this.chosenDoctor !== 0) {
          return (visit.date === this.date && visit.procedure.id === this.chosenProcedure && visit.doctor.id === this.chosenDoctor);
        } else {
          return visit.date === this.date && visit.procedure.id === this.chosenProcedure;
        }
      });

      const visits = results.reduce((r, a) => {
        r[a.doctor.id] = [...r[a.doctor.id] || [], a];
        return r;
      }, {});

      this.visitsByDoctor = Object.keys(visits).map(key => {
        return {doctorId: key, doctorVisits: visits[key]};
      });
    },
    getVisitsSortedByTime() {
      const results = this.visits.filter(visit => {
        if (this.chosenDoctor !== null && this.chosenDoctor !== 0) {
          return (visit.date === this.date && visit.procedure.id === this.chosenProcedure && visit.doctor.id === this.chosenDoctor);
        } else {
          return visit.date === this.date && visit.procedure.id === this.chosenProcedure;
        }
      });

      const visits = results.reduce((r, a) => {
        r[a.interval] = [...r[a.interval] || [], a];
        return r;
      }, {});

      this.visitsByTime = Object.keys(visits).map(key => {
        return {interval: key, doctorVisits: visits[key]};
      });
    }
  },
  watch: {
    date: function (val) {
      this.getVisits();
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

  .visits {
    &__list {
      width: 100%;

      &__heading {
        font-weight: @thin-font-weight;
      }

      &__doctor-name {
        font-weight: @thin-font-weight;
        width: 50%;
      }

      &__doctor-time {
        width: 10%;
      }

      &--thin-text {
        font-weight: @thin-font-weight;
      }
    }

    ul.striped-list > li:nth-of-type(odd) {
      background-color: #F0F0F0 ;
    }
  }

  .sort {
    &__item--active {
      font-weight: bold;
      color: black;
    }

    &__item--inactive {
      color: rgba(0, 0, 0, 0.5);

      &:hover {
        color: rgba(0, 0, 0, 1);
      }
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
