<template>
  <div>
    <alert></alert>
    <div class="container">
      <navbar></navbar>
      <div class="row mt-5">
        <div class="col text-center not-found">
          <h1 class="display-1">404</h1>
          <h2 class="mb-5">Oops! Unable to find page</h2>
          <router-link to="/">
            <a class="btn btn-main btn-lg" href role="button">
              Go to start page
            </a>
          </router-link>
        </div>
      </div>
      <Footer />
    </div>
  </div>
</template>

<script>
import Alert from "@/components/website/Alert";
import Navbar from "@/components/website/Navbar";
import Footer from "@/components/website/Footer";

export default {
  name: "not-found",
  components: {
    Alert,
    Navbar,
    Footer
  }
};
</script>

<style lang="less" scoped>
.btn-main {
  background-color: #b23900;
  border-radius: 10em;
  color: white;
  padding: 0.35em 2.5em 0.5em;
  font-weight: 500;

  &:hover {
    background-color: #993000;
    color: white;
  }

  &:focus {
    box-shadow: none;
  }
}
</style>
