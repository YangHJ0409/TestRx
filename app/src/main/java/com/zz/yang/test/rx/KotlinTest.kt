package com.zz.yang.test.rx

import android.graphics.Point
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Math.round
import java.util.Arrays
import java.util.LinkedList
import java.util.Queue
import kotlin.math.abs

/**
 * Coroutine 테스트
 * RxKotlin 테스트
 * 각종 알고리즘
 */
class KotlinTest12 {
    val LOG = true

    fun main(array: Array<String>) {
        var answer: String = "0123456789"
        val str1 = "abcdefgh"
        val str2 = "1234567"
//        val input1 = str1.toCharArray()

        val my_str = arrayOf("a", "b")
        val result:String = my_str.joinToString("")
        println(result)
        //
        println("===================END")
        println(answer.slice(0..5)) //012345
        println(answer.slice(0 until 5)) //01234
        println(answer.slice(0 until 5 step 2)) //024
        println(answer.slice(5 downTo(0))) //543210
        println(answer.slice(5 downTo(0) step 2)) //531
    }

    fun solution(my_string: String, s: Int, e: Int): String {
        var answer: String = ""
        answer = my_string.slice(s..e).toString()
        return answer
    }

    fun solution(my_string: String, queries: Array<IntArray>): String {
        var answer: String = ""
        val arrStr = my_string.toCharArray()
        if(LOG) println(arrStr.joinToString())

        for(querie in queries) {
            val s = querie[0]
            val e = querie[1]
            val temp = arrStr[s]
            arrStr[s] = arrStr[e]
            arrStr[e] = temp
            answer = arrStr.map{it.toString()}.toString()
            if(LOG) println(answer)
        }//for(queries) -END
        return answer
    }

    fun solution(number: String): Int {
        var answer: Int = 0
        number.forEach {
            it.digitToInt()
        }
        number.reduce { total, num ->
            total + num.digitToInt()
        }
        return answer
    }

    fun testReduceOrFold() {
        if (true)
        {
            val numbers = listOf(7, 4, 8, 1, 9)

            val sum = numbers.reduce { total, num ->
                println("reduce::total=$total, num=$num")
                total + num
            }
            println("reduced: $sum") // reduced: 29
            val sumFromTen = numbers.fold(10) { total, num ->
                println("fold::total=$total, num=$num")
                total + num
            }
            println("folded: $sumFromTen") // folded: 39
        }
        println("-----------------------------------------") // folded: 39

//        if (true) {
//            val numbers = emptyList<Int>()
//
//            val sumFromTen = numbers.fold(10) { total, num ->
//                println("fold::total=$total, num=$num")
//                total + num
//            }
//            println("folded: $sumFromTen") // folded: 10
//            val sum = numbers.reduce { total, num ->
//                println("reduce::total=$total, num=$num")
//                total + num
//            }
//            println("reduced: $sum")
//        }
//        println("-----------------------------------------") // folded: 39

        if (true) {
            val numbers = listOf(5, 2, 10, 4)

            val doubledSum = numbers.reduce { total, num ->
                println("reduce::total=$total, num=$num")
                total + num * 2
            }
            println("reduced: $doubledSum") // reduced: 37 -> 원래는 42가 나와야 한다!!
            val doubledSumFromZero = numbers.fold(0) { total, num ->
                println("fold::total=$total, num=$num")
                total + num * 2
            }
            println("folded: $doubledSumFromZero") // folded: 42
        }
    }

    fun solution(a: Int, b: Int, c: Int, d: Int): Int {
        var answer: Int = 0
        //각 공식에 맞게 점수만 계산하면 되기 때문에 a,b,c,d의 변수는 관계가 없고 그 안의 숫자만 유의미하다
        //따라서 정렬하고 앞에서부터 확인해도 된다
        val arr = intArrayOf(a, b, c, d).sorted()
        if (LOG) println(arr.map{it.toString()})
        val aa = arr[0]
        val bb = arr[1]
        val cc = arr[2]
        val dd = arr[3]

//네 주사위에서 나온 숫자가 모두 p로 같다면 1111 × p점을 얻습니다.
        if (aa == bb && bb == cc && cc == dd) {
            answer = aa * 1111
        }
        else {
            //세 주사위에서 나온 숫자가 p로 같고 나머지 다른 주사위에서 나온 숫자가 q(p ≠ q)라면 (10 × p + q)2 점을 얻습니다.
            if (aa == bb && bb == cc) {
                answer = Math.pow(((10 * aa + dd).toDouble()), 2.0).toInt()
            } else if (bb == cc && cc == dd) {
                answer = Math.pow((10 * dd + aa).toDouble(), 2.0).toInt()
            }
            //주사위가 두 개씩 같은 값이 나오고, 나온 숫자를 각각 p, q(p ≠ q)라고 한다면 (p + q) × |p - q|점을 얻습니다.
            else if (aa == bb && cc == dd) {
                answer = (aa + dd) * abs(aa - dd).toInt()
            } else {
                //어느 두 주사위에서 나온 숫자가 p로 같고 나머지 두 주사위에서 나온 숫자가 각각 p와 다른 q, r(q ≠ r)이라면 q × r점을 얻습니다.
                answer = if (aa == bb) {
                    cc * dd
                } else if (bb == cc) {
                    aa * dd
                } else if (cc == dd) {
                    aa * bb
                } else { //네 주사위에 적힌 숫자가 모두 다르다면 나온 숫자 중 가장 작은 숫자 만큼의 점수를 얻습니다.
                    arr[0]
                }
            }
        }

        return answer
    }

