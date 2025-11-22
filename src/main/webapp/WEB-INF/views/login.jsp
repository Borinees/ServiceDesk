<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>Login - HelpDesk</title>

    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600;700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="/css/base.css">
    <link rel="stylesheet" href="/css/login.css">

</head>
<body class="login-body">

<main class="login-wrap">
    <div class="login-card">

        <h1 class="brand">HelpDesk</h1>
        <p class="subtitle">Bem-vindo de volta!<br>Faça login para continuar.</p>

        <form method="post" action="${pageContext.request.contextPath}/login">

            <label class="field-label">Email</label>
            <input class="input" name="username" type="email"
                   placeholder="seu.email@exemplo.com" required />

            <label class="field-label">Senha</label>
            <input class="input" name="password" type="password"
                   placeholder="●●●●●●" required />

            <a class="link-right" href="#">Esqueceu sua senha?</a>

            <button class="btn primary full" type="submit">Entrar</button>
        </form>

        <div class="divider">ou</div>

        <button class="btn outline full">Continuar com Google</button>
        <button class="btn dark full">Continuar com Apple</button>

        <p class="center small">Não tem uma conta? <a href="#">Cadastre-se</a></p>
    </div>
</main>

</body>
</html>
