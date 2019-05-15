<template>
  <div class="container">
    <Navbar/>
    <div class="row mt-5">
      <div class="col-md-4 mx-auto booking-info--text-center">
        <h5 class="mb-5">
          Aitäh!
          <br>Teie broneering edukalt registreeritud
        </h5>
        <div class="card booking-info">
          <div class="card-body">
            <p class="card-text mb-1 mt-4">Teenus:</p>
            <h5 class="card-title mb-4">{{ serviceType }}</h5>

            <p class="card-text mb-1">Arst:</p>
            <h5 class="card-title mb-4">{{ 'Dr. ' + doctorName }}</h5>

            <p class="card-text mb-1">Aeg:</p>
            <h5 class="card-title mb-5">{{ time }}</h5>
          </div>
        </div>
        <router-link to="/">
            <a class="btn btn-main btn-md mt-5 mb-5 pl-5 pr-5" href="" role="button">Avalehele</a>
        </router-link>
      </div>
    </div>
    <Footer/>
  </div>
</template>

<script>
import Navbar from "@/components/Navbar.vue";
import Footer from "@/components/Footer.vue";

export default {
  name: "thanks",
  components: {
    Navbar,
    Footer
  },
  data() {
    return {
      serviceType: null,
      doctorName: null,
      time: null
    };
  },
  mounted() {
    let userVisit = JSON.parse(this.$ls.get("userVisit"));
    this.serviceType = userVisit.serviceType;
    this.doctorName = userVisit.doctorName;
    this.time = userVisit.time;

    this.$ls.remove("userVisit");
  }
};
</script>

