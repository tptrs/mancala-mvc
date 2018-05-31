<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Document</title>

        <style>
            body{
                background-color: #aef7c4;
            }

            a{
                text-decoration: none;
                color: white;
            }

            .field{
                border: 10px solid yellow;
                float: left;
                font-family: monospace;
                font-size: 120px;
                color: white;
                text-align: center;
                display: flex;
                justify-content: center;
                align-items: center;
                box-shadow: 10px 10px #000000;
            }

            .bowl{
                height: 150px;
                width: 150px;
            }

            .kalaha{
                height: 310px;
                width: 150px;
            }

            .bowl:hover{
                cursor: pointer;
            }

            #board {
                display: flex;
                position: absolute;
                left: 0px;
                top: 0px;
                right: 0px;
                bottom: 0px;
                justify-content: center;
                align-items: center;
            }
            
            .nbleft{
                border-left: none;
            }
            
            .nbright{
                border-right: none;
            }
            
            .nbtop{
                border-top: none;
            }
            
            .nbbottom{
                border-bottom: none;
            }
        </style>


    </head>
    <body>
        <jsp:useBean id="mancala" class="nl.sogyo.mancalamaven.Mancala" scope="session"/>
        <div id="board">
            <div class="kalaha field playerTwo">
                <jsp:getProperty name="mancala" property="field14"/>
            </div>
            <div>
                <div>
                    <form name="move13" method="post" action="http://localhost:8080/mancala-mvc/servlet2" class="bowl field playerTwo nbleft nbbottom">
                        <input type="hidden" name="bowl" value="13">
                        <a href="javascript:document.move13.submit()"> 
                            <jsp:getProperty name="mancala" property="field13"/>
                        </a>
                    </form>
                    <form name="move12" method="post" action="http://localhost:8080/mancala-mvc/servlet2" class="bowl field playerTwo nbleft nbbottom">
                        <input type="hidden" name="bowl" value="12">
                        <a href="javascript:document.move12.submit()"> 
                            <jsp:getProperty name="mancala" property="field12"/>
                        </a>
                    </form>
                    <form name="move11" method="post" action="http://localhost:8080/mancala-mvc/servlet2" class="bowl field playerTwo nbleft nbbottom">
                        <input type="hidden" name="bowl" value="11">
                        <a href="javascript:document.move11.submit()">
                            <jsp:getProperty name="mancala" property="field11"/>
                        </a>
                    </form>
                    <form name="move10" method="post" action="http://localhost:8080/mancala-mvc/servlet2" class="bowl field playerTwo nbleft nbbottom">
                        <input type="hidden" name="bowl" value="10">
                        <a href="javascript:document.move10.submit()"> 
                            <jsp:getProperty name="mancala" property="field10"/>
                        </a>
                    </form>
                    <form name="move9" method="post" action="http://localhost:8080/mancala-mvc/servlet2" class="bowl field playerTwo nbleft nbbottom">
                        <input type="hidden" name="bowl" value="9">
                        <a href="javascript:document.move9.submit()"> 
                            <jsp:getProperty name="mancala" property="field9"/>
                        </a>
                    </form>
                    <form name="move8" method="post" action="http://localhost:8080/mancala-mvc/servlet2" class="bowl field playerTwo nbleft nbbottom nbright">
                        <input type="hidden" name="bowl" value="8">
                        <a href="javascript:document.move8.submit()">
                            <jsp:getProperty name="mancala" property="field8"/>
                        </a>
                    </form>
                </div>
                <div>
                    <form name="move1" method="post" action="http://localhost:8080/mancala-mvc/servlet2" class="bowl field playerOne nbleft">
                        <input type="hidden" name="bowl" value="1">
                        <a href="javascript:document.move1.submit()">
                            <jsp:getProperty name="mancala" property="field1"/>
                        </a>
                    </form>
                    <form name="move2" method="post" action="http://localhost:8080/mancala-mvc/servlet2" class="bowl field playerOne nbleft">
                        <input type="hidden" name="bowl" value="2">
                        <a href="javascript:document.move2.submit()">
                            <jsp:getProperty name="mancala" property="field2"/>
                        </a>
                    </form>
                    <form name="move3" method="post" action="http://localhost:8080/mancala-mvc/servlet2" class="bowl field playerOne nbleft">
                        <input type="hidden" name="bowl" value="3">
                        <a href="javascript:document.move3.submit()">
                            <jsp:getProperty name="mancala" property="field3"/>
                        </a>
                    </form>
                    <form name="move4" method="post" action="http://localhost:8080/mancala-mvc/servlet2" class="bowl field playerOne nbleft">
                        <input type="hidden" name="bowl" value="4">
                        <a href="javascript:document.move4.submit()">
                            <jsp:getProperty name="mancala" property="field4"/>
                        </a>
                    </form>
                    <form name="move5" method="post" action="http://localhost:8080/mancala-mvc/servlet2" class="bowl field playerOne nbleft">
                        <input type="hidden" name="bowl" value="5">
                        <a href="javascript:document.move5.submit()">
                            <jsp:getProperty name="mancala" property="field5"/>
                        </a>
                    </form>
                    <form name="move6" method="post" action="http://localhost:8080/mancala-mvc/servlet2" class="bowl field playerOne nbleft nbright">
                        <input type="hidden" name="bowl" value="6">
                        <a href="javascript:document.move6.submit()">
                            <jsp:getProperty name="mancala" property="field6"/>
                        </a>
                    </form>
                </div>
            </div>
            <div class="kalaha field playerOne" style="z-index:999">
                <jsp:getProperty name="mancala" property="field7"/>
            </div>
        </div>

        <script>
            <jsp:useBean id="Player1" class="nl.sogyo.mancalamaven.domain.Player" scope="session"/>;
            let playerOneElements = document.getElementsByClassName("playerOne");    
            let playerTwoElements = document.getElementsByClassName("playerTwo");
            
            if (<jsp:getProperty name="Player1" property="turn"/> === true) {
                for (let i = 0; i < 7; i++) {
                    playerOneElements[i].style.backgroundColor = "#00a0ff";
                    playerTwoElements[i].style.backgroundColor = '#bd1d00';
                }
            } else {
                for (let i = 0; i < 7; i++) {
                    playerTwoElements[i].style.backgroundColor = "#ff3000";
                    playerOneElements[i].style.backgroundColor = '#0075ce';
                }
            }

        </script>
    </body>
</html>