    fun solution(array: IntArray): Int {
        var answer: Int = 0
//        var map = HashMap<Int, Int>()
//        for (num in array) {
//            map[num] = map[num]!! + 1
//        }
//
//        for (key in map.keys) {
//            println("map[$key] = ${map[key]}")
//        }

        if (array[0] == array[1] && array[1] == array[2] && array[2] == array[3]) {

        }

        val temp:Double = 45 + (45 * 0.15748)
        println(temp)
        val r1 = Math.round(temp)
        println("소수점1자리 반올림:$r1")
        val r2 = String.format("%.2f", (Math.round(temp*10)/10.0).toDouble())
        println("소수점2자리 반올림:${temp*10} / ${Math.round(temp*10)} / $r2")
        val r3 = (Math.round(temp*100)/100.0).toDouble()
        println("소수점3자리 반올림:${temp*100} / ${Math.round(temp*100)} / ${String.format("%.3f", r3)}")

        val dNum:Double = 454.14600

        println(round(dNum))	// 454.0
        println(round(dNum*100) / 100.0)	// 454.15

        return answer
    }
    /*
    fun solution(array: IntArray): Int {
        var answer: Int = -1
        //원소의 길이는 0 < array의 길이 < 100 로 길지 않다
        //원소의 값도 0 ≤ array의 원소 < 1000 로 크지 않다
        //따라서 배열을 사용하여 '배열[원소의 값] = 개수' 를 사용해도 메모리는 문제가 없다
        var arrCount = IntArray(1000) {0}
        var max = 0
        for (num in array) {
            arrCount[num] += 1
            //최대값 갱신
            if (max < arrCount[num]) {
                max = arrCount[num]
                answer = num //최빈값 저장
            }
        }

        arrCount = arrCount.sortedWith { p0, p1 ->
            p1 - p0
        }.toIntArray() //내림차순으로 정렬
        // println("${arrCount.map{ it.toString()}.toString()}")

        //첫번째와 두번째 값이 같으면 최빈값이 두개 이상
        // println("${arrCount[0]}, ${arrCount[1]}")
        if (arrCount[0] == arrCount[1]) {
            answer = -1
        }

        return answer
    }


    fun solution(arr: IntArray): IntArray {
        var stk = mutableListOf<Int>()
        //변수 i를 만들어 초기값을 0으로 설정한 후 i가 arr의 길이보다 작으면 다음 작업을 반복합니다.
        val len = arr.size
        var i = 0
        while (i < len) {
            //만약 stk가 빈 배열이라면 arr[i]를 stk에 추가하고 i에 1을 더합니다.
            val size = stk.size
            println("$i, $size")
            if (size == 0) {
                stk.add(arr[i])
                i += 1
            }
            else {
                val last = stk.get(size-1) //stk.last()
                println("$i, $last, ${arr[i]}")
                //stk에 원소가 있고, stk의 마지막 원소가 arr[i]보다 작으면 arr[i]를 stk의 뒤에 추가하고 i에 1을 더합니다.
                if (last < arr[i]) {
                    stk.add(arr[i])
                    i += 1
                }
                else {
                    //stk에 원소가 있는데 stk의 마지막 원소가 arr[i]보다 크거나 같으면 stk의 마지막 원소를 stk에서 제거합니다.
                    stk.removeAt(size-1)
                }
            }
        }

        arr.sortedWith { p0, p1 ->
            p0 - p1
        }

        return stk.toIntArray()
    }
    */

    fun solution(l: Int, r: Int): IntArray {
        var answer: IntArray = intArrayOf(5)
        val temp = r / 5
        val len = temp.toString().length

        var str = "5"

        var pre = intArrayOf(5)
        for(a in 1 until len) {
            var preTemp = intArrayOf()
            for (num in pre) {
                val num1: Int = num * 10
                val num2: Int = num1 + 5
                preTemp += num1
                preTemp += num2
                if (LOG) println("$num, $num1, $num2")
            }
            pre = preTemp
            for (b in preTemp) {
                answer += b
            }
        }

        // l과r 사이의 값만 남긴다
        answer = answer.filter { it ->
            if (l <= it && it <= r) {
                true
            } else {
                false
            }
        }.toIntArray()

        if (answer.size == 0) {
            answer = intArrayOf(-1)
        }

        return answer
    }
    /*
    fun solution(num_list: IntArray): IntArray {
        val lastIdx = num_list.size - 1
//        var answer: IntArray = IntArray(num_list.size+1)
        var answer: IntArray = intArrayOf()

        num_list.forEachIndexed { idx, num ->
            // println("$idx, $num")
//            answer += num
            answer.plus(num)
        }
        if (num_list[lastIdx] > num_list[lastIdx-1]) {
            answer.plus(num_list[lastIdx] - num_list[lastIdx-1])
        } else {
            answer.plus(num_list[lastIdx] * 2)
        }

        println(answer.map { it.toString() })
        return answer
    }
    */

}

/**
 * 플로이드 알고리즘
 * https://www.acmicpc.net/problem/11404
 * 모든 노드에서 다른 모든 노드까지 가는데 최소비용, O(V^3)
 * 다익스트라: 한 노드 -> 다른 모든 노드, O(ElgV)
 *
 * 작동원리:
 *  - 노드j -> 노드i 비용 배열 만들기, 초기값: INF
 *  - 간선의 값을 비용 배열에 반영
 *  - 모든 노드에 대해 해당 노드 거쳐서 가서 비용 작아질 경우 값 갱신
 *
 *  Tip
 *  그래프 거리 문제 나올때
 *      - 한점 -> 여러점: 다익스트라
 *      = 여러점 -> 여러점: 플로이드
 *  코드가 어려우므로 여러번 연습 필요
 *  */
class KotlinTest11 {

    /*
    아이디어
    - 한점 -> 모든점: 다익스트라 사용
    = 모든점 -> 모든점: 플로이드 사용
    = 거리 초기값 무한대로 설정, 자기 자신으로 가는값 0 설정
    - 노드 거쳐서 가서 비용이 작아질 경우 값 갱신

    변수
    거리 배열: Int[][]: [시작점][도착점]

    포인트
    for 문 3개를 사용
    for(거쳐가는점)
        for(시작점)
            for(도착점)
    이렇게 짜야 한다
     */

    val LOG = true

