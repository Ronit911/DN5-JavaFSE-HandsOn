import React from "react";
import Post from "./Post";

class Posts extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            posts: []
        };
    }

    loadPosts() {

        fetch("https://jsonplaceholder.typicode.com/posts")
            .then(res => res.json())
            .then(data => {

                let p = data.map(i => {
                    return new Post(i.id, i.title, i.body);
                });

                this.setState({
                    posts: p
                });

            });

    }

    componentDidMount() {
        this.loadPosts();
    }

    componentDidCatch(error, info) {
        alert(error);
    }

    render() {

        return (

            <div>

                {
                    this.state.posts.map(i => (

                        <div key={i.id}>
                            <h3>{i.title}</h3>
                            <p>{i.body}</p>
                        </div>

                    ))
                }

            </div>

        );
    }

}

export default Posts;