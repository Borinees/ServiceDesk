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
    <link rel="stylesheet" href="/css/forms.css">
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
            Chamado #<c:out value="${chamado.id}"/>
            <span class="tag green"><c:out value="${chamado.status}"/></span>
            <span class="tag orange"><c:out value="${chamado.prioridade}"/></span>
        </h2>

        <div class="top-actions">
            Bem-vindo(a), <c:out value="${usuarioLogado.nome}"/>
        </div>
    </header>

    <!-- CONTEÚDO PRINCIPAL -->
    <main class="main-area two-column">

        <!-- COLUNA ESQUERDA -->
        <section class="content-left">

            <div class="panel">
                <h3><c:out value="${chamado.titulo}"/></h3>

                <div class="field">
                    <label>Descrição do Chamado</label>
                    <div class="textarea">
                        <c:out value="${chamado.descricao}"/>
                    </div>
                </div>

            </div>

        </section>

        <!-- COLUNA DIREITA -->
        <aside class="sidebar-right">

            <!-- INFO DO CHAMADO -->
            <div class="panel small">
                <h4>Informações do Chamado</h4>

                <p><strong>Cliente:</strong> <c:out value="${chamado.cliente.nome}"/></p>
                <p><strong>Email:</strong> <c:out value="${chamado.cliente.email}"/></p>
                <p><strong>Empresa:</strong> <c:out value="${chamado.cliente.empresa}"/></p>

                <p><strong>Técnico Responsável:</strong>
                    <c:choose>
                        <c:when test="${chamado.tecnico != null}">
                            <c:out value="${chamado.tecnico.nome}"/>
                        </c:when>
                        <c:otherwise>
                            Nenhum técnico atribuído
                        </c:otherwise>
                    </c:choose>
                </p>

                <p><strong>Categoria:</strong> <c:out value="${chamado.categoria.nome}"/></p>
                <p><strong>Serviço:</strong> <c:out value="${chamado.servico.nome}"/></p>

                <p><strong>Data de Abertura:</strong> <c:out value="${chamado.dataAbertura}"/></p>
                <p><strong>Data de Fechamento:</strong> <c:out value="${chamado.dataFechamento}"/></p>
            </div>

            <!-- AÇÕES -->
            <div class="panel small">
                <h4>Ações</h4>

                <form method="post" action="/chamados/${chamado.id}/comentario">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    <button class="btn primary full">Adicionar Comentário</button>
                </form>

                <form method="post" action="/chamados/${chamado.id}/status">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    <button class="btn outline full">Alterar Status</button>
                </form>

                <form method="post" action="/chamados/${chamado.id}/delete">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    <button class="btn danger full">Excluir Chamado</button>
                </form>
            </div>

            <!-- HISTÓRICO / INTERAÇÕES -->
            <div class="panel small">
                <h4>Interações</h4>

                <c:forEach var="i" items="${chamado.interacoes}">
                    <div class="textarea small">
                        <strong><c:out value="${i.autor.nome}"/></strong>
                        <br>
                        <small><c:out value="${i.dataEnvio}"/></small>
                        <br>
                        <c:out value="${i.mensagem}"/>
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
