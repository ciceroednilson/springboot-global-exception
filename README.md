<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
</head>
<body>

<h1>Tratando exceções globais no SpringBoot.</h6>

<h2>Teste de exceções globais.</h2>

<p>Após executar a aplicação devemos acessar a url abaixo</p>
<p>http://localhost:8014/main/executar/0</p>
<p>E então vamos ter o resultado do erro tratado por uma classe global(br.com.ciceroednilson.global.exception.RestResponseExceptionHandler), exemplo do resultado tratado: {"erros":{"erro":"00","detalhe":"Erro de NullPointerException"}}</p>

<h2>A request "executar" pode ter três parâmetros diferentes, sendo eles, 0, 1 e 2.</h2>
<ul>
	<li>0 = NullPointerException</li>
	<li>1 = RuntimeException</li>
	<li>2 = IllegalArgumentException</li>
</ul>


<h2>Teste de exceção tratada no método.</h2>

<p>http://localhost:8014/main/processar</p>
<p>Nesse link vamos ver a propria exceção retornada pela request</p>


<h2>Teste de exceção tratada no método com retorno em json.</h2>

<p>http://localhost:8014/main/validar</p>
<p>Nesse link vamos ver a propria exceção retornada pela request com o formato em json</p>

<p>{"erro":"Erro tratado no próprio método com response em json!"}</p>



</body>
</html>
