const T20Players = [
    "First Player",
    "Second Player",
    "Third Player"
];

const RanjiTrophyPlayers = [
    "Fourth Player",
    "Fifth Player",
    "Sixth Player"
];

const IndianPlayers = [...T20Players, ...RanjiTrophyPlayers];

function OddPlayers(props) {

    const [first, , third, , fifth] = props.IndianTeam;

    return (
        <div>
            <li>First : {first}</li>
            <li>Third : {third}</li>
            <li>Fifth : {fifth}</li>
        </div>
    );
}

function EvenPlayers(props) {

    const [, second, , fourth, , sixth] = props.IndianTeam;

    return (
        <div>
            <li>Second : {second}</li>
            <li>Fourth : {fourth}</li>
            <li>Sixth : {sixth}</li>
        </div>
    );
}

function ListofIndianPlayers(props) {

    return (
        <div>
            {
                props.IndianPlayers.map((p, i) => (
                    <li key={i}>
                        Mr. {p}
                    </li>
                ))
            }
        </div>
    );
}

export {
    OddPlayers,
    EvenPlayers,
    ListofIndianPlayers,
    IndianPlayers
};