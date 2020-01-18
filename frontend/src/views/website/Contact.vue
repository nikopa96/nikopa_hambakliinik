<template>
  <div>
    <alert></alert>
    <div class="container">
      <navbar></navbar>
      <h1 class="title">Contacts</h1>
      <div class="row">
        <div class="col-12 col-md-8 mb-5 mb-md-0">
          <div class="info mb-5">
            <p class="lead mb-1">Head of the clinic: Kenneth Sharples</p>
            <p class="lead mb-1">
              Phone number:
              <a href="tel:+3727550025">+372 755 0025</a>
            </p>
            <p class="lead mb-5">
              Email:
              <a href="mailto:kenneth.sharples@nikopa.ee">
                kenneth.sharples@nikopa.ee
              </a>
            </p>
            <p class="lead mb-1">Secretary: Janae Santos</p>
            <p class="lead mb-1">
              Phone number:
              <a href="tel:+3726850001">+372 685 0001</a>
            </p>
            <p class="lead">
              Email:
              <a href="mailto:secretary@nikopa.ee">secretary@nikopa.ee</a>
            </p>
          </div>
          <div class="info mb-5">
            <h1 class="title">Opening hours</h1>
            <p class="lead mb-1">Monday - Friday: 07:00 - 19:00</p>
            <p class="lead mb-1">Saturday: 10:00 - 15:00</p>
            <p class="lead mb-1">Sunday: closed</p>
          </div>
          <div class="info">
            <h1 class="title">Location</h1>
            <div id="map">
              <GmapMap
                class="map"
                v-bind:center="mapPosition"
                v-bind:zoom="15"
                map-type-id="terrain"
              >
                <GmapMarker v-bind:position="mapPosition" />
              </GmapMap>
            </div>
            <p class="lead mt-4 mb-1">Tallinn, Mustamäe, Sõpruse pst 25a</p>
            <p class="lead">Parking 1 hour free</p>
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
import Alert from "@/components/website/Alert";
import Sidebar from "@/components/website/Sidebar";
import Footer from "@/components/website/Footer";
import Navbar from "@/components/website/Navbar";

export default {
  name: "contact",
  components: {
    Alert,
    Navbar,
    Sidebar,
    Footer
  },
  data() {
    return {
      mapPosition: { lat: 59.402, lng: 24.673 }
    };
  }
};
</script>

<style lang="less" scoped>
.title {
  text-transform: uppercase;
  font-size: 1.5em;
  font-weight: 500;
  letter-spacing: 2px;
  margin-top: 1.5em;
  margin-bottom: 1.5em;
  color: #575757;
}

.info {
  p {
    font-weight: 400;
  }
}

.map {
  width: 100%;
  height: 500px;
}
</style>
