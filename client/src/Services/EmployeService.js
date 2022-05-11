import axios from 'axios';


async function getAllEmployee() {
  return await axios.get('http://localhost:8080/api/v1/employee').then(res => res).then(d => d.data).catch(err => console.log(err));
}

async function deleteEmployeeById(id) {
  return await axios.delete('http://localhost:8080/api/v1/employee/' + id.toString()).then(res => res).catch(err => console.log(err));

}

async function postEmployee(customer) {
  return await axios.post('http://localhost:8080/api/v1/employee', customer).then(res => res).catch(err => console.log(err));
}



export { getAllEmployee, deleteEmployeeById, postEmployee };