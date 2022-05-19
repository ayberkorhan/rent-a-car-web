import {
  useNavigate,
  Navigate,
} from 'react-router-dom';


const ProtectedUserRoute = ({user, children }) => {

  if (user=== "user") {
    return children;
  }
  else{
    return <Navigate to={'/'}/>
  }

};

export default ProtectedUserRoute;