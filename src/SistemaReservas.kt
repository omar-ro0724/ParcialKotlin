
class SistemaReservas {
    private val reservas = mutableListOf<Reserva>()
    private var contador = 1

    fun agregarReserva(idHuesped: Int, nombreHuesped: String, emailHuesped: String, numeroHabitacion: Int, tipoHabitacion: String, precioNoche: Double, nochesReservadas: Int) {
        if (reservas.any { it.numeroHabitacion == numeroHabitacion }) {
            println("ERROR LA HABITAION $numeroHabitacion ESTA OCUPADA")
            return
        }
        val nuevaReserva = Reserva(contador++, idHuesped, nombreHuesped, emailHuesped, numeroHabitacion, tipoHabitacion, precioNoche, nochesReservadas)
        reservas.add(nuevaReserva)
        println("RESERVA REALIZADA CON EXITO: $nuevaReserva")
    }

    fun listarReservas() {
        if (reservas.isEmpty()) {
            println("NO HAY RESERVAS REGISTRADAS")
        } else {
            println("LISTA DE RESERVAS:")
            reservas.forEach { println(it) }
        }
    }

    fun eliminarReserva(id: Int) {
        val reserva = reservas.find { it.idReserva == id }
        if (reserva != null) {
            reservas.remove(reserva)
            println("RESERVA ELIMINADA")
        } else {
            println("NO SE ENCONTRO EL NUMERO DE RESERVA $id.")
        }
    }

    fun mostrarMenu() {
        do {
            println(" MENU ")
            println("1. AGREGAR RESERVA")
            println("2. LISTAR RESERVA")
            println("3. ELIMINAR RESERVA")
            println("4. SALIR")
            print("ELIJA UNA OPCION: ")

            when (readLine()?.toIntOrNull()) {
                1 -> {
                    print("INGRESE ID DEL HUESPED: ")
                    val idHuesped = readLine()?.toIntOrNull() ?: continue
                    print("INGRESE NOMBRE DEL HUESPED: ")
                    val nombreHuesped = readLine().orEmpty()
                    print("INGRESE EMAIL DEL HUESPED: ")
                    val emailHuesped = readLine().orEmpty()
                    print("INGRESE NUMERO DE HABITACION: ")
                    val numeroHabitacion = readLine()?.toIntOrNull() ?: continue
                    print("INGRESE TIPO DE HABITACION: ")
                    val tipoHabitacion = readLine().orEmpty()
                    print("INGRESE PRECIO POR NOCHE: ")
                    val precioNoche = readLine()?.toDoubleOrNull() ?: continue
                    print("INGRESE CANTIDAD DE NOCHES DE RESERVA: ")
                    val nochesReservadas = readLine()?.toIntOrNull() ?: continue

                    agregarReserva(idHuesped, nombreHuesped, emailHuesped, numeroHabitacion, tipoHabitacion, precioNoche, nochesReservadas)
                }
                2 -> listarReservas()
                3 -> {
                    print("INGRESE EL ID DE LA RESERVA A ELIMINAR: ")
                    val id = readLine()?.toIntOrNull()
                    if (id != null) {
                        eliminarReserva(id)
                    } else {
                        println("ID INVALIDO.")
                    }
                }
                4 -> {
                    println("SALIENDO ")
                    break
                }
                else -> println("OPCION NO VALIDO INTENTE NUEVAMENTE")
            }
        } while (true)
    }
}