package rigoberto.lapaz.tecnm.glhf
import androidx.room.*
@Dao
interface JuegosDAO {
    @Query("SELECT * FROM Juego")
    fun getAll(): List<Juego>
    @Query("SELECT titulo FROM Juego")
    fun getNombres(): Array<String>
    @Query("SELECT * FROM Juego where titulo=:string")
    fun getJuego(string: String): Juego
    @Query("SELECT * FROM Juego WHERE estado=:estado")
    fun getLista(estado: Int): List<Juego>
    @Query("Update Juego SET estado=:estado WHERE id=:id")
    fun updateEstado(id:Int,estado:Int): Int
    /*@Query("SELECT * FROM Item WHERE nombre LIKE '%'+:name+'%'")
    fun findByName(name: String): List<Item>*/
}