    fun main(array: Array<String>) {
        val input = arrayOf("5"
            , "14"
            , "1 2 2"
            , "1 3 3"
            , "1 4 1"
            , "1 5 10"
            , "2 4 2"
            , "3 4 1"
            , "3 5 1"
            , "4 5 3"
            , "3 5 10"
            , "3 1 8"
            , "1 4 2"
            , "5 1 7"
            , "3 4 2"
            , "5 2 4")

        val N = input[0].toInt() // 도시의 개수 (2 ≤ n ≤ 100)
        val M = input[1].toInt() //버스의 개수 (1 ≤ m ≤ 100,000)
        if (LOG) println("N = $N, M = $M")

        //노드의 번호는 1부터 빠지는갑시 없이 순차적으로 증가하므로 노드번호를 그대로 인덱스로 사용하기 위해서 배열크기를 N+1로 잡는다
        val COSTS = Array<Array<Int>>(N+1) { Array<Int>(N+1) { Int.MAX_VALUE } }
        for (n in 1..N) { //시작과 도착이 자기 자신인 경우는 비용이 0이 되어야 한다
            COSTS[n][n] = 0
        }

        for (n in 2 until M+2) {
            val arr = input[n].split(" ").map {
                it.toInt()
            }.toTypedArray()
            val s = arr[0] //시작점
            val e = arr[1] //도착점
            val c = arr[2] //비용

            COSTS[s][e] = Math.min(c, COSTS[s][e]) //같은 노드에 다른 비용이 있을 수도 있으므로 최소값을 찾아 저장
        }

        if (LOG) {
            for (n in 1..N) {
                var temp: String = ""
                for (m in 1..N) {
                    if (COSTS[n][m] == Int.MAX_VALUE) {
                       temp += "M"
                    } else {
                       temp += COSTS[n][m]
                    }

                    temp += " "
                }
                println(temp)
            }
        }

        //중요 포인트
        //for 3개 사용
        //거쳐가는 노드 -> 시작 노드 -> 도착 노드
        for (k in 1..N) {
            for (start in 1..N) {
                for (end in 1..N) {
                    if (LOG) println("$start~$k~$end::${COSTS[start][end]} > ${COSTS[start][k]} + ${COSTS[k][end]}")
                    //시작-끝 보다 시작-중간 + 중간-끝 의 비용이 작은 경우 이 값으로 갱신한다
//                    if (COSTS[start][end] > (COSTS[start][k] + COSTS[k][end])) {
//                        COSTS[start][end] = COSTS[start][k] + COSTS[k][end]
//                    }
                    if (COSTS[start][k] != Int.MAX_VALUE && COSTS[k][end] != Int.MAX_VALUE) {
                        COSTS[start][end] = Math.min(COSTS[start][end], (COSTS[start][k] + COSTS[k][end]))
                    }
                }//for(도착 노드)
            }//for(시작 노드)
        }//for(거쳐가는 노드)

        for (n in 1..N) {
            var temp: String = ""
            for (m in 1..N) {
                if (COSTS[n][m] == Int.MAX_VALUE) {
                    temp += "0"
                } else {
                    temp += COSTS[n][m]
                }

                temp += " "
            }
            println(temp)
        }
    }

}

/**
 * 다익스트라
 * https://www.acmicpc.net/problem/1753
 * 한 노드에서 다른 모든 노드까지 가는데 필요한 최소비용 (MST는 모든 노드를 잇는데 필요한 최소비용)
 * 작동원리
 * - 간선: 인접 리스트, 거리 배열: 초기값 무한대로 설정, 힙 시작점 추가
 * - 힙에서 현재 노드 빼면서, 간선 통할 때 더 거리 짧아진다면
 *  - 거리 갱신 및 힙에 추가
 *
 * 중요: 다익스트라 코드
 * 코드가 복잡하므로 연습 필요
 * 중요한건, 해당 문제가 다익스트라 문제인지 알아내는 능력
 *  - 한점에서 다른점으로 가는 최소 비용
용*
 */
class KotlinTest10 {
    /*
    아이디어
    한점에서 다른 모든 점으로의 최단 경로 > 다익스트라 사용
    모든 점 거리 초기값 무한대로 설정
    시작점 거리 0 설정 및 힙에 추가
    힙에서 하나씩 배면서 수행
        현재 거리가 새로운 간선 거칠때보다 크다면 갱신 (== 새로운 간선이 더 작으면)
        새로운 거리에 힙에 추가

    자료구조 (변수)
    다익스트라 사용 힙: Array<비용(Int), 다음노드(Int)>
    거리배열: Array<Int>
    간선, 인접 리스트: Array<비용(Int), 다음노드(Int)>
    */

    val LOG = true

    val input1 = "5 6"
    val input2 = "1"
    val input3 = arrayOf("5 1 1"
    , "1 2 2"
    , "1 3 3"
    , "2 3 4"
    , "2 4 5"
    , "3 4 6")

    var V = 0 //정점의 개수 (노드의 개수): 1부터 V까지 번호가 매겨져 있다
    var E = 0 //간선의 개수
    var K = 0 //시작점

    //간선을 나타내는 세 개의 정수 (u, v, w)가 순서대로 주어진다. 이는 u에서 v로 가는 가중치 w인 간선이 존재한다는 뜻이다. u와 v는 서로 다르며 w는 10 이하의 자연수이다. 서로 다른 두 정점 사이에 여러 개의 간선이 존재할 수도 있음에 유의한다.
    var NODE = mutableMapOf<Int, ArrayList<Pair<Int, Int>>>() // Map<노드번호(V), ArrayList<Pair<비용, 목표노드번호>>>
    //다익스트라의 중요 포인트
    //시작점부터 해당V까지의 최소 비용을 계속 저장한다
    var DIST: Array<Int> = emptyArray() //각 V 인덱스에 최소 비용이 저장된다
    val heap: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>() //비용, 노드번호

