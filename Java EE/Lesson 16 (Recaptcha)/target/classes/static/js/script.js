$(document).ready(() => {
    const API_URL = 'http://localhost:8080/api/v1';
    let prod = {
        name: 'New product',
        description: 'Somde description of new product',
        price: 100,
        image: '???',
        categoryId: 1
    };
    // $.get(`${API_URL}/products`, (resp) => {
    //     console.log(resp);
    // })
    // $.ajax({
    //     type: 'POST',
    //     url: `${API_URL}/products`,
    //     contentType: 'application/json',
    //     data: JSON.stringify(prod),
    //     success: (resp) => {
    //         console.log(resp)
    //     }
    // })
})