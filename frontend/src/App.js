import logo from './logo.svg';
import './App.css';
import {useState} from "react";
import axios from "axios";




function App() {

  const login = {"email":"enes","login_password":"123"};
  const getCustomer = () => {
    axios.get("http://localhost:8080/api/v1/customerlogin/55",{login}).then((res)=> console.log(res.status));
  }
  return (
    <div className="App" onClick={getCustomer}>
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;
