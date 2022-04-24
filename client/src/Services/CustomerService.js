import axios from 'axios';


async function getAllCustomer() {
  return await axios.get('http://localhost:8080/api/v1/customer').then(res => res).then(d => d.data).catch(err => console.log(err));
}

async function deleteCustomerById(id) {
  return await axios.delete('http://localhost:8080/api/v1/customer/' + id.toString()).then(res => res).catch(err => console.log(err));

}

async function postCustomer(customer) {
  return await axios.post('http://localhost:8080/api/v1/customer', customer).then(res => res).catch(err => console.log(err));
}

export { getAllCustomer, deleteCustomerById, postCustomer };