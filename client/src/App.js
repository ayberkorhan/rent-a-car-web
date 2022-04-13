import React from 'react';
import {
  ChakraProvider,
  theme
} from '@chakra-ui/react';
import MainPage from '../Pages/MainPage';


function App() {
  return (
    <ChakraProvider theme={theme} resetCss={true}>
      <MainPage/>
    </ChakraProvider>
  );
}

export default App;
