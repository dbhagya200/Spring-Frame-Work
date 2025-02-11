$(document).ready(function () {
  //add customer
  $('#btn_save ').click(function (){

    $.ajax({
      url: "http://localhost:8080/_10_BackEnd_Web_exploded/api/v1/customer/save",
      method: "POST",
      contentType: "application/json",
      data: JSON.stringify({
        "id": $('#id').val(),
        "name": $('#name').val(),
        "age": $('#age').val(),
        "address": $('#address').val()

      }),
      success:  (response) => {
        if (response) {
          alert("Customer Added Successfully!");
          $('#btn_clear').click()
          $('#btn_getAll').click()
          return
        }else if(val.empty()){
          alert("Please fill all the fields!")
          return
        }
        alert("Failed to add Customer!")
      },
      error:  (error) => {
        alert("Something went wrong!")
        console.log(error);
      }
    });
  })

  //get all customers
  $('#btn_getAll').click(function () {
    $.ajax({
      method: "GET",
      url: "http://localhost:8080/_10_BackEnd_Web_exploded/api/v1/customer/getall",
      success: (res) => {
        let table = $('#customer_table_body');
        table.empty();
        res.forEach((customer) => {
          table.append(`
                        <tr>
                            <td>${customer.id}</td>
                            <td>${customer.name}</td>
                            <td>${customer.age}</td>
                            <td>${customer.address}</td>
                        </tr>
                    `);
        });
      },
      error: (err) => {
        alert("Something went wrong!")
        console.log(err)
      }
    });
  })

  //delete customer
  $('#btn_delete').click(function (){
    //Check if the ID is empty
    if ($('#id').val() === ""){
      alert("Please enter the Customer ID!")
      return
    }
    $.ajax({
      url: "http://localhost:8080/_10_BackEnd_Web_exploded/api/v1/customer/delete?id="+$('#id').val(),
      method: "DELETE",
      success:  (response) => {
        if (response) {
          alert("Customer Deleted Successfully!");
          $('#btn_getAll').click()
          return
        }
        alert("Failed to delete Customer!")
      },
      error:  (error) => {
        alert("Something went wrong!")
        console.log(error);
      }
    })
  })

  //update customer
  $('#btn_update').click(function (){
    // //Check if the ID is empty
    // if ($('#id').val() === ""){
    //   alert("Please enter the Customer ID!")
    //   return
    // }
    $.ajax({
      url: "http://localhost:8080/_10_BackEnd_Web_exploded/api/v1/customer/update",
      method: "PUT",
      contentType: "application/json",
      data: JSON.stringify({
        "id": $('#id').val(),
        "name": $('#name').val(),
        "age": $('#age').val(),
        "address": $('#address').val()
      }),
      success:  (response) => {
        if (response) {
          alert("Customer Updated Successfully!");
          $('#btn_clear').click()
          $('#btn_getAll').click()
          return
        }
        alert("Failed to update Customer!")
      },
      error:  (error) => {
        alert("Something went wrong!")
        console.log(error);
      }
    })
  })

  $('#btn_clear').click(function () {
    $('#id').val("")
    $('#name').val("")
    $('#age').val("")
    $('#address').val("")
  })

  $('#btn_getAll').click()
});


