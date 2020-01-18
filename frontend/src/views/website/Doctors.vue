<template>
  <div>
    <alert></alert>
    <div class="container">
      <navbar></navbar>
      <h1 class="title">Doctors</h1>
      <div class="row">
        <div class="col-12 col-md-8 mb-5 mb-md-0">
          <div class="row row-cols-1 row-cols-md-2 row-cols-lg-3">
            <div
              class="col mb-4"
              v-for="doctor in doctors"
              v-bind:key="doctor.id"
            >
              <div class="card">
                <img
                  class="card-img-top"
                  v-bind:src="images.blankPhoto"
                  v-bind:alt="doctor.name"
                />
                <div class="card-body">
                  <h5 class="card-title mb-4">{{ doctor.name }}</h5>
                  <p class="card-text telephone mb-1">
                    <i class="fas fa-phone"></i>
                    <a v-bind:href="'tel:' + doctor.telephone">
                      {{ doctor.telephone }}
                    </a>
                  </p>
                  <p class="card-text email">
                    <i class="fas fa-at"></i>
                    <a v-bind:href="'mailto:' + doctor.email">
                      {{ doctor.email }}
                    </a>
                  </p>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="col-12 col-md-4">
          <sidebar></sidebar>
        </div>
      </div>
      <Footer />
    </div>
  </div>
</template>

<script>
import Navbar from "@/components/website/Navbar";
import Alert from "@/components/website/Alert";
import Footer from "@/components/website/Footer";
import Sidebar from "@/components/website/Sidebar";

export default {
  name: "doctors",
  components: {
    Alert,
    Navbar,
    Sidebar,
    Footer
  },
  data() {
    return {
      images: {
        blankPhoto: require("@/assets/img/blank_photo.png")
      },
      doctors: null
    };
  },
  mounted() {
    const doctorsApi = fetch("/dentalclinic/api/doctors/getall").then(
      response => {
        return response.json();
      }
    );

    Promise.all([doctorsApi]).then(responses => {
      this.doctors = responses[0];
    });

    console.log();
  }
};
</script>

<style lang="less" scoped>
@fat-font-weight: 500;

.title {
  text-transform: uppercase;
  font-size: 1.5em;
  font-weight: @fat-font-weight;
  letter-spacing: 2px;
  margin-top: 1.5em;
  margin-bottom: 1.5em;
  color: #575757;
}

.card {
  height: 100%;
}

.telephone a {
  font-weight: @fat-font-weight;
  color: rgba(0, 0, 0, 0.8);
}

.email a {
  font-size: 0.8em;
  color: rgba(0, 0, 0, 0.8);
}
</style>
