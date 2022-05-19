import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';
import { useEffect, useState } from 'react';
import { deleteEmployeeById, getAllEmployee, postEmployee } from '../../Services/EmployeService';
import { ConfirmDialog } from 'primereact/confirmdialog';
import { Button } from 'primereact/button';
import { getAllCar } from '../../Services/CarService';

function Employee() {

  const [visible,setVisible]=useState(false);
  const [isLoading,setIsLoading] = useState(true);
  const [employee,setEmployee] = useState({
    "firstName":"",
    "lastName":"",
    "identityNumber":"",
    "adress":"",
    "role":"Developer",

  });
  const [employeeLogin,setEmployeeLogin] = useState({
    "email":"",
    "password":"",
  });
  const [selectedEmployee,setSelectedEmployee]=useState({});
  const [employeeList,setEmployeeList] = useState([{}]);


  useEffect(()=> {
    getAllEmployee().then(res => setEmployeeList(res));
  },[])

  const employeeInputOnChange = (e) => {
    setEmployee({
      ...employee, [e.target.name]: e.target.value,
    });
  };

  const employeeLoginInputOnChange = (e) => {
    setEmployeeLogin({
      ...employeeLogin, [e.target.name]: e.target.value,
    });
  };

  const onFormSubmit = (e) => {
    let emp =  {
      "firstName":employee.firstName,
      "lastName":employee.lastName,
      "identityNumber":employee.identityNumber,
      "adress":employee.adress,
      "role":employee.role,
      employeeLogin

    }
    e.preventDefault();
    postEmployee(emp).then(res => res.status === 200 ? getAllEmployee().then(res => setEmployeeList(res)) : alert("Bir Hata Meydana Geldi"))
  }

  const messageTemplate = <div>Bu Kaydı Silmek İstediğinize Emin Misiniz ?</div>

  const buttons = () => <div>

    <ConfirmDialog visible={visible} onHide={() => setVisible(false)}
                   message={messageTemplate}
                   header='Seçili Araba Bilgileri Silinecek Onaylıyor Musunuz?' icon='pi pi-exclamation-triangle'
                   accept={()=>deleteEmployeeById(selectedEmployee.employeeId).then(()=> getAllEmployee().then(res => setEmployeeList(res)))}
                   />

    <Button onClick={() => setVisible(!visible)} icon='pi pi-check' label='Sil'
            className={'p-button-sm p-button-danger m-2'} />

  </div>

  return (
    <>
      <div>
        <div className='mt-10 sm:mt-0'>
          <div className='md:grid md:grid-cols-3 md:gap-6'>
            <div className='md:col-span-1'>
              <div className='px-4 sm:px-0'>
                <div className='mt-5 md:mt-0 md:col-span-2'>
                  <form action='#' method='POST'>
                    <div className='shadow overflow-hidden sm:rounded-md'>
                      <div className='px-4 py-5 bg-white sm:p-6'>
                        <div className='grid grid-cols-6 gap-6'>


                          <div className='col-span-6 sm:col-span-3'>
                            <label htmlFor='email' className='block text-sm font-medium text-gray-700'>
                              Email
                            </label>
                            <input
                              type='text'
                              name='email'
                              id='email'
                              autoComplete='given-name'
                              className='mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md h-10 bg-blue-50'
                              onChange={employeeLoginInputOnChange}
                            />
                          </div>

                          <div className='col-span-6 sm:col-span-3'>
                            <label htmlFor='password' className='block text-sm font-medium text-gray-700'>
                              Password
                            </label>
                            <input
                              type='password'
                              name='password'
                              id='password'
                              autoComplete='family-name'
                              className='mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md h-10 bg-blue-50'
                              onChange={employeeLoginInputOnChange}
                            />
                          </div>

                          <div className='col-span-6 sm:col-span-3'>
                            <label htmlFor='firstName' className='block text-sm font-medium text-gray-700'>
                              First name
                            </label>
                            <input
                              type='text'
                              name='firstName'
                              id='firstName'
                              autoComplete='given-name'
                              className='mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md h-10 bg-blue-50'
                              onChange={employeeInputOnChange}
                            />
                          </div>

                          <div className='col-span-6 sm:col-span-3'>
                            <label htmlFor='lastName' className='block text-sm font-medium text-gray-700'>
                              Last name
                            </label>
                            <input
                              type='text'
                              name='lastName'
                              id='lastName'
                              autoComplete='family-name'
                              className='mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md h-10 bg-blue-50'
                              onChange={employeeInputOnChange}
                            />
                          </div>


                          <div className='col-span-6 sm:col-span-6 lg:col-span-3'>
                            <label htmlFor='adress' className='block text-sm font-medium text-gray-700'>
                              Adress
                            </label>
                            <input
                              type='text'
                              name='adress'
                              id='adress'
                              className='mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md h-10 bg-blue-50'
                              onChange={employeeInputOnChange}
                            />
                          </div>


                          <div className='col-span-6 sm:col-span-4 lg:col-span-3'>
                            <label htmlFor='identityNumber' className='block text-sm font-medium text-gray-700'>
                              Identity Number
                            </label>
                            <input
                              type='number'
                              name='identityNumber'
                              id='identityNumber'
                              maxLength='11'
                              className='mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md h-10 bg-blue-50'
                              onChange={employeeInputOnChange}

                            />
                          </div>
                        </div>

                        <div className='col-span-6 sm:col-span-3 lg:col-span-3 mt-4'>
                          <label htmlFor='role' className='block text-sm font-medium text-gray-700'>
                            Role
                          </label>
                          <select
                            id='role'
                            name='role'
                            className='mt-1 block w-full py-2 px-3 border border-gray-300 bg-white rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm'
                            onChange={employeeInputOnChange}
                          >
                            <option>Developer</option>
                            <option>Lead</option>
                            <option>Business Analist</option>
                          </select>
                        </div>
                      </div>
                      <div className='px-4 py-3 bg-gray-50 text-right sm:px-6'>
                        <button
                          onClick={onFormSubmit}
                          className='inline-flex justify-center py-2 px-4 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500 '
                        >
                          Save
                        </button>
                      </div>
                    </div>
                  </form>
                </div>
              </div>
            </div>
            <div className='mt-5 md:mt-0 md:col-span-2'>
              {isLoading ?
              <DataTable
                header={buttons}
                value={employeeList} responsiveLayout={'scroll'} selection={selectedEmployee}
                onSelectionChange={(e) => {setSelectedEmployee(e.value);}} selectionMode='single'
                paginator rows={10} rowsPerPageOptions={[5, 10, 25]}>
                <Column field={'firstName'} header={'Adı'} sortable/>
                <Column field={'lastName'} header={'Soyadı'} sortable/>
                <Column field={'identityNumber'} header={'Kimlik Numarası'} sortable/>
                <Column field={'adress'} header={'Adres'} sortable/>
                <Column field={'role'} header={'Role'} sortable/>
                <Column field={'email'} header={'Email'} sortable/>
              </DataTable> : <p>Yükleniyor..</p> }

            </div>
          </div>
        </div>


      </div>
    </>
  );
}

export default Employee;