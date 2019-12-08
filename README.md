# AREP-Corte3: Taller practico de Disponibilidad y Desempeño

## Introduccion
Usted ha sido contratado para capacitar un grupo de ingenieros en la implementación de soluciones elásticas y de alto desempeño. Para esto usted debe construir un tutorial que les permita construir y demostrar las capacidades de autoescalamiento de Amazon Web Services.

Construya un taller que le permita a los ingenieros crear una solución autoescalable en EC2 y en la que puedan demostrar que el sistema efectivamente escala bajo condiciones determinadas de carga.

EN este taller se utilizara un servicio ESB con service mix, para implementar una cola de mensajeria entre un cliente y un servidor.

## Arquitectura de ServiceMix
![](https://github.com/Martin9958/Arep-EBS/blob/master/imagenes/servicemix.png)

## Arquitectura Implementada
![](https://github.com/Martin9958/Arep-EBS/blob/master/imagenes/modelo.png)

## Imagenes del Resultado

- Resultados de la ejecucion en Local

Productor enviando el mensaje

![](https://github.com/Martin9958/Arep-EBS/blob/master/imagenes/A9.PNG)

Consumidor recibiendo el mensaje

![](https://github.com/Martin9958/Arep-EBS/blob/master/imagenes/A10.PNG)

- Proceso de configuracion en EC2 servicio de AWS

![](https://github.com/Martin9958/Arep-EBS/blob/master/imagenes/A1.PNG)

![](https://github.com/Martin9958/Arep-EBS/blob/master/imagenes/A2.PNG)

![](https://github.com/Martin9958/Arep-EBS/blob/master/imagenes/A3.PNG)

![](https://github.com/Martin9958/Arep-EBS/blob/master/imagenes/A4.PNG)

![](https://github.com/Martin9958/Arep-EBS/blob/master/imagenes/A5.PNG)

![](https://github.com/Martin9958/Arep-EBS/blob/master/imagenes/A6.PNG)

![](https://github.com/Martin9958/Arep-EBS/blob/master/imagenes/A7.PNG)

- Configuracion de un nuevo service Group que permita tener los puertos abiertos para la conexion, la idea es dejar abierto el puerto 61616 para la conexion

![](https://github.com/Martin9958/Arep-EBS/blob/master/imagenes/A8.PNG)

- Resultados de la ejecucion sobre el servicio de AWS

![](https://github.com/Martin9958/Arep-EBS/blob/master/imagenes/A11.PNG)

![](https://github.com/Martin9958/Arep-EBS/blob/master/imagenes/A12.PNG)

## Uso del EC2 Para Auto Scaling

1. Para utilizar Amazon EC2 Auto Scaling,se debe utilizar determinados componentes basicos para empezar, iniciando con la creacion de una plantilla de lanzamiento la cual especificara el tipo de instancia EC2 que se creara automaticamente.Para la creacion es necesario entrar a la consola de EC2 y escoger la region de AWS a la cual se asociaran los recursos, una vez escogido seleccione Launch Templates y elija la opcion Create Launch Template:

![](https://github.com/Martin9958/AREP-Corte3/blob/master/imagenes/IM1.png)

2. Seleccione en AMI ID la version de Amazon Linux 2 y el tipo de instancia la cual es t2.micro, dele nombre a las llaves que se generan y seleccione como red VPC.

3. Elija Create launch template (Crear plantilla de lanzamiento).En la página de confirmación, seleccione Create Auto Scaling group (Crear grupo de Auto Scaling).

4. Ahora se tiene que crear un grupo de Auto Scaling, en el paso Configure Auto Scaling group details (Configurar los detalles del grupo de Auto Scaling)

5. Para configurar los dellates del grupo de Auto Scaling. En Group name (Nombre del grupo), escriba un nombre para el grupo de Auto Scaling (por ejemplo, my-first-asg).

![](https://github.com/Martin9958/AREP-Corte3/blob/master/imagenes/IM2.png)

6. En Launch template version (Versión de plantilla de lanzamiento), decida si el grupo de Auto Scaling utiliza el valor predeterminado, la última versión o la versión específica de la plantilla de lanzamiento para escalado ascendente.

7. En Fleet Composition (Composición de la flota), elija Adhere to the launch template (Adherirse a la plantilla de lanzamiento).Mantenga Group size en el valor predeterminado: 1 instancia.

8. Mantenga Network (Red) en la VPC predeterminada de la región de AWS que ha elegido o seleccione su propia VPC.

9. Elija Next: Configure scaling policies (Siguiente: Configurar políticas de escalado).

10. En la página Configure scaling policies, seleccione Keep this group at its initial size y haga clic en Review.

11. En la página Review (Revisar), seleccione Create Auto Scaling group (Crear grupo de Auto Scaling).

12. En la página Auto Scaling group creation status (Estado de la creación del grupo de Auto Scaling), elija Close (Cerrar).

13. NOTA: Puede Verificar su grupo de Auto Scaling en la pestaña de detalles, en la parte de ACtivity History puede tener un vistazo del estatus de la instancia actual.

![](https://github.com/Martin9958/AREP-Corte3/blob/master/imagenes/IMG3.png)

![](https://github.com/Martin9958/AREP-Corte3/blob/master/imagenes/IMG4.png)

## Autor
- Andres Martin Cantor Urrego

## Conocimientos
- Maven y git
- Java
- AWS (EC2 Auto Scaling)
- Configuracion de Instancias y Grupos de seguridad en EC2
