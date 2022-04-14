import { Tabs, TabList, TabPanels, Tab, TabPanel } from '@chakra-ui/react'
import React, { useEffect, useState } from 'react';
import MainMenu from '../Components/MainMenu';
import Customers from '../Components/Customer/Customers';
import Cars from '../Components/Cars/Cars';
import Employee from '../Components/Employee/Employee';
import Order from '../Components/Orders/Order';


function AdminPanel () {


  return(
    <div className={"flex flex-col min-h-full min-w-full justify-center content-center"}>
      <MainMenu/>
      <div className={"mt-3 text-xl font-bold"}>
        <h3 className={"text-2xl font-bold"}>Yönetim Paneli</h3>
        <Tabs isFitted variant='enclosed'>
          <TabList mb='1em'>
            <Tab>CUSTOMERS</Tab>
            <Tab>EMPLOYEES</Tab>
            <Tab>CARS</Tab>
            <Tab>ORDERS</Tab>
          </TabList>
          <TabPanels>
            <TabPanel>
              <Customers/>
            </TabPanel>
            <TabPanel>
              <Employee/>
            </TabPanel>
            <TabPanel>
              <Cars/>
            </TabPanel>
            <TabPanel>
             <Order/>
            </TabPanel>
          </TabPanels>
        </Tabs>
      </div>

    </div>
  )
}

export default AdminPanel;