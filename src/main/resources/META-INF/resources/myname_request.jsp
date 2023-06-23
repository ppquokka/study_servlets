<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>myname_request</title>
</head>
<body>
    <div>input ypur name</div>
    <form action="/getRequestParamsServlet" method="get">
    <div>
        fist name : <input type="text" name="first_name">   
    </div>
    <div>
        second name : <input type="text" name="second_name">
    </div>
    <div>
        <button type="submit">보내기</button>
    </div>
</form>
</body>
</html>
