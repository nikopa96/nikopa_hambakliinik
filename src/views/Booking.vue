<template>
  <div class="container">
    <Navbar/>
    <div class="row">
      <div class="column col-12 col-md-5 pr-md-5">
        <h1 class="title">Broneeri aeg</h1>
        <div class="mb-4">
          <label for="chooseService">Vali teenus:</label>
          <select
            class="custom-select"
            id="chooseService"
            v-model="chosenService"
            @change="getVisits(chosenService, chosenDoctor)"
          >
            <option
              v-for="service in services"
              v-bind:key="service.id"
              v-bind:value="service.id"
            >{{ service.type }}</option>
          </select>
        </div>
        <div class="mb-4">
          <label for="chooseDoctor">Vali arsti:</label>
          <select
            class="custom-select"
            id="chooseDoctor"
            v-model="chosenDoctor"
            @change="getVisits(chosenService, chosenDoctor)"
          >
            <option selected v-bind:value="0">Kõik arstid</option>
            <option
              v-for="doctor in doctors"
              v-bind:key="doctor.id"
              v-bind:value="doctor.id"
            >{{ doctor.name }}</option>
          </select>
        </div>
      </div>
      <div class="column col-12 col-md-7 pl-md-5 d-none d-md-block" v-if="!chosenService">
        <img class="mt-md-5" src="@/assets/img/arrow-left.svg" alt>
        <p class="lead mt-4 text-center">
          Palun vali teenust ja arsti.
          <br>Siin ilmuvad võimalikud visiidite variantid
        </p>
      </div>
      <div class="column col-12 col-md-7 pl-lg-5 pl-0 pr-0 visits" v-else>
        <h1 class="title mb-3">Visiidid</h1>
        <nav class="nav mb-4 mb-4 ml-2 ml-md-0 sort">
          <div class="nav-link p-0 mr-3">Sorteeri:</div>
          <a
            class="nav-link p-0 mr-3"
            v-bind:class="{ 'sort__item--active': sorting === 'DOCTOR', 'sort__item--inactive': sorting === 'TIME' }"
            v-on:click="{{ sorting = 'DOCTOR'; getVisits(chosenService, chosenDoctor) }}"
          >arstide järgi</a>
          <a
            class="nav-link p-0 mr-3"
            v-bind:class="{ 'sort__item--active': sorting === 'TIME', 'sort__item--inactive': sorting === 'DOCTOR' }"
            v-on:click="{{ sorting = 'TIME'; getVisits(chosenService, chosenDoctor) }}"
          >aegade järgi</a>
        </nav>
        <div v-if="sorting === 'DOCTOR'">
          <div v-for="result in results" v-bind:key="result.id">
            <h4 class="visits__list__heading mb-4 ml-2 ml-md-0">{{ 'Dr. ' + result.doctor.name }}</h4>
            <ul class="list-group mb-5 striped-list">
              <li
                class="list-group-item d-flex justify-content-between align-items-center pl-2 pr-2 pl-md-4 pr-md-4"
                v-for="time in result.times"
                v-bind:key="time.id"
              >
                <h5 class="mb-0">{{ time }}</h5>
                <router-link
                  :to="{ name: 'register', params: { serviceId: result.service.id, doctorId: result.doctor.id, time: time }}"
                >
                  <a class="btn btn-book btn-md pl-4 pr-4" href role="button">Broneeri</a>
                </router-link>
              </li>
            </ul>
          </div>
        </div>
        <div v-if="sorting === 'TIME'">
          <div v-for="result in resultsByTime" v-bind:key="result.id">
            <h4 class="visits__list__heading mb-4 ml-2 ml-md-0">{{ result.interval }}</h4>
            <ul class="list-group mb-5 striped-list">
              <li
                class="list-group-item d-flex justify-content-between align-items-center pl-2 pr-2 pl-md-4 pr-md-4"
                v-for="visit in result.visits"
                v-bind:key="visit.id"
              >
                <h5 class="mb-0 visits__list__doctor-time">{{ visit.time }}</h5>
                <h5 class="mb-0 visits__list__doctor-name">{{ 'Dr. ' + visit.doctor.name }}</h5>
                <router-link :to="{ name: 'register', params: { serviceId: visit.service.id, doctorId: visit.doctor.id, time: visit.time }}">
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
import Navbar from "@/components/Navbar.vue";
import Footer from "@/components/Footer.vue";

import axios from "axios";

export default {
  name: "booking",
  components: {
    Navbar,
    Footer
  },
  data() {
    return {
      info: null,
      services: null,
      doctors: null,
      servicesByDoctor: null,
      chosenService: null,
      chosenDoctor: null,
      results: null,
      resultsByTime: null,
      sorting: "DOCTOR"
    };
  },
  mounted() {
    axios.get("http://dijkstra.cs.ttu.ee/~nikopa/kasutajaliidesed/mock_data/data.json").then(response => {
      this.info = response.data;

      this.services = this.info.services;
      this.doctors = this.info.doctors;
      this.servicesByDoctor = this.info.servicesByDoctor;
      this.servicesByTime = this.info.servicesByTime;
    });
  },
  methods: {
    getVisits(chosenServiceId, chosenDoctorId) {
      if (this.sorting === "DOCTOR") {
        this.getVisitsSortedByDoctor(chosenServiceId, chosenDoctorId);
      } else {
        this.getVisitsSortedByTime(chosenServiceId, chosenDoctorId);
      }
    },
    getVisitsSortedByDoctor(chosenServiceId, chosenDoctorId) {
      this.results = this.servicesByDoctor.filter(visit => {
        if (chosenDoctorId !== null && chosenDoctorId !== 0) {
          return (
            visit.service.id === chosenServiceId &&
            visit.doctor.id === chosenDoctorId
          );
        } else {
          return visit.service.id === chosenServiceId;
        }
      });
    },
    getVisitsSortedByTime(chosenServiceId, chosenDoctorId) {
      let results = [];
      this.servicesByTime.forEach(visit => {
        let customVisit = { interval: visit.interval, visits: [] };
        visit.visits.forEach(visitTime => {
          if (visitTime.service.id === chosenServiceId) {
            customVisit.visits.push(visitTime);
          }
        });
        results.push(customVisit);
      });

      let resultsByTime = {};
      results = results.filter(result => result.visits.length !== 0);
      results.forEach(result => {
        resultsByTime[result.interval] = result;
      });

      this.resultsByTime = resultsByTime;
    }
  }
};
</script>