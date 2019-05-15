<template>
  <div class="container">
    <Navbar/>
    <div class="jumbotron jumbotron-fluid d-none d-lg-block promo">
      <div class="container promo__container">
        <h1 class="text-light">
          Kvaliteetne hambaravi
          <br>kõigile!
        </h1>
        <p class="lead promo__container__button">
          <router-link to="/booking">
            <a class="btn btn-main btn-lg" href role="button">Broneeri aeg siin</a>
          </router-link>
        </p>
        <div>
          <div class="text-light">või helistage numbril:</div>
          <h4 class="text-light">+372 685 0001</h4>
        </div>
      </div>
    </div>
    <div class="row d-block d-lg-none promo--mobile">
      <div class="col-md-lg promo__content--mobile">
        <h2 class="text-light">
          Kvaliteetne hambaravi
          <br>kõigile!
        </h2>
      </div>
      <div class="col-md-lg promo__content--mobile">
        <router-link to="/booking">
          <a class="btn btn-main btn-lg" href role="button">Broneeri aeg siin</a>
        </router-link>
      </div>
      <div class="col-md-lg promo__content--mobile">
        <div class="text-light">või helistage numbril:</div>
        <h4 class="text-light">+372 685 0001</h4>
      </div>
    </div>
    <h1 class="title">Miks me oleme?</h1>
    <div class="card-deck">
      <div class="card card--borderless">
        <img
          class="card-img-top card__card-img-top--size-small"
          src="@/assets/img/homepage-promo-1.png"
          alt
        >
        <div class="card-body">
          <h4 class="card-title card__card-title--thin-text">Lastele</h4>
          <p class="card-text">
            Meie hambakliinik omab lepingut Haigekassaga. Lapsed kuni 18.aastat ravivad
            tasuta!
          </p>
        </div>
      </div>
      <div class="card card--borderless">
        <img
          class="card-img-top card__card-img-top--size-small"
          src="@/assets/img/homepage-promo-2.png"
          alt
        >
        <div class="card-body">
          <h4 class="card-title card__card-title--thin-text">Täiskasvanutele</h4>
          <p
            class="card-text"
          >Kvaliteetne ja kiire teenindus. Võib kasutada LHV ja Liisi järelmaksu!</p>
        </div>
      </div>
      <div class="card card--borderless">
        <img
          class="card-img-top card__card-img-top--size-small"
          src="@/assets/img/homepage-promo-3.png"
          alt
        >
        <div class="card-body">
          <h4 class="card-title card__card-title--thin-text">Tudengitele</h4>
          <p class="card-text">Tudengitele ISIC-kaardi kasutamisel soodushinnad kuni 20%</p>
        </div>
      </div>
    </div>
    <h1 class="title">Meie asukoht</h1>
    <div class="row place">
      <div id="map" class="col-auto col-md-6 place__map">
        <GmapMap
          :center="mapPosition"
          :zoom="15"
          map-type-id="terrain"
          style="width: 100%; height: 350px;"
        >
          <GmapMarker
            :position="mapPosition"
          />
        </GmapMap>
      </div>
      <div class="d-none d-sm-block col-md-6 place__text">
        <h4 class="place__text__address place__text--thin-text">
          Tallinn
          <br>Mustamäe
          <br>Sõpruse pst 25a
        </h4>
        <h6 class="place__text--thin-text">Parkla 1h on tasuta</h6>
      </div>
      <div class="d-block d-sm-none col-auto place__text--mobile">
        <h4 class="place__text__address place__text--thin-text">
          Tallinn, Mustamäe
          <br>Sõpruse pst 25a
        </h4>
        <h6 class="place__text--thin-text">Parkla 1h on tasuta</h6>
      </div>
    </div>
    <Footer/>
  </div>
</template>

<script>
import Navbar from "@/components/Navbar.vue";
import Footer from "@/components/Footer.vue";

export default {
  name: "home",
  components: {
    Navbar,
    Footer
  },
  data() {
    return {
      mapPosition: {lat: 59.402, lng: 24.673}
    };
  }
};
</script>
