<template>
  <div>
    <navbar></navbar>
    <div class="container">
      <div class="card">
        <div class="card-header">{{ "Edit visit with ID: " +  this.$route.params.visitId }}</div>
        <div class="card-body">
          <div class="alert alert-success" role="alert" v-if="formValid === true">
            Updated successfully!
          </div>
          <div class="alert alert-danger" role="alert" v-if="formValid === false">
            Form is invalid!
          </div>
          <form class="needs-validation" @submit.prevent="submit" v-if="procedures && doctors && visit">
            <div class="form-group">
              <label for="changeDoctor">Doctor:</label>
              <select class="custom-select" id="changeDoctor" v-model="newDoctor">
                <option v-for="doctor in doctors" v-bind:key="doctor.id" v-bind:value="doctor.id">
                  {{ doctor.name }}
                </option>
              </select>
            </div>
            <div class="form-group">
              <label for="changeProcedure">Procedure:</label>
              <select class="custom-select" id="changeProcedure" v-model="newProcedure">
                <option v-for="procedure in procedures" v-bind:key="procedure.id" v-bind:value="procedure.id">
                  {{ procedure.name }}
                </option>
              </select>
            </div>
            <div class="form-group">
              <label for="changeTime">Time:</label>
              <input
                  type="text"
                  class="form-control"
                  name="time"
                  v-validate="{required: true, regex: /^(?:[01]\d|2[0123]):(?:[012345]\d)$/}"
                  v-bind:class="{ 'is-invalid': errors.has('time') }"
                  id="changeTime"
                  placeholder="HH:mm"
                  v-model="newTime"
              >
              <div class="invalid-feedback">{{ errors.first('time') }}</div>
            </div>
            <div class="form-group">
              <label for="changeDate">Date:</label>
              <input
                  type="text"
                  class="form-control"
                  name="date"
                  v-validate="{required: true, regex: /^((0[1-9]|[12]\d|3[01]).(0[1-9]|1[0-2]).[12]\d{3})$/}"
                  v-bind:class="{ 'is-invalid': errors.has('date') }"
                  id="changeDate"
                  placeholder="dd.MM.yyyy"
                  v-model="newDate"
              >
              <div class="invalid-feedback">{{ errors.first('date') }}</div>
            </div>
            <div class="form-check">
              <input
                  type="checkbox"
                  class="form-check-input"
                  name="newIsActive"
                  id="changeIsActive"
                  v-model="newIsActive"
              >
              <label class="form-check-label" for="changeIsActive">Active</label>
            </div>
            <div class="form-check">
              <input
                  type="checkbox"
                  class="form-check-input"
                  name="newIsBooked"
                  id="changeIsBooked"
                  v-model="newIsBooked"
              >
              <label class="form-check-label" for="changeIsBooked">Booked</label>
            </div>

            <button type="submit" class="btn btn-md mt-5 mb-3">Update</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import Navbar from "../../components/admin/Navbar";
  export default {
    name: "editVisit",
    components: {Navbar},
    data() {
      return {
        visit: null,
        doctors: null,
        procedures: null,
        newDoctor: null,
        newProcedure: null,
        newTime: null,
        newDate: null,
        newIsActive: null,
        newIsBooked: null,
        formValid: null
      };
    },
    mounted() {
      const doctorsApi = fetch('/dentalclinic/api/doctors/getall').then(response => {
        return response.json();
      });
      const proceduresApi = fetch('/dentalclinic/api/procedures/getall').then(response => {
        return response.json();
      });
      const visitApi = fetch('/dentalclinic/api/visits/get/' + this.$route.params.visitId).then(response => {
        return response.json();
      });

      Promise.all([proceduresApi, doctorsApi, visitApi]).then(responses => {
        this.procedures = responses[0];
        this.doctors = responses[1];
        this.visit = responses[2];

        this.newDoctor = this.visit.doctor.id;
        this.newProcedure = this.visit.procedure.id;
        this.newTime = this.visit.time;
        this.newDate = this.visit.date;
        this.newIsActive = this.visit.isActive;
        this.newIsBooked = this.visit.isBooked;
      });
    },
    methods: {
      getTimeInterval(time) {
        let date = new Date();
        date.setHours(time.substr(0, time.indexOf(":")));

        const intervalBefore = date.getHours();
        date.setTime(date.getTime() + (60 * 60 * 1000));
        const intervalAfter = date.getHours();

        return intervalBefore + ":00 - " + intervalAfter + ":00";
      },
      putData() {
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

        fetch("/dentalclinic/api/visits/update/" + this.$route.params.visitId, {
          method: 'PUT',
          headers: {
            'Content-Type': 'application/json'
          },
          body:  JSON.stringify(newVisit)
        }).then(form => {
          this.formValid = true;
        }).catch(error => {
          console.error('Request failure: ', error);
        });
      },
      submit() {
        this.$validator.validateAll().then((field) => {
          if (field) {
            this.putData();
            return;
          }
          this.formValid = false;
        });
      }
    }
  }
</script>

<style lang="less" scoped>
  .btn {
    background-color: #B23900;
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