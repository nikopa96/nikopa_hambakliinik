<template>
  <div>
    <alert></alert>
    <div class="container">
      <navbar></navbar>
      <h1 class="title">Procedures and Prices</h1>
      <div class="row">
        <div class="col-12 col-md-8 mb-5 mb-md-0">
          <div class="accordion" role="tablist">
            <div
              class="card"
              v-for="procedure in procedures"
              v-bind:key="procedure.id"
            >
              <div class="card-header" role="tab">
                <button
                  class="btn btn-link"
                  type="button"
                  v-b-toggle="'accordion-' + procedure.id"
                >
                  {{ procedure.name }}
                </button>
              </div>
              <b-collapse
                :id="'accordion-' + procedure.id"
                visible
                accordion="my-accordion"
                role="tabpanel"
              >
                <div class="card-body">
                  <table class="table table-bordered">
                    <tbody>
                      <tr
                        v-for="price in procedure.additionalFields.prices"
                        v-bind:key="price"
                      >
                        <td>{{ price.name }}</td>
                        <td>{{ price.value }}</td>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </b-collapse>
            </div>
          </div>
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
import Navbar from "@/components/website/Navbar";
import Alert from "@/components/website/Alert";
import Footer from "@/components/website/Footer";
import Sidebar from "@/components/website/Sidebar";

export default {
  name: "procedures",
  components: {
    Footer,
    Alert,
    Navbar,
    Sidebar
  },
  data() {
    return {
      procedures: null
    };
  },
  mounted() {
    const proceduresApi = fetch("/dentalclinic/api/procedures/getall").then(
      response => {
        return response.json();
      }
    );

    Promise.all([proceduresApi]).then(responses => {
      this.procedures = responses[0];
    });
  }
};
</script>

<style lang="less" scoped>
@fat-font-weight: 500;

.title {
  text-transform: uppercase;
  font-size: 1.5em;
  font-weight: @fat-font-weight;
  letter-spacing: 2px;
  margin-top: 1.5em;
  margin-bottom: 1.5em;
  color: #575757;
}

.btn-link {
  color: rgba(0, 0, 0, 0.6);
  font-weight: @fat-font-weight;
  font-size: 1.15em;
}

.btn-link:hover {
  color: rgba(0, 0, 0, 0.8);
  text-decoration: none;
}

.btn-link:active,
.btn-link:focus,
.btn-link:focus-within {
  text-decoration: none;
}
</style>
