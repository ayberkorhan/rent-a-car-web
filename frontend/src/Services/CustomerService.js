import axios from "axios";

export class CustomerService{

    getAllCustomers(){
        return axios.get("http://localhost:8080/api/v1/customer");
    }
}