    fun main(array: Array<String>) {
        val arrayInput1 = input1.split(" ").map {
            it.toInt()
        }.toTypedArray()
        V = arrayInput1[0]
        E = arrayInput1[1]
        if (LOG) println("V = $V, E = $E")

        K = input2.toInt()
        if (LOG) println("K = $K")

        for(i in 0 until E) {
            val arrayInput3 = input3[i].split(" ").map {
                it.toInt()
            }.toTypedArray()

            var list = NODE[arrayInput3[0]]
            if (list == null) {
                list = ArrayList<Pair<Int, Int>>()
            }

            list.add(Pair(arrayInput3[2], arrayInput3[1]))
            NODE[arrayInput3[0]] = list

            if (LOG) println("arrayInput3[0] = ${arrayInput3[0]}, list = ${list.map { it.toString() }}")
        }

        DIST = Array(E) { Int.MAX_VALUE }
        DIST[K] = 0

        heap.add(Pair(0, K))

        while (heap.peek() != null) {
            val eachPair = heap.poll()!!
            val eachW = eachPair.first
            val eachV = eachPair.second
            if (LOG) println("eachW = $eachW, eachV = $eachV, DIST[eachV] = ${DIST[eachV]}")

            val list = NODE[eachV]
            if (list != null) {
                for (nextPair in list) {
                    val nextW = nextPair.first
                    val nextV = nextPair.second
                    if (LOG) println("nextW = $nextW, nextV = $nextV, (nextW + eachW) = ${(nextW + eachW)}, DIST[nextV] = ${DIST[nextV]}")
                    if ((nextW + eachW) < DIST[nextV]) {
                        DIST[nextV] = nextW + eachW
                        heap.add(Pair(nextW, nextV))
                    }
                }
            }

            if (LOG) println("-------------------------------")
        }

        for (res in DIST) {
            println(res)
        }
    }

}

/**
 * 추가공부 필요
 * MST: Minimum Spanning Tree
 * Spanning Tree: 모든 노드가 연결된 트리
 * MST: 최소의 비용으로 모든 노드가 연결 된 트리
 *
 * https://www.acmicpc.net/problem/1197
 *
 * MST 푸는 방법: Kruskal or Prim 두가지가 있다
 * Kruskal: 전체 간선 중 작은것부터 연결 (Union - Find 알고리즘 사용. 어렵다)
 * Prim: 현재 연결된 트리에 이어진 간선중 가장 작은것을 추가 (주로 이걸 쓴다)
 *
 * heap: 최대값 or 최소값을 빠르게 찾아주는 자료구조
 *  이진 트리 구조를 가진다
 *  처음에 저장할 때부터 최대값 or 최소값 결정하도록
 *
 * 중요: 양방인지 단방향인지 주의
 * 최소 스패닝 트리 코드는 그냥 외우자
 * 중요한건 해당 문제가 MST 문제인지 알아내는 능력이 필요하다
 *  - 모든 노드가 연결되도록 한다거나
 *  - 이미 연결된 노드를 최소/최대 '비용'으로 줄이기 등의 문제일 경우
 *
 * 아이디어:
 *  최소 스패닝 트리 기본문제 (외우기)
 *      어디에서, 어디까지 얼마의 비용이 들어가는지를 저장한다
 *  간선을 인접 리스트 형태로 저장
 *  시작점부터 힙에 넣기
 *  힙이 빌때까지
 *      해당 노드 방문안한곳일 경우
 *      방문 체크, 비용추가, 연결된 간선 새롭게 추
 */
class KotlinTest09 {

    /*
    1. 아이디어
    - MST 기본문제, 외우기
    - 간선을 인접리스트에 집어넣기
    - 힙에 시작점 넣기
    - 힙이 빌때까지 다음의 자억을 반복
        - 힙의 최소값 꺼내서, 해당 노드 방문 하지 않했다면
            - 방문표시, 해당 비용 추가, 연결된 간선들 힙에 넣어주기

    2. 시간복잡도
    - MST: O(ElgE)

    3. 자료구조
    - 간선 저장되는 인접리스트: (무게, 노드번호)
    - 힙: (무게, 노드번호)
    - 방문 여부: boolean[]
    - MST 결과값 Int
     */


    val LOG = true

    val V = 3 //정점의 개수. 그래프의 정점은 1번부터 V번까지 번호가 매겨져 있고, 임의의 두 정점 사이에 경로가 있다
    val E = 3 //간선의 개수

    //간선이 저장되는 인접리스트 Pair<무게, 노드번호(정점)>
    val data1 = arrayOf("1 2 1", "2 3 2", "1 3 3")
    val edge = mutableMapOf<Int, ArrayList<Pair<Int, Int>>>()

    //힙
    val heap: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>() //Pair<무게, 노드번호(정점)>

    //방문 여부
    val chk: Array<Boolean> = Array(V+1) { false } //정점의 값을 그대로 index로 사용하기 위해서 V+1개를 생성한다

    var result = 0 //결과값

    fun main(array: Array<String>) {

        //자료 구조 만들기
        for (i in 0 until E) {
            val arrayInt = data1[i].split(" ").map {
                it.toInt()
            }.toTypedArray<Int>()

            if (edge[arrayInt[0]] == null) {
                val list: ArrayList<Pair<Int, Int>> = ArrayList()
                edge[arrayInt[0]] = list
            }
            val listFirst: ArrayList<Pair<Int, Int>> = edge[arrayInt[0]]!!
            listFirst.add(Pair(arrayInt[2], arrayInt[1]))
            if (LOG) println("${arrayInt[0]}:${listFirst.toString()}")

            //양방향이므로 반대방향 값도 저장해야 한다
            if (edge[arrayInt[1]] == null) {
                val list: ArrayList<Pair<Int, Int>> = ArrayList()
                edge[arrayInt[1]] = list
            }
            val listScd: ArrayList<Pair<Int, Int>> = edge[arrayInt[1]]!!
            listScd.add(Pair(arrayInt[2], arrayInt[0]))
            if (LOG) println("${arrayInt[1]}:${listScd.toString()}")

        }

        //최초의 heap
        heap.add(Pair(0, 1))

//        - 힙이 빌때까지 다음의 작업을 반복
        while (heap.peek() != null) {
//        - 힙의 최소값 꺼내서
            val pair = heap.poll()!!
            val c = pair.first
            val v = pair.second
            if (LOG) println("c = $c, v = $v, chk[v] = ${chk[v]}")

//        - 해당 노드 방문 하지 않했다면
            if (!chk[v]) {
//        - 방문표시, 해당 비용 추가, 연결된 간선들 힙에 넣어주기
                chk[v] = true
                result += c
                val list = edge[v]!!
                var minPair: Pair<Int, Int>? = null
                for (next_pair in list) {
                    if (LOG) println("${v}:${next_pair.toString()} ${chk[next_pair.second]}, result = $result")
                    if (!chk[next_pair.second]) {
                        if (null == minPair) {
                            minPair = next_pair
                            continue
                        } else {
                            if (next_pair.first < minPair.first) {
                                minPair = next_pair
                            }
                        }
                    }
                }
//                if (LOG) println("minPair:${minPair.toString()} ${chk[minPair.second]}, result = $result")
                heap.add(minPair)
            }
        }//while -END

        println(result)
    }
}

