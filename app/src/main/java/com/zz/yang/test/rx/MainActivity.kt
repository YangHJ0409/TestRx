package com.zz.yang.test.rx

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.os.Looper
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.zz.yang.test.rx.algorithm.AlgorithmActivity
import com.zz.yang.test.rx.retrofit2.GithubClient
import com.zz.yang.test.rx.struct.StructActivity
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.FileOutputStream
import java.net.URL


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val structBtn = findViewById<Button>(R.id.btn_sturuct)
        structBtn.setOnClickListener {
            val intent = Intent(this, StructActivity::class.java)
            startActivity(intent)
        }

        val test01 = findViewById<Button>(R.id.test01)
        test01.text = "알고리즘::" + "플로이드"
        test01.setOnClickListener {
//            val kotlinTest = KotlinTest() //BFS
//            val kotlinTest = KotlinTest01() //DFS
//            val kotlinTest = KotlinTest02() //하노이
//            val kotlinTest = KotlinTest03() //백트래킹
//            val kotlinTest = KotlinTest04() //시뮬레이션
//            val kotlinTest = KotlinTest05() //투포인터
//            val kotlinTest = KotlinTest06() //이진탐색
//            val kotlinTest = KotlinTest07() //그리디
//            val kotlinTest = KotlinTest08() //DP
//            val kotlinTest = KotlinTest09() //MST
//            val kotlinTest = KotlinTest10() // 다익스트라
            val kotlinTest = KotlinTest11() //플로이드
//            kotlinTest.main(emptyArray());
//            val kotlinTest = KotlinTest12() //오답노트
            kotlinTest.main(emptyArray())
//            kotlinTest.solution(intArrayOf(1, 4, 2, 5, 3))

        }

        val test02 = findViewById<Button>(R.id.test02)
//        test02.text = "코루틴"
        test02.text = "RxKotlin::"
        test02.setOnClickListener {
//            val javaTest = JavaTest() //오답노트
//            assert_test()
//            assert_test2()
            assert_rx1()
        }

        findViewById<Button>(R.id.activity_01).setOnClickListener {
            val intent = Intent(MainActivity@this, TFirstActivity::class.java)
            startActivity(intent)
        }

        //복수의 Subject를 사용. 입력 받은 숫자 뒤에 문자열을 붙이는 작업
        val subject: Subject<String> = PublishSubject.create()
        val disposable = subject.subscribe({ value ->
            println("onNext::$value")
        }, { error -> error.printStackTrace()

        }, {
            println("onComplete::END")
        })


        val observer = object: Observer<Any> {
            override fun onSubscribe(d: Disposable) {
                println("onSubscribe::${d}")
            }

            override fun onError(e: Throwable) {
                e.printStackTrace()
            }

            override fun onComplete() {
                println("onComplete::END")
            }

            override fun onNext(t: Any) {
                println("onNext::${t.toString()}")
                subject.onNext(t.toString() + ", ")
            }
        }

        val subjectInt: Subject<Int> = PublishSubject.create()
        subjectInt.subscribe(observer)

        val subjectString: Subject<String> = PublishSubject.create()
        subjectString.subscribe(observer)

