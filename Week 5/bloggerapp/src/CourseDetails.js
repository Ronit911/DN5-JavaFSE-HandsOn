function CourseDetails() {

  const courses = [
    {
      id: 1,
      name: "Angular",
      date: "4/5/2021"
    },
    {
      id: 2,
      name: "React",
      date: "6/3/2021"
    }
  ];

  return (
    <div>
      <h2>Course Details</h2>

      {
        courses.map((c) => (
          <div key={c.id}>
            <h3>{c.name}</h3>
            <h4>{c.date}</h4>
          </div>
        ))
      }

    </div>
  );
}

export default CourseDetails;