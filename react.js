import {useState} from "react"; 
import Login from "./components/Login"; 
import Dashboard from "./components/Dashboard"; 
 
function App() { 
const [isLoggedIn, setIsLoggedIn] = useState(false); 
 
const handleLogin = () => { 
  setIsLoggedIn(true); 
}; 
const handleLogout = () => { 
  setIsLoggedIn(false); 
} 
return( 
  <div> 
    <h1>Simple React App</h1> 
    {} 
      {isLoggedIn ? ( 
      <Dashboard handleLogout={handleLogout} /> 
    ) : ( 
      <Login handleLogin={handleLogin} /> 
    )} 
 
  </div> 
); 
} 
 
export default App; 
 
function Login({handleLogin}){ 
     return( 
        <div> 
            <h2>Login Page</h2> 
        <button onClick={handleLogin}>Login</button> 
        </div> 
 
     ) 
} 
export default Login; 
 
function Dashboard({handleLogout}){ 
     return( 
        <div> 
            <h2>Dashboard</h2> 
            <p>Welcome to your dashboard!</p> 
            <button onClick={handleLogout}>Logout</button> 
</div> 
) 
} 
export default Dashboard;
