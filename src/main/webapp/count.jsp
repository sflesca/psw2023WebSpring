<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <jsp:useBean id="counter" scope="request" class="sergio.psw2023webspring.utility.Carrello"/>
</head>
<body>
Il mio primo controller
${{counter.count}}
</body>
</html>