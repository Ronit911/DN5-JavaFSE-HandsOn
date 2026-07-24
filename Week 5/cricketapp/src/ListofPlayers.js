function ListofPlayers(props) {

    return (
        <div>
            {
                props.players.map((p, i) => (
                    <li key={i}>
                        Mr. {p.name} {p.score}
                    </li>
                ))
            }
        </div>
    );
}

function Scorebelow70(props) {

    const p = props.players.filter(x => x.score <= 70);

    return (
        <div>
            {
                p.map((x, i) => (
                    <li key={i}>
                        Mr. {x.name} {x.score}
                    </li>
                ))
            }
        </div>
    );
}

export { ListofPlayers, Scorebelow70 };