import { useState } from "react";

function LoginButton(props) {
  return (
    <button onClick={props.onClick}>
      Login
    </button>
  );
}

function LogoutButton(props) {
  return (
    <button onClick={props.onClick}>
      Logout
    </button>
  );
}

function GuestPage() {
  return (
    <div>
      <h2>Please sign up.</h2>

      <h3>Flight Details</h3>

      <ul>
        <li>Flight : Indigo</li>
        <li>From : Chennai</li>
        <li>To : Delhi</li>
        <li>Time : 10:30 AM</li>
      </ul>
    </div>
  );
}

function UserPage() {
  return (
    <div>
      <h2>Welcome back</h2>

      <h3>You can now book your tickets.</h3>
    </div>
  );
}

function Greeting(props) {
  if (props.isLoggedIn) {
    return <UserPage />;
  }

  return <GuestPage />;
}

function App() {

  const [login, setLogin] = useState(false);

  return (
    <div style={{ margin: "40px" }}>

      <Greeting isLoggedIn={login} />

      <br />

      {
        login ?

        <LogoutButton
          onClick={() => setLogin(false)}
        />

        :

        <LoginButton
          onClick={() => setLogin(true)}
        />
      }

    </div>
  );
}

export default App;