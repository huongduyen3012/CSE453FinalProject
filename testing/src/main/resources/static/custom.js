var inputFrom;
var newMin;

$("#from").change(function() {
    inputFrom = parseInt($("#fromLock").val());
    newMin = inputFrom + 1;

    $("#to").attr('min',newMin);
});
$("#fromLock").change(function() {
    inputFrom = parseInt($("#fromLock").val());
    newMin = inputFrom + 1;

    $("#toLock").attr('min',newMin);
});
$("#fromStock").change(function() {
    inputFrom = parseInt($("#fromStock").val());
    newMin = inputFrom + 1;

    $("#toStock").attr('min',newMin);
});
$("#fromBarrel").change(function() {
    inputFrom = parseInt($("#fromBarrel").val());
    newMin = inputFrom +1;

    $("#toBarrel").attr('min',newMin);
});