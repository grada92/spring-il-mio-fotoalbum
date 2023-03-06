
elencoFoto();

function elencoFoto(){
    axios.get('http://localhost:8080/api').then((res) =>{
        // codice da eseguire
        console.log("richiesta ok", res);
        document.querySelector('#foto').innerHTML= '';
        res.data.forEach(element => {
            console.log(element);
            document.querySelector('#foto').innerHTML+= `
       
        <div class="text-center align-items-end justify-content-center row box-foto" >
               
            <div class="img-logo px-5 ">
                <img class="img-fluid foto" src="${element.url} " />
            </div>
            <div class="py-2">
                <div class="box-text text-white">
                    <h4> ${element.titoloFoto}</h4>
                </div>                                          
                    <a class="btn btn-dark-moon" href="./detail.html?id=${element.id}">Visualizza</a>
            </div>        
          
        </div>
            
            `
        });
    }) .catch((res) => {
        // codice da eseguire in caso di errori
        console.log("errore", res);
        alert('ERRORE');
    })
}