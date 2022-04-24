import { useEffect, useState } from 'react';
import { deleteCarById, getAllCar, postCar } from '../../Services/CarService';
import { Column } from 'primereact/column';
import { DataTable } from 'primereact/datatable';
import { Button } from 'primereact/button';
import { ConfirmDialog } from 'primereact/confirmdialog';
import CustomerInfo from '../Customer/CustomerInfo';

function Cars () {


  const [carList, setCarList] = useState([{}]);
  const [selectedCar,setSelectedCar] = useState({});
  const [visible,setVisible]=useState(false);

  const [car,setCar]=useState({
      "plate":'',
      "carClass":'',
      "fuelType":'',
      "gearType":'',
  });
  const [carInfo,setCarInfo]=useState({

      "brand":'',
      "model":'',
      "year":'',
      "kilometer":''
  });
  const [carLocation,setCarLocation]=useState({
      "latitude":'',
      "longitude":''
  });

  useEffect(() => {
    getAllCar().then(res => setCarList(res.data));
    console.log(carList)

  }, []);

  useEffect(() => {
    console.log(selectedCar)
  }, [selectedCar]);

  const onCarHandleChange = (e) => {
    setCar({...car , [e.target.name]:e.target.value});
  }

  const onCarInfoHandleChange = (e) => {
    setCarInfo({...carInfo,[e.target.name]:e.target.value});
  }

  const onCarLocationHandleChange = (e) => {
    setCarLocation({...carLocation,[e.target.name]:e.target.value});
  }


  const onFormSubmit = (e) => {

    const carPost={
      car,
      carInfo,
      carLocation
    };
    postCar(carPost).then(res => res.status === 200 ? getAllCar().then(res => setCarList(res.data)) : alert("Kayıt sırasında hata oluştu"));
    e.preventDefault();

  }

  function deleteCar(){
    deleteCarById(selectedCar.carId).then(res => res ? getAllCar().then(res => setCarList(res.data)) : alert("Hata Oluştu")).catch(err => alert(err));
  }

  const messageTemplate = <div>Bu Kaydı Silmek İstediğinize Emin Misiniz ?</div>

  const buttons = () => <div>

    <ConfirmDialog visible={visible} onHide={() => setVisible(false)}
                   message={messageTemplate}
                   header='Seçili Araba Bilgileri Silinecek Onaylıyor Musunuz?' icon='pi pi-exclamation-triangle'
                   accept={()=>deleteCar(selectedCar.id)} reject={() => console.log('heelo')} />

    <Button onClick={() => setVisible(!visible)} icon='pi pi-check' label='Sil'
            className={'p-button-sm p-button-danger m-2'} />

  </div>

  return(
    <div>
      <div>
        <div className="mt-10 sm:mt-0">
          <div className="md:grid md:grid-cols-3 md:gap-6">
            <div className="md:col-span-1">
              <div className="px-4 sm:px-0">
                <div className="mt-5 md:mt-0 md:col-span-2">
                  <form action="#" method="POST">
                    <div className="shadow overflow-hidden sm:rounded-md">
                      <div className="px-4 py-5 bg-white sm:p-6">
                        <h2 className={"text-xl pb-5"}>Car Info</h2>
                        <div className="grid grid-cols-6 gap-6">
                          <div className="col-span-6 sm:col-span-3">
                            <label htmlFor="plate" className="block text-sm font-medium text-gray-700">
                              Plate
                            </label>
                            <input
                              type="text"
                              name="plate"
                              id="plate"
                              className="mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md h-8"
                              onChange={onCarHandleChange}
                            />
                          </div>

                          <div className="col-span-6 sm:col-span-3">
                            <label htmlFor="fuelType" className="block text-sm font-medium text-gray-700">
                              Fuel Type
                            </label>
                            <select
                              id="fuelType"
                              name="fuelType"
                              className="mt-1 block w-full py-2 px-3 border border-gray-300 bg-white rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
                              onChange={onCarHandleChange}
                            >
                              <option>Oil</option>
                              <option>Electric</option>
                              <option>Diesel</option>
                            </select>
                          </div>


                          <div className="col-span-6 sm:col-span-3">
                            <label htmlFor="carClass" className="block text-sm font-medium text-gray-700">
                              Car Class
                            </label>
                            <select
                              id="carClass"
                              name="carClass"
                              className="mt-1 block w-full py-2 px-3 border border-gray-300 bg-white rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
                              onChange={onCarHandleChange}

                            >
                              <option>Sedan</option>
                              <option>Hatchback</option>
                              <option>VIP</option>
                              <option>SUV</option>
                              <option>Sport</option>
                            </select>
                          </div>


                          <div className="col-span-6 sm:col-span-3">
                            <label htmlFor="gearType" className="block text-sm font-medium text-gray-700">
                              Gear Type
                            </label>
                            <select
                              id="gearType"
                              name="gearType"
                              className="mt-1 block w-full py-2 px-3 border border-gray-300 bg-white rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
                              onChange={onCarHandleChange}

                            >
                              <option>Automatic</option>
                              <option>Manual</option>
                              <option>Semi-Auto</option>
                            </select>
                          </div>
                        </div>

                        <br/>
                        <hr/>
                        <br/>

                        <h2 className={"text-xl pb-5"}>Car Detail</h2>
                        <div className="grid grid-cols-6 gap-6">

                          <div className="col-span-6 sm:col-span-3">

                            <label htmlFor="brand" className="block text-sm font-medium text-gray-700">
                              Brand
                            </label>
                            <input
                              type="text"
                              name="brand"
                              id="brand"
                              className="mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md h-8"
                              onChange={onCarInfoHandleChange}

                            />
                          </div>

                          <div className="col-span-6 sm:col-span-3">
                            <label htmlFor="model" className="block text-sm font-medium text-gray-700">
                              Model
                            </label>
                            <input
                              type="text"
                              name="model"
                              id="model"
                              className="mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md h-8"
                              onChange={onCarInfoHandleChange}

                            />
                          </div>


                          <div className="col-span-6 sm:col-span-3">
                            <label htmlFor="year" className="block text-sm font-medium text-gray-700">
                              Year
                            </label>
                            <input
                              type="text"
                              name="year"
                              id="year"
                              className="mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md h-8"
                              onChange={onCarInfoHandleChange}

                            />
                          </div>


                          <div className="col-span-6 sm:col-span-3">
                            <label htmlFor="kilometer" className="block text-sm font-medium text-gray-700">
                              Kilometer
                            </label>
                            <input
                              type="text"
                              name="kilometer"
                              id="kilometer"
                              className="mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md h-8"
                              onChange={onCarInfoHandleChange}

                            />
                          </div>
                        </div>
                        <br/>
                          <hr/>
                            <br/>


                        <h2 className={"text-xl pb-5"}>Location</h2>
                        <div className="grid grid-cols-6 gap-6">

                          <div className="col-span-6 sm:col-span-3">
                            <label htmlFor="latitude" className="block text-sm font-medium text-gray-700">
                              Latitude
                            </label>
                            <input
                              type="text"
                              name="latitude"
                              id="latitude"
                              className="mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md h-8"
                              onChange={onCarLocationHandleChange}

                            />
                          </div>

                          <div className="col-span-6 sm:col-span-3">
                            <label htmlFor="longitude" className="block text-sm font-medium text-gray-700">
                              Longitude
                            </label>
                            <input
                              type="text"
                              name="longitude"
                              id="longitude"
                              className="mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md h-8"
                              onChange={onCarLocationHandleChange}

                            />
                          </div>


                        </div>



                      </div>
                      <div className="px-4 py-3 bg-gray-50 text-right sm:px-6">
                        <button
                          onClick={onFormSubmit}
                          className="inline-flex justify-center py-2 px-4 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500"
                        >
                          Save
                        </button>
                      </div>
                    </div>
                  </form>
                </div>
              </div>
            </div>
            <div className="mt-5 md:mt-0 md:col-span-2">
              <DataTable
                header={buttons}
                value={carList} responsiveLayout={'scroll'} selection={selectedCar}
                onSelectionChange={(e) => {setSelectedCar(e.value)}} selectionMode='single'>
                <Column field={'plate'} header={'Plaka'} />
                <Column field={'fuelType'} header={'Motor Türü'} />
                <Column field={'gearType'} header={'Klasman'} />
                <Column field={'brand'} header={'Marka'} />
                <Column field={'model'} header={'Model'} />
                <Column field={'year'} header={'Yıl'} />
                <Column field={'kilometer'} header={'Kilometre'} />
                <Column field={'latitude'} header={'Enlem'} />
                <Column field={'longitude'} header={'Boylam'} />
              </DataTable>
            </div>
          </div>
        </div>


      </div>
    </div>
  )
}

export default Cars;