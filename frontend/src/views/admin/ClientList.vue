<template>
  <div>
    <navbar></navbar>
    <div class="container">
      <div class="card">
        <div class="card-header">All clients</div>
        <div class="card-body">
          <table class="table table-hover">
            <thead>
              <tr>
                <th>Name</th>
                <th>Surname</th>
                <th>Telephone</th>
                <th>Email</th>
                <th>Connection type</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="client in clients" v-bind:key="client.id">
                <td>{{ client.name }}</td>
                <td>{{ client.surname }}</td>
                <td>{{ client.telephone }}</td>
                <td>{{ client.email }}</td>
                <td>{{ client.connectionType }}</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Navbar from "@/components/admin/Navbar.vue";

export default {
  name: "clientList",
  components: {
    Navbar
  },
  data() {
    return {
      clients: null
    };
  },
  mounted() {
    fetch("/dentalclinic/api/clients/getall").then(response => {
      response.json().then(data => {
        this.clients = data;
      });
    });
  }
};
</script>

<style scoped></style>
