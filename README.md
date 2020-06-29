I Proyecto Programado


Las y los estudiantes , agrupados en parejas de trabajo, deberán modelar y programar
un sistema de alimentación personalizada. Dicho sistema permite a sus clientes
configurar un perfil alimentario, de modo que el sistema pueda recomendar platillos
tomando en cuenta los gustos y necesidades particulares de cada persona.


El proceso de diseño y toma de decisiones técnicas es fundamental para este
proyecto. No hay una única solución posible. Las parejas de trabajo deben suponer
que tras una reunión con los interesados del proyecto se tomaron las siguientes
notas según los distintos actores identificados:

Cliente

	1. Registrarse como Cliente.
	
	2. Ingresar al Sistema con nombre de usuario y contraseña.
	
	3. Ver un menú de opciones a realizar.
	
	4. Registrarse direcciones para recibir pedidos.
		a. Nombre (ejemplo Casa)
		b. Latitud
		c. Longitud.
		
	5.Completar Perfil Alimentario. Consiste en una serie de posibles necesidades/gustos especiales de cada cliente, por ejemplo:
		a. Vegan@.
		b. Vegetariano@.
		c. Libre de Gluten.
		d. Halal.
		e. Kosher.
		f. Alergias o intolerancias a ingredientes.
		
	6. Solicitar menú del día y ver detalle de la orden (precio a pagar)
		a. Indicar si se quiere proceder con la orden de compra de ese menú o no.

Cociner@

	1. Registrarse como Cociner@.
	2. Ingresar al Sistema con nombre de usuario y contraseña.
	3. Ver un menú de opciones a realizar.
	4. Agregar platillos al sistema. Los platillos pueden ser entradas, platos principales, postres y bebidas.
	
	Cada platillo indica sus ingredientes, la cantidad por unidad y las instrucciones de preparación, como muestra el siguiente ejemplo.
	
	Spaghetti al Burro.
		- Spaghetti 50 gramos.
		- Mantequilla 50 gramos.
		- Salvia blanca 15 hojas.
		- Limón 1 unidad.
		- Sal 1 pizca.
	Hervir agua, salar y cocinar spaghetti. Freír salvia en la mantequilla. Servir salvia sobre spaghetti y agregar jugo de limón.
	
	5. Ver inventario de ingredientes.
	
	6. Agregar ingrediente y cantidad disponible al inventario. Así como el costo según la unidad (kilogramo, unidad, cucharada,etc). 
	
	
Administrador(a)

	1. Registrarse como Administrador(a).
	
	2. Ingresar al Sistema con nombre de usuario y contraseña.
	
	3. Ver un menú de opciones a realizar.
	
	4. Agregar ingrediente al inventario con su respectivo costo, cantidad y unidad.
	
	
Sistema

	- Almacenar información de usuarios.
	- Ofrecer un menú general, con las opciones de ingreso y registro.
	- Al realizarse el registro de un usuario, la contraseña deberá cifrarse con EncoderBase64 de Java antes de almacenarse.
	- Al intentar ingresar al sitio se deberá comparar la contraseña con aquella almacenada. (considerar el cifrado).
	- Generar una opción de menú para el cliente que solicite, esto tomando en cuenta el perfil alimentario del cliente. Por ejemplo, no se podrá incluir en 	los menús de un cliente vegano, platillos con ingredientes de origen animal, ni tampoco ningún platillo con tomate, a un cliente que sea alérgico al mismo.
	- Calcular el precio a pagar de la orden de compra del menú, tomando en cuenta la suma del precio de cada ingrediente según su cantidad, más 35% de 		ganancia dela plataforma y un 13% de I.V.A


Modelado con UML

En el contexto anterior, modele un sistema que incluya todas las funcionalidades mencionadas, realice para esto un diagrama de casos de uso, un diagrama de clases y un diagrama de secuencia (para cada acción del cliente en el sistema).


Programa Java

A partir de los diagramas realizados, escriba un programa en Java SE versión 8 o superior en el que se puedan realizar todas las acciones descritas en esta especificación. La interacción con el sistema deberá realizarse a través de la consola interactiva. El programa deberá cargar la información del sistema de un archivo JSon, este archivo deberá contener al menos 3 clientes, 20 ingredientes y 10 platillos, para realizar pruebas. Si en el programa se agregan elementos también deberán agregarse el archivo que contiene la información.


Video Explicativo

Una vez finalizados sus diagramas en formato UML y todas las clases necesarias para que el sistema funcione. Realice un video, capturando la pantalla de su computadora. Primero explique el diagrama de clases y después haga un recorrido por el código explicándolo también. Finalmente muestre una ejecución exitosa del código. El video deberá ser de entre 5 y 10 minutos. Cada estudiante deberá realizar su propio video y publicarlo a través de YouTube.

