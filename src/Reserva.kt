class Reserva(
    val idReserva: Int,
    val idHuesped: Int,
    val nombreHuesped: String,
    val emailHuesped: String,
    val numeroHabitacion: Int,
    val tipoHabitacion: String,
    val precioNoche: Double,
    val nochesReservadas: Int
) {
    fun montoTotal(): Double {
        return precioNoche * nochesReservadas
    }

    override fun toString(): String {
        return " \n ID RESERVA: $idReserva,\n ID DEL HUESPED: $idHuesped, \n NOMBRE DEL HUESPED: $nombreHuesped,\n EMAIL DEL HUESPED: $emailHuesped, \nNUMERO DE HABITACION: $numeroHabitacion, \n TIPO DE HABITACION: $tipoHabitacion,\n PRECIO POR NOCHE: $$precioNoche, \n NOCHES RESERVADAS EN TOTA: $nochesReservadas,\n COSTO TOTAL DE LA RESERVA: $${montoTotal()}"
    }

}