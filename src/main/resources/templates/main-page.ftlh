<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<h3>Угадай число</h3>
<#if number??>
    <#if answer??>
        <h4>${answer}</h4>
    </#if>
    Ваша цифра: ${guess} ?
    <form action="/" method="get">
        <input type="text" hidden="hidden" name="number_to_guess" value="${number}">
        <input type="radio" name="check" value="Больше">Больше
        <input type="radio" name="check" value="Меньше">Меньше
        <input type="radio" name="check" value="Равно">Равно
        <input type="submit" value="Проверить">
    </form>
<#else>
    <form action="/" method="get">
        Введите число от 0 до 100: <input type="number" placeholder="Число" name="number_to_guess">
        <input type="submit" value="Отправить">
    </form>
</#if>
<hr>
<h3>Анкета</h3>
<#if user??>
    ФИО: ${user.fio}<br>
    Телефон: ${user.phone}<br>
    Почта: ${user.email}<br>
    Возраст: ${user.age}<br>
<#else>
    <form action="/" method="post">
        <input type="text" placeholder="ФИО" name="fio" required="required"><br><br>
        <input type="number" placeholder="Телефон" name="phone" required="required"><br><br>
        <input type="text" placeholder="Почта" name="email" required="required"><br><br>
        <input type="number" placeholder="Возраст" name="age" required="required"><br><br>
        <input type="submit" value="Отправить">
    </form>
</#if>
<hr>
<h3>Вычисление чисел</h3>
<form action="/" method="get">
    <input type="number" name="first_number" placeholder="Первое число" required="required">
    <input type="number" name="second_number" placeholder="Второе число" required="required">
    <input type="number" name="third_number" placeholder="Третье число" required="required">
    <input type="radio" name="math_action" checked="checked" value="max">Максимальное
    <input type="radio" name="math_action" value="min">Минимальное
    <input type="radio" name="math_action" value="avg">Среднеарифметическое
    <input type="submit" value="Отправить"><br><br>
</form>
<#if final_number??>
    Полученное число = ${final_number}
</#if>
</body>
</html>