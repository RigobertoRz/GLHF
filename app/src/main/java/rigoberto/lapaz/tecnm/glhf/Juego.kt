package rigoberto.lapaz.tecnm.glhf

import androidx.room.*
import org.jetbrains.annotations.NotNull

var Juegolista = mutableListOf<Juego>()

val Juego_ID_EXTRA = "JuegoExtra"
@Entity
data class Juego (
    var titulo: String,
    var desarrolladora: String,
    var descripcion: String,
    var estado: Int,
    var rating: Int,
    @PrimaryKey @NotNull var id: Int,

    )
