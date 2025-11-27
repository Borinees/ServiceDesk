<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Chamado #${chamado.id} - HelpDesk</title>

    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/css/base.css">
    <link rel="stylesheet" href="/css/forms.css">
    <link rel="stylesheet" href="/css/chamado.css">
</head>

<body class="app-body">

<!-- SIDEBAR -->
<aside class="sidebar">
    <div class="sidebar-brand">Empresa XYZ</div>
    <nav>
        <ul>
            <li><a href="/dashboard">Dashboard</a></li>
            <li><a href="/usuarios">Gestão de Usuários</a></li>
            <li class="active"><a href="/chamados">Chamados</a></li>
        </ul>
    </nav>
</aside>

<!-- TOPBAR -->
<header class="topbar">
    <h2>Chamado #${chamado.id}</h2>
</header>

<!-- CONTEÚDO -->
<main class="main-area two-column">

    <!-- ESQUERDA -->
    <section class="content-left">
        <div class="panel">
            <h3>${chamado.titulo}</h3>

            <p><strong>Status:</strong> ${chamado.status}</p>
            <p><strong>Prioridade:</strong> ${chamado.prioridade}</p>
            <p><strong>Categoria:</strong> ${chamado.categoria.nome}</p>
            <p><strong>Serviço:</strong> ${chamado.servico.nome}</p>

            <label>Descrição:</label>
            <div class="textarea">
                ${chamado.descricao}
            </div>

            <c:if test="${not empty chamado.anexos}">
                <label>Anexos:</label>
                <ul>
                    <c:forEach var="a" items="${chamado.anexos}">
                        <li><a href="/chamados/anexo/${a.id}" target="_blank">${a.nome}</a></li>
                    </c:forEach>
                </ul>
            </c:if>
        </div>

        <!-- INTERAÇÕES -->
        <div class="panel">
            <h3>Interações</h3>

            <c:forEach var="i" items="${interacoes}">
                <div class="textarea small">
                    <strong>${i.autor.nome}</strong> <br>
                    <small>${i.data}</small><br>
                    ${i.mensagem}
                </div>
            </c:forEach>

            <c:if test="${empty interacoes}">
                <p>Nenhuma interação registrada.</p>
            </c:if>
        </div>
    </section>

    <!-- DIREITA -->
    <aside class="sidebar-right">
        <div class="panel small">
            <h4>Ações</h4>

            <!-- ADICIONAR COMENTÁRIO -->
            <form method="post" action="/chamados/${chamado.id}/comentario">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <button class="btn primary full">Adicionar Comentário</button>
            </form>

            <!-- EDITAR -->
            <a class="btn outline full" href="/chamados/${chamado.id}/editar">Editar Chamado</a>

            <!-- EXCLUIR -->
            <form method="post" action="/chamados/${chamado.id}/delete">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <button class="btn danger full">Excluir Chamado</button>
            </form>
        </div>
    </aside>

</main>

</body>
</html>
