<template>
  <nav class="navbar navbar-expand-lg navbar-light">
    <router-link to="/">
      <a class="navbar-brand" href>
        <img class="d-none d-lg-block" src="@/assets/img/logo.png" width="240" alt>
        <img class="d-block d-lg-none" src="@/assets/img/logo.png" width="150" alt>
      </a>
    </router-link>
    <button
      class="navbar-toggler"
      type="button"
      data-toggle="collapse"
      data-target="#navbarNav"
      aria-controls="navbarNav"
      aria-expanded="false"
      aria-label="Toggle navigation"
    >
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item active">
          <router-link to="/booking">
            <a class="nav-link nav__link--fat-text">Broneeri</a>
          </router-link>
        </li>
        <li class="nav-item">
          <a class="nav-link nav__link--fat-text" href>Teenused ja hinnakiri</a>
        </li>
        <li class="nav-item dropdown">
          <a
            class="nav-link dropdown-toggle nav__link--fat-text"
            href
            id="about"
            role="button"
            data-toggle="dropdown"
            aria-haspopup="true"
            aria-expanded="false"
          >Kliinikust</a>
          <div class="dropdown-menu" aria-labelledby="about">
            <a class="dropdown-item" href>Tutvustus</a>
            <a class="dropdown-item" href>Arstid</a>
          </div>
        </li>
        <li class="nav-item dropdown">
          <a
            class="nav-link dropdown-toggle nav__link--fat-text"
            href
            id="contact"
            role="button"
            data-toggle="dropdown"
            aria-haspopup="true"
            aria-expanded="false"
          >Kontakt</a>
          <div class="dropdown-menu" aria-labelledby="contact">
            <a class="dropdown-item" href>Üldinfo</a>
            <a class="dropdown-item" href>Karjäär</a>
          </div>
        </li>
      </ul>
    </div>
  </nav>
</template>

<script>
export default {
  name: "Navbar"
};
</script>