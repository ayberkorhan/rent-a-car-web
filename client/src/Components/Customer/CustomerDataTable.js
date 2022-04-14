import {Table, TableContainer, Tbody, Th, Thead, Tr } from '@chakra-ui/react';


function CustomerDataTable ({headers}) {
  return(
    <TableContainer>
      <Table size='sm'>
        <Thead>
          <Tr>
            {headers.map((data,i) => {

              return(
                <Th key={i}>
                  {data}
                </Th>
              )
            })} : <></>
          </Tr>
        </Thead>
        <Tbody>
        </Tbody>
      </Table>
    </TableContainer>
  )
}

export default CustomerDataTable;