import office from "./office.jpg";

function App() {

  const offices = [
    {
      name: "DBS",
      rent: 50000,
      address: "Chennai",
      image: office
    },
    {
      name: "Regus",
      rent: 75000,
      address: "Bangalore",
      image: office
    },
    {
      name: "SmartWorks",
      rent: 55000,
      address: "Hyderabad",
      image: office
    }
  ];

  return (
    <div style={{ marginLeft: "40px" }}>

      <h1>Office Space, at Affordable Range</h1>

      {
        offices.map((o, i) => (
          <div key={i}>

            <img
              src={o.image}
              alt="Office Space"
              width="25%"
              height="25%"
            />

            <h2>Name: {o.name}</h2>

            <h3
              style={{
                color: o.rent < 60000 ? "red" : "green"
              }}
            >
              Rent: Rs. {o.rent}
            </h3>

            <h3>Address: {o.address}</h3>

            <br />

          </div>
        ))
      }

    </div>
  );
}

export default App;