/**
 * DP (Dynamic Programming)
 * https://www.acmicpc.net/problem/11726
 * 이전의 값을 재활용 하는 알고리즘
 * 예시: 1~10 숫자 중, 각각 이전값들을 합한 값 구하기
 * 1 (1출력)
 * 1+2 (2부터 1까지 반복)
 * 1+2+3 (3부터 1까지 반복)
 * ...
 * 이렇게 10까지 각각 1, 2, 3...씩 반복하게 되어서 10^2 (N^2) 만큼 시간이 걸리게 된다
 *
 * 이전의 값을 활용해서 시간복잡도를 줄일 수 있음
 * 이전값을 어떻게 잘 사용하는지가 관건, 점화식: An = A(n-1) + A(n-2) ...
 *
 * 중요: 점화식을 짜는게 중요
 * 어떻게 할지 모르겠을땐, 하나씩 그려보면서 규칙 찾기
 * 점화식을 명확하게 세우고 코드를 짜기 (점화식을 짜기 전에 코딩 부터 들어가면 꼬인다)
 */
class KotlinTest08 {

    /*
    A1: 1, A2: 2, A3: 1 + 2
    1. 아이디어
    - 점화식: An = An-1 + An-2
    - N값 구하기 위해, for문 3번부터 N까지의 값을 구해주기
    - 이전값, 이전이전값 더해서, 10007로 나눠 저장 << 이건 문제의 내용
     */

    val LOG = true

    var N = 9
    var result = 0

    fun main(array: Array<String>) {
        result += 1
        for (n in 2..N) {
            result += n
        }

        println(result)

        result = 0

        println("---------------------------")

        //2xn 의 전체 타일에 2x1을 채우려고 한다면
        //n이 3일 때는 n이 2일때의 개수(2)와 n이 1일때의 개수(1)의 합이다 (3 = 2 + 1)
        //n이 4일 때는 n이 3일때의 개수(3)와 n이 2일때의 개수(2)의 합이다 (5 = 3 + 2)
        //n이 5일 때는 n이 4일때의 개수(5)와 n이 3일때의 개수(3)의 합이다 (8 = 5 + 3)
        //즉 An = A(n-1) + A(n-2) 이 된다
        // 이전, 이이전 값을 가지고 있으면 되겠다
        val DP: Array<Int> = Array<Int>(2) { 0 }
        DP[0] = 1
        DP[1] = 2

        for (n in 3..N) {
            result = DP[0] + DP[1]
            if (LOG) println("$result = ${DP[0]} + ${DP[1]}")
            DP[0] = DP[1]
            DP[1] = result
        }

        println(result)
    }
}

/**
 * 그리디
 * https://www.acmicpc.net/problem/11047
 *
 * 현재 차례의 최고의 답을 찾는 문제
 * 어려운 이유: 왜 그런지 증명하기가 어려움
 * 예시: 다른 금액의 동전이 여러개 주어졌을 때 M원을 만드는 최소의 개수 찾기
 * 주의: 1원, 20원, 30원, 40원 이 있을 때 50원을 만들려고 하면
 * 큰금액부터 넣으면: 40원*1 + 10원*10 = 11개
 * 최적의 답: 20원*1 + 30원*1 = 2개
 * 즉, 큰 금액부터 넣는다는것이 곧 답이 아닌 경우가 많다
 * 다만, 주어진 값들이 배수 일 경우(10, 20, 40.. 이런식)에는 큰 금액부터 넣어서 계산해도 문제가 없으리라
 *
 * 중요: 실전 문제에서 그리디로 푸는 문제임을 생각하기가 어려움
 * 그리디 사용 이유 설명 or 반례 찾기 연습해야 함
 */
class KotlinTest07 {

    /*
     * 1. 아이디어
     * - 동전을 저장한뒤, 반대로 뒤집음
     * - 동전 for ->
     *  - 동전 사용개수 추가
     *  - 동전 사용한만큼 K값 갱신
     *
     * 2. 시간복잡도
     * - D(N)
     *
     * 3. 자료구조
     * - 동전 금액 : Int[]
     * - 동전 사용 cnt : Int
     * - 남은 금액 : Int
     */

    val LOG = true

    var N = 0
    var K = 0
    var COINS: Array<Int> = emptyArray()
    var coinCnt:Int = 0

    fun main(array: Array<String>) {
        //case 1
        N = 10
        K = 4200
        COINS = arrayOf(1, 5, 10, 50, 100, 500, 1000, 5000, 10000, 50000)

        //금액이 큰 동전 부터 계산해야 한다
        //내림차순 정렬
//        COINS.sortWith { p0, p1 ->
//            p1 - p0
//        }
        COINS.reverse()
        if (LOG) println(COINS.map { it.toString() })

        solution()

        //case 2
        N = 10
        K = 4790
        COINS = arrayOf(1, 5, 10, 50, 100, 500, 1000, 5000, 10000, 50000)

        COINS.reverse()

        solution()
    }

