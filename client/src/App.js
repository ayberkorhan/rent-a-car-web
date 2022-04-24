import React from 'react';
import {
  BrowserRouter,
  Routes,
  Route,
} from "react-router-dom";
import Login from './Pages/Login';
import AdminPanel from './Pages/AdminPanel';
import "primereact/resources/themes/lara-light-indigo/theme.css";  //theme
import "primereact/resources/primereact.min.css";                  //core css
import "primeicons/primeicons.css";                                //icons



const App = () => {

  return (
    <BrowserRouter>
      <Routes>
        <Route path={'/login'} element={<Login/>}/>
        <Route path={'/adminpanel'} element={<AdminPanel />}/>
      </Routes>
    </BrowserRouter>


  );
};

export default App
