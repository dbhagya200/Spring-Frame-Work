$(document).ready(function () {
    //add customer
    $('#btn_save ').click(function (){

        $.ajax({
            url: "http://localhost:8080/api/v1/item/save",
            method: "POST",
            contentType: "application/json",
            data: JSON.stringify({
                "code": $('#code').val(),
                "name": $('#name').val(),
                "price": $('#price').val(),
                "quantity": $('#quantity').val()

            }),
            success:  (response) => {
                if (response) {
                    alert("Item Added Successfully!");
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
    $("#btn_getAll").click(function () {
        $.ajax({
            method: "GET",
            url: "http://localhost:8080/api/v1/item/get",
            success: (res) => {
                let table = $('#item_table_body');
                table.empty();
                res.data.forEach((item) => {
                    table.append(`
                        <tr>
                            <td>${item.code}</td>
                            <td>${item.name}</td>
                            <td>${item.price}</td>
                            <td>${item.quantity}</td>
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
        if ($("#code").val() === ""){
            alert("Please enter the Customer ID!")
            return
        }
        $.ajax({
            url: "http://localhost:8080/api/v1/item/delete?code="+$('#code').val(),
            method: "DELETE",
            success:  (response) => {
                if (response) {
                    alert("Item Deleted Successfully!");
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
            url: "http://localhost:8080/api/v1/item/update",
            method: "PUT",
            contentType: "application/json",
            data: JSON.stringify({
                "code": $('#code').val(),
                "name": $('#name').val(),
                "price": $('#price').val(),
                "quantity": $('#quantity').val()
            }),
            success:  (response) => {
                if (response) {
                    alert("Item Updated Successfully!");
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
        $('#code').val("")
        $('#name').val("")
        $('#price').val("")
        $('#quantity').val("")
    })

    $('#btn_getAll').click()
});


