import axios from 'axios';


const BASE_URI="http://localhost:8080/api/v1/car";
async function postCar(car){

  return await axios.post(BASE_URI,car).then(res=>res).catch(err => console.log(err));

}

async function getAllCar(car){
  return await axios.get(BASE_URI).then(res=>res).catch(err => console.log(err));
}

async function deleteCarById(id){
  return await axios.delete(BASE_URI+"/"+id).then(res=>res).catch(err => console.log(err));
}



export {postCar,getAllCar,deleteCarById};