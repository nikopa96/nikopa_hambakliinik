<template>
  <div class="container">
    <Navbar/>
    <div class="row mt-5">
      <div class="col-md-4 mx-auto booking-info">
        <h5 class="mb-5">
          Aitäh!
          <br>Teie broneering edukalt registreeritud
        </h5>
        <div class="card">
          <div class="card-body">
            <p class="card-text mb-1 mt-4">Teenus:</p>
            <h5 class="card-title mb-4">{{ procedureName }}</h5>

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
import Navbar from "@/components/website/Navbar.vue";
import Footer from "@/components/website/Footer.vue";

export default {
  name: "thanks",
  components: {
    Navbar,
    Footer
  },
  data() {
    return {
      procedureName: null,
      doctorName: null,
      time: null
    };
  },
  mounted() {
    let userVisit = JSON.parse(this.$ls.get("userVisit"));
    this.procedureName = userVisit.procedureName;
    this.doctorName = userVisit.doctorName;
    this.time = userVisit.time;

    this.$ls.remove("userVisit");
  }
};
</script>

<style lang="less" scoped>
  @fat-font-weight: 500;

  .booking-info {
    text-align: center;
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
</style>