    fun solution() {
        coinCnt = 0
        var temp0:Int = 0
        for (coin in COINS) {
            if (LOG) println(coin)

            temp0 = K / coin
            coinCnt += temp0
            K %= coin

            if (LOG) println("$coin : 사용한 코인 개수 $temp0, 총 코인 개수 = $coinCnt, 남은 금액 = $K ")
        }

        println(coinCnt)
    }

}
/**
 * 이진탐색
 * https://www.acmicpc.net/problem/1920
 * 처음부터 생각하기 어려움, 쉬운방법부터 생각하자
 * 어떤 값을 여러번 탐색해야 하는 경우 이진탐색을 사용해야하는지 고민해보자
 * 중요: 값이 정렬이 되어 었어야 한다
 */
class KotlinTest06 {

    //상수
    val LOG = true
    val N = 5
    val NUMS = arrayOf(4, 1, 5, 2, 3) //찾아지는 항목
    val M = 5
    val SEARCH = arrayOf(1, 3, 7, 9, 5) //찾아야 할 항목

    fun solution(numbers: IntArray): IntArray {
        var answer: IntArray = numbers.map {
            it.toInt() * 2
        }.toIntArray()
        return answer
    }

    //최대공약수 찾기 #외우는케이스
    fun gcd(a: Int, b:Int): Int = if (b != 0) gcd(b, a % b) else a

    fun main(array: Array<String>) {

        //* 중요: 이진탐색은 값이 정렬이 되어 었어야 한다
        NUMS.sortWith { p0, p1 -> Int
            p0!! - p1!! //오름차순
        }
//        NUMS.sortWith { p0, p1 ->
//            p0!! - p1!! //오름차순
//        }
        if (LOG) println(NUMS.map { it.toString() })

        //검색시작
        for (target in SEARCH) {
            search(0, N-1, target)
        }

        println("gcd::" + gcd(4, 8))
        println("gcd::" + gcd(7, 5))
        println("gcd::" + gcd(24, 16))
    }

    //이진탐색 메소드
    fun search(startIdx: Int, endIdx: Int, target: Int) {
        if (LOG) println("search($startIdx, $endIdx, $target)")

        if (startIdx == endIdx) {
            if (NUMS[startIdx] == target) {
                println("같은값 찾음$target")
            } else {
                println("같은값 찾지 못함:$target")
            }
            return
        }

        val mid:Int = (startIdx + endIdx) / 2
        if (LOG) println("$mid")

        if (NUMS[mid] < target) { //절반 나눈위치의 값이 찾는 값보다 작으면: 절반으로 나눈 영역중 오른쪽 범위에서 찾는다
            search(mid + 1, endIdx, target) // +1을 해주는 것을 잊으면 안된다
        } else { //절반으로 나눈 위치의 값이 찾는 값보다 '같거나' '크면': 절반으로 나눈 영역중 왼쪽 범위에서 찾는다
            search(startIdx, mid, target)
        }
    }
}

/**
 * 투포인터
 * https://www.acmicpc.net/problem/2559
 */
class KotlinTest05 {
    //상수
    val LOG = true

    //변수
    var N = 0
    var K = 0
    var NUMS: Array<Int> = emptyArray()
    var MAX = Int.MIN_VALUE
    var each = 0

    fun main(array: Array<String>) {
        val input1 = "10 5" //"10 2"
        val input2 = "3 -2 -4 -9 0 3 7 13 8 -3"

        val arrayInt = input1.split(" ").map {
            it.toInt()
        }
        N = arrayInt[0]
        K = arrayInt[1]

        if (LOG) println(N)
        if (LOG) println(K)

        NUMS = input2.split(" ").map {
            it.toInt()
        }.toTypedArray()

        if (LOG) println(NUMS.map { it.toString() })

        //1. K개 만큼을 더한다
        for (i in 0 until K) {
            each += NUMS[i]
        }//for -END
        if (LOG) println("최초K개를 더한 값:$each")
        MAX = each //일단 이 최초의 값이 최대가 된다

        //2. 반복문을 돌면서 다음을 더하고 가장 앞의 값을 뺀다
        for (i in K until N) {
            each -= NUMS[i-K]
            each += NUMS[i]
            if (LOG) println("빼는값${i-K}:${NUMS[i-K]} / 더하는값${K}:${NUMS[i]} max($MAX, $each)")
            MAX = Math.max(MAX, each)
        }// for -END

        //결과 출력
        println(MAX)
    }
}

/**
 * 시뮬레이션
 * https://www.acmicpc.net/problem/14503
 *
 */
class KotlinTest04 {

    //상수
    val LOG = true

    //입력
    var N = 0 //방의 크기 Y
    var M = 0 //방의 크키 X
    var y = 0 //청소기의 위치 y
    var x = 0 //청소기의 위치 x
    var d = 0 //청소기가 바라보는 방향 0북, 1동, 2남, 3서
    var MAP: Array<Array<Int>> = emptyArray() //지도 0: 청소 안함, 1: 청소했음

    //중간값

    //출력
    var cleanCount = 0 //멈출때까지 청소한 칸의 개수

