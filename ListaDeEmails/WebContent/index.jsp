<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#81BEF7">

 <img width="200" heith="200" src="imagens/logofaetec.JPG"/>

<tr>
<td  width="50"> </td>
</tr>

<form id="EnvioEmail" action="EnviarEmail" method="post">

<table width="300" border="3" align="left" >

<tr>
<td width="200" >
<h2 ><font  color="#FF6700" face="Verdana, Arial, Helvetica, sans-serif">ÁREA DE AUTENTICAÇÃO </font></h2>

</td>
</tr>
<tr>


<td width="200" >
	<font size="2" face="Verdana, Arial, Helvetica, sans-serif"> *Email:</font>
	
	<input type="text" id="emailLogin" name="emailLogin" />
	</textarea>
	
	</td>
	</tr>
<tr>
<td width="200" >
	<font size="2"  face="Verdana, Arial, Helvetica, sans-serif"> *Senha:</font>
	
	<input type="password" id="senha" name="senha" />
	</textarea>
	<br />
	</td>
</tr>


</table>





<table width="588" border="1" align="center" >
<tr>
<td width="460" align="center">
<h1 >Dados de Envio de Email</h1>

</td>
</tr>

<tr>
<td width="460" height="50px">
	<font size="2" face="Verdana, Arial, Helvetica, sans-serif">De:</font>
	<br />
	<textarea rows=1 cols=30 id="remetente" name="remetente" >
	</textarea>
	<br />
	</td>
</tr>

<tr>
<td width="460" height="50px">
	<font size="2" face="Verdana, Arial, Helvetica, sans-serif">Para:</font>
	<br />
	<textarea rows=5 cols=60 id="listaEmail" name="listaEmail" >
	</textarea>
	<br />
	</td>
</tr>


<br />
<br />

<tr>
<td width="460" >
	<font size="2" face="Verdana, Arial, Helvetica, sans-serif">Assunto:</font>
	
	<input type="text" id="assunto" name="assunto" />
	</textarea>
	<br />
	</td>
</tr>
<p>
</p>
<p>
</p>


<tr>

<td width="460" height="200px">
	<font size="2" face="Verdana, Arial, Helvetica, sans-serif">Mensagem:</font>
	<textarea rows=5 cols=60 id="corpo" name="corpo" >
	</textarea>
	<br />
	</td>
</tr>


<br />
<br />
<br />
<br />
<tr>
	<td width="10" height="50px">
	<font size="2" face="Verdana, Arial, Helvetica, sans-serif">Quantidade:</font>
	<input type="text" id="quant" name="quant"/>
	
	<font size="2" face="Verdana, Arial, Helvetica, sans-serif">Data:</font>
	<input type="text" id="data" name="data" placeholder="01/01/2015"/>
	<br />
	</td>
</tr>
	<tr>
	<td align="center" height="50px">
	            <input type="submit" value="Enviar" />
	            
	         </td>
	         </tr>
	

 
<br />
<br />
 
  </form> 




  
</body>
</html>