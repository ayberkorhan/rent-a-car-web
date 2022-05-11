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
import ProtectedRoute from './Components/ProtectedRoute'; //icons



const App = () => {

  const [user,setUser]=useState(null);

  return (
    <>
        <BrowserRouter>
          <Routes>
            <Route path={'/login'} element={<Login user={user} setUser={setUser}/>}/>
            <Route path={'/adminpanel'}
                   element={<ProtectedRoute user={user}>
                              <AdminPanel user={user}/>
            </ProtectedRoute>}/>
          </Routes>
        </BrowserRouter>


    </>



  );
};

export default App
