<template>
  <div>
    <navbar></navbar>
    <div class="container">
      <div class="card">
        <div class="card-header">Add new visit</div>
        <div class="card-body">
          <div
            class="alert alert-danger"
            role="alert"
            v-if="formValid === false"
          >
            Form is invalid!
          </div>
          <form
            class="needs-validation"
            @submit.prevent="submit"
            v-if="procedures && doctors"
          >
            <div class="form-group">
              <label for="addDoctor">Doctor:</label>
              <select
                class="custom-select"
                name="doctor"
                v-validate="'required'"
                v-bind:class="{ 'is-invalid': errors.has('doctor') }"
                id="addDoctor"
                v-model="newDoctor"
              >
                <option
                  v-for="doctor in doctors"
                  v-bind:key="doctor.id"
                  v-bind:value="doctor.id"
                >
                  {{ doctor.name }}
                </option>
              </select>
              <div class="invalid-feedback">{{ errors.first("doctor") }}</div>
            </div>
            <div class="form-group">
              <label for="addProcedure">Procedure:</label>
              <select
                class="custom-select"
                name="procedure"
                v-validate="'required'"
                v-bind:class="{ 'is-invalid': errors.has('procedure') }"
                id="addProcedure"
                v-model="newProcedure"
              >
                <option
                  v-for="procedure in procedures"
                  v-bind:key="procedure.id"
                  v-bind:value="procedure.id"
                >
                  {{ procedure.name }}
                </option>
              </select>
              <div class="invalid-feedback">
                {{ errors.first("procedure") }}
              </div>
            </div>
            <div class="form-group">
              <label for="addTime">Time:</label>
              <input
                type="text"
                class="form-control"
                name="time"
                v-validate="{
                  required: true,
                  regex: /^(?:[01]\d|2[0123]):(?:[012345]\d)$/
                }"
                v-bind:class="{ 'is-invalid': errors.has('time') }"
                id="addTime"
                placeholder="HH:mm"
                v-model="newTime"
              />
              <div class="invalid-feedback">{{ errors.first("time") }}</div>
            </div>
            <div class="form-group">
              <label for="addDate">Date:</label>
              <input
                type="text"
                class="form-control"
                name="date"
                v-validate="{
                  required: true,
                  regex: /^((0[1-9]|[12]\d|3[01]).(0[1-9]|1[0-2]).[12]\d{3})$/
                }"
                v-bind:class="{ 'is-invalid': errors.has('date') }"
                id="addDate"
                placeholder="dd.MM.yyyy"
                v-model="newDate"
              />
              <div class="invalid-feedback">{{ errors.first("date") }}</div>
            </div>
            <div class="form-check">
              <input
                type="checkbox"
                class="form-check-input"
                name="newIsActive"
                id="addIsActive"
                v-model="newIsActive"
              />
              <label class="form-check-label" for="addIsActive">Active</label>
            </div>
            <div class="form-check">
              <input
                type="checkbox"
                class="form-check-input"
                name="newIsBooked"
                id="addIsBooked"
                v-model="newIsBooked"
              />
              <label class="form-check-label" for="addIsBooked">Booked</label>
            </div>

            <button type="submit" class="btn btn-md mt-5 mb-3">Add</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Navbar from "@/components/admin/Navbar.vue";

export default {
  name: "addVisit",
  components: {
    Navbar
  },
  data() {
    return {
      doctors: null,
      procedures: null,
      newDoctor: null,
      newProcedure: null,
      newTime: null,
      newDate: null,
      newIsActive: false,
      newIsBooked: false,
      formValid: null
    };
  },
  mounted() {
    const doctorsApi = fetch("/dentalclinic/api/doctors/getall").then(
      response => {
        return response.json();
      }
    );
    const proceduresApi = fetch("/dentalclinic/api/procedures/getall").then(
      response => {
        return response.json();
      }
    );

    Promise.all([proceduresApi, doctorsApi]).then(responses => {
      this.procedures = responses[0];
      this.doctors = responses[1];
    });
  },
  methods: {
    getTimeInterval(time) {
      let date = new Date();
      date.setHours(time.substr(0, time.indexOf(":")));

      const intervalBefore = date.getHours();
      date.setTime(date.getTime() + 60 * 60 * 1000);
      const intervalAfter = date.getHours();

      return intervalBefore + ":00 - " + intervalAfter + ":00";
    },
    postData() {
      const newVisit = {
        doctor: {
          id: this.newDoctor
        },
        procedure: {
          id: this.newProcedure
        },
        time: this.newTime,
        interval: this.getTimeInterval(this.newTime),
        date: this.newDate,
        isActive: this.newIsActive,
        isBooked: this.newIsBooked
      };

      fetch("/dentalclinic/api/visits/add", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(newVisit)
      })
        .then(() => {
          this.$router.push("/admin/visits");
        })
        .catch(error => {
          console.error("Request failure: ", error);
        });
    },
    submit() {
      this.$validator.validateAll().then(field => {
        if (field) {
          this.postData();
          return;
        }
        this.formValid = false;
      });
    }
  }
};
</script>

<style lang="less" scoped>
.btn {
  background-color: #b23900;
  border-radius: 10em;
  color: white;
  font-weight: 500;
  padding-left: 3em;
  padding-right: 3em;
  padding-bottom: 0.5em;

  &:hover {
    background-color: #993000;
    color: white;
  }

  &:focus {
    box-shadow: none;
  }
}
</style>
