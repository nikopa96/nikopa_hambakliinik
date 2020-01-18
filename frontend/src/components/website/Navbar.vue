<template>
  <div>
    <b-navbar class="nav" toggleable="lg" type="light">
      <b-navbar-brand href="#">
        <router-link to="/">
          <a class="navbar-brand" href="#">
            <img
              class="d-none d-lg-block"
              src="@/assets/img/logo.png"
              width="240"
              alt=""
            />
            <img
              class="d-block d-lg-none"
              src="@/assets/img/logo.png"
              width="150"
              alt=""
            />
          </a>
        </router-link>
      </b-navbar-brand>
      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>
      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav class="ml-auto">
          <b-nav-item class="nav-text" text="" right>
            <router-link to="/booking">
              <a>Booking</a>
            </router-link>
          </b-nav-item>
          <b-nav-item class="nav-text" text="" right>
            <router-link to="/procedures">
              <a>Procedures and Prices</a>
            </router-link>
          </b-nav-item>
          <b-nav-item class="nav-text" text="" right>
            <router-link to="/doctors">
              <a>Doctors</a>
            </router-link>
          </b-nav-item>
          <b-nav-item-dropdown class="nav-text" text="About us" right>
            <router-link to="/contact" tag="b-dropdown-item">
              Contact
            </router-link>
            <router-link to="/careers" tag="b-dropdown-item">
              Careers
            </router-link>
          </b-nav-item-dropdown>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
  </div>
</template>

<script>
export default {
  name: "navbar"
};
</script>

<style lang="less" scoped>
@fat-font-weight: 500;

.nav {
  padding-top: 0;
}

.nav-text {
  font-size: 1.25em;
  font-weight: @fat-font-weight;
  margin-left: 1em;

  a {
    color: rgba(0, 0, 0, 0.5);
  }

  a:hover {
    color: rgba(0, 0, 0, 0.8);
    text-decoration: none;
  }
}
</style>
