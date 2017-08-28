<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	<!-- importando a biblioteca de taglib e formatação de data fmt -->
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	
	<!-- importando classe que será utilizada criando a DAO -->
	<jsp:useBean id="dao" class="br.com.caelum.jdbc.dao.ContatoDao" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Contatos</title>
</head>
<body>	
	<!-- importando cabeçalho -->
	<c:import url="cabecalho.jsp" />

	<table>
		<!-- percorre contatos montando as linhas da tabela alternando as cores -->
		<c:forEach var="contato" items="${dao.lista}" varStatus="id">
			<tr bgcolor="#${id.count % 2 == 0 ? 'C0C0C0"' : 'ffffff'}" >
				<td>${id.count}</td>
				<td>${contato.nome}</td>
				<td>
				
				<c:if test="${not empty contato.email}">
					<a href="mailto:${contato.email}">${contato.email}</a>
				</c:if>
				
				<c:if test="${empty contato.email}">
					Email não informado
				</c:if>
				</td>	
				
				<td>${contato.endereco}</td>
				<td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" />
				</td>
			</tr>
		</c:forEach>
	</table>
			
		<!-- importando rodapé -->
		<c:import url="rodape.jsp" />
</body>
</html>