import axios from 'axios';

async function getAllCustomerLogin() {
  return await axios.get('http://localhost:8080/api/v1/customerlogin/').catch(err => console.log(err));
}

async function getCustomerLoginWithLoginId(id) {
  return await axios.get('http://localhost:8080/api/v1/customerlogin/' + id).then(res => res).catch(err => console.log(err));
}

async function postCustomerLogin(login) {
  return await axios.post('http://localhost:8080/api/v1/customerlogin', login).then(res => res).catch(err => console.log(err));
}

export { getAllCustomerLogin, getCustomerLoginWithLoginId, postCustomerLogin };