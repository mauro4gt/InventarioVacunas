# InventarioVacunas
Prueba Tecnica para Developer Bilingue Kruger

Las especificaciones del proyecto son que tiene dos tablas que se conectan de uno a uno hacen un join colum por el id 
la primera se llama Empleado donde guarda la informacion 
Cédula.
Nombres.
Apellidos.
Correo electrónico
Fecha de nacimiento.
Dirección de domicilio.
Teléfono móvil.
Estado de vacunación:

la segunda se llama vacuna guarda la informacion
Tipo de vacuna: 
Estos son los valores posibles
Sputnik, AstraZeneca, Pfizer y Jhonson&Jhonson
Fecha de vacunación.
Número de dosis.

Tiene una carpeta repository
Donde hace la interface y extiende del jpa

Tiene una carpeta service
Donde implementa la inteface los metodos para generar tanto registro borrado listado y editar la informacion

Tienes una carpeta rest
Donde consume estos servicios y genera el codigo post y get
Son una serie de metodos donde cumple las instrucciones dadas por la empresa kruger

La base de se genera solo debe tener una conexion directa con postgresql pgadmin para el caso seria prudente cambiar la clave al momento de montarla
en la computandora donde se quiera alojar 

Una vez iniciado es prudente cambiar en el archivo application.properties en la carpeta resources 
DE #spring.jpa.hibernate.ddl-auto=update
A #spring.jpa.hibernate.ddl-auto=create-drop
y volverla a cambiar esto al ejecutarlo una unica vez para las siguientes serguir como estaba ya al inicio eso solo para cargar la base
y que no se borre los datos si estuviera ingresandolos desde la base para pruebas
DE #spring.jpa.hibernate.ddl-auto=create-drop
A #spring.jpa.hibernate.ddl-auto=update

Sin mas que decir para verificar el servicio rest use postman sugiero eso para ver, ingresar, eliminar, editar

Espero les haya gustado disculpen mi forma de documentar por cuestiones de trabajo fue un poco improvisada

jaja

Saludos

