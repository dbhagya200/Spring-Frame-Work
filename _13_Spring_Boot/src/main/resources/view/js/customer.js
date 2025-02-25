let ID =0;

function generateID() {
  console.log("Generating ID...");
  const id = `CID-0${ID}`;
  ID++;
  console.log(`Generated Customer ID: ${id}`);
  return id;
}
function loadOrderDetails() {
  const newID = generateID();

  // Set values to text fields
  $("#id").val(newID);
}
$(document).ready(function () {
  loadOrderDetails();
  generateID();
  //add customer
  $('#btn_save ').click(function (id){

    $.ajax({
      url: "http://localhost:8080/api/v1/customer/save",
      method: "POST",
      contentType: "application/json",
      data: JSON.stringify({
        "id":   $("#id").val(id),
        "name": $('#name').val(),
        "address": $('#address').val()

      }),
      success:  (response) => {
        if (response) {
          alert(response.message);

          $('#btn_clear').click()
          $('#btn_getAll').click()
          return
        }else if(value.empty()){
          alert("Please fill all the fields!")
          return
        }
        alert(response.message)
      },
      error:  (error) => {
        alert(error.message)
        console.log(error);
      }
    });
  })

  //get all customers
  $("#btn_getAll").click(function () {
    $.ajax({
      method: "GET",
      url: "http://localhost:8080/api/v1/customer/get",
      success: (res) => {
        let table = $('#customer_table_body');
        table.empty();
        res.data.forEach((customer) => {
          table.append(`
                        <tr>
                            <td>${customer.id}</td>
                            <td>${customer.name}</td>
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
    if ($("#id").val() === ""){
      alert("Please enter the Customer ID!")
      return
    }
    $.ajax({
      url: "http://localhost:8080/api/v1/customer/delete?id="+$('#id').val(),
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
      url: "http://localhost:8080/api/v1/customer/update",
      method: "PUT",
      contentType: "application/json",
      data: JSON.stringify({
        "id": $('#id').val(),
        "name": $('#name').val(),
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
    $('#address').val("")
  })

  $('#btn_getAll').click()
});


