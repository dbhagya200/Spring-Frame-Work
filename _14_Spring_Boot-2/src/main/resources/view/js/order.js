let cartData=[];
let tot=0;
$("#addToCart").click( (e)=>{
    let itemCode=  $('#itCode').val();
    let des=$('#itName').val();
    let price=$('#uPrice').val();
    let qty=$('#qty').val();
    let total=qty*price;
    tot= tot + total;

    let cartObject = {itemCode,des,price,qty,total};
    cartData.push(cartObject);
    loadCartData();
})

function loadCartData(){
    $("#orderTableBody").empty();
    for(let i=0;i<cartData.length;i++){
        let row=`<tr>
                <td>${cartData[i].itemCode}</td>
                <td>${cartData[i].des}</td>
                <td>${cartData[i].price}</td>
                <td>${cartData[i].qty}</td>
                <td>${cartData[i].total}</td>
                    </tr>`;
        $('#netTotal').val(tot);

        $('#orderTableBody').append(row);
    }
}

$("#purchase").click( (e) =>{

    let orderId=$("#orderId").val();
    let customerId=$("#cusId").val();
    let itemId=$("#itCode").val();
    let date=$("#orderDate").val();


    $.ajax({
        url:"http://localhost:8080/api/v1/item/save",
        method:'POST',
        data:{
            orderId:orderId,
            date:date,
            customerId:customerId
        },
        success:function (response){
            alert("Order placed successfully");
            orderDetails(orderId);
        },
        error:function (error){
            alert("Error while Order placed");
            console.log(error)
        }
    })
})

function orderDetails(orderId){
    cartData.forEach(element =>{
        console.log(element.itemCode);
        $.ajax({
            url:'http://localhost:8080/api/v1/item/save',
            method:'POST',
            data:{
                orderId:orderId,
                itemCode:element.itemCode,
                qty: element.qty,
                unitPrice: element.unitPrice

            },
            success:function (response){
                alert("Order Detail placed successfully");
                updateItem(element.itemCode,element.qtyOnHand);
            },
            error:function (error){
                alert("Error while Order Detail placed");
                console.log(error)
            }
        })
    })

}

function updateItem(itemCode,qtyOnHand){
    $.ajax({
        url:'http://localhost:8080/api/v1/item/update',
        method:'PUT',
        data:JSON.stringify({
            itemCode:itemCode,
            qtyOnHand:qtyOnHand
        }),
        success:function (response){
            alert("Item updated successfully");
            // cartData.splice(0,cartData.length)
            loadOrderDetails();
            clearfield()
        }
    })
}

function clearfield(){
    $("#orderId").val('');
    $("#orderDate").val('');
    $("#cusId").val('');
    $("#cusName").val('');
    $("#itCode").val('');
    $("#itName").val('');
    $("#uPrice").val('');
    $("#qtyOnHand1").val('');
    $("#qty").val('');

}

const selectCustomerIds =() =>{
    $.ajax({
        url: "http://localhost:8080/Application1_Web_exploded/customer",
        method:"GET",
        success: function (response) {
            let data =response;
            $('#cusId').empty();
            $('#cusId').append(
                `<option value="0">Select Customer</option>`
            );
            for(let i=0;i<data.length;i++){
                $(`#cusId`).append(`<option value="${data[i].id}">${data[i].id}</option>`)
            }
        },
        error: function (){
            console.log("error")
        }
    })
}
selectCustomerIds();

$("#cusId").on('change', (e) =>{
    let cid=e.target.value;
    $.ajax({
        url: "http://localhost:8080/Application1_Web_exploded/customer",
        method:"GET",
        success:function (response){
            let data = response;

            for(let i=0;i<data.length;i++){
                if(cid == data[i].id){
                    $('#cusName').val(data[i].name);
                }
            }
        },
        error:function (error){
            console.log(error)
        }
    })
})

$("#itCode").on('change', (e) =>{
    let itcode=e.target.value;
    $.ajax({
        url: "http://localhost:8080/Application1_Web_exploded/item",
        method:"GET",
        success:function (response){
            let data=response;
            for(let i=0;i<data.length;i++){
                if(itcode == data[i].code){
                    $('#itName').val(data[i].description);
                    $('#uPrice').val(data[i].unitPrice);
                    $('#qtyOnHand1').val(data[i].qtyOnHand);

                }
            }
        },
        error: function (error){
            console.log(error);
        }
    })
})

const selectItemsIds =() =>{
    $.ajax({
        url: "http://localhost:8080/Application1_Web_exploded/item",
        method:"GET",
        success: function (response) {
            let data =response;
            $('#itCode').empty();
            $('#itCode').append(
                `<option value="0">Select Item</option>`
            );
            for(let i=0;i<data.length;i++){
                $(`#itCode`).append(`<option value="${data[i].code}">${data[i].code}</option>`)
            }
        },
        error: function (){
            console.log("error")
        }
    })
}

selectItemsIds()