    fun main(array: Array<String>) {
        N = 11
        M = 10
        y = 7
        x = 4
        d = 0

        val input2: Array<String> = arrayOf(
            "1 1 1 1 1 1 1 1 1 1"
            , "1 0 0 0 0 0 0 0 0 1"
            , "1 0 0 0 1 1 1 1 0 1"
            , "1 0 0 1 1 0 0 0 0 1"
            , "1 0 1 1 0 0 0 0 0 1"
            , "1 0 0 0 0 0 0 0 0 1"
            , "1 0 0 0 0 0 0 1 0 1"
            , "1 0 0 0 0 0 1 1 0 1"
            , "1 0 0 0 0 0 1 1 0 1"
            , "1 0 0 0 0 0 0 0 0 1"
            , "1 1 1 1 1 1 1 1 1 1")

        //데이터 만들기
        MAP = Array(N) { Array(M) {0} }
        for (n in 0 until N) {
            MAP[n] = input2[n].split(" ").map {
//                Integer.parseInt(it)
                it.toString().toInt()
            }.toTypedArray()
            if (LOG) println(MAP[n].map { it.toString() })
        }

        //청소기가 바라보는 방향 d: 0북, 1동, 2남, 3서
        val dy = arrayOf(-1, 0, 1, 0) //d값에 따른 왼쪽 방향의 y값. d가 0일때 왼쪽y값, d가 1일때 왼쪽y값...
        val dx = arrayOf(0, 1, 0, -1) //d값에 따른 왼쪽 방향의 x값

        //반복문 돌기
        var ing = true
        var move = false //청소 가능한 곳을 찾아 이동을 했는지 여부
        while (true) {
            //현재위치 청소
            if (LOG) println("현재위치::$y,$x:$d::청소여부 ${MAP[y][x]}, $cleanCount")
            if (MAP[y][x] == 0) {
                MAP[y][x] = 1
                cleanCount += 1
            }

            move = false

            //현재 바라보고 있는 방향에서 왼쪽 부터 탐색
            //d == 0: 3-2-1-0
            //d == 1: 0-3-2-1
            //d == 2: 1-0-3-2
            //d == 3: 2-1-0-3
            for (i in 0 until 4) {
                val tempD = (d + 3 - i) % 4
                val ny = y + dy[tempD]
                val nx = x + dx[tempD]
                if (LOG) println("$y,$x:$d::왼쪽부터탐색($tempD):$ny, $nx")

                //탐색하는 곳이 벽이 아니어야 함
                if ((ny in 0 until N) && (nx in 0 until M)) {
                    //청소를 하지 않았다면 바라보고 있는 방향으로 진행(즉 탐색한 방향으로 한칸 이동이다)
                    if (MAP[ny][nx] == 0) {
                        if (LOG) println("이동가능한장소:: ${MAP[ny][nx]}")
                        y = ny
                        x = nx
                        d = tempD //바라보는 방향도 바꿔야 한다!!!
                        move = true
                        break //이동을 했으므로 for문 종료
                    } else {
                        if (LOG) println("이동 불가능한장소:: ${MAP[ny][nx]}")
                    }
                }
            }
            //모든 방향을 탐색했지만 벽이거나 청소를 했다면 뒤로 한칸 이동(즉 이동을 하지 못했다)
            if (!move) {
                //바라보는 방향(d)에서 한칸 뒤 좌표 구한다(즉 왼쪽으로 두번 돌린 곳)
                val tempD = (d + 2) % 4
                val ny = y + dy[tempD]
                val nx = x + dx[tempD]
                if (LOG) println("$y,$x:$d::이동한 곳이 없다:뒤로이동 가능한지 확인($tempD):$ny, $nx")

                //진행할 곳이 없고 뒤도 막혀 있다면 종료(한칸 뒤가 벽이라면 동작을 멈춘다)
                if (ny !in 0 until N) {
                    break
                }
                if (nx !in 0 until M) {
                    break
                }

                //그것이 아니라면 뒤로 한칸 이동
                //바라보는 방향을 바꿔서는 안된다!!!
                y = ny
                x = nx
            }
        }

        //결과값 출력
        println(cleanCount)

    }

}

/**
 * 백트래킹
 * https://www.youtube.com/watch?v=atTzqxbt4DM&list=WL&index=1
 */
class KotlinTest03 {
    //상수
    val LOG = true

    //입력
    var N = 0 //1~N까지
    var M = 0 //M개를 뽑음

    //중간값
//    var result: List<String> = mutableListOf()
    var result: Array<Int> = emptyArray()
    var SEEN: Array<Boolean> = emptyArray()

    //출력

    fun main(array: Array<String>) {
        N = 4
        M = 2

        result = Array(M) {0}
        SEEN = Array(N+1) {false} //밑에 for 문에서 1부터 찾기 시작할 예정이므로 N+1

        recur(0)
    }

    fun recur(m: Int) {
        if (m == M) {
            val temp = result.map {
                it.toString()
            }
            println(temp)
            return
        }

        for (n in 1..N) {
            if (!SEEN[n]) {
                SEEN[n] = true
                result[m] = n
                recur(m+1)

                //하나의 뎁스(m)을 모두 찾고 거슬러 올라왔다면 방문여부와 결과값을 제외해줘야 다시 선택이 가능하다
                result[m] = 0
                SEEN[n] = false
            }
        }
    }
}

/**
 * 하노이의 원반
 */
class KotlinTest02 {

    val LOG = true

//    var answer = arrayOf<IntArray>()
    val answer = mutableListOf<IntArray>()

    fun hanoiMove(num: Int, from: Int, bay: Int, to: Int) {
        val arr = intArrayOf(from, to)
        answer.add(arr)
        // if (LOG) println("${arr.map { it.toString() }}")

        if (num == 1) {
            if (LOG) println("원반 1\t: $from 에서 $to 로 이동")
        } else {
            hanoiMove(num -1, from, to, bay)
            if (LOG) println("원반 $num \t: $from 에서 $to 로 이동")
            hanoiMove(num -1, bay, from, to)
        }
    }

    fun main(array: Array<String>) {
        hanoiMove(2, 1, 2, 3)

//        if (LOG) println("${answer.map { it.toString() }}")

        val result: Array<IntArray> = answer.toTypedArray()
//        return result
    }
}

/**
 * 깊이탐색 알고리즘
 * https://www.acmicpc.net/problem/2667 DFS, 재귀
 */
class KotlinTest01 {

    //상수
    val LOG = false
    val NEXT_Y = arrayOf(-1, 1, 0, 0) //다음 상하좌우의 y좌표
    val NEXT_X = arrayOf(0, 0, -1, 1) //다음 상하좌우의 x좌표

    //input
    var N = 0
    var VERTEX: Array<Array<Int>> = emptyArray()
    var VISIT: Array<Array<Boolean>> = emptyArray()

