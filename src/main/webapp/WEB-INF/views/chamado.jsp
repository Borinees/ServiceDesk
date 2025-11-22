<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Chamado - HelpDesk</title>

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
                <li><a href="/dashboard">Dashboard</a></li>
                <li><a href="/usuarios">Gestão de Usuários</a></li>
                <li class="active"><a href="/chamados">Chamados</a></li>
            </ul>
        </nav>
    </aside>

    <!-- TOPBAR -->
    <header class="topbar">
        <h2>
            Chamado #${chamado.id}
            <span class="tag green">${chamado.status}</span>
            <span class="tag orange">${chamado.prioridade}</span>
        </h2>

        <div class="top-actions">
            Bem-vindo(a), ${usuarioLogado.nome}
        </div>
    </header>

    <!-- CONTEÚDO PRINCIPAL -->
    <main class="main-area two-column">

        <!-- COLUNA ESQUERDA -->
        <section class="content-left">

            <div class="panel">
                <h3>${chamado.titulo}</h3>

                <div class="field">
                    <label>Descrição do Chamado</label>
                    <div class="textarea">
                        ${chamado.descricao}
                    </div>
                </div>

                <!-- você não tem anexos no DTO → removido -->
            </div>

        </section>

        <!-- COLUNA DIREITA -->
        <aside class="sidebar-right">

            <!-- INFO DO CHAMADO -->
            <div class="panel small">
                <h4>Informações do Chamado</h4>

                <p><strong>Cliente:</strong> ${chamado.cliente.nome}</p>
                <p><strong>Email:</strong> ${chamado.cliente.email}</p>
                <p><strong>Empresa:</strong> ${chamado.cliente.empresa}</p>

                <p><strong>Técnico Responsável:</strong>
                    <c:choose>
                        <c:when test="${chamado.tecnico != null}">
                            ${chamado.tecnico.nome}
                        </c:when>
                        <c:otherwise>
                            Nenhum técnico atribuído
                        </c:otherwise>
                    </c:choose>
                </p>

                <p><strong>Categoria:</strong> ${chamado.categoria.nome}</p>
                <p><strong>Serviço:</strong> ${chamado.servico.nome}</p>

                <p><strong>Data de Abertura:</strong> ${chamado.dataAbertura}</p>
                <p><strong>Data de Fechamento:</strong> ${chamado.dataFechamento}</p>
            </div>

            <!-- AÇÕES -->
            <div class="panel small">
                <h4>Ações</h4>

                <form method="post" action="/chamados/${chamado.id}/comentario">
                    <button class="btn primary full">Adicionar Comentário</button>
                </form>

                <form method="post" action="/chamados/${chamado.id}/status">
                    <button class="btn outline full">Alterar Status</button>
                </form>

                <form method="post" action="/chamados/${chamado.id}/delete">
                    <button class="btn danger full">Excluir Chamado</button>
                </form>
            </div>

            <!-- HISTÓRICO / INTERAÇÕES -->
            <div class="panel small">
                <h4>Interações</h4>

                <c:forEach var="i" items="${chamado.interacoes}">
                    <div class="textarea small">
                        <strong>${i.autor.nome}</strong>
                        <br>
                        <small>${i.dataEnvio}</small>
                        <br>
                        ${i.mensagem}
                    </div>
                </c:forEach>

                <c:if test="${empty chamado.interacoes}">
                    <p>Nenhuma interação registrada.</p>
                </c:if>
            </div>

        </aside>
    </main>

</body>
</html>
