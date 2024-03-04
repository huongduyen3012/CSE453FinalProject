$("#from").change(function() {
    $("#to").attr('min',$("#from").val());
});
$("#fromLock").change(function() {
    $("#toLock").attr('min',$("#fromLock").val());
});
$("#fromStock").change(function() {
    $("#toStock").attr('min',$("#fromStock").val());
});
$("#fromBarrel").change(function() {
    $("#toBarrel").attr('min',$("#fromBarrel").val());
});

document.cookie;