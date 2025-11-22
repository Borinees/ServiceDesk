<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">

    <title>Dashboard - HelpDesk</title>

    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/css/base.css">
    <link rel="stylesheet" href="/css/login.css">

</head>

<body class="app-body">

<!-- SIDEBAR -->
<aside class="sidebar">
    <div class="sidebar-brand">Empresa XYZ</div>

    <nav>
        <ul>
            <li class="active">Dashboard</li>

            <li><a href="${pageContext.request.contextPath}/usuarios">Gestão de Usuários</a></li>
            <li><a href="${pageContext.request.contextPath}/chamados">Listagem de Chamados</a></li>

            <li>Relatórios</li>
            <li>Configurações</li>
        </ul>
    </nav>

    <div class="sidebar-footer">
        ${usuarioNome != null ? usuarioNome : "Usuário"} <br>
        <a class="small muted" href="${pageContext.request.contextPath}/logout">Sair</a>
    </div>
</aside>

<!-- TOPBAR -->
<header class="topbar">
    <h2>Dashboard</h2>

    <div class="top-actions">
        Bem-vindo(a), ${usuarioNome != null ? usuarioNome : "Usuário"}
    </div>
</header>

<!-- MAIN -->
<main class="main-area">
    <section class="cards-grid">

        <div class="card large">
            <h4>Chamados Abertos</h4>
            <div class="big-number">${chamadosAbertos != null ? chamadosAbertos : 0}</div>
            <a class="muted small" href="${pageContext.request.contextPath}/chamados">Ver todos</a>
        </div>

        <div class="card">
            <h4>Chamados em Andamento</h4>
            <div class="big-number">${chamadosAndamento != null ? chamadosAndamento : 0}</div>
        </div>

        <div class="card">
            <h4>Concluídos (7 dias)</h4>
            <div class="big-number">${concluidosSemana != null ? concluídosSemana : 0}</div>
        </div>

        <div class="card">
            <h4>Tempo Médio de Resposta</h4>
            <div class="stat">
                ${tempoRespostaMedio != null ? tempoRespostaMedio : "—"}
            </div>
        </div>

        <div class="card">
            <h4>Chamados por Prioridade</h4>
            <div class="muted small">(gráfico futuramente)</div>
        </div>

        <div class="card">
            <h4>Últimos Chamados Abertos</h4>

            <ul class="muted small">
                <c:forEach var="c" items="${ultimosChamados}">
                    <li>#${c.id} - ${c.titulo}</li>
                </c:forEach>

                <c:if test="${empty ultimosChamados}">
                    <li>Nenhum chamado recente.</li>
                </c:if>
            </ul>
        </div>

    </section>
</main>

</body>
</html>
