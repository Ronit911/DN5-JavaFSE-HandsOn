function BlogDetails() {

  const blogs = [
    {
      id: 1,
      title: "React Learning",
      author: "Stephen Biz",
      text: "Welcome to learning React"
    },
    {
      id: 2,
      title: "Installation",
      author: "Schwedenier",
      text: "You can install React from npm."
    }
  ];

  return (
    <div>
      <h2>Blog Details</h2>

      {
        blogs.map((b) => (
          <div key={b.id}>
            <h3>{b.title}</h3>
            <h4>{b.author}</h4>
            <p>{b.text}</p>
          </div>
        ))
      }

    </div>
  );
}

export default BlogDetails;