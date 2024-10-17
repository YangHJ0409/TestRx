package com.zz.yang.test.rx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import java.lang.ref.WeakReference

class TFirstActivity : AppCompatActivity() {
    val TAG = TFirstActivity::class.java.simpleName;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tfirst)

        /*
        //문제 검증
        //Handler 에 딜레이(10초)를 걸고 명령을 하나 넣어 둔 뒤 바로 엑티비티를 종료해 보자
        handler.postDelayed({
            LogUtil.d(TAG, "handler::run!!!")
        }, 1000 * 10)
        finish()
        */

        /*
        //해별 방법 연구 1
        nonleakHandler.postDelayed({
            LogUtil.d(TAG, "nonleakHandler::run!!!")
        }, 1000 * 10)
        finish()
        */

        /*
        //해별 방법 연구 2
        looperHandler.postDelayed({
            LogUtil.d(TAG, "nonleakHandler::run!!!")
        }, 1000 * 10)
        finish()
         */


        //해별 방법 연구 3
        weakHandler.postDelayed({
            LogUtil.d(TAG, "weakHandler::run!!!")
        }, 1000 * 10)
        finish()
    }

    //메모리 누수를 테스트 해보기 위한 핸들러
    private val handler: Handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            LogUtil.d(TAG, "handlerMessage::${msg.what}")
        }
    }
    /*
    inner class로 선언 되었는데 이 handler 가 메인 스레드(TFirstActivity의 스레드)의 Looper나 MessageQueue를 사용할 경우 Outer 클래스가 GC의 대상이 되지 못하게 막는다.
    여기서 메모리 누수가 발생하게 된다. 엑티비티는 종료되었지만 해당 엑티비티의 남겨진 부산물이 아직 Looper나 MessageQueue에 남아 버리기 때문.
    */

    /*
    해결 방법 연구 1
    문제의 원인은 handler 가 inner class임에도 엑티비티와 함께 destroy 가 되지 않기 때문이다.
    즉 handler 를 inner class가 아니게 만드는 방법을 시도해보자
    * */
    private val nonleakHandler = NonLeakHandler()

    private class NonLeakHandler: Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            LogUtil.d("Outer", "NonLeakHandler::handlerMessage:${msg.what}")
        }
    }

    /*
    해별 방법 연구 2
    문제의 원인은 handler 를 사용하여 메인 쓰레드의 Looper 나 MessageQueue에 들어가서 CG의 대상이 되지 못하는 것이 원인이다.
    메인 쓰레드의 Looper와 함께 하도록 만들어 본다
    (위험도는 여전히 남는다)
     */
    var looperHandler: Handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {

        }
    }

    /*
    해결 방법 연구 3
    WeakReference (약한참조) 를 사용해서 GC의 대상이 되도록 유도 해본다.
    WeakReference 는 GC가 발생하면 참조하는 책체가 해제되기 때문에 WeakReference객체가 null이 아니지만 참조를 하고 있는 객체는 null이 나올 수 있는 위험성을 지닌다는 걸 주의 해야 한다.
    따라서 내부 처리르 할 때 activity의 객체가 있는지를 항상 확인 하고 사용하도록 하자.
    동작 설명
    WeakReference를 생성하게 되면 참조가 된 객체는 ReferenceQueue에 등록이 된다.
    ReferenceQueue : 참조 대기열. 객체의 참조 변화에 따라 변경이 된다. ReferenceQueue에 등록이 되면 GC에 의해 객체가 해제 될 수 있다.
    참조: https://developer.android.com/reference/java/lang/ref/Reference
     */
    var weakHandler = WeakHandler(this)
    class WeakHandler(activity: TFirstActivity) : Handler() {
        private val main: WeakReference<TFirstActivity> = WeakReference(activity)
        override fun handleMessage(msg: Message) {

            super.handleMessage(msg)
        }
    }

    /*
    해결 방법 연구 4
    onDestroy에서 모든 callback들을 삭제해본다.
    1, 2, 3 번 방법 외에 추가적으로 안정성을 높일 수 있다
     */
    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null);
    }
}