//        subject.observeOn(observer)

        //07월
        val btn01 = findViewById<Button>(R.id.btn01)
        btn01.text = "subjectInt.onNext(1)"
        btn01.setOnClickListener {
//            testBtn01()
            subjectInt.onNext(1)

        }

        val btn02 = findViewById<Button>(R.id.btn02)
        btn02.text = "subjectString.onNext(2)"
        btn02.setOnClickListener {
//            testBtn02()
            subjectString.onNext("2")
        }

        val btn03 = findViewById<Button>(R.id.btn03)
        btn03.text = "MVVM 테스트"
        btn03.findViewById<Button>(R.id.btn03).setOnClickListener {
//            testBtn03()
            testBtn04()
        }

        //08월
        val btn20 = findViewById<Button>(R.id.btn20)
        btn20.text = "알고리즘 Activity"
        btn20.setOnClickListener {
//            testBtn20()
            val intent = Intent(this, AlgorithmActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btn30).setOnClickListener {
            testBtn30()
        }
    }

    fun assert_test() {
        println("assert_test::START!!!")
        runBlocking {
//            println("start")
//            /** A Scope */
//            withContext(Dispatchers.IO) {
//                println("A Scope : I'am withContext, start!")
//                for (item in 0..1000) {
//                    println("A Scope : $item")
//                }
//            }
//            println("withContext End!")
//            /** B Scope */
//            CoroutineScope(Dispatchers.IO).launch{
//                println("B Scope : I'am CoroutineScope, start!")
//                for (item in 0..1000) {
//                    println("B Scope : $item")
//                }
//            }

//            launch {
//                println("launch 1")
//            }
//            println("2")
//            coroutineScope {
//                for(item in 4..100) {
//                    println("cS1 : $item")
//                }
//            }
//            CoroutineScope(Dispatchers.Default).launch{
//                for(item in 4..100) {
//                    println("CS : $item")
//                }
//            }
//            launch {
//                println("launch 2")
//            }
//            println("Hey!")
//            coroutineScope {
//                for(item in 4..100) {
//                    println("cS2 : $item")
//                }
//            }

//            /** A Scope */
//            CoroutineScope(Dispatchers.IO).launch {
//                launch {
//                    println("A Scope : I'am withContext, start!")
//                    for (item in 0..1000) {
//                        println("A Scope : $item")
//                    }
//                }.join()
//
//
//                launch {
//                    println("B Scope : I'am CoroutineScope, start!")
//                    for (item in 0..1000) {
//                        println("B Scope : $item")
//                    }
//                }
//            }

            /** A Scope */
            CoroutineScope(Dispatchers.IO).launch {

                getNetData11()
                getNetData22()
            }
        }
        println("assert_test::END!!!")
    }

    fun assert_test2() {
//        runBlocking {
//            val job = CoroutineScope(Dispatchers.IO).async {
//                println("assert_test22::Async start!!!")
//                "Async END"
//            }
//        val start = job.start()
//        println("assert_test22::start = $start")
//            val await = job.await()
//            println("assert_test22::await = $await")
//        }

        runBlocking {
            val deferred1: Deferred<Int> = CoroutineScope(Dispatchers.IO).async {
                //데이터 베이스, 웹데이터 수신 등 IO 처리
                100
            }
            val value1 = deferred1.await() //async.await()는 일시 중단이 가능하기 때문에 suspend fun 혹은 runBlocking 안에서만 사용이 가능하다
            println(value1)

            //sort 등의 CPU작업을 많이  해야 하는 경우는 Default를 사용한다
            val sortedDeferred: Deferred<Array<String>> = CoroutineScope(Dispatchers.Default).async {
                val array = arrayOf("10", "1", "2", "3", "4")
                array.sorted()
                array
            }
            val value2 = sortedDeferred.await()
            println(value2)

            CoroutineScope(Dispatchers.Main).launch {
                val result = value1.toString() + value2[2]

                val test02 = findViewById<Button>(R.id.test02)
                test02.text = "코루틴" + result
            }
        }



    }

    private suspend fun getNetData11() {
        println("A Scope : I'am withContext, start!")
//        for (item in 0..1000) {
//            println("A Scope : $item")
//        }
        delay(1000)
        println("A Scope : I'am withContext, END!")
    }

    private fun getNetData22() {
        println("B Scope : I'am CoroutineScope, start!")
        for (item in 0..1000) {
            println("B Scope : $item")
        }
    }

    private fun assert_rx1() {
        val list:MutableList<String> = mutableListOf<String>()
        ('A'..'Z').forEach {
            list.add(it.toString())
        }

        //자료에 직접 Observable을 만들고 거기에 subscribeBy에 직접 onNext들을 할당
//        val observable: Observable<String> = list.toObservable()
//        val disposable = observable.subscribeBy(
//            onNext = {
//                println(it)
//            },
//            onError = {
//                it.printStackTrace()
//            },
//            onComplete = {
//                println("END")
//            }
//        )


        //map(스트림)을 Observable로 만든 후 곧바로 subscribe를 추가 하는 방식. 보다 코드를 간단하게
        val strTemp1 = "ABCDE"
        val observable2 = strTemp1.map { it ->
            it + ", "
        }.toObservable()
            .subscribe({value ->
                println(value)
            }, { error ->
                error.printStackTrace()
            }, {
                println("END")
            })
//        observable2.

//        val strTemp = "ABCDE"
//        val observable = strTemp.map {
//            it
//        }.toObservable()


        //Observer를 객체로 만들고, Subject도 객체로 만들어서 동적으로 onNext를 호출 해야할 경우
        val observer = object: Observer<String> {
            override fun onSubscribe(d: Disposable) {
                println("onSubscribe::${d}")
            }

            override fun onError(e: Throwable) {
                e.printStackTrace()
            }

            override fun onComplete() {
                println("onComplete::END")
            }

            override fun onNext(t: String) {
                println("onNext::${t}")
            }
        }

        val subject: Subject<String> = PublishSubject.create()
        subject.map {
            it + ", "
        }.subscribe(observer)

        val strTemp = "ABCDE"
        strTemp.map { it ->
            subject.onNext(it.toString())
        }

    }

    private fun testBtn01() {
        val observable = Observable
            // create 부분
            .create { emitter ->
                val list = mutableListOf("hello", "rx", "world")

                list.forEach { item ->
                    emitter.onNext(item)

                    //subscribeBy::onError를 받고 싶다면 사용
//                    if (item == "world") emitter.onError(Throwable("world 워드를 찾음"))
                    if (item == "abcd") emitter.onError(Throwable("abcd 워드를 찾음"))
                }

                emitter.onComplete()
            }
            // combine 부분
            .map { item ->
                "$item!"
            }
            .subscribeBy(
                onError = { it.printStackTrace() }, onNext = { println("onNext::$it") }, onComplete = { println("DONE") }
            )
    }

    @SuppressLint("CheckResult")
    fun testBtn02() {
        Observable.just("One", "Two")			// Observable 선언, just()는 내부 요소 순서대로 전달 (2번 onNext 호출)
            .subscribeOn(Schedulers.io())		// Observable, Observer 실행Thread 변경 (io -> Worker스레드, 백그라운드)
            .observeOn(AndroidSchedulers.mainThread())	// Observer 실행Thread 변경 (UI스레드)
            .subscribe (				// 구독 등록, 3개의 param (onNext(), onError(), onComplete())
                { value -> println("Result : $value") },	// onNext() 재정의, 데이터 발행(emit)시 호출
                { error -> println("Error : $error") },		// onError() 재정의, 예외 발생 시 호출
                { println("onComplete") }			// onComplete() 재정의, 모든 데이터 발행 후 호출
            )
//        Result : One
//        Result : Two
//        onComplete
    }

    fun testBtn03() {
        //자료형 선언 없이 사용
        val observable1 = Observable.create {
            it.onNext("Str1") //문자열 데이터를 방출한다
            it.onNext("Str2")
            it.onComplete()
        }

        //자료형 선언을 하면서 사용
        val observable2 = Observable.create<Int> {
            it.onNext(10) //Int 데이터를 방출한다
            it.onNext(20)
            it.onNext(30)
            it.onComplete()
        }

        //구독자 생성
        //위(observable1, observable2의 it.onNext() 에서 방출한 데이터 스트림을 소비한다
        val observer = object: Observer<Any> {
            //데이터 발행이 끝났음을 알리는 완료 이벤트를 Observer에 전달하여 onNext()를 더 호출하지 않음을 나타낸다
            override fun onComplete() {
                println("onComplete()")
            }

            //오류가 발생했음을 Observer에 전달함
            override fun onError(e: Throwable) {
                println("onError() - $")
            }

            override fun onSubscribe(d: Disposable) {
                println("onSubscribe() - $d ")
            }

            //하나의 소스 Observable에서 Observer까지 한 번에 하나씩 순차적으로 데이터를 발행한다
            override fun onNext(t: Any) {
                if (t is String) { // "Str1", "Str2" 가 올 것이다
                    println("onSubscribe() onNext() is String - $t ")
                }

                if (t is Int) { // 10, 20, 30이 올 것이다
                    println("onSubscribe() onNext() is Int - $t ")
                }
            }
        }

        //Schedulers.newThread()와 같이 RxKotlin에서 제공된 메인 기본 스레드는 새로운 백그라운드를 생성한다. Schedulers.io() 는 IO 스레드에서 코드를 실행합니다.
        val subscription = observable1
            .subscribeOn(Schedulers.io()) // observable을 IO 스레드에서 실행
            .observeOn(AndroidSchedulers.mainThread()) // Observer 메인 스레드에서 실행
            .subscribe(observer) // observer 구독

        //간단 사용
        observable1.subscribe(observer)
        observable2.subscribe(observer)
    }

    fun testBtn04() {
        /*
        Observable.interval(200, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io()) // subscribeOn을 통해 Observable을 IO 스케줄러로 지정
            .subscribe {
                println("${Thread.currentThread().name} : $it")
            }

        Thread.sleep(1000)
        */

        /*
        IO 스케줄러로 지정하였지만 무시되고 Computation 스케줄러에서
        아이템을 발행하는 모습을 확인할 수 있다.

        RxComputationThreadPool-1 : 0
        RxComputationThreadPool-1 : 1
        RxComputationThreadPool-1 : 2
        RxComputationThreadPool-1 : 3
         */
        val intent = Intent(this, MVVMActivity2::class.java)
        startActivity(intent)
    }


    /**************************************************************************************
    Rx 와 Retrofit2를 연계
    **************************************************************************************/
    @SuppressLint("CheckResult")
    fun testBtn20() {
        GithubClient.getApi().getRepos("tkdgusl94")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({ items ->
                items.forEach { println(it) }
            }, { e ->
                println(e.toString())
            })
    }


    /**************************************************************************************
    AsyncTask의 대처
     **************************************************************************************/

    //AsyncTask를 테스트하는 메소드
    fun testBtn30() {

        //Task를 실행할 때 처리할 때 필요한 매개변수를 만들어 넘길 수 있다
        val arr = Array<Int>(2) {0}
        arr[0] = 100
        arr[1] = 5

        //이때 만들어 execute로 넘긴 변수는 doInBackground(vararg p0: Array<Int>?)로 넘어가게 된다
//        oldTask.execute(arr)
    }

}