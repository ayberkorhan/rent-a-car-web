import { useEffect, useRef, useState } from 'react';
import { deleteCustomerById, getAllCustomer, postCustomer } from '../../Services/CustomerService';
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';
import { Button } from 'primereact/button';
import { confirmDialog, ConfirmDialog } from 'primereact/confirmdialog';
import {
  deleteCustomerAdresById,
  getCustomerAdressByCustomerId,
  postCustomerAdress,
} from '../../Services/CustomerAdressService';
import { getCustomerLoginWithLoginId, postCustomerLogin } from '../../Services/CustomerLoginService';
import CustomerInfo from './CustomerInfo';
import { Toast } from 'primereact/toast';

export default function Customers() {

  const [customers, setCustomers] = useState([{}]);
  const [deleteButtonvisible, setDeleteButtonvisible] = useState(false);
  const [selectedCustomer, setSelectedCustomer] = useState({});
  const [customerAdress, setCustomerAdress] = useState([{}]);
  const [customerLogin, setCustomerLogin] = useState({});
  const [customerPost, setCustomerPost] = useState({
    email: '',
    password: '',
    firstName: '',
    lastName: '',
    identityNumber: '',
    country: '',
    city: '',
    town: '',
    street: '',
    buildingInfo: '',
    doorNumber: '',
    zipCode: '',
  });
  const [isLoaded, setIsLoaded] = useState(false);
  const toast = useRef();


  useEffect(() => {
    getAllCustomer()
      .then(res => setCustomers(res))
      .then(setIsLoaded(true));
  }, []);

  useEffect(() => {
    getDetail();
  }, [selectedCustomer]);

  function getDetail() {
    if (selectedCustomer !== null) {
      getCustomerAdressByCustomerId(selectedCustomer.customerId).then(res => setCustomerAdress(res.data));
      getCustomerLoginWithLoginId(selectedCustomer.loginId).then(res => setCustomerLogin(res.data));
    }
  }


  const deleteCustomerAdres = () => {
    deleteCustomerById(selectedCustomer.customerId).then(() => getAllCustomer().then(res => setCustomers(res)));
  };

  const inputOnChange = (e) => {
    setCustomerPost({
      ...customerPost, [e.target.name]: e.target.value,
    });
  };

  const onSubmit = (e) => {
    const login = { email: customerPost.email, password: customerPost.password };
    let customer = {
      firstName: customerPost.firstName,
      lastName: customerPost.lastName,
      identityNumber: customerPost.identityNumber,
      customerLogin: {
        loginId: null,
      },
    };
    let adress = {
      country: customerPost.country,
      city: customerPost.city,
      town: customerPost.town,
      street: customerPost.street,
      buildingInfo: customerPost.buildingInfo,
      doorNumber: customerPost.buildingInfo,
      zipCode: customerPost.zipCode,
      customer: {
        customerId: null,
      },
    };


    if(customerPost.email.length>5 && customerPost.password>6 && customerPost.identityNumber.length === 11) {
      postCustomerLogin(login)
        .then(res => {
          customer.customerLogin.loginId = res.data.loginId;
          postCustomer(customer)
            .then(res => {
              adress.customer.customerId = res.data.customerId;
              postCustomerAdress(adress).then(response => {
                response.status === 200 ? alert('Kayıt Başarılı') : alert('Hata!');
              });
            });
        })
    }
    else {
      alert("Lütfen Alanları Doldurunuz")
    }
    // This chain is post customerLogin , customer , customerAdres



    e.preventDefault();
  };

  const messsageTemplate =
    <div>
      <h1 className={'text-2xl font-bold'}>Silinecek Kullanıcı Bilgileri</h1>
      <hr />
      <section>
        {selectedCustomer ? <div>
          <p>Adı:{selectedCustomer.firstName}</p>
          <p>Soyadı:{selectedCustomer.lastName}</p>
          <p>Kimlik Numarası:{selectedCustomer.identityNumber}</p>
        </div> : false}

      </section>
    </div>;


  const buttons = () => <div>

    <ConfirmDialog visible={deleteButtonvisible} onHide={() => setDeleteButtonvisible(false)}
                   message={messsageTemplate}
                   header='Kullanıcı Silinecek Onaylıyor Musunuz?' icon='pi pi-exclamation-triangle'
                   accept={deleteCustomerAdres} reject={() => console.log('heelo')} />

    <Button onClick={() => setDeleteButtonvisible(!deleteButtonvisible)} icon='pi pi-check' label='Sil'
            className={'p-button-sm p-button-danger m-2'} />
    <CustomerInfo customer={selectedCustomer} customerAdress={customerAdress} customerLogin={customerLogin} />
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
                            <label htmlFor='first-name' className='block text-sm font-medium text-gray-700'>
                              Email
                            </label>
                            <input
                              type='text'
                              name='email'
                              id='email'
                              autoComplete='given-name'
                              className='mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md h-10 bg-blue-50'
                              onChange={(e) => inputOnChange(e)}

                            />
                          </div>

                          <div className='col-span-6 sm:col-span-3'>
                            <label htmlFor='last-name' className='block text-sm font-medium text-gray-700'>
                              Password
                            </label>
                            <input
                              type='password'
                              name='password'
                              id='password'
                              autoComplete='family-name'
                              className='mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md h-10 bg-blue-50'
                              onChange={(e) => inputOnChange(e)}


                            />
                          </div>

                          <div className='col-span-6 sm:col-span-3'>
                            <label htmlFor='first-name' className='block text-sm font-medium text-gray-700'>
                              First name
                            </label>
                            <input
                              type='text'
                              name='firstName'
                              id='firstName'
                              autoComplete='given-name'
                              className='mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md h-10 bg-blue-50'
                              onChange={(e) => inputOnChange(e)}

                            />
                          </div>

                          <div className='col-span-6 sm:col-span-3'>
                            <label htmlFor='last-name' className='block text-sm font-medium text-gray-700'>
                              Last name
                            </label>
                            <input
                              type='text'
                              name='lastName'
                              id='lastName'
                              autoComplete='family-name'
                              className='mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md h-10 bg-blue-50'
                              onChange={(e) => inputOnChange(e)}
                            />
                          </div>

                          <div className='col-span-6 sm:col-span-4'>
                            <label htmlFor='email-address' className='block text-sm font-medium text-gray-700'>
                              Identity Number
                            </label>
                            <input
                              type='number'
                              name='identityNumber'
                              id='identityNumber'
                              maxLength='11'
                              className='mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md h-10 bg-blue-50'
                              onChange={(e) => inputOnChange(e)}
                            />
                          </div>

                          <div className='col-span-6 sm:col-span-3'>
                            <label htmlFor='country' className='block text-sm font-medium text-gray-700'>
                              Country
                            </label>
                            <select
                              id='country'
                              name='country'
                              autoComplete='country-name'
                              className='mt-1 block w-full py-2 px-3 border border-gray-300 bg-white rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm h-10 bg-blue-50'
                              onChange={(e) => inputOnChange(e)}
                            >
                              <option>US</option>
                              <option>Canada</option>
                              <option>Turkey</option>
                            </select>
                          </div>
                          <div className='col-span-6 sm:col-span-6 lg:col-span-2'>
                            <label htmlFor='city' className='block text-sm font-medium text-gray-700'>
                              City
                            </label>
                            <input
                              type='text'
                              name='city'
                              id='city'
                              autoComplete='address-level2'
                              onChange={(e) => inputOnChange(e)}
                              className='mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md h-10 bg-blue-50'
                            />
                          </div>

                          <div className='col-span-6'>
                            <label htmlFor='street-address' className='block text-sm font-medium text-gray-700'>
                              Town
                            </label>
                            <input
                              type='text'
                              name='town'
                              id='town'
                              autoComplete='street-address'
                              onChange={(e) => inputOnChange(e)}
                              className='mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md h-10 bg-blue-50'
                            />
                          </div>
                          <div className='col-span-6'>
                            <label htmlFor='street-address' className='block text-sm font-medium text-gray-700'>
                              Street
                            </label>
                            <input
                              type='text'
                              name='street'
                              id='street'
                              autoComplete='street-address'
                              onChange={(e) => inputOnChange(e)}
                              className='mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md h-10 bg-blue-50'
                            />
                          </div>


                          <div className='col-span-6 sm:col-span-3 lg:col-span-2'>
                            <label htmlFor='region' className='block text-sm font-medium text-gray-700'>
                              Building Info
                            </label>
                            <input
                              type='text'
                              name='buildingInfo'
                              id='buildingInfo'
                              autoComplete='address-level1'
                              onChange={(e) => inputOnChange(e)}
                              className='mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md h-10 bg-blue-50'
                            />
                          </div>
                          <div className='col-span-6 sm:col-span-3 lg:col-span-2'>
                            <label htmlFor='region' className='block text-sm font-medium text-gray-700'>
                              Door Number
                            </label>
                            <input
                              type='text'
                              name='doorNumber'
                              id='doorNumber'
                              onChange={(e) => inputOnChange(e)}
                              autoComplete='address-level1'
                              className='mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md h-10 bg-blue-50'
                            />
                          </div>

                          <div className='col-span-6 sm:col-span-3 lg:col-span-2'>
                            <label htmlFor='postal-code' className='block text-sm font-medium text-gray-700'>
                              ZIP / Postal code
                            </label>
                            <input
                              type='text'
                              name='zipCode'
                              id='zipCode'
                              autoComplete='postal-code'
                              onChange={(e) => inputOnChange(e)}
                              className='mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md h-10 bg-blue-50'
                            />
                          </div>
                        </div>
                      </div>
                      <div className='px-4 py-3 bg-gray-50 text-right sm:px-6'>
                        <button
                          onClick={onSubmit}
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
              <DataTable
                header={buttons}
                value={customers} responsiveLayout={'scroll'} selection={selectedCustomer}
                onSelectionChange={(e) => {setSelectedCustomer(e.value);getDetail() }} selectionMode='single'>
                <Column field={'firstName'} header={'Adı'} />
                <Column field={'lastName'} header={'Soyadı'} />
                <Column field={'identityNumber'} header={'Kimlik Numarası'} />
              </DataTable>
            </div>
          </div>
        </div>


      </div>
    </>
  );
}
