import {
  Popover,
  PopoverTrigger,
  PopoverContent,
  PopoverHeader,
  PopoverBody,
  PopoverArrow,
  PopoverCloseButton, Button,
} from '@chakra-ui/react';

function EmployeDetail({customer,customerAdress,customerLogin}){
  console.log(customerAdress);

  return(
    <div>
      <Popover>
        <PopoverTrigger>
          <Button className={"m-2"} colorScheme={"blue" } size={"sm"}>Detaylar</Button>
        </PopoverTrigger>
        <PopoverContent>
          <PopoverArrow />
          <PopoverCloseButton />
          <PopoverHeader>Customer Detail!</PopoverHeader>
          <PopoverBody>
            <div className={"flex flex-col"}>
              <h1 className={"font-bold text-2xl"}>
                Kişisel Bilgiler
              </h1>
              <hr/>
              <p>Adı:{customer.firstName}</p>
              <p>Soyadı:{customer.lastName}</p>
              <p>Kimlik Numarası:{customer.identityNumber}</p>
            </div>
            <div className={"flex flex-col"}>
              <h1 className={"font-bold text-2xl"}>
                Adres Bilgileri
              </h1>
              <hr/>
            </div>
            <div className={"flex flex-col"}>
              <h1 className={"font-bold text-2xl"}>
               GİRİŞ BİLGİLERİ
              </h1>
              <hr/>
              <p>KULLANICI ADI:</p>
              <p>ŞİFRE:</p>
            </div>

          </PopoverBody>
        </PopoverContent>
      </Popover>
    </div>
  )
}

export default EmployeDetail;