import axios from 'axios';

async function getCustomerAdressByCustomerId(id) {
  return await axios.get('http://localhost:8080/api/v1/customeradress/customer/' + id).then(res => res).catch(err => console.log(err));
}

async function deleteCustomerAdresById(id) {
  return await axios.delete('http://localhost:8080/api/v1/customeradress/' + id).then(res => res).catch(err => console.log(err));
}

async function postCustomerAdress(adress) {
  return await axios.post('http://localhost:8080/api/v1/customeradress', adress).then(res => res).catch(err => console.log(err));
}

export { getCustomerAdressByCustomerId, deleteCustomerAdresById, postCustomerAdress };