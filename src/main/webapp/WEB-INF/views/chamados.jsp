<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Chamados - HelpDesk</title>
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

<main class="main-area">

    <!-- FILTROS -->
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

    <!-- TABELA -->
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
                            ${chamado.status == 'ABERTO' ? 'yellow' :
                              chamado.status == 'EM_ANDAMENTO' ? 'blue' :
                              chamado.status == 'FECHADO' ? 'green' : 'gray'}">
                            ${chamado.status}
                        </span>
                    </td>

                    <td>
                        <span class="pill
                            ${chamado.prioridade == 'BAIXA' ? 'gray' :
                              chamado.prioridade == 'MEDIA' ? 'orange' :
                              chamado.prioridade == 'ALTA' ? 'red' :
                              chamado.prioridade == 'URGENTE' ? 'purple' : ''}">
                            ${chamado.prioridade}
                        </span>
                    </td>

                    <td>
                        <c:choose>
                            <c:when test="${chamado.tecnico != null}">${chamado.tecnico.nome}</c:when>
                            <c:otherwise>Não atribuído</c:otherwise>
                        </c:choose>
                    </td>

                    <td>
                        <fmt:formatDate value="${chamado.dataAbertura}" pattern="dd/MM/yyyy HH:mm" />
                    </td>

                    <td>
                        <fmt:formatDate value="${chamado.atualizadoEm}" pattern="dd/MM/yyyy HH:mm" />
                    </td>

                    <td class="actions">

                        <!-- VER -->
                        <a href="/chamados/${chamado.id}">🔍</a>

                        <!-- EDITAR -->
                        <a href="/chamados/${chamado.id}/editar">✎</a>

                        <!-- DELETE COM CSRF -->
                        <form method="post" action="/chamados/${chamado.id}/delete" style="display:inline;">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                            <button class="icon-button" onclick="return confirm('Excluir chamado?')">🗑</button>
                        </form>

                    </td>
                </tr>
            </c:forEach>
            </tbody>

        </table>
    </section>

</main>

</body>
</html>
