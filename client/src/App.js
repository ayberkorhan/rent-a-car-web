import React, { useState } from 'react';
import {
  BrowserRouter,
  Routes,
  Route,
} from "react-router-dom";
import Login from './Pages/Login';
import AdminPanel from './Pages/AdminPanel';
import "primereact/resources/themes/lara-light-indigo/theme.css";  //theme
import "primereact/resources/primereact.min.css";                  //core css
import "primeicons/primeicons.css";
import ProtectedAdminRoute from './Components/ProtectedAdminRoute';
import Contact from './Pages/Contact';
import About from './Pages/About';
import Welcome from './Pages/Welcome';
import Register from './Pages/Register';
import ProtectedUserRoute from './Components/ProtectedUserRoute';
import Cars from './Components/Cars/Cars';
import Order from './Pages/Order'; //icons



const App = () => {

  const [user,setUser]=useState(null);

  return (
    <>
        <BrowserRouter>
          <Routes>
            <Route path={'/login'} element={<Login user={user} setUser={setUser}/>}/>
            <Route path={'/contact'} element={<Contact/>}/>
            <Route path={'/about'} element={<About/>}/>
            <Route path={'/register'} element={<Register/>}/>
            <Route path={'/adminpanel'}
                   element={<ProtectedAdminRoute user={user}>
                              <AdminPanel user={user}/>
            </ProtectedAdminRoute>}/>
            <Route path={'/order'}
                   element={<ProtectedUserRoute user={user}>
                     <Order user={user}/>
                   </ProtectedUserRoute>}/>

            <Route path={'/'} element={<Welcome/>}/>
          </Routes>
        </BrowserRouter>


    </>



  );
};

export default App
