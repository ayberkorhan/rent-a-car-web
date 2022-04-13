import { Tabs, TabList, TabPanels, Tab, TabPanel } from '@chakra-ui/react'
import React from 'react';
import CustomersTable from './CustomersTable';


function AdminPanelTabs(){



  return <div>
    <Tabs>
      <TabList>
        <Tab>MÜŞTERİLER</Tab>
        <Tab>ÇALIŞANLAR</Tab>
        <Tab>ARABALAR</Tab>
        <Tab>SİPARİŞLER</Tab>
      </TabList>

      <TabPanels>
        <TabPanel>
          <div className={"flex flex-auto"}>
            <div className={"w-1/5 bg-black h-full"}>
            </div>
            <div className={"w-full"} >
              <CustomersTable></CustomersTable>
            </div>

          </div>

        </TabPanel>
        <TabPanel>
          <p>ÇALIŞANLAR!</p>
        </TabPanel>
        <TabPanel>
          <p>ARABALAR!</p>
        </TabPanel>
        <TabPanel>
          <p>SİPARİŞLER</p>
        </TabPanel>
      </TabPanels>
    </Tabs>
  </div>
}

export default AdminPanelTabs;