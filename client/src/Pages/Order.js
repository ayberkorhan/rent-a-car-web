import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';
import { useEffect, useState } from 'react';
import { getAllCar } from '../Services/CarService';
import { Button } from 'primereact/button';

function Order () {

  const [carList,setCarlist] = useState([{}]);
  const [selectedCar,setSelectedCar] = useState({});


  useEffect(() => {
    getAllCar().then(res => setCarlist(res.data));
  }, []);



  const header = <div className={"flex flex-auto "}>

    <div className={"flex items-center justify-content-center mr-2 ml-2"}>
      <p>Başlangıç Tarihi:</p>
      <input id="baslangic" type={"date"} className={"ml-3 w-32  text-black"} placeholder={"Baslangiç Tarihi"}/>
    </div>
    <div className={"flex items-center justify-content-center mr-2 ml-2"}>
      <p>Bitiş Tarihi:</p>
      <input id="baslangic" type={"date"} className={"ml-3 w-32  text-black"} placeholder={"Baslangiç Tarihi"}/>
    </div>
    <Button label="Satın al" className="p-button-success" />
  </div>

  return(

        <div className="mt-10 sm:mt-0 w-full h-full">
          <div className="md:grid md:grid-cols-1 md:gap-6">
            <div className="md:col-span-1">
              <div className="px-4 sm:px-0">
            <div className="mt-5 md:mt-0 md:col-span-2">
              <DataTable
                header={header}
                value={carList} responsiveLayout={'scroll'} selection={selectedCar}
                onSelectionChange={(e) => {setSelectedCar(e.value)}} selectionMode='single'
                paginator rows={5} rowsPerPageOptions={[5, 10, 25]}
              >
                <Column field={'plate'} header={'Plaka'} sortable />
                <Column field={'fuelType'} header={'Motor Türü'} sortable />
                <Column field={'gearType'} header={'Klasman'} sortable />
                <Column field={'brand'} header={'Marka'} sortable/>
                <Column field={'model'} header={'Model'} sortable/>
                <Column field={'year'} header={'Yıl'} sortable/>
                <Column field={'kilometer'} header={'Kilometre'} sortable />
                <Column field={'latitude'} header={'Enlem'} sortable/>
                <Column field={'longitude'} header={'Boylam'} sortable/>
              </DataTable>
            </div>
          </div>
        </div>
          </div>
        </div>
  )
}

export default Order;