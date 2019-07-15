<template>
  <div class="alert">
    <h6 class="alert__title">Nikolai Kopa portfolio</h6>
    <h6 class="alert__description">Backend: Spring Boot + Java, Frontend: Vue.js + Bootstrap + LESS, Database: PostgreSQL</h6>
    <div class="alert__buutons">
      <router-link :to="{ name: 'visitList'}" tag="a" class="btn btn-outline-light">Admin Panel</router-link>
      <a href="https://github.com/nikopa96/nikopa_hambakliinik" role="button" class="btn btn-outline-light">Source Code</a>
    </div>
  </div>
</template>

<script>
  export default {
    name: "alert"
  }
</script>

<style lang="less" scoped>
  @fat-font-weight: 500;
  @letter-spacing-wide: 1.5px;
  @thin-font-weight: 400;

  .alert {
    background-color: #009788;
    border-radius: 0;
    color: white;

    &__title {
      text-transform: uppercase;
      font-weight: @fat-font-weight;
      letter-spacing: @letter-spacing-wide;
      display: inline-block;
      margin-bottom: 0.35em;
    }

    &__description {
      display: inline-block;
      font-weight: @thin-font-weight;
      margin-left: 2em;
      margin-bottom: 0.35em;
    }

    &__buutons {
      display: inline-block;
      float: right;
      margin-top: -0.4em;
    }

    .btn {
      padding-left: 1.5em;
      padding-right: 1.5em;
      margin-left: 1em;
      font-weight: @fat-font-weight;
    }
  }

  @media only screen and (max-width: 1240px) {
    .alert {
      text-align: center;

      &__description {
        margin-left: 0;
      }

      &__buutons {
        float: none;
        margin-top: 1em;
      }
    }
  }
</style>