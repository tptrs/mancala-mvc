<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    
    <style>
        .text{
            text-align: center;
            font-family: monospace;
            font-size: 28px;
            margin-top: 30px;
        }
        
        a {
            text-decoration: none;
            color: #000000;
        }
        
        body{
            background-color: #aef7c4;
        }
        
        .menu{
            margin: auto;
            margin-top: 300px;
            padding: 20px;
            background-color: yellow;
            box-shadow: 10px 10px #000000;
            width: 500px;
            height: 250px;
        }
        
        #message{
            font-weight: bold;
            font-size: 35px
        }
    </style>
</head>
<body>
    
    <div class="menu">
        <div class="text" id="message"></div>
        <div class="text"><a href="http://localhost:8080/mancala-mvc/servlet1">Start a new Mancala game</a></div>
        <div class="text"><a href="http://localhost:8080/mancala-mvc/">Return to Main Menu</a></div>
    </div>
    
    <script>
        <jsp:useBean id="Field14" class="nl.sogyo.mancalamaven.domain.Kalaha" scope="session"/>
        <jsp:useBean id="Field7" class="nl.sogyo.mancalamaven.domain.Kalaha" scope="session"/>
        const pointsP1 = <jsp:getProperty name="Field7" property="stoneCount"/>
        const pointsP2 = <jsp:getProperty name="Field14" property="stoneCount"/>
        let messageElement = document.getElementById("message")
        if(pointsP1 > pointsP2) messageElement.innerText = "Blue player won!"
        else if(pointsP1 < pointsP2) messageElement.innerText = "Red player won!"
        else messageElement.innerText = "It's a tie!"
    </script>
</body>
</html>