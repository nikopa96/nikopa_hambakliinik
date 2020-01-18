<template>
  <div class="sidebar">
    <router-link to="/booking">
      <a class="btn btn-main btn-lg mb-3" href role="button">Book a visit</a>
    </router-link>
    <div class="telephone-info">
      <div>or call by phone:</div>
      <h4>
        <a href="tel:+3726850001">+372 685 0001</a>
      </h4>
    </div>
  </div>
</template>

<script>
export default {
  name: "sidebar"
};
</script>

<style lang="less" scoped>
.sidebar {
  text-align: center;
}

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

.telephone-info {
  a {
    color: rgba(0, 0, 0, 1);
  }
}
</style>
