<template>
  <div>
    <navbar></navbar>
    <div class="container">
      <div class="row button-row">
        <router-link :to="{ name: 'addVisit'}">
          <button class="btn btn-md mb-3">Add new visit</button>
        </router-link>
      </div>
      <div class="card">
        <div class="card-header">
          All visits
        </div>
        <div class="card-body">
          <form ref="form">
            <table class="table table-hover">
              <thead>
              <tr>
                <th>Visit ID</th>
                <th>Doctor</th>
                <th>Procedure</th>
                <th>Date</th>
                <th>Time</th>
                <th>Active?</th>
                <th>Booked?</th>
                <th></th>
                <th></th>
              </tr>
              </thead>
              <tbody>
              <tr v-for="visit in visits">
                <td>{{ visit.id }}</td>
                <td>{{ visit.doctor.name }}</td>
                <td>{{ visit.procedure.name }}</td>
                <td>{{ visit.date }}</td>
                <td>{{ visit.time }}</td>
                <td><i class="oi oi-check visit-list__oi-check" v-if="visit.isActive"></i></td>
                <td><i class="oi oi-check visit-list__oi-check" v-if="visit.isBooked"></i></td>
                <td class="visit-list__edit">
                  <router-link :to="{ name: 'editVisit', params: { visitId: visit.id }}">
                    <i class="oi oi-pencil visit-list__oi-pencil"></i>
                    Edit
                  </router-link>
                </td>
                <td class="visit-list__delete">
                  <i class="oi oi-trash" v-on:click="deleteVisit(visit.id)"></i>
                </td>
              </tr>
              </tbody>
            </table>
          </form>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import Navbar from "@/components/admin/Navbar.vue";

  export default {
    name: "visitList",
    components: {
      Navbar
    },
    data() {
      return {
        visits: null
      };
    },
    mounted() {
      fetch('/dentalclinic/api/visits/getallbyid').then(response => {
        response.json().then(data => {
          this.visits = data;
        });
      });
    },
    methods: {
      deleteVisit(visitId) {
        if (window.confirm("Do you really want to delete a visit with ID: " + visitId + "?")) {
          fetch("/dentalclinic/api/visits/delete/" + visitId, {
            method: 'DELETE'
          }).then(result => {
            location.reload();
          }).catch(error => {
            console.error('Request failure: ', error);
          });
        }
      }
    }
  }
</script>

<style lang="less" scoped>
  @bold: 600;
  @medium-sea-green: mediumseagreen;
  @light-green: #52B377;
  @dark-green: #336B41;
  @light-red: #FF5F57;
  @small: small;

  .container {
    margin-top: -1em;

    .button-row {
      margin-left: 0;
      margin-right: 0;

      a {
        margin-left: auto;
      }
    }
  }

  .visit-list {
    &__oi-check {
      color: @medium-sea-green;
    }

    &__edit {
      font-weight: @bold;

      a {
        color: @light-green;

        &:hover {
          color: @dark-green;
        }
      }
    }

    &__oi-pencil {
      font-size: @small;
    }

    &__delete {
      color: @light-red;
      cursor: pointer;

      &:hover {
        color: darkred;
      }
    }
  }

  .card {
    margin-bottom: 3em;
  }

  .btn {
    background-color: #009687;
    border-radius: 10em;
    color: white;
    font-weight: 500;
    padding: 0.25em 1.5em 0.25em;

    &:hover {
      background-color: #00786C;
      color: white;
    }

    &:focus {
      box-shadow: none;
    }
  }
</style>

