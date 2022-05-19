import {
  useNavigate,
  Navigate,
} from 'react-router-dom';


const ProtectedAdminRoute = ({user, children }) => {

  if (user=== "admin") {
      return children;
  }
  else{
   return <Navigate to={'/'}/>
  }

};

export default ProtectedAdminRoute;