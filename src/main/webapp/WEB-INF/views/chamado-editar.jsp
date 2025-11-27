<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Editar Chamado - HelpDesk</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/css/base.css">
    <link rel="stylesheet" href="/css/forms.css">
    <link rel="stylesheet" href="/css/chamado.css">


</head>

<body class="app-body">

<aside class="sidebar">
    <div class="sidebar-brand">Empresa XYZ</div>
    <nav>
        <ul>
            <li><a href="/dashboard">Dashboard</a></li>
            <li><a href="/usuarios">Gestão de Usuários</a></li>
            <li><a href="/chamados" class="active">Chamados</a></li>
        </ul>
    </nav>
</aside>

<header class="topbar">
    <h2>Editar Chamado #${chamado.id}</h2>
</header>

<main class="main-area">
    <section class="content">

        <form class="panel form-panel" method="post" action="/chamados/${chamado.id}/editar">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

            <label>Título</label>
            <input class="input" name="titulo" value="${chamado.titulo}" required>

            <label>Status</label>
            <select class="input" name="status" required>
                <option ${chamado.status == 'ABERTO' ? 'selected' : ''}>ABERTO</option>
                <option ${chamado.status == 'EM_ANDAMENTO' ? 'selected' : ''}>EM_ANDAMENTO</option>
                <option ${chamado.status == 'FECHADO' ? 'selected' : ''}>FECHADO</option>
            </select>

            <label>Prioridade</label>
            <select class="input" name="prioridade" required>
                <option ${chamado.prioridade == 'BAIXA' ? 'selected' : ''}>BAIXA</option>
                <option ${chamado.prioridade == 'MEDIA' ? 'selected' : ''}>MEDIA</option>
                <option ${chamado.prioridade == 'ALTA' ? 'selected' : ''}>ALTA</option>
                <option ${chamado.prioridade == 'URGENTE' ? 'selected' : ''}>URGENTE</option>
            </select>

            <label>Descrição</label>
            <textarea class="textarea" name="descricao">${chamado.descricao}</textarea>

            <div class="form-actions">
                <a href="/chamados/${chamado.id}" class="btn">Cancelar</a>
                <button type="submit" class="btn primary">Salvar Alterações</button>
            </div>
        </form>

    </section>
</main>

</body>
</html>
