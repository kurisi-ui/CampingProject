"use strict";




let targetDiv = document.querySelector('div');

//* FETCH - fetch allows us to send and receive requests utilizing promises (get all)
fetch(`https://jsonplaceholder.typicode.com/comments`) // fetch plug in the target URL
.then((response) => { // .then follows fetch and takes in response
    if (response.status !== 200) { // If statement to check if response IS NOT 200
        console.log(`status: ${response.status}`);
        return;
    }
    response.json()// Taking response and converting to json using .json()
    .then( (data) => { // .then() if succesful uses arrow function
        console.log(data); // console.log out data
    }).catch((error) => { //.catch() if unsuccesful save error
        console.log(`${error}`); // console.log out error
    })
});

fetch(`https://jsonplaceholder.typicode.com/comments`) // fetch plug in the target URL
.then((response) => { // .then follows fetch and takes in response
    if (response.status !== 200) { // If statement to check if response IS NOT 200
        console.log(`status: ${response.status}`);
        return;
    }
    response.json()
    .then((data) => {
        console.log("Hello");
    }  )
    .catch((error) => console.log(`${error}`))
}); 

//* Fetch by ID (Get by ID)
let id = 2; // ID of the item you want to fetch
console.log(`The id of the item I want is ${id}`);

fetch(`https://jsonplaceholder.typicode.com/posts/${id}`)
.then((response) => {
    if (response.status !== 200) {
        console.log(`status ${response.status}`);
        return;
    }
    response.json()
    .then((data) => console.log(data))

    .catch((error) => console.log(`error ${error}`))
});

//* Object being passed to the backend
const myObject = {
    "userId": 100,
    "title":"this is a test camp",
    "openWinter":"this is the test body",
    "price": 22.22

};
//* Fetch post method

fetch(`https://jsonplaceholder.typicode.com/posts`, {

    method: `POST`, // declaring the method
    headers: {
        "content-type":"application/json" //header
    },
    body: JSON.stringify(myObject) //what data to post
}) 
.then( (response) => response.json())
.then( (data) => console.log(`Request successful with JSON response ${data}`))
.catch( (error) => console.log(error));



//!Fetch Update work out self assignment



//*Fetch Delete 
// Deleting a specific item 
console.log(`Post to be deleted ${id}`);

fetch(`https://jsonplaceholder.typicode.com/posts/${id}`, {
method: `DELETE`
})
.then((data) => console.log(`Request all with JSON response ${data}`))
.catch((error) => console.log(error));


//* PostData Function


let postData = (data) => {
    let newTitle = document.createElement('h3');
    let newBody = document.createElement('p');
    let bodyData = data.body; 
    let titleData = data.title;
    newTitle.innerHTML = titleData;
    newBody.innerHTML = bodyData;
    //newData.innerHTML = `Title: ${titleData} Body: ${bodyData}`;
    targetDiv.appendChild(newTitle);
    targetDiv.appendChild(newBody);
} 

