import axios from 'axios';


function getAllCustomer() {
  return axios.get('http://localhost:8080/api/v1/customer');
}

function deleteCustomerById(id){
  return axios.delete("http://localhost:8080/api/v1/customer/"+id.toString());

}


export  {getAllCustomer,deleteCustomerById};