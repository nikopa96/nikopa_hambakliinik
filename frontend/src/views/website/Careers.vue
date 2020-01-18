<template>
  <div>
    <alert></alert>
    <div class="container">
      <navbar></navbar>
      <h1 class="title">Careers</h1>
      <div class="row">
        <div class="col-12 col-md-8 mb-5 mb-md-0">
          <h1 class="display-4">Sorry :(</h1>
          <p class="lead">Currently no vacancies</p>
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
import Navbar from "@/components/website/Navbar";
import Sidebar from "@/components/website/Sidebar";
import Footer from "@/components/website/Footer";

export default {
  name: "careers",
  components: {
    Alert,
    Navbar,
    Sidebar,
    Footer
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

.display-4 {
  font-size: 3rem;
}
</style>
