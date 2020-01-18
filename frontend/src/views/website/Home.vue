<template>
  <div>
    <alert></alert>
    <div class="container">
      <navbar></navbar>
      <div
        class="jumbotron jumbotron-fluid d-none d-lg-block promo"
        :style="{ backgroundImage: `url('${images.promoBlock}')` }"
      >
        <div class="container promo__container">
          <h1 class="text-light">
            Quality Dental Care
            <br />for everyone!
          </h1>
          <p class="lead promo__container__button">
            <router-link to="/booking">
              <a class="btn btn-main btn-lg" role="button">
                Book a visit here
              </a>
            </router-link>
          </p>
          <div>
            <div class="text-light">or call by phone:</div>
            <h4 class="text-light">+372 685 0001</h4>
          </div>
        </div>
      </div>
      <div class="row d-block d-lg-none promo--mobile">
        <div class="col-md-lg promo__content--mobile">
          <h2 class="text-light">
            Quality Dental Care
            <br />for everyone!
          </h2>
        </div>
        <div class="col-md-lg promo__content--mobile">
          <router-link to="/booking">
            <a class="btn btn-main btn-lg" role="button">
              Book a visit here
            </a>
          </router-link>
        </div>
        <div class="col-md-lg promo__content--mobile">
          <div class="text-light">or call by phone:</div>
          <h4 class="text-light">+372 685 0001</h4>
        </div>
      </div>
      <h1 class="title">Why exactly us?</h1>
      <div class="card-deck">
        <div class="card">
          <img
            class="card-img-top card__card-img-top"
            :src="images.homepagePromo1"
            alt
          />
          <div class="card-body">
            <h4 class="card-title card__card-title">For children</h4>
            <p class="card-text">
              Our dental clinic has an agreement with the Estonian health
              insurance fund. Сhildren under 18 can treat their teeth for free.
            </p>
          </div>
        </div>
        <div class="card">
          <img
            class="card-img-top card__card-img-top"
            :src="images.homepagePromo2"
            alt
          />
          <div class="card-body">
            <h4 class="card-title card__card-title">For adults</h4>
            <p class="card-text">
              Quality and quick service. There is a possibility of treatment in
              installments!
            </p>
          </div>
        </div>
        <div class="card">
          <img
            class="card-img-top card__card-img-top"
            :src="images.homepagePromo3"
            alt
          />
          <div class="card-body">
            <h4 class="card-title card__card-title">For students</h4>
            <p class="card-text">
              Students with an ISIC card receive a 20% discount!
            </p>
          </div>
        </div>
      </div>
      <h1 class="title">Our Location</h1>
      <div class="row place">
        <div id="map" class="col-auto col-md-6 place__map">
          <GmapMap
            :center="mapPosition"
            :zoom="15"
            map-type-id="terrain"
            style="width: 100%; height: 350px;"
          >
            <GmapMarker :position="mapPosition" />
          </GmapMap>
        </div>
        <div class="d-none d-sm-block col-md-6 place__text">
          <h4>Tallinn<br />Mustamäe<br />Sõpruse pst 25a</h4>
          <h6>Parking 1 hour free</h6>
        </div>
        <div class="d-block d-sm-none col-auto place__text--mobile">
          <h4>
            Tallinn, Mustamäe
            <br />Sõpruse pst 25a
          </h4>
          <h6>Parking 1 hour free</h6>
        </div>
      </div>
      <Footer />
    </div>
  </div>
</template>

<script>
import Navbar from "@/components/website/Navbar.vue";
import Footer from "@/components/website/Footer.vue";
import Alert from "@/components/website/Alert.vue";

export default {
  name: "home",
  components: {
    Navbar,
    Footer,
    Alert
  },
  data() {
    return {
      images: {
        promoBlock: require("@/assets/img/promo-block.jpg"),
        homepagePromo1: require("@/assets/img/homepage-promo-1.png"),
        homepagePromo2: require("@/assets/img/homepage-promo-2.png"),
        homepagePromo3: require("@/assets/img/homepage-promo-3.png")
      },
      mapPosition: { lat: 59.402, lng: 24.673 }
    };
  }
};
</script>

<style lang="less" scoped>
@fat-font-weight: 500;
@letter-spacing-wide: 2px;
@thin-font-weight: 400;

.promo {
  background-size: cover;
  background-repeat: no-repeat;
  background-position-y: center;

  &__container {
    padding: 1em 5em;

    &__button {
      margin-top: 1.5em;
      margin-bottom: 2.5em;
    }
  }

  &--mobile {
    background-color: #009687;
    padding-top: 2.5em;
    padding-bottom: 1em;
  }

  &__content--mobile {
    margin-left: auto;
    margin-right: auto;
    margin-bottom: 2.5em;
    text-align: center;
  }

  h1 {
    font-size: 3rem;
  }
}

.btn-main {
  background-color: #b23900;
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

.card {
  border: none;

  &__card-title {
    font-weight: @thin-font-weight;
  }

  &__card-img-top {
    width: 80%;
    margin-left: auto;
    margin-right: auto;
  }
}

.place {
  margin-left: 0;
  margin-right: 0;

  &__map {
    height: 350px;
    width: 100%;
    padding: 0;
  }

  &__text {
    padding-left: 3.5em;
    font-weight: @thin-font-weight;

    h4 {
      font-weight: @thin-font-weight;
      line-height: 1.5;
      margin-bottom: 1.5em;
    }

    h6 {
      font-weight: @thin-font-weight;
    }

    &--mobile {
      margin-top: 1.5em;
      margin-left: auto;
      margin-right: auto;
      text-align: center;
    }
  }

  .place__text--mobile {
    margin-top: 1.5em;
    margin-left: auto;
    margin-right: auto;
    text-align: center;

    h4 {
      font-weight: @thin-font-weight;
      margin-bottom: 1em;
    }

    h6 {
      font-weight: @thin-font-weight;
    }
  }
}
</style>
