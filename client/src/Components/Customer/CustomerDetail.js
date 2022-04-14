import {
  Popover,
  PopoverTrigger,
  PopoverContent,
  PopoverHeader,
  PopoverBody,
  PopoverArrow,
  PopoverCloseButton, Button,
} from '@chakra-ui/react';
import { useEffect, useState } from 'react';
import { getCustomerLoginWithLoginId } from '../../Services/CustomerLoginService';

function CustomerDetail(){

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
            BODY
          </PopoverBody>
        </PopoverContent>
      </Popover>
    </div>
  )
}

export default CustomerDetail;