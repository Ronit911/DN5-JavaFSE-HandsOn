import { useState } from "react";

function CurrencyConvertor() {

  const [r, setR] = useState("");
  const [e, setE] = useState("");

  function handleSubmit(event) {

    event.preventDefault();

    const euro = (r / 90).toFixed(2);

    setE(euro);

    alert("Converting to Euro Amount is " + euro);
  }

  return (

    <div>

      <h1 style={{ color: "green" }}>
        Currency Convertor!!!
      </h1>

      <form onSubmit={handleSubmit}>

        <label>Amount </label>

        <input
          type="number"
          value={r}
          onChange={(x) => setR(x.target.value)}
        />

        <br /><br />

        <label>Currency </label>

        <input
          type="text"
          value={e}
          readOnly
        />

        <br /><br />

        <button type="submit">
          Submit
        </button>

      </form>

    </div>

  );
}

export default CurrencyConvertor;