const URLParams=new URLSearchParams(window.location.search);
const fotoid=URLParams.get('id');

axios.get(`http://localhost:8080/api/${fotoid}`).then((res) => {
    console.log('richiesta ok', res);
    document.querySelector('#detail').innerHTML= res.data.descrizione;


    document.getElementById("home_page").innerHTML += `<a class="btn btn-danger" href="index.html">Torna in Homepage</a>`;
    
}).catch((res) => {
    console.error('errore nella richiesta', res);
    alert('Errore durante la richiesta!');
});

