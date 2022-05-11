import {
  useNavigate,
  Navigate,
} from 'react-router-dom';


const ProtectedRoute = ({user, children }) => {

  if (user) {
    return children;
  }
  else{
   return <Navigate to={"/login"}></Navigate>
  }

};

export default ProtectedRoute;