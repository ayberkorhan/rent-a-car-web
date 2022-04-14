import axios from 'axios';

async function getCustomerAdressByCustomerId(id){
  const res = await axios.get("http://localhost:8080/api/v1/customeradress/customer/"+id)
  return res.data;

}

async function deleteCustomerAdresById(id){
  const res = await axios.get("http://localhost:8080/api/v1/customeradress/customer/"+id);
  return res.data;
}


export  {getCustomerAdressByCustomerId,deleteCustomerAdresById};