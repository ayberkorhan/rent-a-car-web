import axios from 'axios';

function getAllCustomerLogin(){
  return axios.get("http://localhost:8080/api/v1/customerlogin/")
}

function getCustomerLoginWithLoginId(id){
  return axios.get("http://localhost:8080/api/v1/customerlogin/"+id.toString())
}

export {getAllCustomerLogin,getCustomerLoginWithLoginId};