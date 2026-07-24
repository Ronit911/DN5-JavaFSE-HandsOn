import BookDetails from "./BookDetails";
import BlogDetails from "./BlogDetails";
import CourseDetails from "./CourseDetails";

function App() {

  const show = true;

  return (
    <div className="main">

      {show && <CourseDetails />}

      {show ? <BookDetails /> : null}

      <BlogDetails />

    </div>
  );
}

export default App;