import React from 'react';
import {
  ChakraProvider,
  theme,
} from '@chakra-ui/react';
import './index.css';
import Menu from './Components/Menu';
import AdminPanel from './Pages/AdminPanel';


function App() {
  return (
    <ChakraProvider theme={theme} resetCss={true}>
      <AdminPanel/>
    </ChakraProvider>
  );
}

export default App;
