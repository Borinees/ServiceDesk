<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>Gestão de Usuários - HelpDesk</title>

    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/css/base.css">
    <link rel="stylesheet" href="/css/forms.css">
    <link rel="stylesheet" href="/css/login.css">
</head>

<body class="app-body">

    <aside class="sidebar">
        <div class="sidebar-brand">Empresa XYZ</div>
        <nav>
            <ul>
                <li><a href="/dashboard">Dashboard</a></li>
                <li class="active">Gestão de Usuários</li>
                <li><a href="/chamados">Chamados</a></li>
            </ul>
        </nav>
    </aside>

    <header class="topbar">
        <h2>Gestão de Usuários</h2>

        <div class="top-actions">
            <a href="/usuarios/novo" class="btn primary">Adicionar Novo Usuário</a>
        </div>
    </header>

    <main class="main-area">

        <section class="content">

            <div class="panel">

                <!-- BUSCA -->
                <form method="get" action="/usuarios" class="search-row">
                    <input
                        class="input"
                        name="busca"
                        value="<c:out value='${param.busca}'/>"
                        placeholder="Buscar por nome, email ou ID..."
                    />
                    <button class="btn outline">Filtrar</button>
                </form>

                <!-- TABELA -->
                <table class="table">
                    <thead>
                    <tr>
                        <th></th>
                        <th>Nome</th>
                        <th>Email</th>
                        <th>Tipo</th>
                        <th>Empresa / Departamento</th>
                        <th>Status</th>
                        <th>Último Login</th>
                        <th>Ações</th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach var="u" items="${usuarios}">
                        <tr>
                            <td><input type="checkbox"></td>

                            <td><c:out value="${u.nome}"/></td>
                            <td><c:out value="${u.email}"/></td>
                            <td><c:out value="${u.tipoUsuario}"/></td>

                            <td>
                                <c:if test="${u.empresa != null}">
                                    <c:out value="${u.empresa}"/>
                                </c:if>
                                <c:if test="${u.departamento != null}">
                                    <c:out value="${u.departamento}"/>
                                </c:if>
                            </td>

                            <td>
                                <span class="tag ${u.ativo ? 'green' : 'red'}">
                                    <c:out value="${u.ativo ? 'Ativo' : 'Inativo'}"/>
                                </span>
                            </td>

                            <td>
                                <c:choose>
                                    <c:when test="${u.ultimoLogin != null}">
                                        <c:out value="${u.ultimoLogin}"/>
                                    </c:when>
                                    <c:otherwise>
                                        Nunca logou
                                    </c:otherwise>
                                </c:choose>
                            </td>

                            <td class="actions">

                                <a href="/usuarios/${u.id}/editar">✎</a>

                                <form method="post" action="/usuarios/${u.id}/delete" class="inline">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                                    <button class="link danger" title="Excluir">🗑</button>
                                </form>

                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                <!-- PAGINAÇÃO -->
                <div class="table-footer">

                    <form method="get" action="/usuarios">
                        Itens por página:
                        <select name="size" onchange="this.form.submit()">
                            <option value="10" <c:if test="${size == 10}">selected</c:if>>10</option>
                            <option value="20" <c:if test="${size == 20}">selected</c:if>>20</option>
                            <option value="50" <c:if test="${size == 50}">selected</c:if>>50</option>
                        </select>

                        <input type="hidden" name="busca" value="${param.busca}">
                        <input type="hidden" name="pagina" value="${pagina}">
                    </form>

                    <div class="muted small">
                        <c:out value="${start}"/> - <c:out value="${end}"/> de <c:out value="${total}"/> usuários
                    </div>

                    <div class="pagination">
                        <c:if test="${pagina > 1}">
                            <a href="/usuarios?pagina=${pagina - 1}&size=${size}">&lt; Anterior</a>
                        </c:if>

                        Página <c:out value="${pagina}"/>

                        <c:if test="${pagina < totalPaginas}">
                            <a href="/usuarios?pagina=${pagina + 1}&size=${size}">Próximo &gt;</a>
                        </c:if>
                    </div>

                </div>

            </div>

        </section>

    </main>

</body>
</html>
