<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Chamados - HelpDesk</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/css/base.css">
    <link rel="stylesheet" href="/css/chamado.css">
    <link rel="stylesheet" href="/css/form.css">

</head>
<body class="app-body">

<!-- SIDEBAR -->
<aside class="sidebar">
    <div class="sidebar-brand">Empresa XYZ</div>
    <nav>
        <ul>
            <li><a href="/dashboard">Dashboard</a></li>
            <li><a href="/usuarios">Gestão de Usuários</a></li>
            <li class="active">Chamados</li>
        </ul>
    </nav>
</aside>

<!-- TOPBAR -->
<header class="topbar">
    <h2>Chamados</h2>
    <div class="top-actions">
        <a href="/chamados/novo" class="btn primary">Novo Chamado</a>
    </div>
</header>

<!-- FILTROS -->
<main class="main-area">
    <section class="panel filters">
        <form method="get" action="/chamados" class="filter-row">
            <input class="input" name="busca" placeholder="Buscar Chamado..." />
            <select class="input" name="status">
                <option value="">Status: Todos</option>
                <option value="ABERTO">Aberto</option>
                <option value="EM_ANDAMENTO">Em Andamento</option>
                <option value="FECHADO">Fechado</option>
            </select>
            <select class="input" name="prioridade">
                <option value="">Prioridade: Todas</option>
                <option value="BAIXA">Baixa</option>
                <option value="MEDIA">Média</option>
                <option value="ALTA">Alta</option>
                <option value="URGENTE">Urgente</option>
            </select>
            <select class="input" name="tecnico">
                <option value="">Atribuído a: Qualquer</option>
                <c:forEach var="t" items="${tecnicos}">
                    <option value="${t.id}">${t.nome}</option>
                </c:forEach>
            </select>
            <input class="input small" type="date" name="inicio" />
            <input class="input small" type="date" name="fim" />
            <button type="submit" class="btn outline">Filtrar</button>
        </form>
    </section>

    <!-- TABELA DE CHAMADOS -->
    <section class="panel table-panel">
        <table class="table">
            <thead>
            <tr>
                <th>ID do Chamado</th>
                <th>Assunto</th>
                <th>Status</th>
                <th>Prioridade</th>
                <th>Atribuído a</th>
                <th>Criado em</th>
                <th>Última Atualização</th>
                <th>Ações</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="chamado" items="${chamados}">
                <tr>
                    <td>#${chamado.id}</td>
                    <td>${chamado.titulo}</td>
                    <td>
                            <span class="pill
                                <c:choose>
                                    <c:when test="${chamado.status == 'ABERTO'}">yellow</c:when>
                        <c:when test="${chamado.status == 'EM_ANDAMENTO'}">blue</c:when>
                        <c:when test="${chamado.status == 'FECHADO'}">green</c:when>
                        <c:otherwise>gray</c:otherwise>
                        </c:choose>
                        ">
                        ${chamado.status}
                        </span>
                    </td>
                    <td>
                            <span class="pill
                                <c:choose>
                                    <c:when test="${chamado.prioridade == 'BAIXA'}">gray</c:when>
                        <c:when test="${chamado.prioridade == 'MEDIA'}">orange</c:when>
                        <c:when test="${chamado.prioridade == 'ALTA'}">red</c:when>
                        <c:when test="${chamado.prioridade == 'URGENTE'}">purple</c:when>
                        </c:choose>
                        ">
                        ${chamado.prioridade}
                        </span>
                    </td>
                    <td>${chamado.tecnico != null ? chamado.tecnico.nome : 'Não atribuído'}</td>
                    <td>${chamado.dataAbertura}</td>
                    <td>${chamado.atualizadoEm}</td>
                    <td class="actions">
                        <a href="/chamados/${chamado.id}">🔍</a>
                        <a href="/chamados/${chamado.id}/editar">✎</a>
                        <a href="/chamados/${chamado.id}/delete">🗑</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </section>
</main>
</body>
</html>
