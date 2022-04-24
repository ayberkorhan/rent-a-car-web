import {
  Drawer,
  DrawerBody,
  DrawerFooter,
  DrawerHeader,
  DrawerOverlay,
  DrawerContent,
  DrawerCloseButton, useDisclosure, Input,
} from '@chakra-ui/react';
import React, { useEffect, useState } from 'react';
import { Button } from 'primereact/button';



function CustomerInfo({customer,customerLogin,customerAdress}) {
  const { isOpen, onOpen, onClose } = useDisclosure()
  const btnRef = React.useRef()


  const loginInfo = <div>
    {customer.firstName !== undefined && customer.firstName !== null ?
      <section>
        <hr/>
        <br/>
        <p className={"font-bold text-l"}>Adı:{customer.firstName}</p>
        <p className={"font-bold text-l"}>Soyadı: {customer.lastName}</p>
        <p className={"font-bold text-l"}>Kimlik Numarası: {customer.identityNumber}</p>
        <p className={"font-bold text-l"}>Email: {customerLogin.email}</p>
        <br/>
        <hr/>
        <br/>
        {customerAdress.map((adress,i)=> {
          return (
            <div key={i}>
              <h2 className={"text-xl font-bold"}>Adres Bilgileri</h2>
              <p className={"font-bold text-l"}>Ülke: {adress.country}</p>
              <p className={"font-bold text-l"}>İl: {adress.city}</p>
              <p className={"font-bold text-l"}>İlçe: {adress.town}</p>
              <p className={"font-bold text-l"}>Cadde: {adress.street}</p>
              <p className={"font-bold text-l"}>Bina Adı: {adress.buildingInfo}</p>
              <p className={"font-bold text-l"}>Kapı Numarası: {adress.doorNumber}</p>
              <p className={"font-bold text-l"}>Posta Kodu: {adress.zipCode}</p>
            </div>
          )
        })}
      </section>
      :
      <p>Not Found</p>
    }

  </div>
  return (
    <>
      <Button ref={btnRef} colorScheme='teal' onClick={onOpen} className={"m-2 p-button-sm"}>
        Detaylar
      </Button>
      <Drawer
        isOpen={isOpen}
        placement='left'
        onClose={onClose}
        finalFocusRef={btnRef}
      >
        <DrawerOverlay />
        <DrawerContent>
          <DrawerCloseButton />
          <DrawerHeader><p className={"font-bold text-2xl"}>Müşteri Detayları</p></DrawerHeader>
          <DrawerBody>
            {loginInfo}

          </DrawerBody>
          <DrawerFooter>
            Footer
          </DrawerFooter>
        </DrawerContent>
      </Drawer>
    </>
  )
}

export default CustomerInfo;