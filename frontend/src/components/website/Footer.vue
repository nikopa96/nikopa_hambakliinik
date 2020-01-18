<template>
  <div class="row footer">
    <div class="col-md-4 footer__logo">
      <img :src="images.logo" width="195" alt="" />
      <div>© 2020 Nikopa hambakliinik</div>
    </div>
    <div class="col-md-2 footer__column">
      <router-link to="/booking" tag="h6">
        <a class="footer__link" href="">Booking</a>
      </router-link>
    </div>
    <div class="col-md-2 footer__column">
      <router-link to="/procedures" tag="h6">
        <a class="footer__link" href="">Procedures and Prices</a>
      </router-link>
    </div>
    <div class="col-md-2 footer__column">
      <router-link to="/doctors" tag="h6">
        <a class="footer__link" href="">Doctors</a>
      </router-link>
    </div>
    <div class="col-md-2 footer__column">
      <h6>About us</h6>
      <router-link to="/contact" tag="a" class="footer__link--child">
        Contact
      </router-link>
      <router-link to="/careers" tag="a" class="footer__link--child">
        Careers
      </router-link>
    </div>
  </div>
</template>

<script>
export default {
  name: "Footer",
  data() {
    return {
      images: {
        logo: require("@/assets/img/logo-light.png")
      }
    };
  }
};
</script>

<style lang="less" scoped>
.footer {
  background-color: #00786c;
  padding-top: 2.5em;
  padding-bottom: 2.5em;
  margin-top: 4.5em;
  color: white;
  height: auto;

  &__logo {
    text-align: center;
  }

  &__link {
    color: white;

    &:hover {
      color: #d4d4d4;
      text-decoration: none;
    }

    &--child {
      color: white;
      display: block;
      margin-top: 0.5em;
    }
  }

  h6 {
    text-transform: uppercase;
    letter-spacing: 2px;
  }
}

@media only screen and (max-width: 575.98px) {
  .title {
    text-align: center;
  }

  .footer {
    text-align: center;

    &__logo {
      margin-bottom: 1em;
    }

    &__column {
      margin-top: 1em;
    }
  }
}
</style>
