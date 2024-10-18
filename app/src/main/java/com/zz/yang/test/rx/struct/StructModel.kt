package com.zz.yang.test.rx.struct

class StructModel {

//    val MIN_OR_MAX = true //최소 힙이면 true, 최대 힙이면 false
    var MIN_OR_MAX = false //최소 힙이면 true, 최대 힙이면 false

//    val arrayInt = ArrayList<Int>() //arrayListOf<Int>()
//    val arrayInt = intArrayOf(0)
    var arrayInt: IntArray = IntArray(1) {0} //힙은 첫번째는 비워두고 두번째부터 값을 넣는다
    var size = 1


    fun addHeap(value: Int) {
        val tempArrayInt = IntArray(size + 1) {0}
        for (n in 1 until size) {
            tempArrayInt[n] = arrayInt[n]
        }
        tempArrayInt[tempArrayInt.lastIndex] = value //제일 끝에 넣음
        arrayInt = tempArrayInt
        size++

        if (size > 2) { //값이 한개 이상 초과가 되었을 경우에만 계산한다
            recAdd(arrayInt.lastIndex)
        }
    }

    fun delHeap(value: Int) {
        //에외처리
        if (size <= 1) {
            return
        }

        println(arrayInt.toList().toString())

        //root 노드에 최말단 노드를 집어 넣는다 (최말단 노드는 없어진다)
        val lastValue = arrayInt[arrayInt.lastIndex]
        arrayInt[1] = lastValue
        println(lastValue)
        println(arrayInt[1])

        val tempArrayInt = IntArray(size - 1) {0}
        for (n in 1 until tempArrayInt.size) { //index 1은 이미 위에서 넣었기 때문에
            tempArrayInt[n] = arrayInt[n]
        }
        arrayInt = tempArrayInt
        size--

        println(arrayInt.toList().toString())


        //재귀 함수를 돌면서 재정렬
        recDel(1)
    }


    fun getHeapToString(): String {
        return arrayInt.toList().toString()
    }

    fun getParent(index: Int): Int {
        return arrayInt[index / 2]
    }

    fun getChildLeft(index: Int): Int {
        return arrayInt[index * 2]
    }

    fun getChildRight(index: Int): Int {
        return arrayInt[index * 2 + 1]
    }

    //재귀로 돌면서 add 처리를 한다
    fun recAdd(index: Int) {
        if (index <= 1) { //끝까지 왔다면 종료
            println("가장 첫번째 인덱스까지 왔음")
            return
        }

        val child = arrayInt[index]
        val parent = getParent(index)

        val needSwitching = if (MIN_OR_MAX) { //최소 힙
            if (child < parent) { // 자식이 부모값보다 작으면 서로 바꾼다
                true
            } else {
                false
            }
        } else { //최대 힙
            if (child > parent) { // 자식이 부모값보다 작으면 서로 바꾼다
                true
            } else {
                false
            }
        }

        if (needSwitching) {
            arrayInt[index / 2] = child
            arrayInt[index] = parent
            val nextIndex = index / 2
            recAdd(nextIndex)
        } else {
            println("더 이상 정리할 필요가 없음")
        }
    }

    fun recDel(index: Int) {
        //예외처리: 마지막까지 탐색했다면 종료
        if (index >= arrayInt.lastIndex) {
            println("가장 마지막 인덱스까지 왔음")
            return
        }

        val parent = arrayInt[index] //자기 자신 (부모)

        //자식이 있는지 없는지 확인 하면서 정리
        val indexChildLeft = index * 2
        if (indexChildLeft <= arrayInt.lastIndex) { //자식 노드 중 왼쪽에 값이 있으면
            val childLeft = arrayInt[indexChildLeft]
            val needSwitching = if (MIN_OR_MAX) { //최소 힙
                if (childLeft < parent) { // 자식이 부모값보다 작으면 서로 바꾼다
                    true
                } else {
                    false
                }
            } else { //최대 힙
                if (childLeft > parent) { // 자식이 부모값보다 크면 서로 바꾼다
                    true
                } else {
                    false
                }
            }

            if (needSwitching) {
                arrayInt[index] = childLeft
                arrayInt[indexChildLeft] = parent
                recDel(indexChildLeft)
            } else {
                val indexChildRight = indexChildLeft + 1
                if (indexChildRight <= arrayInt.lastIndex) {
                    val childRight = arrayInt[indexChildRight]
                    val needSwitchingRight = if (MIN_OR_MAX) { //최소 힙
                        if (childRight < parent) { // 자식이 부모값보다 작으면 서로 바꾼다
                            true
                        } else {
                            false
                        }
                    } else { //최대 힙
                        if (childLeft > parent) { // 자식이 부모값보다 크면 서로 바꾼다
                            true
                        } else {
                            false
                        }
                    }
                    if (needSwitchingRight) {
                        arrayInt[index] = childRight
                        arrayInt[indexChildRight] = parent
                        recDel(indexChildRight)
                    }
                }
            }
        }
    }
}