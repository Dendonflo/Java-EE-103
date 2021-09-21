<!doctype html>
<html lang="fr">
<head>
  <meta charset="utf-8">
  <title>Titre de la page</title>
  <!--<link rel="stylesheet" href="style.css">
  <script src="script.js"></script>-->
</head>
<body>
  <%@ page import="web.Bag" %>
  <% 
    out.println("<h1>sac</h1>");
    Bag myBag = (Bag) request.getAttribute("bag");
        if(myBag != null){
          myBag.print(out);}         
  %>

    <form method="POST" action="bag">
      <input type="text" name="ref" value="Reference">
      <input type="text" name="qty" value="Quantite">
      <input type="submit" value="envoyer">
    </form>
</body>
</html>