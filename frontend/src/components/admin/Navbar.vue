<template>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
      <router-link :to="{ name: 'home'}">
        <a class="navbar-brand" href="#">
          <img src="@/assets/img/logo-light.png" width="130" alt="">
        </a>
      </router-link>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText"
              aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarText">
        <ul class="navbar-nav ml-4">
          <router-link :to="{ name: 'visitList'}" tag="li" class="nav-item"
                       v-bind:class="{ 'active': $route.name === 'visitList' }">
            <a class="nav-link mr-2" href="#">Visits</a>
          </router-link>
          <router-link :to="{ name: 'clientList'}" tag="li" class="nav-item"
                       v-bind:class="{ 'active': $route.name === 'clientList' }">
            <a class="nav-link mr-2" href="#">Clients</a>
          </router-link>
        </ul>
      </div>
    </div>
  </nav>
</template>

<script>
  export default {
    name: "navbar"
  }
</script>

<style lang="less" scoped>
  @large: large;

  .navbar {
    margin-bottom: 2em;
  }

  .navbar-brand {
    padding: 0;
  }

  .nav-link {
    font-size: @large;
  }
</style>