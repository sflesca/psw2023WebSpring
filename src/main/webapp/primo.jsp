<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <jsp:useBean id="messaggio" scope="request" class="java.lang.String"/>
</head>
<body>
Il mio primo controller
${{messaggio}}
</body>
</html>