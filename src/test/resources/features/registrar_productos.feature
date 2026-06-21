#language:es

Característica: Registro de productos

  Escenario: Usuario bloqueado intenta iniciar sesion
    Cuando que el usuario "locked_out_user" esta bloqueado
    Entonces el sistema deberia mostrar un mensaje de error "Epic sadface: Sorry, this user has been locked out."

  Escenario: Registrar un nuevo producto
    Dado que el usuario "standard_user" esta en la pagina de registro de productos
    Cuando el usuario ingresa los productos al carrito: "Sauce Labs Backpack" 
    Entonces el producto deberia ser registrado exitosamente
    Y el sistema deberia mostrar un mensaje de confirmacion "Thank you for your order!"