# Tarea 2: Desarrollo Orientado a Objetos
## Alumnos:

- **Agustín Salgado Espinoza**
- **Ignacio Silva Vera**
- **Juan Pablo Nuñez Toloza**

Nuevas clases:

InvitadoExteerno: Nueva clase para invitar externos, utiliza la interfaz invitable para poder ser invitado y tiene como propiedades nombres,apellidos y correo electronico.

Informe: Nueva clase para generar un informe sobre la reunion, este anota multiples datos sobre la misma.

Cambios en uml original: 

Departamento: Se añadio una propiedad, la cual es una lista de empleados se utilizo para englobar todos los empleados del departamento, ademas se agrego el metodo "agregarempleado" para añadir empleados a la lista

Empleado: Se añadio la propiedas "Departamento" para asociarlo a su asociacion

Nota: Se añadio una propiedad instant, esta se utiliza para comparar el momento de creacion de las notas para poder compararlas cronologicamente.

Asistencia: Se utilizo 3 propiedades, "empleado","horaLLegada" y "asistio", estas se utilizan para evaluar al empleado, si asistio y si llego a la hora adecuada.

Reunion: Se añadieron listas como propiedades para poder organizar de manera optima los datos, tambien se añadieron metodos para las mismas.

Invitacion: Se añadieron propiedas para ver a quien se invita y la reunion a la cual se le invita.
