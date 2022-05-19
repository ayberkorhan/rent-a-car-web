import React, { useState } from 'react';
import { login } from '../Services/CustomerLoginService';
import { Navigate, useNavigate } from 'react-router-dom';
import { employeeLogin } from '../Services/EmployeService';
import { Checkbox } from '@chakra-ui/react';


function Login(props) {

  const {user,setUser} = props;
  const [loginInfo, setLoginInfo] = useState({});
  const [userLogin,setUserLogin] = useState(false);
  const [adminLogin,setAdminLogin] = useState(false);
  const navigate = useNavigate();

  const onChange = (e) => {
    setLoginInfo({ ...loginInfo, [e.target.name]: e.target.value });
  };


  const loginUser = () => {
    login(loginInfo).then(res => setUserLogin(res.data))
    employeeLogin(loginInfo).then(res => setAdminLogin(res.data)).finally(()=> yetki());
  }

  const yetki = () => {
    if(!userLogin && !adminLogin ) {
      alert("Kullanıcı Adı Veya Şifre Yanlış")
    }
    else if(userLogin && adminLogin) {
      alert("Kullanıcı Adı Veya Şifre Yanlış")
    }
    else if (userLogin){
      setUser("user")
      alert("Giriş Başarılı")
      navigate("/order")
    }
    else if(adminLogin){
      setUser("admin")
      alert("Giriş Başarılı")
      navigate("/adminpanel")
    }
  }



  const onSubmit = (e) => {
    loginUser();
   e.preventDefault()
  };


  return (
    <div>
      <div className='min-h-full flex items-center justify-center py-12 px-4 sm:px-6 lg:px-8'>
        <div className='max-w-md w-full space-y-8'>
          <div>
            <img
              className='mx-auto h-12 w-auto'
              src='https://tailwindui.com/img/logos/workflow-mark-indigo-600.svg'
              alt='Workflow'
            />
            <h2 className='mt-6 text-center text-3xl font-extrabold text-gray-900'>Sign in to your account</h2>
            <p className='mt-2 text-center text-sm text-gray-600'>
              <a href='#' className='font-medium text-indigo-600 hover:text-indigo-500'>

              </a>
            </p>
          </div>
          <form className='mt-8 space-y-6' action='#' method='POST'>
            <input type='hidden' name='remember' defaultValue='true' />
            <div className='rounded-md shadow-sm -space-y-px'>
              <div>
                <label htmlFor='login-email' className='sr-only'>
                  Email address
                </label>
                <input
                  id='login-email'
                  name='email'
                  type='email'
                  autoComplete='email'
                  required
                  className='appearance-none rounded-none relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 rounded-t-md focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 focus:z-10 sm:text-sm'
                  placeholder='Email address'
                  onChange={onChange}
                />
              </div>
              <div>
                <label htmlFor='login_password' className='sr-only'>
                  Password
                </label>
                <input
                  id='login_password'
                  name='password'
                  type='password'
                  autoComplete='current-password'
                  required
                  className='appearance-none mt-3 rounded-none relative block w-full px-3 py-2 border border-gray-300 placeholder-gray-500 text-gray-900 rounded-b-md focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 focus:z-10 sm:text-sm'
                  placeholder='Password'
                  onChange={onChange}
                />
              </div>


            </div>

            <div>
            </div>

            <div>
              <button
                type='submit'
                onClick={onSubmit}
                className='group relative mt-3 w-full flex justify-center py-2 px-4 border border-transparent text-sm font-medium rounded-md text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500'
              >
                <span className='absolute left-0 inset-y-0 flex items-center pl-3'>

                </span>
                Giriş Yap
              </button>

              <button
                type='submit'
                className='group relative mt-3 w-full flex justify-center py-2 px-4 border border-transparent text-sm font-medium rounded-md text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500'
              >
                <span className='absolute left-0 inset-y-0 flex items-center pl-3'>

                </span>
                Kayıt Ol
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>


  );
}

export default Login;