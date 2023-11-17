import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.kotlin.subscribeBy


fun main(args:Array<String>) {
    val observablePertama = Observable.just("satu","dua","tiga")
    val subscriberPertama = observablePertama.subscribe{
        println("Subscriber pertama\t: " +it)
    }

    val subscriberKedua = observablePertama.subscribe{
        println("Subscriber kedua\t: " +it)
    }

    val subscriberKetiga = observablePertama.subscribeBy(
        onNext = { println("Subscriber ketiga\t: " + it)},
        onComplete = { println("Selesai")},
        onError = { println("Gangguan")},
    )
}