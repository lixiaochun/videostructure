<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WebSocket client</title>
<script type="text/javascript" src="jquery-3.3.1.min.js"></script>  
<script type="text/javascript" language="javascript">

		
        var socket;
        if (typeof (WebSocket) == "undefined"){
            alert("This explorer don't support WebSocket")
        }

        function connect() {
            //Connect WebSocket server
            socket =new WebSocket("ws://192.168.3.193:8000/videostructure/capDataPush");
            //open
            socket.onopen = function () {
                //alert("WebSocket is open");
            }
            //Get message
            socket.onmessage = function (msg) {
				var dt = eval("("+msg.data+")");
				var content = "";
				if( dt.capType == 1 ){
					content += "抓拍图片:<img src='"+dt.imgUrl+"'></br>";
					content += "抓拍类型:行人</br>";
					content += "抓拍uuid:"+dt.uuid+"</br>";
					content += "上身颜色:"+dt.coatColor+"</br>";
					content += "下身颜色:"+dt.trousersColor+"</br>";
					content += "背包:"+dt.bagStyle+"</br>";
					content += "眼睛:"+dt.glass+"</br>";
					content += "帽子:"+dt.cap+"</br>";
				}
				if( dt.capType == 3 ){
					content += "抓拍图片:<img src='"+dt.capUrl+"'></br>";
					content += "抓拍类型:机动车</br>";
					content += "抓拍uuid:"+dt.uuid+"</br>";
					content += "车牌号:"+dt.plateNo+"</br>";
					content += "车辆颜色:"+dt.vehicleColor+"</br>";
					content += "品牌:"+dt.vehicleBrandTag+"</br>";
					content += "车型:"+dt.vehicleClass+"</br>";
					content += "车牌颜色:"+dt.plateColor+"</br>";
				}
				if( dt.capType == 4 ){
					content += "抓拍图片:<img src='"+dt.capUrl+"'></br>";
					content += "抓拍类型:非机动车</br>";
					content += "抓拍uuid:"+dt.uuid+"</br>";
					content += "上身颜色:"+dt.coatColor+"</br>";
					content += "下身颜色:"+dt.trousersColor+"</br>";
					content += "背包:"+dt.bagStyle+"</br>";
					content += "眼睛:"+dt.glass+"</br>";
					content += "帽子:"+dt.cap+"</br>";
				}
				$("#content").html(content);
            }
            //close
            socket.onclose = function () {
                alert("WebSocket is closed");
            }
            //error
            socket.onerror = function (e) {
                alert("Error is " + e);
            }
        }

        function closeSocket() {
            socket.close();
        }

        function sendMsg() {
            socket.send("c9c074d8ebb840489ab047933b1a80b2");
        }
        
        function alertMsg() {
            alert("33333");
        }
        
        function guid() {
        	function S4() {
        		return (((1+Math.random())*0x10000)|0).toString(16).substring(1);
       		}
       		return (S4()+S4()+"-"+S4()+"-"+S4()+"-"+S4()+"-"+S4()+S4()+S4());
       	}
       	
    </script>
</head>
<body>
 	<button onclick="connect()">connect</button>
    <button onclick="closeSocket()">close</button>
    <button onclick="sendMsg()">sendMsg</button>
    <button onclick="alertMsg()">alert</button>
    <div id="content"></div>
</body>
</html>
