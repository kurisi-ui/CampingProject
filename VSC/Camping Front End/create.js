"use strict";

//post method
fetch("databaselocation", { //1
    method: 'post', //Method
    headers: {
      "Content-type": "application/json" //3
    },
    body: JSON.stringify( //4
      {
        "campName": "Billybob Camp",//5
        "openWinter": 5,
        "price": 22.22
      }
    )
  })
  .then(res => res.json())
  .then((data) => console.log(`Request succeeded with JSON response ${data}`))
  .catch((error) => console.log(`Request failed ${error}`))
  });

  const createButton = document.querySelector('input');