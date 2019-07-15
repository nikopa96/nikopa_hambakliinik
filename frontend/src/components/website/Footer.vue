<template>
  <div class="row footer">
    <div class="col-md-4 footer__logo">
      <img :src="images.logo" width="195" alt="">
      <div>© 2019 Nikopa hambakliinik</div>
    </div>
    <div class="col-md-2 footer__column">
      <h6>Broneeri</h6>
    </div>
    <div class="col-md-2 footer__column">
      <h6>Teenused ja hinnakiri</h6>
    </div>
    <div class="col-md-2 footer__column">
      <h6>Kliinikust</h6>
      <a class="footer__link" href="#">Tutvustus</a>
      <a class="footer__link" href="#">Arstid</a>
    </div>
    <div class="col-md-2 footer__column">
      <h6>Kontakt</h6>
      <a class="footer__link" href="#">Üldinfo</a>
      <a class="footer__link" href="#">Karjäär</a>
    </div>
  </div>
</template>

<script>
export default {
  name: "Footer",
  data() {
    return {
      images: {
        logo: require('@/assets/img/logo-light.png')
      }
    };
  }
};
</script>

<style lang="less" scoped>
  @letter-spacing-wide: 2px;

  .footer {
    background-color: #00786C;
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
      display: block;
      margin-top: 0.5em;
    }

    h6 {
      text-transform: uppercase;
      letter-spacing: @letter-spacing-wide;
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
