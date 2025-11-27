<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width,initial-scale=1">
  <title>Abrir Novo Chamado - HelpDesk</title>
  <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600;700&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="/css/base.css">
  <link rel="stylesheet" href="/css/forms.css">
  <link rel="stylesheet" href="/css/login.css">
</head>

<body class="app-body form-page">

  <aside class="sidebar">
    <div class="sidebar-brand">Empresa XYZ</div>

    <nav>
      <ul>
        <li><a href="/dashboard">Dashboard</a></li>
        <li><a href="/usuarios">Gestão de Usuários</a></li>
        <li><a href="/chamados">Chamados</a></li>
      </ul>
    </nav>
  </aside>

  <header class="topbar">
    <h2>Abrir Novo Chamado</h2>
  </header>

  <main class="main-area">
    <section class="content">

      <!-- FORM PARA CRIAR CHAMADO -->
      <form class="panel form-panel" method="post" action="/chamados/novo" enctype="multipart/form-data">

        <!-- CSRF PROTECTION -->
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

        <!-- TÍTULO -->
        <label>Assunto do Chamado <span class="required">***</span></label>
        <input class="input" name="titulo" required />

        <!-- CATEGORIA -->
        <label>Categoria <span class="required">***</span></label>
        <select class="input" name="categoriaId" required>
          <option value="">Selecione...</option>

          <c:forEach var="cat" items="${categorias}">
            <option value="${cat.id}">${cat.nome}</option>
          </c:forEach>

        </select>

        <!-- PRIORIDADE -->
        <label>Prioridade <span class="required">***</span></label>
        <div class="radio-row">
          <label><input type="radio" name="prioridade" value="BAIXA" required> Baixa</label>
          <label><input type="radio" name="prioridade" value="MEDIA"> Média</label>
          <label><input type="radio" name="prioridade" value="ALTA"> Alta</label>
          <label><input type="radio" name="prioridade" value="URGENTE"> Urgente</label>
        </div>

        <!-- DESCRIÇÃO -->
        <label>Descrição Detalhada <span class="required">***</span></label>
        <textarea class="textarea" name="descricao" required></textarea>

        <!-- ANEXOS -->
        <label>Anexar Arquivos (Opcional)</label>
        <input type="file" name="anexos" multiple class="input" />

        <!-- BOTÕES -->
        <div class="form-actions">
          <a href="/chamados" class="btn">Cancelar</a>
          <button type="submit" class="btn primary">Enviar Chamado</button>
        </div>

      </form>

    </section>
  </main>

</body>
</html>
