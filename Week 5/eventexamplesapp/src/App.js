import { useState } from "react";
import CurrencyConvertor from "./CurrencyConvertor";

function App() {

  const [c, setC] = useState(0);

  function inc() {
    setC(c + 1);
  }

  function dec() {
    setC(c - 1);
  }

  function hello() {
    alert("Hello! Member");
  }

  function add() {
    inc();
    hello();
  }

  function welcome(m) {
    alert(m);
  }

  function press() {
    alert("I was clicked");
  }

  return (
    <div style={{ margin: "20px" }}>

      <h2>{c}</h2>

      <button onClick={add}>Increment</button>

      <br /><br />

      <button onClick={dec}>Decrement</button>

      <br /><br />

      <button onClick={() => welcome("Welcome")}>
        Say Welcome
      </button>

      <br /><br />

      <button onClick={press}>
        Click on me
      </button>

      <br /><br />

      <CurrencyConvertor />

    </div>
  );
}

export default App;