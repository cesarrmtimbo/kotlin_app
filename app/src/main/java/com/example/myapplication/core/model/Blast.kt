import kotlinx.serialization.Serializable

@Serializable
class Blast(
    var title: String = "",
    var msg: String = "",
    private var details: String = "",
    private var errorDetails: String = "", // Para armazenar detalhes do erro em forma de string
    private var heap: String? = null
) : Exception() {

    override val message: String?
        get() = msg

    // Métodos modificados
    fun heap(heap: String): Blast {
        this.heap = heap
        return this
    }

    fun getHeap(): String {
        return heap ?: ""
    }

    fun setErrorDetails(throwable: Throwable): Blast {
        this.errorDetails = "${throwable::class.simpleName}: ${throwable.message}"
        return this
    }

    fun getErrorDetails(): String {
        return errorDetails
    }

    fun details(details: String): Blast {
        this.details = details
        return this
    }

    fun title(title: String): Blast {
        this.title = title
        return this
    }

    fun msg(msg: String): Blast {
        this.msg = msg
        return this
    }
}