    //result
    var totalDanzi = 0 //단지 총 갯수
    val countDanzi = mutableListOf<Int>() //단지별 집 갯수
    var countDanziTemp = 0 //단지별 집 갯수 임시저장
    fun main(array: Array<String>) {
        val input1 = "7"
        val input2: Array<String> = arrayOf("0110100"
            , "0110101"
            , "1110101"
            , "0000111"
            , "0100000"
            , "0111110"
        , "0111000")

        N = Integer.parseInt(input1)

        //자료 만들기
        VERTEX = Array(N) { Array(N) {0} }
        for (y in 0 until N) {
            val brArr = input2[y].map {
                if (LOG) println(it)
                it.toString().toInt()
            }
            for (x in 0 until N) {
                VERTEX[y][x] = brArr[x]
            }
            if (LOG) println(VERTEX[y].map { it.toString()})
        }
        VISIT = Array(N) { Array(N) {false} }

        //탐색하기
        for(n in 0 until N) {
            for(m in 0 until N) {
                if (!VISIT[n][m] && VERTEX[n][m] == 1) {
                    VISIT[n][m] = true
                    totalDanzi += 1 //단지 하나 찾음

                    //재귀돌기
                    countDanziTemp = 0
                    dfs(n, m) //단지내 집 개수를 찾음
                    if (LOG) println("countDanziTemp=$countDanziTemp")
                    countDanzi.add(countDanziTemp)
                }
            }//for(x) -END
        }//for(y) -END

        //결과값 출력
        println(totalDanzi)
//        countDanzi.sort()
//        countDanzi.reverse()
//        countDanzi.sortWith(object : Comparator<Int> {
//            override fun compare(p0: Int?, p1: Int?): Int {
//                if (LOG) println("$p0, $p1")
////                return p0!! - p1!! //오름차순
//                return p1!! - p0!! //내림차순
//            }
//        })
        countDanzi.sortWith { i1: Int, i2: Int ->
            i2 - i1
        }
//        countDanzi.sortWith { p0, p1 ->
//            if (LOG) println("$p0, $p1")
//            //return p0!! - p1!! //오름차순
//            p1!! - p0!! //내림차순
//        }
        for (n in countDanzi) println(n)
    }

    fun dfs(y: Int, x: Int) {
        var ny = 0 //다음 y 좌표
        var nx = 0 //다음 x 좌표

        countDanziTemp += 1 //단지내 집 개수는 하나 증가

        for (n in 0..3) {
            ny = y + NEXT_Y[n]
            nx = x + NEXT_X[n]

            //범위 밖 확인
            if (ny !in 0 until N) {
                if (LOG) println("범위 밖 확인Y::$ny")
                continue
            }
            if (nx !in 0 until N) {
                if (LOG) println("범위 밖 확인X::$nx")
                continue
            }

            if (!VISIT[ny][nx] && VERTEX[ny][nx] == 1) {
                VISIT[ny][nx] = true
                dfs(ny, nx)
            }
        }//for -END
    }

//    3
//    7
//    8
//    9
}

/**
 * 너비탐색 알고리즘
 * https://www.acmicpc.net/problem/1926
 */
class KotlinTest00 {


    //1926
    fun main(array: Array<String>) {

        val temp1 = "6 5"
        val temp2: Array<String> = arrayOf("1 1 0 1 1", "0 1 1 0 0", "0 0 0 0 0", "1 0 1 1 1", "0 0 1 1 1", "0 0 1 1 1")

        val br = BufferedReader(InputStreamReader(System.`in`))
//        var brArr = br.readLine().split(" ")
        var brArr = temp1.split(" ")

        N = Integer.parseInt(brArr[0]) //세로
        M = Integer.parseInt(brArr[1]) //가로

        Nods = Array(N) { Array(M) {0} }
        for(n in 0 until N) {
//            brArr = br.readLine().split(" ")
            brArr = temp2[n].split(" ")
            for(m in 0 until M) {
                Nods[n][m] = Integer.parseInt(brArr[m])
            }
        }

        solution(6, 5, Nods)
    }

    var N = 0;
    var M = 0;
    var count = 0;
    var maxArea = Int.MIN_VALUE;
    var Nods: Array<Array<Int>> = emptyArray()
    var visit: Array<Array<Boolean>> = emptyArray() //arrayOf(arrayOf(false))
    fun solution(N: Int, M: Int, Nods: Array<Array<Int>>) {
        visit = Array(N) { Array(M) {false} }

        for(n in 0 until N) {
            for(m in 0 until M) {
                println("if (${visit[n][m]} && ${Nods[n][m]} == 1)")
                if (!visit[n][m] && Nods[n][m] == 1) {
                    visit[n][m] = true
                    count += 1
                    val area = bfs(n, m)
                    if (area > maxArea) {
                        maxArea = area
                    }
                }
            }
        }

        println(count)
        println(maxArea)
    }

    fun bfs(y: Int, x: Int): Int {
        var area = 0
        val queue = LinkedList<Point>() //ArrayDeque<Int>()
        queue.add(Point(x, y))

        var point: Point?
        var n = 0;
        var m = 0;
        while(queue.peek() != null) {
            area += 1
            point = queue.poll()!!
            n = point.y
            m = point.x

//            println("base:$n, $m ${visit[n][m]}")
            //상하좌우 탐색
            if (n > 0 && !visit[n-1][m] && Nods[n-1][m] == 1) { //상
                visit[n-1][m] = true
                queue.add(Point(m, n-1))
            }
            if (n < (N-1) && !visit[n+1][m] && Nods[n+1][m] == 1) {//하
                visit[n+1][m] = true
                queue.add(Point(m, n+1))
            }

            if (m > 0 && !visit[n][m-1] && Nods[n][m-1] == 1) {//좌
                visit[n][m-1] = true
                queue.add(Point(m-1, n))
            }

            if (m < (M-1) && !visit[n][m+1] && Nods[n][m+1] == 1) {//우
                visit[n][m+1] = true
                queue.add(Point(m+1, n))
            }
        }

        return area
    }

}