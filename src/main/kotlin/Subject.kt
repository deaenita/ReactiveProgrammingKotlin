import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.subjects.AsyncSubject
import io.reactivex.rxjava3.subjects.BehaviorSubject
import io.reactivex.rxjava3.subjects.PublishSubject
import io.reactivex.rxjava3.subjects.ReplaySubject

fun main(args:Array<String>) {
    val subscriptions = CompositeDisposable()

    //val subject = PublishSubject.create<String>()
    //val subject = BehaviorSubject.create<String>()
    //val subject = ReplaySubject.createWithSize<String>(4)
    val subject = AsyncSubject.create<String>()

    subject.onNext("Satu")
    subject.onNext("Dua")
    subject.onNext("Tiga")

    val subcriberSatu = subject.subscribeBy (
        onNext = { println("S1:$it")},
    )
    subscriptions.add(subcriberSatu)
    subject.onNext("Empat")

    val subscriberDua = subject.subscribeBy(
        onNext = { println("S2:$it") }
    )
    subscriptions.add(subscriberDua)

    subject.onComplete()
    subscriptions.dispose()
}

