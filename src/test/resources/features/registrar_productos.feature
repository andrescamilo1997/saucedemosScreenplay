#language:es

Característica: Registro de productos

  Escenario: Usuario bloqueado intenta iniciar sesión
    Cuando que el usuario "locked_out_user" está bloqueado
    Entonces el sistema debería mostrar un mensaje de error "Epic sadface: Sorry, this user has been locked out."

  Escenario: Registrar un nuevo producto
    Dado que el usuario "standard_user" está en la página de registro de productos
    Cuando el usuario ingresa los productos al carrito: "Sauce Labs Backpack" 
    Entonces el producto debería ser registrado exitosamente
    Y el sistema debería mostrar un mensaje de confirmación "Thank you for your order!"